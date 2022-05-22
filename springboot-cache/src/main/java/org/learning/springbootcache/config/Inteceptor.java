package org.learning.springbootcache.config;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.Select;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.List;

@Component
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class Inteceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        beforeIntercept(invocation);

        return invocation.proceed();
    }

    private void beforeIntercept(Invocation invocation) throws JSQLParserException {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();

        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        Statement statement = CCJSqlParserUtil.parse(sql);
        if (!(statement instanceof Insert)) {
            return;
        }

        Insert insert = (Insert) statement;
        String tableName = insert.getTable().getName();
        if (!StringUtils.equalsIgnoreCase(tableName, "department")) {
            return;
        }


        Select select = insert.getSelect();
        if (select != null) {
            return;
        }

        List<Column> columns = insert.getColumns();
        if (CollectionUtils.isEmpty(columns)) {
            return;
        }
        if (columns.stream().anyMatch(c -> StringUtils.equalsIgnoreCase(c.getColumnName(), "memo"))) {
            return;
        }


        insert.addColumns(new Column("memo"));
        ((ExpressionList) insert.getItemsList()).getExpressions().add(new StringValue("hhhhhhh"));

        setFieldValue(boundSql, "sql", insert.toString());
    }

    public static Field getTargetField(Class<?> targetClass, String fieldName) {
        Field field = null;
        try {
            if (targetClass == null) {
                return field;
            }

            if (Object.class.equals(targetClass)) {
                return field;
            }

            field = FieldUtils.getDeclaredField(targetClass, fieldName, true);
            if (field == null) {
                field = getTargetField(targetClass.getSuperclass(), fieldName);
            }
        } catch (Exception e) {
        }
        return field;
    }

    public static void setFieldValue(Object obj, String fieldName, Object value) {
        if (null == obj) {
            return;
        }
        Field targetField = getTargetField(obj.getClass(), fieldName);
        try {
            FieldUtils.writeField(targetField, obj, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

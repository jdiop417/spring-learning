package org.learning.beanRegister;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import java.util.Set;

public class SspaiRegister implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // scanner
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                if (!beanDefinition.getMetadata().isIndependent()) {
                    return false;
                }

                if (beanDefinition.getMetadata().isAnnotation()) {
                    return false;
                }

                if (!beanDefinition.getMetadata().isInterface()) {
                    return false;
                }
                return true;
            }
        };

        scanner.addIncludeFilter(new AnnotationTypeFilter(HttpController.class));
        Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents("org.learning.beanRegister");

        // register
        for (BeanDefinition candidateComponent : candidateComponents) {
            if (candidateComponent instanceof AnnotatedBeanDefinition) {
                AnnotatedBeanDefinition annotatedBeanDefinition = (AnnotatedBeanDefinition) candidateComponent;
                registerBeanDefinitions(annotatedBeanDefinition, registry);
            }
        }
    }

    private void registerBeanDefinitions(AnnotatedBeanDefinition annotatedBeanDefinition, BeanDefinitionRegistry registry) {
        // className
        AnnotationMetadata metadata = annotatedBeanDefinition.getMetadata();
        String className = metadata.getClassName();
        Class clazz = ClassUtils.resolveClassName(className, null);

        // beanDefinition
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(metadata.getAnnotationAttributes(HttpController.class.getName()));
        BeanDefinitionBuilder definition = BeanDefinitionBuilder.genericBeanDefinition(clazz, () -> {
            SspaiFactoryBean sspaiFactoryBean = new SspaiFactoryBean();
            sspaiFactoryBean.setUrl(attributes.getString("url"));
            sspaiFactoryBean.setType(clazz);
            return sspaiFactoryBean.getObject();
        });
        AbstractBeanDefinition beanDefinition = definition.getBeanDefinition();
        beanDefinition.setLazyInit(true);

        // register
        registry.registerBeanDefinition(className, beanDefinition);
    }
}

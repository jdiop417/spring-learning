package org.learning.foundation.killIfElse.after;

public class Test {
    public static void main(String[] args) {
        UserRelatedType relatedType = UserRelatedType.SHUOSHUO;
        UserRelated related = UserRelatedFactory.createRelated(relatedType);
        if (related != null) {
            related.list();
        } else {
            return;
        }
    }
}

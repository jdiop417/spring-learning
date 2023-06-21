package org.learning.beanRegister;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SspaiServiceTest {
    @Resource
    private SspaiService sspaiService;

    @Test
    public void pageQueryCommentByArticleId() {
        String s = sspaiService.pageQueryCommentByArticleId(null, null, null, null, null);
        System.out.println(s);
    }
}
package org.learning.beanRegister;


import java.util.Date;

@HttpController(url = "https://sspai.com", desc = "少数派")
public interface SspaiService {
    @HttpMethod(requestType = HttpMethod.RequestType.GET, path = "/api/v1/comment/user/article/hot/page/get")
    String pageQueryCommentByArticleId(Integer limit, Integer offset, Date createdAt, Integer articleId, Integer flagModel);
}

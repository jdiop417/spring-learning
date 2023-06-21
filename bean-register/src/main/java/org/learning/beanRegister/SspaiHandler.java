package org.learning.beanRegister;

import lombok.Data;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Data
public class SspaiHandler implements InvocationHandler {

    private String url;
    private String path;
    private Class<?> type;
    private HttpMethod.RequestType requestType = HttpMethod.RequestType.GET;

    public SspaiHandler() {
    }

    public SspaiHandler(String url, Class<?> type) {
        this.url = url;
        this.type = type;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HttpMethod annotation = method.getAnnotation(HttpMethod.class);
        requestType = annotation.requestType();
        path = annotation.path();

        String retVal = null;
        switch (requestType) {
            case GET:
                String uri = url + path + "?limit=20&offset=0&created_at=1687357496&article_id=78993&flag_model=1";
                retVal = new RestTemplate().getForObject(uri, String.class);

                break;
            case POST:
            default:
                break;
        }
        return retVal;
    }
}

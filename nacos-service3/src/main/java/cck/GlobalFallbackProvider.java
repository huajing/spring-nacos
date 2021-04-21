package cck;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * zuul的全局回退，可实现按服务的hystrix
 */
@Component
public class GlobalFallbackProvider implements FallbackProvider {

    @Override
    public String getRoute() {
        return "*"; //全部服务启动fallback
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        if(cause instanceof HystrixTimeoutException){
            return response(HttpStatus.GATEWAY_TIMEOUT, route, cause);
        }else {
            //后台错误
            return response(HttpStatus.INTERNAL_SERVER_ERROR, route, cause);
        }
    }

    private ClientHttpResponse response(final HttpStatus status, String route, Throwable cause){
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return status;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return status.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return status.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", 0);
                jsonObject.put("success", false);
                jsonObject.put("location", "gateway");
                jsonObject.put("route", route);
                String message = cause != null ? (cause.getMessage() == null ? cause.getCause().getMessage() : cause.getMessage()) : this.getStatusText();
                jsonObject.put("message", message);
                return new ByteArrayInputStream(jsonObject.toJSONString().getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mediaType = new MediaType("application", "json", StandardCharsets.UTF_8);
                headers.setContentType(mediaType);
                return headers;
            }
        };
    }
}

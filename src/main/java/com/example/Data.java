package com.example;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by jasonskipper on 2/27/17.
 *
 *
 * {
 "headers": {
     "cache-control": "no-cache",
     "postman-token": "1c9983b5-0d7f-4352-9a0f-2491e6eacc03",
     "content-type": "application/json",
     "user-agent": "PostmanRuntime/2.5.2",
     },
 "method": "POST",
 "url": "/animals",
 "body": "{\n  \"name\": \"My New Animals\"\n}"
 }
 *
 */
public class Data {
    private Map<String, String> headers;
    private String method;
    private String url;
    private String body;

    public Data(){

    }

    public Data(HttpServletRequest req) throws Exception{
        setMethod(req.getMethod());
        setUrl(req.getRequestURL().toString());
        setBody(req.getReader().lines().collect(Collectors.joining()));

        headers = new HashMap<String, String>();
        Enumeration<String> keys = req.getHeaderNames();
        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            headers.put(key, req.getHeader(key));
        }
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

package com.example.security.support;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-14 09:51
 **/
public class SimpleResponse {

    public SimpleResponse(Object content){
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

}


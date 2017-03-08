package com.padoon.exceptiondemo.data;

/**
 * Created by jiang on 2017/3/8.
 */

public class HttpResult<T> {
    private int responsecode;
    private String message;
    private T results;

    public int getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(int responsecode) {
        this.responsecode = responsecode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}

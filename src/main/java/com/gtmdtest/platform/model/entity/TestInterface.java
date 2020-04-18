package com.gtmdtest.platform.model.entity;

public class TestInterface {
    private Integer id;

    private String itfName;

    private String url;

    private String method;

    private String params;

    private String output;

    private String itfHeaders;

    private String itfCookies;

    private String itfAssert;

    private String itfTempvalue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItfName() {
        return itfName;
    }

    public void setItfName(String itfName) {
        this.itfName = itfName == null ? null : itfName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output == null ? null : output.trim();
    }

    public String getItfHeaders() {
        return itfHeaders;
    }

    public void setItfHeaders(String itfHeaders) {
        this.itfHeaders = itfHeaders == null ? null : itfHeaders.trim();
    }

    public String getItfCookies() {
        return itfCookies;
    }

    public void setItfCookies(String itfCookies) {
        this.itfCookies = itfCookies == null ? null : itfCookies.trim();
    }

    public String getItfAssert() {
        return itfAssert;
    }

    public void setItfAssert(String itfAssert) {
        this.itfAssert = itfAssert == null ? null : itfAssert.trim();
    }

    public String getItfTempvalue() {
        return itfTempvalue;
    }

    public void setItfTempvalue(String itfTempvalue) {
        this.itfTempvalue = itfTempvalue == null ? null : itfTempvalue.trim();
    }
}
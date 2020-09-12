package com.gtmdtest.platform.model.enums;


public enum RequestMethod {
    get("GET"),post("POST"),delete("DELETE"),put("PUT");

    String methodName;

    RequestMethod(String methodName){
        this.methodName = methodName;
    }

    public String getName(){
        return methodName;
    }
}

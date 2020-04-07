package com.gtmdtest.platform.model.enums;


public enum requestMethod {
    get("GET"),post("POST"),delete("DELETE");

    String methodName;

    requestMethod(String methodName){
        this.methodName = methodName;
    }

    public String getName(){
        return methodName;
    }
}

//package com.gtmdtest.platform.common;
//
//import java.util.Properties;
//
///**
// * @program: platform
// * @description:
// * @author:
// * @create: 2019-11-25 14:08
// **/
//public class diffTools {
//
////    public static int verificationBykey(Object value){
////        //获取第一个字符
////        if(value==null){
////            return 0;
////        }
////        String ac  = value==null?"null":value.toString();
////
////        char a = ac.charAt(0);
////
////        switch (a){
//////          开头[，表示嵌套了一个数组
////            case '[':
////                return 1;
//////          开头为{，表示嵌套的是一个JsonObject对象
////            case '{':
////                return 2;
//////          开头为"，表示普通值并没有嵌套过程
////            default:
////                return 3;
////
////        }
////    }
//
////    public static void main(String[] args) {
////        Properties p = System.getProperties();
////        p.list(System.out);
////        System.out.println("-------Memory Usage----------");
////        Runtime rt = Runtime.getRuntime();
////        System.out.println("Total Memory = "+ rt.totalMemory() +
////                "\nFree Memory = " + rt.freeMemory()+
////                "\nMax Memory = " + rt.maxMemory());
////    }
//}

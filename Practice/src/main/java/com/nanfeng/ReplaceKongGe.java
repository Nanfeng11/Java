package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/8/12
 */
//public class ReplaceKongGe {
//    public String replaceSpace(StringBuffer str) {
//        return str.toString().replace(" ","%20");
//    }
//}

public class ReplaceKongGe {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (c==' '){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

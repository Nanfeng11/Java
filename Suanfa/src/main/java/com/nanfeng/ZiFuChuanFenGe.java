package com.nanfeng;

import java.util.Set;

/**
 * Author：nanfeng
 * Created:2019/7/24
 */
public class ZiFuChuanFenGe {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s.length()<=0){
            return false;
        }
        if(dict.isEmpty()){
            return false;
        }
        boolean[] arr = new boolean[s.length()+1];
        //初始化F(0)为true
        arr[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(arr[j] && dict.contains(s.substring(j,i))){
                    arr[i] = true;
                    break;
                }
            }
        }
        return arr[s.length()];
    }

}

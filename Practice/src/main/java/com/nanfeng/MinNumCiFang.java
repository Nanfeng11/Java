package com.nanfeng;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Author：nanfeng
 * Created:2019/8/27
 */
public class MinNumCiFang {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            BigDecimal r = sc.nextBigDecimal();
            int n = sc.nextInt();
            BigDecimal res = r.pow(n);
            NumberFormat nf = NumberFormat.getInstance();
            nf.setGroupingUsed(false);
            nf.setMaximumFractionDigits(100);
            System.out.println(nf.format(res));
        }
    }
}

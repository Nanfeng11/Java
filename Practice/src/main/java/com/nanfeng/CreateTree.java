package com.nanfeng;

import java.util.Arrays;

/**
 * Author：nanfeng
 * Created:2019/8/14
 */
public class CreateTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
        }
    }

    private static int find(int[] arr, int v){
        for (int i=0; i<arr.length; i++){
            if (arr[i] == v)
                return i;
        }
        return -1;
    }

    public static TreeNode buildTree(int[] pre, int[] in){
        if (pre.length == 0){
            return null;
        }

        int rootVal = pre[0];
        TreeNode root = new TreeNode(rootVal);

        int leftSize = find(in,rootVal);

        int[] leftPre = Arrays.copyOfRange(pre,1,leftSize+1);
        int[] leftIn = Arrays.copyOfRange(in,0,leftSize);
        root.left = buildTree(leftPre,leftIn);

        int[] rightPre = Arrays.copyOfRange(pre,leftSize+1,pre.length);
        int[] rightIn = Arrays.copyOfRange(in,leftSize+1,in.length);
        root.right = buildTree(rightPre,rightIn);

        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,3,4,5,6,7};
        int[] in = new int[]{3,2,4,1,6,5,7};
        buildTree(pre,in);
        System.out.println("创建成功");
    }
}

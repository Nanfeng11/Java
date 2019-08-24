package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/8/24
 */
public class ReverseDList {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    private static TreeNode prev = null;
    private static TreeNode head = null;

    private static void buildDList(TreeNode node){
        node.left = prev;
        if (prev != null){
            prev.right = node;
        }else {
            head = node;
        }
        prev = node;
    }

    private static void inOrderSearchTree(TreeNode pRootOfTree){
        if (pRootOfTree != null){
            inOrderSearchTree(pRootOfTree.left);
            buildDList(pRootOfTree);
            inOrderSearchTree(pRootOfTree.right);
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree){
        prev = null;
        head = null;
        inOrderSearchTree(pRootOfTree);
        return head;
    }
}

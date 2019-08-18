package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/8/18
 */
public class FindSubtree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    private boolean isSame(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        return root1.val == root2.val
                && isSame(root1.left,root2.left)
                && isSame(root1.right,root2.right);
    }
    private boolean find(TreeNode root1,TreeNode root2){
        if(root1 == null || root2 ==null){
            return false;
        }
        if(isSame(root1,root2)){
            return true;
        }
        if(find(root1.left,root2)){
            return true;
        }
        return find(root1.right,root2);
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        return find(root1,root2);
    }


//    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
//        boolean result = false;//先初始化结果
//        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
//        if (root2 != null && root1 != null) {
//
//            if (root1.val == root2.val) {
//                //以这个根节点为为起点判断是否包含Tree2
//                result = doesTree1HaveTree2(root1, root2);
//            }
//            //如果找不到，那么就再去root的左子树当作起点，去判断是否包含Tree2
//            if (!result) {
//                result = HasSubtree(root1.left, root2);
//            }
//
//            //如果还找不到，那么就再去root的右子树当作起点，去判断是否包含Tree2
//            if (!result) {
//                result = HasSubtree(root1.right, root2);
//            }
//        }
//        //返回结果
//        return result;
//    }
//
//    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
//        //如果Tree2已经遍历完了都能对应的上，返回true
//        if (node2 == null) {
//            return true;
//        }
//        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
//        if (node1 == null) {
//            return false;
//        }
//        //如果其中有一个点没有对应上，返回false
//        if (node1.val != node2.val) {
//            return false;
//        }
//        //如果根节点对应的上，那么就分别去子节点里面匹配
//        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
//    }


}

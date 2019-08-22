package com.nanfeng;

import java.util.ArrayList;

/**
 * Author：nanfeng
 * Created:2019/8/22
 */
public class DFS {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<Integer> path = new ArrayList<>();
    ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null){
            return pathList;
        }

        path.add(root.val);

        if (root.left == null && root.right == null && root.val == target){
            pathList.add(new ArrayList<>(path));
        }

        if (root.val < target && root.left != null ){
            FindPath(root.left, target-root.val);
        }

        if (root.val < target && root.right != null){
            FindPath(root.right, target-root.val);
        }

        path.remove(path.size()-1);

        return pathList;
    }
}

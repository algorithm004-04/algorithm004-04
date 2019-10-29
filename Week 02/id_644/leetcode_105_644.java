package com.company;

import java.util.HashMap;

/**
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class buildTree {
    public static void main(String[] args) {

    }
    private int pre =0;
    private int in = 0;
    public TreeNode buildTree_recur(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inmap = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            inmap.put(inorder[i],i);
        }
        return buildTreehelper_recur( preorder,0,preorder.length,inorder,0,inorder.length,inmap);
    }

    //recur 双指针
    public TreeNode buildTreehelper_recur(int[] preorder, int p_start, int p_end,int[] inorder,int in_start,int in_end
            ,HashMap<Integer,Integer> inmap) {
        if(p_end == p_start) return null;
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int inorder_root = inmap.get(root_val);
        int left_scope = inorder_root - in_start;
        //left treele
        root.left = buildTreehelper_recur(preorder,p_start +1,p_start+1+ left_scope,inorder,in_start,left_scope,inmap);
        // rigth.tree
        root.right = buildTreehelper_recur(preorder,p_start+1+left_scope,p_end,inorder,inorder_root+1,in_end,inmap);
        return root;
    }



    // recur 直接用inorder 中的数值判断范围  ，这个算是巧的了 不好理解
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreehelper( preorder,inorder,(long)Integer.MAX_VALUE+1);
    }
    public TreeNode buildTreehelper(int[] pretree,int[] intree,long stop) {
        if (pre == pretree.length) return null;
        if (intree[in] == stop) {
            in++;
            return null; // 没有子节点！
        }
        int root_val = pretree[pre++];
        TreeNode root = new TreeNode(root_val);
        root.left = buildTreehelper(pretree,intree,root_val);
        root.right = buildTreehelper(pretree,intree,stop);
        return root;
    }
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}

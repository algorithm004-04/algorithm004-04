package main.week.week02;

import java.util.*;

/**
 * Created by ybh on 2019/10/28.
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 所有节点的值都是唯一的,所以记录下每个值的父亲值
 */
public class LeetCode_236_419 {

    Map<Integer,TreeNode> valNode = new HashMap<>(128);
    Map<Integer,TreeNode> nodeFatherValue = new HashMap<>(128);
    //定义两个终止条件，中序不用遍历完
    boolean finalValue01 = false;
    boolean finalValue02 = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        cycleTree(root,p.val,q.val);
        //将对应的值放到list中
        int value01 = p.val;
        int value02 = q.val;
        List<Integer> list01 = new ArrayList<>(nodeFatherValue.size());
        List<Integer> list02 = new ArrayList<>(nodeFatherValue.size());
        list01.add(value01);
        while (nodeFatherValue.containsKey(value01)){
            list01.add(nodeFatherValue.get(value01).val);
            value01 = nodeFatherValue.get(value01).val;
        }
        list02.add(value02);
        while (nodeFatherValue.containsKey(value02)){
            list02.add(nodeFatherValue.get(value02).val);
            value02 = nodeFatherValue.get(value02).val;
        }

        int l1 = list01.size()-1;
        int l2 = list02.size()-1;

        for(;l1>-1&&l2>-1;l1--,l2--){
            if(!list01.get(l1).equals(list02.get(l2))){
                return valNode.get(list01.get(l1+1));
            }
        }
        if(l1==0&&l2>0){
            return valNode.get(list01.get(0));
        }else {
            return valNode.get(list02.get(0));
        }


    }

    //中序
    private void cycleTree(TreeNode root,int value01,int value02) {
        if(finalValue01 && finalValue02){
            return;
        }
        valNode.put(root.val,root);
        if(root.val==value01){
            finalValue01 = true;
        }
        if(root.val==value02){
            finalValue02 = true;
        }
        if(finalValue01 && finalValue02){
            return;
        }
        if(root.left != null){
            nodeFatherValue.put(root.left.val,root);
            cycleTree(root.left,value01,value02);
        }
        if(root.right != null){
            nodeFatherValue.put(root.right.val,root);
            cycleTree(root.right,value01,value02);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

package week_03.lesson9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindLargestInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {

        //声明接收每行最大值的集合
        List<Integer> result = new LinkedList<>();
        if (null == root) {
            return result;
        }

        //声明保存每层结点的队列
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        //第一次要把根节点加进去
        nodeList.add(root);
        //定义每层节点的个数
        int cur = nodeList.size();
        //定义每层最大的数，默认为int类型最小的数
        int maxValue = Integer.MIN_VALUE;

        while (nodeList.size() > 0) {
            for (;cur > 0; cur--) {
                //把当前层的元素弹出来，然后对比一下最大的元素
                TreeNode tmp = nodeList.pollFirst();
                maxValue = maxValue > tmp.val ? maxValue : tmp.val;
                //如果有左右子节点，添加到结点队列中去
                if (null != tmp.left) {
                    nodeList.add(tmp.left);
                }
                if (null != tmp.right) {
                    nodeList.add(tmp.right);
                }
            }
            //把最大值加到结果集合中
            result.add(maxValue);
            maxValue = Integer.MIN_VALUE;
            cur = nodeList.size();
        }
        return result;

    }

    public static void main(String[] args) {

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

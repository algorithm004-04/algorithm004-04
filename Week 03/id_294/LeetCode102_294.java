package week03;
// 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
// 给定二叉树: [3,9,20,null,null,15,7],
//输出
// [
//  [3],
//  [9,20],
//  [15,7]
// ]

import common.TreeNode;
import common.Utils;

import java.util.ArrayList;
import java.util.List;


public class LeetCode102_294 {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    int totalCount = 0;
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
//        bfs(root, 0);
        System.out.println(result);
        return null;
    }

    public void dfs(TreeNode root, int level) {
        if (root == null) return;
        List<Integer> levelData = null;
        if (level >= result.size()) {
            levelData = new ArrayList<Integer>();
            result.add(levelData);
        } else {
            levelData = result.get(level);
        }
        levelData.add(root.val);
        dfs(root.left, level +1 );
        dfs(root.right, level +1 );
    }

    public void bfs(Integer[] arr, int level) {
        if (totalCount >= arr.length) return ;
        double levelCount = Math.pow(2, level);
        List<Integer> levelData = new ArrayList<>();
        double endIndex = Math.min(totalCount + levelCount, arr.length);
        for (int i = totalCount; i < endIndex; i++) {
            if (arr[i] != null) {
                levelData.add(arr[i]);
            }
        }
        totalCount += levelCount;
        result.add(levelData);
        bfs(arr, level + 1);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = Utils.makeTree(arr);
//        new LeetCode102_294().levelOrder(root);
        LeetCode102_294 inst = new LeetCode102_294();
        inst.bfs(arr, 0);
        System.out.println(inst.result);
    }
}

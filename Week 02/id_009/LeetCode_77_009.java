import java.util.ArrayList;
import java.util.List;
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法
// https://leetcode-cn.com/problems/combinations/

public class LeetCode_77_009 {
    public static void main(String[] args) {
        LeetCode_77_009 test = new LeetCode_77_009();
        int n = 4;
        int k = 2;
        System.out.println(test.combine2(n, k));
    }

    /**
     * 方法一：递归法(优化的全遍历)
     * 同Subsets_78一样，每个数字分选、不选两种情况，递归遍历，当发生以下情况时，递归跳出：
     * <p>
     * 1）遍历数字达到最大数；
     * 2）subset的大小等于k时，无需再添加元素，递归跳出；
     * 3）遍历剩余的数n - item 小于 还需要插入的个数k - subset.size()，再往后遍历也不够长度k，递归跳出。
     * <p>
     * 加了终结条件2和3后，避免了无效的遍历，效率大大提升。
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 0, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int n, int k, int item, List<Integer> subset, List<List<Integer>> res) {
        if (item == n || subset.size() == k || k - subset.size() > n - item) {
            if (subset.size() == k) {
                res.add(new ArrayList<>(subset));
            }
            return;
        }


        dfs(n, k, item + 1, subset, res);

        subset.add(item + 1);
        dfs(n, k, item + 1, subset, res);


        subset.remove(subset.size() - 1);
    }


    /**
     * 方法二：迭代法优化
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());

        for (int i = 1; i < n + 1; i++) {
            int currentSize = lists.size();
            for (int j = 0; j < currentSize; j++) {
                List<Integer> temp = new ArrayList<>(lists.get(j));
                if (k - temp.size() <= n - i + 1) {    //遍历剩余的n-i+1个数 小于 还需要插入的个数k - temp.size()，再往后遍历也不够长度k，一次子集temp不插入。
                    temp.add(i);
                    if (temp.size() == k) {
                        res.add(temp);  //subset的大小已经等于k,无需再次添加进lists
                    } else {
                        lists.add(temp);
                    }
                }
            }
        }
        return res;
    }
}

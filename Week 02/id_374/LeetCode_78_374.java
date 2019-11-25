package algorithm.homework.week02;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_78_374 {
    public static void main(String[] args) {
        LeetCode_78_374 l78 = new LeetCode_78_374();
        int[] nums = {1, 2, 3};
        System.out.println(l78.subsets(nums));
    }

    /**
     * 递归
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        dfs(0, nums, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void dfs(int i, int[] nums, ArrayList<Integer> tmpList, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<Integer>(tmpList));
            return;
        }
        dfs(i + 1, nums, tmpList, ans);
        tmpList.add(nums[i]);
        dfs(i + 1, nums, tmpList, ans);
        tmpList.remove(tmpList.size() - 1);
    }

    /**
     * 迭代
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> list = new ArrayList<Integer>();
            int size = ans.size();
            for (int j = 0; j < size; ++j) {
                List<Integer> list2 = new ArrayList<Integer>(ans.get(j));
                list2.add(nums[i]);
                ans.add(list2);
            }
            list.add(nums[i]);
            ans.add(list);
        }
        ans.add(new ArrayList<Integer>());
        return ans;
    }
}

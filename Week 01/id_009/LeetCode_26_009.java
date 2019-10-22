package lesson3;

/**
 * 【数组去重】
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 */
public class LeetCode_26_009 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        LeetCode_26_009 test = new LeetCode_26_009();
        int size = test.removeDuplicates2(nums);
        System.out.println(size);
    }

    /**
     * 方法一：辅助结构
     * 遍历一遍，辅助结构记录不重复的值，并且赋值到原数组中，返回辅助结构的size。
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        List<Integer> noRepeat = new ArrayList<>();
        for (int item : nums) {
            if (!noRepeat.contains(item)) {
                noRepeat.add(item);
            }
        }
        Iterator<Integer> iterator = noRepeat.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            nums[i] = next;
            i++;
        }
        return noRepeat.size();
    }

    /**
     * 方法二：双指针
     * 指针j记录不重复的数，如果指针i对应的值和指针j对应的值不相等，则复制给++j。
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }


}


<?php
/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。

 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:

 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
class Solution
{

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    public function majorityElement($nums)
    {
        $store = [];
        $len = count($nums);
        foreach ($nums as $v) {
            if (isset($store[$v])) {
                $store[$v]++;
            } else {
                $store[$v] = 1;
            }
            if ($store[$v] > $len/2) {
                return $v;
            }
        }
        return 0;
    }
}

// $data= [-1,100,2,100,100,4,100];
// print_r((new Solution())->majorityElement($data));

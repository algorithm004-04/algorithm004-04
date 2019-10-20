<?php class Solution
{
    /**
     * 三次翻转
     *
     * @param [type] $nums
     * @param [type] $k
     * @return void
     */
    function rotate(&$nums, $k)
    {
        $k = $k % count($nums);
        $this->reverse($nums, 0, count($nums) - 1);
        $this->reverse($nums, 0, $k - 1);
        $this->reverse($nums, $k, count($nums) - 1);
    }

    function reverse(&$nums, $start, $end)
    {
        while ($start < $end) {
            $tmp = $nums[$start];
            $nums[$start] = $nums[$end];
            $nums[$end] = $tmp;
            $start++;
            $end--;
        }
    }
}

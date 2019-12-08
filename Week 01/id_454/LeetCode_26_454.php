<?php

/**
 * 题目描述
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */

/**
 * Example 1 
 * Input [1,1,2]
 * Output [1,2]
 * 
 * 
 * Example 2
 * Input [0,0,1,1,1,2,2,3,3,4]
 * Output [0,1,2,3,4]
 * 
 * 
 * Example 3 -处理数组未排序
 * 
 * Input [1,1,2,3,4,3,5,6,5]
 * Output [1,2,3,4,5,6]
 * 
 */

/**
 * 解题思路
 * 1、给定了已经排序好的数组，，只需循环处理当前元素是否与前置元素相同，相同则删除即可
 * 2、如果给一个为排序的数组如何解决
 *      第一先排序，再去重复
 *      第二不排序直接去重：example3RemoveDuplicates
 */

class Solution
{

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function removeDuplicates(&$nums)
    {
        $nums_size = count($nums);
        if ($nums_size <= 0) {
            return false;
        }
        $number = $nums[0];
        for ($i = 1; $i < $nums_size; $i++) {
            if ($number == $nums[$i]) {
                unset($nums[$i]);
            } else {
                $number = $nums[$i];
            }
        }
    }

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function example3RemoveDuplicates(&$nums)
    {
        $nums_size = count($nums);
        for ($i = 0; $i < $nums_size; $i++) {
            $key = $nums_size + $nums[$i];
            if (!array_key_exists($key, $nums)) {
                $nums[$key] = $nums[$i];
            }
            unset($nums[$i]);
        }
    }
}

<?php
class Solution
{

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    public function search($nums, $target)
    {
        $len = count($nums);
        $start = 0;
        $end = $len-1;
        
        while ($start <=$end) {
            $mid = intval($start + ($end-$start)/2);
            if ($nums[$mid] == $target) {
                return $mid;
            }
            if ($nums[$mid] < $nums[$end]) {
                if ($target >= $nums[$mid] && $target <= $nums[$end]) {
                    $start = $mid+1;
                } else {
                    $end = $mid-1;
                }
            } else {
                if ($target <= $nums[$mid] && $target >= $nums[$start]) {
                    $end = $mid - 1;
                } else {
                    $start = $mid + 1;
                }
            }
        }
        return -1;
    }
}

$s = new Solution();
$nums = [4,5,6,7,0,1,2];
$target = 0;
$nums = [1,3];
$target = 3;
echo $s->search($nums, $target);

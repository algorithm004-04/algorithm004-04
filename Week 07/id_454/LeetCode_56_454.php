<?php
class Solution
{
    function merge($intervals)
    {
        asort($intervals);
        $range = array();
        foreach ($intervals as $interval) {
            if (empty($range)) {
                array_push($range, $interval);
                continue;
            }
            $inRange = false;
            foreach ($range as $index => $value) {
                if ($value[0] <= $interval[0] && $value[1] >= $interval[1]) {
                    $inRange = true;
                    continue;
                }
                if ($value[0] <= $interval[0] && $value[1] < $interval[1] && $interval[0] <= $value[1]) {
                    $range[$index][1] = $interval[1];
                    $inRange = true;
                }
                if ($value[0] > $interval[0] && $value[1] >= $interval[1] && $value[1] >= $interval[0]) {
                    $range[$index][0] = $interval[0];
                    $inRange = true;
                }
            }
            if (!$inRange) {
                array_push($range, $interval);
            }
        }
        return $range;
    }
}

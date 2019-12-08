### 排序算法
- 冒泡排序
```php
function bubbleSort($arr)
{
    $len = count($arr);
    for ($i = 1; $i < $len; $i++) {
        for ($k = 0; $k < $len - $i; $k++) {
            if ($arr[$k] > $arr[$k + 1]) {
                $tmp = $arr[$k + 1];
                $arr[$k + 1] = $arr[$k];
                $arr[$k] = $tmp;
            }
        }
    }
    return $arr;
}
```
- 选择排序
```php
function selectSort($arr)
{
    $len = count($arr);
    for ($i = 0; $i < $len - 1; $i++) {
        $p = $i;
        for ($j = $i + 1; $j < $len; $j++) {
            if ($arr[$p] > $arr[$j]) {
                $p = $j;
            }
        }
        if ($p != $i) {
            $tmp = $arr[$p];
            $arr[$p] = $arr[$i];
            $arr[$i] = $tmp;
        }
    }
    return $arr;
}
```
- 插入排序
```php
function insertSort($arr)
{
    $len = count($arr);
    for ($i = 1; $i < $len; $i++) {
        $tmp = $arr[$i];
        for ($j = $i - 1; $j >= 0; $j--) {
            if ($tmp < $arr[$j]) {
                $arr[$j + 1] = $arr[$j];
                $arr[$j] = $tmp;
            } else {
                break;
            }
        }
    }
    return $arr;
}
```
- 快速排序
```php
function quickSort($arr)
{
    $length = count($arr);
    if ($length <= 1) {
        return $arr;
    }
    $base_num = $arr[0];
    $left_array = array();
    $right_array = array();
    for ($i = 1; $i < $length; $i++) {
        if ($base_num > $arr[$i]) {
            $left_array[] = $arr[$i];
        } else {
            $right_array[] = $arr[$i];
        }
    }
    $left_array = quickSort($left_array);
    $right_array = quickSort($right_array);
    return array_merge($left_array, array($base_num), $right_array);
}
```
- 归并排序
```php
function merge_sort(array $lists)
{
    $n = count($lists);
    if ($n <= 1) {
        return $lists;
    }
    $left = merge_sort(array_slice($lists, 0, floor($n / 2)));
    $right = merge_sort(array_slice($lists, floor($n / 2)));
    $lists = merge($left, $right);
    return $lists;
}

function merge(array $left, array $right)
{
    $lists = [];
    $i = $j = 0;
    while ($i < count($left) && $j < count($right)) {
        if ($left[$i] < $right[$j]) {
            $lists[] = $left[$i];
            $i++;
        } else {
            $lists[] = $right[$j];
            $j++;
        }
    }
    $lists = array_merge($lists, array_slice($left, $i));
    $lists = array_merge($lists, array_slice($right, $j));
    return $lists;
}
```
- 堆排序
```php
function heap_sort(array $lists)
{
    $n = count($lists);
    build_heap($lists);
    while (--$n) {
        $val = $lists[0];
        $lists[0] = $lists[$n];
        $lists[$n] = $val;
        heap_adjust($lists, 0, $n);
        //echo "sort: " . $n . "\t" . implode(', ', $lists) . PHP_EOL;
    }
    return $lists;
}

function build_heap(array &$lists)
{
    $n = count($lists) - 1;
    for ($i = floor(($n - 1) / 2); $i >= 0; $i--) {
        heap_adjust($lists, $i, $n + 1);
        //echo "build: " . $i . "\t" . implode(', ', $lists) . PHP_EOL;
    }
    //echo "build ok: " . implode(', ', $lists) . PHP_EOL;
}

function heap_adjust(array &$lists, $i, $num)
{
    if ($i > $num / 2) {
        return;
    }
    $key = $i;
    $leftChild = $i * 2 + 1;
    $rightChild = $i * 2 + 2;

    if ($leftChild < $num && $lists[$leftChild] > $lists[$key]) {
        $key = $leftChild;
    }
    if ($rightChild < $num && $lists[$rightChild] > $lists[$key]) {
        $key = $rightChild;
    }
    if ($key != $i) {
        $val = $lists[$i];
        $lists[$i] = $lists[$key];
        $lists[$key] = $val;
        heap_adjust($lists, $key, $num);
    }
}
```
- 希尔排序
```php
function shell_sort(array $lists)
{
    $n = count($lists);
    $step = 2;
    $gap = intval($n / $step);
    while ($gap > 0) {
        for ($gi = 0; $gi < $gap; $gi++) {
            for ($i = $gi; $i < $n; $i += $gap) {
                $key = $lists[$i];
                for ($j = $i - $gap; $j >= 0 && $lists[$j] > $key; $j -= $gap) {
                    $lists[$j + $gap] = $lists[$j];
                    $lists[$j] = $key;
                }
            }
        }
        $gap = intval($gap / $step);
    }
    return $lists;
}
```
- 基数排序
```php
function radix_sort(array $lists)
{
    $radix = 10;
    $max = max($lists);
    $k = ceil(log($max, $radix));
    if ($max == pow($radix, $k)) {
        $k++;
    }
    for ($i = 1; $i <= $k; $i++) {
        $newLists = array_fill(0, $radix, []);
        for ($j = 0; $j < count($lists); $j++) {
            $key = $lists[$j] / pow($radix, $i - 1) % $radix;
            $newLists[$key][] = $lists[$j];
        }
        $lists = [];
        for ($j = 0; $j < $radix; $j++) {
            $lists = array_merge($lists, $newLists[$j]);
        }
    }
    return $lists;
}
```
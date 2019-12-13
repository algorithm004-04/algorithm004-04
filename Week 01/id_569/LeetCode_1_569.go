package main
import (
    "fmt"
)

func main (){

    nums := []int{2,7,11,5}
    target := 9
    r := twoSum(nums,target)
    fmt.Println(r)
}
//1暴力法
func twoSum(nums []int, target int) []int {
    res := []int{}
    len := len(nums)
    for i:=0;i<len-1;i++{
        for j:=i+1;j<len;j++{
        	if target == nums[i] + nums[j] {
        	    res = append(res,i,j)
            }
        }
    }
    return  res
}



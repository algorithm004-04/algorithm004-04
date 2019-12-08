package simple;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表
// 第一周

public class LC1 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ret = twoSum_my(nums,22);
        print(ret);

        ret = twoSum_violence(nums,22);
        print(ret);
    }

    private static void print(int[] ret) {
        System.out.println("------------------------");
        if(ret.length==0){
            System.out.println("Nothing to print.");
        }
        for(int i=0;i<ret.length;i++){
            System.out.println(ret[i]);
        }
    }

    /**
     * 使用哈希来存储目标值和下标，循环一遍，判断如果target-i如果在map中，直接返回。
     * map的作用是缓存了之前遍历的值与下标，当遍历到后面的值时，直接和map中的值进行对比。
     * 另外一个关键点是：a+b=target转换为a=target-b
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_my(int[] nums, int target) {
        java.util.Map<Integer,Integer> map = new java.util.HashMap<>();
        for(int i=0;i<nums.length;i++){
            int val = target - nums[i];
            if(map.get(val) != null){
                return new int[]{map.get(val),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }


    /**
     * 暴力解题
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_violence(int[] nums,int target){
        int[] ret = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j]) == target){
                    ret[0] = i;
                    ret[1] = j;
                    break;
                }
            }
        }
        return ret;
    }
}




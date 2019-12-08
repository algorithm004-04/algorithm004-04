package week_02.lesson8;

public class MajorityElement {


    public static int majorityElement(int[] nums) {

        //暴力法
        /*int majorityLength = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int sum : nums) {
                if (sum == num) {
                    count++;
                }
            }
            if (count > majorityLength) {
                return num;
            }
        }
        */

        //hash法
        /*int majorityLength = nums.length / 2;
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int num :
                nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num,countMap.get(num) + 1);
            } else {
                countMap.put(num,1);
            }
        }

        for(Iterator<Map.Entry<Integer,Integer>> iterator = countMap.entrySet().iterator();
                iterator.hasNext();) {
            Map.Entry<Integer,Integer> entry = iterator.next();
            if (entry.getValue() > majorityLength) {
                return entry.getKey();
            }
        }

        return -1;*/


        //分治法
        return majority(nums,0,nums.length - 1);


    }

    private static int majority(int[] nums, int l, int h) {
        //当数组拆分到只有一个元素的时候，返回这个元素
        if (l == h) {
            return nums[l];
        }
        int mid = (h - l) / 2 + l;
        int left = majority(nums, l, mid);
        int right = majority(nums, mid + 1, h);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, l, h);
        int rightCount = countInRange(nums, right, l, h);
        return leftCount > rightCount ? left : right;

    }

    private static int countInRange(int[] nums, int num, int l, int h) {

        int count = 0;
        for (int i = l; i <= h; i++) {
            if (num == nums[i]) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

}

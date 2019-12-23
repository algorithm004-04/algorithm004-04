public class RemoveDuplicatesSolution {
    public int removeDuplicates(int[] nums) {

        int index = 1;
        //原地修改数组
        for (int i = 0; i < nums.length - 1; i++) {
            //如果前后两个数组元素不同，
            if (nums[i] != nums[i + 1]) {
                nums[index++] = nums[i + 1];
            }
        }

        return index;

    }
}
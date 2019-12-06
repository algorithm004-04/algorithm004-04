
public class LeetCode_33_029 {
	 public int search(int[] nums, int target) {
	        int left = 0;
	        int right = nums.length-1;
	        int mid = left + (right-left)/2;
	        
	        while(left <= right){
	            if(nums[mid] == target){
	                return mid;
	            }

	             //×ó±ßÉıĞò
	            if(nums[left] <= nums[mid]){ 
	                //ÔÚ×ó±ß·¶Î§ÄÚ
	                if(target >= nums[left] && target <= nums[mid]){
	                    right = mid-1;
	                }
	                //Ö»ÄÜ´ÓÓÒ±ßÕÒ
	                else{
	                    left = mid+1;
	                }
	            //ÓÒ±ßÉıĞò
	            }else{ 
	                //ÔÚÓÒ±ß·¶Î§ÄÚ
	                if(target >= nums[mid] && target <= nums[right]){
	                    left = mid +1;
	                }
	                //Ö»ÄÜ´Ó×ó±ßÕÒ
	                else{
	                    right = mid-1;
	                }

	            }
	            mid = left + (right-left)/2;
	        }
	        
	        return -1;  //Ã»ÕÒµ½
	    }
}


public class LeetCode_33_029 {
	 public int search(int[] nums, int target) {
	        int left = 0;
	        int right = nums.length-1;
	        int mid = left + (right-left)/2;
	        
	        while(left <= right){
	            if(nums[mid] == target){
	                return mid;
	            }

	             //�������
	            if(nums[left] <= nums[mid]){ 
	                //����߷�Χ��
	                if(target >= nums[left] && target <= nums[mid]){
	                    right = mid-1;
	                }
	                //ֻ�ܴ��ұ���
	                else{
	                    left = mid+1;
	                }
	            //�ұ�����
	            }else{ 
	                //���ұ߷�Χ��
	                if(target >= nums[mid] && target <= nums[right]){
	                    left = mid +1;
	                }
	                //ֻ�ܴ������
	                else{
	                    right = mid-1;
	                }

	            }
	            mid = left + (right-left)/2;
	        }
	        
	        return -1;  //û�ҵ�
	    }
}

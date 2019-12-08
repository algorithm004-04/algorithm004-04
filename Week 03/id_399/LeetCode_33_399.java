class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        if(nums.length==1)
            return nums[0]==target?0:-1;
        if(nums.length==2){
            if(nums[0]==target)
                return 0;
            else if(nums[1]==target)
                return 1;
            else return -1;
        }
        int first=nums[0];
        int l=0,r=nums.length-1;
        if(first<nums[nums.length-1]){
             while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]>target)
                r=mid-1;
            else if(nums[mid]<target)
                 l=mid+1;
            else{
                return mid;
            }
        }
            return -1;
        }
        //如果不是完全有序，则先找到最小的值index=l
        else{
             while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]>first)
                l=mid+1;
            else if(nums[mid]<first)
                r=mid;
            else{
                l++;
                break;
            }
        }
        int l1,r1;
        if(target<nums[l]||target>nums[l-1])
            return -1;
        else if(target<=nums[nums.length-1]){
            l1=l;r1=nums.length-1;
        }
        else{
            l1=0;r1=l-1;
        }
        while(l1<=r1){
            int mid=(l1+r1)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                r1=mid-1;
            else l1=mid+1;
        }
        return -1;
        }
       
    }

}
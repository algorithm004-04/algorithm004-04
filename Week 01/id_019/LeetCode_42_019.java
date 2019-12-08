class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0){
            return 0;
        }
        int left=0,right=height.length-1;
        int leftMax=height[left],rightMax=height[right];
        int res=0;
        while(left<=right){
            if(leftMax<rightMax){
                if(height[left]<leftMax){
                    res+=leftMax-height[left];
                }
                leftMax=Math.max(leftMax,height[left++]);
            }else{
                if(height[right]<rightMax){
                    res+=rightMax-height[right];
                }
                rightMax=Math.max(rightMax,height[right--]);
            }
        }
        return res;
    }
}
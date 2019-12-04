private static void rotate(int[] nums,int k) {
        int[] bak = new int[nums.length];

        int i=0;
        while(i<k){
            bak[i] = nums[nums.length-k+i];
            i++;
        }

        i=0;
        for(int j=nums.length-1;j>=0;j--){
            if(j<k){
                nums[j] = bak[j];
            }else{
                nums[j] = nums[nums.length-k-i-1];
                i++;
            }
        }


    }
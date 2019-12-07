class Solution {
    List<List<String>> result = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        int[] res = new int[n];// 索引代表行，值代表列，表示第几行几列是Q
        boolean[] flag = new boolean[n];//表示第i列是否被用过，false表示未被用过
        backtrace(res,flag,0,n);
        return result;
        
    }
    //回溯法的框架
    public void backtrace(int[] res,boolean[] flag,int index,int n){
        if(index == n){//找到一个解
            List<String> list = new ArrayList<>();
            for(int x :res){
                StringBuilder  str = new StringBuilder();
                for(int i =0;i<n;i++){
                    if(x==i)
                        str.append("Q");
                    else 
                        str.append(".");
                }
                list.add(str.toString());
            }
            result.add(list);
        }
        else
        for(int i = 0; i<n; i++){
            
            if(!flag[i]){//该列没有被填过
                if(index==0){
                     res[index] = i;
                     flag[i] =true;
                     backtrace(res, flag,index+1,n);
                     flag[i] =false; 
                }else{
                    int t = 1;
                    while(index-t>=0){
                        if(res[index-t]==i+t||res[index-t]==i-t)break;
                        t++;
                    }
                    if(t>index){//保证不在对角线上
                     res[index] = i;
                     flag[i] =true;
                     backtrace(res, flag,index+1,n);
                     flag[i] =false;   
                    }
                }
                    
            }
           
        }
    }
    
}

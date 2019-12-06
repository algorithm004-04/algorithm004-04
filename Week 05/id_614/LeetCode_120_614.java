class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minlen = new int[row+1];
        for (int level = row-1;level>=0;level--){
            for (int i = 0;i<=level;i++){
                minlen[i] = Math.min(minlen[i], minlen[i+1]) + triangle.get(level).get(i);
            }
        }
        return minlen[0];
    }
}
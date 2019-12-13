/**
 * 贪心算法，先满足胃口最大的孩子，再满足胃口最小的孩子
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {


        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        for(int index_cookie = s.length-1, index_child = g.length-1;index_cookie >= 0 && index_child >= 0;){
            if(s[index_cookie] >= g[index_child]){
                ++count;
                --index_cookie;
            }
            --index_child;
        }
        return count;

    }
}
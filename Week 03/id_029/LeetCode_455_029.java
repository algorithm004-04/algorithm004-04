import java.util.Arrays;

public class LeetCode_455_029 {
	 public int findContentChildren(int[] g, int[] s) {
	        Arrays.sort(g);
	        Arrays.sort(s);
	        int i=0,j=0;
	        int l1=g.length,l2=s.length;
	        while(i<l1&&j<l2){
	            if(g[i]<=s[j]){
	                i++;
	            }
	            j++;
	        }
	        return i;
	    }
}

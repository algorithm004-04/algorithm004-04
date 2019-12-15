package alg;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyang on 2019-10-27.
 */
class Solution {

  public static List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> combs = new ArrayList<>();
    combine(combs, new ArrayList<>(), 1, n, k);
    return combs;
  }
  public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
    if(k==0) {
      combs.add(new ArrayList<>(comb));
      return;
    }
    for(int i=start;i<=n;i++) {
      comb.add(i);
      combine(combs, comb, i+1, n, k-1);
      comb.remove(comb.size()-1);
    }
  }

}


import java.util.ArrayList;
import java.util.List;

public class LeetCode_77_034 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }

    private void combine(List<List<Integer>> res, ArrayList<Integer> temp, int start, int n, int k) {
         if (k == 0) {
             res.add(new ArrayList<>(temp));
             return;
         }

         for (int i = start; i < n - k + 1; i ++) {
             temp.add(i);
             combine(res, temp, i + 1, n, k - 1);
             temp.remove(temp.size() - 1);
         }

    }
}

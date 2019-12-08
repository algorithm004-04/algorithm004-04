import java.util.ArrayList;
import java.util.List;

public class LeetCode_22_029 {
	 public List<String> generateParenthesis(int n) {
         List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis(c))
                    for (String right: generateParenthesis(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
}

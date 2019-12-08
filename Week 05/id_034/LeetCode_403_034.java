import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode_403_034
 *
 * @Author blackberry
 * @Date 2019/11/17 8:47 PM
 **/
public class LeetCode_403_034 {

    public boolean canCross(int[] stones) {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < stones.length; i ++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(0);

        for (int i = 0; i < stones.length; i ++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1;  step ++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LeetCode_1244_034
 *
 * @Author blackberry
 * @Date 2019/12/1 12:23 PM
 **/
class Leaderboard {
    private Map<Integer, Integer> map;

    public Leaderboard() {
        map = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId, 0) + score);
    }

    public int top(int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(map.size(), (n1, n2) -> n2 - n1 > 0 ? 1 : n2 == n1 ? 0 : -1);
        heap.addAll(map.values());
        int ans = 0;
        for (int i = 0; i < K; i ++) {
            ans += heap.poll();
        }
        return ans;
    }

    public void reset(int playerId) {
        map.remove(playerId);
    }
}

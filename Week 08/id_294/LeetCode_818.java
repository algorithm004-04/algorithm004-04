package week08;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Node {
	int speed;
	int pos;
	int level;

	public Node(int speed, int pos, int level) {
		this.speed = speed;
		this.pos = pos;
		this.level = level;
	}


	public String toString() {
		return this.speed + "-" + this.pos + "-" + this.level;
	}
}

public class LeetCode_818 {
	static Queue<Node> queue = new LinkedList<>();
	static Map<String, Boolean> visited = new HashMap<>();

	/**
	 * 1.构建一个二叉树，每次分A和R两个分支
	 * 进行bfs逐层搜索，找到第一个等于target的节点，节点的深度就是路径长度
	 * 220ms 略慢
	 * 目前剪枝只对小于0 和 大于 target * 2,以及重复的 <speed,pos> pair
	 * 2.将字符串拼接改为StringBuilder方式构建，提升到192ms，还是很慢
	 */
	public static int racecar(int target) {
		queue.add(new Node(1, 0, 0));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.pos == target) {
				return node.level;
			}
			int nextSpeed = node.speed * 2;
			int nextPos = node.pos + node.speed;
			String key = getKey(nextSpeed, nextPos);
			if (visited.containsKey(key)) {
				continue;
			}
			if (nextPos <= 2 * target && nextPos >= 0) {
				visited.put(key, true);
				queue.add(new Node(node.speed * 2, node.pos + node.speed, node.level + 1));
			}

			int speedDir = -node.speed / Math.abs(node.speed);
			key = getKey(speedDir, node.pos);
			if (visited.containsKey(key)) {
				continue;
			}
			visited.put(key, true);
			queue.add(new Node(speedDir, node.pos, node.level + 1));
		}
		return 0;
	}

	public static String getKey(int speed, int pos) {
		StringBuilder sb = new StringBuilder();
		sb.append(speed);
		sb.append("-");
		sb.append(pos);
		return sb.toString();
	}

	/**
	 * 10ms dp
	 * 左移 右移一定记得加括号啊
	 */
	public static int raceCarDp(int target) {
		int[] dp = new int[target + 1];
		for (int i = 1; i <= target; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 1; (1 << j) - 1 <= i * 2; j++) {
				int pos = (1 << j) - 1; // 连续向右i步到达的位置 2 ^ i - 1
				if (pos == i) {
					dp[i] = j;
				} else if (pos > i) {
					dp[i] = Math.min(dp[i], j + 1 + dp[pos - i]);
				} else {
					for (int b = 0; b < j; b++) {
						int backDis = (1 << b) - 1;
						dp[i] = Math.min(dp[i], j + 1 + b + 1 + dp[i - pos + backDis]);
					}
				}
			}
		}
		return dp[target];
	}

	public static void main(String[] args) {
		int step = raceCarDp(330);
		System.out.println("step " + step);
	}
}

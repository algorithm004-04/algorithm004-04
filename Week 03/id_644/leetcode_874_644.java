package week03;
/**874
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 *
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 *
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 *
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 *
 * 返回从原点到机器人的最大欧式距离的平方。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 示例 2：
 *
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 *  
 *
 * 提示：
 *
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class robotsim {
    public static void main(String[] args) {
        int[] command = new int[] {4,-1,4,-2,4,1,1234567};
        int[][] obs = new int[][] {{2,4}};
        int temp = 6;
        //System.out.println(((long)6<<32) +1);
        long start = System.currentTimeMillis();
        int res = robotSim(command,obs);
        long end = System.currentTimeMillis();
        System.out.println((end-start));

    }
    public static  int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> set = new HashSet<>();
        //Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(((long)obs[0]<<32) + obs[1]);
            //set.add(obs[0]+" "+ obs[1]);

        }
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, x = 0, y = 0, result = 0;
        for (int c : commands) {
            if (c == -1) {
                d++;
                if (d == 4) {
                    d = 0;
                }
            } else if (c == -2) {
                d--;
                if (d == -1) {
                    d = 3;
                }
            } else {

                while (c-- > 0 && !set.contains(((long)(x + dirs[d][0])<<32) + y + dirs[d][1]))  {
                //while (c-- > 0 && !set.contains((x + dirs[d][0])+ " " + (y + dirs[d][1])))  {
                    x += dirs[d][0];
                    y += dirs[d][1];
                }
               // System.out.println(x+ "  "+y);
            }

            result = Math.max(result, x * x + y * y);
        }
        return result;
    }
}

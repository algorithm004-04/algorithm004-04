/*
解法１:使用递归，并使用ＨashＭap进行去重，即如果已经计算过直接返回结果
但是该算法在LeetCode上时间复杂度过高，未通过，提示超时
*/
class Solution1 {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        if(n == 1) {
            return 1;
        }

        if(n == 2) {
            return 2;
        }

        //判断当前的n是否已经有计数结果，如果有直接返回,即进行剪枝
        if(map.containsKey(n)){
            return map.get(n);
        }

        Integer ret = climbStairs(n-1) + climbStairs(n-2);
        map.put(n,ret);
        return ret;
    }

    public static void main(String[] args) {
       Solution res = new Solution();
       System.out.println(res.climbStairs(3));
    }
}



/*
解法2，将递归改写为迭代的方式(循环)
f(n) = f(n-1) + f(n-2) (f(1) = 1,f(2)=2)
*/
class Solution2 {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        if(n == 1) {
            return 1;
        }

        if(n == 2) {
            return 2;
        }

        int res = 0;
        int pre = 2;
        int prepre = 1;

        for(int i = 3; i <= n; ++i ){
            res = pre + prepre;
            prepre = pre;
            pre = res;
        }

        return res;
    }
}


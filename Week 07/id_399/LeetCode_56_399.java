public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0)
            return new int[0][0];
        LinkedList<Interval> list = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] nums = intervals[i];
            Interval in = new Interval(nums[0], nums[1]);
            list.add(in);
        }
        //按照区间第一个数字排序
        list.sort(Comparator.comparingInt(o -> o.num1));
        List<Interval> resList = new ArrayList<>();
        Interval first = list.removeFirst();
        while (!list.isEmpty()) {
            Interval second = list.removeFirst();
            if (first.num2 < second.num1) {
                //两个区间不相交
                resList.add(first);
                first = second;
            } else {
                //合并两个区间
                first = new Interval(first.num1, Math.max(first.num2, second.num2));
            }
        }
        resList.add(first);
        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            res[i][0] = resList.get(i).num1;
            res[i][1] = resList.get(i).num2;
        }
        return res;
    }

    class Interval {
        int num1;
        int num2;

        Interval(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

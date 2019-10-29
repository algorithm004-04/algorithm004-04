class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> rec = new LinkedList<>();
        backtrack(1, n, k, result, rec);
        return result;
    }

    public void backtrack(int level, int n, int k, List<List<Integer>> result, LinkedList<Integer> rec) {
        if(rec.size() == k) {
            result.add(new LinkedList<>(rec));
            return;
        }

        for (int i = level; i <= n; i++) {
            rec.add(i);
            backtrack(i + 1, n, k, result, rec);
            rec.removeLast();
        }
    }

}
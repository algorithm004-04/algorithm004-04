package week_02.lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        findCombinations(n,k,1,new Stack<>());
        return result;
    }

    private static void findCombinations(int n, int k, int i, Stack<Integer> p) {
        if (p.size() == k) {
            result.add(new ArrayList<>(p));
            return;
        }
        for (int j = i; j <= n - (k - p.size()) + 1; j++) {
            p.push(j);
            findCombinations(n,k,j+1,p);
            p.pop();
        }

    }

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }

}

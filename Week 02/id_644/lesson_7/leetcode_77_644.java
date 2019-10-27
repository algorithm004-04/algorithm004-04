package com.company;

import java.util.ArrayList;
import java.util.List;

public class combine {
    public static void main(String[] args) {

    }
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n<=0|| k>n || k<=0) return res;
        List<Integer> temp = new ArrayList<>();
        recur(n,k,1,temp);
        return res;


    }
    //递归
    public void recur_normal(int n ,int k, int start ,List<Integer> temp) {
        if(temp.size() == k)  {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start;i<=n;i++) {
            temp.add(i);
            recur_normal(n,k,i+1,temp);
            temp.remove(temp.size()-1);
        }
    }
    //reform
    public void recur(int n ,int k, int start ,List<Integer> temp) {
        if(temp.size() == k)  {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start;i<=n-(k-temp.size())+1;i++) { // 减少无效循环
            temp.add(i);
            recur(n,k,i+1,temp);
            temp.remove(temp.size()-1);
        }
    }

}

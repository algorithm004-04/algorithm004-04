package com.company;
/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public static void main(String[] args) {
        int test =3;
        System.out.println(generateParenthesis(3));

    }
    public static  List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String temp = "";
        recur(n,temp,0,0,res);
        return res;

    }

    public static void recur(int max, String temp, int lp, int rp, List<String> res) {

        if (temp.length() == max*2) {
            res.add(temp);
            return ;
        }
        if(lp<max) {
            recur(max,temp+"(",lp+1,rp,res);
            //temp.deleteCharAt(temp.length()-1);
        }
        if(rp<lp) {
            recur(max,temp+")",lp,rp+1,res);
            //temp.deleteCharAt(temp.length()-1);
        }
    }


    }


    /**stringbuilder 容易忘记temp的状态恢复
     *  public static  List<String> generateParenthesis(int n) {
     *         List<String> res = new ArrayList<>();
     *         StringBuilder temp = new StringBuilder("");
     *         recur(n,temp,0,0,res);
     *         return res;
     *
     *     }
     *
     *     public static void recur(int max, StringBuilder temp, int lp, int rp, List<String> res) {
     *
     *         if (temp.length() == max*2) {
     *             res.add(temp.toString());
     *             return ;
     *         }
     *         if(lp<max) {
     *             recur(max,temp.append("("),lp+1,rp,res);
     *             temp.deleteCharAt(temp.length()-1);
     *         }
     *         if(rp<lp) {
     *             recur(max,temp.append(")"),lp,rp+1,res);
     *             temp.deleteCharAt(temp.length()-1);
     *         }
     *     }
     */


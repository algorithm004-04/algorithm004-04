/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode_46_034
 *
 * @Author mengdebiao@duxiaoman.com
 * @Date 2019/10/27 12:11 PM
 **/
public class LeetCode_46_034 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(res, new ArrayList<Integer>(), nums);
        return res;
    }

    private void permute(List<List<Integer>> res, ArrayList<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            permute(res, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }

}

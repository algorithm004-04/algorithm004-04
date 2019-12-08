import java.util.ArrayList;
import java.util.List;

public class SubSetsSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null){
            return result;
        }
        dfs(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, ArrayList<Integer> list, int level) {
        //terminator
        if(level == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }

        //no process, drill down
        dfs(result, nums, list, level+1); //not pick the number at this index

        //process, drill down
        list.add(nums[level]);
        dfs(result, nums, list, level+1);

        //reverse the current state
        list.remove(list.size()-1);

    }


}

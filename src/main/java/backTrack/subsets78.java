package backTrack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qingqing
 * @function:求所有子集：回溯，leedcode78
 * @create 2021-04-04-14:36
 */
public class subsets78 {
//    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //     backtrack(0, nums, res, new ArrayList<Integer>());
        //     return res;
        // }

        // private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        //     res.add(new ArrayList<>(tmp));
        //     for (int j = i; j < nums.length; j++) {
        //         tmp.add(nums[j]);
        //         backtrack(j + 1, nums, res, tmp);
        //         tmp.remove(tmp.size() - 1);
        //     }
        // }

//        ArrayList<Integer> track = new ArrayList<>();
        backtrack(nums,0,new ArrayList<Integer>(),res);
        return res;
    }
    void backtrack(int[] nums, int start, ArrayList<Integer> track, List<List<Integer>> res){
        //和全排列不同，子集是在track.size()<nums.length()时，每组数res都保存
        res.add(new ArrayList<>(track));
        for(int i=start;i<nums.length;i++){
            track.add(nums[i]);
            backtrack(nums,i+1,track,res);   //不是start+1，是i+1！向下遍历
            track.remove(track.size()-1);
        }
    }
    @Test
    void test(){
        int[] nums = new int[]{1,2,3};
        subsets78 test = new subsets78();
        List<List<Integer>> res = test.subsets(nums);
        System.out.println(res);
    }
}
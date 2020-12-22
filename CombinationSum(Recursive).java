//Recursive Solution
class Solution {
    List<List<Integer>> result;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        targ = target;
        if(candidates==null || candidates.length==0){
            return result;
        }
        helper(candidates, new ArrayList<>(), 0, 0);
        return result;
    }
    public void helper(int[] candidates, List<Integer> temp, int sum, int index){
        //base
        if(sum > targ || index==candidates.length)
            return;
        if(sum==targ){
            result.add(temp);
            return;
        }
        //logic
        //don't choose
        helper(candidates, new ArrayList<>(temp), sum, index+1);
        //choose
        temp.add(candidates[index]);
        helper(candidates, new ArrayList<>(temp), sum + candidates[index], index);
    }
}
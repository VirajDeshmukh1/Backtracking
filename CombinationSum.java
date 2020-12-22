class Solution {
    List<List<Integer>> result;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        targ = target;
        if(candidates==null || candidates.length==0)
            return result;
        backtrack(candidates, new ArrayList<>(), 0, 0);
        return result;
    }
    public void backtrack(int[] candidates, List<Integer> temp, int sum, int index){
        //base
        if(sum>targ)
            return;
        if(sum==targ){
            result.add(new ArrayList<>(temp));
            return;
        }
        //logic
        for(int i=index;i<candidates.length;i++){
            //action
            temp.add(candidates[i]);
            //recurse
            backtrack(candidates, temp, sum + candidates[i], i);
            //backtrack
            temp.remove(temp.size()-1);
        }
    }
}

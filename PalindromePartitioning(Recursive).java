//Recusive Solution

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s==null || s.length()==0)
            return result;
        helper(s, new ArrayList<>(), 0);
        return result;
    }
    public void helper(String s, List<String> temp, int start){
        //base
        if(start==s.length()){
            result.add(temp);
            return;
        }
        //logic
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s, start, i)){
                List<String> newList = new ArrayList<>(temp);
                newList.add(s.substring(start, i+1));
                helper(s, newList, i+1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start)!=(s.charAt(end))){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }
}


//Space Complexity : O( 2^N)
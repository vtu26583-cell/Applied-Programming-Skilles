import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        // Base case: If the current list size matches the input array length, we found a permutation
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // Since numbers are unique, we just check if the number is already in our path
                if (tempList.contains(nums[i])) continue; 
                
                // Choose the element
                tempList.add(nums[i]);
                
                // Explore further
                backtrack(result, tempList, nums);
                
                // Backtrack (Remove the last element to try the next possibility)
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
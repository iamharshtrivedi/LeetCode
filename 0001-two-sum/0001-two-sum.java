import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Use a HashMap to store the numbers we've seen and their indices.
        // This allows for O(1) average time lookups.
        HashMap<Integer, Integer> numMap = new HashMap<>();

        // Iterate through the array with a single pass.
        for (int i = 0; i < nums.length; i++) {
            // Calculate the 'complement' required to reach the target.
            int complement = target - nums[i];

            // Check if the complement already exists in our map.
            if (numMap.containsKey(complement)) {
                // If it does, we've found the two numbers.
                // Return their indices: the one stored in the map and the current index.
                return new int[]{numMap.get(complement), i};
            }

            // If the complement isn't found, store the current number and its index.
            // This prepares the map for future lookups.
            numMap.put(nums[i], i);
        }

        // According to the problem statement, a solution is guaranteed to exist.
        // This return statement is a fallback and will not be reached.
        return new int[]{};
    }
}
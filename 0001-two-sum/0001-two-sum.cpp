#include <vector>
#include <unordered_map>

class Solution {
public:
    std::vector<int> twoSum(std::vector<int>& nums, int target) {
        // Use an unordered_map (hash map) for O(1) average time lookups.
        std::unordered_map<int, int> seen_numbers;

        // Iterate through the array once.
        for (int i = 0; i < nums.size(); ++i) {
            int current_num = nums[i];
            int complement = target - current_num;

            // Check if the complement exists in our map.
            if (seen_numbers.count(complement)) {
                // If it does, we found the pair. Return their indices.
                return {seen_numbers[complement], i};
            }
            
            // If not, store the current number and its index for future lookups.
            seen_numbers[current_num] = i;
        }

        // The problem guarantees a solution, so this line is for completeness.
        return {};
    }
};
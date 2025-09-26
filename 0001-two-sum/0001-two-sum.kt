class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // HashMap to store value -> index mapping for fast lookup
        val map = HashMap<Int, Int>()

        // Iterate through the array
        for (i in nums.indices) {
            val complement = target - nums[i]

            // If the complement is already seen, return the indices
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            }

            // Store current number with its index
            map[nums[i]] = i
        }

        // As per problem statement, there will always be one valid answer
        throw IllegalArgumentException("No solution found")
    }
}

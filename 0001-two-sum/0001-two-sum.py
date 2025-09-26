from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # A hash map to store the numbers we've seen and their indices.
        # This allows for O(1) average time complexity for lookups.
        num_map = {}

        # We iterate through the list only once.
        # 'enumerate' provides both the index 'i' and the value 'num'.
        for i, num in enumerate(nums):
            # Calculate the 'complement' needed to reach the target.
            complement = target - num

            # Check if the complement already exists in our hash map.
            # If it does, we've found the two numbers that sum up to the target.
            if complement in num_map:
                # The problem guarantees a unique solution, so we can return immediately.
                # 'num_map[complement]' gives the index of the complement.
                return [num_map[complement], i]
            
            # If the complement is not in the map, add the current number and its index.
            # This prepares the map for future lookups.
            num_map[num] = i

        # This part of the code is technically unreachable as the problem statement
        # guarantees that a solution always exists.
        return []

        
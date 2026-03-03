class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;

        int maxEnding = nums[0], maxSoFar = nums[0];
        int minEnding = nums[0], minSoFar = nums[0];

        total = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            total += x;

            // Kadane for max subarray
            maxEnding = Math.max(x, maxEnding + x);
            maxSoFar = Math.max(maxSoFar, maxEnding);

            // Kadane for min subarray
            minEnding = Math.min(x, minEnding + x);
            minSoFar = Math.min(minSoFar, minEnding);
        }

        // If all numbers are negative, maxSoFar is the answer
        if (maxSoFar < 0) return maxSoFar;

        // Otherwise max of non-circular and circular
        return Math.max(maxSoFar, total - minSoFar);
    }
}
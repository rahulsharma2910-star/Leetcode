class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        long sum = 0;
        long maxSum = 0;

        HashSet<Integer> set = new HashSet<>();

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            while (set.contains(nums[right])) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            sum += nums[right];
            set.add(nums[right]);

            if (right - left + 1 > k) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
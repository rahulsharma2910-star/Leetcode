
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean forward = nums[i] > 0;
            int slow = i;
            int fast = i;

            while (true) {
                slow = next(nums, slow, n, forward);
                if (slow == -1) {
                    break;
                }

                fast = next(nums, fast, n, forward);
                if (fast == -1) {
                    break;
                }

                fast = next(nums, fast, n, forward);
                if (fast == -1) {
                    break;
                }

                if (slow == fast) {
                    return true;
                }
            }
        }

        return false;
    }

    private int next(int[] nums, int index, int n, boolean forward) {
        if ((nums[index] > 0) != forward) {
            return -1;
        }

        int nextIndex = ((index + nums[index]) % n + n) % n;

        if (nextIndex == index) {
            return -1;
        }

        return nextIndex;
    }
}

 
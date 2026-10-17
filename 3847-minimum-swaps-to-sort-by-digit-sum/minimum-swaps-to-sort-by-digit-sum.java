class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        // Store [digitSum, value]
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = digitSum(nums[i]);
            arr[i][1] = nums[i];
        }
        // Sort by:
        // 1. digit sum
        // 2. value
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // value -> target index
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i][1], i);
        }
        boolean[] visited = new boolean[n];
        int ans = 0;
        // Find cycles
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int j = i;
            int cycleLength = 0;
            while (!visited[j]) {
                visited[j] = true;
                j = map.get(nums[j]);
                cycleLength++;
            }
            ans += cycleLength - 1;
        }
        return ans;
    }

    private int digitSum(int num) {

        int sum = 0;

        while (num > 0) {

            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
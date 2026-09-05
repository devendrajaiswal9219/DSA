class Solution {
    public void combinations(int idx, int sum, int k, int[] arr,
                             List<Integer> list, List<List<Integer>> ans) {
        if (idx == arr.length) {
            if (sum == k) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(arr[idx]);
        sum += arr[idx];
        if (sum < k) {
            combinations(idx, sum, k, arr, list, ans);
        }
        else if (sum == k) {
            combinations(idx + 1, sum, k, arr, list, ans);
        }
        sum -= arr[idx];
        list.remove(list.size() - 1);
        combinations(idx + 1, sum, k, arr, list, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinations(0, 0, target, candidates, list, ans);
        return ans;
    }
}
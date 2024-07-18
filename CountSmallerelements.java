class Solution {
    public int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        mergeSort(nums, indices, count, 0, n - 1);
        return count;
    }

    private void mergeSort(int[] nums, int[] indices, int[] count, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(nums, indices, count, start, mid);
        mergeSort(nums, indices, count, mid + 1, end);
        merge(nums, indices, count, start, mid, end);
    }

    private void merge(int[] nums, int[] indices, int[] count, int start, int mid, int end) {
        int[] tempIndices = new int[end - start + 1];
        int left = start, right = mid + 1, k = 0, rightCount = 0;
        while (left <= mid && right <= end) {
            if (nums[indices[right]] < nums[indices[left]]) {
                tempIndices[k++] = indices[right++];
                rightCount++;
            } else {
                tempIndices[k++] = indices[left];
                count[indices[left]] += rightCount;
                left++;
            }
        }
        while (left <= mid) {
            tempIndices[k++] = indices[left];
            count[indices[left]] += rightCount;
            left++;
        }
        while (right <= end) {
            tempIndices[k++] = indices[right++];
        }
        System.arraycopy(tempIndices, 0, indices, start, end - start + 1);
    }
}

class Solution3 {
    private final static Random RANDOM = new Random(System.currentTimeMillis());
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        return nums;
    }
    private void quickSort(int[] nums,int left,int right) {
        if (left >= right) {
            return;
        }

        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        int pivot = nums[left];

        int lt = left + 1; // lt: less than
        int gt = right; // gt: great than
        // all in nums[left+1,lt) < pivot
        // all in nums[lt..i) = pivot
        // all in nums(gt,right] > pivot
        int i = left + 1;
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums,i,lt);
                lt++;
                i++;
            }else if (nums[i] == pivot) {
                i++;
            }else {
                // nums[i] > pivot
                swap(nums,i,gt);
                gt--;
            }
        }
        swap(nums,left,lt - 1);
        quickSort(nums,left,lt - 2);
        quickSort(nums,gt + 1,right);

    }
   
    private void swap(int[] nums,int index1,int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
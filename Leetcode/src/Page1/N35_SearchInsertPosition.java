package Page1;

/*
* 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
* 你可以假设数组中无重复元素。
* */
public class N35_SearchInsertPosition {

    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] >= target) {
                break;
            }
        }
        return i;
    }

    public int searchInsert_(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}

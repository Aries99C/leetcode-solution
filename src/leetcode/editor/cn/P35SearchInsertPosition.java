//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 2199 👎 0

package leetcode.editor.cn;
//java:搜索插入位置
class P35SearchInsertPosition{
    public static void main(String[] args){
        Solution solution = new P35SearchInsertPosition().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0; // 查找区间左边界
        int right = nums.length - 1; // 查找区间右边界
        int mid = (right - left) / 2 + left; // 中位索引，如此计算避免溢出

        while (left < nums.length && right >= 0 && left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target) { // 找到目标
                return mid;
            } else if (nums[mid] > target) { // 在左侧
                right = mid - 1;
            } else { // 在右侧
                left = mid + 1;
            }
        }

        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
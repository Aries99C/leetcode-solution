//给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//
// 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。 
//
// 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并
//的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//解释：需要合并 [1,2,3] 和 [2,5,6] 。
//合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//解释：需要合并 [1] 和 [] 。
//合并结果是 [1] 。
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0], m = 0, nums2 = [1], n = 1
//输出：[1]
//解释：需要合并的数组是 [] 和 [1] 。
//合并结果是 [1] 。
//注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -10⁹ <= nums1[i], nums2[j] <= 10⁹ 
// 
//
// 
//
// 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？ 
//
// Related Topics 数组 双指针 排序 👍 2213 👎 0

package leetcode.editor.cn;
//java:合并两个有序数组
class P88MergeSortedArray{
    public static void main(String[] args){
        Solution solution = new P88MergeSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) { // 第二个数组为空不需要合并
            return;
        }

        int curIdx = m + n - 1; // 记录当前插入位置
        int scan1Idx = m - 1; // 第一个数组的扫描指针
        int scan2Idx = n - 1; // 第二个数组的扫描指针

        while (scan1Idx >= 0 && scan2Idx >= 0) {
            if (nums2[scan2Idx] > nums1[scan1Idx]) { // 第二个数组的最大值更大
                nums1[curIdx] = nums2[scan2Idx]; // 将第二个数组的最大值插入第一个数组
                // 移动指针来代表指针右侧的数组已合并完成
                curIdx--; // 插入位置移动
                scan2Idx--; // 第二个数组的扫描指针移动
            } else { // 第一个数组的最大值更大
                nums1[curIdx] = nums1[scan1Idx]; // 将第一个数组的最大值插入第一个数组
                // 移动指针来代表指针右侧的数组已合并完成
                curIdx--; // 插入位置移动
                scan1Idx--; // 第一个数组的扫描指针移动
            }
        }

        // 处理剩余未移动的元素
        while (scan2Idx >= 0) { // 第一个数组剩余的元素无需处理
            nums1[curIdx] = nums2[scan2Idx];
            curIdx--;
            scan2Idx--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
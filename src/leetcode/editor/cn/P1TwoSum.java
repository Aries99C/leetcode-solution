// 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [2,7,11,15], target = 9
// 输出：[0,1]
// 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
// 输入：nums = [3,2,4], target = 6
// 输出：[1,2]
// 
//
// 示例 3： 
//
// 
// 输入：nums = [3,3], target = 6
// 输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
//
// Related Topics 数组 哈希表 👍 17934 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

// java:两数之和
class P1TwoSum {
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> rest2Idx = new HashMap<>(); // 用哈希表存储“差值->下标”的键值对

            // 仅扫描一次数组，且哈希表操作均为O(1)，因此总时间复杂度为O(n)
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];
                if (rest2Idx.containsKey(x)) { // 如果已经有该key，说明扫描过的元素中存在一个y满足x+y=target
                    return new int[]{rest2Idx.get(x), i}; // 直接返回y和x的下标对
                } else {
                    rest2Idx.put(target - x, i); // 否则不存在y满足x+y=target，将(target-x, i)存入哈希表中
                }
            }

            // 不存在解就返回-1
            return new int[]{-1, -1};
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
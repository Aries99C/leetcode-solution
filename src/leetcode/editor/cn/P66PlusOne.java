//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
//
// Related Topics 数组 数学 👍 1318 👎 0

package leetcode.editor.cn;
//java:加一
class P66PlusOne{
    public static void main(String[] args){
        Solution solution = new P66PlusOne().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) { // 不存在进位
            digits[digits.length - 1]++;
            return digits;
        }

        // 检查是否为9999等
        boolean longer = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                longer = false;
                break;
            }
        }

        if (!longer) { // 数组长度一定不会发生改变
            int add = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int x = digits[i] + add;
                digits[i] = x % 10;
                add = x / 10;
            }
            return digits;
        } else {
            // 进位成100000等
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = 0;
            }
            return newDigits;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
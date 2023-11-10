//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics 数组 动态规划 👍 1089 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:杨辉三角
class P118PascalsTriangle{
    public static void main(String[] args){
        Solution solution = new P118PascalsTriangle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(); // 初始化

        for (int i = 0; i < numRows; i++) { // 按行生成
            List<Integer> row = new ArrayList<>(); // 初始化每行

            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            if (i > 0) { // 只有第一行左右侧的1是共享的
                row.add(1);
            }

            res.add(row);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
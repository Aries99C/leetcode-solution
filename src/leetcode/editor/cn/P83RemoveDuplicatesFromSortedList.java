//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 👍 1066 👎 0

package leetcode.editor.cn;
//java:删除排序链表中的重复元素
class P83RemoveDuplicatesFromSortedList{
    public static void main(String[] args){
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) { // 处理空链表
            return null;
        }

        ListNode dummy = new ListNode(-101); // 优化删除头节点的情况
        dummy.next = head;

        ListNode curNode = dummy.next;
        ListNode preNode = dummy;

        while (curNode.next != null) {
            if (curNode.val == curNode.next.val) { // 重复删除
                preNode.next = curNode.next; // 跳跃连接
                curNode.next = null; // 断开连接来删除当前节点
                curNode = preNode.next; // 扫描下一个节点
            } else { // 无需删除，两个指针前进
                preNode = preNode.next;
                curNode = curNode.next;
            }
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
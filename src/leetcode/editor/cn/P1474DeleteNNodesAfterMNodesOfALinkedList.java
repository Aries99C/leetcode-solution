// 给定链表 head 和两个整数 m 和 n. 遍历该链表并按照如下方式删除节点:
//
// 
// 开始时以头节点作为当前节点. 
// 保留以当前节点开始的前 m 个节点. 
// 删除接下来的 n 个节点. 
// 重复步骤 2 和 3, 直到到达链表结尾. 
// 
//
// 在删除了指定结点之后, 返回修改过后的链表的头节点. 
//
// 
//
// 示例 1: 
//
// 
//
// 
// 输入: head = [1,2,3,4,5,6,7,8,9,10,11,12,13], m = 2, n = 3
// 输出: [1,2,6,7,11,12]
// 解析: 保留前(m = 2)个结点,  也就是以黑色节点表示的从链表头结点开始的结点(1 ->2).
// 删除接下来的(n = 3)个结点(3 -> 4 -> 5), 在图中以红色结点表示.
// 继续相同的操作, 直到链表的末尾.
// 返回删除结点之后的链表的头结点.
//
// 示例 2: 
//
// 
//
// 
// 输入: head = [1,2,3,4,5,6,7,8,9,10,11], m = 1, n = 3
// 输出: [1,5,9]
// 解析: 返回删除结点之后的链表的头结点.
//
// 示例 3: 
//
// 
// 输入: head = [1,2,3,4,5,6,7,8,9,10,11], m = 3, n = 1
// 输出: [1,2,3,5,6,7,9,10,11]
// 
//
// 示例 4: 
//
// 
// 输入: head = [9,3,7,7,9,10,8,2], m = 1, n = 2
// 输出: [9,7,8]
// 
//
// 
//
// 提示: 
//
// 
// 链表中节点数目在范围 [1, 10⁴] 内 
// 1 <= Node.val <= 10⁶ 
// 1 <= m, n <= 1000 
// 
//
// 
//
// 进阶: 你能通过 就地 修改链表的方式解决这个问题吗? 
//
// Related Topics 链表 👍 27 👎 0

package leetcode.editor.cn;

// java:删除链表 M 个节点之后的 N 个节点
class P1474DeleteNNodesAfterMNodesOfALinkedList {
    public static void main(String[] args) {
        Solution solution = new P1474DeleteNNodesAfterMNodesOfALinkedList().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteNodes(ListNode head, int m, int n) {
            ListNode node = head;

            while (node != null) {
                // 先将node移动到保留的最后一个节点
                for (int i = 0; i < m - 1; i++) {
                    if (node.next == null) { // 保留时提前终止，直接返回
                        return head;
                    }
                    node = node.next;
                }
                // 找到下一次保留的第一个节点
                ListNode next = node;
                for (int i = 0; i < n + 1; i++) {
                    if (next.next == null) { // 删除时提前终止，处理完链表连接再返回
                        node.next = null; // 从上一次保留的末尾断开即可
                        return head;
                    }
                    next = next.next;
                }
                // 处理本次删除的连接更新
                node.next = next; // 从上一次保留的末尾连接到本次保留的起点
                node = node.next;
            }

            return head;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
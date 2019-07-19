import java.util.ArrayList;
import java.util.List;

/**
 * P024 Swap Nodes in Pairs
 * Medium
 *
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class LC024_Swap_Nodes_In_Pairs {


    /**
     * Version A, 用List重排
     */
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // create a list of Nodes
        List<ListNode> node_list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            node_list.add(cur);
            cur = cur.next;
        }

        // swap in list
        for (int i = 0; i < node_list.size(); i += 2) {
            if (node_list.get(i).next != null) {
                ListNode temp = node_list.get(i);
                node_list.set(i, node_list.get(i + 1));
                node_list.set(i + 1, temp);
            }
        }

        // re-link
        int i = 0;
        while (i != node_list.size() - 1) {
            node_list.get(i).next = node_list.get(i + 1);
            i += 1;
        }
        node_list.get(i).next = null;

        return node_list.get(0);
    }

    public static void main(String[] args) {

        assert new LC024_Swap_Nodes_In_Pairs().swapPairs(null) == null: "Empty";

        ListNode Q1 = ListNode.genNode(new int[]{1});
        ListNode A1 = ListNode.genNode(new int[]{1});
        assert new LC024_Swap_Nodes_In_Pairs().swapPairs(Q1).equals(A1): "Single";

        ListNode Q2 = ListNode.genNode(new int[]{1,2});
        ListNode A2 = ListNode.genNode(new int[]{2,1});
        assert new LC024_Swap_Nodes_In_Pairs().swapPairs(Q2).equals(A2): "1 Pair";

        ListNode Q3 = ListNode.genNode(new int[]{1, 2, 3, 4});
        ListNode A3 = ListNode.genNode(new int[]{2, 1, 4, 3});
        assert new LC024_Swap_Nodes_In_Pairs().swapPairs(Q3).equals(A3): "Even pairs";

        ListNode Q4 = ListNode.genNode(new int[]{1, 2, 3, 4, 5});
        ListNode A4 = ListNode.genNode(new int[]{2, 1, 4, 3, 5});
        assert new LC024_Swap_Nodes_In_Pairs().swapPairs(Q4).equals(A4): "Odd paris";

        System.out.println("all passed");

    }


}

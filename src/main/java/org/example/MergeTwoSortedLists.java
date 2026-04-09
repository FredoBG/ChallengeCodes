package org.example;

import org.example.util.ListNode;

public class MergeTwoSortedLists {

    public void merge(ListNode list1, ListNode list2) {
        ListNode list3 = null, currNode = null, headList3 = null;
        int whichList;

        System.out.println("List1: ");
        this.printList(list1);
        System.out.println("List2: ");
        this.printList(list2);

        if (list1 == null)
            headList3 = list2;
        else if (list2 == null)
            headList3 = list1;

        if (headList3 == null) {
            while (list1 != null && list2 != null) {
                currNode = list1.val <= list2.val ? list1 : list2;
                whichList = list1.val <= list2.val ? 1 : 2;
                if (list3 == null) {
                    list3 = new ListNode(currNode.val);
                    headList3 = list3;
                } else {
                    list3.next = new ListNode(currNode.val);
                    list3 = list3.next;
                }
                if (whichList == 1)
                    list1 = currNode.next;
                else
                    list2 = currNode.next;
            }
            list3.next = list1 != null ? list1 : list2;
        }

        System.out.println("mergedList: ");
        this.printList(headList3);
    }

    private void printList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }

        System.out.println();
    }
}

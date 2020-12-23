package com.interview_preparation_kit.linkedlists;

import java.util.HashSet;
import com.interview_preparation_kit.linkedlists.FindMergePointofTwoLists.SinglyLinkedListNode;

public class DetectACycle {

    /*
    Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

    A Node is defined as:
        class Node {
            int data;
            Node next;
        }
    */

    boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        HashSet<SinglyLinkedListNode> hsp = new HashSet<>();

        if (head == null) return false;

        while(current != null){
            if(hsp.contains(current)) return true;
            else hsp.add(current);
            current = current.next;
        }

        return false;
    }

    boolean hasCycleWithTwoPointers(SinglyLinkedListNode head) {

        if (head == null) return false;

        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

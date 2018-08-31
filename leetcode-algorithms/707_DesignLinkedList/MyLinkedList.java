class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode head;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode dummy = head;
        if (index >= size) {
            return -1;
        }
        int count = 0;

        while (count != index) {
            dummy = dummy.next;
            count += 1;
        }

        return dummy.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        this.head = newHead;
        size += 1;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode dummy = head;

        while (dummy.next != null) {
            dummy = dummy.next;
        }
        dummy.next = new ListNode(val);
        size += 1;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode dummy = head;

        if (index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        int count = 0;

        while (count != index - 1) {
            dummy = dummy.next;
            count += 1;
        }

        ListNode tmp = new ListNode(val);
        tmp.next = dummy.next;
        dummy.next = tmp;
        size += 1;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode dummy = head;
        ListNode prev = null;
        if (index >= size) {
            return;
        }

        int count = 0;

        while (count != index) {
            prev = dummy;
            dummy = dummy.next;
            count += 1;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = dummy.next;
            dummy.next = null;
        }
        size -= 1;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

package list;

public class MiscSingleLinkList
{

    // Move last element to front of a given Linked List
    public static ListNode moveLastToFirst(ListNode head)
    {

        if (head == null || head.getNext() == null)
        {
            return null;
        }
        ListNode Prelast = null;
        ListNode last = head;

        while (last.getNext() != null)
        {
            Prelast = last;
            last = last.getNext();
        }
        Prelast.setNext(null);

        last.setNext(head);
        head = last;
        return head;
    }

    /* deletes alternate nodes of a list starting with head */

    public static void deleteAlt(ListNode head)
    {

        if (head == null)
        {
            return;
        }
        ListNode prev = head;
        ListNode next = head.getNext();

        while (prev != null && next != null)
        {

            prev.setNext(next.getNext());
            next = null;
            prev = prev.getNext();
            if (prev != null)
            {
                next = prev.getNext();
            }
        }
        SingleLinkList.printList(head);
    }

    /*
     * Reverse a Linked List in groups of given size Inputs: 1->2->3->4->5->6->7->8->NULL and k = 3 Output:
     * 3->2->1->6->5->4->8->7->NULL.
     */
    public static ListNode reverse(ListNode head, int n)
    {

        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        int count = 0;

        while (curr != null && count < n)
        {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null)
        {
            head.setNext(reverse(next, 3));
        }

        return prev;

    }

    /*
     * Reverse alternate K nodes in a Singly Linked List Given a linked list, write a function to reverse every
     * alternate k nodes (where k is an input to the function) in an efficient way. Give the complexity of your
     * algorithm.
     * 
     * Example: Inputs: 1->2->3->4->5->6->7->8->9->NULL and k = 3 Output: 3->2->1->4->5->6->9->8->7->NULL.
     */

    public static ListNode reverseAlt(ListNode head, int n)
    {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < n)
        {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
            count++;
        }
        if (head != null)
        {
            head.setNext(curr);
        }
        count = 0;
        while (count < n - 1 && curr != null)
        {
            curr = curr.getNext();
            count++;
        }
        if (curr != null)
        {
            curr.setNext(reverseAlt(curr.getNext(), n));
        }
        return prev;
    }

    /*
     * Segregate even and odd nodes in a Linked List Given a Linked List of integers, write a function to modify the
     * linked list such that all even numbers appear before all the odd numbers in the modified linked list. Also, keep
     * the order of even and odd numbers same.
     * 
     * Examples: Input: 17->15->8->12->10->5->4->1->7->6->NULL Output: 8->12->10->4->6->17->15->5->1->7->NULL
     */
    public static ListNode segregateEvenOdd(ListNode head)
    {

        ListNode end = head;
        ListNode curr = head;
        ListNode prev = null;

        while (end.getNext() != null)
        {
            end = end.getNext();
        }
        ListNode new_end = end;
        while (curr.getData() % 2 != 0 && curr != end)
        {
            new_end.setNext(curr);
            curr = curr.getNext();
            new_end.getNext().setNext(null);
            new_end = new_end.getNext();
        }
        if (curr.getData() % 2 == 0)
        {
            head = curr;

            while (curr != end)
            {

                if (curr.getData() % 2 == 0)
                {
                    prev = curr;
                    curr = curr.getNext();
                }
                else
                {

                    prev.setNext(curr.getNext());
                    curr.setNext(null);
                    new_end.setNext(curr);
                    new_end = new_end.getNext();
                    curr = prev.getNext();
                }

            }

        }
        else
        {
            prev = curr;
        }
        if (new_end != end && (end.getData()) % 2 != 0)
        {
            prev.setNext(end.getNext());
            end.setNext(null);
            new_end.setNext(end);
        }
        return head;

    }

    // Detect and Remove Loop in a Linked List

    public static int detectAndRemoveLoop(ListNode head)
    {
        ListNode node1 = head;
        ListNode node2 = head;

        while (node1 != null && node2 != null && node2.getNext() != null)
        {
            node1 = node1.getNext();
            node2 = node2.getNext().getNext();

            if (node1 == node2)
            {
                remove(node1, head);
                return 1;
            }
        }
        return 0;
    }

    public static void remove(ListNode node1, ListNode head)
    {

        ListNode pt1 = node1;
        ListNode pt2 = node1;

        int k = 0;

        while (pt1.getNext() != pt2)
        {
            pt1 = pt1.getNext();
            k++;
        }
        pt1 = head;
        pt2 = head;

        for (int i = 0; i < k; i++)
        {
            pt2 = pt2.getNext();
        }

        while (pt2.getNext() != pt1)
        {
            pt2 = pt2.getNext();
            pt1 = pt1.getNext();
        }
        pt2.setNext(null);

    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode();
        head = SingleLinkList.insert(head, 18);
        head = SingleLinkList.insert(head, 17);
        head = SingleLinkList.insert(head, 16);
        head = SingleLinkList.insert(head, 15);
        head = SingleLinkList.insert(head, 14);

        head = SingleLinkList.insert(head, 13);
        head = SingleLinkList.insert(head, 12);
        head = SingleLinkList.insert(head, 11);

        head.getNext().getNext().getNext().getNext().getNext().getNext().getNext()
                .setNext(head.getNext().getNext().getNext());
        System.out.println("Detetct =" + detectAndRemoveLoop(head));
        SingleLinkList.printList(head);
        // head = moveLastToFirst(head);
        // SingleLinkList.printList(reverseAlt(head, 3));
        // deleteAlt(head);
        // SingleLinkList.printList(segregateEvenOdd(head));

    }

}

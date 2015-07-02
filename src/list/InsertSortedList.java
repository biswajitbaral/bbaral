package list;

public class InsertSortedList
{

    /**
     * @param args
     */
    public static ListNode insertSorted(ListNode head, int data)
    {

        ListNode node = new ListNode(data);

        if (head.getData() == Integer.MIN_VALUE)
        {

            return node;
        }

        if (head.getData() > data)
        {
            node.setNext(head);
            return node;
        }
        ListNode currNode = head, prevNode = head;

        while (currNode != null && currNode.getData() < data)
        {
            prevNode = currNode;
            currNode = currNode.getNext();
        }
        prevNode.setNext(node);
        node.setNext(currNode);
        return head;

    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode();
        head = SingleLinkList.insert(head, 15);
        head = SingleLinkList.insert(head, 14);
        head = SingleLinkList.insert(head, 13);
        head = SingleLinkList.insert(head, 12);
        head = SingleLinkList.insert(head, 11);
        SingleLinkList.printList(head);
        head = insertSorted(head, 20);
        SingleLinkList.printList(head);
        head = insertSorted(head, 10);
        SingleLinkList.printList(head);
        head = insertSorted(head, 14);
        SingleLinkList.printList(head);
        head = insertSorted(head, 13);
        SingleLinkList.printList(head);

    }

}

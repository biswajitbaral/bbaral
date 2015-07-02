package list;

/*
 * Single Link List Implementation 
 * */
public class ListNode
{
    private int      data = Integer.MIN_VALUE; ;
    private ListNode next;

    public ListNode()
    {

    }

    public ListNode(int data)
    {
        this.data = data;
    }

    /**
     * @return the node
     */

    public ListNode getNext()
    {
        return this.next;
    }

    /**
     * @param node
     *            the node to set
     */
    public void setNext(ListNode next)
    {
        this.next = next;
    }

    /**
     * @return the data
     */
    public int getData()
    {
        return data;
    }

    /**
     * @param data
     *            the data to set
     */
    public void setData(int data)
    {
        this.data = data;
    }
}

class SingleLinkList
{
    // Length
    public int ListLength(ListNode head)
    {
        int length = 0;
        ListNode current = head;
        while (current != null)
        {
            length++;
            current = current.getNext();
        }

        return length;
    }

    public static void printList(ListNode headNode)
    { // no need of temp, because the function cannot

        while (headNode != null)
        {

            System.out.print(headNode.getData() + " ");

            headNode = headNode.getNext();
        }
        System.out.println();
    }

    // insert data
    public static ListNode insert(ListNode headNode, int data)
    {
        if (headNode.getData() == Integer.MIN_VALUE)
        {
            headNode.setData(data);
            return headNode;
        }

        ListNode newNode = new ListNode(data);
        newNode.setNext(headNode);
        headNode = newNode;
        return headNode;
    }

    // insertLinkList
    public ListNode insertLinkList(ListNode headNode, ListNode nodeToinsert, int pos)
    {

        if (headNode == null)
        {
            return nodeToinsert;
        }
        int size = ListLength(headNode);

        if (pos > size + 1 || pos < 1)
        {
            System.out.println("Invalid Position");
            return headNode;
        }
        if (pos == 1)
        {
            nodeToinsert.setNext(headNode);
            return nodeToinsert;
        }
        else
        {
            ListNode prevNode = headNode;
            int count = 1;
            while (count < pos - 1)
            {
                prevNode = prevNode.getNext();
                count++;
            }
            ListNode currentNode = prevNode.getNext();
            nodeToinsert.setNext(currentNode);
            prevNode.setNext(nodeToinsert);
        }
        return headNode;
    }

    // delete LinkList
    public ListNode deleteLinkList(ListNode headNode, int pos)
    {
        int size = ListLength(headNode);
        if (pos > size || pos < 1)
        {
            System.out.println("Not possible");
            return headNode;
        }
        if (pos == 1)
        {
            ListNode currentNode = headNode.getNext();
            headNode = null;
            return currentNode;
        }
        else
        {
            ListNode prevNode = headNode;
            int count = 1;
            while (count < pos)
            {
                prevNode = prevNode.getNext();
                count++;
            }
            ListNode currentNode = prevNode.getNext();
            prevNode.setNext(currentNode.getNext());
            currentNode = null;
        }
        return headNode;
    }

    // search from a list
    public boolean searchLinkList(ListNode headNode, int x)
    {
        ListNode currentNode = headNode;
        while (currentNode != null)
        {
            if (currentNode.getData() == x)
            {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    // getNth Node from start

    public int getNthNode(ListNode headNode, int index)
    {
        ListNode currentNode = headNode;
        int count = 0;
        while (currentNode != null)
        {
            if (count == index)
            {
                return currentNode.getData();
            }
            currentNode = currentNode.getNext();
            count++;
        }
        // throw Exception will be better solution , here i am returning -1
        return -1;
    }

    // print Middle Point
    public void PrintMiddleNode(ListNode headNode)
    {
        ListNode slowNode = headNode;
        ListNode fastNode = headNode;

        while (slowNode != null && fastNode != null)
        {
            slowNode = headNode.getNext();
            fastNode = headNode.getNext().getNext();
        }

        System.out.println(slowNode.getData());
    }

    // Nth node from the end of a Linked List
    public void printNthFromLast(ListNode headNode, int n)
    {

        ListNode currNode = headNode;
        ListNode tmpNode = headNode;
        int count = 0;
        if (headNode != null)
        {

            while (count < n)
            {
                if (tmpNode == null)
                {
                    System.out.println("Lesser length");
                    return;
                }
                count++;
                tmpNode = tmpNode.getNext();
            }
            while (tmpNode != null)
            {
                tmpNode = tmpNode.getNext();
                currNode = currNode.getNext();
            }
            System.out.println(currNode.getData());
        }

    }

    // delete a List
    public void deleteList(ListNode headNode)
    {
        ListNode currNode = headNode;
        ListNode nextNode;

        while (currNode != null)
        {
            nextNode = currNode.getNext();
            currNode = null;
            currNode = nextNode;
        }
        headNode = null;
    }

    // Reverse a link List

    public void reverseList(ListNode headNode)
    {
        ListNode prev = null;
        ListNode currrentNode = headNode;
        ListNode next;

        while (currrentNode != null)
        {
            next = currrentNode.getNext();
            currrentNode.setNext(prev);
            prev = currrentNode;
            currrentNode = next;
        }
        headNode = prev;
    }

    // detect Loop in LinkList using Floyd’s Cycle-Finding Algorithm:
    public int detectLoop(ListNode headNode)
    {
        ListNode slowNode = headNode;
        ListNode fastNode = headNode;

        while (slowNode != null && fastNode != null)
        {
            slowNode = headNode.getNext();
            fastNode = headNode.getNext().getNext();

            if (slowNode == fastNode)
            {
                System.out.println("Found Loop");
                return 1;
            }
        }
        return 0;
    }
}

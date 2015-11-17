package list;

/*
 * Double Link List Implementation 
 * */
public class DLLNode
{

    private int     data;
    private DLLNode prev;
    private DLLNode next;

    public DLLNode(int data)
    {
        this.data = data;
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

    /**
     * @return the prev
     */
    public DLLNode getPrev()
    {
        return prev;
    }

    /**
     * @param prev
     *            the prev to set
     */
    public void setPrev(DLLNode prev)
    {
        this.prev = prev;
    }

    /**
     * @return the next
     */
    public DLLNode getNext()
    {
        return next;
    }

    public int ListLength(DLLNode head)
    {
        int length = 0;
        DLLNode current = head;
        while (current != null)
        {
            length++;
            current = current.getNext();
        }

        return length;
    }

    /**
     * @param next
     *            the next to set
     */
    public void setNext(DLLNode next)
    {
        this.next = next;
    }

    public DLLNode insertDLList(DLLNode headNode, DLLNode nodeToinsert, int pos)
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
            headNode.setPrev(nodeToinsert);
            return nodeToinsert;
        }
        else
        {
            DLLNode prevNode = headNode;
            int count = 1;
            while (count < pos - 1)
            {
                prevNode = prevNode.getNext();
                count++;
            }
            DLLNode currentNode = prevNode.getNext();
            if (currentNode != null)
            {
                currentNode.setPrev(nodeToinsert);
            }
            nodeToinsert.setNext(currentNode);
            prevNode.setNext(nodeToinsert);
            nodeToinsert.setPrev(prevNode);

        }
        return headNode;
    }

}

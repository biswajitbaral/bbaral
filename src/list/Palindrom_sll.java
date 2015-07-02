package list;

public class Palindrom_sll
{

    private ListNode start;

    public boolean isPalindrome(ListNode headNode)
    {
        start = headNode;
        boolean isPalin = isPalindromeUtil(headNode);
        start = null;
        return isPalin;
    }

    private boolean isPalindromeUtil(ListNode right)
    {
        if (right == null)
        {
            return true;
        }
        boolean isp = isPalindromeUtil(right.getNext());
        if (!isp)
        {
            return false;
        }

        if (start.getData() == right.getData())
        {
            start = start.getNext();
            return true;
        }

        return false;
    }

    public static void main(String[] args)
    {
        Palindrom_sll pl = new Palindrom_sll();
        ListNode head = new ListNode();
        head = SingleLinkList.insert(head, 11);
        head = SingleLinkList.insert(head, 12);
        head = SingleLinkList.insert(head, 13);
        head = SingleLinkList.insert(head, 12);
        head = SingleLinkList.insert(head, 11);
        SingleLinkList.printList(head);
        if (pl.isPalindrome(head))
        {
            System.out.println("is a palindrome");
        }
        else
        {
            System.out.println("not a palindrome");
        }

    }

}

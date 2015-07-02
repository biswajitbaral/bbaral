package list;

public class InsertPoint
{

    public static int insertPoint(ListNode head1, ListNode head2)
    {
        SingleLinkList sl = new SingleLinkList();
        int c1 = sl.ListLength(head1);
        int c2 = sl.ListLength(head2);
        int d = 0;
        if (c1 > c2)
        {
            d = c1 - c2;
            return insertPoint(d, head1, head2);
        }
        else
        {
            d = c2 - c1;
            return insertPoint(d, head2, head1);

        }

    }

    public static int insertPoint(int d, ListNode head1, ListNode head2)
    {

        ListNode curr1 = head1;
        ListNode curr2 = head2;

        for (int i = 0; i < d; i++)
        {
            if (curr1 == null)
            {
                return -1;
            }
            curr1 = curr1.getNext();
        }
        while (curr1 != null && curr2 != null)
        {

            if (curr1 == curr2)
            {
                return curr1.getData();
            }
            curr1 = curr1.getNext();
            curr2 = curr2.getNext();
        }
        return -1;
    }

}

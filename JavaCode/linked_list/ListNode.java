package JavaCode.linked_list;

public class ListNode {
    public int val;
    public ListNode next;
    public  ListNode(int val)
    {
        this.val=val;
        next=null;
    }

    @Override
    public String toString() {
       StringBuilder sb=new StringBuilder();
       ListNode p=this;
       while (p!=null)
       {
           sb.append(p.val).append("->");
           p=p.next;
       }
       sb.append("null");
       return sb.toString();
    }
}

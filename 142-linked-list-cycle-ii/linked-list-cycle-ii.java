class Solution{
public ListNode detectCycle(ListNode head){
if(head==null)return null;
ListNode s=head,f=head;
while(f!=null&&f.next!=null){
s=s.next;
f=f.next.next;
if(s==f){
ListNode p=head;
while(p!=s){
p=p.next;
s=s.next;
}
return p;
}
}
return null;
}
}
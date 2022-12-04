https://leetcode.com/problems/palindrome-linked-list/

class Solution {
    
    ListNode reverse(ListNode head)
    {
        ListNode c = head;
        ListNode n;
        ListNode p = null;
        while(c!=null)
        {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }
    
    public boolean isPalindrome(ListNode head) {
        
        if(head==null || head.next==null)
        {
            return true;
        }
    
        // mid point
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        slow.next = reverse(slow.next);
        
        slow = slow.next;
        
        // compare slow with head
        while(slow!=null)
        {
            if(slow.val!=head.val)
            {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        
        return true;
        
    }
}
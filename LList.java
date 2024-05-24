public class LList {
 private Node head;
 // private LList next;

 public Node getHead() { return head; }
 
 static class Node {
   private Node next;
   private Object data;
 
   public Node(Object dataValue) {
     next = null;
     data = dataValue;
   }
 
   // The next four methods are not needed unless a Node is being
   // accessed from outside the LList class.
 
   public Node getNext() { return next; }
 
   public Object getData() { return data; }
 
   public void setNext(Node nextValue) {
     next = nextValue;
   }
 
   public void setData(Object info) {
     data = info;
   }
 
 }
 
 public LList() {
   head = null;
 }
  public void InsertAtHead(Object info) {
   Node temp = new Node(info);
   temp.next = head;
   head = temp;
 }
 
 public void InsertAtTail(Object info) {
   Node temp = new Node(info);
 
   if (head == null) {
     head = temp;
   } else {
     Node iterator = head;
     while (iterator.next != null)
       iterator = iterator.next;
     iterator.next = temp;
   }
 }
 
 public void InsertItem(Node before, Object info) {
   Node temp = new Node(info);
   temp.next = before.next;
   before.next = temp;
 }
 
 public int DeleteNode(Object info) {
   Node temp = Find(info);
 
   if (temp == null)
     return 0;
 
   Node iterator = head;
 
   while (iterator != null && iterator.next != temp)
     iterator = iterator.next;
 
   iterator.next = temp.next;
 
   return 1;
 
 }
 
 public void PrintList() {
   Node iterator = head;
   while (iterator != null) {
     System.out.println(iterator.data);
     iterator = iterator.next;
   }
 }
 
 public Node Find(Object target) {
   Node iterator = head;
   while (iterator != null && !(iterator.data.equals(target)))
     iterator = iterator.next;
 
   return iterator;
 }
}
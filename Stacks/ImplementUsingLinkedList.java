public class ImplementUsingLinkedList {
    public static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value=value;
            next=null;
        }
    }

    static class Stack{
        private static Node head;
        public static boolean isEmpty(){
            return head==null;
        }

        public static void push(int value){
            Node newNode=new Node(value);
            if(isEmpty()){
                head=newNode;
                return;
            }

            newNode.next=head;
            head=newNode;
        }

        public static int pop() {
            if(isEmpty()){
                return -1;
            }
            int top=head.value;
            head=head.next;
            return top;            
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.value;

        }
        
    }

    public static void main(String[] args) {
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }


    }
    
}

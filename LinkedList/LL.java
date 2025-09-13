class LL{
    Node head;
    private int size;
    
    // what node contains
    class Node{ 
        String data;
        Node next;

        Node(String data){
        this.data=data;
        this.next=null;
        }
    }

    public void addFirst(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;   
            return;         
        }
        size++;
        newNode.next=head;
        head=newNode;
    }

    public void addLast(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;   
            return;         
        }
        size++;
        Node currentNode=head;
        while(currentNode.next!=null){
            currentNode=currentNode.next;
        }

        currentNode.next=newNode;
    }

    public void deleteFirst(){
        if(head== null){
            System.out.println("Linkedlist is empty");
            return;
        }
        size--;
        head=head.next;
    }

    public void deleteLast(){
        if(head== null){
            System.out.println("Linkedlist is empty");
            return;
        }
       
        size--;
        if(head.next==null){
            head=null;
            return;     
        }

        Node secondlast =head;
        Node last=head.next;

        if(last.next!=null){
            last=last.next;
            secondlast=secondlast.next;
        }

        secondlast.next=null;
    }

    public int getSize(){
        return size;
    }

    public void printList(){
        if(head==null){
            System.out.println("Linked List is empty");
        }

        Node currentNode=head;
        while(currentNode!=null){
            System.out.print(currentNode.data+ "->");
            currentNode=currentNode.next;
        }

        System.out.print("null");
    }


    public static void main(String args[]){
        LL list=new LL();

        list.addFirst("is");
        list.addFirst("name");
        list.addFirst("My");
        list.addLast("Vaishnavi");
        
        list.printList();

        list.getSize();
        list.deleteFirst();
        list.deleteLast();  

        System.out.println("");
        list.printList();
        list.getSize();

    }

}

// The reason your last line is not working:

// System.out.print(list.printList());


// is because printList() does not return anything.

// printList() is defined as:

// public void printList() { ... }


// void means it does not give any value back.

// System.out.print() can only print something that actually exists (like a string or number).

// So Java cannot print void, that’s why it fails.

// ✅ Fix it by just calling the method directly:

// list.printList();  // This will print the linked list


// No System.out.print() needed.








// //1️⃣ void methods

// When a method is declared as void, it does not return anything.

// That’s fine — you don’t have to return a value.

// Example:

// public void sayHello() {
//     System.out.println("Hello");
// }


// You just call it:

// sayHello(); // prints "Hello"


// You cannot do:

// System.out.print(sayHello()); // ❌ ERROR because void gives nothing

// 2️⃣ What about return; in a void method?

// Even though void doesn’t return a value, you can still write:

// return;


// This just stops the method immediately.

// You are not returning a value, you are just exiting early.

// Example:

// public void addFirst(String data){
//     Node newNode = new Node(data);
//     if(head == null){
//         head = newNode;
//         return; // exit here, nothing after this runs
//     }
//     newNode.next = head;
//     head = newNode;
// }


// Without return, if the list is empty, your code would continue to:

// newNode.next = head; // newNode.next points to itself → WRONG
// head = newNode;


// So return is just to stop the method early, not to return a value. ✅

// 💡 Shortcut way to think about it:

// return; in a void method = “stop the method now”

// You don’t give back a value

// You can skip it, but sometimes it prevents mistakes or extra code from running
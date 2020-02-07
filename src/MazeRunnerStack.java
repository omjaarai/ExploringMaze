import java.util.EmptyStackException;
class Position {
    int col;
    int row;
    Position(int row, int col) {
        this.col = col;
        this.row = row;
    }
    boolean equals(Position other) {
        return this.col==other.col && this.row==other.row;
    }
}
class ListNode<T> {
    // Fields
    private T item;            // item data field of any type T
    private ListNode<T> next;  // reference to the next node in the list

    // Constructors
    /**
     * Creates an instance of ListNode given an item
     * The created ListNode does not refer to any next one
     * @param item
     */
    public ListNode(T item) {
        this.item = item;
        this.next = null;
    }

    /**
     * Creates an instance of ListNode given item and next as input arguments
     * @param item represents the data field
     * @param next refers to the next node in the list
     */
    public ListNode(T item, ListNode<T> next) {
        this.item = item;
        this.next = next;
    }

    // Methods
    /**
     * @return the item
     */
    public T getItem() {
        if(item!=null)
            return item;
        else 
            return null;
    }

    /**
     * @param item the item to set
     */
    public void setItem(T item) {
        this.item = item;
    }

    /**
     * @return the next
     */
    public ListNode<T> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(ListNode<T> next) {
        this.next = next;
    }


} 

public class MazeRunnerStack implements StackADT<Position> {
    ListNode<Position> top; // top of the linked list
    int size; // size of the stack
    public MazeRunnerStack() {
        top = null;
        size = 0;
    }

    public boolean contains(Position p)throws EmptyStackException {
            if (isEmpty())
                throw new EmptyStackException();
            ListNode<Position> runner = top; // create a runner pointer 
            // and initialize it to top

            // traverse the list looking for a much with p
            while (runner != null && !runner.getItem().equals(p))
                runner = runner.getNext();

            if (runner != null) // item found
                return true;
            else // list entirely traversed without finding a match with findObject
                return false;
        
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return top==null;
    } // returns true if the stack is empty, otherwise returns false

    public void push(Position item) throws IllegalArgumentException {
        // inserts a ListNode holding newObject at
        // the top of the stack.
        // size should be incremented after adding newObject
        // to the stack
        // This operation is equivalent to add newObject at index 0
        // with a SinglyLinkedList

        // create new ListNode with next node top
        ListNode<Position> newNode = new ListNode<>(item, top);
        // Put newNode as the top of the list
        top = newNode;
        // free newNode
        newNode = null;
        // increment size if item is not null
        if(item!=null)
            size++;
        else {
            throw new IllegalArgumentException();
        }

    }

    public Position pop() throws EmptyStackException {
        // The size should be decremented if the pop operation is executed
        // without error
        if (isEmpty())
            throw new EmptyStackException(); 
        // or
        //return null;
        // or
        // throw new EmptyStackException();

        // remove and return the node at the top of the stack
        Position remove = top.getItem();
        top = top.getNext();
        size --; // decrement the stack's size
        return remove;  
    }

    public Position peek() throws EmptyStackException {
        // returns the item at the top of the stack without removing it
        // throws an exception or returns null if the stack is empty

        if (isEmpty()) 
            //throw new EmptyStackException(); 
            // or
            // return null;
            throw new EmptyStackException();

        return top.getItem(); // return item at the top of the stack
    }


    //to display all the elements in the stack in a sequential order
    public void display() {
        ListNode<Position> runner = top;
        int row, col, c=0;
        int[][] arr= new int[size()][2];
        //runner iterating through the stack and storing it in a new array
        while (runner!= null) {
            row = runner.getItem().row ;
            col=runner.getItem().col;

            arr[c][0]=row;
            arr[c][1]=col;
            c++;
            runner=runner.getNext();
        }
        //printing the array in opposite order to get the right order of stack
        for(int i=arr.length-1;i>=1;i--) {
            System.out.print("["+arr[i][0]+","+ arr[i][1]+"]"+" --> ");

        }
        System.out.print("["+arr[0][0]+","+ arr[0][1]+"]");
    }
}


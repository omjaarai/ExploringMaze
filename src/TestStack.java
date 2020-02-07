import java.util.EmptyStackException;
public class TestStack { 
/*
 * main() checks if all runtests() is true
 * it prints "All tests passed!" if it is true.
 */
    public static void main(String[]args) {
        if(runTests()) {
            System.out.println("All tests passed!");
        }
    }
    /*
     * runTests() checks if all the methods are true or not.
     * it returns true if all of them are true
     * and returns false if even one of them is false and prints statements accordingly.
     */
    public static boolean runTests() {

        return testPush1()&&testPushFromEmpty()&&testPeek1()&&testPeekFromEmpty()
            &&testPop1()&&testPopFromEmpty()&&testContains1()&&testContainsFromEmpty()
            &&testConstructor1()&& testConstructor2();
    }
    /*
     *testConstructor1() creates a new object of MazeRunnerStack class and pushes 1 item(of Position data type) in it
     *if the top item's row and column is equal to the row and column specified by the item 
     *this method should return true, otherwise false and
     *prints "TestConstructor1 failed".
     */
    private static boolean testConstructor1()throws EmptyStackException {
        MazeRunnerStack testStack=new MazeRunnerStack();
        Position item1= new Position(20,10);
        testStack.push(item1);
        boolean result=(testStack.top.getItem().row ==20 &&testStack.top.getItem().col==10);
        if(!result)
            System.out.println("TestConstructor1 failed!");
        return result;
    }
    /*
     *testConstructor() creates a new object of class MazeRunnerStack and checks the if it contains null and it's size.
     *If an EmptyStackException is thrown, then the test passes and this test method returns
     *true. Otherwise,the following is printed:
     *“Failure: Failure: checking an empty stack”
     */
    private static boolean testConstructor2()throws EmptyStackException {
        MazeRunnerStack testStack=new MazeRunnerStack();
        boolean result=false;
        try {
            result=testStack.contains(null)&&testStack.size()==0;
        }
        catch(EmptyStackException e) {
            result=true;
        }
        if(!result)
            System.out.println("Failure: checking an empty stack!");
        return result;
    }
    /*
     *testPush1() creates a new stack and pushes 2 items(of Position data type) in it
     *if testStack contains all the items and the size is equal to 2
     *this method should return true, otherwise false and
     *prints "TestPush1 failed".
     */
    private static boolean testPush1()throws IllegalArgumentException  {
        MazeRunnerStack testStack= new MazeRunnerStack();
        Position item1= new Position(10,10);
        Position item2= new Position(5,5);
        testStack.push(item1);
        testStack.push(item2);

        boolean result= testStack.contains(item1)&&testStack.contains(item2)&& testStack.size()==2;
        if(!result)
            System.out.println("TestPush1 failed!");
        return result;
    }
    /*
     *testPushFromEmpty1() creates a new stack and (in a try block) and calls push(null).
     *If an IllegalArgumentException is thrown, then the test passes and this test method returns
     *true. Otherwise, the following is printed:
     *“Failure: push an empty object in the stack.”
     */
    private static boolean testPushFromEmpty() throws IllegalArgumentException {
        MazeRunnerStack testStack= new MazeRunnerStack();
        boolean result=false;
        try {
            testStack.push(null);
        }
        catch(IllegalArgumentException e) {
            result=true;
        }
        if(!result) {
            System.out.println("Failure: push an empty object in the stack!");
        }
        return result;
    }
    /*
     *testPeek1() creates a new stack and pushes 2 items(of Position data type) in it
     *testStack.peek() is called and the value returned by it is stored in a new variable t
     *if t is equal to the last item pushed
     *this method should return true, otherwise false and
     *prints "TestPeek1 failed".
     */
    private static boolean testPeek1() throws EmptyStackException {
        MazeRunnerStack testStack= new MazeRunnerStack();
        Position item1= new Position(10,10);
        Position item2= new Position(5,5);
        testStack.push(item1);
        testStack.push(item2);
        Position t=testStack.peek();
        boolean result=(t.equals(item2)&& testStack.size()==2); 
        if(!result)
            System.out.println("TestPeek1 failed!");
        return result;
    }
    /*
     *testPeekFromEmpty1() creates a new stack and (in a try block) immediately calls pop().
     *If an EmptyStackException is thrown, then the test passes and this test method returns
     *true. Otherwise, following is printed:
     *"Failure: Peek in an empty stack."
     */
    private static boolean testPeekFromEmpty() throws EmptyStackException {
        MazeRunnerStack testStack= new MazeRunnerStack();
        boolean result=false;
        //        testStack.push(null);
        //        testStack.push(null);
        try {
            result=testStack.peek()==null && testStack.size()==0;
        }
        catch(EmptyStackException e) {
            result=true;
        }
        if(!result)
            System.out.println("Failure: Peek in an empty stack!");
        return result;
    }
    /*
     *testPop1() creates a new stack and pushes two items(of Position data type) in it
     *pop() is called immediately, if the top item is equal to item1 and the initial size of the stack
     * is equal to the size of current stack, this method should return true, otherwise false and
     * prints "TestPop1 failed".
     */
    private static boolean testPop1() throws EmptyStackException {
        MazeRunnerStack testStack= new MazeRunnerStack();
        Position item1= new Position(10,10);
        Position item2= new Position(5,5);
        testStack.push(item1);
        testStack.push(item2);
        int size=testStack.size();
        testStack.pop();
        boolean result=testStack.top.getItem().equals(item1)&& testStack.size()==size-1;
        if(!result) {
            System.out.println("TestPop1 failed!");
        }
        return result;
    }
    /*
     *testPopFromEmpty1() creates a new stack and (in a try block) immediately calls pop().
     *If an EmptyStackException is thrown, then the test passes and this test method returns
     *true. Otherwise, the value pop() returned is saved and the following is printed:
     *“Failure: pop from an empty stack. Expected EmptyStackException. Got [returnedValue].”
     */
    private static boolean testPopFromEmpty() throws EmptyStackException {
        boolean result=false;
        MazeRunnerStack testStack= new MazeRunnerStack();
        try { 

            testStack.pop();
        }

        catch(EmptyStackException e) {
            result=true;

        }
        if(!result) {
            System.out.println("Failure: pop from an empty stack. "
                + "Expected EmptyStackException. Got ["+ testStack.pop()+"].”");
        }
        return result;



    }
    /*
     *testContains1() creates a new stack and pushes 4 items(of Position data type) in it
     *if testStack contains all the items and the size is equal to 4
     *this method should return true, otherwise false and
     *prints "TestContains1 failed".
     */
    private static boolean testContains1() {
        MazeRunnerStack testStack= new MazeRunnerStack();
        Position item1= new Position(10,10);
        Position item2= new Position(5,5);
        Position item3= new Position(2,2);
        Position item4= new Position(1,1);
        testStack.push(item1);
        testStack.push(item2);
        testStack.push(item3);
        testStack.push(item4);
        boolean result= (testStack.contains(item1)&&testStack.contains(item2)&&
            testStack.contains(item3)&&testStack.contains(item4)&& testStack.size()==4);
        if(!result)
            System.out.println("TestContains1 failed!");
        return result;
    }
    /*
     *testContainsFromEmpty1() creates a new stack and (in a try block) and calls testStack.contains(null).
     *If an EmptyStackException is thrown, then the test passes and this test method returns
     *true. Otherwise, following is printed:
     *"Failure: contains() in an empty stack."
     */
    private static boolean testContainsFromEmpty()throws EmptyStackException {
        MazeRunnerStack testStack= new MazeRunnerStack();
        boolean result=false;
        try {
            result=testStack.contains(null)&& testStack.size()==0;
        }
        catch(EmptyStackException e) {
            result=true;

        }
        if(!result) {
            System.out.println("Failure: contains() in an empty stack."); 
        }
        return result;


    }
}

////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title:           Exploring a Maze
//Files:           none
//Course:          CS 300 spring 2018
//
//Author:          Omjaa Rai
//Email:           orai@wisc.edu
//Lecturer's Name: Mouna Ayari Ben Hadj Kacem
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//Partner Name:
//Partner Email:
//Lecturer's Name:
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//__ Write-up states that pair programming is allowed for this assignment.
//__ We have both read and understand the course Pair Programming Policy.
//__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
//Students who get help from sources other than their partner must fully
//acknowledge and credit those sources of help here.  Instructors and TAs do
//not need to be credited here, but tutors, friends, relatives, room mates
//strangers, etc do.  If you received no outside help from either type of
//source, then please explicitly indicate NONE.
//
//Persons:         none
//Online Sources:  none
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class Maze { //class starts
    MazeRunnerStack path=new MazeRunnerStack(); //mazeRunnerStack class object
    Boolean solved=false;       // boolean to check is the maze is solved or not
    private char[][] mazeInfo;  //maze specified by the user
    private static char[][] maze;//maze to be displayed
    private static Position start;//start position object
    private static Position finish;// finish object position
    private char orientation= 'R';//orientation variable to check the orientation
    public Maze(char[][]mazeInfo) {//parameterized constructor
        this.mazeInfo=mazeInfo;
        maze=new char[mazeInfo.length*2+1][mazeInfo[0].length*4+1];
    }


    public static void main(String[]args) {//main function
        char[][] mazeInfo= {{'L','.','|'},{'L','_','_'}};//initializing the maze mazeInfo
        Maze testMaze= new Maze(mazeInfo); //creating a new maze to be displayed
        testMaze.setStart(0,0);//set start position
        testMaze.setFinish(0,2);//set finish position
        testMaze.solveMaze();//solveMaze is called to solve the maze
        testMaze.displayMaze();//maze is displayed with the solution

    }
    public void solveMaze() {
        int stepCount=0;//to check is there is no solution to a maze
        path = new MazeRunnerStack();// new stack
        path.push(start);//start position is stored in the stack
        Position currentPosition = new Position(start.row, start.col);//currentPosition is set to start position
        //loop to check if the maze is solved and the number of steps is more than(row*col*4), if not keep iterating
        while (solved != true && stepCount < mazeInfo.length * mazeInfo[0].length * 4) {
            //checks the orientation
            switch(orientation) {
                //if orientation is left
                case 'L':
                    if(currentPosition.row != 0 && mazeInfo[currentPosition.row - 1][currentPosition.col] != 'L' && mazeInfo[currentPosition.row - 1][currentPosition.col] != '_') 
                        orientation = 'U';
                    else if(currentPosition.col != 0 && mazeInfo[currentPosition.row][currentPosition.col] != 'L' && mazeInfo[currentPosition.row][currentPosition.col] != '|') 
                        orientation = 'L';
                    else if(currentPosition.row != mazeInfo.length - 1 && mazeInfo[currentPosition.row][currentPosition.col] != 'L' && mazeInfo[currentPosition.row][currentPosition.col] != '_') 
                        orientation = 'D';
                    else if(currentPosition.col != mazeInfo[0].length - 1 && mazeInfo[currentPosition.row][currentPosition.col + 1] != 'L' && mazeInfo[currentPosition.row][currentPosition.col + 1] != '|') 
                        orientation = 'R';
                    break;
                    //if orientation is right
                case 'R': 
                    if(currentPosition.row != mazeInfo.length - 1 && mazeInfo[currentPosition.row][currentPosition.col] != 'L' && mazeInfo[currentPosition.row][currentPosition.col] != '_') 
                        orientation = 'D';
                    else if(currentPosition.col != mazeInfo[0].length - 1 && mazeInfo[currentPosition.row][currentPosition.col + 1] != 'L' && mazeInfo[currentPosition.row][currentPosition.col + 1] != '|') 
                        orientation = 'R';
                    else if(currentPosition.row != 0 && mazeInfo[currentPosition.row - 1][currentPosition.col] != 'L' && mazeInfo[currentPosition.row - 1][currentPosition.col] != '_') 
                        orientation = 'U';
                    else if(currentPosition.col != 0 && mazeInfo[currentPosition.row][currentPosition.col] != 'L' && mazeInfo[currentPosition.row][currentPosition.col] != '|') 
                        orientation = 'L';
                    break;
                    //if orientation is straight
                case 'U': 
                    if(currentPosition.col != mazeInfo[0].length - 1 && mazeInfo[currentPosition.row][currentPosition.col + 1] != 'L' && mazeInfo[currentPosition.row][currentPosition.col + 1] != '|') 
                        orientation = 'R';
                    else if(currentPosition.row != 0 && mazeInfo[currentPosition.row - 1][currentPosition.col] != 'L' && mazeInfo[currentPosition.row - 1][currentPosition.col] != '_') 
                        orientation = 'U';
                    else if(currentPosition.col != 0 && mazeInfo[currentPosition.row][currentPosition.col] != 'L' && mazeInfo[currentPosition.row][currentPosition.col] != '|') 
                        orientation = 'L';
                    else if(currentPosition.row != mazeInfo.length - 1 && mazeInfo[currentPosition.row][currentPosition.col] != 'L' && mazeInfo[currentPosition.row][currentPosition.col] != '_') 
                        orientation = 'D';
                    break;
                    //if orientation is down
                case 'D': 
                    if(currentPosition.col != 0 && mazeInfo[currentPosition.row][currentPosition.col] != 'L' && mazeInfo[currentPosition.row][currentPosition.col] != '|') 
                        orientation = 'L';
                    else if(currentPosition.row != mazeInfo.length - 1 && mazeInfo[currentPosition.row][currentPosition.col] != 'L' && mazeInfo[currentPosition.row][currentPosition.col] != '_') 
                        orientation = 'D';
                    else if(currentPosition.col != mazeInfo[0].length - 1 && mazeInfo[currentPosition.row][currentPosition.col + 1] != 'L' && mazeInfo[currentPosition.row][currentPosition.col + 1] != '|') 
                        orientation = 'R';
                    else if(currentPosition.row != 0 && mazeInfo[currentPosition.row - 1][currentPosition.col] != 'L' && mazeInfo[currentPosition.row - 1][currentPosition.col] != '_') 
                        orientation = 'U';
                    break;
            }

            //if final orientation is left, change the current position to (row, col-1)
            if(orientation== 'L') { 
                currentPosition = new Position(currentPosition.row, currentPosition.col - 1);
            }

            //else if final orientation is straight, change the current position to (row-1, col)         
            else if(orientation== 'U') {
                currentPosition = new Position(currentPosition.row - 1, currentPosition.col);

            }
            //else if final orientation is right, change the current position to (row, col+1)
            else if(orientation== 'R') {
                currentPosition = new Position(currentPosition.row, currentPosition.col + 1);

            }
            //else if final orientation is down, change the current position to (row+1, col)
            else if(orientation== 'D') {
                currentPosition = new Position(currentPosition.row + 1, currentPosition.col);

            }
            //if stack already contains currentPosition,remove it from the stack
            if (path.contains(currentPosition)) 
                while(!path.peek().equals(currentPosition))
                    path.pop();
            //else add the currentPosition to the stack
            else 
                path.push(currentPosition);
            //checks if currentPosition is equal to the final position
            if(currentPosition.equals(finish)) 
                solved = true;
            stepCount++;
        }

        if(solved==false) {
            System.out.println("No solution could be found.");
        }


    }
    public void setStart(int row, int column) {
        start= new Position(row,column);//start position
    }
    public void setFinish(int row, int column) {
        finish=new Position(row,column);//finish position
    }
    public void displayMaze() {
        //if the maze is solved print "solution is"
        if(solved)
            System.out.println("Solution is:");
        //creating the maze boundaries
        for(int i=0; i< maze.length;i++) {
            for(int j=0;j< maze[i].length;j++) {
                maze[i][j]=' ';
                if(i==0)
                    maze[i][j]='-';
                if(j%4==0&& i%2==0)
                    maze[i][j]='+';
                if(i%2==1&&(j==0||j==maze[i].length-1))
                    maze[i][j]='|';
            }
        }
        //creates maze array from mazeInfo to be displayed
        for(int i=0;i<mazeInfo.length;i++) {
            for(int j=0; j< mazeInfo[i].length;j++) {
                if(mazeInfo[i][j]=='L') {
                    maze[2*i+1][4*j]='|';
                    for(int dashes=1; dashes<4; dashes++) {
                        maze[2*i+2][4*j+dashes]='-';
                    }
                }
                if(mazeInfo[i][j]=='|')
                    maze[2*i+1][4*j]='|';

                if(mazeInfo[i][j]=='_') {
                    for(int dashes=1; dashes<4; dashes++) {
                        maze[2*i+2][4*j+dashes]='-';
                    }
                }
            }
        }
        
        if(start!=null&& finish!=null) {
            //if maze is solved, set all the positions in the stack to '*'
            if(solved) {
                ListNode<Position> runner = path.top;
                Position s;
                while (runner!= null) {

                    s = runner.getItem() ;
                    maze[s.row*2+1][s.col*4+2]='*';
                    runner = runner.getNext();
                }
            }
            //set the start and finish positions back to 'S' and 'F'
            maze[2*start.row+1][4*start.col+2]='S';
            maze[2*finish.row+1][4*finish.col+2]='F';

        }
        //printing the array maze(displaying the maze)
        for(int i=0; i<maze.length;i++) {
            for(int j=0;j<maze[i].length;j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        //printing the path, uses display method in MazeRunnerStack class
        if(solved) {
            System.out.print("Path is: ");
            path.display();
        }
    }
}



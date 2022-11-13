import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class MazeMaker {
    //todo future George's problem once the actual game mechanics work
    /*
    Genreral Algorithm
       create a nxn int[][]
       0==path 1 == wall , 2 == start, 3 = end point, 4 == empty
       set up the array: all the outermost edges need to be walls for preventing out of bounds exceptions later
       The inside will be a grid of emptys separated by walls.


       1.pick a starting point, make it a 4
       2. randomly pick one of its neighbors that's a 4 (these will be separated by wall)
       3. go to the neighbor. make it and the wall between them a 4.
       4. repeat 3 until the current spot has no neighbors. (mark as a potential end point)
       5. backtrack until you get to a spot with still empty neighbors
       6. repeat 2-5 until all empty spots are gone.
       7. Pick random endpoints from the potential end point list.

       return the array.

     */


    // class to host the functions that creates random mazes of designated size


    private static int[][] intitArray(int rows , int cols) {
        //todo make a intial array of dimension (xD,yD)
        /*
        all edges are walls, and every empty is surrounded by walls
        looks like{1,1,1,1,1},
                  {1,4,1,4,1},
                  {1,1,1,1,1},
                  {1,4,1,4,1},
                  {1,1,1,1,1}
         */
        //rows and cols need to be odd numbers
        if (rows%2 == 0){ rows++;}
        if(cols%2 == 0){cols++;}

        int[][] init =  new int[rows][cols];

        for (int x = 0; x< rows; x++) {
            for (int y = 0; y < cols; y++) {

                if( x%2 != 0 && y%2 != 0){ //if both x and y are odd then 4
                    init[x][y] = 4;
                }else{ // make the rest walls
                    init[x][y] = 1;
                }
            }
        }
        return init;
    }

    private static int[][] depthFS(int[][] intit){

        //starting point
        Point start = new Point(0,1);
        Point cur , next;
        cur = new Point(start.x +1 ,1);

        //depth first search using stacks
        Stack<Point> visited = new Stack<>();
        visited.push(cur);
        while( !visited.isEmpty()){

            intit[cur.x][cur.y] = 0; // make the current spot a path.
            next = getNext(cur, intit); //returns null or a point

            if( next != null){ //next is a point to go to

                //make the inbetween the points spot a path
                int xPath = (cur.x + next.x) /2;
                int yPath = (cur.y + next.y) /2;
                intit[xPath][yPath] = 0;

                //go to that point
                cur = next;

                //add it to the list
                visited.push(cur);
            }else{ //if there are no neighbors, make the current the previus tile
                //System.out.println("you reached the end of a branch");
                cur = visited.pop();
            }


        }

        intit[start.x][start.y] = 2; // set the start to a green square
        intit[intit.length-1][intit[0].length -2] = 3; // make the bottom the finish

        return intit;
    }
    private static Point getNext(Point cur, int[][] maze){
        //return the next point
        //the next point is 2 squares away

        //todo come up with something clever to deal with out of bounds exceptions

        //4 points
        Point up = new Point(cur.x -2, cur.y);
        Point down = new Point(cur.x +2 , cur.y);
        Point left = new Point(cur.x, cur.y-2);
        Point right = new Point(cur.x, cur.y+2);

        Point[] theoretical = {up,down,left,right};
        ArrayList<Point> actual = new ArrayList<>();

        // logic bby

        for (Point n:theoretical) {
            if(n.x >=1 && n.y >= 1 && n.x<= maze.length-1 && n.y <= maze[0].length-1){ // out of bounds
                if (maze[n.x][n.y] != 0) { // if we have already been here
                    actual.add(n);
                }
            }
        }

        //if there are actual neighbors return one of them
        if (actual.size() > 0){
            Collections.shuffle(actual);
            return actual.get(0);
        }else{
            return null;
        }

    }



    public int[][] runMaker(int rows, int cols){
        //call the methods
        int[][] a = intitArray(rows,cols);
        return depthFS(a);
    }

    public static void main(String[] args) {
        int[][] a = intitArray(100,100);


/*
        for (int x = 0; x< 11; x++) {
            for (int y = 0; y < 13; y++) {
                System.out.print(a[x][y] + " ");
            }
            System.out.println();
        }
*/


        int[][]maze = depthFS(a);;
        for (int x = 0; x< 101; x++) {
            for (int y = 0; y < 101; y++) {
                System.out.print(maze[x][y] + " ");
            }
            System.out.println();
        }
    }
}

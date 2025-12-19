//allPath function shows all possible ways to reach to the target
//basicBacktrack shows the most basic way to backtrack

public class Basic_Backtrack {
    public static void main(String[] args){
        boolean[][] maze={
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
//        allPath("",maze,0,0);
        basicBacktrack("",maze,0,0);

    }
    static void allPath(String p,boolean[][] maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]) return;
        maze[r][c] = false;

        if(r< maze.length-1){
            allPath(p+'D',maze,r+1,c);
        }
        if(c< maze[0].length-1){
            allPath(p+'R',maze,r,c+1);
        }
        if(r>0){
            allPath(p+'U',maze,r-1,c);
        }
        if(c>0){
            allPath(p+'L',maze,r,c-1);
        }

    }

    static void basicBacktrack(String p,boolean[][] maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]) return; //false,so leave this path as it is and quit
        maze[r][c] = false;

        if(r< maze.length-1){
            basicBacktrack(p+'D',maze,r+1,c);
        }
        if(c< maze[0].length-1){
            basicBacktrack(p+'R',maze,r,c+1);
        }
        if(r>0){
            basicBacktrack(p+'U',maze,r-1,c);
        }
        if(c>0){
            basicBacktrack(p+'L',maze,r,c-1);
        }
        maze[r][c] = true;

    }
    //please watch the tutorial to print steps in the matrix after completing recursion in arrays video and
    //also understand this->The variables in the arguments that are not objects (primitives) are unique for every recursive call—they exist independently in each call stack frame. Arrays or objects that are passed, however, are shared references, so any modification in one recursive call affects the original object. That’s why in backtracking we need to undo changes (reset) to allow other recursive paths to explore correctly.”
}

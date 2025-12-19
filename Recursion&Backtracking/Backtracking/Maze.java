import java.util.*;

public class Maze {

    // PRINT all valid paths
    public static void pathRestrictions(String p, boolean[][] maze, int r, int c) {

        // If blocked, stop
        if (!maze[r][c]) {
            return;
        }

        // Reached destination
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        // Down
        if (r < maze.length - 1) {
            pathRestrictions(p + "V", maze, r + 1, c);
        }

        // Right
        if (c < maze[0].length - 1) {
            pathRestrictions(p + "H", maze, r, c + 1);
        }

        // Diagonal
        if (r < maze.length - 1 && c < maze[0].length - 1) {
            pathRestrictions(p + "D", maze, r + 1, c + 1);
        }
    }

    // COUNT all valid paths
    public static int countPaths(boolean[][] maze, int r, int c) {

        // If blocked, no paths
        if (!maze[r][c]) {
            return 0;
        }

        // Destination reached
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            return 1;
        }

        int count = 0;

        // Down
        if (r < maze.length - 1) {
            count += countPaths(maze, r + 1, c);
        }

        // Right
        if (c < maze[0].length - 1) {
            count += countPaths(maze, r, c + 1);
        }

        // Diagonal
        if (r < maze.length - 1 && c < maze[0].length - 1) {
            count += countPaths(maze, r + 1, c + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        boolean[][] board = {
                {true,  true,  true},
                {true,  false, true}, // obstacle at (1,1)
                {true,  true,  true}
        };

        System.out.println("Paths:");
        pathRestrictions("", board, 0, 0);

        System.out.println("\nTotal paths: " + countPaths(board, 0, 0));
    }
}

// static int count(int r, int c) {
//     // Base case
//     if (r == 1 || c == 1) {
//         return 1;
//     }

//     // Recursive calls
//     int down = count(r - 1, c);
//     int right = count(r, c - 1);

//     return down + right;
// }

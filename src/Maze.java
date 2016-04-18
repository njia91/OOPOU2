
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by dv15man on 2016-04-11
 */
public class Maze {

    private char[][] maze;
    //private position start;


    /**
     *
     * @param file reference to the file were the maze is stored.
     * @throws IOException if somethings wrong with file.
     */
    public Maze(java.io.Reader file) throws IOException{

        BufferedReader buffer = new BufferedReader(file);
        Queue<String> queue = new LinkedList<String>();
        String line;
        int lineNr = 0;
        int lineSize = 0;
        int i;
        int lineIndex = 0;



        // Read the file and stores each line in an queue.
        while((line = buffer.readLine()) != null){
            if (lineSize < line.length()){
                lineSize = line.length();
            }
            queue.add(line);
            lineNr++;
        }



        maze = new char[lineNr][lineSize];

        // Merging the lines from the file to the maze array.
        while ((line = queue.poll()) != null){
            i = 0;

            while (i < line.length()){
                maze[lineIndex][i] = line.charAt(i);
                i++;
            }
            i = 0 ;
            lineIndex++;
        }

        for (char[] row: maze){
            for (char column: row){
                System.out.print(column);
               // start = new Position(row,column);
            }

        }







    }

  //  public boolean  IsMovable(Position p){

  //  }

  //  public boolean isGoal(Position p){

  //  }

  //  public Position getStartPosition(){

   // }
}

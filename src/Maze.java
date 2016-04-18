
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by dv15man on 2016-04-11
 */
public class Maze {

    private char[][] maze;


    /**
     *
     * @param file reference to the file were the maze is stored.
     * @throws IOException if somethings wrong with file.
     */
    public Maze(java.io.Reader file) throws IOException{
        BufferedReader buffer = new BufferedReader(file);
        Queue<String> queue = new LinkedList<Sting>();
        String line;
        int lineNr = 0;
        int lineSize = 0;

        // Read the file and stores each line in an queue.
        while((line = buffer.readLine()) != null){
            if (lineSize < line.length()){
                lineSize = line.length();
            }
            queue.add(line);
            lineNr++;
        }


        maze = new char[lineNr][lineSize];







    }

  //  public boolean  IsMovable(Position p){

  //  }

  //  public boolean isGoal(Position p){

  //  }

  //  public Position getStartPosition(){

   // }
}

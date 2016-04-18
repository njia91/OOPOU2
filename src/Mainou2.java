
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 * Created by dv15man on 2016-04-18.
 */
public class Mainou2 {

    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            FileReader stream = new FileReader(file);
            Maze maze = new Maze(stream);
        }
        catch(Exception e){
            System.out.println("Something wrong with input file!");

            System.exit(0);
        }





    }
}

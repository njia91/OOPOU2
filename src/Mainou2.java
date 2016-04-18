
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 * Created by dv15man on 2016-04-18.
 */
public class Mainou2 {

    public static void main(String[] args) {
        try {
            File file = new File(args[0])
            FileReader fileReader = new FileReader(file);
        }
        catch(NullPointerException e){
            if(!file.exists()){
                System.out.println(args[0] + "does not exist!");
            }
            System.exit(0);
        }

        Maze maze = new Maze(file);



    }
}

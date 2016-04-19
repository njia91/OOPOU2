import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dv15man on 2016-04-18.
 */
public class MazeTest {

    @Test
    public void shouldReadCorrectMaze() throws Exception{
           File file = new File("mazetest");
           FileReader stream = new FileReader(file);
           Maze maze = new Maze(stream);

    }

    @Test (expected = IOException.class)
    public void shouldReadInvalidMazeNoGoal() throws Exception{

            File file = new File("mazetest2");
            FileReader stream = new FileReader(file);
            Maze maze = new Maze(stream);
    }

    @Test (expected = IOException.class)
    public void shouldReadInvalidMazeMultipleStart() throws Exception{

        File file = new File("mazetest3");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
    }

    @Test
    public void shouldReadCorrectMazeMultipleGoals() throws Exception{
        File file = new File("mazetest4");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);

    }

}

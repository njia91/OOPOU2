import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dv15man on 2016-04-18.
 */
public class MazeTest {
    /**
     * Tests if Maze can read a correct maze from file.
     * @throws Exception
     */
    @Test
    public void shouldReadCorrectMaze() throws Exception{
           File file = new File("mazetest");
           FileReader stream = new FileReader(file);
           Maze maze = new Maze(stream);

    }

    /**
     * Tests that Maze throws an exception if no start position in maze.
     * @throws Exception
     */
    @Test (expected = IOException.class)
    public void shouldReadInvalidMazeNoStart() throws Exception{

            File file = new File("mazetest2");
            FileReader stream = new FileReader(file);
            Maze maze = new Maze(stream);
    }

    /**
     * Tests that Maze throws an exception if no goal in maze.
     * @throws Exception
     */
    @Test (expected = IOException.class)
    public void shouldReadInvalidMazeNoGoal() throws Exception{

        File file = new File("mazetest5");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
    }

    /**
     * Tests that Maze throws an exception if multiple start position maze.
     * @throws Exception
     */
    @Test (expected = IOException.class)
    public void shouldReadInvalidMazeMultipleStart() throws Exception{

        File file = new File("mazetest3");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
    }

    /**
     * Tests that Maze throws an exception if multiple start position maze.
     * @throws Exception
     */
    @Test
    public void shouldReadCorrectMazeMultipleGoals() throws Exception{
        File file = new File("mazetest4");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);

    }

}

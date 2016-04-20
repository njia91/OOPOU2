import org.junit.Test;

import java.io.File;
import java.io.FileReader;

/**
 * Created by dv15man.
 */
public class RightHandRuleRobotTest {


    @Test
    public void shouldCreateARightHandRobot() throws Exception{
        File file = new File("robotTest1");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
        RightHandRuleRobot robbie = new RightHandRuleRobot(maze);
    }

    @Test(expected = IllegalStateException.class)
    public void robotShouldbeBoxedIn() throws Exception{
        File file = new File("robotTest1");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
        RightHandRuleRobot robbie = new RightHandRuleRobot(maze);
        robbie.move();
    }

    @Test
    public void robotShouldNotbeBoxedIn() throws Exception{
        File file = new File("robotTest2");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
        RightHandRuleRobot robbie = new RightHandRuleRobot(maze);
        robbie.move();
    }


}

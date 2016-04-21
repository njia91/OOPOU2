import java.io.File;
import java.io.FileReader;

/**
 * Created by dv15man on 2016-04-20.
 */
public class RobotRace {

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                //int stepCounterRightHandRobot = 0;
                int stepCounterMemoryRobot = 0;
                File file = new File(args[0]);
                FileReader stream = new FileReader(file);

                Maze maze=new Maze(stream);
                //RightHandRuleRobot robbie = new RightHandRuleRobot(maze);
                MemoryRobot bobbie = new MemoryRobot(maze);


                int i = 0;
                //while (!maze.isGoal(robbie.getCurrentPosition())) {
                 //   robbie.move();
                 //   stepCounterRightHandRobot++;



                 //   i++;
                //}

                while(!maze.isGoal(bobbie.getCurrentPosition())){
                    bobbie.move();
                    stepCounterMemoryRobot++;
                }

                System.out.println("Steps for right handed robot: " +
                        stepCounterMemoryRobot);

                //System.out.println("Steps for right handed robot: " +
                //stepCounterRightHandRobot);

            } catch (Exception e) {
                System.err.println(e);
            }



        }
        else{
            System.err.println("Invalid program parameters.");
        }

    }
}

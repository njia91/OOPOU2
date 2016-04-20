import java.io.File;
import java.io.FileReader;

/**
 * Created by dv15man on 2016-04-20.
 */
public class RobotRace {

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                int stepCounterRightHandRobot = 0;
                File file = new File(args[0]);
                FileReader stream = new FileReader(file);
                Maze maze=new Maze(stream);

                RightHandRuleRobot robbie = new RightHandRuleRobot(maze);
                int i = 0;
                while ( i <10) {
                    robbie.move();
                    stepCounterRightHandRobot++;
                    System.out.println("Steps for right handed robot: " +
                            stepCounterRightHandRobot);
                    i++;
                }

                System.out.println("Steps for right handed robot: " +
                        stepCounterRightHandRobot);

            } catch (Exception e) {
                System.out.println("Something wrong with input file!");
                System.exit(0);
            }



        }
        else{
            throw new IllegalArgumentException("Invalid program parameters.");
        }

    }
}

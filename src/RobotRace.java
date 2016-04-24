import java.io.File;
import java.io.FileReader;

/**
 * Created by dv15man.
 *
 * This is a small test program to find out which robot navigates a
 * maze in the shortest time!
 *
 * One robot follows the Right wall all the time untill
 * it can find the goal.
 * The other robot uses a depth-first-search to find the goal.
 */
public class RobotRace {

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                int stepCounterRightHandRobot = 0;
                int stepCounterMemoryRobot = 0;
                boolean didRobbieFindTheGoal = true;
                File file = new File(args[0]);
                FileReader stream = new FileReader(file);
                Maze maze=new Maze(stream);

                RightHandRuleRobot robbie = new RightHandRuleRobot(maze);
                MemoryRobot bobbie = new MemoryRobot(maze);


                //The robots conducts the race one at a time!
                while (!robbie.hasReachedGoal() && didRobbieFindTheGoal) {

                        try {
                            robbie.move();
                        } catch (Exception e) {
                            System.err.println(e);
                            didRobbieFindTheGoal = false;
                        }
                        stepCounterRightHandRobot++;
                }

                while(!bobbie.hasReachedGoal()){
                    try {
                        bobbie.move();
                    }
                    catch(Exception e){
                        System.err.println(e);
                    }
                        stepCounterMemoryRobot++;

                }


                System.out.println("Steps for MemoryRobot robot: " +
                        stepCounterMemoryRobot);
                System.out.println("Steps for RightHandRuleRobot: " +
                        stepCounterRightHandRobot);

                if (stepCounterMemoryRobot < stepCounterRightHandRobot ||
                        !didRobbieFindTheGoal){
                    System.out.println("\nMemoryRobot WON!!");
                }
                else if (stepCounterMemoryRobot > stepCounterRightHandRobot){
                    System.out.println("\nRightHandRuleRobot WON!!");
                }
                else {
                    System.out.println("It is a TIE!");
                }


            } catch (Exception e) {
                System.err.println(e);
            }

        }
        else{
            System.err.println("Invalid program parameters.");
        }

    }
}

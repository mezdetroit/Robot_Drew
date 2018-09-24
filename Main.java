package first.team815.robotics;

public class Main
{
	 static long start = System.currentTimeMillis();
	 
	public static void main(String[] args)
	{
		Robot robot = new Robot();	//make our robot to use the Class Robot (object)
		
		robot.autonomousInit();
		
		start = System.currentTimeMillis();

		while (getDuration() < 15000) {	//time autonomous
		robot.autonomousPeriodic();
		}
		printDuration("Auton Periodic is done: ");
		
		robot.teleopInit();
		
		start = System.currentTimeMillis();	
		while(getDuration() < 120000) {	//time teleop = 120 sec
			printDuration("Telop time:");
			robot.teleopPeriodic();	
		}
		printDuration("Teleop Periodic is done:");
		
		robot.robotDisabled();//disable the robot
		
	}
	public static long getDuration() {	//time Teleop
		return System.currentTimeMillis() - start;
	}
	public static void printDuration(String str) {
		System.out.println(str + " " + getDuration()/1000 + "." + getDuration()%1000 + " sec");
	}

}

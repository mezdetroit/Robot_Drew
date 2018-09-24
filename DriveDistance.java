package first.team815.robotics;

public class DriveDistance {
	
	public static void driveDistance(double distance) {
		//print out how long it will drive and how far it traveled
		double speed = Robot.driveTrain.getSpeed();
		System.out.println("Distance: " + distance);
		System.out.println("Speed: " + speed);	//Robot since Robot is now static
		double time = distance / speed;
		System.out.println("Time: " + time);
	}
	
}

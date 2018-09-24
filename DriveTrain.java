package first.team815.robotics;

public class DriveTrain {
	
	private double speed;		//speed is a member variable only available in this class
	
	//constructors
	public DriveTrain() {
		speed = 1;
	}
	public DriveTrain(double speedIn) {
		this.speed = speedIn;
		// speed = speedIn;
	}
	public double getSpeed() {
		return speed;
	}
	
}

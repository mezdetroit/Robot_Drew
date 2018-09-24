package first.team815.robotics;

public class Elevator {
	
	private boolean isElevatorUp;
	private boolean isElevatorDown;
	private boolean isElevatorMovingUp;
	private boolean isElevatorMovingDown;
	private double elevatorSpeed;		//+ = going UP; - = going DOWN

/*
 * 	
 */
	public Elevator() {	//elevator constructor  constructor should NOT have void and be Pascal case
		isElevatorDown = false;	//elevator is not down
		isElevatorUp = false;	//elevator is not up
		elevatorSpeed = 0.0;		//elevator is NOT moving
	}
		public void lowerElevator() {	//lower the elevator
		isElevatorUp = false;	//elevator is NOT UP
		isElevatorDown = false;	//elevator is NOT DOWN
		elevatorSpeed = -0.5;	//DOWN at 50% speed
	}
	public void raiseElevator() {	//raise the elevator
		isElevatorDown = false;	//elevator is NOT DOWN
		isElevatorUp = false;	//elevator is NOT UP
		elevatorSpeed = +0.5;	//UP at 50% speed
	}
	public void stopElevator() {
		elevatorSpeed = 0.0;
	}
	public void changeElevatorSpeed(double incrementSpeed) {
		double newSpeed = elevatorSpeed + incrementSpeed;	//will + or minus the speed by the sent delta
		if(newSpeed > 1.0) elevatorSpeed = 1.0;
		else if(newSpeed <-1.0) elevatorSpeed = -1.0;
		else elevatorSpeed = newSpeed;
	}
/*
 * 
 */
	public boolean isElevatorUp()	{
		return isElevatorUp;
	}
	public boolean isElevatorDown()	{
		return isElevatorDown;
	}

	public double elevatorSpeedIs() {
		return elevatorSpeed;
	}
	public boolean isElevatorMovingUp()	{
		return elevatorSpeed > 0.0 ? true: false;	//if speed > 0 elevator is going UP
	}
	public boolean isElevatorMovingDown()	{
		return elevatorSpeed < 0.0 ? true: false;	//if speed < 0 elevator is going DOWN
	}
	public void setElevatorUp(boolean elevatorIsUp)	{
		this.isElevatorUp = elevatorIsUp;
		this.isElevatorDown = false;
		if(elevatorIsUp && elevatorSpeed > 0.0) elevatorSpeed = 0.0;	//stop the elevator if being told the elevator is up
	} 
	public void setElevatorDown(boolean elevatorIsDown)	{
		this.isElevatorDown = elevatorIsDown;
		this.isElevatorUp = false;
		if(elevatorIsDown && elevatorSpeed < 0.0) elevatorSpeed = 0.0;	//stop the elevator if being told the elevator is down
	} 	
}

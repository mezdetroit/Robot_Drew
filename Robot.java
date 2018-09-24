package first.team815.robotics;

import java.util.Scanner;

public class Robot {	//robot contains member functions of Robot
	
	//DriveTrain driveTrain = new DriveTrain();	//give our robot a drive train
	static DriveTrain driveTrain;	//will initialize in autonInit()
	static Claw claw;
	static Elevator elevator;
	static Decode decode;
	Scanner keyboard = new Scanner(System.in);
	private String[] auton = {"cc","r","iemu","+","wait","su","stop","oc","sco"};
	private int autonStep = 0;	//step that autonomous is executing
	
	public void autonomousInit() {
		System.out.println("Auto Init");
//		int autonStep = 0;	//step that autonomous is executing
		claw =  new Claw();
		elevator = new Elevator();
//		elevator.elevator();
		decode = new Decode();
//		decode.decode();
	}
	
	public void autonomousPeriodic() {
		System.out.println("Auto Periodic");
		driveTrain = new DriveTrain(5);	//set speed to 5
		DriveDistance.driveDistance( 15);	//set distance to 15
//		for(int i=0; i<auton.length -1; i++) 
		if(autonStep < auton.length) {
			String in = auton[autonStep];
			if(decode.decodeCommand(in)) {
				performCommand(in);
				if(in != "wait") motionTime(2000);	//used to slow down the listing
				autonStep++;	//next step
			}
		}
	}
	
	public void teleopInit() {
			System.out.println("Teleop Init");
	}
	
	public void teleopPeriodic() {
			System.out.print("Enter command: ");
			String input = keyboard.nextLine();
			if(decode.decodeCommand(input)) {
				performCommand(input);
		}
	}
	public void robotDisabled() {
		elevator.changeElevatorSpeed(-elevator.elevatorSpeedIs());	//stop robot
		documentCommand("Robot is Disabled");
	}
	public void performCommand(String input) {
		switch(input) {
		case "r": elevator.raiseElevator();documentCommand(input);break;
		case "l": elevator.lowerElevator();documentCommand(input);break;
		case "ieu": elevator.isElevatorUp();documentCommand(input);break;
		case "ied": elevator.isElevatorDown();documentCommand(input);break;
		case "iemu": elevator.isElevatorMovingUp(); documentCommand(input);break;
		case "iemd": elevator.isElevatorMovingDown();documentCommand(input);break;
		case "su": elevator.setElevatorUp(true);documentCommand(input);break;
		case "sd": elevator.setElevatorDown(true);documentCommand(input);break;
		case "+": elevator.changeElevatorSpeed(0.1);documentCommand(input);break;
		case "-": elevator.changeElevatorSpeed(0.1);documentCommand(input);break;
		case "stop": elevator.changeElevatorSpeed(-elevator.elevatorSpeedIs());documentCommand(input);break;
		case "speed": documentCommand(input);break;
		case "cc": claw.close();documentCommand(input);break;
		case "oc": claw.open();documentCommand(input);break;
		case "ico": claw.isOpen();documentCommand(input);break;
		case "icc": claw.isClosed();documentCommand(input);break;
		case "sco": claw.setOpen(true);documentCommand(input);break;
		case "scc": claw.setClosed(true);documentCommand(input);break;
		case "wait": motionTime(2000);documentCommand(input);break;
		default: System.out.println(input + "Command NOT implemented");
		}	//end switch
	}
	public void documentCommand(String str) {
			clawStatus(str);
			elevatorStatus(str);
	}
	public void elevatorStatus(String str) {
	//	System.out.println(str);
		System.out.println("Elevator Speed: " + elevator.elevatorSpeedIs());
		System.out.println("Elevator is: " + "Moving UP? " + elevator.isElevatorMovingUp() + " Moving DOWN? " + elevator.isElevatorMovingDown());
		System.out.println("Elevator is: " + "       UP? " + elevator.isElevatorUp() + "        DOWN? " + elevator.isElevatorDown());
	}
	public void clawStatus(String str) {
		System.out.println("Claw is Open? " + claw.isOpen() + "   Is Claw Closed? " + claw.isClosed());
	}
	public void motionTime(long delay) {
		long end = delay + System.currentTimeMillis();
		System.out.println("Wait time: " + delay/1000 + "." + delay%1000);
		while(System.currentTimeMillis() <= end) {	//loop until current time is >= end time
			
		}
	}

}

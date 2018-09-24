package first.team815.robotics;

import java.util.HashMap;

public class Decode 
{

	HashMap<String, String> orders = new HashMap<>();
	
	public Decode() {
		orders.put("r","Raise Elevator ");
		orders.put("l","Lower Elevator ");
		orders.put("ieu","Is Elevator UP? ");
		orders.put("ied","Is Elevator DOWN? ");
		orders.put("iemu","Is Elevator MOVING UP? ");
		orders.put("iemd","Is Elevator MOVING DOWN? ");
		orders.put("speed","Elevator Speed is: ");
		orders.put("su","Set Elevator to UP position: ");
		orders.put("sd","Set Elevator to DOWN position: ");
		orders.put("stop", "Stop Elevator");
		orders.put("+", "Increase speed by 0.1 ");
		orders.put("-", "Decrease speed by -0.1 ");
		orders.put("cc", "Close Claw");
		orders.put("oc", "Open Claw");
		orders.put("icc", "Is Claw Closed");
		orders.put("ico", "Is Claw Open");
		orders.put("scc", "Set Claw Closed");
		orders.put("sco", "Set Claw Open");
		orders.put("wait", "Motion Wait time");
		listCommands();
	}
	
	public boolean decodeCommand(String inCommand) {
		if(orders.containsKey(inCommand)) {
			System.out.println("Command: " + inCommand + " : " + orders.get(inCommand));
			return true;
		}
		else {
			System.out.println("Invalid command: " + inCommand);
			listCommands();
			return false;
		}
	}
	public void listCommands() {
		for(String key: orders.keySet()) {
			System.out.println("   " + key + " " + orders.get(key));
			}
	}
/*
 * Idea is to use the same decode for Auton and Teleop
 */
}


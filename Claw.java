package first.team815.robotics;

public class Claw {
	private boolean isOpen;	

	//constructor
	public Claw() {
		isOpen = false;	//claw is closed
	}
	
	public void open() {
		isOpen = true;
	}
	public void close() {
		isOpen = false;
	}

	public boolean isOpen()
	{
		return isOpen;
	}
	public boolean isClosed()
	{
		return !isOpen;
	}
	public void setOpen(boolean isOpen)
	{
		this.isOpen = isOpen;
	} 
	public void setClosed(boolean isClosed)
	{
		this.isOpen = !isClosed;
	} 
}


public class Elevator extends Provided.AbstractElevator {
	
	//Fields
/*	protected boolean carrying;
	protected Provided.AbstractElevatorController control;
	private int floor;
	char id;
	private static char ID;
	protected java.util.concurrent.locks.ReentrantLock passenger;
	protected int targetFloor;
	protected java.lang.Thread thread;
	*/
	//Constructor
	public Elevator(Provided.AbstractElevatorController control) {
        super(control);
	}
	
	//Methods
	@Override
	//start method: Construct and start the thread running this elevator
	public void start() {
		super.thread = new Thread(this);
		super.thread.start();
		}
		
	
	//isAvailable method: checks if elevator is not carrying and there are no passengers in elevator 
	@Override
	public boolean isAvailable() {
		if(carrying == false && passenger == null) {
			return true;
		}
		else {
			return false;
		}
		
	}

	//pickUp method: elevator beings to move toward passengers destination and picks up passenger
	@Override
	protected void pickUp() {
		//update target floor update whether its carrying passengers or not
		//set this equal to get destination
		//after this set carrying to true
		if(shouldPickUp()) { //if(carrying ==false)
			passenger.board(this);
			targetFloor = passenger.getDestination();
			carrying = true;
		//	this.start();
	}
	}

	@Override
	// shouldPickUp: checks availability of elevator and the destination of where passenger is
	protected boolean shouldPickUp() {
		if(passenger != null && getFloor() == targetFloor && carrying == false) {
			return true;
			
		}
		return false;
	
}
	//offload method: checks if carrying is false and no passengers in elevator then passenger exits
	@Override
	protected void offload() {
		//make sure other fields are accurate, if carrying and passenger fields, carrying = false and passenger = null
		try {
			
			control.lock.lock();
			carrying = false; 
			passenger.exit();
			passenger = null; 
			control.elevatorFinished.signalAll();
			
		}
		
		finally {
			
			control.lock.unlock();
		}
		
		
	}
	
	//shouldOffload method: checks if elevator is carrying and gets passengers destination
	@Override
	protected boolean shouldOffload() {
		if(this.carrying == true && this.getFloor() == passenger.getDestination()) {
			return true;
		}
		return false;
		
		}

	//hail method: 
	@Override
	public void hail(int floor, Provided.Person p) throws Provided.OccupiedException {
		//set target floor to move elevator
		//make sure have elevator is available and set target floor and set passenger
		//elevator's lock
		try {
			lock.lock();    
			if(!this.isAvailable()) throw new Provided.OccupiedException(this.id + "unavailable"); {
				passenger = p;
				targetFloor = floor;
				
			}	
	}
		finally{
			lock.unlock();
			
		}
	}
}	
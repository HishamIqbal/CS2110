import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Button extends Provided.AbstractButton {
	
	//Fields
/*	protected Provided.AbstractElevatorController control;
	int floor;
	private Provided.Person p;
	private boolean pressed;
	private java.lang.Thread thread;
	
*/
	//Constructor
	public Button(int floor, Provided.AbstractElevatorController control) {
		
        super(floor, control);
	}
	
	//press method: does try and catch to signal when button is pressed to controller
	@Override
	protected void press(Provided.Person p) {
		
		
		
		try {
			
			control.lock.lock(); 
			control.request(floor,p);
			control.buttonPressed.signalAll();
		}
		
		finally {
			
			control.lock.unlock();
			
		}

}
}


	
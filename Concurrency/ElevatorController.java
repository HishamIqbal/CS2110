

public class ElevatorController extends Provided.AbstractElevatorController{
			
	//run method that actually runs the elevator
	@Override
	public void run() {
		while(!Provided.TERMINATE) {
			try {
				
				lock.lock();
				
				if(availMethod() == null) {
					
					elevatorFinished.await();
					
				}
				if(personQueue.isEmpty()) {
					
					buttonPressed.await();
				}
				else {
					
					this.availMethod().hail(floorQueue.remove(), personQueue.remove());
				}
			}
				catch(InterruptedException exception) {
					Thread.currentThread().interrupt();
				}
				catch(Provided.OccupiedException exception2) {
					exception2.printStackTrace();
				}
				finally {
					
					lock.unlock();
				}
				
			}
		}
		
	//Avail method that looks at if an elevator is available to be used
		public Provided.AbstractElevator availMethod(){
			for(Provided.AbstractElevator elevatorAvailable: elevators) {
				if(elevatorAvailable.isAvailable()) {
					return elevatorAvailable;
				}
				
			}
			return null;
			
		}
		
	
}
	
	
	
	

	

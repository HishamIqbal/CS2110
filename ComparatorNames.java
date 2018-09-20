/* Mohammad Hisham Iqbal, mhi8zx, Homework 4

 */

import java.util.Comparator;

public class ComparatorNames implements Comparator<Playable> {
	public int compare(Playable o1, Playable o2) {
		if(o1.getName().compareTo(o2.getName())<0) {
			return -1;
			
		}else if(o1.getName().compareTo(o2.getName())>0) {
			return 1;
			
		}else {
			return 0;
			
		}
	
		

}
}


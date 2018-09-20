/* Mohammad Hisham Iqbal, mhi8zx, Homework 4

 */

import java.util.Comparator;

public class ComparatorTimes implements Comparator<Playable> {
	public int compare(Playable o1, Playable o2) {
		return o1.getPlayTimeSeconds() - o2.getPlayTimeSeconds();
		
	}
}

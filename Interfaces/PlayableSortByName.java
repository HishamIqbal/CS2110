/* Mohammad Hisham Iqbal, mhi8zx, Homework 4

 */
import java.util.Comparator;

public class PlayableSortByName implements Comparator<Playable> {
  
   public int compare(Playable p1, Playable p2){
       return p1.getName().compareTo(p2.getName());
   }

}

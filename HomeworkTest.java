/* Mohammad Hisham Iqbal, mhi8zx, Homework 4

 */

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class HomeworkTest {
	/*Creates a list of songs */
	
	Song s1 = new Song("Coldplay", "Clocks",3,180 );
	Song s2 = new Song("Jay Z", "Forever",4,240 );
	Song s3 = new Song("Lil Wayne", "No Love", 2,120 );
	Song s4 = new Song("Eminem", "Headlights", 5, 300 );
	Song s5 = new Song("Lil Wayne", "No Love", 2,120 );
	
	PlayList p1 = new PlayList("PlayList 1");
	
	ArrayList<Playable>play = new ArrayList<Playable>();
	
	Song o1 = new Song("Katy Perry", "Roar");
	Song o2 = new Song("Justin Bieber", "Baby");
	Song o3 = new Song("Usher", "Justin Bieber");
	Song o4 = new Song("Usher", "Justin Bieber");
	Song o5 = new Song("They Fray", "Heartless");
	
	PlayList p2 = new PlayList("PlayList 2");
	
	
	ArrayList<Playable>play2 = new ArrayList<Playable>();
	
	Song n1 = new Song("Anthm", "USA", 2,120);
	Song n2 = new Song("Wahoowa", "UVA",3,180);
	
	PlayList p3 = new PlayList("PlayList 3");
	
	ArrayList<Playable>play3 = new ArrayList<Playable>();
	
	
	PlayList p4 = new PlayList("PlayList 4");
	
	/**Create songs and create a playList object p5*/
	Song g1 = new Song("Lifehouse", "Broken",3,180);
	Song g2 = new Song("Jo", "Jolene", 2,120);
	
	PlayList p5 = new PlayList("PlayList 5");
	
	ArrayList<Playable>play5 = new ArrayList<Playable>();
	
	@Before
	public void setUp() {
	
		play.add(s1);
		play.add(s2);
		play.add(s3);
		play.add(s4);
		play.add(s5);
		
		p1.setPlayableList(play);
		
		play2.add(o1);
		play2.add(o2);
		play2.add(o3);
		
		p2.setPlayableList(play2);
		
		play3.add(n1);
		play3.add(n2);
		
		p3.setPlayableList(play3);
		
		play5.add(g1);
		play5.add(g2);
		
		
	}
	
	//getName test 1
	@Test
	public void testGetName() {
		String expected = p1.getName();
		assertEquals("PlayList 1", expected);
	}
	
	//getName test 2
	@Test
	public void testGetName2() {
		String expected = p3.getName();
		assertEquals("PlayList 3", expected);
	}
	
	//numberOfSongs test 1
	@Test
	public void testNumberOfSongs() {
		int expected = p1.numberOfSongs();
		assertEquals(5,expected);
			
	}
	
	//numberOfSongs test 2
	@Test
	public void testNumberOfSongs2() {
		int expected = p2.numberOfSongs();
		assertEquals(3, expected);
	}
	
	//Equals test 1
	@Test
	public void testEquals() {
		assertFalse(s1.equals(s2));
	}
	
	//Equals test 2
	@Test
	public void testEquals2() {
		assertEquals(s3,s5);
	}
	
	//toString test 1
	@Test
	public void testToString() {
		assertEquals("{Song: title = Forever artist = Jay Z}", s2.toString());
	}
	
	//toString test 2
	@Test
	public void testToString2() {
		assertEquals("{Song: title = No Love artist = Lil Wayne}", s3.toString());
	}
	
	//CompareTo test 1
	@Test
	public void testCompareTo() {
		System.out.println(s4.compareTo(s1));
		int expected = s4.compareTo(s1);
		assertEquals(1, expected);
	}
	
	//CompareTo test 2
	@Test
	public void testCompareTo2() {
		int expected = o3.compareTo(o4);
		assertEquals(0, expected);
	}
	
	
	//toString test 1
	@Test
	public void testToStringPlay() {
		assertEquals("Name: PlayList 1{Song: title = Clocks artist = Coldplay}{Song: title = Forever artist = Jay Z}{Song: title = No Love artist = Lil Wayne}{Song: title = Headlights artist = Eminem}{Song: title = No Love artist = Lil Wayne}",p1.toString());
	}
	
	//toString test 2
	@Test
	public void testToStringPlay2() {
		assertEquals("Name: PlayList 2{Song: title = Roar artist = Katy Perry}{Song: title = Baby artist = Justin Bieber}{Song: title = Justin Bieber artist = Usher}",p2.toString());
	}
	
	//LoadSongs test 1
	@Test
	public void testLoadSongs() {
		boolean expected = p1.loadSongs("extra.txt");
		assertEquals(false, expected);
		
	}
	
	//LoadSongs test 2
	@Test
	public void testLoadSongs2() {
		boolean expected = p2.loadSongs("extra.txt");
		assertEquals(false, expected);
		
	}
	
	//clear test 1
	@Test
	public void testClear() {
		boolean expected = p1.clear();
		assertEquals(true, expected);
	}
	
	//Clear test 2
	@Test
	public void testClear2() {
		boolean expected = p2.clear();
		assertEquals(true, expected);
	}
	
	//AddSong test 1
	@Test
	public void testAddSong() {
		boolean expected = p2.addSong(o4);
		assertEquals(true, expected);
	}
	
	//AddSong test 2
	@Test
	public void testAddSong2() {
		boolean expected = p2.addSong(o5);
		assertEquals(true, expected);
	}
	
	//Removeplayable test 1
	@Test
	public void testRemovePlayable() {
		Playable expected = p1.removePlayable(0);
		assertEquals(s1, expected);
	}
	
	//Remove playable test 2
	@Test
	public void testRemovePlayable2() {
		Playable expected = p2.removePlayable(1);
		assertEquals(o2, expected);
	}
	
	//RemovePlayable test 1 part 2
	@Test
	public void testRemovePlayableOcc() {
		Playable expected = p1.removePlayable(s1);
		assertEquals(s1, expected);
	}
	
	//RemovePlayble test 2 part 2
	@Test
	public void testRemovePlayableOcc2() {
		Playable expected = p2.removePlayable(o3);
		assertEquals(o3, expected);
	}
	
	//getPlayable test 1
	@Test
	public void testGetPlayable() {
		Playable expected = p1.getPlayable(3);
		assertEquals(s4,expected);
		
	}
	
	//getPlayable test 2
	@Test
	public void testGetPlayable2() {
		Playable expected = p2.getPlayable(2);
		assertEquals(o3,expected);
		
	}
	
	//AddPlaylist test 1
	@Test
	public void testAddPlayList() {
		p1.setName("PlayList 1");
		p2.setName("PlayList 2");
		boolean expected = p1.addPlayList(p2);
		assertEquals(true, expected);
	}
	
	//Addplaylist test 2
	@Test
	public void testAddPlayList2() {
		boolean expected = p2.addPlayList(p1);
		assertEquals(true, expected);
	}
	
	//SortByName test 1
	@Test
	public void testSortByName() {
		p4.addSong(n1);
		p4.addSong(n2);
		p3.sortByName();
		
		assertEquals(p4.getPlayableList(), p3.getPlayableList());
	}

	//SortByName test 2
	@Test
	public void testSortByName2() {
		p5.addSong(n1);
		p5.addSong(n2);
		p3.sortByName();
		assertEquals(p5.getPlayableList(), p3.getPlayableList());
	}
	
	//SortByTime test 1
	@Test
	public void testSortByTime() {
		p4.addSong(n1);
		p4.addSong(n2);
		p3.sortByTime();
		assertEquals(p4.getPlayableList(), p3.getPlayableList());
		
	}
	
	//SortByTime test 2
	@Test
	public void testSortByTime2() {
		p5.addSong(n1);
		p5.addSong(n2);
		p3.sortByTime();
		assertEquals(p5.getPlayableList(), p3.getPlayableList());
	}

	
	
	
	

}

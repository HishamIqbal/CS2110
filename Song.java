/* Mohammad Hisham Iqbal, mhi8zx, Homework 4

 */

public class Song implements Playable, Comparable<Song> {

	//Variables
	private String artist;
	private String title;
	private int minutes;
	private int seconds;
	
	
	// Constructors
	public Song(String artist, String title) {
		 this.artist = artist;
		 this.title = title;
		 this.minutes = 0;
		 this.seconds = 0;
	}
	
	public Song(String artist, String title, int minutes, int seconds) {
		 this.artist = artist;
		 this.title = title;
		 this.minutes = minutes;
		 this.seconds = seconds;
	}
	
	public Song(Song s) {
		this.artist = s.getArtist();
		this.title = s.getTitle();
		this.minutes = s.getMinutes();
		this.seconds = s.getSeconds();
	}
	
	
	
//Play method
	@Override
	public void play() {
		System.out.printf("Playing Song: artist = %-20s title = %s\n", artist, title);

	}

	 
//Getters and setters
	@Override
	public String getName() {
		return this.title;
	}
	
	@Override
	public int getPlayTimeSeconds() {
		return this.seconds +60 * this.minutes;
	}
	@Override
	public int numberOfSongs() {
		return 1;
	}
	
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	//Equals method
	
	public boolean equals(Object o) {
		if(o instanceof Song) {
			Song ride = (Song) o;
			if(this.artist.equals(ride.artist) && this.title.equals(ride.title) 
					&& this.minutes == ride.minutes && this.seconds == ride.seconds) {
				
				return true;
			}
	
		}
		return false;
	}
	
	//ToString method
	
	public String toString() { 
		   return "{Song: title = " + title + " artist = " + artist + "}";
	
	}

	//CompareTo method
	@Override
	public int compareTo(Song goner) {
		if(this.artist.compareTo(goner.artist) <0) {
			return -1;
		}
		else if(this.artist.compareTo(goner.artist)==0) {
			if(this.title.compareTo(goner.title) < 0) {
				return -1;
			}
			else if(this.title.compareTo(goner.title)==0) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else if(this.artist.compareTo(goner.artist)>0) {
			return 1;
		}
		return 0;
				
			
		}
		
	}


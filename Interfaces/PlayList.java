/* Mohammad Hisham Iqbal, mhi8zx, Homework 4

 */

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PlayList implements Playable {
	
	//Variables
	private String name;
	private ArrayList<Playable> playableList;
	
	
	//Constructors
	public PlayList() {
		this.name = "Untitled";
		this.playableList = new ArrayList<Playable>(); 
	}
	
	public PlayList(String newName) {
		this.name = newName;
		playableList = new ArrayList<Playable>();
	}
	
	//Getters and Setters
	public ArrayList<Playable> getPlayableList() {
		return playableList;
	}

	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getPlayTimeSeconds() {
		int counter = 0;
		for(Playable g: playableList) {
			counter = counter + g.getPlayTimeSeconds();
		}
		return counter;
	}

	//numberOfSongs method
	@Override
	public int numberOfSongs() {
		int counter=0;
		for(Playable g: playableList) {
			g.numberOfSongs();
			counter = counter + g.numberOfSongs();
			
		}
		return counter;
	}

	
	//toString method
	public String toString() {
		String nam = "Name: " + this.name;
		
		for(Playable og : playableList) {
			nam = nam + og.toString();
		}
		return nam;		
	}
	
	//loadSongs method
	public boolean loadSongs(String fileName) {
		
		File loader= new File(fileName);
		Scanner loadSongs= null;
		
		try {
		loadSongs = new Scanner(loader);
		}
		
		catch(Exception ex) {
			return false;
			
		}
		int num = 0;
		String title = "";
		String artist = "";
		int sec = 0;
		int min = 0;
		
		
		while(loadSongs.hasNextLine()) {
			String next = loadSongs.nextLine();
			num+=1;
			next = next.trim();
			
			if(num == 1) {
				title = next;	
			}
			else if(num == 2) {
				artist = next;	
			}
			else if(num == 3) {
				int ind = next.indexOf(":");
				String m = next.substring(0,ind);
				String s = next.substring(ind+1);
				min = Integer.parseInt(m);
				sec = Integer.parseInt(s);
				
				if(sec>=60) {
					int mins = sec/60;
					min += mins;
					sec=sec-(60*mins);	
			}
				
			}else if(num == 4) {
				num = 0;
				Song j= new Song(artist, title, min, sec);
				this.playableList.add(j);	
			}
			}
		loadSongs.close();
		return true;
		
	}
	
	
	//Method clear
	public boolean clear() {
		playableList.clear();
			return true; 
	}
	
	//method addSong
	public boolean addSong(Song s) {
		playableList.add(s);
		return true;
	}
	
	//method removePlayable
	public Playable removePlayable(int index) {
		if(index >= playableList.size() || index<0) {
			return null;
		}
		
		else {
			return playableList.remove(index);
		}
	}

	//method removePlayable
	public Playable removePlayable(Playable p) {
		for(Playable s: playableList) {
			if(s.equals(p)) {
				playableList.remove(p);
				return p;
				
			}
			
		}
		return null;
	}

	
	//method getPlayable
	public Playable getPlayable(int index) {
		  if(index >= playableList.size() || index<0){
	           return null;
	       }
		  else {
			  return playableList.get(index);  
		  }
	       
	   }
	
	//method addPlaylist
	public boolean addPlayList(PlayList pl) {
		for(Playable g: playableList){
	           if(g instanceof PlayList){
	               if(g.getName().equals(pl.getName())){
	                   return false;
	               }
	           }
	       }
	       playableList.add(pl);
	       return true;
	   }

		
	//method play
	@Override
		public void play() {
			for( Playable each: playableList) {
				each.play();
			}
			
		}
		
	//method sortByName
	public void sortByName() {
		Collections.sort(playableList, new ComparatorNames());
		
	}

	//method sortByTime
	public void sortByTime() {
			Collections.sort(playableList, new ComparatorTimes());
			
		}
		
}


		



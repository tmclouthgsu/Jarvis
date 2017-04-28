


//PLEASE READ THIS
/*
* In order to use this code you will need to create another test class with a main method, call it what ever you like.
* In the main method of that other class you will need to call the constrcutor of the class you make.
* 
* Here is an example. String test[][] = {{"turn","nn"},{"the","dt"},{"lights","nns"},{"on","in"},{"to","to"},{"420","cd"}};
* For example here I would type | Heating testHeating = new Heating(test)
* If everything works as expected you should see it match some of the words in your lemArrays and output whatever you tell that case to do.
*/

public class Spotify1 {
	//variables used by this class, go ahead and edit these as you need for your functions and class templates.
	boolean turnOff;
	boolean turnOn = false;
	int setVolumeUp;
	int setVolumeDown;
	int setNextSong;
	int setPreviousSong;
	String listOfOps = "Spotify play | Turn Spotify off | Spotify set volume up | Spotify set volume down | Spotify next song | spotify previous song";
	
	//class constructor -- edit for your class name
	public Spotify1(){		
	}
	
	//do not edit -- class function that accepts the input Array -- do not edit
	public void doSomething(String[][] taggedText) {
		this.lemLayer2(taggedText);
	}
	
	//lemmatization layer 1 arrays -- edit with your values
	/*1*/ String[] turnOnLem = {"on","play"};
	/*2*/ String[] turnOffLem = {"off", "pause"};
	/*3*/ String[] setVolumeUpLem = {"up","increase"};
	/*4 / String[] setVolumeDownLem = {"down","decrease"}
	/*5 String[] setNextSong = {"next", "next song"};
	/*6 String[] setPreviousSong = {"previous", "last song"};
	/*7 String[] toasterLem = {"close"};
	/*8 String[] lightsLem = {"close"};
	/*9 String[] camerasLem = {"close"};
	/*10String[] alarmLem = {"close"};*/
	
	//do not edit -- lemmatization method -- do not edit
	public int lemLayer2(String[][] sentence){
		
		//do not edit -- lemmatiztion must have variables for finding the correct output function -- do not edit
		int[] counter = new int[100];
		int switchNumber = 0;
		int switchMax = 0;
		int errorLevel = 0;
		String errorInput = "";
		
		//iterate through sentence and count the matches for each layer 2 word -- edit the names of the arrays to match your layer 2 word arrays.
		for(int i=0; i<sentence.length;i++){
			
			for(int k=0; k<turnOnLem.length;k++){
				if(sentence[i][0].toLowerCase().contains((turnOnLem[k].toLowerCase()))){
				counter[1]++;
				}				
			}
			for(int k=0; k<turnOffLem.length;k++){
				if(sentence[i][0].toLowerCase().contains((turnOffLem[k].toLowerCase()))){
				counter[2]++;
				}				
			}
			for(int k=0; k<setVolumeUpLem.length;k++){
				if(sentence[i][0].toLowerCase().contains((setVolumeUpLem[k].toLowerCase()))){
				counter[3]++;
				}
			}
			for(int k=0; k<setVolumeDownLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((setVolumeDownLem[k].toLowerCase()))){
					counter[4]++;	
					}
			}
			for(int k=0; k<setNextSongLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((setNextSongLem[k].toLowerCase()))){
					counter[5]++;		
					}
			}
			for(int k=0; k<setPreviousSongLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((setPreviousLem[k].toLowerCase()))){
					counter[6]++;
					}
			}
			
	}		
		
		//do not edit -- finds the most matched function and returns the number of the function -- do not edit
		for(int j=0;j<counter.length;j++){
			if(counter[j] != 0 && counter[j] == switchMax){
				errorLevel = 1;
			}
			if(counter[j]>switchMax){
				switchNumber = j;
				switchMax=counter[j];
				errorLevel = 0;
			}
		}
		
		//checks to see if there was not a most matched, and if there was not a most matched it returns an error -- do not edit
		if(errorLevel != 0)
		{
			for(int i=0; i<sentence.length;i++){
				errorInput += (sentence[i][0] + " ");
			}
			System.out.println("We were unable to determine what change you were trying to make, could you please try to rephrase this command:" + errorInput);
			return 99;
		}
		
		//switch based on which array is matched the most number of times 
		//insert your functions after the sysout and before the break like i have done with case 1.
		switch (switchNumber){
		
		case 1: //System.out.println("Spotify method turnOn");
				this.turnOn();
				break;
		case 2: //System.out.println("Spotify method turnOff");
				this.turnOff();
				break;
		case 3: //System.out.println("Spotify method setVolumeUp");
				this.setVolumeUp();
				break;
		case 4: //System.out.println("Spotify method seVolumeDown");
				this.setVolumeDown();
				break;
		case 5: //System.out.println("Spotify method setNextSong");
				this.setNextSong();
				break;
		case 6: //System.out.println("Spotify method setPreviousSong");
				this.setPreviousSong();
				break;
		case 7: System.out.println("heating method 7");
				break;
		case 8: System.out.println("heating method 8");
				break;
		case 9: System.out.println("heating method 9");
				break;
		case 10:System.out.println("heating method 10");
				break;
		default:System.out.println("We were unable to find a command that matched your request.");
				System.out.println("The list of availble operations for the Alarm are: " + listOfOps);
				break;
		}		
		return switchNumber;
	}

	
	
	//this is where you define all the functions for the class. Go ahead and add all your methods for changing values and opening and closing whatever below.
	//my code from here on out is only for the heating but you can use it as an example for your classes. 
	
	public void turnOff(){
		if(this.turnOn == true){
		this.turnOn = false;
		System.out.println("Spotify is now off");
		}
		else{
			System.out.println("Spotify is already off");
		}
	}
	public void turnOn(){
		if(this.turnOn == false){
		this.turnOn = true;
		System.out.println("Spotify is now on");
		}
		else{
			System.out.println("Spotify is already on");
		}
	}	
	public void setVolumeUp(){
		if(){
			;
			System.out.println("Volume up to:");
			}
			else{
				System.out.println("volume is set to:");
			}
		
	}
	public void setVolumeDown(){
		if(){
			;
			System.out.println("Volume up to:");
			}
			else{
				System.out.println("volume is set to:");
			}
		
	}
	public void setNextSong(){
		
	}
	public void setPreviousSong(){
		
	
	}
	
	
	}

			

	
	
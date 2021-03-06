
public class Television {
	//variables used by this class, go ahead and edit these as you need for your functions and class templates.
		int volume = 15;
		int channel = 50;
		boolean powerOn = false;
		boolean powerOff = true;
		String listOfOps = "Turn Television On | Turn Television off | Set channel |Set Volume";
		
		//class constructor -- edit for your class name
		public Television(){		
		}
		
		//do not edit -- class function that accepts the input Array -- do not edit
		public void doSomething(String[][] taggedText) {
			this.lemLayer2(taggedText);
		}
		
		//lemmatization layer 1 arrays -- edit with your values
		/*1*/ String[] setVolumeLem = {"volume", "sound"};
		/*2*/ String[] setChannelLem = {"channel" , "station"};
		/*3*/ String[] setPowerOnLem = {"on"};
		/*4*/ String[] setPowerOffLem = {"off"};
		/*5 String[] doorsLem = {"close"};
		/*6 String[] ovenLem = {"close"};
		/*7 String[] toasterLem = {"close"};
		/*8 String[] spotifyLem = {"close"};
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
		for(int i=0; i<sentence[0].length;i++){
			
			
			for(int k=0; k<setVolumeLem.length;k++){
				if(sentence[i][0].toLowerCase().contains((setVolumeLem[k].toLowerCase()))){
				counter[1]++;
				}				
			}
			for(int k=0; k<setChannelLem.length;k++){
				if(sentence[i][0].toLowerCase().contains((setChannelLem[k].toLowerCase()))){
				counter[1]++;
				}				
			}
			for(int k=0; k<setPowerOnLem.length;k++){
				if(sentence[i][0].toLowerCase().contains((setPowerOnLem[k].toLowerCase()))){
				counter[1]++;
				}				
			}
			for(int k=0; k<setPowerOffLem.length;k++){
				if(sentence[i][0].toLowerCase().contains((setPowerOffLem[k].toLowerCase()))){
				counter[1]++;
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
			
			case 1: setVolume(String[][]input);
			break;
			case 2: setChannel(String[][]input);
			break;
			case 3: setPowerOn();
			break;
			case 4: setPowerOff();
			break;
			default:System.out.println("We were unable to find a command that matched your request.");
					System.out.println("The list of availble operations for the Alarm are: " + listOfOps);
					break;
			}		
			return switchNumber;
		}

		
		
		//this is where you define all the functions for the class. Go ahead and add all your methods for changing values and opening and closing whatever below.
		//my code from here on out is only for the heating but you can use it as an example for your classes. 
		
		public void setChannel(String[][]input){
			//channel = this.channel;
			for(int i=0; i<input.length;i++){
				if(input[i][1].endsWith("cd") || input[i][1].endsWith("in")){
					System.out.println("Setting Channel to " + input[i][0] + ".");
					this.channel = (int)input[i][0];
					break;
					//put channel for loop 1-1000
				}
			}
		}
		public void setVolume(String[][]input){
			for(int i=0; i<input.length;i++){
				if(input[i][1].endsWith("cd")|| input[i][1].endsWith("in")){
					System.out.println("Setting volume to " + input[i][0] + ".");
				}// set volume loop 1-50
			}
			
		}
		
		public void setPowerOn(){
			//powerOn = !powerOn;
			if(powerOff == true){
				powerOn = !powerOn;
				System.out.println("The television has been turned on.");
			}
			else{
				System.out.println("The television is already on.");
			}
		}
		
		public void setPowerOff(){
			if (powerOn == true){
				powerOn = !powerOn;
				System.out.println("The television has been turned off.");
		}
			else{
				System.out.println("The television is already off.");
		}
	}

}

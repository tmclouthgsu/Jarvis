
public class Television {

	
		int volume = 15;
		int channel = 0;
		boolean powerOn = false;
		String listOfOps = "Turn Television On | Turn Television off | Set channel | Set Volume";
		
		//class constructor -- edit for your class name
		public Television(){		
		}
		
		//do not edit -- class function that accepts the input Array -- do not edit
		public void doSomething(String[][] taggedText) {
			this.lemLayer2(taggedText);
		}
		
		//lemmatization layer 2 arrays -- edit with your values
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
			Window output = new Window();
			
			//iterate through sentence and count the matches for each layer 2 word -- edit the names of the arrays to match your layer 2 word arrays.
		for(int i=0; i<sentence[0].length;i++){
			
			
			for(int k=0; k<setVolumeLem.length;k++){
				if(sentence[i][0].toLowerCase().startsWith(((setVolumeLem[k].toLowerCase())))){
				counter[1]++;
				}				
			}
			for(int k=0; k<setChannelLem.length;k++){
				if(sentence[i][0].toLowerCase().startsWith((setChannelLem[k].toLowerCase()))){
				counter[2]++;
				}				
			}
			for(int k=0; k<setPowerOnLem.length;k++){
				if(sentence[i][0].toLowerCase().equals((setPowerOnLem[k].toLowerCase()))){
				counter[3]++;
				}				
			}
			for(int k=0; k<setPowerOffLem.length;k++){
				if(sentence[i][0].toLowerCase().equals((setPowerOffLem[k].toLowerCase()))){
				counter[4]++;
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
				output.makeOutputWindow("We were unable to determine what change you were trying to make, could you please try to rephrase this command:" + errorInput);
				return 99;
			}
			
			//switch based on which array is matched the most number of times 
			switch (switchNumber){
			
			case 1: setVolume(sentence);
			break;
			case 2: setChannel(sentence);
			break;
			case 3: setPowerOn();
			break;
			case 4: setPowerOff();
			break;
			default:output.makeOutputWindow("We were unable to find a command that matched your request. The list of availble operations for the Television are: " + listOfOps);
			break;
			}		
			return switchNumber;
		}

		
		public void setChannel(String[][]input){
			Window output = new Window();
			for(int i=0; i<input.length;i++){
				if(input[i][1].endsWith("cd")){
					if(Integer.parseInt(input[i][0]) > 0 && Integer.parseInt(input[i][0]) <= 999){
					output.makeOutputWindow("Setting Channel to " + input[i][0] + ".");
					this.channel = Integer.parseInt(input[i][0]);
					}
					else{
						output.makeOutputWindow("This channel is not available. Please select a channel between 1 and 999");
					}
				}
			}
		}
		public void setVolume(String[][]input){
			Window output = new Window();
			for(int i=0; i<input.length;i++){
				if(input[i][1].endsWith("cd")){
					output.makeOutputWindow("Setting volume to " + input[i][0] + ".");
				}
			}
			
		}
		
		public void setPowerOn(){
			Window output = new Window();
			if(powerOn == false){
				powerOn = !powerOn;
				output.makeOutputWindow("The television has been turned on.");
			}
			else{
				output.makeOutputWindow("The television is already on.");
			}
		}
		
		public void setPowerOff(){
			Window output = new Window();
			if (powerOn == true){
				powerOn = !powerOn;
				output.makeOutputWindow("The television has been turned off.");
		}
			else{
				output.makeOutputWindow("The television is already off.");
		}
	}

}
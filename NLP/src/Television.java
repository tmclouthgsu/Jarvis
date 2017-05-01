
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
		/*1*/ String[] setVolumeLem = {"volume","volume","volume","volume","volume","level"};
		/*2*/ String[] setChannelLem = {"channel","channel","channel","channel","program","number"};
		/*3*/ String[] setPowerOnLem = {"on","on","on","on","on","on"};
		/*4*/ String[] setPowerOffLem = {"off","off","off","off","off"};

		
		//do not edit -- lemmatization method -- do not edit
		public int lemLayer2(String[][] sentence){
			
			//do not edit -- lemmatiztion must have variables for finding the correct output function -- do not edit
			int[] counter = new int[5];
			int switchNumber = 0;
			int switchMax = 0;
			int errorLevel = 0;
			String errorInput = "";
			Window output = new Window();
			
			//iterate through sentence and count the matches for each layer 2 word -- edit the names of the arrays to match your layer 2 word arrays.
			for(int i=0; i<sentence.length;i++){
				
				for(int k=0; k<setVolumeLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((setVolumeLem[k].toLowerCase()))){
					counter[1]++;
					}				
				}
				for(int k=0; k<setChannelLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((setChannelLem[k].toLowerCase()))){
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
			
			case 1:	setVolume(sentence);
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
				if(this.powerOn == true){
				if(input[i][1].endsWith("cd")){
					int tempChannel = Integer.parseInt(input[i][0]);
					if(tempChannel > 0 && tempChannel <= 999){
					output.makeOutputWindow("Setting Channel to " + tempChannel + ".");
					this.channel = tempChannel;
					}
					else{
						output.makeOutputWindow("This channel is not available. Please select a channel between 1 and 999");
					}
				}
				}
				else{
					output.makeOutputWindow("The Television must be turned on before a channel can be selected");
				}
			}
		}
		public void setVolume(String[][]input){
			Window output = new Window();
			if(this.powerOn == true){
			for(int i=0; i<input.length;i++){
				if(input[i][1].endsWith("cd")){
					output.makeOutputWindow("Setting volume to " + Integer.parseInt(input[i][0]) + ".");
					this.volume = Integer.parseInt(input[i][0]);
				}
			}
			}
			else{
				output.makeOutputWindow("The Television must be turned on before a volume can be selected");
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
public class Light {

	boolean isOn;
	String listOfOps = "Turn Lights on | Turn Lights off";
	
	//class constructor -- edit for your class name
	public Light(){		
	}
	
	//do not edit -- class function that accepts the input Array -- do not edit
	public void doSomething(String[][] taggedText) {
		this.lemLayer2(taggedText);
	}
	
	//lemmatization layer 1 arrays -- edit with your values
	/*1*/ String[] turnLightsOnLem = {"on","on"};
	/*2*/ String[] turnLightsOffLem = {"off","off"};

	//do not edit -- lemmatization method -- do not edit
	public int lemLayer2(String[][] sentence){
		
		//do not edit -- lemmatiztion must have variables for finding the correct output function -- do not edit
		int[] counter = new int[3];
		int switchNumber = 0;
		int switchMax = 0;
		int errorLevel = 0;
		String errorInput = "";
		Window output = new Window();
		
		
		//iterate through sentence and count the matches for each layer 2 word -- edit the names of the arrays to match your layer 2 word arrays.
		for(int i=0; i<sentence.length;i++){
			
			for(int k=0; k<turnLightsOnLem.length;k++){
				if(sentence[i][0].toLowerCase().equals((turnLightsOnLem[k].toLowerCase()))){
				counter[1]++;
				}				
			}
			for(int k=0; k<turnLightsOffLem.length;k++){
				if(sentence[i][0].toLowerCase().equals((turnLightsOffLem[k].toLowerCase()))){
				counter[2]++;
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
		
		case 1: //System.out.println("light method turnOn");
				this.turnLightsOn();
				break;
		case 2: //System.out.println("light method turnOff");
				this.turnLightsOff();
				break;
		default:output.makeOutputWindow("We were unable to find a command that matched your request. The list of availble operations for the Lights are: \n" + listOfOps);
				break;
		}		
		return switchNumber;
	}
	
	
	//this is where you define all the functions for the class. Go ahead and add all your methods for changing values and opening and closing whatever below.
	//my code from here on out is only for the heating but you can use it as an example for your classes. 
	
	public void turnLightsOff(){
		Window output = new Window();
		if(this.isOn == true){
		this.isOn = false;
		output.makeOutputWindow("The Lights are now off");
		}
		else{
			output.makeOutputWindow("The Lights are already off");
		}
	}
	public void turnLightsOn(){
		Window output = new Window();
		if(this.isOn == false){
		this.isOn = true;
		output.makeOutputWindow("The Lights are now on");
		}
		else{
			output.makeOutputWindow("The Lights are already on");
		}
	}	
}

public class Toaster {
	//variables used by this class, go ahead and edit these as you need for your functions and class templates.
		boolean isOn;
		boolean isOff;
		String listOfOps = "Turn Toaster on | Turn Toaster off | Change setting";
		
		//class constructor -- edit for your class name
		public Toaster(){		
		}
		
		//do not edit -- class function that accepts the input Array -- do not edit
		public void doSomething(String[][] taggedText) {
			this.lemLayer2(taggedText);
		}
		
		//lemmatization layer 1 arrays -- edit with your values
		/*1*/ String[] setHighLem = {"high"};
		/*2*/ String[] setMediumLem = {"medium"};
		/*3*/ String[] setLowLem = {"low"};
		/*4*/ String[] setOnLem = {"on"};
		/*5*/ String[] setOffLem = {"off"};
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
			for(int i=0; i<sentence.length;i++){
				
				for(int k=0; k<setHighLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((setHighLem[k].toLowerCase()))){
					counter[1]++;
					}				
				}
				for(int k=0; k<setMediumLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((setMediumLem[k].toLowerCase()))){
					counter[2]++;
					}				
				}
				for(int k=0; k<setLowLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((setLowLem[k].toLowerCase()))){
					counter[3]++;
					}				
				}
				for(int k=0; k<setOnLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((setOnLem[k].toLowerCase()))){
					counter[4]++;
					}				
				}
				for(int k=0; k<setOffLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((setOffLem[k].toLowerCase()))){
					counter[5]++;
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
			
			case 1: //System.out.println("alarm method turnOn");
					this.setHigh();
					break;
			case 2: //Sets the toaster to Medium
					this.setMedium();
					break;
			case 3: //Sets the toaster to Low
					this.setLow();
					break;
			case 4: //Turns on the toaster if it is off.
					this.turnOn();;
					break;
			case 5: //Turns off the toaster if it is on.
					this.turnOff();
					break;
			
			default:System.out.println("We were unable to find a command that matched your request.");
					System.out.println("The list of availble operations for the Alarm are: " + listOfOps);
					break;
			}		
			return switchNumber;
		}

		
		
		//this is where you define all the functions for the class. Go ahead and add all your methods for changing values and opening and closing whatever below.
		//my code from here on out is only for the heating but you can use it as an example for your classes. 
		
		
		public void setHigh(){
			System.out.println("Setting the toaster to high.");
		}
		public void setMedium(){
			System.out.println("Setting the toaster to medium.");
		}
		public void setLow(){
			System.out.println("Setting the toaster to Low.");
		}
		public void turnOn(){
			if(isOn == true){
				System.out.println("The toaster is already on.");
			}
			else{
				System.out.println("Now turning the toaster on.");
			}
		}
		public void turnOff(){
			if(isOff == true){
				System.out.println("The toaster is already off");
			}
			else{
				System.out.println("Turning off the toaster.");
			}


		}		
		

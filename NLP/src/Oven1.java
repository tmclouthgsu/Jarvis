package jarvis;


public class Oven {
	//variables used by this class, go ahead and edit these as you need for your functions and class templates.
		boolean isOn ;
		boolean isOff;
		int setTemperature;
		int remainingTime;
		int heating;
		

		
		String listOfOps = "Turn Oven on | Turn Oven off | Set Temperature of Oven | Remaining Time of oven | Oven Heating";
		
		//class constructor -- edit for your class name
		public Oven(){		
		}
		
		//do not edit -- class function that accepts the input Array -- do not edit
		public void doSomething(String[][] taggedText) {
			this.lemLayer2(taggedText);
		}
		
		//lemmatization layer 1 arrays -- edit with your values
		/*1*/ String[] isOnLem = {"on","bake","heat"};
		/*2*/ String[] setTemperatureLem = {"temperature", "increase temperature"};
		/*3*/ String[] remainingTimeLem = {"time left","remaining time"};
		/*4*/ String[] isOffLem = {"off"};
		/*5*/ String[] heatingLem = {"heat","heat"};
		/*6 String[] spotifyLem = {"close"};
		/*7 String[] toasterLem = {"close"};
		/*8 String[] lightsLem = {"close"};
		/*9 String[] camerasLem = {"close"};
		/*10String[] alarmLem = {"close"};*/
		
		//do not edit -- lemmatization method -- do not edit
		public int lemLayer2(String[][] sentence){
			
			//do not edit -- lemmatization must have variables for finding the correct output function -- do not edit
			int[] counter = new int[100];
			int switchNumber = 0;
			int switchMax = 0;
			int errorLevel = 0;
			String errorInput = "";
			Window output = new Window(); 
			
			//iterate through sentence and count the matches for each layer 2 word -- edit the names of the arrays to match your layer 2 word arrays.
			for(int i=0; i<sentence.length;i++){
				
				for(int k=0; k<isOnLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((isOnLem[k].toLowerCase()))){
					counter[1]++;
					}				
				}
				for(int k=0; k<setTemperatureLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((setTemperatureLem[k].toLowerCase()))){
					counter[2]++;
					}				
				}
				for(int k=0; k<remainingTimeLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((remainingTimeLem[k].toLowerCase()))){
					counter[3]++;
					}	
				}		
				for(int k=0; k<heatingLem.length;k++){
						if(sentence[i][0].toLowerCase().contains((heatingLem[k].toLowerCase()))){
						counter[4]++;	
					}
				}		
						
				for(int k=0; k<isOffLem.length;k++){
						if(sentence[i][0].toLowerCase().contains((isOffLem[k].toLowerCase()))){
						counter[5]++;		
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
			//insert your functions after the sysout and before the break like i have done with case 1.
			switch (switchNumber){
			
			case 1: //System.out.println("Oven method isOn");
					this.isOn();
					break;
			case 2: //System.out.println("Oven method setTemperature");
					this.setTemperature();
					break;
			case 3: //System.out.println("Oven method remainingTime");
					this.remainingTime();
					break;
			case 4: //System.out.println("Oven method heating");
					this.heating();
					break;
			case 5: //System.out.println("Oven method isOff");
					this.isOff();
					break;
			case 6: System.out.println("heating method 6");
					break;
			case 7: System.out.println("heating method 7");
					break;
			case 8: System.out.println("heating method 8");
					break;
			case 9: System.out.println("heating method 9");
					break;
			case 10:System.out.println("heating method 10");
					break;
			default:output.makeOutputWindow("We were unable to find a command that matched your request.");
					output.makeOutputWindow("The list of availble operations for the Oven are: " + listOfOps);
					break;
			}		
			return switchNumber;
		}

		}
		
		//this is where you define all the functions for the class. Go ahead and add all your methods for changing values and opening and closing whatever below.
		//my code from here on out is only for the heating but you can use it as an example for your classes. 
		
		public void isOff(){
			Window output == new Window();
			if(this.isOn == true){
			this.isOn = false;
			output.makeOutputWindow("Oven is now off");
			}
		
			else{
				output.makeOutputWindow("Oven is already off");
			}
		
		}
		public void isOn(){
			Window output == new Window();
			if(this.isOn == false){
			this.isOn = true;
			output.makeOutputWindow("Oven is now on");
			}
		
			else{
				output.makeOutputWindow("Oven is already on");
			}
		}	
		
		private void setTemperature(String[][] input){
			Window output == new Window();
			this.isOn = true;
			for(int k=0; k<input.length;k++){
				//output.makeOutputWindow(input[k][1]);
				if(input[k][1].contains("cd")){
				 //output.makeOutputWindow(Integer.parseInt(input[k][0]));
					this.setTemperature = Integer.parseInt(input[k][0]);
				output.makeOutputWindow("Setting temperature to:" + this.setTemperature);
				}
			}
		
		}
			 public String remainingTime(long milliseconds) {
				 this.isOn = true;
			        String format = String.format("%%0%dd", 2);
			        long elapsedTime = milliseconds / 1000;
			        String seconds = String.format(format, elapsedTime % 60);
			        String minutes = String.format(format, (elapsedTime % 3600) / 60);
			        String hours = String.format(format, elapsedTime / 3600);
			        String time =  hours + ":" + minutes + ":" + seconds;
			        return time;
			        output.makeOutputWindow("remaining time is:" + time);
			    }

		
			
		
			
		
		public void heating(String[][] input){
			this.isOn = true;
			output.makeOutputWindow("Oven heating at:" + this.setTemperature) ;
		}
			
		
		
		
		
		}

			
		
		
			
	
	


	

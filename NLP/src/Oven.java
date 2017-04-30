public class Oven {
	//variables used by this class, go ahead and edit these as you need for your functions and class templates.
		boolean isOn;
		int temperature;
		int cookingTime;
		

		
		String listOfOps = "Turn Oven on | Turn Oven off | Set Temperature of Oven | Remaining Time of oven | Oven Heating";
		
		//class constructor -- edit for your class name
		public Oven(){		
		}
		
		//do not edit -- class function that accepts the input Array -- do not edit
		public void doSomething(String[][] taggedText) {
			this.lemLayer2(taggedText);
		}
		
		//lemmatization layer 1 arrays -- edit with your values
		/*1*/ String[] turnOnLem = {"on","bake","heat","on","bake","heat"};
		/*2*/ String[] setTemperatureLem = {"set","temperature","increase","decrease","set","temperature","increase","decrease"};
		/*3*/ String[] cookingTimeLem = {"time","left","for"};
		/*4*/ String[] getTemperature = {"what","how"};
		/*5*/ String[] turnOffLem = {"off","off","off"};

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
				
				for(int k=0; k<turnOnLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((turnOnLem[k].toLowerCase()))){
					counter[1]++;
					}				
				}
				for(int k=0; k<setTemperatureLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((setTemperatureLem[k].toLowerCase()))){
					counter[2]++;
					}				
				}
				for(int k=0; k<cookingTimeLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((cookingTimeLem[k].toLowerCase()))){
					counter[3]++;
					}	
				}		
				for(int k=0; k<getTemperature.length;k++){
						if(sentence[i][0].toLowerCase().contains((getTemperature[k].toLowerCase()))){
						counter[4]++;	
					}
				}		
						
				for(int k=0; k<turnOffLem.length;k++){
						if(sentence[i][0].toLowerCase().contains((turnOffLem[k].toLowerCase()))){
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
				for(int j=0; j<sentence.length;j++){
					errorInput += (sentence[j][0] + " ");
				}
				
				output.makeOutputWindow("We were unable to determine what change you were trying to make, could you please try to rephrase this command:" + errorInput);
				return 99;
			}

			switch (switchNumber){
			
			case 1: System.out.println("Oven method isOn");
					this.turnOn();
					break;
			case 2: System.out.println("Oven method setTemperature");
					this.setTemperature(sentence);
					break;
			case 3: System.out.println("Oven method remainingTime");
					this.cookingTime(sentence);
					break;
			case 4: System.out.println("Oven method heating");
					this.heating(sentence);
					break;
			case 5: System.out.println("Oven method isOff");
					this.turnOff();
					break;
			default:output.makeOutputWindow("We were unable to find a command that matched your request. The list of availble operations for the Oven are: " + listOfOps);
					break;
			}		
			return switchNumber;
		}

		public void turnOff(){
			Window output = new Window();
			if(this.isOn == true){
				this.isOn = false;
				output.makeOutputWindow("Oven is now off");
			}
		
			else{
				output.makeOutputWindow("Oven is already off");
			}
		
		}
		public void turnOn(){
			Window output = new Window();
			if(this.isOn == false){
				this.isOn = true;
				output.makeOutputWindow("Oven is now on");
			}
		
			else{
				output.makeOutputWindow("Oven is already on");
			}
		}	
		
		private void setTemperature(String[][] input){
			Window output = new Window();
			this.isOn = true;
			for(int k=0; k<input.length;k++){
				if(input[k][1].contains("cd")){
					this.temperature = Integer.parseInt(input[k][0]);
				output.makeOutputWindow("Setting temperature to:" + this.temperature);
				}
			}
		
		}
		public void cookingTime(String[][] input) {
			Window output = new Window();
			this.isOn = true;
			for(int k=0; k<input.length;k++){
				if(input[k][1].contains("cd")){
					this.cookingTime = Integer.parseInt(input[k][0]);
					output.makeOutputWindow("Turning the oven on and setting the timer for " + this.cookingTime + " minutes");
				}				
			}
		}

		public void heating(String[][] input){
			Window output = new Window();
			this.isOn = true;
			output.makeOutputWindow("Oven heating at:" + this.temperature) ;
		}		
}
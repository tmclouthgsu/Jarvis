	public class Camera {
		
		//variables used by this class, go ahead and edit these as you need for your functions and class templates.
			boolean isOn = false;
			boolean isRecording = false;			
			String listOfOps = "Turn Camera on | Turn Camera off | Start recording";
			
			//class constructor -- edit for your class name
			public Camera(){		
			}
			
			//do not edit -- class function that accepts the input Array -- do not edit
			public void doSomething(String[][] taggedText) {
				this.lemLayer2(taggedText);
			}
			
			//lemmatization layer 1 arrays -- edit with your values
			/*1*/ String[] onLem = {"on","on"};
			/*2*/ String[] offLem = {"off","off"};
			/*3*/ String[] isRecordingLem = {"start","record"};

			//do not edit -- lemmatization method -- do not edit
			public int lemLayer2(String[][] sentence){
				
				//do not edit -- lemmatization must have variables for finding the correct output function -- do not edit
				int[] counter = new int[4];
				int switchNumber = 0;
				int switchMax = 0;
				int errorLevel = 0;
				String errorInput = "";
				Window output = new Window(); 
				
				//iterate through sentence and count the matches for each layer 2 word -- edit the names of the arrays to match your layer 2 word arrays.
				for(int i=0; i<sentence.length;i++){
					
					for(int k=0; k<onLem.length;k++){
						if(sentence[i][0].toLowerCase().equals((onLem[k].toLowerCase()))){
						counter[1]++;
						}				
					}
					for(int k=0; k<offLem.length;k++){
						if(sentence[i][0].toLowerCase().equals((offLem[k].toLowerCase()))){
						counter[2]++;
						}				
					}
					for(int k=0; k<isRecordingLem.length;k++){
						if(sentence[i][0].toLowerCase().contains((isRecordingLem[k].toLowerCase()))){
						counter[3]++;
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
				//insert your functions after the sysout and before the break like i have done with case 1.
				switch (switchNumber){
				
				case 1: //System.out.println("camera method on");
						this.on();
						break;
				case 2: //System.out.println("camera method off");
						this.off();
						break;
				case 3: //System.out.println("camera method isRecording");
						this.isRecording();
						break;
				default:output.makeOutputWindow("We were unable to find a command that matched your request. \nThe list of availble operations for the Camera are: " + listOfOps);
						break;
				}		
				return switchNumber;
			}
			
			//this is where you define all the functions for the class. Go ahead and add all your methods for changing values and opening and closing whatever below.
			//my code from here on out is only for the heating but you can use it as an example for your classes. 
			
			public void off(){
				Window output = new Window();
				if(this.isOn == true){
				this.isOn = false;
				this.isRecording = false;
				output.makeOutputWindow("The camera is now off");
				}	
				else{
					output.makeOutputWindow("The camera is already off");
				}
			
			}
			public void on(){
				Window output = new Window();
				if(this.isOn == false){
				this.isOn = true;
				output.makeOutputWindow("The camera is now on");
				}
				else{
					output.makeOutputWindow("The camera is already on");
				}
			}	
			
			private void isRecording(){
				Window output = new Window();
				if(this.isOn == true){
					if(this.isRecording == false){
						this.isRecording = true;
						output.makeOutputWindow("The camera is now recording");
					}
					else{
						output.makeOutputWindow("The camera is already recording");
					}
			}
				else
					output.makeOutputWindow("The camera must be on to record");
			}	
}

		public class Curtain {
			
			//variables used by this class, go ahead and edit these as you need for your functions and class templates.
			boolean isOpen = false;
			String listOfOps = "Open Curtains| Close Curtains";
			Window output = new Window();
			//class constructor that accepts the input Array -- edit for your class name

			
			public Curtain(){
				
			}
			public void doSomething(String[][] taggedText) {
				this.lemLayer2(taggedText);
				
			}
			
			//lemmatization layer 1 arrays -- edit with your values
			String[] openCurtainsLem = {"open"};
			String[] closeCurtainsLem = {"close","draw"};

		//lemmatiztion must have variables for finding the correct output function -- do not edit				
				
				//lemmatization method -- do not edit
				public int lemLayer2(String[][] sentence){
					
					int[] counter = new int[3];
					int switchNumber = 0;
					int switchMax = 0;
					int errorLevel = 0;
					String errorInput = "";
					Window output = new Window();
					
					
					//iterate through sentence and count the matches for each layer 2 word -- edit the names of the arrays to match your layer 2 word arrays.
					for(int i=0; i<sentence.length;i++){
						
						for(int k=0; k<openCurtainsLem.length;k++){
							if(sentence[i][0].toLowerCase().contains((openCurtainsLem[k].toLowerCase()))){
							counter[1]++;
							}				
						}
						for(int k=0; k<closeCurtainsLem.length;k++){
							if(sentence[i][0].toLowerCase().contains((closeCurtainsLem[k].toLowerCase()))){
							counter[2]++;
							}				
						}
						
					}
					
					
					//finds the most matched function and returns the number of the function -- do not edit
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
					
					
					switch (switchNumber){
					case 1: //System.out.println("sending to case 1");
							openCurtains(sentence);
							break;
					case 2: //System.out.println("sendind to case 2");
							closeCurtains(sentence);		
							break;					
					default:output.makeOutputWindow("We were unable to find a command that matched your request. The list of availble operations for the Curtains are: " + listOfOps);
						break;
					}
					return switchNumber;
				}		
					
				public void openCurtains(String[][] input){
					Window output = new Window();
					if(this.isOpen == true){
						output.makeOutputWindow("The curtains are arlready open");
					}
					else{
						this.isOpen = true;
						output.makeOutputWindow("I opened the curtains");
					}
				}	
				
				
				//method to close curtains 
				public void closeCurtains(String[][] input){
					Window output = new Window();
					if(this.isOpen == true){
						this.isOpen = false;
						output.makeOutputWindow("I closed the curtains");
					}
					else{
						output.makeOutputWindow("The curtains are arlready closed");
					}
			}		
		}
				
				



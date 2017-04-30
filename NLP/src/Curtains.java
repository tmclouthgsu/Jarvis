
		public class Curtains {
			
			//variables used by this class, go ahead and edit these as you need for your functions and class templates.
			boolean isOpen = false;
			String listOfOps = "Curtain is open| Curtain is closed";
			Window output = new Window();
			//class constructor that accepts the input Array -- edit for your class name
			public Curtains(String[][] taggedText) {
				this.lemLayer2(taggedText);
				
			}
			//class constructor -- edit for your class name
			public Curtains(){
				
			}
			
			//lemmatization layer 1 arrays -- edit with your values
			String[] openCurtainsLem = {"open"};
			String[] closeCurtainsLem = {"close"};

		//lemmatiztion must have variables for finding the correct output function -- do not edit
				public int[] counter = new int[100];
				int switchNumber;
				int switchMax;
				int errorLevel;
				String errorInput = "";
				
				
				//lemmatization method -- do not edit
				public int lemLayer2(String[][] sentence){
					
					
					//iterate through sentence and count the matches for each layer 2 word -- edit the names of the arrays to match your layer 2 word arrays.
					for(int i=0; i<sentence.length;i++){
						
						for(int k=0; k<openCurtainsLem.length;k++){
							if(sentence[i][0].toLowerCase().contains((openCurtainsLem[k].toLowerCase()))){
							this.counter[1]++;
							}				
						}
						for(int k=0; k<closeCurtainsLem.length;k++){
							if(sentence[i][0].toLowerCase().contains((closeCurtainsLem[k].toLowerCase()))){
							this.counter[2]++;
							}				
						}
						
					}
					
					
					//finds the most matched function and returns the number of the function -- do not edit
					for(int j=0;j<this.counter.length;j++){
						if(this.counter[j] != 0 && this.counter[j] == this.switchMax){
							this.errorLevel = 1;
						}
						if(this.counter[j]>this.switchMax){
							this.switchNumber = j;
							this.switchMax=this.counter[j];
							this.errorLevel = 0;
						}
					}
					//checks to see if there was not a most matched, and if there was not a most matched it returns an error -- do not edit
					if(this.errorLevel != 0)
					{
						for(int i=0; i<sentence.length;i++){
							this.errorInput += (sentence[i][0] + " ");
						}
						System.out.println("We were unable to determine what change you were trying to make, could you please try this command again:" + this.errorInput);
						return 99;
					}
					
					
					switch (this.switchNumber){
					
					
					case 1: System.out.println("sending to case 1");
							openCurtains(sentence);
							break;
					case 2: System.out.println("sendind to case 2");
							closeCurtains(sentence);		
							break;					
					default:System.out.println("Nothing in the input sentence matched one of your arrays.");
							break;
					}
				
					
					return this.switchNumber;

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
					if(this.isOpen != false){
						this.isOpen = false;
						output.makeOutputWindow("I closed the curtains");
					}
					else{
						output.makeOutputWindow("The curtains are arlready closed");
					}
			}		
		}
				
				





public class Door {
	
	//variables used by this class, go ahead and edit these as you need for your functions and class templates.
	boolean isOpen;
	boolean isLocked;
	String listOfOps = "Open Door | Lock Door";
	
	//class constructor -- edit for your class name
	public Door(){		
	}
	
	//do not edit -- class function that accepts the input Array -- do not edit
	public void doSomething(String[][] taggedText) {
		this.lemLayer2(taggedText);
	}
	
	//lemmatization layer 1 arrays -- edit with your values
	/*1*/ String[] openDoorLem = {"open"};
	/*2*/ String[] closeDoorLem = {"close","shut"};
	/*3*/ String[] lockDoorLem = {"lock","secure"};
	/*4*/ String[] unlockDoorLem = {"unlock"};
	
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
		for(int i=0; i<sentence.length;i++){
			
			for(int k=0; k<openDoorLem.length;k++){
				if(sentence[i][0].toLowerCase().contains((openDoorLem[k].toLowerCase()))){
				counter[1]++;
				}				
			}
			for(int k=0; k<closeDoorLem.length;k++){
				if(sentence[i][0].toLowerCase().contains((closeDoorLem[k].toLowerCase()))){
				counter[2]++;
				}				
			}
			for(int k=0; k<lockDoorLem.length;k++){
				if(sentence[i][0].toLowerCase().contains((lockDoorLem[k].toLowerCase()))){
				counter[3]++;
				}				
			}
			for(int k=0; k<unlockDoorLem.length;k++){
				if(sentence[i][0].toLowerCase().contains((unlockDoorLem[k].toLowerCase()))){
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
			System.out.println("We were unable to determine what change you were trying to make, could you please try to rephrase this command:" + errorInput);
			return 99;
		}
		
		//switch based on which array is matched the most number of times 
		//insert your functions after the sysout and before the break like i have done with case 1.
		switch (switchNumber){
		
		case 1: //System.out.println("alarm method turnOn");
				this.openDoor();
				break;
		case 2: //System.out.println("alarm method turnOff");
				this.closeDoor();
				break;
		case 3: //System.out.println("alarm method callPolice");
				this.lockDoor();
				break;
		case 4: //System.out.println("heating method 4");
				this.unlockDoor();
				break;
		default:output.makeOutputWindow("We were unable to find a command that matched your request. The list of availble operations for the Alarm are: " + listOfOps);
				break;
		}		
		return switchNumber;
	}
	
	public void openDoor(){
		Window output = new Window();
		if(this.isOpen == false){
			this.isOpen = true;
			output.makeOutputWindow("the door is now open");
		}
		else{
			output.makeOutputWindow("the door is already open");
		}
	}
	public void closeDoor(){
		Window output = new Window();
		if(this.isOpen == true){
		this.isOpen = false;
		output.makeOutputWindow("the door is now closed");
		}
		else{
		output.makeOutputWindow("the door is already closed");
		}
	}
	public void lockDoor(){
		Window output = new Window();
		if(this.isLocked == false){
		this.isLocked = true;
		output.makeOutputWindow("the door is now locked");
	   }
		else{
			output.makeOutputWindow("the door is already locked");
		}
	}
	
	
	public void unlockDoor(){
		Window output = new Window();
		if(this.isLocked == true){
		this.isLocked = false;
		output.makeOutputWindow("the door is now unlocked");
		}
		else{
			output.makeOutputWindow("the door is already unlocked");
		}
	}
}
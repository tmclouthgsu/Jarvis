
public class Thermostat {


	
	boolean cutOn = false;
	String mode = "A/C";
	int temperature = 75;
	String listOfOps = "Turn the thermostat on | Turn the thermostat off | Check the thermostat temperature | Set the thermostat temperature";
	Window output = new Window();

	public void doSomething(String[][] taggedText) {
		this.lemLayer2(taggedText); 
		} 
	
	public Thermostat(){
		
		
		
		
	}
	
	String[] cutOnLem = {"on"};
	String[] turnOffLem = {"off"};
	String[] checkTemperatureLem = {"check","current","check","get","what"};
	String[] setTemperatureLem ={"set","set","change","hot","cold"};

	public int lemLayer2(String[][] sentence){
		
		
		int[] counter = new int[5];
		int switchNumber = 0;
		int switchMax = 0;
		int errorLevel = 0;
		String errorInput = "";
		
		for(int i=0; i<sentence.length;i++){
			
			for(int k=0; k<cutOnLem.length;k++){
				if(sentence[i][0].toLowerCase().equals((cutOnLem[k].toLowerCase()))){
				counter[1]++;
				}				
			}
			for(int k=0; k<turnOffLem.length;k++){
				if(sentence[i][0].toLowerCase().equals((turnOffLem[k].toLowerCase()))){
				counter[2]++;
				}				
			}
			for(int k=0; k<checkTemperatureLem.length;k++){
				if(sentence[i][0].toLowerCase().contains((checkTemperatureLem[k].toLowerCase()))){
				counter[3]++;
				}				
			}
			for(int k=0; k<setTemperatureLem.length;k++){
				if(sentence[i][0].toLowerCase().contains((setTemperatureLem[k].toLowerCase()))){
				counter[4]++;
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
		output.makeOutputWindow("We were unable to determine what change you were trying to make, could you rephrase this command:" + errorInput);
		return 99;
	}
	
	
	switch (switchNumber){

	
	case 1: System.out.println("turn on");
			turnOn(sentence);
			break;
	case 2: System.out.println("turn off");
			turnOff(sentence);
			break;
	case 3: System.out.println("check temp");
			checkTemperature(sentence);
			break;
	case 4: System.out.println("set temp");
			setTemperature(sentence);
			break;
	default:output.makeOutputWindow("We were unable to find a command that matched your request. The list of availble operations for the Thermostat are: \n" + listOfOps);
	break;
	
		}
		return switchNumber;

	}
	
	private void setTemperature(String[][] input){
		Window output = new Window();
		this.cutOn = true;
		for(int k=0; k<input.length;k++){
			if(input[k][1].contains("cd")){
					this.temperature = Integer.parseInt(input[k][0]);
					output.makeOutputWindow("The temperature is now set to " + this.temperature);
			}				
		}
		
	}
	
	private void turnOn(String[][] sentence) {
		Window output = new Window();
		if(this.cutOn == false){
			this.cutOn = true;
			output.makeOutputWindow("The thermostat is now on");
		}
		else{
			output.makeOutputWindow("Thermostat is already on.");
		}
		
	}
	
	public void turnOff(String[][] sentence)
	{
		Window output = new Window();
		if(this.cutOn == true){
			this.cutOn = false;
			output.makeOutputWindow("The thermostat is now off");
		}
		else{
			output.makeOutputWindow("The thermostat is already off");
		}
	}

	public void checkTemperature(String[][] sentence)
	{
		Window output = new Window();
		output.makeOutputWindow("The current temperature is " + this.temperature);
				
	}
	
}
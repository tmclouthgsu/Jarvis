
public class Curtains {
	
	//curtains variables
	boolean open = false;
	
	//lemmatization layer 2 arrays
	String[] openCurtainsLem = {"open"};
	String[] closeCurtainsLem = {"close"};
	
	//lemmatiztion must have variables for finding the correct output function
	public int[] counter = new int[100];
	int switchNumber;
	int switchMax;
	
	//lemmatization method
	public void lemCurtains(String[][] sentence){
		
		//iterate through sentence and count the matches for each layer 2 word
		for(int i=0; i<sentence[0].length;i++){
			
			//1
			if(sentence[0][i] == openCurtainsLem[0]){
				counter[1]++;
			}
			
			//2
			if(sentence[0][i] == closeCurtainsLem[0]){
				counter[2]++;
			}
		}
		
		//finds the most matched function and returns the number of the function
		for(int j=0;j<counter.length;j++){
			if(counter[j]>switchMax){
				switchNumber = j;
				switchMax=counter[j];
			}
			
		}

		
		// case statement for picking the function based on the most matched function
		switch (switchNumber){
		
		case 1: openCurtains();
				break;
		case 2: closeCurtains();
				break;
		}

	}
	
	
	//functions to be called by switch statement
	public void openCurtains(){
		if(open != true){
			open = true;
			System.out.println("I opened the curtains");
		}
		else{
			System.out.println("The curtains are arlready open");
		}
	}	
	public void closeCurtains(){
		if(open != false){
			open = false;
			System.out.println("I closed the curtains");
		}
		else{
			System.out.println("The curtains are arlready closed");
		}
	}
	

}

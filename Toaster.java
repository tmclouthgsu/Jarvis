
public class Toaster {

	private String setting;
	boolean isOn;
	boolean isOff;
	
	public void setHigh(){
		this.setting = "high";
	}
	public void setMedium(){
		this.setting = "medium";
	}
	public void setLow(){
		this.setting = "low";
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

	public int[] counter = new int[100];
	int switchNumber;
	int switchMax;
	
	String[] setHighLem = {"high"};
	String[] setMediumLem = {"medium"};
	String[] setLowLem = {"low"};
	String[] setOnLem = {"on"};
	String[] setOffLem = {"off"};
	
	
	public void lemToaster(String[][]sentence){
	
		for(int i=0; i <sentence[0].length; i++){
			if(sentence [0][i] == setHighLem[0]){
				counter[1]++;
			}
			if(sentence [0][i] == setMediumLem[0]){
				counter[2]++;
			}
			if (sentence [0][i] == setLowLem[0]){
				counter[3]++;
			}
			if (sentence [0][i] == setOnLem[0]){
				counter[4]++;
			}
			if (sentence [0][i] == setOffLem[0]){
				counter[5]++;
			}
		switch (switchNumber){
		case 1: setHigh();
						break;
		case 2: setMedium();
						break;
		case 3: setLow();
						break;
		case 4: turnOn();
						break;
		case 5: turnOff();
						break;
		}
		}
	}
		
	

 }

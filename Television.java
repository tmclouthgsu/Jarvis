
public class Television {
	
	private int volume;
	private int channel;
	private boolean powerOn;
	private boolean powerOff;
	
	
	public void channelUp(){
		channel = channel + 1;
	}
	
	public void channelDown(){
		channel = channel - 1;
	}
	public void setChannel(){
		//channel = this.channel;
		System.out.println("Setting Channel to " + this.channel + ".");
	}
	public void setVolume(){
		//volume = this.volume;
		System.out.println("Setting volume to " + this.volume + ".");
	}
	
	public void volumeUp(){
		volume = volume + 1;
	}
	
	public void volumeDown(){
		volume = volume - 1;
	}
	public void setPowerOn(){
		//powerOn = !powerOn;
		if(powerOff == true){
			powerOn = !powerOn;
			System.out.println("The television has been turned on.");
		}
		else{
			System.out.println("The television is already on.");
		}
	}
	
	public void setPowerOff(){
		if (powerOn == true){
			powerOn = !powerOn;
			System.out.println("The television has been turned off.");
	}
		else{
			System.out.println("The television is already off.");
	}
	
	
	public int[] counter = new int[100];
	int switchNumber;
	int switchMax;
	
	String[] setVolumeLem = {"volume"+ "sound"};
	String[] setChannelLem = {"channel" + "station"};
	String[] setPowerOnLem = {"on"};
	String[] setPowerOffLem = {"off"};
	
	public void lemTelevision(String[][] sentence){
		
		for(int i=0; i<sentence[0].length;i++){
			if(sentence [0][i] == setVolumeLem[0]){
				counter[1]++;
			}
			if(sentence [0][i] == setVolumeLem[1]){
				counter[1]++;
			}
			if(sentence [0][i] == setChannelLem[0]){
				counter[2]++;
			if(sentence [0][i] == setChannelLem[1]){
				counter[2]++;
			}
			if(sentence [0][i] == setPowerOnLem[0]){
				counter[3]++;
			}
			if(sentence [0][i] == setPowerOffLem[0]){
				counter[4]++;
			}
			}
			for(int j=0;j<counter.length;j++){
				if(counter[j]>switchMax){
					switchNumber = j;
					switchMax=counter[j];
				}
			switch (switchNumber){
			case 1: setVolume();
							break;
			case 2: setChannel();
							break;
			case 3: setPowerOn();
							break;
			case 4: setPowerOff();
							break;
			}
			
			}
			}
		}
	}
	public static void main(String[] args){
		
	}
		}
		

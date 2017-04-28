
public class Layer1Filter {

	public Layer1Filter() {

	}
		
		//lemmatization layer 1 arrays - weighting is done by the number of times the word appears in the array.
		/*1*/ String[] curtainsLem = {"curtain","drape","blind","curtain","blind"};
		/*2*/ String[] thermostatLem = {"thermostat","temperature","heating","a/c","air","conditioning","house","temp","thermostat","temperature","heating","a/c","air","conditioning","thermostat","temperature","heating","a/c","thermostat","temperature"};
		/*3*/ String[] televisionLem = {"television","channel","source","tv","tele","watch","program","television","channel","tv","television"};
		/*4*/ String[] lightsLem = {"light","lights","lighting","lights","bright"};
		/*5*/ String[] doorsLem = {"door","lock","unlock","door","outside"};
		/*6*/ String[] ovenLem = {"oven","bake","broiler","burner","stove","cook"};
		/*7*/ String[] toasterLem = {"toaster","toast","toast","toast","toast"};
		/*8*/ String[] spotifyLem = {"spotify","music","song","stream","shuffle","play","playlist"};
		/*9*/ String[] camerasLem = {"camera","shoot","snap","picture","video","record","watch"};
		/*10*/String[] alarmLem = {"alarm","alarm"};
		
		//lemmatiztion must have variables for finding the correct output function
		public int[] counter = new int[100];
		int switchNumber;
		int switchMax;
		int errorLevel;
		String errorInput = "";
		
		//lemmatization method
		public int lemLayer1(String[][] sentence){
			
			//iterate through sentence and count the matches for each layer 2 word
			for(int i=0; i<sentence.length;i++){
				
				for(int k=0; k<curtainsLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((curtainsLem[k].toLowerCase()))){
					this.counter[1]++;
					}				
				}
				for(int k=0; k<thermostatLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((thermostatLem[k].toLowerCase()))){
					this.counter[2]++;
					}				
				}
				for(int k=0; k<televisionLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((televisionLem[k].toLowerCase()))){
					this.counter[3]++;
					}				
				}
				for(int k=0; k<lightsLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((lightsLem[k].toLowerCase()))){
					this.counter[4]++;
					}				
				}
				for(int k=0; k<doorsLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((doorsLem[k].toLowerCase()))){
					this.counter[5]++;
					}				
				}
				for(int k=0; k<ovenLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((ovenLem[k].toLowerCase()))){
					this.counter[6]++;
					}				
				}
				for(int k=0; k<toasterLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((toasterLem[k].toLowerCase()))){
					this.counter[7]++;
					}				
				}
				for(int k=0; k<spotifyLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((spotifyLem[k].toLowerCase()))){
					this.counter[8]++;
					}				
				}
				for(int k=0; k<camerasLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((camerasLem[k].toLowerCase()))){
					this.counter[9]++;
					}				
				}
				for(int k=0; k<alarmLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((alarmLem[k].toLowerCase()))){
					this.counter[10]++;
					}				
				}
			}
			
			//finds the most matched function and returns the number of the function
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
			
			if(this.errorLevel != 0)
			{
				for(int i=0; i<sentence.length;i++){
					this.errorInput += (sentence[i][0] + " ");
				}
				System.out.println("We were unable to determine what object you were trying to make changes to, could you please try this command again:" + this.errorInput);
				return 99;
			}
			
			return this.switchNumber;

		}		

	}


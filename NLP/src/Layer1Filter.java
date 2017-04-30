
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
		/*8*/ String[] spotifyLem = {"spotify","music","song","stream","shuffle","play","play","playlist"};
		/*9*/ String[] camerasLem = {"camera","shoot","snap","picture","video","record","watch"};
		/*10*/String[] alarmLem = {"alarm","alarm","alarm","police","emergency"};
		
		//lemmatiztion must have variables for finding the correct output function

		//lemmatization method
		public int lemLayer1(String[][] sentence){
			
			int[] counter = new int[100];
			int switchNumber= 0;
			int switchMax=0;
			int errorLevel=0;
			String errorInput = "";
			
			
			//iterate through sentence and count the matches for each layer 2 word
			for(int i=0; i<sentence.length;i++){
				
				for(int k=0; k<curtainsLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((curtainsLem[k].toLowerCase()))){
					counter[1]++;
					}				
				}
				for(int k=0; k<thermostatLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((thermostatLem[k].toLowerCase()))){
					counter[2]++;
					}				
				}
				for(int k=0; k<televisionLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((televisionLem[k].toLowerCase()))){
					counter[3]++;
					}				
				}
				for(int k=0; k<lightsLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((lightsLem[k].toLowerCase()))){
					counter[4]++;
					}				
				}
				for(int k=0; k<doorsLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((doorsLem[k].toLowerCase()))){
					counter[5]++;
					}				
				}
				for(int k=0; k<ovenLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((ovenLem[k].toLowerCase()))){
					counter[6]++;
					}				
				}
				for(int k=0; k<toasterLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((toasterLem[k].toLowerCase()))){
					counter[7]++;
					}				
				}
				for(int k=0; k<spotifyLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((spotifyLem[k].toLowerCase()))){
					counter[8]++;
					}				
				}
				for(int k=0; k<camerasLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((camerasLem[k].toLowerCase()))){
					counter[9]++;
					}				
				}
				for(int k=0; k<alarmLem.length;k++){
					if(sentence[i][0].toLowerCase().contains((alarmLem[k].toLowerCase()))){
					counter[10]++;
					}				
				}
			}
			
			//finds the most matched function and returns the number of the function
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
			
			if(errorLevel != 0)
			{
				for(int i=0; i<sentence.length;i++){
					errorInput += (sentence[i][0] + " ");
				}
				System.out.println("I was unable to determine what object you were trying to manage, could you please try this command again:" + errorInput);
				return 99;
			}
			
			return switchNumber;

		}		

	}


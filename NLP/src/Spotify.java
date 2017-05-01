public class Spotify {
	//variables used by this class, go ahead and edit these as you need for your functions and class templates.
	boolean isOn = false;
	boolean isPaused = false;
	boolean isShuffle = false;
	String playing = "";
	int volume = 0;
	String tempPlaying = "";
	String listOfOps = "Set the volume | Set a (playlist) | Play a (song) | Turn On | Turn Off | Shuffle | Skip forward | Skip Backward | Pause";
	
	//lemmatization layer 1 arrays -- edit with your values
	/*1*/ String[] setVolumeLem = {"volume","loud","quiet"};
	/*2*/ String[] setPlaylistLem = {"playlist","list","station"};
	/*3*/ String[] playSongLem = {"play","listen"};
	/*4*/ String[] turnOnLem = {"on","on","stream"};
	/*5*/ String[] turnOffLem = {"off","close","stop"};
	/*6*/ String[] shuffleLem = {"shuffle","random"};
	/*7*/ String[] nextSongLem = {"skip","next","forward"};
	/*8*/ String[] previousSongLem = {"back","previous"};
	/*9*/ String[] pauseLem = {"pause","break",};
	/*10*/ String[] getPlayingLem = {"what","playing","get"};
	//class constructor -- edit for your class name
	public Spotify(){		
	}
	String[][] removePlaying(String[][] input){
		int startPosition = 0;
		int endPosition = 0;
		int k = 0;
		String playing = "";
		for(int i=0;i<input.length;i++){
			if(input[i][0].contains("-lrb-")){
				startPosition = i;
			}
			if(input[i][0].contains("-rrb-")){
				endPosition = i;
			}
		}
		String[][] output = new String[input.length-((endPosition-startPosition))][3];
		if(endPosition != 0){
			for(int j=0;j<input.length;j++){
				if(j==startPosition){
					j=endPosition;
				}
				output[k][0] = input[j][0];
				output[k][1] = input[j][1];
				System.out.println(output[k][0] + " " + output[k][1]);
				k++;
			}
			for(int s=startPosition+1;s<endPosition;s++){
				playing += input[s][0];
			}
			this.tempPlaying = playing;
		}
		else{
			output=input;
		}
		return output;
	}
	
	//do not edit -- class function that accepts the input Array -- do not edit
	public void doSomething(String[][] taggedText) {
		this.lemLayer2(removePlaying(taggedText));
	}

	
	//do not edit -- lemmatization method -- do not edit
	public int lemLayer2(String[][] sentence){
		
		//do not edit -- lemmatiztion must have variables for finding the correct output function -- do not edit
		int[] counter = new int[10];
		int switchNumber = 0;
		int switchMax = 0;
		int errorLevel = 0;
		String errorInput = "";
		Window output = new Window();
		
		//iterate through sentence and count the matches for each layer 2 word -- edit the names of the arrays to match your layer 2 word arrays.
		for(int i=0; i<sentence.length;i++){
			
			for(int k=0; k<setVolumeLem.length;k++){
				if(sentence[i][0].toLowerCase().startsWith((setVolumeLem[k].toLowerCase()))){
				counter[1]++;
				}				
			}
			for(int k=0; k<setPlaylistLem.length;k++){
				if(sentence[i][0].toLowerCase().startsWith((setPlaylistLem[k].toLowerCase()))){
				counter[2]++;
				}				
			}
			for(int k=0; k<playSongLem.length;k++){
				if(sentence[i][0].toLowerCase().startsWith((playSongLem[k].toLowerCase()))){
				counter[3]++;
				}				
			}
			for(int k=0; k<turnOnLem.length;k++){
				if(sentence[i][0].toLowerCase().startsWith((turnOnLem[k].toLowerCase()))){
				counter[4]++;
				}				
			}
			for(int k=0; k<turnOffLem.length;k++){
				if(sentence[i][0].toLowerCase().startsWith((turnOffLem[k].toLowerCase()))){
				counter[5]++;
				}				
			}
			for(int k=0; k<shuffleLem.length;k++){
				if(sentence[i][0].toLowerCase().startsWith((shuffleLem[k].toLowerCase()))){
				counter[6]++;
				}				
			}
			for(int k=0; k<nextSongLem.length;k++){
				if(sentence[i][0].toLowerCase().startsWith((nextSongLem[k].toLowerCase()))){
				counter[7]++;
				}				
			}
			for(int k=0; k<previousSongLem.length;k++){
				if(sentence[i][0].toLowerCase().startsWith((previousSongLem[k].toLowerCase()))){
				counter[8]++;
				}				
			}
			for(int k=0; k<pauseLem.length;k++){
				if(sentence[i][0].toLowerCase().startsWith((pauseLem[k].toLowerCase()))){
				counter[9]++;
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
		switch (switchNumber){
		
		case 1: //System.out.println("test method 1");
			this.setVolume(sentence);
				break;
		case 2: //System.out.println("alarm method turnOff");
			this.setPlaylist(sentence);	
				break;
		case 3: //System.out.println("alarm method callPolice");
				this.playSong(sentence);
				break;
		case 4: //System.out.println("alarm method turnOn");
				this.turnOn();
				break;
		case 5: //System.out.println("alarm method turnOff");
				this.turnOff();
				break;
		case 6: //System.out.println("alarm method callPolice");
				this.shuffle();
				break;
		case 7: //System.out.println("alarm method turnOn");
				this.nextSong();
				break;
		case 8: //System.out.println("alarm method turnOff");
				this.previousSong();
				break;
		case 9: //System.out.println("alarm method callPolice");
				this.pause();
				break;
		default:output.makeOutputWindow("We were unable to find a command that matched your request. The list of availble operations for Spotify are: \n" + listOfOps);
				break;
		}		
		this.tempPlaying = "";
		return switchNumber;
	}

	
	public void turnOff(){
		Window output = new Window();
		if(this.isOn == true){
		this.isOn = false;
		this.isPaused = false;
		this.isShuffle = false;
		this.playing = "";
		this.volume = 0;
		this.tempPlaying = "";
		output.makeOutputWindow("Spotify is now off");
		}
		else{
			output.makeOutputWindow("Spotify is already off");
		}
	}
	public void turnOn(){
		Window output = new Window();
		if(this.isOn == false){
		this.isOn = true;
		output.makeOutputWindow("Spotify is now on");
		}
		else{
			output.makeOutputWindow("Spotify is already on");
		}
	}	
	public void setVolume(String[][]input){
		Window output = new Window();
		if(this.isOn){
		for(int i=0; i<input.length;i++){
			if(input[i][1].endsWith("cd")){
				output.makeOutputWindow("Setting volume to " + Integer.parseInt(input[i][0]) + ".");
				this.volume = Integer.parseInt(input[i][0]);
			}
		}
		}
		else{
			output.makeOutputWindow("Spotify must be turned on before a volume can be selected");
		}
		
	}
	public void setPlaylist(String[][]input){
		Window output = new Window();
		if(this.isOn && this.tempPlaying.equals("")){
			output.makeOutputWindow("I was not able to find this Spotify playlist could you try surrounding it with parenthesis?");
		}
		else if(this.isOn){
			this.playing = this.tempPlaying;
			output.makeOutputWindow("Spotify is now playing the playlist " + this.playing);
			this.isPaused = false;
		}

		else{
			output.makeOutputWindow("Spotify must be turned on before a playlist can be selected");
		}
		
	}
	public void playSong(String[][]input){
		Window output = new Window();
		if(this.isOn && this.tempPlaying.equals("")){
			output.makeOutputWindow("I was not able to find this song could you try surrounding it with parenthesis?");
		}
		else if(this.isOn){
			this.playing = this.tempPlaying;
			output.makeOutputWindow("Spotify is now playing the song " + this.playing);
			this.isPaused = false;
		}

		else{
			output.makeOutputWindow("Spotify must be turned on before a song can be selected");
		}
		
	}
	public void shuffle(){
		Window output = new Window();
		this.isShuffle = true;
		this.isPaused = false;
		output.makeOutputWindow("I am now shuffling your favourite Spotify tracks");
	}
	public void nextSong(){
		Window output = new Window();
		output.makeOutputWindow("I am skipping this song on Spotify at your request");
	}
	public void previousSong(){
		Window output = new Window();
		this.isShuffle = true;
		output.makeOutputWindow("I am going to play the last song again at your request");
	}
	public void pause(){
		Window output = new Window();
		if(this.isOn){
		if(this.isPaused){
			output.makeOutputWindow("Spotify is already paused");
		}
		else{
		this.isPaused = true;
		output.makeOutputWindow("I am pausing Spotify");
		}
		}
		else{
			output.makeOutputWindow("Spotify is currently off");
		}
	}
	public void getPlaying(){
		Window output = new Window();
		if(this.isOn){
			if(!this.isPaused){
				output.makeOutputWindow("Spotify is currently playing " + this.playing);
			}
			else{
				output.makeOutputWindow("Spotify is currently paused while playing " + this.playing);
			}
		}
		else{
			output.makeOutputWindow("Spotify is currently Off");
		}
	}
}
import java.io.IOException;

public class Jarvis {

	public Jarvis() {
	}
	//INSTRUCTIONS ON USING NEW JARVIS FILE - Uncomment the object you are testing, make sure your file and class name are the same as the one listed below.
	//Then Uncomment the test code under the case you are testing.
	//change the string to match something in your code and see if it works!!
	
	static Alarm testAlarm = new Alarm();
	//static Curtain testCurtain = new Curtain();
	//static Thermostat testThermostat = new Thermostat();
	//static Camera testCamera = new Camera();
	//static Light testLight = new Light();
	//static Television testTelevision = new Television();
	//static Oven testOven = new Oven();
	//static Spotify testSpotify = new Spotify();
	//static Door testDoor = new Door();
	//static Toaster testToaster = new Toaster();

	public static void main(String[] args) throws Exception, IOException {
		String[] input = {"Turn the alarm on","Turn the alarm off","Turn the alarm"};
		
		// case statement for picking the function based on the most matched function
		for(int i=0;i<input.length;i++)
		{
			Layer1Filter device = new Layer1Filter();
			POSTagger tagger = new POSTagger();
			String[][] taggedInput = tagger.tag(input[i]);
			
		switch (device.lemLayer1(taggedInput)){
		
		case 1: System.out.println("sending to curtains");
		//testCurtain.doSomething(taggedInput);		
		break;
		case 2: System.out.println("sending to thermostat");
		//testThermostat.doSomething(taggedInput);		
		break;
		case 3: System.out.println("sending to television");
		//testTelevision.doSomething(taggedInput);		
		break;
		case 4: System.out.println("sending to lights");
		//testLight.doSomething(taggedInput);		
		break;
		case 5: System.out.println("sending to doors");
		//testDoor.doSomething(taggedInput);		
		break;
		case 6: System.out.println("sending to oven");
		//testOven.doSomething(taggedInput);
		break;
		case 7: System.out.println("sending to toaster");
		//testToaster.doSomething(taggedInput);
		break;
		case 8: System.out.println("sending to spotify");
		//testSpotify.doSomething(taggedInput);		
		break;
		case 9: System.out.println("sending to cameras");
		//testCamera.doSomething(taggedInput);
		break;
		case 10:System.out.println("sending to alarm");
		testAlarm.doSomething(taggedInput);
		break;
		default:System.out.println("Nothing in the input sentence matched one of your object arrays.");
		break;

		}
		
		}

	}

}

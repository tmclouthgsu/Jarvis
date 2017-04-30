import java.io.IOException;
import java.util.regex.Pattern;

public class Jarvis {

	public Jarvis() {
	}	
	
	static Alarm testAlarm = new Alarm();
	//static Curtain testCurtain = new Curtain();
	//static Thermostat testThermostat = new Thermostat();
	//static Camera testCamera = new Camera();
	//static Light testLight = new Light();
	static Television testTelevision = new Television();
	//static Oven testOven = new Oven();
	//static Spotify testSpotify = new Spotify();
	//static Door testDoor = new Door();
	static Toaster testToaster = new Toaster();
	
	static Layer1Filter device = new Layer1Filter();
	static POSTagger tagger = new POSTagger();

	public static void main(String[] args) throws Exception, IOException {
		Window inputWindow = new Window();
		String[] input = inputWindow.makeInputWindow().split(Pattern.quote("."));
		Window outputWindow = new Window();
			
		
		// case statement for picking the function based on the most matched function
		for(int i=0;i<input.length;i++)
		{

			String[][] taggedInput = tagger.tag(input[i]);
			
		switch (device.lemLayer1(taggedInput)){
		
		case 1: System.out.println("sending to curtains");
		//testCurtain.doSomething(taggedInput);		
		break;
		case 2: System.out.println("sending to thermostat");
		//testThermostat.doSomething(taggedInput);		
		break;
		case 3: System.out.println("sending to television");
		testTelevision.doSomething(taggedInput);		
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
		testToaster.doSomething(taggedInput);
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
		default:outputWindow.makeOutputWindow("I was unable to determine what object you wanted me to change, could you please try again. \nThe list of managed devices is: "
				+ "Curtains | Thermostat | Lights | Television | Doors | Oven | Toaster | Spotify | Cameras | Alarm");
		break;

		}
		}
		System.exit(0);

	}

}

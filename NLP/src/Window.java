
import javax.swing.*;

public class Window
{
	public String makeInputWindow(){
	
	JFrame inputFrame = new JFrame("Jarvis");

    // prompt the user to enter their task
    String task = JOptionPane.showInputDialog(inputFrame, "What can I help you with? \n \n You can enter multiple commands just please only one per sentence.", "Jarvis",JOptionPane.PLAIN_MESSAGE);
	if(task == null){
		System.exit(0);
	}
    // get the user's input. note that if they press Cancel, 'task' will be null
    return task;
  }
	public void makeOutputWindow(String output){
		
		JFrame outputFrame = new JFrame("Jarvis");
		JOptionPane.showMessageDialog(outputFrame, output, "Jarvis", JOptionPane.PLAIN_MESSAGE);
		return;
	}
}
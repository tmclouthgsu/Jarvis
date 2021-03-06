import java.io.IOException;
 
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
 
public class POSTagger {
	
	public static String[][] convertToArray(String input){
		String lowerInput = input.toLowerCase();
		String[] breakdown = lowerInput.split(" ");
		String[][] tagSplit = new String[breakdown.length][2];
		for(int i=0;i<breakdown.length;i++){
			//System.out.println(breakdown[i]);
			tagSplit[i] = breakdown[i].split("/");
			}
		return tagSplit;
	}
	
	public String[][] tag(String textToBeTagged) throws ClassNotFoundException, IOException{
		 
        // Initialize the tagger
        MaxentTagger tagger = new MaxentTagger("taggers/bidirectional-distsim-wsj-0-18.tagger");
 
        // The sample string
        String input = textToBeTagged;
 
        // The tagged string
        String taggedString = tagger.tagString(input);
        
        // Output the result
        //System.out.println(tagged);
        
        String[][] taggedArray = convertToArray(taggedString);
        
        return taggedArray;
        //Layer1Filter myFilter = new Layer1Filter();
        //myFilter.lemLayer1(taggedArray);
      
        //this code breaks the tagged string then checks for a tagged type "cd" and then for each "nn" tagged will print (setting the "nn" to "cd")
    		//String[] breakdown = tagged.split(" ");
	}
}
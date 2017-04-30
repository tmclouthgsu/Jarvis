import java.io.IOException;
 
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
 
public class POSTagger {
	
	public static String[][] convertToArray(String input){
		String[] breakdown = input.toLowerCase().split(" ");
		String[][] tagSplit = new String[breakdown.length][2];
		for(int i=0;i<breakdown.length;i++){
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
        
        String[][] taggedArray = convertToArray(taggedString);
        
        
        return taggedArray;
	}
}
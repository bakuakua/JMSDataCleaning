package preprocess;
import java.util.ArrayList;
/*	Utilities for pre-processing data in .csv format
 *  which helps to trim the .csv file into smaller 
 *  sizes with only relevant features. 
 */
public class preprocessUtils{
	/*	Transform a string sequence into an arrayList of strings that 
	 * 	splits at ',', and treats strings enclosed by "" as a string token
	 * 
	 *  @param line
	 *  	line: a string that represents a line of a .csv file.
	 *  
	 * 	@return ArrayList<String> 
	 * 		an arraylist of strings in which each element represents a string
	 * 		token of an particular feature
	 */
	public static ArrayList<String> parseLine(String line){
		ArrayList<String> rtn = new ArrayList<String>();
		if (line == null){
			return rtn;
		}
		else{
			int currentsplitlocation = 0;
			int nextsplitlocation = getNextSplitLoc(line, 0);
			rtn.add(line.substring(currentsplitlocation,nextsplitlocation));
				while(nextsplitlocation<line.length()){
					currentsplitlocation = nextsplitlocation+1;
					nextsplitlocation = getNextSplitLoc(line, currentsplitlocation);
					rtn.add(line.substring(currentsplitlocation, nextsplitlocation));
					
				}
		}
		return rtn;
	}
	/*	A helper function to parseLine(), it calculates the next legal
	 * 	split location in the input string based on current split location
	 * 	
	 * 	@param line, currentsplitlocation
	 * 		line : a string that represents a line of a .csv file.
	 * 		currentsplitlocation : the current split location in the string which 
	 * 							   is used to find the next split location
	 * 
	 * 	@return the index of the next legal split location in the string
	 * 
	 */
	public static int getNextSplitLoc(String line, int currentsplitlocation){
		int nextsplitlocation = currentsplitlocation;
		for (int i = currentsplitlocation; i<line.length();i++){
			if (line.charAt(i) == ',' && (OccurrenceOf(line.substring(currentsplitlocation,i),'"') == 2 ||OccurrenceOf(line.substring(currentsplitlocation,i),'"')==0)){
				nextsplitlocation = i;
				break;
			}
			if (i + 1 == line.length()){
				nextsplitlocation = i+1;
				break;
			}
		}
		return nextsplitlocation;
	}
	/*	a helper function to getNextSplitLoc()
	 * 	it counts the occurrence of an arbitrary character
	 * 	in a input string
	 * 	
	 * 	@param str, x
	 * 		str : a string of interest
	 * 		x : the character being looked in the string
	 * 
	 *  @return int 
	 *  	an integer that represents the number of occurrence of x in str
	 * 
	 */
	public static int OccurrenceOf(String str, char x){
		int count = 0;
		for (int i = 0; i<str.length(); i++){
			if (str.charAt(i)== x){
				count++;
			}
		}
		return count;
	}
	
}

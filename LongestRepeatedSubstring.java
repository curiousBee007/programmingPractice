import java.util.*;
public class LongestRepeatedSubstring {
	
	public String returnLongestSubstring(String s){
	    
	    if(s == null ||s.length() == 0)
	      return null;
	    
	    int length = s.length();
	    int maximumLength = 1;
	    int startIndex = 0;
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    for(int i = 0 ; i < length ; i++){
	      for(int j = i+1; j <= length; j++){
	         String substr = s.substring(i,j);
	        if(map.containsKey(substr)){
	           int value = map.get(substr);
	          
	           if(value > maximumLength){
	             maximumLength = value;
	             startIndex = i;
	           }
	        }
	        else{
	            int length1 = j -i;
	            map.put(substr,length1);
	         }
	      }
	    }
	   
	    String largestValue = s.substring(startIndex,startIndex + maximumLength);
	    return largestValue;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s = "aaabbbcccc";
       LongestRepeatedSubstring obj = new LongestRepeatedSubstring();
       String m = obj.returnLongestSubstring(s);
       System.out.println(m);
       
	}

}

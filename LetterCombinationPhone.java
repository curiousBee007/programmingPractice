import java.util.*;
public class LetterCombinationPhone {
	
	private String[] KEYS = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
      
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0)
          return result;
        letterCombination("",result,0,digits);
        return result;
    
    }
    
    public void letterCombination(String prefix, List<String> result, int offset,String digits){
        if(prefix.length() == digits.length()){
            result.add(prefix);
            return;
        }
        String letter = KEYS[(digits.charAt(offset)-'0')];
       
         for(int i = 0 ; i < letter.length() ; i++){
            letterCombination(prefix+letter.charAt(i), result, offset+1,digits);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String inputString = "23";
        LetterCombinationPhone obj = new LetterCombinationPhone();
        List<String> resultString = obj.letterCombinations(inputString);
        for(String s: resultString) {
        	System.out.println(s);
        }
	}

}

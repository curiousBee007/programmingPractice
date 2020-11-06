import java.util.*;

public class MakeSpace {
	
	 public static List<ArrayList<Integer>> returningParentList(int[][] parentChildPairs){
		  
		   HashMap<Integer,ArrayList<Integer>> parentMap = new HashMap<Integer,ArrayList<Integer>>();
		    
		    int length = parentChildPairs.length;
		    for(int i = 0 ; i < length ; i++){
		         int parentElement = parentChildPairs[i][0];
		         int childElement = parentChildPairs[i][1];
		      
		         if(!parentMap.containsKey(childElement)){
		           ArrayList<Integer> tempList = new ArrayList<Integer>();
		           tempList.add(parentElement);
		          parentMap.put(childElement,tempList);
		         
		         }
		         else if(parentMap.containsKey(childElement)){
		         
		           ArrayList<Integer> tempList = parentMap.get(childElement);
		           tempList.add(parentElement);
		           parentMap.put(childElement,tempList);
		         }   
		            
		       if(!parentMap.containsKey(parentElement)) 
		       {
		           ArrayList<Integer> tempList = new ArrayList<Integer>();
		           parentMap.put(parentElement,tempList);
		       }
		      
		    }
		    
		    
		    //Iterating over hashMap 
		    ArrayList<Integer> parentZero = new ArrayList<Integer>();
		    ArrayList<Integer> parentTwo = new ArrayList<Integer>();
		    
		    Set set = parentMap.entrySet();
		    Iterator iterator = set.iterator();
		    while(iterator.hasNext()){
		    Map.Entry mentry = (Map.Entry)iterator.next();
		    int key = (int)(mentry.getKey());
		    ArrayList<Integer> tempList =  (ArrayList<Integer>)(mentry.getValue());
		      if(tempList.size() == 0){
		         parentZero.add(key);
		      }
		      
		      if(tempList.size() == 1){
		         parentTwo.add(key);
		      }
		    
		    }
		  
		 List<ArrayList<Integer>> finalList = new ArrayList<>();
		    finalList.add(parentZero);
		    finalList.add(parentTwo);
		    
		    return finalList;
		  
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] parentChildPairs = new int[][] {
	        {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
	        {4, 5}, {4, 8}, {8, 9}
	    };
	    System.out.println(returningParentList(parentChildPairs));
	}

}

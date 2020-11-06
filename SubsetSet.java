import java.util.*;

public class SubsetSet {

	 public List<List<Integer>> subsets(int[] nums) {
		    List<List<Integer>> list = new ArrayList<>();
		    Arrays.sort(nums);
		    backtrack(list, new ArrayList<>(), nums, 0);
		    return list;
		}

		private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
		    list.add(new ArrayList<>(tempList));
		    for(int i = start; i < nums.length; i++){
		        tempList.add(nums[i]);
		        backtrack(list, tempList, nums, i + 1);
		        tempList.remove(tempList.size() - 1);
		    }
		}
		
	
		/*public List<List<Integer>> subsets(int[] nums) {
	       List<List<Integer>> allSubsets = new ArrayList<List<Integer>>();
	        int max = 1 << nums.length;
	        
	        for(int k = 0 ; k < max ;k++){
	            
	            ArrayList<Integer> subset = convertIntToSet(k,nums);
	            allSubsets.add(subset);
	            
	        }
	        return allSubsets;
	        
	    }
	    
	    public ArrayList<Integer> convertIntToSet(int k,int nums[]){
	        int index = 0;
	        ArrayList<Integer> arrList = new ArrayList<Integer>();
	        
	        for(int x = k; x > 0; x = x >> 1){
	            if((x & 1) == 1){
	                arrList.add(nums[index]);
	            }
	            
	            index++;
	        }
	       return arrList; 
	    }*/
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int a[] = {1,2,3};
       SubsetSet obj = new SubsetSet();
       List<List<Integer>> subsets1 = obj.subsets(a);
       for(List<Integer> l: subsets1) {
    	   System.out.println(l);
       }
	}

}


public class FindPower {
	
	//Q. Given two integers X and N, compute X^N in a function.

	// 2^3 = (2^2) * 2
	//2^4 = (2^2) * (2^2) 


	public int findPower(int X, int N){
	   
	    if(N == 0)
	       return 1;
	       
	    if(N == 1)
	       return X;
	       
	    if(N == 2)
	       return X*X;   

	    int quotient = N/2;
	    int remainder = N%2;
	    int multVal = 1;
	   
	   if(remainder == 1)
	     multVal = X;
	     
	   int reducedPower = findPower(X,quotient);
	   
	   return reducedPower * reducedPower * multVal;
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int X = 2;
		int Y = 7;
		FindPower obj = new FindPower();
		int result = obj.findPower(-2, 7);
		System.out.println(result);
		

	}

}

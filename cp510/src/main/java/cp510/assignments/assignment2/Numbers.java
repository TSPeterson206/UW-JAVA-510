package cp510.assignments.assignment2;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Numbers {
	
	public static void main(String[] args) {
		
		boolean result = isPrime(5);
		System.out.println("result of isPrime(5) "+ result);
		
		int result2 = lcm(210,16);
		System.out.println("result of lcm(210,16) " + result2);
		
		int result3 = gcf(125,55);
		System.out.println("result of  gcf(125,55)" + result3);
		
		
	double[] array1= {1.0, 1.0, 0.5, -2.2, -0.3, 0.5, -0.4, 3.2};	
//	double[] array1= {1, -2,-1};	

		double result4 = mean(array1);
		System.out.println("result of mean(1.0, 1.0, 0.5, -2.2, -0.3, 0.5, -0.4, 3.2) "+result4);
		
		double[] array2 = {-0.8, -0.5, -0.12, 0.3, 0.6, 22.0};
		double result5 = median(array2);
		System.out.println("result of median(-0.8, -0.5, -0.12, 0.3, 0.6, 22.0)"+result5);
		
		long result6 = factorial(3);
		System.out.println("result of factorial(3)"+result6);
		
		BigInteger result7 = factorial(BigInteger.valueOf(45));
		System.out.println("factorial of 45 : " + result7);
};
	
	public static boolean isPrime(int num) {
		for(int i = 2; i < num; i++) {
	        if(num%i == 0) {
	            return false;
	        }
	    }
	    return num > 1;
	};
	
	public static int lcm( int param1, int param2 ) {
		int larger = Math.max(param1,param2);
		int smaller = Math.min(param1,param2);
		
		int current = larger;
		  while(current % smaller != 0){
		    current += larger;
		  }
		
		return current;
	};
	
	public static int gcf( int param1, int param2 ) {
		int greatestCommon = 1;
	    for (int i = 1; i <= param1 && i <= param2; i++) {
	        if (param1 % i == 0 && param2 % i == 0) {
	            greatestCommon = i;
	        }
	    }
	    return greatestCommon;
	    	};
	    	
	public static double mean( double[] arr ) {
		
		Set<Double> linkedHashSet = new LinkedHashSet<Double>();
		
		
	    double sum = 0;
	    for (double i : arr) {
	    	System.out.println(i);
	    	linkedHashSet.add(i);
	    	}
	    System.out.println(linkedHashSet);
	    for(double j : linkedHashSet) {
	    	sum += j;
	    	System.out.println(sum);
	    };
	    System.out.println(linkedHashSet);

	    return sum/linkedHashSet.size();
	    	};
	    	
	public static double median( double[] arr ) {
		if(arr.length==1) {return arr[0];};
		double[] sortableArray = arr;
		Arrays.sort(sortableArray);
		if(arr.length%2 != 0) {
			double middle = sortableArray.length/2 - 0.5;
			return sortableArray[(int) middle];
					} else {
						double middleLeft=sortableArray.length/2 - 0.5;
								double middleRight=sortableArray.length/2 + 0.5;
								return (sortableArray[(int) middleLeft]+sortableArray[(int) middleRight])/2;
					}
	};
	
	public static long factorial( long num ) {
		if(num == 0) {return 1;} else if(num>20){throw new IllegalArgumentException();};
		long fact = 1;
	    for (int i = 2; i <= num; i++) {
	        fact = fact * i;
	    }
	    return fact;
	};
	
	public static BigInteger factorial( BigInteger num ) {
		if (num == BigInteger.ZERO || num == BigInteger.ONE) { return BigInteger.ONE; } 
		return num.multiply(factorial(num.subtract(BigInteger.ONE)));
	};
	
}
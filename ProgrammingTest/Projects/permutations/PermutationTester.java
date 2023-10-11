package permutations;

/** This class measures the performance of the permutation algorithms */

//import java.util.Random;

public class PermutationTester 
{

	public static void main(String[] arg) {
		Permutations p = new Permutations();
		
		int[] perm = new int[6];
		p.algorithm1(perm);//346125 6 steps
		p.algorithm2(perm);//135624 13 steps
		p.algorithm3(perm);//145632 12 steps
		
		
	}

}
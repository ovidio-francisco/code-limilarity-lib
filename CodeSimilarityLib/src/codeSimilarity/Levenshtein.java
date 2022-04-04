package codeSimilarity;

public class Levenshtein {
	private static int max(int a, int b) {
		return a > b ? a : b;	
	}

	private static int min(int a, int b) {
		return a < b ? a : b;
	}

	private static int min(int a, int b, int c) {
		int result = a;

		if (b<result) result = b;
		if (c<result) result = c;
		
		return result;
	}


	public static int compare(String[] c1, String[] c2) {
		int t1 = c1.length;
		int t2 = c2.length;


		int[][] m = new int[t1+1][t2+1];
		
		for(int i=0; i<=t1; i++) 
			for(int j=0; j<=t2; j++)
				if (min(i,j) == 0)
					m[i][j] = max(i,j);
				else
					m[i][j] = min(
						  	     m[i-1][j]+1,
								 m[i][j-1]+1,
								 m[i-1][j-1] + (!c1[i-1].equals(c2[j-1]) ? 1 : 0)
							     );

		return m[t1][t2];
	}

}

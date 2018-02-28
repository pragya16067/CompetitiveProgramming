//NAME : PRAGYA PRAKASH

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class ProbA2 {


	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int n=Reader.nextInt();
		int m=Reader.nextInt();
		int[] A=new int[n];
		
		for(int i=0; i<n; i++)
		{
			A[i]=Reader.nextInt();
		}
		
		
		if (n==m)
		{
			Arrays.sort(A);
			System.out.println(A[A.length-1]);
		}
		
		else
		{
			Arrays.sort(A);
			int low=1;
			int high=A[A.length-1];
			
			//Applying Binary Search
			while(low < high)
			{
				int mid=low + (high-low)/2;
				int reqmics = 0;
				for(int i=0; i<A.length; i++)
				{
					int ans=0;
					if(A[i] % mid!=0)
						ans= A[i]/mid+1;
					else
						ans=A[i]/mid;
					reqmics = reqmics+ (int)ans;
				}
				
				if(reqmics <= m)
				{
					high=mid;
				}
				else
				{
					low = mid+1;
				}
			}
			System.out.println(low);
		}

	}

}


/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
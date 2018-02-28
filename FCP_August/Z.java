//Name : PRAGYA PRAKASH

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Z {
	
	public static long getSum(int[] s) {
		long sum=0;
		for(int i=0; i<s.length; i++)
		{
			sum=sum+s[i];
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int T=Reader.nextInt();
		while(T-- > 0)
		{
			int N=Reader.nextInt();
			int K=Reader.nextInt();
			int minindex=0;
			int[] A=new int[N];
			for(int i=0; i<N; i++)
			{
				A[i]=Reader.nextInt();
				if(A[i]>=0)
				{
					minindex=i;
				}
				
			}
			
			Arrays.sort(A);
			
			//To find the min index of positive number in array
			for(int i=0; i<N; i++) {
				if(A[i] < A[minindex] && A[i]>=0)
				{
					minindex=i;
				}
			}
			//System.out.println(minindex);
			
			int i=0;
			for(int ctr=K; ctr>0; ctr--)
			{
				if(A[i]>0)
				{//If you reach a positive number just change its sign remaining k times
					if(ctr%2==0)
						break;
					else
					{
						A[minindex]=(-1)*A[minindex];
						break;
					}
				}
				else
				{//For negative numbers change sign and check if minimum needs updation
					A[i]=(-1)*A[i];
					if(A[i]<A[minindex])
						minindex=i;
				}
				i++;
				if(i==N)
				{
					Arrays.sort(A);
					i=0;
				}
			}
			
			System.out.println(getSum(A));
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
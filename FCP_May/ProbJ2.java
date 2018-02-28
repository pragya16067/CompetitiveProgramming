import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProbJ2 {
	
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		long T=Reader.nextLong();
		BigInteger out=BigInteger.valueOf(0);
		long M=1000000007;
		while(T-- > 0)
		{
			long N=Reader.nextLong();
			Long[] A=new Long[(int) N];
			
			for (int k = 0; k < N; k++)
			{
				 A[k]=Reader.nextLong();
			}
			Arrays.sort(A);
			
			out=BigInteger.valueOf(0);
			 
			//BigInteger x = BigInteger.valueOf(1);
			long[] X=new long[(int) N];
			long x=1;
			X[0]=x;
			N=N-1;
		    for (int k=0; k < N; k++)
		    {
		    	x=X[k]*(N-k)/(k+1); 
		    	X[k+1]=x;
		    }
		    //System.out.println();
		    for (int k=0; k < N+1; k++)
		    {
		    	BigInteger a=BigInteger.valueOf(A[k]*X[k]).mod(BigInteger.valueOf(M));
		    	//out=out.add(BigInteger.valueOf(A[k]*X[k]));
		    	out=out.add(a);
		    }
			System.out.println(out.mod(BigInteger.valueOf(M)));
			//System.out.println();
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




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProbJ {
	
	public static BigInteger nCr(long n, long r,long M)
	{
		//System.out.prlongln(n+" "+r);
		if(n<r)
			return BigInteger.valueOf(0);
		else if(r==0 || n==r)
		{
			return BigInteger.valueOf(1);
		}
		else
		{
			if(r>n-r)
			{
				r=n-r;
			}
			BigInteger fact=BigInteger.valueOf(1);
			BigInteger rfact=BigInteger.valueOf(1);
			BigInteger k=BigInteger.valueOf(r);
			for(long i=n; i>n-r; i--)
			{
				fact=fact.multiply(BigInteger.valueOf(i));
				rfact=rfact.multiply(k);
				k=k.subtract(BigInteger.valueOf(1));
				
			}
			
			return (fact.divide(rfact)).mod(BigInteger.valueOf(M));
		
		}
	}

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		long T=Reader.nextLong();
		long ans=0;
		BigInteger out=BigInteger.valueOf(0);
		while(T-- > 0)
		{
			long N=Reader.nextLong();
			out=BigInteger.valueOf(0);
			Long[] A=new Long[(int) N];
			for (int k = 0; k < N; k++)
			{
				 A[k]=Reader.nextLong();
			}
			Arrays.sort(A);
			for(int i=0; i<N;i++)
			{
				//ans=Reader.nextLong()%1000000007 * nCr(N-1,i,1000000007).longValue();
				ans=A[i]%1000000007 * nCr(N-1,i,1000000007).longValue();
				out=out.add(BigInteger.valueOf((ans%1000000007)));
				//System.out.println(out);
			}
			
			/*Long[] A=new Long[(int) N];
			for (int k = 0; k < N; k++)
			{
				 A[k]=Reader.nextLong();
			}*/
			/*
			int x = 1;
			N=N-1;
		    for (int k = 0; k <= N; k++)
		    {
		        //System.out.print(x+" ");
		        //out=out+ (A[k]*x);
		    	out=out.add(BigInteger.valueOf(Reader.nextLong()*x));
		        x = x * ((int) N - k) / (k + 1);
		        
		    }*/
		    //System.out.println();
			System.out.println(out.mod(BigInteger.valueOf(1000000007)));
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


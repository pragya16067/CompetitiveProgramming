import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;
 
// REFERENCE : https://math.stackexchange.com/questions/989862/find-the-coefficient-of-x24-in-1-x-x2-x3-x4-x58/989889
 
class SANDWICH {
	
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
			
			return (fact.divide(rfact));
		
		}
	}
	
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		long T=Reader.nextLong();
	
		while(T-- > 0)
		{
			long N=Reader.nextLong();
			long K=Reader.nextLong();
			long M=Reader.nextLong();
			
			double n=(double) N;
			long r=(long) Math.ceil(n/K);
			//r=N/K+1;
			
			System.out.print(r+" ");
			
			
			
			if(N%K==0)
			{
				System.out.print(1%M);
				System.out.println();
			}
			else
			{
				//coefficient of x^n in equation
				BigInteger coeff=BigInteger.valueOf(0);
				//thus we need to find all pairs of a and b such that Ka+b=N
				long a=0;
				long b=0;
				long x=N/K*(K-N%K);
				long y=(K-N%K+1);
				for(long i=0; i<r; i++)
				{
					a=i;
					b=x - i*y;
					//System.out.println(a+" "+b);
					if(b<0)
						break;
					else
					{
						if(a%2==0)
						{
							coeff=coeff.add((nCr(r+b-1,b,M)).multiply(nCr(r,a,M)));
						}
						else
						{
							coeff=coeff.subtract((nCr(r+b-1,b,M)).multiply(nCr(r,a,M)));
						}
					}
				}
				System.out.print(coeff.mod(BigInteger.valueOf(M)));
				System.out.println();
			}
			
		}
	}
	
}
 
 
 
/** Class for buffered reading long and double values */
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
    
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
} 
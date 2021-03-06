import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

class SUMQ {
	
	public static int getIndex(int[] X, int start, int rel) {
		int i;
		for(i=start; i<X.length; i++)
		{
			if(X[i]>rel)
			{
				return (i-1);
			}
		}
		
		return (i-1);
	}

	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int T=Reader.nextInt();
		while(T-- > 0)
		{
			int Alen=Reader.nextInt();
			int Blen=Reader.nextInt();
			int Clen=Reader.nextInt();
			
			int[] A=new int[Alen];
			int[] B=new int[Blen];
			int[] C=new int[Clen];
			
			for(int i=0; i<Alen; i++)
			{
				A[i]=Reader.nextInt();
			}Arrays.sort(A);
			
			long[] Asum=new long[Alen];
			long sum=0;
			for(int i=0; i<Alen; i++)
			{
				sum=(sum+A[i]) % 1000000007 ;
				Asum[i]=sum;	
			}
			
			for(int i=0; i<Blen; i++)
			{
				B[i]=Reader.nextInt();
			}Arrays.sort(B);
			
			for(int i=0; i<Clen; i++)
			{
				C[i]=Reader.nextInt();
			}Arrays.sort(C);
			
			long[] Csum=new long[Clen];
			long sumC=0;
			for(int i=0; i<Clen; i++)
			{
				sumC=(sumC+C[i]) % 1000000007;
				Csum[i]=sumC;	
			}
			
			
			int y=0;
			int Astart=0;
			int Cstart=0;
			long sumfinal=0;
			
			for(int i=0; i<Blen; i++)
			{
				y=B[i];
				long sumy=0;
				
				int Aindex=getIndex(A,Astart,y);
				if (Aindex==-1)
				{
					Aindex=0;
					continue;
				}
				Astart=Aindex;
				long sum1 = (Asum[Aindex] + (((y % 1000000007)*((Aindex+1) % 1000000007)) % 1000000007)) % 1000000007;
				
				int Cindex=getIndex(C,Cstart,y);
				if (Cindex==-1)
				{
					Cindex=0;
					continue;
				}
				Cstart=Cindex;
				long sum2 = (Csum[Cindex] + (((y % 1000000007)*((Cindex+1) % 1000000007))% 1000000007)) % 1000000007;
				
				sumy=(sum1 * sum2) % 1000000007;
			    sumfinal=(sumfinal+sumy) % 1000000007 ;
				}
			
			
			System.out.println(sumfinal);
			
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


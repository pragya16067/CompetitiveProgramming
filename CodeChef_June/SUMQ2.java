
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

class SUMQ2 {
	
	/*public static int f(int x, int y, int z) {
		if(x<=y && z<=y)
		{
			long ans=((x+y)*(y+z));
			return (int)(ans % 1000000007);
		}
		else
		{
			return 0;
		}
	}*/

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
			
			for(int i=0; i<Blen; i++)
			{
				B[i]=Reader.nextInt();
			}Arrays.sort(B);
			
			for(int i=0; i<Clen; i++)
			{
				C[i]=Reader.nextInt();
			}Arrays.sort(C);
			
			int x=0;
			int y=0;
			int z=0;
			long sumfinal=0;;
			for(int i=0; i<Blen; i++)
			{
				y=B[i];
				long sumy=0;
				long sum1=0;
				long sum2=0;
				int j=0;
				int k=0;
				while(A[j]<=y && C[k]<=y)
				{
					
					x=A[j];
					sum1=(sum1+x+y) % 1000000007;
					z=C[k];
					sum2=(sum2+z+y) % 1000000007;
					if(j<A.length-1)
						j++;
					else 
						break;
					
					if(k<C.length-1)
						k++;
					else 
						break;
				}
				
				while(A[j]<=y)
				{
					
					x=A[j];
					sum1=(sum1+x+y) % 1000000007;
					if(j<A.length-1)
						j++;
					else 
						break;
				}
				while(C[k]<=y)
				{
					
					z=C[k];
					sum2=(sum2+z+y) % 1000000007;
					if(k<C.length-1)
						k++;
					else 
						break;
				}
				
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



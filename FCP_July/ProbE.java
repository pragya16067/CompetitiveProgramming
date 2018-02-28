import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ProbE {
	
	static int[] getGE(int arr[], int n) {
		int[] NGE=new int[n];
		int ge=arr[n-1];
		for(int i=n-2; i>=0; i--)
		{
			int element=arr[i];
			if(element < ge)
			{
				NGE[i]=ge;
				continue;
			}
			else
			{
				ge=element;
				continue;
			}
			
		}
		return NGE;
	}
	
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int N=Reader.nextInt();
		int[] A=new int[N];
		
		for(int i=0; i<N; i++)
		{
			A[i]=Reader.nextInt();
		}
		
		long total=0;
		int[] NGE=getGE(A,N);
		/*for(int i=0; i<N; i++)
		{
			System.out.print(NGE[i]+" ");
		}
		System.out.println();*/
		
		for(int i=0; i<N; i++)
		{
			if(NGE[i]==0)
			{
				continue;
			}
			else
			{
				total=total + (NGE[i]-A[i]);
			}
		}
		System.out.println(total);
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
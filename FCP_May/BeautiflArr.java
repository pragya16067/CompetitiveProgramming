import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeautiflArr {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int n=Reader.nextInt();
		int[] A=new int[n];
		
		for(int i=0; i<n; i++)
		{
			A[i]=Reader.nextInt();
		}
		
		int temp;
		for(int i=1; i<n; i++)
		{
			if((i+1)%2==0)
			{
				if(A[i]<A[i-1])
				{
					temp=A[i];
					A[i]=A[i-1];
					A[i-1]=temp;
				}
			}
			else
			{
				if(A[i]>A[i-1])
				{
					temp=A[i];
					A[i]=A[i-1];
					A[i-1]=temp;
				}
			}
		}
		
		for(int i=0; i<n;i++)
		{
			System.out.print(A[i]+" ");
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

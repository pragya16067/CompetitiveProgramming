import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class MXMEDIAN {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int T=Reader.nextInt();
		
		while(T-- > 0)
		{
			int N=Reader.nextInt();
			int[] A=new int[2*N];
			int[] B=new int[N];
			for(int i=0; i<2*N; i++)
			{
				A[i]=Reader.nextInt();
			}
			Arrays.sort(A);
			for(int j=N; j<2*N; j++)
			{
				B[j-N]=A[j];
			}
			System.out.println(B[(N-1)/2]);
			for(int i=0; i<N; i++)
			{
				System.out.print(A[i] + " " + B[i] + " ");
			}
			System.out.println();
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
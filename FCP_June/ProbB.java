import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProbB {
	
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int N=Reader.nextInt();
		int M=Reader.nextInt();
		int V=Reader.nextInt();
		
		int B=Reader.nextInt();
		int G=Reader.nextInt();
		int H=Reader.nextInt();
		
		while(M-- > 0)
		{
			//roads
			int x=Reader.nextInt();
			int y=Reader.nextInt();
			int L=Reader.nextInt();
		}
		
		while(V-- > 0)
		{
			//Destinations
			int Z=Reader.nextInt();
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
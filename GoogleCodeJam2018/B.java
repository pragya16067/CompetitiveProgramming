import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {

	
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int T= Reader.nextInt();
		PrintWriter writer = new PrintWriter("Output.txt", "UTF-8");
		int Caseno=1;
		while(T-- > 0) {
			int L= Reader.nextInt();
			while(L-- > 0)
			{
				
			}
			
			System.out.println("Case #"+Caseno+": ");
			writer.println("Case #"+Caseno+": ");
			Caseno++;
		}
		
		
		
		writer.close();
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


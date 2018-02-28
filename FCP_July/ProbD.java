import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProbD {
	
	static long gcd(long a, long b)
    {
        if(b==0)
        	return a;
        else
        	return gcd(b,a%b);
    }
     
    // method to return LCM of two numbers
    static long lcm(long a, long b)
    {
        return (a*b)/gcd(a, b);
    }

    
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		long N=Reader.nextLong();
		long A=Reader.nextInt();
		long B=Reader.nextInt();
		long C=Reader.nextInt();
		long a=N/A;
		long b=N/B;
		long c=N/C;
		
		long lcm1=lcm(A,B);
		long lcm2=lcm(B,C);
		long lcm3=lcm(A,C);
		long lcm4=lcm(lcm1,C);
		
		long l1=N/lcm1;
		long l2=N/lcm2;
		long l3=N/lcm3;
		long l4=N/lcm4;
		
		long result = a+b+c-l1-l2-l3+l4;
		
		System.out.println(result);

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
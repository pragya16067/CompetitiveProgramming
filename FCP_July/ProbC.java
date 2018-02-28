import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//Reference from : https://math.stackexchange.com/questions/19709/equation-for-summing-subsets

public class ProbC {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int T=Reader.nextInt();
		BigInteger modval=BigInteger.valueOf(1000000007);
		while(T-- > 0)
		{
			int N=Reader.nextInt();
			BigInteger n=BigInteger.valueOf(N);
			BigInteger two=BigInteger.valueOf(2);
			BigInteger ans1=two.modPow(n.subtract(BigInteger.valueOf(1)),modval);
			BigInteger ans2=n.modPow(two,modval);
			BigInteger ans7=(ans1.multiply(ans2)).mod(modval);
			//System.out.println(ans7);
			
			BigInteger ans3=ans1.multiply(n.mod(modval));
			BigInteger ans4=ans3.mod(modval);
			//System.out.println(ans4);
			
			BigInteger ans5=(ans1.multiply(two)).mod(modval);
			BigInteger ans8=ans5.subtract(BigInteger.valueOf(1));
			BigInteger ans6=ans8.mod(modval);
			//System.out.println(ans6);
			
			BigInteger result1=ans7.subtract(ans4);
			BigInteger result=(result1.add(ans6));
			System.out.println(result.mod(modval));
			
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
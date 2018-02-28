import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


class EXPTREE {
	
	
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int T=Reader.nextInt();
		while(T-- > 0)
		{
			long N=Reader.nextLong();
			
			BigInteger num=BigInteger.valueOf(1);
			BigInteger n1=(BigInteger.valueOf(N-1));
			num=n1.multiply(BigInteger.valueOf(N));
			
			BigInteger den=BigInteger.valueOf((4*N)-6);
			
			//System.out.println(den +" "+num);
			
			//System.out.println(num.gcd(den));
			BigInteger gcd=num.gcd(den);
			//System.out.println(gcd);
			//System.out.println(gcd.compareTo(BigInteger.valueOf(1))!=0);
			while(gcd.compareTo(BigInteger.valueOf(0))!=0 && gcd.compareTo(BigInteger.valueOf(1))!=0)
			{
				num=num.divide(gcd);
				den=den.divide(gcd);
				gcd=num.gcd(den);
			}
			//System.out.println(num);
			//System.out.println(den);
			
			BigInteger modval0=BigInteger.valueOf(1000000005);
			BigInteger modval1=BigInteger.valueOf(1000000007);
			BigInteger modval2=BigInteger.valueOf(1000000009);
			//BigInteger pow1=den.pow(1000000005);
			//BigInteger pow2=den.pow(1000000007);
			
			BigInteger ans1=(num.mod(modval1)).multiply(den.modPow(modval0,modval1));
			BigInteger ans2=(num.mod(modval2)).multiply(den.modPow(modval1,modval2));
			System.out.println(ans1.mod(modval1) +" "+ ans2.mod(modval2));
			
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



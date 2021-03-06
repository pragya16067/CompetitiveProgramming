//Name : PRAGYA PRAKASH
//Roll No. : 2016067

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class A {
	//Function finder to find the Highest Common Factor of 2 numbers
	static long finder(long x, long y)
    {
        if(y==0)
        	return x;
        else
        	return finder(y,x%y);
    }
    
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int T=Reader.nextInt();
		long M= 1000000007;
		//Fast Output
		PrintWriter printWriter = new PrintWriter(System.out);
		while(T-- > 0)
		{	
			int N=Reader.nextInt();
			long pragya;
			long[] Edges=new long[N];
			
			long num1=Reader.nextLong();
			Edges[0]=num1;
			long num2=Reader.nextLong();
			Edges[1]=num2;
			//Take Highest Common Factor of first 2 numbers to find overall pragya by a loop
			//pragya finds the pragya of all lengths given
			pragya=finder(num1,num2);
			
			for(int i=2; i< N ; i++)
			{
				long num=Reader.nextLong();
				pragya=finder(num,pragya);
				Edges[i]=num;
			}
			
			long ans=1;
			//Finding the final answer of the number of hypercubes(of side length final HCF) of same volume fitted in the given hypercuboid
			for(int i=0; i<N; i++)
			{
				long fact =( Edges[i]/pragya ) % M;
				ans=(ans * fact) % M;
			}
			
		
			printWriter.println(ans % M);
			
		}
		printWriter.close();
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



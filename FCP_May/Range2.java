import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Range2 {
	
	public static boolean[] prime;
	
	public static void sieveOfEratosthenes(int n)
    {
		// Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        prime = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;
         
        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }
         
        /*Print all prime numbers
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
                System.out.print(i + " ");
        }*/
    }
	

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int a=Reader.nextInt();
		int b=Reader.nextInt();
		int k=Reader.nextInt();
		
		sieveOfEratosthenes(b+1);
		prime[0]=false;
		prime[1]=false;
		
		int[] A=new int[b-a+1];
		int[] givenprimes=new int[b-a+1];
		int endpointer=0;
		int maxdiff=0;int diff=0;
		
		for(int i=a; i<=b; i++)
		{
			if(prime[i])
			{
				givenprimes[endpointer++]=i;
			}
			A[i-a]=i;
		}
	
		if(k==endpointer)
		{
			//System.out.println(A.length);
			double possible1=(A[A.length-1]-givenprimes[0]+1);
			double possible2=givenprimes[endpointer-1]-A[0]+1;
			System.out.println((int ) Math.max(possible1,possible2));
		}
		
		else if(k>endpointer)
		{
			System.out.println(-1);
		}
		
		else
		{
			maxdiff=givenprimes[k-1]-a+1;
			diff=b-givenprimes[endpointer-k]+1;
			if(diff>maxdiff)
				maxdiff=diff;
			for(int i=0;i<endpointer-k;i++)
			{
				diff=givenprimes[i+k]-givenprimes[i];
				if(diff>maxdiff)
					maxdiff=diff;
			}
			System.out.println(maxdiff);
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

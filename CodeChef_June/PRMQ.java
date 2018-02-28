import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class PRMQ {
	
public static boolean[] prime;
public static int[] SPF;
	
	public static void sieveOfEratosthenes(int n)
    {
		// Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        prime = new boolean[n+1];
        SPF=new int[n+1];
        int end=(int) Math.sqrt(n);
        for(int i=0;i<=n;i++)
        {
            prime[i] = true;
            SPF[i]=i;
        }
        
        for(int p = 2; p <=end; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*2; i <= n; i += p)
                {
                    prime[i] = false;
                    if(SPF[i]==i)
                    	SPF[i]=p;
                }
            }
        }
         
        /*Print all prime numbers
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
                System.out.print(i + " ");
        }*/
    }
	
	/*public static int F(int[] a, int L,int R,int X,int Y) {

	     int result = 0;
	     for(int i = X ; i < Y+1 ; i++)  {
	         if( prime[i] ) {
	             for(int j = L; j <= R; j++ ) {
	                  int number = a[j];
	                  int exponent = 0;
	                  while( number % i == 0 ) {
	                     exponent = exponent + 1; 
	                     number = number/i;
	                  }
	                  result = result + exponent;
	                  //System.out.println(i+" "+result);
	              }
	         }
	     }
	     return result;
	}*/
	
	public static int F(int[] a, int L,int R,int X,int Y) {
		int result=0;
		int primefactors=0;
		for(int i = L ; i < R+1 ; i++)  
		{
			int n=a[i];
			while(n!=1)
			{
				primefactors=SPF[n];
				if(primefactors>=X && primefactors<=Y)
				{
					result++;
				}
				n = n / SPF[n];
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int N=Reader.nextInt();
		int[] A=new int[N];
		for(int i=0; i<N; i++)
		{
			A[i]=Reader.nextInt();
		}
		//Arrays.sort(A);
		int Q=Reader.nextInt();
		sieveOfEratosthenes(1000000);
		//sieveOfEratosthenes(1000);
		prime[0]=false;
		prime[1]=false;
		/*for(int i=0; i<SPF.length; i++)
		{
			System.out.print(SPF[i]+" ");
		}*/
		while(Q-- > 0)
		{
			int L=Reader.nextInt()-1;
			int R=Reader.nextInt()-1;
			int X=Reader.nextInt();
			int Y=Reader.nextInt();
			
			
			int ans = F(A,L,R,X,Y);
			System.out.println(ans);
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


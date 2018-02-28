import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class NEO01 {

	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int T=Reader.nextInt();
		
		while(T-- > 0)
		{
			int N=Reader.nextInt();
			
			//An array to store happiness
			int[] A=new int[N];
			long s=0;//sum of subset elements
			int ct=0;//length of subset
			for(int i=0; i<N; i++)
			{
				int num=Reader.nextInt();
				A[i]=num;
				if(num >= 0)
				{
					ct=ct+1;
					s= s + num;
				}
			}
			//System.out.println(ct+" "+s);
			
			Arrays.sort(A);
			int i=N-1;
			long sum=0;
			while(i >= 0)
			{
				int num=A[i];
				if(num < 0)
				{
					//System.out.println((s+num)*(ct+1));
					//System.out.println( s*ct );
					//System.out.println((s+num)*(ct+1) >= s*ct );
					if((s+num)*(ct+1) >= s*ct )
					{
						//System.out.println(num);
						s=s+num;
						ct=ct+1;
					}	
					else 
					{
						sum=sum+num;
					}
				}
				
				i--;	
			
			}
			//System.out.println(ct+" "+s);
			//System.out.println(sum);
			System.out.println(s*ct + sum);
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class CHEFCODE {
		
	public static void main(String[] args) {
		try
		{
		Reader.init(System.in);
		int N=Reader.nextInt();
		double K=(double) Reader.nextLong();
		
		long totsets=(long) Math.pow(2.0,N)-1;
		
		//int n=(int) N;
		double[] arr=new double[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Reader.nextInt();
			//arr[i]=1000000000000000000.0;
		}
		/*for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");;
		}*/
		
		
		//Now to find the subsets which have product greater than K
		
		long c=0;
		
        // Run a loop for printing all 2^n
        // subsets one by one
        long totsets1=(long) Math.pow(2.0,N);
        for (int i = 0; i < totsets1; i++)
        {
        	//System.out.print(i);
            //System.out.print("{ ");
            int end;
            // Print current subset
            double prod=1.0;
            for (int j = 0; j < N; j++)
            {
            	end=(int) Math.pow(2.0, j);
                
                if ((i & end) > 0)
                {
                	prod=prod*arr[j];
                	String s=arr[j]+" ";
                	//System.out.println(s);
                	if(s==" ") //So as to not include the empty set in counting
                		{prod=0;}
                	//System.out.print(j+", ");
                    //System.out.print(arr[j] + " ");
                }
            }
            if(prod>K)
			{
				c++;
			}
            else
            	System.out.println(prod);
            //System.out.println("}");
        }
		//System.out.println(c);
		System.out.println(totsets-c);
		
		System.exit(0);
	}
	
	catch(Exception e)
	{
		System.out.println(e);
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class CLONEME {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int T=Reader.nextInt();
		
		while(T-- > 0)
		{
			int N=Reader.nextInt();
			int Q=Reader.nextInt();
			int[] A=new int[N];
			
			for(int i=0; i<N; i++)
			{
				A[i]=Reader.nextInt();
			}
			
			while(Q-- > 0)
			{
				int a=Reader.nextInt();
				int b=Reader.nextInt();
				int c=Reader.nextInt();
				int d=Reader.nextInt();
				int[] A1=new int[b-a+1];
				int[] A2=new int[b-a+1];
				
				for(int j=0; j<A1.length; j++)
				{
					A1[j] = A[a-1+j];
					A2[j] = A[c-1+j];
				}
				Arrays.sort(A1);
				Arrays.sort(A2);
				
				boolean flag=true;
				boolean ans=true;
				for(int j=0; j<A1.length; j++)
				{
					if(A1[j]==A2[j])
					{
						continue;
					}
					else if(A1[j]!=A2[j] && flag==true)
					{
						flag=false;
						continue;
					}
					else
					{
						System.out.println("NO");
						ans=false;
						break;
					}
				}
				if(ans==true)
					System.out.println("YES");
			}
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

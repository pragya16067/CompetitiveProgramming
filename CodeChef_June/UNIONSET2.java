import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class UNIONSET2 {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int T=Reader.nextInt();
		
		while(T-- > 0)
		{
			int N=Reader.nextInt();
			int K=Reader.nextInt();
			HashMap<Integer,HashSet<Integer>> h=new HashMap<Integer,HashSet<Integer>> ();
			
			for(int x=0; x<N; x++)
			{
				int L=Reader.nextInt();
				ArrayList<Integer> A=new ArrayList<Integer> ();
				for(int i=0;i<L;i++)
				{
					A.add(Reader.nextInt());
				}
	
				Collections.sort(A);
				HashSet<Integer> hs=new HashSet<Integer>();
				for(int j=0; j<A.size(); j++)
				{
					hs.add(A.get(j));
				}
				h.put(x, hs);
			}
			
			int count=0;
			for(int x=0; x<N-1; x++)
			{
				HashSet<Integer> A=h.get(x);
				if(A.size()==K)
				{
					count=count+N-(x+1);
				}
				else
				{
				
					for(int i=x+1; i<N; i++)
					{
						HashSet<Integer> check=h.get(i);
						
						int intersection=0;
						//for(int j=0; j<A.size(); j++)
						for( int s : A)
						{
							if(check.contains(s))
							{
								intersection++;
							}
						}
						if(A.size()+check.size()-intersection==K)
						{
							count++;
						}
						 
					}
	
				}
				
			}
			System.out.println(count);
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

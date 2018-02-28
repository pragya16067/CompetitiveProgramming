import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class CHEFROUT {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int T=Reader.nextInt();
		for(int j=0; j<T; j++)
		{
			int flag=0;
			String s=Reader.reader.readLine();
			char[] C=s.toCharArray();
			/*for(int i=0; i<C.length; i++)
			{
				System.out.print(C[i]+" ");
			}*/
			System.out.println();
			for(int i=0; i<C.length-1; i++)
			{
				char c1=C[i];
				char c2=C[i+1];
				if(c1=='C')
				{
					continue;
				}
				else if(c1=='S')
				{
					if(c2=='C' || c2=='E')
						{flag=1;
						break;}
					else
						continue;
				}
				else if(c1=='E')
				{
					if(c2=='C')
					{
						flag=1;
						break;
					}
					else
						continue;
						
				}
			}
			if(flag==0)
				System.out.println("yes");
			else
				System.out.println("no");
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
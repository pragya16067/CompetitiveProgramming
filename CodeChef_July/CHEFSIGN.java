import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class CHEFSIGN {
	
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int T=Reader.nextInt();
		while(T-- > 0)
		{
			String s=Reader.reader.readLine();
			int max=0;
			int ptr=0;
			while(ptr<s.length())
			{
				int i=0;
				if(s.charAt(ptr)=='<')
				{
					while(ptr<s.length() && (s.charAt(ptr)=='<' || s.charAt(ptr)=='='))
					{
						if(s.charAt(ptr)!='=')
							i++;
						ptr++;	
					}
					if(i>max)
						max=i;
				}
				else if(s.charAt(ptr)=='>')
				{
					while( ptr<s.length() && (s.charAt(ptr)=='>' || s.charAt(ptr)=='='))
					{
						if(s.charAt(ptr)!='=')
							i++;
						ptr++;
					}
					if(i>max)
						max=i;
				}
				else
				{
					ptr++;
				}
				
				
			}
			System.out.println(max+1);
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

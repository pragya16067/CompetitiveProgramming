import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class NITIKA {
	
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int T=Reader.nextInt();
		while(T-- > 0)
		{
			String s=Reader.reader.readLine();
			String[] arr=s.split(" ");
			if(arr.length==1)
			{
				String ln=arr[0];
				System.out.println((""+ln.charAt(0)).toUpperCase()+ln.substring(1).toLowerCase());
			}
			else if(arr.length==2)
			{
				String fn=(""+arr[0].charAt(0)).toUpperCase() + ". ";
				String ln=arr[1];
				System.out.println(fn+(""+ln.charAt(0)).toUpperCase()+ln.substring(1).toLowerCase());
			}
			else
			{
				String fn=(""+arr[0].charAt(0)).toUpperCase() + ". ";
				String mn=(""+arr[1].charAt(0)).toUpperCase() + ". ";
				String ln=arr[2];
				System.out.println(fn+mn+(""+ln.charAt(0)).toUpperCase()+ln.substring(1).toLowerCase());
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
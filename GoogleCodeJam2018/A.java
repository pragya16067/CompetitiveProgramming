import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {
	
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int T= Reader.nextInt();
		PrintWriter writer = new PrintWriter("Output.txt", "UTF-8");
		int Caseno=1;
		while(T-- > 0) {
			int K=Reader.nextInt();
			int[] Dist=new int[K];
			int ptr;
			if(K%2 == 0) //K is even
			{
				for(ptr=0; ptr<=K/2-1; ptr++)
				{
					Dist[ptr] = ptr;
				}
				ptr = K/2;
				
				Dist[ptr++] = K/2-1;
				int val = K/2-1;
				while(ptr<K)
				{
					Dist[ptr] = val-1;
					ptr++;
					val--;
				}
			}
			else
			{
				for(ptr=0; ptr<=K/2; ptr++)
				{
					Dist[ptr] = ptr;
				}
				ptr = K/2+1;
				int val = K/2-1;
				while(ptr<K)
				{
					Dist[ptr] = val;
					ptr++;
					val--;
				}
			}
			int[] OptD = new int[K];
			for(int i=0; i<K; i++)
			{
				OptD[i] = Reader.nextInt();
			}
			Arrays.sort(OptD);
			Arrays.sort(Dist);
			int min=0;
			for(int i=0; i<K; i++)
			{
				min = min + ((OptD[i] - Dist[i]) * (OptD[i] - Dist[i]));
				//System.out.println((OptD[i] - Dist[i]) * (OptD[i] - Dist[i]));
			}
			System.out.println("Case #"+Caseno+": "+min);
			writer.println("Case #"+Caseno+": "+min);
			Caseno++;
		}
		
		
		
		writer.close();
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
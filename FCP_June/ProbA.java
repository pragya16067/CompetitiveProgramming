import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ProbA {
	private static LinkedList<Integer> A = new LinkedList<Integer>();
	private static LinkedList<Integer> B = new LinkedList<Integer>();
	private static int imp=0;
	private static int V;
	
	private static void isBipartite(int G[][])
	{
	    // Create a color array to store colors assigned to all
	    // vertices. Vertex/ number is used as index in this
	    // array. The value '-1' of  colorArr[i] is used to
	    // indicate that no color is assigned to vertex 'i'.
	    // The value 1 is used to indicate first color is
	    // assigned and value 0 indicates second color is
	    // assigned.
		int colorArr[] = new int[V+1];
        for (int i=0; i<=V; ++i)
            colorArr[i] = -1;
	 
	    // This code is to handle disconnected graoh
	    for (int i = 1; i <= V; i++)
	    {
	      if (colorArr[i] == -1 && imp==0)
	    	  isBipartiteUtil(G, i, colorArr);
	    }
	 
	     return;
	}
	
	// This function returns true if graph G[V][V] is Bipartite, else false
    private static void isBipartiteUtil(int G[][],int src,int[] colorArr)
    {
        // Create a color array to store colors assigned to all veritces.
        // Vertex number is used as index in this array. The value '-1'
        // of  colorArr[i] is used to indicate that no color is assigned
        // to vertex 'i'.  The value 1 is used to indicate first color
        // is assigned and value 0 indicates second color is assigned.
        
 
        // Assign first color to source
        colorArr[src] = 1;
        A.add(src);
 
        // Create a queue (FIFO) of vertex numbers and enqueue
        // source vertex for BFS traversal
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(src);
 
        // Run while there are vertices in queue (Similar to BFS)
        while (q.size() != 0)
        {
 
            // Dequeue a vertex from queue
            int u = q.poll();
 
            // Find all non-colored adjacent vertices
            for (int v=1; v<V+1; ++v)
            {
                // An edge from u to v exists and destination v is
                // not colored
                if (G[u][v]==1 && colorArr[v]==-1)
                {
                    // Assign alternate color to this adjacent v of u
                    colorArr[v] = 1-colorArr[u];
                    if(colorArr[v]==1)
                    	A.add(v);
                    else
                    	B.add(v);
                    q.add(v);
                }
 
                // An edge from u to v exists and destination v is
                // colored with same color as u
                else if (G[u][v]==1 && colorArr[v]==colorArr[u])
                {
                    imp=1;
                    return;
                }
            }
        }
        // If we reach here, then all adjacent vertices can
        //  be colored with alternate color
        return;
    }
	
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int N=Reader.nextInt();
		V=N;
		int M=Reader.nextInt();
		int[][] AdjM=new int[N+1][N+1];
		while(M-- > 0)
		{
			int x=Reader.nextInt();
			int y=Reader.nextInt();
			AdjM[x][y]=1;
			AdjM[y][x]=1;
		}
		
		/*for(int i=0; i<V; i++)
		{
			for(int j=0; j<V; j++)
			{
				System.out.print(AdjM[i][j]+ " ");
			}System.out.println();
		}*/
		
		isBipartite(AdjM);
		
		if(imp==1)
		{
			System.out.println(-1);
		}
		else
		{
			System.out.println(A.size());
			for(int i : A)
			{
				System.out.print(i+" ");
			}
			System.out.println();
			
			System.out.println(B.size());
			for(int i : B)
			{
				System.out.print(i+" ");
			}
			System.out.println();
			
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


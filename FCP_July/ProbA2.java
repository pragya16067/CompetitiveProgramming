import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class GNode {
	
	public int data;
	public GNode link;
	//public String color;
	
	public GNode() { 		
		// a simple GNode
		data = 0; 
		link = null;
		//color="White";
	}
	
	public GNode(int n) {
		// a GNode with a given value
		data = n; 
		link = null; 
		//color="White";
	}

	public GNode(int value, GNode ptr) {
		//a GNode with given value and reference
		data=value;
		link=ptr; 
		//color="White";
	}
	
	public int getData() {
		return this.data;
	}
	
	
	
	public GNode getLink() {
		return this.link;
	}
	
	public void setLink(GNode n) {
		this.link=n;
	}
	
	
	
	public void setData(int n) {
		this.data=n;
	}
	
	public void insert(int value) {
		GNode nptr=new GNode(value,this.getLink());
		//nptr.setLink(this.getLink());
		this.setLink(nptr);
	}
	
	public void display() {
		GNode n=this;
		do
		{
			System.out.print(n.getData()+" ");
			n=n.getLink();
		}while(n!=null);
		
		System.out.println();
	}
}

//Reference: Tutorial on Problem D: Distance in Tree, VK Cup 2012, Codeforces
public class ProbA2 {
	
	int dp[][], result;
	
	public void dfs(int vertex, int parent, int k, GNode[] l)
	  {   
		    dp[vertex][0] = 1;
		    GNode v=l[vertex];
		    while(v.getLink()!=null)
		    {
		    	int u=v.getLink().getData();
		    	if(u != parent) 
		    	{
		    		dfs(u, vertex, k,l);
		    	}
		    	v=v.getLink();
		    }
		    
		    for(int i = 0; i < k; i++)
		    {
		    	result = result + dp[parent][i]*dp[vertex][k-i-1];
		    }
		    
		    for(int i = 1; i <= k; i++)
		    {
		    	dp[parent][i] = dp[parent][i] + dp[vertex][i-1];
		    }   
	  }
	
	public static void main(String[] args) throws IOException{
		
		    Reader.init(System.in);
			int N=Reader.nextInt();
			int K=Reader.nextInt();
			ProbA2 obj = new ProbA2();
	  		obj.dp = new int[N+1][K+1];
			
			GNode[] AdjList=new GNode[N+1];
			for(int i=0; i<N+1;i++)
			{
				GNode nptr=new GNode(i);
				AdjList[i]=nptr;
			}
			
			for(int i=1; i<N; i++)
			{
				int U=Reader.nextInt();
				int V=Reader.nextInt();
				
				GNode n1=AdjList[U];
				n1.insert(V);
				GNode n2=AdjList[V];
				n2.insert(U);
			}
			
			/*for(int i=0; i<N+1;i++)
			{
				GNode n=AdjList[i];
				n.display();
			}*/
			
			
			obj.dfs(1, 0, K, AdjList);
			
			int ans=obj.result;
			System.out.println(ans);
				
			
		
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


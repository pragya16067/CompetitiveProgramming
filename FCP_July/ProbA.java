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


public class ProbA {

	public static boolean[] Seen;
	public static int[] Path;
	
	public static void dfs(int i, GNode[] l) {
		Seen[i]=true;
		GNode u=l[i];
		while(u.getLink()!=null)
		{
			GNode v=u.getLink();
			int x=v.getData();
			if(!Seen[x])
			{
				Path[x]=i;
				dfs(x,l);
			}
			u=u.getLink();
		}
		
		return;
	}
	
	public static boolean isPathK(int V,int K) {
		ArrayList<Integer> result=new ArrayList<Integer> ();
		int current=V;
		do
		{
			result.add(current);
			current=Path[current];
		}while(current!=-1);
		
		if(result.size()-1==K)
			return true;
		else 
			return false;
	}
	
	public static void main(String[] args) throws IOException{
		
		    Reader.init(System.in);
			int N=Reader.nextInt();
			int K=Reader.nextInt();
			
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
			
			int result=0;
			
			for(int u=1; u<N; u++) {
				Seen=new boolean[N+1];
				Path=new int[N+1];
				
				
				dfs(u,AdjList);
				Path[u]=-1;
				
				for(int i=u+1; i<=N; i++)
				{
					if(isPathK(i,K))
					{
						/*System.out.println(i);
						for(int i1=0; i1<Path.length; i1++)
						{
							System.out.print(Path[i1]+" ");
						}System.out.println();*/
						result++;
					}
				}
			}
			
			/*for(int i=0; i<path.size(); i++)
			{
				System.out.print(path.get(i)+" ");
			}System.out.println();*/
				
			System.out.println(result);
				
			
		
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



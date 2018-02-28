import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
	private int val;
	public ArrayList<Node> neighbours;
	
	public Node(int value, ArrayList<Node> neighbour) {
		val=value;
		neighbours=neighbour;
	}
	
	public void addNeighbour(Node v) {
		this.neighbours.add(v);
	}
	
	public ArrayList<Node> getNeighbours() {
		return this.neighbours;
	}
	
}

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


class PSHTTR2 {
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
	
	public static ArrayList<Integer> getPath(int V) {
		ArrayList<Integer> result=new ArrayList<Integer> ();
		int current=V;
		do
		{
			result.add(current);
			current=Path[current];
		}while(current!=-1);
		
		return result;
	}
	
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int T=Reader.nextInt();
		while(T-- > 0)
		{
			int N=Reader.nextInt();
			
			
			
			GNode[] AdjList=new GNode[N+1];
			for(int i=0; i<N+1;i++)
			{
				GNode nptr=new GNode(i);
				AdjList[i]=nptr;
			}
			
			int[][] data=new int[3][N];
			for(int i=1; i<N; i++)
			{
				int U=Reader.nextInt();
				int V=Reader.nextInt();
				int C=Reader.nextInt();
				
				data[0][i] = U;
				data[1][i] = V;
				data[2][i] = C;
				
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
			
			
			/*for(int i=0; i<3; i++)
			{
				for(int j=0; j<N; j++)
				{
					System.out.print(data[i][j]);
				}
				System.out.println();
			}*/
			
			int M=Reader.nextInt();
			while(M-- > 0)
			{
				Seen=new boolean[N+1];
				Path=new int[N+1];
				int Uq=Reader.nextInt();
				int Vq=Reader.nextInt();
				int K=Reader.nextInt();
				
				dfs(Uq,AdjList);
				
				Path[Uq]=-1;
				ArrayList<Integer> path = getPath(Vq);
				
				/*for(int i=0; i<path.size(); i++)
				{
					System.out.print(path.get(i)+" ");
				}System.out.println();*/
				
				int xor=0;
				for(int i=0; i<path.size()-1; i++)
				{
					int u=path.get(i);
					int v=path.get(i+1);
					//System.out.println("u="+u+" v="+v);
					for(int j=0; j<N; j++)
					{
						if(data[0][j]==u && data[1][j]==v)
						{
							//System.out.println("j="+j);
							if(data[2][j]<=K)
								xor=xor^(data[2][j]);
						}
						else if(data[0][j]==v && data[1][j]==u)
						{
							//System.out.println("j="+j);
							if(data[2][j]<=K)
								xor=xor^(data[2][j]);
						}
					}
				}
				System.out.println(xor);
				
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



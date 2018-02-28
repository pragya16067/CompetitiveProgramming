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


class PSHTTR {
	
	public static int cyclic=0;
	public static int reached=0;
	
	public static ArrayList<Integer> DFS(GNode[] l,char[] color,int start,int V) {
		
		for(int i=0; i<color.length;i++)
		{
			color[i]='w';
		}
		
		ArrayList<Integer> path=new ArrayList<Integer> ();
		ArrayList<Integer> p=DFS_Visit(start,l,color,path,V);
		return p;
		
		
	}
	
	public static ArrayList<Integer> DFS_Visit(int index, GNode[] l,char[] color,ArrayList<Integer> path,int V) {
		GNode u=l[index];
		color[index]='g';
		path.add(u.getData());
		//System.out.println(cyclic);
		//System.out.println("u="+u.getData());
		/*for(int i=0; i<path.size(); i++)
		{
			System.out.print(path.get(i)+" ");
		}System.out.println();*/
		
		while(u.getLink()!=null && reached==0)
		{
			
			GNode v=u.getLink();
			/*if(path.get(path.size()-1)!=u.getData() && cyclic==0)
			{
				while(path.get(path.size()-1)!=u.getData())
				{
					System.out.println(u.getData()+" "+path.get(path.size()-1));
					path.remove(path.size()-1);
				}
			}
			if(cyclic==1)
				cyclic=0;*/
			//System.out.print(v.getColor());
			
			if(color[v.getData()-1]=='w')
			{
				//System.out.println("v="+v.getData()+" "+v.getColor());
				DFS_Visit(v.getData()-1,l,color,path,V);
			}
			if(v.getData() == V)
			{
				path.add(V);
				reached=1;
				return path;
			}
			if(color[v.getData()-1]=='g' )
			{
				//System.out.println("Hello");
				cyclic=1;
				//return;
			}
			u=u.getLink();
			//System.out.println("u="+u.getData()+" "+u.getColor());
		}
		color[index]='b';
		return path;
	}
	
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int T=Reader.nextInt();
		while(T-- > 0)
		{
			int N=Reader.nextInt();
			char[] Color=new char[N];
			
			GNode[] AdjList=new GNode[N];
			for(int i=0; i<N;i++)
			{
				GNode nptr=new GNode(i+1);
				AdjList[i]=nptr;
				Color[i]='w';
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
				
				GNode n1=AdjList[U-1];
				n1.insert(V);
				GNode n2=AdjList[V-1];
				n2.insert(U);
			}
			
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
				int Uq=Reader.nextInt();
				int Vq=Reader.nextInt();
				int K=Reader.nextInt();
				ArrayList<Integer> path=DFS(AdjList, Color, Uq-1, Vq);
				for(int i=0; i<path.size(); i++)
				{
					System.out.print(path.get(i)+" ");
				}System.out.println();
				
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


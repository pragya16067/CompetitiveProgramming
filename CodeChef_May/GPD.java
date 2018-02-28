import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

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


class GPD {

public static int reached=0;
public static int min=Integer.MAX_VALUE;
public static int max=0;
public static int minval=0;
public static int maxval=0;


	
	public static void DFS(int MMIndex,int MMKey,int RIndex,GNode[] l,char[] color,int[] Key) {
		
		for(int i=0; i<color.length;i++)
		{
			color[i]='w';
		}
		
		DFS_Visit(MMIndex,MMKey,RIndex,l,color,Key);
		
	}
	
	public static void DFS_Visit(int MinMaxIndex,int MMKey,int index, GNode[] l,char[] color,int[] Key) {
		GNode u=l[index];
		color[index]='g';
		int val=Key[index] ^ MMKey;
		if(val > max)
		{
			max=val;
			maxval=Key[index];
		}
		if(val < min)
		{
			min=val;
			minval=Key[index];
		}
		//System.out.println(reached);
		//System.out.println("u="+u.getData()+" "+u.getColor());
		
		while(u.getLink()!=null && reached!=1)
		{
			GNode v=u.getLink();
			//System.out.print(v.getColor());
			if(color[v.getData()]=='w')
			{
				//System.out.println("v="+v.getData()+" "+v.getColor());
				DFS_Visit(MinMaxIndex,MMKey,v.getData(),l,color,Key);
			}
			if(v.getData()==MinMaxIndex )
			{
				//System.out.println("Hello");
				reached=1;
				//return;
			}
			u=u.getLink();
			//System.out.println("u="+u.getData()+" "+u.getColor());
		}
		color[index]='b';
		
	}
	
	
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int N=Reader.nextInt();
		int Q=Reader.nextInt();
		
		char[] Color=new char[N+Q+1];
		int[] Key=new int[N+Q+1];
		
		GNode[] AdjList=new GNode[N+Q+1];
		for(int i=0; i<=N+Q;i++)
		{
			GNode nptr=new GNode(i);
			AdjList[i]=nptr;
		}
		int end_pointer=N+1;
		
		int R=Reader.nextInt();
		int Rkey=Reader.nextInt();
		
		int n=N-1;
		while (n-- > 0)
		{
			int u=Reader.nextInt();
			int v=Reader.nextInt();
			int k=Reader.nextInt();
			
			Key[u]=k;
			GNode g=AdjList[v];
			g.insert(u);
		
		}
		//Now we have the complete adjacency list
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer> ();
		int last_answer=0;
		
		for(int j=0; j<Q; j++)
		{
			int t=Reader.nextInt();
			t^=last_answer;
			
			if(t==0)
			{
				int v=Reader.nextInt();
				int u=Reader.nextInt();
				int k=Reader.nextInt();
				
				u ^= last_answer;
			    v ^= last_answer;
			    k ^= last_answer;
			    
			    /*To insert station*/
			    hm.put(end_pointer, u);
			    Key[end_pointer]=k;
			    GNode g=AdjList[v];
				g.insert(end_pointer);
			    end_pointer++;
			}
			
			else
			{
				int v=Reader.nextInt();
				int k=Reader.nextInt();
				
				// find real values for v, and k
		        v ^= last_answer;
		        k ^= last_answer;
		        
		        DFS(v,k,R,AdjList,Color,Key);
		        // compute the requested values
		        int min_answer =  minval  ;
		        int max_answer =  maxval  ; 
		        
		        System.out.print(minval^k);
		        System.out.print(" ");
		        System.out.print(maxval^k);
		        System.out.println();

		        // update last_answer
		        last_answer = min_answer ^ max_answer;
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
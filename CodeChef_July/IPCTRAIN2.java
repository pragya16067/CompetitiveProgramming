import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Teacher {
	public int sday;
	public int time;
	public int sadness;
	
	public Teacher(int Sday,int Time,int Sadness) {
		sday=Sday;
		time=Time;
		sadness=Sadness;
	}
		
}

//Using MaxHeap class written previously for DSA course by myself with reference from SanFoundary

class MaxHeap2 {
	
	public Teacher[] Heap;
	public int size;
	private int maxsize;
	
	private static final int FRONT = 1;
	
	public MaxHeap2(int maxsize)
	{
	    this.maxsize = maxsize;
	    this.size = 0;
	    Heap = new Teacher[this.maxsize + 1];
	    Heap[0] = new Teacher(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE);
	    for(int i=1; i<this.maxsize+1; i++)
	    {
	    	Heap[i]=new Teacher(0,0,0);
	    }
	}
	
	 private boolean isLeaf(int pos)
    {
        if (pos >=  (size / 2)  &&  pos <= size)
        {
            return true;
        }
        return false;
    }
	 
	public void heapify2(int i) {
		int leftChild=(2*i);
		int rightChild= leftChild+1;
		
		if (!isLeaf(i))
        { 
            if ( Heap[i].sadness < Heap[leftChild].sadness  || Heap[i].sadness < Heap[rightChild].sadness)
            {
                if (Heap[leftChild].sadness > Heap[rightChild].sadness)
                {
                    swap(i, leftChild);
                    heapify2(leftChild);
                }
                else
                {
                    swap(i, rightChild);
                    heapify2(rightChild);
                }
            }
        }
	}

	public void heapify(int i) {
		int heapsize=size;
		boolean flag=true;
		
		while(i<=(heapsize-1)/2 && flag==true)
		{
			int max=i;
			int l=2*i;
			int r=2*i+1;
			if(l<=heapsize && Heap[l].sadness>Heap[i].sadness)
			{
				max=l;
			}
			if(r<=heapsize && Heap[r].sadness>Heap[max].sadness)
			{
				max=r;
			}
			if(max!=i)
			{
				Teacher temp=Heap[max];
				Heap[max]=Heap[i];
				Heap[i]=temp;
				i=max;
				//heap=heapify(heap,min);
			}
			else
			{
				flag=false;
			}
		}
	}
	
    private void swap(int fpos,int spos)
    {
        Teacher tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
	
	public void insert(Teacher element)
	    {
	        Heap[++size] = element;
	        int current = size;
	        int parent = current / 2;
	 
	        while(Heap[current].sadness > Heap[parent].sadness)
	        {
	            swap(current,parent);
	            current = parent;
	            parent = current / 2;
	        }	
	    }
	
	public void Build_Heap()
    {
        for (int pos = (size / 2); pos >= 1; pos--)
        {
            heapify(pos);
        }
    }
 
    public void extract_max()
    {
        //Teacher popped = Heap[FRONT];
    	if(size==1)
    	{
    		Heap[FRONT]=new Teacher(0,0,0);
    		size--;
    	}
    	else
    	{
    		Heap[FRONT] = Heap[size];
    		Heap[size] = new Teacher(0,0,0);
    		size--;
    		heapify(FRONT);
    	}
        return;
    }

}
class IPCTRAIN2 {

	
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int T=Reader.nextInt();
		while(T-- > 0)
		{
			int N=Reader.nextInt();
			int D=Reader.nextInt();
			
			long total=0;
			Teacher[] trainers=new Teacher[N];
			HashMap<Integer, ArrayList<Teacher>> hm=new HashMap<Integer, ArrayList<Teacher>> ();
			
			
			for(int k=0; k<N; k++)
			{
				int d=Reader.nextInt();
				int t=Reader.nextInt();
				int s=Reader.nextInt();
				Teacher o=new Teacher(d,t,s);
				trainers[k]=o;
				if(hm.containsKey(d))
				{
					ArrayList<Teacher> temp=hm.get(d);
					temp.add(o);
				}
				else
				{
					ArrayList<Teacher> temp=new ArrayList<Teacher> ();
					temp.add(o);
					hm.put(d,temp);
				}
			}
			
			int day=1;
			MaxHeap2 heap=new MaxHeap2(N);
			
			while(day<=D)
			{
				
				if(hm.containsKey(day))
				{
					ArrayList<Teacher> temp=hm.get(day);
					for(int i=0; i<temp.size(); i++)
					{
						heap.insert(temp.get(i));
						//System.out.println(trainers[k].time+" "+trainers[k].sadness);
						
					}
				}
				/*for (int i = 1; i <= heap.size ; i++ )
		        {
		            System.out.print(heap.Heap[i].sadness+" ");
		        }
	            System.out.println();*/
				
				if(heap.size>0)
				{
					Teacher o=heap.Heap[1];
					heap.extract_max();
					o.time=o.time-1;
					
					if(o.time!=0)
					{
						//heap.extract_max();
						heap.insert(o);
						//System.out.println(o.time+" "+o.sadness);
					}
				}
				/*for (int i = 1; i <= heap.size ; i++ )
		        {
		            System.out.print(heap.Heap[i].sadness+" ");
		        }
	            System.out.println();*/
	            
				day++;
				
			}
			
			/*System.out.println("final");
			for (int i = 1; i <= heap.size ; i++ )
	        {
	            System.out.print(heap.Heap[i].sadness+" ");
	        }
            System.out.println();*/
			
			for(int y=1; y<=heap.size; y++)
			{
				Teacher o=heap.Heap[y];
				//System.out.println("finally "+o.time+" "+o.sadness);
				long sad=o.sadness;
				long mult = ((o.time)*sad);
				total=total + mult;
			}
			
			System.out.println(total);
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


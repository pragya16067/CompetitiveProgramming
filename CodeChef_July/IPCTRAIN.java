import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
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

//Using MaxHeap class written previously for DSA course by myself

class IPCTRAIN {
	
	private static void mergesort(Teacher[] A,Teacher[] aux,int low, int high) {
		 if (low < high) {

		 int middle = (low + high) / 2;

		 mergesort(A,aux,low, middle);

		 mergesort(A,aux,middle + 1, high);
		 // Combine both the sorted subarrays
		 merge(A,aux,low, middle, high);
		 }
	}
	
	private static void merge(Teacher[] A,Teacher[] aux,int low, int middle, int high) {
		 // Copy contents of A into aux array
		 for (int i = low; i <= high; i++) {
		 aux[i] = A[i];
		 }
		 int i = low;
		 int j = middle + 1;
		 int k = low;
		 // Copy the smallest element from either sub arrays into A

		 
		
		 while (i <= middle && j <= high) {
			 if (aux[i].sday <= aux[j].sday) {
				 	A[k] = aux[i];
				 	i++;} 
			 else {
				 	A[k] = aux[j];
				 	j++;}
			 k++;
		 }
		
		// Copy the rest of the elements
		 while (i <= middle) {
			 A[k] = aux[i];
			 k++;
			 i++;
		 }
		 
		 while (j <= high) {
			 A[k] = aux[j];
			 k++;
			 j++;
		 }
	}
	
	public static int heapsize;
	
	public static Teacher[] heapify(Teacher[] heap, int i) {
		heapsize=heap.length-1;
		boolean flag=true;
		
		while(i<=(heapsize-1)/2 && flag==true)
		{
			int max=i;
			int l=2*i+1;
			int r=2*i+2;
			if(l<=heapsize && heap[l].sadness>heap[i].sadness)
			{
				max=l;
			}
			if(r<=heapsize && heap[r].sadness>heap[max].sadness)
			{
				max=r;
			}
			if(max!=i)
			{
				Teacher temp=heap[max];
				heap[max]=heap[i];
				heap[i]=temp;
				i=max;
				//heap=heapify(heap,min);
			}
			else
			{
				flag=false;
			}
		}

		return heap;
	}
	
	public static Teacher[] Build_Heap(Teacher[] A) {
		for(int i=(A.length-2)/2; i>=0; i--)
		{
			A=heapify(A,i);
		}
		return A;
	}
	
	public static Teacher[] extract_max(Teacher[] A) {
		A[0]=A[A.length-1];
		Teacher[] Anew=new Teacher[A.length-1];
		for(int i=0; i<Anew.length; i++)
		{
			Anew[i]=A[i];
		}
		Anew=heapify(Anew,0);
		return (Anew);
	}
	
	public static Teacher[] insert(Teacher[] A,Teacher i) {
		Teacher[] Anew=new Teacher[A.length+1];
		Anew[Anew.length-1]=i;
		for(int j=0; j<A.length; j++)
		{
			Anew[j]=A[j];
		}
		
		//Anew=heapify(Anew,(Anew.length-1));
		Anew=Build_Heap(Anew);
		
		return Anew;
	}
	
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int T=Reader.nextInt();
		while(T-- > 0)
		{
			int N=Reader.nextInt();
			int D=Reader.nextInt();
			//boolean[] days=new boolean[D];
			//Initially all entries in this array are false
			
			/*for(int i=0;i<days.length;i++)
			{
				System.out.println(days[i]);
			}*/
			int total=0;
			Teacher[] trainers=new Teacher[N];
			Teacher[] aux=new Teacher[N];
			
			for(int k=0; k<N; k++)
			{
				int d=Reader.nextInt();
				int t=Reader.nextInt();
				int s=Reader.nextInt();
				Teacher o=new Teacher(d,t,s);
				trainers[k]=o;	
			}
			mergesort(trainers, aux, 0, N-1);
			/*for(int i=0;i<trainers.length;i++)
			{
				System.out.println(trainers[i].sday);
			}*/
			//MaxHeap obj=new MaxHeap(trainers);
			
			int day=trainers[0].sday;
			int k=1;
			Teacher[] heap={trainers[0]};;
			//heap[0]=trainers[0];
			heap=Build_Heap(heap);
			
			while(day<=D)
			{
				
				while(k<N && trainers[k].sday==day)
				{
					heap=insert(heap,trainers[k]);
					//System.out.println(trainers[k].time+" "+trainers[k].sadness);
					k++;
				}
				if(heap.length>0)
				{
					Teacher o=heap[0];
					heap=extract_max(heap);
					o.time=o.time-1;
					if(o.time!=0)
					{
						heap=insert(heap,o);
						//System.out.println(o.time+" "+o.sadness);
					}
				}
				day++;
				
			}
			
			/*for(int i=0;i<heap.length;i++)
			{
				System.out.println(heap[i].sadness);
			}*/
			
			for(int y=0; y<heap.length; y++)
			{
				Teacher o=heap[y];
				//System.out.println("finally "+o.time+" "+o.sadness);
				total=total+((o.time)*(o.sadness));
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



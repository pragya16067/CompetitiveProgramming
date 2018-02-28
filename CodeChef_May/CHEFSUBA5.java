

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class obj {
	public int v;
	public int startI;
	public int endI;
	public int number;
	
	public obj(int value,int start, int end, int count) {
		v=value;
		startI=start;
		endI=end;
		number=count;
	}
}
	
	
class CHEFSUBA5 {
	
	public static int start=0;
	public static int end=0;
	
	public static void construct(int[] A, obj[] arr, int k) {
		//constructing the object array using window shifting
		int n=A.length;
		int index=1;
		int len=k;
		int c=0;
		
		//calculate the sum of the first k elements
		
		for(int i=0;i<k;i++)
		{
			c=c+A[i];
		}
		
		arr[0]=new obj(A[0],0,k-1,c);
		
		if(k!=n)
		{
			int window_sum = c;
		    for (int i=k; i<n+k-1; i++)
		    {
		       window_sum += A[i%n] - A[(i-k)%n];
		       arr[(i-k+1)]=new obj(A[index],index,(len)%n,window_sum);  
		       index++;
		       len++;
		    }
		}

	}
	
	public static void Display(obj[] arr) {
		for(int i=0; i<arr.length; i++)
		{
			obj p=arr[i];
			System.out.println(p.v+" "+p.startI+" "+p.endI+" "+p.number);
		}
	}
	

	public static void sortObjArr(obj[] A) {
		obj[] aux=new obj[A.length];
		mergesort(A,aux,0,A.length-1);	
	}
	
	//Using Code fr Mergesort Pre-Written By me
	private static void mergesort(obj[] A,obj[] aux,int low, int high) {
		 if (low < high) {

		 int middle = (low + high) / 2;

		 mergesort(A,aux,low, middle);

		 mergesort(A,aux,middle + 1, high);
		 // Combine both the sorted subarrays
		 merge(A,aux,low, middle, high);
		 }
	}
	
	private static void merge(obj[] A,obj[] aux,int low, int middle, int high) {
		 // Copy contents of A into aux array
		 for (int i = low; i <= high; i++) {
		 aux[i] = A[i];
		 }
		 int i = low;
		 int j = middle + 1;
		 int k = low;
		 // Copy the smallest element from either sub arrays into A

		 
		
		 while (i <= middle && j <= high) {
			 if (aux[i].number <= aux[j].number) {
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
	
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int N=Reader.nextInt();
		int K=Reader.nextInt();
		if(K>N)
			K=N;
		end=N-1;
		
		int P=Reader.nextInt();
		int[] A=new int[N];
		for(int i=0; i<N; i++)
		{
			A[i]=Reader.nextInt();
		}
		
		obj[] arr=new obj[N];
		construct(A,arr,K);
		//Display(arr);
		if(K!=N)
			sortObjArr(arr);
		//Display(arr);
		
		String s=Reader.reader.readLine();
		char[] C=s.toCharArray();
		
		for(int i=0; i<P; i++)
		{
			char c=C[i];
			if(c=='!')
			{
				if(start==0)
					start=N-1;
				else
					start--;
				if(end==0)
					end=N-1;
				else
					end--;
				//System.out.println("start"+start+" "+"end"+end);
			}
			else
			{
				if(K==N)
				{
					System.out.println(arr[0].number);
				}
				else if(start==0)
				{
					for(int j=N-1;j>=0;j--)
					{
						obj p=arr[j];
						if(p.startI>=start && p.startI<=end-K+1)
						{
							System.out.println(p.number);
							break;
						}
					}
				}
				else
				{
					for(int j=N-1;j>=0;j--)
					{
						obj p=arr[j];
						if(p.startI>p.endI)
						{
							if(start<p.endI+1|| start>p.startI )
							
							{
								continue;
							}
							System.out.println(p.number);
							break;
						}
						else
						{
							if(start<p.endI+1 && start>p.startI)
							{
								continue;
							}
							System.out.println(p.number);
							break;
						}
					}
					
				}
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

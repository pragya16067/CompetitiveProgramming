import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class ProbA{
	public float data;
	public int divfactor;
	
	public ProbA(int v,int x) {
		data=v;
		divfactor=x;
	}
	
	public void setDivFactor(int v) {
		this.divfactor=v;
	}
	
	public void setData(float v) {
		this.data=v;
	}
	
	public int getDivFactor() {
		return this.divfactor;
	}
	
	private static void mergesort(ProbA[] A,ProbA[] aux,int low, int high) {
		 if (low < high) {

		 int middle = (low + high) / 2;

		 mergesort(A,aux,low, middle);

		 mergesort(A,aux,middle + 1, high);
		 // Combine both the sorted subarrays
		 merge(A,aux,low, middle, high);
		 }
	}
	
	private static void merge(ProbA[] A,ProbA[] aux,int low, int middle, int high) {
		 // Copy contents of A into aux array
		 for (int i = low; i <= high; i++) {
		 aux[i] = A[i];
		 }
		 int i = low;
		 int j = middle + 1;
		 int k = low;
		 // Copy the smallest element from either sub arrays into A

		 
		
		 while (i <= middle && j <= high) {
			 if (aux[i].data <= aux[j].data) {
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
		int n=Reader.nextInt();
		int m=Reader.nextInt();
		int[] A=new int[n];
		ProbA[] Anew=new ProbA[n];
		ProbA[] aux=new ProbA[n];
		
		for(int i=0; i<n; i++)
		{
			A[i]=Reader.nextInt();
			Anew[i]=new ProbA(A[i],1);
		}
		
		
		if (n==m)
		{
			Arrays.sort(A);
			System.out.println(A[A.length-1]);
		}
		
		else
		{
			mergesort(Anew,aux,0,Anew.length-1);
			int divfactor=1;
			int ctr=1;
			for(int i=0; i<m-n; i++)
			{
				int j=Anew.length-1;
				divfactor=Anew[j].getDivFactor();
				float y=Anew[j].data*divfactor/(divfactor+1);
				Anew[j].setData(y);
				Anew[j].setDivFactor(divfactor+1);
				
				/*Arrays.sort(Anew, new Comparator<ProbA>() {
					
					@Override
					public int compare(ProbA x, ProbA y)
					{
						return Integer.compare(x.divfactor,y.divfactor);
					}
				});*/
				mergesort(Anew,aux,0,Anew.length-1);
				
				/*for(int k=0; k<A.length; k++)
				{
					System.out.print(Anew[k].data+" ");
				}System.out.println();*/
					
			}
			double ans=(Math.ceil(Anew[A.length-1].data));
			System.out.println((int) ans); 
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
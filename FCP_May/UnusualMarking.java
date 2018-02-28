import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

//Reference from GeeksForGeeks (Find Next Smaller Next Greater Array)

public class UnusualMarking {
	public static int count=0;
	
	// function find Next greater element
	public static void nextGreater(int arr[], int n, int next[], char order)
	{
	    // create empty stack
	    Stack<Integer> S=new Stack<Integer> ();
	 
	    // Traverse all array elements in reverse order
	    // order == 'G' we compute next greater elements of
	    //              every element
	    // order == 'S' we compute right smaller element of
	    //              every element
	    for (int i=n-1; i>=0; i--)
	    {
	        // Keep removing top element from S while the top
	        // element is smaller then or equal to arr[i] (if Key is G)
	        // element is greater then or equal to arr[i] (if order is S)
	        while (!S.empty() && ((order=='G')? arr[S.peek()] <= arr[i]:
	                           arr[S.peek()] >= arr[i]))
	            S.pop();
	 
	        // store the next greater element of current element
	        if (!S.empty())
	            next[i] = S.peek();
	 
	        // If all elements in S were smaller than arr[i]
	        else
	            next[i] = -1;
	 
	        // Push this element
	        S.push(i);
	    }
	}
	 
	// Function to find Right smaller element of next greater
	// element
	public static void nextSmallerOfNextGreater(int arr[], int n)
	{
	    int NG[]=new int[n]; // stores indexes of next greater elements
	    int RS[]=new int[n]; // stores indexes of right smaller elements
	 
	    // Find next greater element
	    // Here G indicate next greater element
	    nextGreater(arr, n, NG, 'G');
	 
	    // Find right smaller element
	    // using same function nextGreater()
	    // Here S indicate right smaller elements
	    nextGreater(arr, n, RS, 'S');
	 
	    // If NG[i] == -1 then there is no smaller element
	    // on right side. We can find Right smaller of next
	    // greater by arr[RS[NG[i]]]
	    
	    for (int i=0; i< n; i++)
	    {
	        if (NG[i] != -1 && RS[NG[i]] != -1)
	            count=count + 5;
	        else if(NG[i] != -1 && RS[NG[i]] == -1)
	            count=count + 10;
	        else
	        	count=count + 15;
	    }
	}

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int n=Reader.nextInt();
		int[] A=new int[n];
		
		for(int i=0; i<n; i++)
		{
			A[i]=Reader.nextInt();
		}
		
		nextSmallerOfNextGreater(A, n);
		System.out.println(count);
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

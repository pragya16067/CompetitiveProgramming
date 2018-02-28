import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Segment Tree class referenced from Geeks For Geeks

	// Java Program to show segment tree operations like construction,
	// query and update
	class SegmentTree 
	{
		int sum=0;
	    int st[]; // The array that stores segment tree nodes
	 
	    
	    SegmentTree(int arr[], int n)
	    {
	        // Allocate memory for segment tree
	        //Height of segment tree
	        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
	 
	        //Maximum size of segment tree
	        int max_size = 2 * (int) Math.pow(2, x) - 1;
	 
	        st = new int[max_size]; // Memory allocation
	 
	        constructSTUtil(arr, 0, n - 1, 0);
	    }
	    
	 // A recursive function that constructs Segment Tree for array[ss..se].
	    // si is index of current node in segment tree st
	    int constructSTUtil(int arr[], int ss, int se, int si)
	    {
	        // If there is one element in array, store it in current node of
	        // segment tree and return
	        if (ss == se) {
	            st[si] = arr[ss];
	            return arr[ss];
	        }
	 
	        // If there are more than one elements, then recur for left and
	        // right subtrees and store the sum of values in this node
	        int mid = getMid(ss, se);
	        st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) +
	                 constructSTUtil(arr, mid + 1, se, si * 2 + 2);
	        return st[si];
	    }
	 
	    // A utility function to get the middle index from corner indexes.
	    int getMid(int s, int e) {
	        return s + (e - s) / 2;
	    }
	 
	    
	      // The function to update a value in input array and segment tree.
	    void updateValue(int arr[], int n, int i, int new_val)
	    {
	        // Check for erroneous input index
	        if (i < 0 || i > n - 1) {
	            System.out.println("Invalid Input");
	            return;
	        }
	 
	        // Get the difference between new value and old value
	        int diff = new_val - arr[i];
	 
	        // Update the value in array
	        arr[i] = new_val;
	 
	        // Update the values of nodes in segment tree
	        updateValueUtil(0, n - 1, i, diff, 0);
	    }
	    

	    void updateValueUtil(int ss, int se, int i, int diff, int si)
	    {
	        // Base Case: If the input index lies outside the range of 
	        // this segment
	        if (i < ss || i > se)
	            return;
	 
	        // If the input index is in range of this node, then update the
	        // value of the node and its children
	        st[si] = st[si] + diff;
	        if (se != ss) {
	            int mid = getMid(ss, se);
	            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
	            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
	        }
	    }
	 
	 
	    // Return sum of elements in range from index qs (quey start) to
	   // qe (query end).  It mainly uses getSumUtil()
	    int getSum(int n, int qs, int qe)
	    {
	        // Check for erroneous input values
	        if (qs < 0 || qe > n - 1 || qs > qe) {
	            System.out.println("Invalid Input");
	            return -1;
	        }
	        return getSumUtil(0, n - 1, qs, qe, 0);
	    }
	    

	    int getSumUtil(int ss, int se, int qs, int qe, int si)
	    {
	        // If segment of this node is a part of given range, then return
	        // the sum of the segment
	        if (qs <= ss && qe >= se)
	            return st[si];
	 
	        // If segment of this node is outside the given range
	        if (se < qs || ss > qe)
	            return 0;
	 
	        // If a part of this segment overlaps with the given range
	        int mid = getMid(ss, se);
	        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
	                getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
	    }
	    
	    //To get the index of the element in array A which gives sum of no. of zeroes at least equal to K
	    int getIndex(int K,int[] A) {
	    	int low=0;
	    	int high=A.length-1;
	    	int mid=0;
	    	while(low <= high)
	    	{
	    		mid=(low + high)/2;
	    		if(getSum(A.length,0,mid)<K)
	    		{
	    			low=mid+1;
	    		}
	    		else
	    		{
	    			high=mid-1;
	    		}
	    	}
	    	return low;
	    	
	    }
	 
	    
	}
	 

public class ProbC {
	
	    public static void main(String[] args) throws IOException{
	    	Reader.init(System.in);
	    	int N=Reader.nextInt();
	    	int[] A=new int[N];
	    	
	    	for(int i=0; i<N; i++)
	    	{
	    		int n=Reader.nextInt();
	    		if(n==0)
	    			A[i]=1;
	    		else
	    		{
	    			int ctr=0;
	    			while(n>0)
		    		{
		    			if(n%10==0)
		    				ctr++;
		    			n=n/10;
		    		}
	    			A[i]=ctr;
	    		}
	    		
	    	}
	    	
	    	
	    	
	    	SegmentTree s=new SegmentTree(A,N);
	    	/*for(int j=0; j<s.st.length;j++)
	    	{
	    		System.out.print(s.st[j]+" ");
	    	}System.out.println();*/
	    	
	    	int Q=Reader.nextInt();
	    	while(Q-- > 0)
	    	{
	    		int ch=Reader.nextInt();
	    		if(ch==1)
	    		{
	    			int K=Reader.nextInt();
	    			//get index of when sum==K
	    			if(K>s.getSum(N, 0, N-1))
	    			{
	    				System.out.println(-1);
	    			}
	    			else
	    			{
		    			int i=s.getIndex(K,A);
		    			System.out.println(i);
	    			}
	    			//Add check fr K>N-1
	    		}
	    		else
	    		{
	    			int I=Reader.nextInt();
	    			int V=Reader.nextInt();
	    			int ctr=0;
	    			if(V==0)
		    			ctr=1;
		    		else
		    		{
		    			while(V>0)
			    		{
			    			if(V%10==0)
			    				ctr++;
			    			V=V/10;
			    		}
		    		}
	    			
	    			s.updateValue(A, N, I, ctr);
	    			
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

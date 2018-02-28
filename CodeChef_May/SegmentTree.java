
// Program for range maximum query using segment tree
class SegmentTreegetMaxOnes2
{
    int st[]; //array to store segment tree
 
    // A utility function to get minimum of two numbers
    int maxVal(int x, int y) {
        return (x > y) ? x : y;
    }
 
    // A utility function to get the middle index from corner
    // indexes.
    int getMid(int s, int e) {
        return s + (e - s) / 2;
    }
 
    /*  A recursive function to get the minimum value in a given
        range of array indexes. The following are parameters for
        this function.
 
        st    --> Pointer to segment tree
        index --> Index of current node in the segment tree. Initially
                   0 is passed as root is always at index 0
        ss & se  --> Starting and ending indexes of the segment
                     represented by current node, i.e., st[index]
        qs & qe  --> Starting and ending indexes of query range */
    int MaxQUtil(int ss, int se, int qs, int qe, int index)
    {
        // If segment of this node is a part of given range, then
        // return the min of the segment
        if (qs <= se && qe >= ss)
            return st[index];
 
        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return Integer.MAX_VALUE;
 
        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);
        return maxVal(MaxQUtil(ss, mid, qs, qe, 2 * index + 1),
                MaxQUtil(mid + 1, se, qs, qe, 2 * index + 2));
    }
 
    // Return minimum of elements in range from index qs (quey
    // start) to qe (query end).  It mainly uses MaxQUtil()
    int getMaxOnes(int n, int qs, int qe)
    {
        // Check for erroneous input values
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }
 
        return MaxQUtil(0, n - 1, qs, qe, 0);
    }
 
    // A recursive function that constructs Segment Tree for
    // array[ss..se]. si is index of current node in segment tree st
    int constructSTUtil(int arr[], int ss, int se, int si)
    {
        // If there is one element in array, store it in current
        //  node of segment tree and return
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }
 
        // If there are more than one elements, then recur for left and
        // right subtrees and store the minimum of two values in this node
        int mid = getMid(ss, se);
        st[si] = maxVal(constructSTUtil(arr, ss, mid, si * 2 + 1),
                constructSTUtil(arr, mid + 1, se, si * 2 + 2));
        return st[si];
    }
 
    /* Function to construct segment tree from given array. This function
       allocates memory for segment tree and calls constructSTUtil() to
       fill the allocated memory */
    void constructST(int arr[], int n)
    {
        // Allocate memory for segment tree
 
        //Height of segment tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
 
        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new int[max_size]; // allocate memory
 
        // Fill the allocated memory st
        constructSTUtil(arr, 0, n - 1, 0);
    }
    
    /* A recursive function to update the nodes which have the given 
    index in their range. The following are parameters
     st, si, ss and se are same as getSumUtil()
     i    --> index of the element to be updated. This index is in
              input array.
    diff --> Value to be added to all nodes which have i in range */
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

 // The function to update a value in input array and segment tree.
// It uses updateValueUtil() to update the value in segment tree
 void updateValue(int arr[], int n, int i,int old_value, int new_value)
 {
   
     if (st[i]==old_value && ( 2*i+1>=st.length || st[2*i+1]==0))
     {
    	 st[i]=new_value;
    	 checkParents(i);
    	 return;
     }
     else
     {
    	 if( (2*i)+1<st.length && (2*i)+2<st.length)
    	 {
    		 updateValue(arr,n,2*i+1,old_value,new_value);
    		 updateValue(arr,n,2*i+2,old_value,new_value);
    	 }
     }

    
 }
 
 void checkParents(int i) {
	 if(i==0)
		 return;
	 if(i%2==0) //Right child is updated
	 {
		 if(maxVal(st[i],st[i-1])!=st[(i-1)/2])
		 {
			 st[(i-1)/2]=maxVal(st[i],st[i-1]);
			 checkParents((i-1)/2);
		 }
		 else
			 return;
	 }
	 else if(i%2==1) //Left child is updated
	 {
		 if(maxVal(st[i],st[i+1])!=st[(i-1)/2])
		 {
			 st[(i-1)/2]=maxVal(st[i],st[i-1]);
			 checkParents((i-1)/2);
		 }
		 else
			 return;
	 }
	 
 }
 
 void display() {
	 for(int i=0; i<st.length; i++)
	 {
		 System.out.print(st[i]+" ");
	 }
	 System.out.println();
 }
 
 
    // Driver program to test above functions
    public static void main(String args[]) 
    {
        int arr[] = {1, 3, 2, 7, 9, 11};
        int n = arr.length;
        SegmentTreegetMaxOnes2 tree = new SegmentTreegetMaxOnes2();
 
        // Build segment tree from given array
        tree.constructST(arr, n);
 
        int qs = 1;  // Starting index of query range
        int qe = 5;  // Ending index of query range
 
        // Print minimum value in arr[qs..qe]
        System.out.println("Minimum of values in range [" + qs + ", "
                           + qe + "] is = " + tree.getMaxOnes(n, qs, qe));
        tree.display();
     // Update: set arr[1] = 20 and update corresponding segment
        // tree nodes
        tree.updateValue(arr, n, 1,3,20);
        tree.display();
        
        
        System.out.println("Minimum of values in range [" + qs + ", "
                + qe + "] is = " + tree.getMaxOnes(n, qs, qe));
    }
}

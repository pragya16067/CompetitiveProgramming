class Node {
	int start;
	int end;
	int length;
	int[] insertEdge=new int[26];
	int suffixEdge;
}


public class PalindromeTree {
	public Node Root1=new Node();
	public Node Root2=new Node();
	
	// stores Node information for constant time access
	Node[] tree=new Node[1000];
	 
	// Keeps track the current Node while insertion
	int currNode;
	String s;
	int ptr;
	
	public void insert(int idx) {
		//STEP 1//
		 
	    /* search for Node X such that s[idx] X S[idx]
	       is maximum palindrome ending at position idx
	       iterate down the suffix link of currNode to
	       find X */
	    int tmp = currNode;
	    while (true)
	    {
	        int curLength = tree[tmp].length;
	        if (idx - curLength >= 1 && s.charAt(idx) == s.charAt(idx-curLength-1))
	            break;
	        tmp = tree[tmp].suffixEdge;
	    }
	 
	    /* Now we have found X ....
	     * X = string at Node tmp
	     * Check : if s[idx] X s[idx] already exists or not*/
	    if(tree[tmp].insertEdge[s.charAt(idx)-'a'] != 0)
	    {
	        // s[idx] X s[idx] already exists in the tree
	        currNode = tree[tmp].insertEdge[s.charAt(idx)-'a'];
	        return;
	    }
	 
	    // creating new Node
	    ptr++;
	 
	    // making new Node as child of X with
	    // weight as s[idx]
	    tree[tmp].insertEdge[s.charAt(idx)-'a'] = ptr;
	 
	    // calculating length of new Node
	    //System.out.println(ptr);
	    tree[ptr].length = tree[tmp].length + 2;
	 
	    // updating end point for new Node
	    tree[ptr].end = idx;
	 
	    // updating the start for new Node
	    tree[ptr].start = idx - tree[ptr].length + 1;
	 
	 
	//STEP 2//
	 
	    /* Setting the suffix edge for the newly created
	       Node tree[ptr]. Finding some String Y such that
	       s[idx] + Y + s[idx] is longest possible
	       palindromic suffix for newly created Node.*/
	 
	    tmp = tree[tmp].suffixEdge;
	 
	    // making new Node as current Node
	    currNode = ptr;
	    if (tree[currNode].length == 1)
	    {
	        // if new palindrome's length is 1
	        // making its suffix link to be null string
	        tree[currNode].suffixEdge = 2;
	        return;
	    }
	    while (true)
	    {
	        int curLength = tree[tmp].length;
	        if (idx-curLength >= 1 && s.charAt(idx) == s.charAt(idx-curLength-1))
	            break;
	        tmp = tree[tmp].suffixEdge;
	    }
	 
	    // Now we have found string Y
	    // linking current Nodes suffix link with s[idx]+Y+s[idx]
	    tree[currNode].suffixEdge = tree[tmp].insertEdge[s.charAt(idx)-'a'];
	}
	
	
	public static void main(String[] args) {
		PalindromeTree obj=new PalindromeTree();
		
		// initializing the tree
	    obj.Root1.length = -1;
	    obj.Root1.suffixEdge = 1;
	    obj.Root2.length = 0;
	    obj.Root2.suffixEdge = 1;
	 
	    obj.tree[1] = obj.Root1;
	    obj.tree[2] = obj.Root2;
	    for(int i=3; i<1000; i++)
	    {
	    	obj.tree[i]=new Node();
	    }
	    obj.ptr = 2;
	    obj.currNode = 1;
	 
	    // given string
	    obj.s = "aaaaa";
	    int l = obj.s.length();
	 
	    for (int i=0; i<l; i++)
	    {
	        obj.insert(i);
	    }
	 
	    // printing all of its distinct palindromic
	    // substring of length 4
	    
	    int count=0;
	    for (int i=3; i<=obj.ptr; i++)
	    {
	    	String str="";
	        //System.out.print( (i-2) + ") ");
	        for (int j=obj.tree[i].start; j<=obj.tree[i].end; j++)
	            str=str+(obj.s.charAt(j));
	        if(str.length()==4)
	        {
	        	System.out.println(str);
	        	count++;
	        }
	        	
	    }
	    System.out.println(count);

	}

}

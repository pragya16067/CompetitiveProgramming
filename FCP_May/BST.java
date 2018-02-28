// NAME : PRAGYA PRAKASH
// ROLL NO. : 2016067


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class TreeNode {
	
	public TreeNode left;
	public TreeNode right;
	public int data;
	
	public TreeNode(TreeNode leftnode, TreeNode rightnode, int x) {
		this.left = leftnode;
		this.right = rightnode;
		this.data = x;
	}
	
	public TreeNode(int x) {
		this.left = null;
		this.right = null;
		this.data = x;
	}
	
	public TreeNode() {
		this.left = null;
		this.right = null;
		this.data = -1;
	}
	
	public void setData(int x) {
		this.data=x;
	}
	
}


public class BST {
	
	public TreeNode root;
	
	public BST(int r) {
		root=new TreeNode(r);
	}
	
	/* A recursive function to insert a new key in BST */
	public static TreeNode insert(TreeNode Root, int key) {
 
        /* If the tree is empty, return a new node */
        if (Root == null) {
            Root = new TreeNode(key);
            return Root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < Root.data)
            Root.left = insert(Root.left, key);
        else if (key > Root.data)
            Root.right = insert(Root.right, key);
 
        /* return the (unchanged) node pointer */
        return Root;
    }
	
	public static void printInorder(TreeNode root) {
		if(root==null)
		{
			return;
		}
		else{
			printInorder(root.left);
			System.out.println(root.data);
			printInorder(root.right);
		}
	}
	
	public static int getCount(int a, int b, TreeNode root) {
		if(a >= root.data && root.data >= b)
		{
			return (GetToVal(root,a,0) + GetToVal(root,b,0) - root.data);
		}
		else
		{
			if(a > root.data && b > root.data )
			{
				return getCount(a,b,root.right);
			}
			else
			{
				return getCount(a,b,root.left);
			}
		}
	}
	
	public static int GetToVal(TreeNode root, int val,int count) {
		if(root.data==val)
		{
			return (root.data + count);
		}
		
		if(root.data > val)
			return GetToVal(root.left,val,count+root.data);
		else
			return GetToVal(root.right,val,count+root.data);
		
	}

	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int N=Reader.nextInt();
		BST bst=new BST(2);
		
		for(int i=0; i<N; i++)
		{
			insert(bst.root,Reader.nextInt());
		}
		
		//printInorder(bst.root);
		//System.out.println(bst.root.data);
		
		int a=Reader.nextInt();
		int b=Reader.nextInt();
		int temp=0;
		if(a<b)
		{
			temp=a;
			a=b;
			b=temp;
		}
		System.out.println(getCount(a,b,bst.root));

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
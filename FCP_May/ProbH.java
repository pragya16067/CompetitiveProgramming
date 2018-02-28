import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//Implementation of TRIE inspired from Sanfoundry(How to implement a trie in java)

/*
 *  Java Program to Implement Trie
 */
 
import java.util.*;
 
class TrieNode 
{
    char content; 
    boolean isEnd; 
    int count;  
    LinkedList<TrieNode> childList; 
 
    /* Constructor */
    public TrieNode(char c)
    {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
        count = 0;
    }  
    public TrieNode subNode(char c)
    {
        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }
}
 
class Trie
{
    private TrieNode root;
 
     /* Constructor */
    public Trie()
    {
        root = new TrieNode(' '); 
    }
     /* Function to insert word */
    public void insert(String word)
    {
        /*if (search(word) == true) 
            return;*/        
        TrieNode current = root; 
        for (char ch : word.toCharArray() )
        {
            TrieNode child = current.subNode(ch);
            if (child != null)
                current = child;
            else 
            {
                 current.childList.add(new TrieNode(ch));
                 current = current.subNode(ch);
            }
            current.count++;
        }
        current.isEnd = true;
    }
    
    /* Function to search for word */
    public boolean search(String word)
    {
        TrieNode current = root;  
        for (char ch : word.toCharArray() )
        {
            if (current.subNode(ch) == null)
                return false;
            else
                current = current.subNode(ch);
        }      
        if (current.isEnd == true) 
            return true;
        return false;
    }
    
    
    public String maxXor(String word) {
    	TrieNode current = root;
    	String s="";
        for (char ch : word.toCharArray() )
        {
        	char c;
        	if(ch=='0')
        	{
        		c='1';
        	}
        	else
        	{
        		c='0';
        	}
        	
            if (current.subNode(c) == null)
            {
                current=current.subNode(ch);
                s=s+ch;
            }
            else
            {
                current = current.subNode(c);
                s=s+c;
            }
        }   
        return s;
        /*if (current.isEnd == true) 
            return s;
        return null;*/
    	
    }
    
    /* Function to remove a word */
    public void remove(String word)
    {           
        TrieNode current = root;
        for (char ch : word.toCharArray()) 
        { 
            TrieNode child = current.subNode(ch);
            if (child.count == 1) 
            {
                current.childList.remove(child);
                return;
            } 
            else 
            {
                child.count--;
                current = child;
            }
        }
        current.isEnd = false;
    }
    
}  



public class ProbH {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		
		long Q=Reader.nextLong();
		Trie T=new Trie();

		/*int n1=2;
		int n2=3;
		String s1=Integer.toBinaryString(n1);
		if(s1.length()!=32)
		{ 
			int rem=32-s1.length();
			for(int i=0;i<rem;i++)
			{
				s1="0"+s1;
			}
		}
		T.insert(s1);
		String s2=Integer.toBinaryString(n2);
		if(s2.length()!=32)
		{ 
			int rem=32-s2.length();
			for(int i=0;i<rem;i++)
			{
				s2="0"+s2;
			}
		}
		T.insert(s2);
		
		String str1="00000000000000000000000000000000";
		String ans1=T.maxXor(str1);
		int xorval1=Integer.parseInt(str1,2) ^ Integer.parseInt(ans1,2);
		System.out.println(xorval1);*/
		
		String str1="00000000000000000000000000000000";
		T.insert(str1);
		
		while(Q-- > 0)
		{
			String s=Reader.reader.readLine();
			String[] a=s.split(" ");
			if(a[0].equals("+"))
			{
				String str=Long.toBinaryString(Long.parseLong(a[1]));
				if(str.length()!=32)
				{ 
					int rem=32-str.length();
					for(int i=0;i<rem;i++)
					{
						str="0"+str;
					}
				}
				T.insert(str);
			}
			
			else if(a[0].equals("-"))
			{
				String str=Long.toBinaryString(Long.parseLong(a[1]));
				if(str.length()!=32)
				{ 
					int rem=32-str.length();
					for(int i=0;i<rem;i++)
					{
						str="0"+str;
					}
				}
				T.remove(str);
			}
			
			else
				
			{
				String str=Long.toBinaryString(Long.parseLong(a[1]));
				if(str.length()!=32)
				{ 
					int rem=32-str.length();
					for(int i=0;i<rem;i++)
					{
						str="0"+str;
					}
				}
				//System.out.println(str);
				String ans=T.maxXor(str);
				//System.out.println(ans);
				long xorval=Long.parseLong(str,2) ^ Long.parseLong(ans,2);
				System.out.println(xorval);
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

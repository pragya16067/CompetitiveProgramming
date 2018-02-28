
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

//Implementation of TRIE inspired from GeeksForGeeks(How to implement a trie in java)


// Trie Node, which stores a character and the children in a HashMap
class TrieNode {
	
	private char value;
    private HashMap<Character,TrieNode> children;
    private boolean bIsEnd;
    
    
    public TrieNode(char ch)  {
        value = ch;
        children = new HashMap<>();
        bIsEnd = false;
    }
    public HashMap<Character,TrieNode> getChildren() {   
    	return children;  
    }
    
    public char getValue() {
    	return value;     
    }
    
    public void setIsEnd(boolean val) {   
    	bIsEnd = val;     
    }
    
    public boolean isEnd() {   
    	return bIsEnd;    
    }
 
    
}
 
// Implements the actual Trie
class Trie {
	
	 private TrieNode root;
	
    // Constructor
    public Trie()   {     root = new TrieNode((char)0);       }    
 
    // Method to insert a new word to Trie
    public void insert(String word)  {
 
        // Find length of the given word
        int length = word.length();
        TrieNode crawl = root;
 
        // Traverse through all characters of given word
        for( int level = 0; level < length; level++)
        {
            HashMap<Character,TrieNode> child = crawl.getChildren();
            char ch = word.charAt(level);
 
            // If there is already a child for current character of given word
            if( child.containsKey(ch))
                crawl = child.get(ch);
            else   // Else create a child
            {
                TrieNode temp = new TrieNode(ch);
                child.put( ch, temp );
                crawl = temp;
            }
        }
 
        // Set bIsEnd true for last character
        crawl.setIsEnd(true);
    }
 
   
    
 // The main method that finds out the longest matching prefix
    public String getMatchingPrefix2(String input)  {
        String result = ""; // Initialize resultant string
        int length = input.length();  // length of the input string       
 
        TrieNode crawl = root;   
 
        int level, prevMatch = 0;
        for( level = 0 ; level < length; level++ )
        {
            // Find current character of str
            char ch = input.charAt(level);    
 
            // HashMap of current Trie node to traverse down
            HashMap<Character,TrieNode> child = crawl.getChildren();                        
 
            // See if there is a Trie edge for the current character
            if( child.containsKey(ch) )
            {
               result += ch;          //Update result
               crawl = child.get(ch); //Update crawl to move down in Trie
 
               //update prevMatch
               
               prevMatch = level + 1;
            }
            else  break;
        }
 
  
        return result;
    }
 
   
}
 
class WSITES01 {
   public static void main(String[] args) throws IOException {
        Trie dict = new Trie();
        
		Reader.init(System.in);
		int N=Reader.nextInt();
		
		String[] Blocked=new String[N+1];
		int endB=0;
		
		for(int i=0; i<N; i++)
		{
			//System.out.println(Blocked[i]);
			String n = Reader.reader.readLine();
			String[] s=n.split(" ");
			if(s[0].equals("+"))
			{
				dict.insert((String) s[1]);
			}
			
			if(s[0].equals("-"))
			{
				Blocked[endB++]=(String) s[1];
				//System.out.println(Blocked[endB]);
			}
		}
		
		if(endB==0)
		{
			System.out.println(-1);
		}
		else
		{
			try
			{
				String[] Prefix=new String[endB];
		
				for(int i=0;i<endB;i++)
				{
					String s = dict.getMatchingPrefix2(Blocked[i]);
					s=s+Blocked[i].charAt(s.length());
					Prefix[i]=s;
				}
				
				//To sort array in lexicographical order
				Arrays.sort(Prefix);
				
				//To remove duplicates from list of prefixes
				int it=1;
				int j=0;
				while(it < Prefix.length){
		            if(Prefix[it].equals(Prefix[j])){
		                it++;
		            }else{
		                Prefix[++j] = Prefix[it++];
		            }   
		        }
				
				//to print output
				System.out.println(j+1);
				for(int i=0;i<=j;i++)
				{
					System.out.println(Prefix[i]);
				}
			}
			catch(StringIndexOutOfBoundsException e)
			{
				System.out.println(-1);
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

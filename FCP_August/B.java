import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
	
	public static int count=0;
	public static int[] Amt;
	
	//returns an array of amount calculated for each friend
	public static void CalcAmt(int[][] matrix) {
		Amt=new int[matrix.length];
		
		//calculating net amount for each person by subtracting total debt from total credit of each person
		//Storing in Amt array
		for (int p=0; p<matrix.length; p++)
		{
	       for (int i=0; i<matrix.length; i++)
	       {
	          Amt[p] += (matrix[i][p] -  matrix[p][i]);
	       }
		}
		
	}

	//returns the index of borrower with min Amount
	 public static int getMinAmount () {
		  int min=0;
		  for(int i=1; i<Amt.length; i++)
		  {
			  if(Amt[i]<Amt[min])
			  {
				  min=i;
			  }
		  }
		  return min;
	  }
	  
	//returns the index of borrower with max Amount
	  public static int getMaxAmount () {
		  int max=0;
		  for(int i=1; i<Amt.length; i++)
		  {
			  if(Amt[i]>Amt[max])
			  {
				  max=i;
			  }
		  }
		  return max;
	  }
	  
	  public static int Min(int a,int b) {
		  if(a<b)
			  return a;
		  else
			  return b;
	  }

	  
	  public static void MinimizeTransactions() {
		  //To get the max amount that has been given(credited) to any person
		  int maxC = getMaxAmount();
		  
		  //to get the index of the person with the min amount i.e. the person with most debts
		  int maxD = getMinAmount();
		  
		  //Base Case :
		  // When both max values are zero we can stop
		  if (Amt[maxC] == 0 && Amt[maxD] == 0)
		        return;
		  
		  //Finding the min of the 2 amounts
		  int m=Min(Amt[maxC],-Amt[maxD]);
		  
		  //Updating Values
		  Amt[maxC] -= m;
		  Amt[maxD] += m;
		  
		  //System.out.println("person "+maxD+" pays "+ m +" to person "+maxC);
		  count+=m;
		  
		  MinimizeTransactions();
	  }
	
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int N=Reader.nextInt();
		int M=Reader.nextInt();
		int[][] DebtGraph = new int[N][N];
		
		while(M-- > 0) {
			int pi=Reader.nextInt()-1;
			int po=Reader.nextInt()-1;
			int money=Reader.nextInt();
			DebtGraph[pi][po] = money;	
		}
		
		CalcAmt(DebtGraph);
		MinimizeTransactions();
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


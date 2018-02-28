import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
 
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
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
class ziu{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int k=Reader.nextInt();
        int p=Reader.nextInt();
        int i=0;
        int[] a=new int[n];
        while(i<n){
            a[i]=Reader.nextInt();
            i++;
        }
        String s=Reader.next();
        i=0;
        int pt=0;
        while(i<p){
            if(s.charAt(i)=='!')pt++;
            else if (s.charAt(i)=='?'){
                int it=n-k+1;
                int j=0;
                int max=0;
                while(j<it){
                    int sum=0;
                    int t=pt+j;
                    while(t!=(pt+j+k-1)%n){
                        sum=sum+a[t];
                        t=(t+1)%n;
                    }
                    if (sum>max)max=sum;
                    j++;
                }
                System.out.println(max);
            }
        i++;
        }
    }
}

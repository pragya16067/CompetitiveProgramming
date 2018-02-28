import java.io.IOException;

public class Range {
	public static boolean[] prime;
	
	public static void sieveOfEratosthenes(int n)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        prime = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;
         
        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }
         
        // Print all prime numbers
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
                System.out.print(i + " ");
        }
    }
	

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int a=Reader.nextInt();
		int b=Reader.nextInt();
		int k=Reader.nextInt();
		
		sieveOfEratosthenes(b);
		prime[1]=false;
		/*for(int i=0; i<prime.length; i++)
		{
			System.out.print(prime[i]+" ");
		}*/
		
		int[] A=new int[b-a+1];
		
		for(int i=a; i<=b; i++)
		{
			A[i-a]=i;
		}
		
		int ctr=0;
		int width=0;
		for(int i=0;i<A.length;i++)
		{
			if(prime[i])
			{
				ctr++;
			}
			width++;
			if(ctr>=k)
			{
				break;
			}
		}
		if(ctr<k)
		{
			System.out.println(-1);
		}
		else
		{
			for(int i=0; i<=A.length-width; i++)
			{
				if(prime[i])
					ctr--;
				if(prime[i+width-1])
					ctr++;
				if(ctr<k)
					break;
			}
		}
		

	}

}

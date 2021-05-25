import java.io.*;
class Binomial
{
	public static void main(String  args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double p,q,P,Q,n,x,b = 0,f,bp;
		int ch;
		System.out.println("Enter the value of n");
		n = Integer.parseInt(br.readLine());
		System.out.println("Enter the value of of success rate in (%)");
		p = Integer.parseInt(br.readLine());
		P = p/100;
		q = 1-P;
		System.out.println("Success rate is "+P);
		System.out.println("Failure rate is "+q);
		
		System.out.println("Enter the value of x : ");
		x = Integer.parseInt(br.readLine());
		
		System.out.println("Menu");
		System.out.println("1. At least (>=)\n2. At most (<=)\n3. Exactly(=)\n4. Exit\n");
		System.out.println("Enter your choice");
		ch = Integer.parseInt(br.readLine());
		switch(ch)
		{
			case 1:
					for(int i = 0; i < x ; i++ )
					{						
					b+= combination(n,i)*power(P,i)*power(q,n-i);
					}
					bp = 1-b;
					System.out.println("Probability is "+bp);
					break;
			
			case 2:
					for (int i = 0; i <= x; i++)
					{
						b+= combination(n,i)*power(P,i)*power(q,n-i);
					}
					System.out.println("Probability is "+b);
					break;
			
			case 3:
					b = combination(n,x)*power(P,x)*power(q,n-x);
					System.out.println("Probability is "+b);
					break;
					
			case 4:
					break;
		} 
		
		
	}
	
	public static double factorial(double n)
	{
		double y,c,fact =1;
		y = n;
		if (y == 0)
			return 1;
		if(y == 1)
			return 1;
		else
		{
			for ( c = 1 ; c <= y ; c++ )
            fact = fact*c;
		}
		return fact;
	}
	
	public static double combination(double n,double x)
	{
		double m,p,comb;
		m = n;
		p = x;
		comb = factorial(m)/(factorial(p)*factorial(m-p));
		return comb;
	}
	
	


	public static double power(double q,double r)
	{
		double w,s;
		w = q;
		s = r;
		double d = 1;
		for (int i = 0 ; i < s ; i++ )
		{
			 d = w*d;
		}
		return d;
	}
}
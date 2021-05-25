//Program to generate random numbers based on linear congruential generator

import java.math.BigInteger;
import java.util.Random;
 
public class Linear_Congruential_Random_Numbers 
{
    public static void main(String args[])
    {
        BigInteger n = new BigInteger(16, new Random(){});
        Random rand = new Random();
        BigInteger m = new BigInteger("65535");
 
        for(int i=0; i<5; i++)
        {
            System.out.print(n+", ");
            BigInteger a = new BigInteger(16, new Random(){});
            BigInteger c = new BigInteger(16, new Random(){});
            n = ((a.multiply(a)).add(c)).mod(m);
        }
        System.out.println("... ");
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class Test_RunsAboveBelow {
         
    ArrayList<Double> randomNumbers;   
    int runCount=0, n1=0, n2=0;   
    Boolean sign = null;   
    double mew, sigma_sqr, Z;
 
    public Test_RunsAboveBelow() {
        randomNumbers = new ArrayList<Double>();
         
        acceptRandomNumbers();
        performTest();
        printResult();
    }
 
     
    public Test_RunsAboveBelow(ArrayList<Double> randomNumbers) {
         
        this.randomNumbers = randomNumbers;
         
        acceptRandomNumbers();
        performTest();
        printResult();
    }
     
    private void performTest()
    {
        doRunCount();
         
        double b = runCount;
        double N = randomNumbers.size();
         
        double twoInton1n2 = (2.0*n1*n2);
         
        mew = (twoInton1n2/N)+0.5;
        sigma_sqr = twoInton1n2*(twoInton1n2-N)/(Math.pow(N, 2)*(N-1));
        Z = (b-mew)/Math.sqrt(sigma_sqr);
    }
     
    private void doRunCount()
    {
        for(double r : randomNumbers)
        {
            if(sign!=null)
            {
                if(r>0.495)
                {
                    n1++;
                     
                    if(!sign)
                    {
                        sign=true;
                        runCount++;
                    }
                }
                else
                {
                    n2++;
                     
                    if(sign)
                    {
                        sign=false;
                        runCount++;
                    }
                }
            }
            else
            {
                if(r>0.495)
                {
                    n1++;
                    sign=true;
                }
                else
                {
                    n2++;
                    sign=false;
                }
                runCount++;
            }
        }
    }
     
    private  void printResult()
    {
        System.out.println("Result -");
        System.out.println("b = " + runCount);
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
        System.out.println("Mew = " + mew);
        System.out.println("Sigma^2 = " + sigma_sqr);
        System.out.println("Z = " + Z);
    }
     
    public void acceptRandomNumbers()
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             
            System.out.print("Sample Space (N) = ");
            int count = Integer.parseInt(br.readLine());
             
            System.out.println("\nEnter Random Numbers: ");
             
            for(int i=0; i<count; i++)
            {
                randomNumbers.add(Double.parseDouble(br.readLine()));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }   
     
    public static void main(String[] args)
    {
        Test_RunsAboveBelow test_RAB = new Test_RunsAboveBelow();
    }     
}
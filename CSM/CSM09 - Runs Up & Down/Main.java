import java.io.*;

class RunUpAndDown {

    void ruab(double seq[], double n, double critical) {
        double count = 1;                          
        int i = 0;

        f:
        while (i < n - 1) {

            int j = 0;
            while (seq[i] < seq[i + 1]) {
                i++;
                j++;

                if (i == n - 1) {
                    break f;
                }
            }

            if (j > 0) {
                count++;
            }

            while (seq[i] > seq[i + 1]) {
                i++;

                if (i == n - 1) {
                    break f;
                }
            }

            count++;
        }

        

        double mean = ((2 * n) - 1) / 3.0;                      
        double varsq = ((16 * n) - 29) / 90;                   
        double var = Math.sqrt(varsq);                    
        double z = (count - mean) / var;

        System.out.println(rup);

        if (critical > z && z > -critical) {
            System.out.println("Randomness of given numbers accepted");
        } else {
            System.out.println("Randomness of given numbers rejected");
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter total number in sequence : ");
        int n = Integer.parseInt(br.readLine());


        double seq[] = new double[n];
        System.out.println("Enter numbers in sequences : ");
        for (int i = 0; i < n; i++) {
            seq[i] = Double.parseDouble(br.readLine());
        }

        double p = (double) n;

        RunUpAndDown r = new RunUpAndDown();
        r.ruab(seq, p, 1.96);

    }
}
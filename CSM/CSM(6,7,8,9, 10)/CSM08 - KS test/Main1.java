import java.io.*;

class KSTest {

    void kst(double num[], double dalpha) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    double temp;
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        double d1[] = new double[num.length];
        double d2[] = new double[num.length];
        double n = (double) num.length;

        for (int i = 0; i < num.length; i++) {
            d1[i] = ((i + 1) / n) - num[i];
        }

        for (int i = 0; i < num.length; i++) {
            d2[i] = (num[i] - (i) / n);
        }

        double d1max = d1[0];
        for (int i = 0; i < num.length; i++) {
            if (d1max <= d1[i]) {
                d1max = d1[i];
            }
        }

        System.out.println("D+ = " + d1max);

        double d2max = d2[0];
        for (int i = 0; i < num.length; i++) {
            if (d2max <= d2[i]) {
                d2max = d2[i];
            }
        }

        System.out.println("D- = " + d2max);

        double dplus = d1max;
        double dminus = d2max;
        double d;

        if (dplus > dminus) {
            d = dplus;
            System.out.println("D = " + d);
        } else {
            d = dminus;
            System.out.println("D = " + d);
        }

        if (dalpha > d) {
            System.out.println("Given numbers uniformity accepted");
        } else {
            System.out.println("Given numbers uniformity rejected");
        }

    }
}

public class Main1 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter total numbers : ");
        int n = Integer.parseInt(br.readLine());

        double a[] = new double[n];

        System.out.println("Enter numbers : ");
        for (int i = 0; i < n; i++) {
            a[i] = Double.parseDouble(br.readLine());
        }

        double da;

        System.out.println("Enter critcal value : ");
        da = Double.parseDouble(br.readLine());

        KSTest ks = new KSTest();
        ks.kst(a, da);

    }
}
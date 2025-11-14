import java.util.*;
 
public class start {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Cik kriteijas \n");
        int m = sc.nextInt(); sc.nextLine();
 
        String[] names = new String[m];
        double[] weights = new double[m];
        double sum = 0;
 
        for (int i = 0; i < m; i++) {
            System.out.print("Kriterijas nosaukums \n" + (i+1) + ": ");
            names[i] = sc.nextLine().trim();
 
            System.out.print("svars % (5..100): ");
            double w = sc.nextDouble(); sc.nextLine();
            if (w < 5 || w > 100) { System.out.println("Neder tāds"); return; }
 
            weights[i] = w;
            sum += w;
        }
        if (sum > 100.0) { System.out.println("virs 100% parsniedz"); return; }
 
        System.out.print("Cik studenti? ");
        int n = sc.nextInt(); sc.nextLine();
 
        String[] students = new String[n];
        double[][] grades = new double[n][m];
 
        for (int s = 0; s < n; s++) {
            System.out.print("Studenta vards: ");
            students[s] = sc.nextLine().trim();
 
            for (int i = 0; i < m; i++) {
                System.out.print("Atzime \"" + names[i] + "\" (0..10): ");
                double g = sc.nextDouble(); sc.nextLine();
                if (g < 0 || g > 10) { System.out.println("Neder tada atzime"); return; }
                grades[s][i] = g;
            }
        }
 
        System.out.println("\n |||||||||||||||BEIGAS VERTESANAS||||||||||||||| ");
        for (int s = 0; s < n; s++) {
            double finalGrade = 0;
            for (int i = 0; i < m; i++) {
                finalGrade += grades[s][i] * (weights[i] / 100.0);
            }
            System.out.printf("%s: %.2f%n", students[s], finalGrade);
        }
    }
}
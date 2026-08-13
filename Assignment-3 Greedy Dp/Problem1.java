import java.util.*;

class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int budget = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        Arrays.sort(a);

        int count = 0;

        for (int x : a) {
            if (x <= budget) {
                budget -= x;
                count++;
            }
        }

        System.out.println(count);
    }
}
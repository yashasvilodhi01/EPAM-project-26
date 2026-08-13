import java.util.*;

class Problem2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int prev2 = 0;
        int prev1 = 0;

        for (int i = 0; i < n; i++) {
            int take = prev2 + a[i];
            int skip = prev1;

            int current = Math.max(take, skip);

            prev2 = prev1;
            prev1 = current;
        }

        System.out.println(prev1);
    }
}

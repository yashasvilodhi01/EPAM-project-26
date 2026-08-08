import java.util.*;

public class Problem1 {

    static ArrayList<Integer>[] graph;
    static int[] key;
    static int count = 0;
    static int K;

    static void dfs(int node, int parent, int xor) {

        xor = xor ^ key[node];

        if (xor >= K) {
            count++;
        }

        for (int next : graph[node]) {
            if (next != parent) {
                dfs(next, node, xor);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        K = sc.nextInt();

        key = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            key[i] = sc.nextInt();
        }

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1, 0, 0);

        System.out.println(count);

        sc.close();
    }
}
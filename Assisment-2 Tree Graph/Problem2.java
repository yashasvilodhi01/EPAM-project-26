import java.util.*;

public class Problem2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] distance = new int[N + 1];

        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();

        distance[1] = 0;
        queue.add(1);

        while (!queue.isEmpty()) {

            int current = queue.remove();

            for (int next : graph[current]) {

                if (distance[next] == -1) {

                    distance[next] = distance[current] + 1;

                    queue.add(next);
                }
            }
        }

        int count = 0;

        for (int i = 1; i <= N; i++) {

            if (distance[i] != -1 && distance[i] <= D) {
                count++;
            }
        }

        System.out.println(count);

        sc.close();
    }
}
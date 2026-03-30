import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] red = new ArrayList[n];
        List<Integer>[] blue = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            red[i] = new ArrayList<>();
            blue[i] = new ArrayList<>();
        }
        
        for (int[] e : redEdges) red[e[0]].add(e[1]);
        for (int[] e : blueEdges) blue[e[0]].add(e[1]);
        
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        boolean[][] visited = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});
        visited[0][0] = true;
        visited[0][1] = true;
        
        int dist = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int node = cur[0], color = cur[1];
                
                if (ans[node] == -1) ans[node] = dist;
                
                if (color == 0) {
                    for (int next : blue[node]) {
                        if (!visited[next][1]) {
                            visited[next][1] = true;
                            q.offer(new int[]{next, 1});
                        }
                    }
                } else {
                    for (int next : red[node]) {
                        if (!visited[next][0]) {
                            visited[next][0] = true;
                            q.offer(new int[]{next, 0});
                        }
                    }
                }
            }
            
            dist++;
        }
        
        return ans;
    }
}
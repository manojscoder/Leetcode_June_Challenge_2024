// problem link: https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/description
// Time: O(n ^ 2 log n + m)
// Space: O(n ^ 2 + m)
class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[n];
        int[] degree = new int[n];

        for(int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();

        for(int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            degree[edges[i][1]]++;
        }

        Queue<Integer> ZeroDegree = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Set<Integer>> ancSet = new ArrayList<>();

        for(int i = 0; i < n; i++)
            if(degree[i] == 0)
                ZeroDegree.offer(i);
        
        while(!ZeroDegree.isEmpty()) {
            int curr = ZeroDegree.poll();
            topo.add(curr);

            for(int v : adjList[curr]) {
                degree[v]--;
                if(degree[v] == 0)
                    ZeroDegree.offer(v);
            }
        }
        
        for(int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
            ancSet.add(new HashSet<>());
        }

        for(int node : topo) {
            for(int nei : adjList[node]) {
                ancSet.get(nei).add(node);
                ancSet.get(nei).addAll(ancSet.get(node));
            }
        }

        for(int i = 0; i < n; i++) {
            result.get(i).addAll(ancSet.get(i));
            Collections.sort(result.get(i));
        }

        return result;
    }
}

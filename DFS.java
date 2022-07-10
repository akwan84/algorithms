import java.util.*;
public class DFS {
	static HashMap<Integer, List<Integer>> map = new HashMap<>();
	
	public static void buildGraph(int n, int[][] edges) {
		for(int i = 1; i <= n; i++) {
			map.put(i, new ArrayList<>());
		}
		
		for(int[] edge : edges) {
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}
	}
	
	public static void main(String[] args) {
		int n = 4; //number of nodes (nodes from 0 to n - 1)
		int[][] edges = {{1, 2}, {3, 4}, {2, 3}}; //undirected edges
		
		buildGraph(n, edges);
		
		dfs(1, new HashSet<Integer>());
	}
	
	public static void dfs(int cur, Set<Integer> visited) {
		System.out.println(cur);
		visited.add(cur);
		for(Integer x : map.get(cur)) {
			if(!visited.contains(x)) {
				dfs(x, visited);
			}
		}
	}
}

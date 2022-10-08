public boolean isBipartite(int[][] graph) {
	var color = new int[graph.length];
	Arrays.fill(color, -1);

	for (var i = 0; i < graph.length; i++)
		if (color[i] == -1 && !bfs(i, graph, color))
			return false;
	return true;
}

private boolean bfs(int node, int[][] graph, int[] color) {
	var q = new ArrayDeque<>(List.of(node));
	color[node] = 0;

	while (!q.isEmpty()) {
		var curr = q.poll();
		for (var neighbor : graph[curr]) {
			if (color[neighbor] == color[curr])
				return false;
			if (color[neighbor] == -1) {
				color[neighbor] = 1 - color[curr];
				q.add(neighbor);
			}
		}
	}
	return true;
}

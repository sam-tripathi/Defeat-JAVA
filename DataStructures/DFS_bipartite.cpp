public boolean isBipartite(int[][] graph) {
	var colors = new int[graph.length];
	for (var i = 0; i < graph.length; i++)
		if (colors[i] == 0 && !dfs(graph, colors, 1, i))
			return false;
	return true;

}

private boolean dfs(int[][] graph, int[] colors, int color, int node) {
	if (colors[node] != 0)
		return colors[node] == color; // is the node the same color it was about to be colored with?
	colors[node] = color;

	for (var nei : graph[node])
		if (!dfs(graph, colors, -color, nei))
			return false;
	return true;
}

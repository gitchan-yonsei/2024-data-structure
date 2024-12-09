/*
 * Name: 조은기
 * Student ID #: 2019147029
 */

import java.util.ArrayList;

/*
 * Do NOT import additional packages/classes.
 * If you (un)intentionally use packages/classes we did not provide,
 * you will get 0.
 */

public class FindCycle {
    public static ArrayList<Object> findCycle(UndirectedGraph g) {
        /*
         * Input: an undirected graph
         *
         * Output: the ArrayList containing vertices and edges
         *
         * Does:
         *  - conduct DFS in increasing order of index to find a cycle in the given undirected graph.
         *  - if a cycle is found, save and return the alternating sequence of vertices and edges in the arraylist.
         *  - the sequence must start and end with the vertex in the cycle whose index is the smallest.
         *  - in the sequence, there will be two edges incident to the start vertex.
         *  - the edge with the larger index must come after the start vertex, and the edge with the smaller index must come before the end vertex.
         *  - if a cycle is not found, return null.
         *  - we will use a graph with only one cycle as input.
         *  - please note that the given graph may not be connected.
         */
        boolean[] visited = new boolean[g.numVertices()];
        ArrayList<Object> path = new ArrayList<>();
        ArrayList<Object> result = new ArrayList<>();

        for (Vertex v : g.vertices()) {
            if (!visited[v.getIdx()]) {
                if (dfs(g, v, null, visited, path, result)) {
                    break;
                }
            }
        }

        if (!result.isEmpty()) {
            return reorderCycle(result);
        }
        return null;
    }

    private static boolean dfs(UndirectedGraph g, Vertex current, Edge parentEdge, boolean[] visited, ArrayList<Object> path, ArrayList<Object> result) {
        visited[current.getIdx()] = true;
        path.add(current); // 현재 정점을 경로에 추가

        // 현재 정점과 연결된 모든 간선 탐색
        for (Edge edge : g.incidentEdges(current)) {
            Vertex next = g.opposite(current, edge);
            if (result.isEmpty()) {
                if (!visited[next.getIdx()]) {
                    path.add(edge); // 간선을 경로에 추가
                    if (dfs(g, next, edge, visited, path, result)) {
                        return true;
                    }
                    path.remove(path.size() - 1); // 간선 제거
                } else if (parentEdge == null || next.getIdx() != g.opposite(current, parentEdge).getIdx()) {
                    // 사이클 발견
                    result.add(next); // 사이클 시작점 추가
                    result.add(edge); // 사이클 간선 추가

                    // 경로에서 사이클 경로만 추출
                    int index = path.lastIndexOf(next);
                    for (int i = index + 1; i < path.size(); i++) {
                        result.add(path.get(i));
                    }
                    result.add(next);
                    return true;
                }
            }
        }

        path.remove(path.size() - 1); // 현재 정점 제거
        return false;
    }

    private static ArrayList<Object> reorderCycle(ArrayList<Object> cycle) {
        int minVertexIdx = Integer.MAX_VALUE;
        int startIndex = -1;

        // 가장 작은 인덱스를 가진 정점 찾기
        for (int i = 0; i < cycle.size(); i++) {
            if (cycle.get(i) instanceof Vertex) {
                Vertex v = (Vertex) cycle.get(i);
                if (v.getIdx() < minVertexIdx) {
                    minVertexIdx = v.getIdx();
                    startIndex = i;
                }
            }
        }

        // 시작점을 기준으로 사이클 순서 재배치
        ArrayList<Object> reordered = new ArrayList<>();
        for (int i = startIndex; i < cycle.size(); i++) {
            reordered.add(cycle.get(i));
        }
        for (int i = 0; i < startIndex; i++) {
            reordered.add(cycle.get(i));
        }

        // 조건에 맞게 간선 순서 정렬
        if (reordered.get(1) instanceof Edge && reordered.get(reordered.size() - 2) instanceof Edge) {
            Edge firstEdge = (Edge) reordered.get(1);
            Edge lastEdge = (Edge) reordered.get(reordered.size() - 2);
            if (firstEdge.getIdx() > lastEdge.getIdx()) {
                reordered.set(1, lastEdge);
                reordered.set(reordered.size() - 2, firstEdge);
            }
        }
        return reordered;
    }
}

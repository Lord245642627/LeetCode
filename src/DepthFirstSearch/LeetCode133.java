package DepthFirstSearch;

import utils.Node;

import java.util.*;

/**
 * @author Lord Camelot
 * @date 2024/3/22
 * @description LeetCode133 深度优先搜索
 */
public class LeetCode133 {
    Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        visited.put(node, newNode);
        for (Node n : node.neighbors) {
            newNode.neighbors.add(cloneGraph(n));
        }
        return newNode;
    }

    private Node bfs(Node node) {
        if (node == null) {
            return node;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        visited.put(node, new Node(node.val, new ArrayList()));
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}

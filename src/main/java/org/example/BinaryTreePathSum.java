package org.example;

import org.example.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
Given the root of a binary tree and an integer targetSum,
return the number of paths where the sum of the values
along the path equals targetSum.

The path does not need to start or end at the root or a leaf,
but it must go downwards
(i.e., traveling only from parent nodes to child nodes).

DFS: Depth-First Search, búsqueda en profundidad
(Explorar un árbol yendo lo más profundo posible por un
camino antes de retroceder)
*/
public class BinaryTreePathSum {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, 1); // caso base
        return dfs(root, 0, targetSum, prefixMap);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixMap) {
        if (node == null) return 0;

        currentSum += node.val;

        // Número de caminos válidos que terminan en este nodo
        int count = prefixMap.getOrDefault(currentSum - targetSum, 0);

        // Agregar currentSum al mapa
        prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);

        // Recorrer hijos
        count += dfs(node.left, currentSum, targetSum, prefixMap);
        count += dfs(node.right, currentSum, targetSum, prefixMap);

        // Backtrack: eliminar la suma actual
        prefixMap.put(currentSum, prefixMap.get(currentSum) - 1);

        return count;
    }
}

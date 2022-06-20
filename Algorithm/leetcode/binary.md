## Lowest Common Ancestor of a Binary Search Tree

```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, Math.min(p.val, q.val), Math.max(p.val, q.val));
    }

    public TreeNode lca (TreeNode root, int min, int max) {
        if (min <= root.val && root.val <= max) return root;
        // max보다 크다는 것은 현재 root 의 왼편으로 탐색 필요
        // (binary search tree 는 자신의 값보다 큰것을 오른쪽에 descendant 를두고 작은 것은 왼쪽에 둔다)
        if (root.val > max) return lca(root.left, min, max);
        if (root.val < min) return lca(root.right, min, max);
        return null;
    }
}
```

## 236. Lowest Common Ancestor of a Binary Tree

- binary Search Tree 가 아니기 때문에 전부 탐색해야 함.

````
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // All Node.val are unique.
        // 본인의 숫자가 나오면 다른 숫자가 상관없이 본인의 node return
        if (root == p || root == q) return root;

        // search over left and right
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 마지막 노드까지 탐색 이후
        if (left != null && right != null) return root;
        if (left != null) return left;
        else return right;
    }
}
```
````

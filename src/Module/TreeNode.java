package Module;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(String x) {
        val = Integer.valueOf(x);
    }

    @Override
    public String toString() {
        return val + "";
    }

    public static List<TreeNode> level(TreeNode node) {
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<TreeNode> result = new LinkedList<>();
        list.add(node);
        while (!list.isEmpty()) {
            node = list.poll();
            result.add(node);
            if (node.left != null)
                list.offer(node.left);
            if (node.right != null)
                list.offer(node.right);
        }
        return result;
    }

    public static List<TreeNode> toList(TreeNode treeNode) {
        List<TreeNode> nodelist = new LinkedList<>();
        addNode(nodelist, treeNode);
        return nodelist;
    }

    public static void addNode(List<TreeNode> nodelist, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        nodelist.add(treeNode);
        addNode(nodelist, treeNode.left);
        addNode(nodelist, treeNode.right);
    }

    public static TreeNode toTree(List<TreeNode> nodes) {
        for (int i = 0; i < nodes.size() / 2 - 1; i++) {
            nodes.get(i).left = nodes.get(2 * i + 1);
            nodes.get(i).right = nodes.get(2 * i + 2);
        }
        int lastParentIndex = nodes.size() / 2 - 1;
        nodes.get(lastParentIndex).left = nodes.get(2 * lastParentIndex + 1);
        if (lastParentIndex % 2 == 0) {
            nodes.get(lastParentIndex).right = nodes.get(2 * lastParentIndex + 2);
        }
        return nodes.get(0);
    }

    public static List<TreeNode> createTree(String... nodes) {
        List<TreeNode> nodelist = new LinkedList<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) {
                nodelist.add(null);
            } else {
                nodelist.add(new TreeNode(nodes[i]));
            }
        }
        for (int i = 0; i < nodes.length / 2 - 1; i++) {
            nodelist.get(i).left = nodelist.get(2 * i + 1);
            nodelist.get(i).right = nodelist.get(2 * i + 2);
        }
        int lastParentIndex = nodes.length / 2 - 1;
        nodelist.get(lastParentIndex).left = nodelist.get(2 * lastParentIndex + 1);
        if (lastParentIndex % 2 == 0) {
            nodelist.get(lastParentIndex).right = nodelist.get(2 * lastParentIndex + 2);
        }
        return nodelist;
    }
}

import Module.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author fuyou
 * @Date 2019/1/10 10:23
 */
public class MergeTrees {
    public static final String[] t1 = {"1","3","2","5"};
    public static final String[] t2 = {"2","1","3","0","4","0","7"};

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        mergeTrees(TreeNode.createTree(t1).get(0), TreeNode.createTree(t2).get(0));
//        System.out.println(TreeNode.level(TreeNode.createTree(t1).get(0)));
//        System.out.println(TreeNode.level(TreeNode.createTree(t2).get(0)));
        System.out.println(System.currentTimeMillis());
    }

    static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        List<TreeNode> nodes1 = TreeNode.level(t1);
        List<TreeNode> nodes2 = TreeNode.level(t2);
        List<Integer> result = new LinkedList<>();
        int size = Math.min(nodes1.size(), nodes2.size());
        int bsize = Math.max(nodes1.size(), nodes2.size());
        for (int i = 0; i < size; i++) {
            result.add(nodes1.get(i).val + nodes2.get(i).val);
        }
        for (int i = size; i <bsize; i++) {
            result.add(nodes2.get(i).val);
        }
        System.out.println(result);
        return null;
    }
}

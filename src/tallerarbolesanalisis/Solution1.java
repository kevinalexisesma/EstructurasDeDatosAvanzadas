package tallerarbolesanalisis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 {

    List<TreeNode> tree;
    public Solution1(TreeNode root) {
        tree = new ArrayList<>();
        tree.add(root);
        for (int i = 0; i < tree.size(); ++i) {
            if (tree.get(i).left != null) tree.add(tree.get(i).left);
            if (tree.get(i).right != null && tree.get(i).left != null) tree.add(tree.get(i).right);
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        int tamanio = tree.size();
        tree.add(node);
        if(tamanio%2 == 0){
            tree.get((tamanio-1)/2).right = node;
        }else{
            tree.get((tamanio-1)/2).left = node;
        }
        return tree.get((tamanio-1)/2).val;
    }

    public TreeNode get_root() {
        return tree.get(0);
    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int i, TreeNode treeNode) {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


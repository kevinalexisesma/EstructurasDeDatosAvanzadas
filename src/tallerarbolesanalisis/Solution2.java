package tallerarbolesanalisis;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    List<Integer> inorder = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorderT(root);
        return inorder;
    }


    public void inorderT(TreeNode root) {
        if(root != null){
            if(root.left !=  null){
                inorderT(root.left);
            }
            inorder.add(root.val);
            if(root.right != null){
                inorderT(root.right);
            }
        }
    }
}

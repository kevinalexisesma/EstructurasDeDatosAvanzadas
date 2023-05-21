package tallerarbolesanalisis;

public class Solution3 {

    boolean bst = true;
    TreeNode previous = null;
    public void isValid(TreeNode root){
        if(root==null){
            return;
        }
        isValid(root.left);
        if(previous!=null && previous.val>=root.val){
            bst = false;
        }
        previous = root;
        isValid(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        isValid(root);
        return bst;
    }

}

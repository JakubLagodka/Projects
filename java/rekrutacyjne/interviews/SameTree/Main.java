public class Test {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
        public boolean isSameTree(TreeNode p, TreeNode q) {
            TreeNode tmpP = p, tmpQ = q;
            int counter = 0;
            while(p != null){
                if(q == null || p.val!=q.val){
                    return false;
                }
                p = p.left;
                q = q.left;
                counter++;
            }
            if(q != null){
                return false;
            }
            while(tmpP != null){
                if(tmpQ == null || tmpP.val!=tmpQ.val){
                    return false;
                }
                tmpP = tmpP.right;
                tmpQ = tmpQ.right;
                counter++;
            }
            if(tmpQ != null){
                return false;
            }
            if(counter > 10){
                return false;
            }
            return true;
        }
    }
    public static void main(String[] args) {

    }
}

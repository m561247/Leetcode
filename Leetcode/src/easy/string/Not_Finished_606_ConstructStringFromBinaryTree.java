package easy.string;
/**
 * 等學完樹再來
 */

public class Not_Finished_606_ConstructStringFromBinaryTree {
	/*
	 * Use Lib
	 */
	private static class UseLib {
		
		private static class TreeNode {
			      int val;
			      TreeNode left;
			      TreeNode right;
			      TreeNode() {}
			      TreeNode(int val) { this.val = val; }
			      TreeNode(int val, TreeNode left, TreeNode right) {
			          this.val = val;
			          this.left = left;
			          this.right = right;
			      }
			  }
	    public String tree2str(TreeNode t) {
			return "12345";
	    }
	}
	
	private static class WithOutLib {
		
		private static class TreeNode {
			      int val;
			      TreeNode left;
			      TreeNode right;
			      TreeNode() {}
			      TreeNode(int val) { this.val = val; }
			      TreeNode(int val, TreeNode left, TreeNode right) {
			          this.val = val;
			          this.left = left;
			          this.right = right;
			      }
			  }
	    public String tree2str(TreeNode t) {
			return "12345";
	    }
	}

}

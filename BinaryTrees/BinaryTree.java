public class BinaryTree<T> {

	private BinaryTreeNode<T> root;

	public BinaryTree() {
		this(null);
	}

	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}
	
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	@Override
	public boolean equals(Object o) {
		//To do
	}

	public BinaryTree<T> deepCopy() {
		//To do
	}

	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t,
			boolean left) {
		//To do
	}
	
	public int size(){
		//To do
	}
	
	public int height(){
		//To do
	}
	
	public boolean full(){
		//To do
	}
	
	public void mirror(){
		//To do
	}
	
	public String inOrder(){
		//To do
	}
}

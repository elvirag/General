package trees;

/**
 * RBTree.java
 * Purpose: A super class to implement (common methods of) Red-Black-Tree. 
 */
public class RBTree {

	protected Node _root, _nil; //the root and nil (sentry)

	/** Class Constructor (default) */
	public RBTree(){
		//initializing all the instance variables
		_nil = createNode();
		_nil.setColor(Node.Colors.BLACK); //the sentry is always black
		_root = _nil;
		_root._left = _root._right = _nil;
		_root.setParent(_nil);
	}
	
	/** 
	 * used in constructors to prevent Type hiding
	 * @return a new Node of appropriate Type (Node) 
	 */
	protected Node createNode() {
		return new Node("");
	}
	
	/**
	 * used in constructors to prevent Type hiding
	 * @param id the key for this node
	 * @return a new Node of this Type
	 */
	protected Node createNode(String id) {
		return new Node(id);
	}

	/**
	 * Insert a new node into this tree (copy from the book (pg. 236) changes are commented)
	 * @param tree the tree to insert a node
	 * @param z the node to insert
	 */
	public void insert(RBTree tree, Node z) {

		//changed from book to match java language 
		Node y = _nil, x = _root;
		z._left = z._right = _nil;
		
		while(x!=_nil){
			y = x;
			if(z.getKey().compareTo(x.getKey())<0)
				x = x._left;
			else
				x = x._right;
		}

		z.setParent(y);
		if(y==tree._nil){
			tree.setRoot(z);
			tree._root.setParent(tree._nil);
		}
		else if (z.getKey().compareTo(y.getKey())<0)
			y._left=z;
		else 
			y._right=z;
		z._left=tree._nil;
		z._right=tree._nil;
		z.setColor(Node.Colors.RED);

		addFixUp(this ,z);
	}
	
	/**
	 * delete a node from this tree (copy from the book (pg. 242) changes are commented)
	 * @param tree the tree to delete from
	 * @param z the node to delete
	 */
	protected void delete(RBTree tree, Node z) {

		Node y, x; //changed from book to match java language 
		
		if(z._left == tree.getNil() || z._right == tree.getNil())
			y = z;
		else
			y = treeSuccessor(tree, z);

		
		if(y._left != tree.getNil())
			x = y._left;
		else
			x = y._right;

		x.setParent(y.getParent());

		if(y.getParent() == tree.getNil())
			tree.setRoot(x);
		else{
			if(y== y.getParent()._left)
				y.getParent()._left = x;
			else
				y.getParent()._right = x;
		}

		if(y != z){
			z.copyData(y); //changed from key[z] <- key[y] to account for other satellite data
		}
		if(y._color == Node.Colors.BLACK)
			deleteFixup(tree, x) ;
		

	}

	//fix the tree after delete operation (pg. 243)
	private void deleteFixup(RBTree tree, Node x) {
		Node w;
		while (x != _nil && x.getColor() == Node.Colors.BLACK){
			if (x == x.getParent()._left){
				w = x.getParent()._right;
				if (w.getColor() == Node.Colors.RED){
					w.setColor(Node.Colors.BLACK);
					x.getParent().setColor(Node.Colors.RED);
					leftRotate(tree, x.getParent());
					w = x.getParent()._right;
				}
				if ( w._left.getColor() == Node.Colors.BLACK && w._right.getColor() == Node.Colors.BLACK){
					w.setColor(Node.Colors.RED);
					x = x.getParent();
				}
				else{
					if (w._right.getColor() == Node.Colors.BLACK){
						w._left.setColor(Node.Colors.BLACK);
						w.setColor(Node.Colors.RED);
						rightRotate(tree, w);
						w = x.getParent()._right;
					}
					w.setColor(x.getParent().getColor());
					x.getParent().setColor(Node.Colors.BLACK);
					w._right.setColor(Node.Colors.BLACK);
					leftRotate(tree, x.getParent());
					x = _root;
				}
			}//end if
			else{
				w = x.getParent()._left;
				if (w.getColor() == Node.Colors.RED){
					w.setColor(Node.Colors.BLACK);
					x.getParent().setColor(Node.Colors.RED);
					rightRotate(tree, x.getParent());
					w = x.getParent()._left;
				}
				if ( w._right.getColor() == Node.Colors.BLACK && w._left.getColor() == Node.Colors.BLACK){
					w.setColor(Node.Colors.RED);
					x = x.getParent();
				}
				else{
					if (w._left.getColor() == Node.Colors.BLACK){
						w._right.setColor(Node.Colors.BLACK);
						w.setColor(Node.Colors.RED);
						leftRotate(tree, w);
						w = x.getParent()._left;
					}
					w.setColor(x.getParent().getColor());
					x.getParent().setColor(Node.Colors.BLACK);
					w._left.setColor(Node.Colors.BLACK);
					rightRotate(tree, x.getParent());
					x = _root;
				}
			}
		}//End while
	}

	//
	private Node treeSuccessor(RBTree tree, Node x) {
		Node y;

		if(x._right != tree._nil)
			return treeMinimum(tree, x._right);
		else{
			y = x.getParent();

			while(y != tree.getNil() && x == y._right){
				x = y;
				y = y.getParent();
			}
			return y;
		}
	}

	//return the minimum of the tree (pg. 217)
	private Node treeMinimum(RBTree tree, Node root) {
		Node y = root;
		
		while(y._left != tree.getNil())
			y = y._left;
		return y;
	}

	// fix the tree after insertion of a node (pg. 236)
	private void addFixUp(RBTree tree, Node z) {
		Node y;

		while (z.getParent().getColor() == Node.Colors.RED){

			if(z.getParent() == z.getParent().getParent()._left){
				y = z.getParent().getParent()._right;
				if(y.getColor() == Node.Colors.RED){
					z.getParent().setColor(Node.Colors.BLACK);
					y.setColor(Node.Colors.BLACK);
					z.getParent().getParent().setColor(Node.Colors.RED);
					z = z.getParent().getParent();
				}
				else{
					if(z == z.getParent()._right){
						z = z.getParent();
						leftRotate(tree, z);
					}
					z.getParent().setColor(Node.Colors.BLACK);
					z.getParent().getParent().setColor(Node.Colors.RED);
					rightRotate(tree, z.getParent().getParent());
				}
			}//end if

			else{
				y = z.getParent().getParent()._left;
				if(y.getColor() == Node.Colors.RED){
					z.getParent().setColor(Node.Colors.BLACK);
					y.setColor(Node.Colors.BLACK);
					z.getParent().getParent().setColor(Node.Colors.RED);
					z = z.getParent().getParent();
				}
				else{ 
					if(z == z.getParent()._left){
						z = z.getParent();
						rightRotate(tree, z);
					}
					z.getParent().setColor(Node.Colors.BLACK);
					z.getParent().getParent().setColor(Node.Colors.RED);
					leftRotate(tree, z.getParent().getParent());	
				}
			}//end else
		}//end while

		tree._root.setColor(Node.Colors.BLACK);
	}

	//used in insert/delete node (pg. 234)
	private void rightRotate(RBTree tree, Node x) {

		Node y =  x._left;
				
		x._left=y._right; 
		if(y._right != tree._nil)
			y._right.setParent(x);

		y.setParent(x.getParent());
		if(x.getParent() == tree._nil)
			tree.setRoot(y);
		else if(x == x.getParent()._right)
			x.getParent()._right = y;
		else 
			x.getParent()._left = y;
		y._right = x;
		x.setParent(y);

	}

	//used in insert/delete node (pg. 234)
	private void leftRotate(RBTree tree, Node x) {
		
		Node y = x._right;

		x._right = y._left; 
		if(y._left != tree._nil)
			y._left.setParent(x);

		y.setParent(x.getParent());
		if(x.getParent() == tree._nil)
			tree.setRoot(y);
		else if(x == x.getParent()._left)
			x.getParent()._left = y;
		else 
			x.getParent()._right = y;
		y._left = x;
		x.setParent(y);
	}

	//GETTERS
	/** @return the nil[Tree] */
	public Node getNil() {
		return _nil;
	}

	/** @return the root[Tree] */
	public Node getRoot() {
		return _root;
	}
	
	//SETTERS
	/**
	 * set a new sentinel to act as nil[Tree]
	 * @param nil the node to act as new sentinel
	 */
	public void setNil(Node nil) {
		_nil = nil;
	}

	/**
	 * set a new root[Tree]
	 * @param root the node to act as the new root[Tree]
	 */	
	public void setRoot(Node root) {
		_root = root;
	}
}

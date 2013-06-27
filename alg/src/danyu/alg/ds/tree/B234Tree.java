package danyu.alg.ds.tree;

public class B234Tree extends RBTree {

	@Override
	public BSNode insert(BSNode node, BSNode newP){
	
		if(node==null){
			node=newP;
			return node;
		}
		
		if(isRed(node.leftChild) && isRed(node.rightChild))
			swapColor(node);
		
		insertNode(node,newP);
			
		if(isRed(node.rightChild) && ! isRed(node.leftChild))	
			node=rotateLeft(node);
		
		if(isRed(node.leftChild) && isRed(node.leftChild.leftChild))
			node=rotateRight(node);	
				
		return node;
	}
	
	@Override
	public String toString() {return "2-3-4 Tree";}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

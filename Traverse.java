
public class Traverse {
	public static void traverseData(TreeSub tree){  //inorder traverse.
		System.out.print(tree.data+"  ");
		
		for(int count=0;count<tree.list.size();count++){
			traverseData(tree.list.get(count));
		}
	}
}

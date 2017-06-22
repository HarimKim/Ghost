package tree;

import java.util.Scanner;
import java.util.ArrayList;

public class Tree {
	public static void traverseData(Node tree){  //in order traverse.
		System.out.print(tree.data+"  ");
		
		for(int count=0;count<tree.list.size();count++){
			traverseData(tree.list.get(count));
		}
	}
	
	public static boolean searchData(int keyData, Node root){
		boolean dataIs = false;
		
		for(int count = 0;root.list.size()>count ;count++){
			if(root.list.get(count).data==keyData){
				dataIs = true;
				return dataIs;
			}
			else{
				dataIs=searchData(keyData,root.list.get(count));
				if(dataIs==true) break;
			}
		}
		return dataIs;
	}
	
	public static void searchDemo(Node root){
		boolean input;
		int keyData;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Input the key for the Search. : ");
		keyData = scan.nextInt();
		System.out.println("==========================================================");
		
		input = searchData(keyData,root);
		
		if(input==true){
			System.out.println("There is the key you inputted in the Tree.");
			System.out.println("==========================================================");
		}
		else{
			System.out.println("There is not the key you inputted in the Tree.");
			System.out.println("==========================================================");
		}
	}
	public static void deleteData(int keyData, Node tree){
		ArrayList<Node> tempList = new ArrayList<>();
		
		if(Tree.searchData(keyData, tree)==true){
		
			for(int count = 0;tree.list.size()>count ;count++){
				if(tree.list.get(count).data==keyData){
					System.out.println("<Notice>the Node is deleted and replaced with first child. The rest childs become childs of first child.");
					System.out.println("==========================================================");
					tempList = tree.list.get(count).list; //save the child of Node.
					if(tempList.size()==0){	
						tree.list.remove(count);
					}
					else{
						tree.list.set(count, tempList.get(0)); //put the first child to the deleted node.
						if(tempList.size()>1){ 
							for(int subCount = 1;subCount<tempList.size();subCount++){ //the rest childs become childs of first child.
								tree.list.add(tempList.get(subCount));
							}
						}
					}
				}
				else{
					deleteData(keyData,tree.list.get(count));
				}
			}
		}
		else
			return;
	
	}
	public static void deleteDemo(Node tree){
		int keyData;
		Scanner scan = new Scanner(System.in);
			
		System.out.print("Input the key for the Delete.: ");
		keyData = scan.nextInt();
		System.out.println("==========================================================");
		if(Tree.searchData(keyData, tree)==false){
			System.out.println("<Warning>There is not the key you inputted in the Tree.");
			System.out.println("==========================================================");
			return;
		}
		deleteData(keyData,tree);
	}
	
	public static boolean insert(int key, Node keyNode, Node tree){  
		boolean isInsert = false;
		
		if(tree.data==key){   //the case user wants input the data under the root. 
			tree.list.add(keyNode);
			System.out.println("Complete.");
			System.out.println("==========================================================");
			isInsert = true;
			return isInsert;
		}
		else{
			for(int count=0;count<tree.list.size();count++){
				if(tree.list.get(count).data==key){
					tree.list.get(count).list.add(keyNode);
					System.out.println("Complete.");
					System.out.println("==========================================================");
					isInsert = true;
					return isInsert;
				}
				else
				{
					isInsert = Tree.insert(key, keyNode, tree.list.get(count));
					if(isInsert == true) break;
				}
			}
			return isInsert;
		}
	}
	
	public static void insertDemo(int key, Node tree){
		Node keyNode = new Node();
		Scanner scan = new Scanner(System.in);
		int keyData;
		keyNode.data=key;
		
		System.out.print("Where do you want to make child?(key of begining root is '0'.) Please input the key : ");
		keyData = scan.nextInt();
		System.out.println("==========================================================");
		
		if(tree.data!=0&&Tree.searchData(keyData, tree)==false){
			System.out.println("<Warning>There is not the key you inputted in the Tree.");
			System.out.println("==========================================================");
			return;
		}
		else{
			Tree.insert(keyData,keyNode,tree);
		}
	}
}

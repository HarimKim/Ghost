import java.util.Scanner;
import java.util.ArrayList;
public class Delete {
	public static void deleteData(int keyData, TreeSub tree){
		ArrayList<TreeSub> tempList = new ArrayList<>();
		
		if(Search.searchData(keyData, tree)==true){
		
			for(int count = 0;tree.list.size()>count ;count++){
				if(tree.list.get(count).data==keyData){
					System.out.println("<알림>해당 Node는 삭제되고 (node의 child가 있으면)첫번째 child로 대체 됩니다. 나머지 child는 첫번째 child의 child가 됩니다.");
					System.out.println("==========================================================");
					tempList = tree.list.get(count).list; //해당 node의 child저장.
					if(tempList.size()==0){	//삭제하는 node의 child가 없으면 그냥 삭제.
						tree.list.remove(count);
					}
					else{
						tree.list.set(count, tempList.get(0)); //첫번째 child를 삭제하는 node의 자리에 넣음.
						if(tempList.size()>1){ 
							for(int subCount = 1;subCount<tempList.size();subCount++){ //삭제한 node의 나머지 child는 첫번째 child의 child가 됨.
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
	public static void deleteDemo(TreeSub tree){
		int keyData;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삭제할 데이터를 입력 해주세요 : ");
		keyData = scan.nextInt();
		System.out.println("==========================================================");
		if(Search.searchData(keyData, tree)==false){
			System.out.println("<경고>입력한 원소가 Tree에 존재하지 않습니다.");
			System.out.println("==========================================================");
			return;
		}
		deleteData(keyData,tree);
	}
}

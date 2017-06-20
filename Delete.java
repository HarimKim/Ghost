import java.util.Scanner;
import java.util.ArrayList;
public class Delete {
	public static void deleteData(int keyData, TreeSub tree){
		ArrayList<TreeSub> tempList = new ArrayList<>();
		
		if(Search.searchData(keyData, tree)==true){
		
			for(int count = 0;tree.list.size()>count ;count++){
				if(tree.list.get(count).data==keyData){
					System.out.println("<�˸�>�ش� Node�� �����ǰ� (node�� child�� ������)ù��° child�� ��ü �˴ϴ�. ������ child�� ù��° child�� child�� �˴ϴ�.");
					System.out.println("==========================================================");
					tempList = tree.list.get(count).list; //�ش� node�� child����.
					if(tempList.size()==0){	//�����ϴ� node�� child�� ������ �׳� ����.
						tree.list.remove(count);
					}
					else{
						tree.list.set(count, tempList.get(0)); //ù��° child�� �����ϴ� node�� �ڸ��� ����.
						if(tempList.size()>1){ 
							for(int subCount = 1;subCount<tempList.size();subCount++){ //������ node�� ������ child�� ù��° child�� child�� ��.
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
		
		System.out.print("������ �����͸� �Է� ���ּ��� : ");
		keyData = scan.nextInt();
		System.out.println("==========================================================");
		if(Search.searchData(keyData, tree)==false){
			System.out.println("<���>�Է��� ���Ұ� Tree�� �������� �ʽ��ϴ�.");
			System.out.println("==========================================================");
			return;
		}
		deleteData(keyData,tree);
	}
}

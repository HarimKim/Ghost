import java.util.Scanner;
public class Search {
	public static boolean searchData(int keyData, TreeSub root){
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
	public static void searchDemo(TreeSub root){
		boolean input;
		int keyData;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("ã���� �ϴ� ���� �Է��� �ּ���. : ");
		keyData = scan.nextInt();
		System.out.println("==========================================================");
		
		input = searchData(keyData,root);
		
		if(input==true){
			System.out.println("�Է��� �����Ͱ� Tree�ȿ� �����մϴ�.");
			System.out.println("==========================================================");
		}
		else{
			System.out.println("�Է��� �����Ͱ� Tree�ȿ� �������� �ʽ��ϴ�.");
			System.out.println("==========================================================");
		}
	}
}

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
		
		System.out.print("찾고자 하는 값을 입력해 주세요. : ");
		keyData = scan.nextInt();
		System.out.println("==========================================================");
		
		input = searchData(keyData,root);
		
		if(input==true){
			System.out.println("입력한 데이터가 Tree안에 존재합니다.");
			System.out.println("==========================================================");
		}
		else{
			System.out.println("입력한 데이터가 Tree안에 존재하지 않습니다.");
			System.out.println("==========================================================");
		}
	}
}

import java.util.Scanner;

public class addData {
	public static TreeSub addDataInSibling(int inputData, TreeSub parent){
		/*inputData = 추가할 데이터 값, parent = 해당 노드의 parent list를 가지고 있는 TreeSub*/
		TreeSub temp = new TreeSub();
		temp.data = inputData;
		
		parent.list.add(temp);
		System.out.println("<알림>값이 입력되었습니다.");
		System.out.println("==========================================================");
		
		return parent;
		
	}
	public static TreeSub addDataInChild(int inputData, TreeSub parent){
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		TreeSub temp = new TreeSub(); //입력할 데이터가 들어있는 TreeSub
		TreeSub subParent = new TreeSub(); //child에 값을 추가한 뒤 그 값의 parent를 취하는 TreeSub
		temp.data = inputData;
		int index;
		int subin;
		int subData;
		
		if(parent.list.size()==0)
		{
			System.out.println("<경고>Tree가 비어있습니다. Sibling부터 값을 넣어 주세요.");
			System.out.println("==========================================================");
			return parent;
		}
		
		System.out.print("몇번 째 parent에 child를 생성 하시겠습니까? : ");
		index = scan.nextInt();
		System.out.println("==========================================================");
		if(parent.list.size()<index){
			System.out.println("<경고>입력한 값보다 parent의 수가 적습니다.");
			System.out.println("==========================================================");
			return parent;
		}
		else{
			subParent = parent.list.get(index-1); //index는 0부터 시작하니까.
			subParent = addData.addDataInSibling(inputData,subParent); //child에 값을 집어 넣음.
			do{
				System.out.println("이 child에 대해 수행할 작업을 선택해 주세요.\n");
				System.out.println("1)이 child에 대해 Sibling추가");
				System.out.println("2)이 child에 대해 Child추가");
				System.out.println("3)이 child에 대해 수행할 작업이 없습니다");
				System.out.print("                               입력: ");
				subin=scan.nextInt();
				System.out.println("==========================================================");
				if (subin>3||subin<1)
				{
					System.out.println("<경고>선택지 내의 번호를 입력해 주세요.");
					System.out.println("==========================================================");
					subin=4; //한번 더 루프 돌게 함.
				}
				switch(subin){
				case 1 : {System.out.print("추가할 데이터를 입력해 주세요 : ");
				subData = scan2.nextInt();
				System.out.println("==========================================================");
				subParent = addData.addDataInSibling(subData,subParent);
				break;}
				case 2 : {System.out.print("추가할 데이터를 입력해 주세요 : ");
				subData = scan2.nextInt();
				System.out.println("==========================================================");
				subParent = addDataInChild(subData,subParent);
				break;}
				case 3 : System.out.println("<알림>이 sub tree에 대한 입력이 끝났습니다. 다른 sub tree에 대한 작업을 수행하기 위해 돌아갑니다.");
				System.out.println("==========================================================");
				default : break;
				}
			}while(subin!=3);
			
			parent.list.set(index-1,subParent);
			return parent;
			
		}
	}
}

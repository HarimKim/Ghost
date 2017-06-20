import java.util.ArrayList;
import java.util.Scanner;
/*child 개수에 제한이 없고 형식이 주어지지 않은 tree*/

public class TreeMain {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		TreeSub tree = new TreeSub(); //root의 parent노드를 저장해 둠. data = 0, 사실상 모든 sub tree의 root에 해당.
		tree.data = 0;
		int input;
		int inputData;
		
		do{		
			System.out.println("수행할 작업을 선택 해주세요.\n");
			System.out.println("1)Sibling에 데이터 추가");
			System.out.println("2)Child에 데이터 추가");
			System.out.println("3)Traverse");
			System.out.println("4)Search");
			System.out.println("5)Delete");
			System.out.println("6)종료");
			System.out.print("                              입력 : ");
			input = scan.nextInt();
			System.out.println("==========================================================");
			
			if(input<1||input>6){
				System.out.println("<경고>선택지 내에서 선택 해주세요.");
				System.out.println("==========================================================");
				input=7;
			}
			switch(input){
			case 1 : {System.out.print("추가할 데이터를 입력해 주세요 : ");
			inputData = scan2.nextInt();
			System.out.println("==========================================================");
			tree=addData.addDataInSibling(inputData,tree);
			break;}
			case 2 :{System.out.print("추가할 데이터를 입력해 주세요 : ");
			inputData = scan2.nextInt();
			System.out.println("==========================================================");
			tree=addData.addDataInChild(inputData,tree);
			break;}
			case 3 :Traverse.traverseData(tree); break;
			case 4 : Search.searchDemo(tree); break;
			case 5 : Delete.deleteDemo(tree); break;
			case 6 : break;
			default : break;
			}
		}while(input!=6);
		
		System.out.println("<알림>프로그램을 종료합니다.");
		System.out.println("옜");
	}
	
}

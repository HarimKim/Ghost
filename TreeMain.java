import java.util.ArrayList;
import java.util.Scanner;
/*child ������ ������ ���� ������ �־����� ���� tree*/

public class TreeMain {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		TreeSub tree = new TreeSub(); //root�� parent��带 ������ ��. data = 0, ��ǻ� ��� sub tree�� root�� �ش�.
		tree.data = 0;
		int input;
		int inputData;
		
		do{		
			System.out.println("������ �۾��� ���� ���ּ���.\n");
			System.out.println("1)Sibling�� ������ �߰�");
			System.out.println("2)Child�� ������ �߰�");
			System.out.println("3)Traverse");
			System.out.println("4)Search");
			System.out.println("5)Delete");
			System.out.println("6)����");
			System.out.print("                              �Է� : ");
			input = scan.nextInt();
			System.out.println("==========================================================");
			
			if(input<1||input>6){
				System.out.println("<���>������ ������ ���� ���ּ���.");
				System.out.println("==========================================================");
				input=7;
			}
			switch(input){
			case 1 : {System.out.print("�߰��� �����͸� �Է��� �ּ��� : ");
			inputData = scan2.nextInt();
			System.out.println("==========================================================");
			tree=addData.addDataInSibling(inputData,tree);
			break;}
			case 2 :{System.out.print("�߰��� �����͸� �Է��� �ּ��� : ");
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
		
		System.out.println("<�˸�>���α׷��� �����մϴ�.");
		System.out.println("��");
	}
	
}

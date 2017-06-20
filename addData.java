import java.util.Scanner;

public class addData {
	public static TreeSub addDataInSibling(int inputData, TreeSub parent){
		/*inputData = �߰��� ������ ��, parent = �ش� ����� parent list�� ������ �ִ� TreeSub*/
		TreeSub temp = new TreeSub();
		temp.data = inputData;
		
		parent.list.add(temp);
		System.out.println("<�˸�>���� �ԷµǾ����ϴ�.");
		System.out.println("==========================================================");
		
		return parent;
		
	}
	public static TreeSub addDataInChild(int inputData, TreeSub parent){
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		TreeSub temp = new TreeSub(); //�Է��� �����Ͱ� ����ִ� TreeSub
		TreeSub subParent = new TreeSub(); //child�� ���� �߰��� �� �� ���� parent�� ���ϴ� TreeSub
		temp.data = inputData;
		int index;
		int subin;
		int subData;
		
		if(parent.list.size()==0)
		{
			System.out.println("<���>Tree�� ����ֽ��ϴ�. Sibling���� ���� �־� �ּ���.");
			System.out.println("==========================================================");
			return parent;
		}
		
		System.out.print("��� ° parent�� child�� ���� �Ͻðڽ��ϱ�? : ");
		index = scan.nextInt();
		System.out.println("==========================================================");
		if(parent.list.size()<index){
			System.out.println("<���>�Է��� ������ parent�� ���� �����ϴ�.");
			System.out.println("==========================================================");
			return parent;
		}
		else{
			subParent = parent.list.get(index-1); //index�� 0���� �����ϴϱ�.
			subParent = addData.addDataInSibling(inputData,subParent); //child�� ���� ���� ����.
			do{
				System.out.println("�� child�� ���� ������ �۾��� ������ �ּ���.\n");
				System.out.println("1)�� child�� ���� Sibling�߰�");
				System.out.println("2)�� child�� ���� Child�߰�");
				System.out.println("3)�� child�� ���� ������ �۾��� �����ϴ�");
				System.out.print("                               �Է�: ");
				subin=scan.nextInt();
				System.out.println("==========================================================");
				if (subin>3||subin<1)
				{
					System.out.println("<���>������ ���� ��ȣ�� �Է��� �ּ���.");
					System.out.println("==========================================================");
					subin=4; //�ѹ� �� ���� ���� ��.
				}
				switch(subin){
				case 1 : {System.out.print("�߰��� �����͸� �Է��� �ּ��� : ");
				subData = scan2.nextInt();
				System.out.println("==========================================================");
				subParent = addData.addDataInSibling(subData,subParent);
				break;}
				case 2 : {System.out.print("�߰��� �����͸� �Է��� �ּ��� : ");
				subData = scan2.nextInt();
				System.out.println("==========================================================");
				subParent = addDataInChild(subData,subParent);
				break;}
				case 3 : System.out.println("<�˸�>�� sub tree�� ���� �Է��� �������ϴ�. �ٸ� sub tree�� ���� �۾��� �����ϱ� ���� ���ư��ϴ�.");
				System.out.println("==========================================================");
				default : break;
				}
			}while(subin!=3);
			
			parent.list.set(index-1,subParent);
			return parent;
			
		}
	}
}

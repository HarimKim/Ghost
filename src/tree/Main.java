

import java.util.ArrayList;
import java.util.Scanner;
import tree.*;


public class Main {
		public static void main(String[] args)
		{
			Scanner scan = new Scanner(System.in);
			Scanner scan2 = new Scanner(System.in);
			Node tree = new Node(); //root, data = 0, root of all sub tree.
			tree.data = 0;
			int input;
			int inputData;
			
			do{		
				System.out.println("Choose the option.\n");
				System.out.println("1)Insert");
				System.out.println("2)Traverse");
				System.out.println("3)Search");
				System.out.println("4)Delete");
				System.out.println("5)Exit");
				System.out.print("                              INPUT : ");
				input = scan.nextInt();
				System.out.println("==========================================================");
				
				if(input<1||input>5){
					System.out.println("<Warning>Please choose in option number.");
					System.out.println("==========================================================");
					input=6;
				}
				switch(input){
				case 1 : System.out.print("Input data for Insert : ");
				inputData = scan2.nextInt();
				System.out.println("==========================================================");
				Tree.insertDemo(inputData,tree);
				break;
				case 2 : Tree.traverseData(tree); break;
				case 3 : Tree.searchDemo(tree); break;
				case 4 : Tree.deleteDemo(tree); break;
				case 5 : break;
				default : break;
				}
			}while(input!=5);
			
			System.out.println("<Notice>Exit the program.");
		
		
	}
}

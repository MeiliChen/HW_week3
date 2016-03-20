import java.util.*;
import java.io.*;
public class Second
{
	public static void main(String[] args)
	{
		int pcount=0,opt=0;
		String[] peoples = new String[5];
	    int[] scores = new int[5];
	    
	    System.out.println("連續輸入5筆學生資料:\n");
	    
	    while(pcount < 5)
		{
	    	System.out.print("Enter student" +(pcount+1)+ "'s name:");
	        Scanner input = new Scanner(System.in);
	        peoples[pcount] = input.nextLine();
	        System.out.print("Enter student" +(pcount+1)+ "'s score:");
	        Scanner input2 = new Scanner(System.in);
	        scores[pcount++] = input2.nextInt();
		}
		Vector vector = new Vector(Arrays.asList(peoples));
		LinkedList list = new LinkedList(Arrays.asList(peoples));
		System.out.println("vector="+vector);
		System.out.println("list="+list);
		HashMap hashMap = new HashMap();
		TreeMap treeMap = new TreeMap();
		for (int i=0; i<peoples.length; i++)
		{
			hashMap.put(peoples[i], scores[i]);
			treeMap.put(peoples[i], scores[i]);
		}
	//	System.out.println("hashMap="+hashMap);
	//	System.out.println("treeMap="+treeMap);	
		
		while(true)
		{
			System.out.print("1)search student's grade -1)End:");
	        Scanner option = new Scanner(System.in);
	        opt = option.nextInt();
	        if(opt == -1)
	        	break;
	        else if(opt == 1)
	        {
				System.out.print("Enter a student's name:");
		        Scanner input3 = new Scanner(System.in);
		        String[] search = new String[1];
		        search[0] = input3.nextLine();
				
				System.out.println("hashMap.get "+search[0] +" : "+ hashMap.get(search[0]));	
	        }
	        else
	        	System.out.println("Error!");
		}
	}
}

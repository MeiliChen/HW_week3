
import java.io.*;
import java.util.*;
public class Third
{
	public static void main(String[] args) throws IOException
	{
		
		String mustSplitString = "";
		HashMap hashMap = new HashMap();
		Scanner enter = new Scanner(System.in);
		Object temp=0;
		int num=0,opt=0,count=0,i=0;
		String hold="";
		FileReader fr = new FileReader("record.txt");//§Ë­¦
        BufferedReader br = new BufferedReader(fr);
        
        while (br.ready()) {
			if(i==0)//§ËKEY
			{
				hold=br.readLine();
				i=1;
			}
			else if(i==1)//§Ëvalue
			{
				i=0;
				hashMap.put(hold,br.readLine());//”Z KEY,value
			}
        }
        fr.close();
        
        while(true)
        {
        	System.out.print("1)¿é¤J 2)¦L¥X¨ÃÀx¦s -1)Exit:");
        	opt = Integer.parseInt(enter.nextLine());
        	
        	if(opt==1)
			{
				FileWriter fw = new FileWriter("record.txt");
				System.out.println("¿é¤J:");
				mustSplitString = (enter.nextLine()).toLowerCase();
				String[] after = mustSplitString.split("[,;\\.\\\\ ////\\*+-]+");
				System.out.println("================================================================");
				for(i=0;i<after.length;i++)
				{
					
					if(hashMap.get(after[i])==null) 
					{
						
						hashMap.put(after[i],"1");
					}
					else  
					{
						temp=hashMap.get(after[i]);  
						num=Integer.valueOf((String)temp)+1;
						hold=Integer.toString(num);
						hashMap.put(after[i],hold);
						
					}
				}
				for (Object key : hashMap.keySet())	
				{
					fw.write(key+"\n"+hashMap.get(key)+"\n");
				}
				fw.flush();
				fw.close();
			}
			else if(opt==2)
			{
				for (Object key : hashMap.keySet())
				{
					System.out.println(key + " : " + hashMap.get(key));
				}
				System.out.println("================================================================");
			}
			else if(opt==-1)
			{
				break;
			}
        }
	}
}
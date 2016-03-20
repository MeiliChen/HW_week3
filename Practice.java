import java.io.*;
import java.util.*;
public class Practice
{
	public static void main(String[] args)
	{
        int opt,count=0,resultCount=0,i,j,k;
        String []put = new String[100]; //存放每次輸入的字串
        String []after = new String[100]; //存放分解過後的字串
  
        while(true)
        {
            System.out.print("1)input string 2)output & sort -1)End:");
            Scanner option = new Scanner(System.in);
            opt = option.nextInt();
            ArrayList<String> result = new ArrayList<String>();    //arraylist result 
            if(opt == -1)
                break;
            else if(opt == 1)
            {
                System.out.print("Enter a string:");
                Scanner input = new Scanner(System.in);
                put[count++] = input.nextLine().toLowerCase(); 
            }
            else if(opt == 2)
            {
                int flag=0;
                for(i = 0 ; i < count ; i++)
                {
                	after = put[i].split("[\n|\t|\\,|\\.|\\!|\\?|\\s]+");
                    for(j = 0; j<after.length;j++)
                    {
                    	if(after[j].matches("[a-z]+") == true) //判斷是否全部都為英文字母
                    	{
                    		if(resultCount == 0) //第一筆先存入
                    		{
                    			result.add(after[j]);
                    			resultCount++;
                    		}
                    		else //判斷重複
                    		{
                    			flag=0;
                    			for(k=0;k<resultCount;k++)
                    			{
                    				if(after[j].equals(result.get(k)) == true)
                    				{
                    					flag = 1;
                    					break;
                    				}
                    			}
                    			if(flag == 0)
                    			{
                    				result.add(after[j]);
                    				resultCount++;
                    			}
                    		}
                    	}
                    	if(after[j].matches("[0-9]+") == true) //判斷是否全部都為數字，是的話相加後印出
                    	{
                    		int sum=0,t=0;
                    			t = Integer.valueOf(after[j]);
                    			while(t / 10 > 0)
                    			{
                    				sum += t % 10;
                    				t /= 10;
                    			}
                    			sum += t;
                    		System.out.println(sum);
                    	}
                    }
                }
                Collections.sort(result);
                System.out.println(result);
            }
            else
                continue;
            System.out.println("");
        }
	}
}

import java.io.*;
import java.util.*;
public class Practice
{
	public static void main(String[] args)
	{
        int opt,count=0,resultCount=0,i,j,k;
        String []put = new String[100]; //�s��C����J���r��
        String []after = new String[100]; //�s����ѹL�᪺�r��
  
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
                    	if(after[j].matches("[a-z]+") == true) //�P�_�O�_���������^��r��
                    	{
                    		if(resultCount == 0) //�Ĥ@�����s�J
                    		{
                    			result.add(after[j]);
                    			resultCount++;
                    		}
                    		else //�P�_����
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
                    	if(after[j].matches("[0-9]+") == true) //�P�_�O�_���������Ʀr�A�O���ܬۥ[��L�X
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

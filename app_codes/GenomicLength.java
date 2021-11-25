package Codes;

import java.io.FileReader;

//
//import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class GenomicLength 
{
	public double count1=0,count2=0,count3=0,count4=0,total=0;
	public double[] array=new double[5];
	public GenomicLength(String name)
	{
	
    FileReader inputStream = null;
    try 
    {
        inputStream = new FileReader(name);
        //outputStream = new FileWriter("charactero.txt");
        int c;
        while ((c = inputStream.read()) != -1) 
        {
              
        	if(c=='G')
        		count1++;
        	else if(c=='C')
        		count2++;
        	else if(c=='A')
        		count3++;
        	else if(c=='T')
        		count4++;
        	else
        		break;
        	
        }
        
        total=count2+count1+count3+count4;
        //System.out.println("Total length="+ total);
        array[0]=(count3*100+0.0)/total;
        array[1]=(count1*100+0.0)/total;
        array[2]=(count2*100+0.0)/total;
        array[3]=(count4*100+0.0)/total;
        array[4]=total;

        }
        catch(IOException e)
        {
        	//System.out.println("IOException occurred");
        	System.exit(0);
        }


	}
	
	public double[] getGL()
	{
		//System.out.println(Arrays.toString(array));
		return array;
	}
	//MAIN Function
    public static void main(String[] args) throws IOException 
    {
    	//double arr[] = Function("C:/Users/Shreya Johri/Documents/vc.txt");
    	//System.out.println(Arrays.toString(arr));
    
    }
        
}



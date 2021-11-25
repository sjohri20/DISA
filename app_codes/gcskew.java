package Codes;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class gcskew 
{
	public double[] finalarr ;
	
	public gcskew(String name, int  ws, int ss, int gl)
	{
		InputStream is = null; 
	      FilterInputStream fis = null;
	      int i = 0;
	      int p=0,k=0,l=0,j=0,count1=0,count2=0;
	   
	      char c;
	      int a=0, s=0;
	      int windows=(int)(((gl-ws)/ss)+1);
	      //int n;
	      double calc;
	      byte[] buffer = new byte[ws];
	      double arr[]=new double[windows];
	      //System.out.println(name);
			//System.out.println(ws);
			//System.out.println(ss);
			//System.out.println(gl);
	      
	      try 
	      {
	         // create input streams
	         is = new FileInputStream(name);
	         fis = new BufferedInputStream(is);
	         for(p=0;p<windows;p++)
	         {
	        	//System.out.println("we have performed the reset!");	 
	         // returns number of bytes read to buffer
	         i = fis.read(buffer, 0,ss);
	         fis.mark(ws);
	         k=fis.read(buffer,ss,ws-ss);
	         // prints
	         //System.out.println("Number of bytes read: "+i);
	         for(j=0;j<ws;j++)
	         {
	       	  //System.out.println("the array= " + (char)buffer[j]);
	       	  if((char)buffer[j]=='C')
	       		  count1++;
	       	  if((char)buffer[j]=='G')
	       		  count2++;
	         }
	         calc = (count1-count2+0.0)/(count1+count2);
	         //System.out.println("The value=" + calc);
	         arr[s]=calc;
	         //HERE,WE ARE STORING VALUES IN AN ARRAY arr
	         s++;
	         fis.reset();
	      //   System.out.println("we have performed the reset!");
	         count2=0;
	         count1=0;
	         }
	         // for each byte in buffer
	       /*  for(byte b:buffer) {
	         
	            // converts byte to character
	            c = (char)b;
	            
	            // if byte is null
	            if(b == 0)
	               c = '-';
	            // prints
	            System.out.println("Char read from buffer b: "+c);
	          //  System.out.println("Char read from buffer b: "+ buffer[1]);
	         } */
	        /* for(s=0;s<windows;s++)
	         {
	        	 //HERE, WE ARE PRINTING VALUES FROM THE ARRAY arr
	        	 System.out.println("Now we are printing from s!!"+(double)arr[s]);
	         }*/
	      } 
	      catch(IOException e) 
	      {   
	         // if any I/O error occurs
	         e.printStackTrace();
	      } 
	      finally 
	      {   
	         // releases any system resources associated with the stream
	         if(is!=null)
				try {
					is.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	         if(fis!=null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      }
	      finalarr=arr.clone();
	}
	public double[] gcskewfunction()
	{
		//System.out.println(Arrays.toString(finalarr));
		return finalarr;
	}
   public static void main(String[] args) throws Exception 
   {
      
   }
}



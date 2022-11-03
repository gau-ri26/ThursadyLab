/* Write a JAVA program which will generate the threads: - To display 10 terms of Fibonacci series. - To display 1 to 10 in reverse order. */


package Nov_03_11;

import java.io.*;

public class FibnoiccThread extends Thread
{
	public void run()  //Calling run method in another class
    {
         try     //use try block where exception show.
         {
              int a=0, b=1, c=0;
              BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

              System.out.print("Enter the Limit for fabonacci: ");

              int n = Integer.parseInt(br.readLine());
              
              System.out.println("Fibonacci series:");
              while (n>0)
              {
                   System.out.print(c+" ");
                   a=b;
                   b=c;
                   c=a+b;
                   n=n-1;
              }
         }
         catch (Exception ex)     //catch block to handle the exception.....
         {
              ex.printStackTrace();    //Printing the exception....
         }
    }
}

package Nov_03_11;

public class ReverseThread extends Thread
{
	public void run()   //Calling run method in another class
    {
         try                        //use try block where exception show.
         {
              
              System.out.println("\n Reverse is: ");
              
              for (int i=10; i >= 1 ;i-- )
              {
                   System.out.print(i+"  ");
              }
              
         }
         catch (Exception ex)			//catch block to handle the exception.....
         {
              ex.printStackTrace();			//Printing the exception....
         }
    }
}

package Nov_03_11;

public class MainThreadQ2 
{  
  //main method
	public static void main(String[] args)
    {
         try      		 	//use try block where exception show.
         {
              FibnoiccThread fib = new FibnoiccThread();
              fib.start();            // calling the run method
              fib.sleep(5000);         //sleeping thread for 5sec
              ReverseThread rev = new ReverseThread();
              rev.start();          // calling the run method
         }
         catch (Exception ex) 		//catch block to handle the exception.....
         {
              ex.printStackTrace();		//Printing the exception....
         }
    }
}


/* Write a program that creates 2 threads - each displaying a message (Pass the message as a parameter to the constructor). 
 * The threads should display the messages continuously till the user presses any key.*/
 
 
 package Nov_03_11;

class Question1 extends Thread
{
	   String str; //global variable
	    public Question1(String string)
	    {
		// TODO Auto-generated constructor stub
	    }
	    
		public void MyThread(String s)
	    {
	        str=s;  
	    }
	    public void run() //Calling run method in another class
	    {
	        while(true)
	        {   System.out.println((Thread.currentThread()).getName()+" "+"Message: "+str); //Prints Message
	            System.out.println((Thread.currentThread()).getName()+" "+"Priority:  "+(Thread.currentThread()).getPriority()); //printing
	             
	            try
	            {
	                Thread.sleep(2000); //sleeping thread for 2sec
	            }
	            catch(Exception ex)
	            { 
	                System.out.println(ex.toString());
	            }           
	        }
	    }
}

public class Q1 extends Thread
{
	 public static void main(String args[])
	    {
	        Question1 t1= new Question1("Activate");         //passing args to the constructor
	        Question1 t2= new Question1("Deactivate");       //passing args to the constructor
	        System.out.println("Threads Output.. "); 
	        t1.start();         //calling the run method
	        t2.start();         //calling the run method
	    }
}


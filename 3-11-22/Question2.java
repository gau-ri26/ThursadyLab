/* Write a Java program using Synchronized Threads, which demonstrates Producer Consumer concept. Producer Consumer problem: The producer-consumer problem is the classical concurrency of a multi process synchronization problem. It is also known as bound-buffer problem. The problem describes two processes, the producer and the consumer, who share a common, fixed-size buffer used as a queue. The producer generates a piece of data, put it into the buffer and starts again. */

package Nov_03_11;

	
	class Shop 
	{
	      private int materials;
	      private boolean available = false;
	      public synchronized int get()			 // synchronized method to get a true or false
	      {
	            while (available == false) 			//using while loop
	            {
	                  try			//use try block where exception show.
	                  {
	                        wait();
	                  }
	                  catch (Exception ie)		 //catch block to handle the exception	
	                  {
	                	  ie.printStackTrace();
	                  }
	            }
	            available = false;
	            notifyAll();
	            return materials;
	      }
	      public synchronized void put(int value)       // synchronized method to get a true or false
	      {
	            while (available == true)				//using while loop to check condition is true
	            {
	                  try						//use try block where exception show.
	                  {
	                        wait();
	                  }
	                  catch (Exception e)				//catch block to handle the exception...
	                  {
	                        e.printStackTrace();
	                  }
	            }
	            materials = value;
	            available = true;
	            notifyAll();
	      }
	}
	class Consumer extends Thread
	{
	      private Shop Shop;
	      private int number;
	      public Consumer(Shop c, int number)
	      {
	            Shop = c;
	            this.number = number;				//using this keyword
	      }
	      public void run()    //ctreating run method
	      {
	            int value = 0;
	            for (int i = 0; i < 10; i++) 		//Using for loop
	            {
	                  value = Shop.get();
	                  System.out.println("Consumed value " + this.number+ " got: " + value);
	            }
	      }
	}
	class Producer extends Thread
	{
	      private Shop Shop;
	      private int number;

	      public Producer(Shop c, int number)
	      {
	            Shop = c;
	            this.number = number; 		//using this keyword
	      }
	      public void run()			//create run method
	      {
	            for (int i = 0; i < 10; i++)		//For loop
	            {
	                  Shop.put(i);
	                  System.out.println("Produced value " + this.number+ " put: " + i);
	                  try					 //use try block where exception show.
	                  {
	                        sleep((int)(Math.random() * 100));
	                  }
	                  catch (Exception ex)     //catch block to handle the exception...
	                  {
	                        ex.printStackTrace();
	                  }
	            }
	      }
}

public class ProducerConsumerQ3
	{
		//main method
	      public static void main(String[] args)
	      {
	            Shop c = new Shop();
	            Producer p1 = new Producer(c, 1);    	//passing args to the constructor
	            Consumer c1 = new Consumer(c, 1);		//passing args to the constructor
	            p1.start();    //calling the run method
	            c1.start();    // calling the run method
	      }
	}





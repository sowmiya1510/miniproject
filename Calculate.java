package Com.Teleapps.MiniPRoject.StockManagement;

import java.awt.HeadlessException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

   public class Calculate   
   {
    static String input;
    static double numberOfShares;
    static double purchasePrice;
    static double purchaseCommission;
    static double salesPrice;
    static double salesCommission;
    static double profit;
    static double amount;
    static String stock;
	static double currentbalance;
    static DecimalFormat df = new DecimalFormat("0.00");
    
    static int AccountBalance=2000; 
    static double Fund=2000;
    static int count=1;
    static Map<String,Integer> stocks=new HashMap<String,Integer>();
	   
    
	static void Choose()
	{
		  stocks.put("Gold", 3000);
		  stocks.put("Silver",2000);
		  stocks.put("Platinum",2000);
		  stocks.put("Watch", 2000);
          stocks.put("Electronics",1000);
		  stocks.put("Dress", 1000);
		  
	 input = JOptionPane.showInputDialog("Enter the Product Stock you want to purchase?");
	        stock = String.valueOf(input);
	    	
	         if(stocks.containsKey(stock))
	         {
	        	buy();
	         }
	         else if(stock.isBlank())
	         {
		       JOptionPane.showMessageDialog(null,"Stock name is Blank", "Stock Not Found", JOptionPane.INFORMATION_MESSAGE);
		     
		       System.exit(0);

	         }
	        else
	         {
	        	JOptionPane.showMessageDialog(null,"Invalid Stock name", "Stock Not Found", JOptionPane.INFORMATION_MESSAGE);
	        	
	        	System.exit(0);
	         }
	         
	         
	         }
    
	  

          public  static void buy() throws HeadlessException, NumberFormatException
             {
        	  	input = JOptionPane.showInputDialog("How many shares did you purchase?");
        	  		numberOfShares = Double.parseDouble(input);
     
        	  			if(numberOfShares<=stocks.get(stock))
        	  			{
        	  			
  	  
        	  					input = JOptionPane.showInputDialog("What was the price per share?");
        	  					purchasePrice = Double.parseDouble(input);
     
        	  					Commision();
                   	
        	  			}
        	  				else
        	  				{
        	  					JOptionPane.showMessageDialog(null,"Stocks Insufficient", input, JOptionPane.INFORMATION_MESSAGE);
        	  					System.exit(0);
        	  				}		
        	  	}    
   
             
    
      static void Commision()
      {
        
         input = JOptionPane.showInputDialog("What was the purchase commission fee?");
         purchaseCommission = Double.parseDouble(input);
         amount=(numberOfShares*purchasePrice)+purchaseCommission;
     
                                 if(amount<=AccountBalance)
                                  {
                                	   AccountBalance-=amount;
                                       JOptionPane.showMessageDialog(null, "Your Account Balance Rs." + df.format(AccountBalance), "Stock Profit App", JOptionPane.INFORMATION_MESSAGE);
                                       
                                       input = JOptionPane.showInputDialog("Do You Want to  sell");
                           	           String Choice = String.valueOf(input);
                           	        
                           	        if(Choice.equalsIgnoreCase("Yes"))
                           	        {
                           	        	
                           	        	     sell();
                           	        	 	
                           	        }
                           	        else if(Choice.equalsIgnoreCase("NO"))
                           	        {
                           	        System.exit(0);	
                           	        }
                                    
                           	        
                           	        else if(Choice.isBlank())
                           	        {
                           	        	JOptionPane.showMessageDialog(null,"Choice is Blank", "Error", JOptionPane.INFORMATION_MESSAGE);
                           				  System.exit(0);
                           	        }
                           	        else if(!Choice.equalsIgnoreCase("yes") && !Choice.equalsIgnoreCase("No"))
                           	        {
                           	        	JOptionPane.showMessageDialog(null,"Choice Not Valid", "Error", JOptionPane.INFORMATION_MESSAGE);
                         				  System.exit(0);
                           	        }
                                  }
                                   else if(amount>AccountBalance)
                                    {

                        	        	JOptionPane.showMessageDialog(null,"Insufficient Balace", "Error", JOptionPane.INFORMATION_MESSAGE);
                        	        	JOptionPane.showMessageDialog(null,"Enter the Purchase limit less than or Equal of Rs."+df.format(AccountBalance), "Error", JOptionPane.INFORMATION_MESSAGE);
                        	        	buy();
                                    }
                                      
        	}
         
          	static void sell()
          	{
                 
          	input = JOptionPane.showInputDialog("How much did you sell each share for?");
          	salesPrice = Double.parseDouble(input);
         
          			input = JOptionPane.showInputDialog("What was the selling commission fee?");
          			salesCommission = Double.parseDouble(input);
         
          			profit =((numberOfShares * salesPrice) +salesCommission)-amount; 
         
        
        
          				if(profit > 0 )
          				{
          					JOptionPane.showMessageDialog(null, "Your Stock Profit  Rs." + df.format(profit), "Stock Profit App", JOptionPane.INFORMATION_MESSAGE);

          					AccountBalance+=profit;
          					JOptionPane.showMessageDialog(null, "Your Account Balance After Profit  Rs." + df.format(AccountBalance), "Stock Profit App", JOptionPane.INFORMATION_MESSAGE);

          					Choose();
          					System.exit(0);
            
          				} 
          				else if(profit<0)
          				{
          					JOptionPane.showMessageDialog(null, "Your Stock after Loss  Rs." + df.format(profit), "Stock Profit App", JOptionPane.INFORMATION_MESSAGE);

          					AccountBalance-=profit;
          					JOptionPane.showMessageDialog(null, "Your Account Balance After Loss  Rs." + df.format(AccountBalance), "Stock Profit App", JOptionPane.INFORMATION_MESSAGE);
	                        if(AccountBalance<0)    
	                        {
	                        	Accoutstatus();
	                        	
	                        }
	                        else
	                        {
	                        	Choose();
	                        	System.exit(0);
	                        }
          				}
        
                }
      
       
      static void Accoutstatus()
      {
    
    	  
    	   if(AccountBalance>0 && count==1)
          {
            JOptionPane.showMessageDialog(null, "Low Balance Rs." + df.format(AccountBalance), "Stock Profit App", JOptionPane.INFORMATION_MESSAGE);

          	AccountBalance+=Fund;
           
          	JOptionPane.showMessageDialog(null, "Bonus Fund Credicted Rs." + df.format(AccountBalance), "Stock Profit App", JOptionPane.INFORMATION_MESSAGE);

          	
          	count++;
       	Choose();
          }
          else if(AccountBalance>0 && count==2)
          {
              JOptionPane.showMessageDialog(null, "Insufficient Account Fund Rs." + df.format(AccountBalance), "Stock Profit App", JOptionPane.INFORMATION_MESSAGE);
              JOptionPane.showMessageDialog(null,"Thanks", "End", JOptionPane.INFORMATION_MESSAGE);
     	       System.exit(0);
           }
          
          System.exit(0);
      }
    
}

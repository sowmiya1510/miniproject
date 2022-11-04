package Com.Teleapps.MiniPRoject.StockManagement;

import javax.swing.JOptionPane;

public class Stock extends Calculate {

	public static void main(String[] args) {
         
		input = JOptionPane.showInputDialog("User Name");
        String UserName = String.valueOf(input);
        UserName(UserName);
	  }
	
	public static void UserName(String UserName)
    {
		
    String arr[]= {"Elakiya","Hari","Booma","Sowmi","Siva","sre","Keerthy","Gokul"};
    

     for (int i = 0; i < arr.length; i++) {

		if (arr[i].equalsIgnoreCase(UserName)) 
		{
			input = JOptionPane.showInputDialog("PassWord");
	        int PassWord = Integer.parseInt(input);
			Password(PassWord);
			
		} else if (i == arr.length - 1)
		{
			JOptionPane.showMessageDialog(null,"Invalid UserName", "Login", JOptionPane.INFORMATION_MESSAGE);
			 System.exit(0);
			
		}
		else if(UserName.isBlank())
		{
			JOptionPane.showMessageDialog(null,"UserName is Empty", "Login", JOptionPane.INFORMATION_MESSAGE);
			  System.exit(0);
		}
     }
     }

	public static void Password(int PassWord) {
		
		int arr[]= {101,102,103,104,105,106};
	    

	     for (int i = 0; i < arr.length; i++) {

			if (arr[i]==PassWord) 
			{
				Choose();
				
			} 
			else if (i == arr.length - 1)
			{
				JOptionPane.showMessageDialog(null,"Invalid Password", "Login", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
				
				
			}
			else if(PassWord==0)
			{
				JOptionPane.showMessageDialog(null,"UserName is Empty", "Login", JOptionPane.INFORMATION_MESSAGE);
				  System.exit(0);
			}
	     }
	}
	}
package emailAdministration;
import java.util.*;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String dept;
    private int mailboxCapacity=500;
    private String alternateEmail;
    private int defaultpasswordLength=10;
    private String email;
    private String companySuffix="aeycompany.com";
    
    //Constructor to recieve the first name and last name
    public Email(String firstName,String lastName) {
    	this.firstName=firstName;
    	this.lastName=lastName;
    	
    	//Call a method for the dept - return the dept
    	this.dept=setDept();
    	
    	//call a method that returns random password
    	this.password=randomPassword(defaultpasswordLength);
    	System.out.println("Your password is: "+this.password);
    	
    	//combine elements to generate email
    	email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+dept+"."+companySuffix;    	
    }
        
    //Ask for the department
    private String setDept() {
    	System.out.println("New Worker: "+firstName+"\nDepartment Codes\n1) for Sales\n2) for Development\n3) for Accounting\n0) for None ");
    	System.out.print("Enter Dept Code: ");
    	Scanner sc=new Scanner(System.in);
    	int deptchoice=sc.nextInt();
    	sc.close();
    	if(deptchoice==1) {return "Sales";}
    	else if(deptchoice==2) {return "Developer";}
    	else if(deptchoice==3) {return "Accouting";}
    	else if(deptchoice==0) {return "None";}
		return dept;		
    }
    
    //Generate a random password
    private String randomPassword(int length) {
    	String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$%^&*";
    	char[]password=new char[length];
    	for(int i=0;i<length;i++) {
    		int r=(int)(Math.random()*passwordSet.length());
    		password[i]=passwordSet.charAt(r);
    	}return new String(password);
    }
    
    //Set the mailbox capacity
    public void setMailCapacity(int capacity) {
    	mailboxCapacity=capacity;
    }
    
    //Set the alternate email
    public void setAlternateEmail(String altEmail) {
    	alternateEmail=altEmail;
    }
    
    //Change the password
    public void changePassword(String password) {
    	this.password=password;
    }
    
    public int getMailboxCapacity(){
    	return mailboxCapacity;
    }
    public String getAlternateEmail() {
    	return alternateEmail;
    }
    public String getPassword() {
    	return password;
    }
    public String showInfo() {
    	return "DISPLAY NAME: "+firstName+" "+lastName+
    			"\nCOMPANY EMAIL: "+email+
    			"\nMAILBOX CAPACITY: "+mailboxCapacity+"mb";
    }    
}

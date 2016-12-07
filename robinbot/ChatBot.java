import java.util.Scanner;

/**
 * Write a description of class ChatBot here.
 * 
 * @author Yashila Bordag
 * @version 0.0.01 (Nov-4-2016, last edit: 11:37AM)
 */
public class ChatBot
{
    // instance variables
    public String name;
    public String greetingStatement;

    /**
     * Constructor for objects of class ChatBot
     * @param  name   name given by user
     * @param  statement   statement given by user
     * @return     end of conversation
     */
    public String RobinBot(String name, String greetingStatement)
    {
        // Greet User
        System.out.println(greetingStatement);
        
        RobinBot robin = new RobinBot();
		
		System.out.println (robin.getGreeting(name));
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
        while (statement.toLowerCase() != "bye" || statement.toLowerCase() != "goodbye" ) {
            System.out.println(robin.getResponse(name.toLowerCase(), statement.toLowerCase()));
            statement = in.nextLine();
        }
        System.out.println("Goodbye " + name + "!");
        return null;
    }

}

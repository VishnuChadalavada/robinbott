
/**
 * Write a description of class RobinBot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RobinBot
{
    // instance variables - replace the example below with your own
    
    private String[] quietResponse = {
        "Oh no batman! I think the joker got another victim!",
        "(As you) You’re the coolest Robin! (As Himself) I know."};
        
    private String[] randomResponse = {
        "I see….",
        "What was that?",
        "Why would you say that?",
        "Uhh… Say that again?",
        "Can you repeat that?",
        "I dunno.",
        "Why’s that?",
        "You sure?",
        "Interesting…",
        "What does the Joker do in his free time? … He clowns around!",};
        
    /* 
       0 - smoke, smoking, smokes
       1 - italian, dessert, cannoli
       2 - italian, pasta, ravioli
       3 - hi, hello, greetings, hey
       4 - my name, my name is, the name
       5 - help, please save

       6 - birdbrain
       7 - pinhead
       8 - flying graysons, flying, graysons
       9-10 - mr. freeze, iceboy

       11 - cold, freezing, freeze, chilly, chill
       12 - batman, bat, bats
       13-15 - poison ivy
       16-17 - joker

       18-19 - clown
       20 - alfred, alfred pennyworth, penny, butler

       21-25 - joke
       */
    private String[] keywordResponse = {
        "Holy smokes! That’s smokin hot!", //0
        "Holy Cannoli! I love italian desserts!", //1
        "Holy Ravioli! I love pasta!", //2
        "Hi there, I am one half of the dynamic duo, Robin the wonder boy! Who are you?", //3
        "What a wonderful name!", //4
        "Have no fear, the dynamic duo is here!", //5
        
        "Who are you calling a bird brain!", //6
        "Who are you calling a pinhead!", //7
        "I don’t want to talk about that, please.", //8
        "I know him, we put him in the cooler! He had a chilly personality!", //9
        "We kicked his ice!", //10
        
        "Holy cold creeps!", //11
        "He is my best friend and my partner in justice!", //12
        "She had quite a flowery personality.", //13
        "Why doesn't Batman like taking walks in the forest? I don't like poison ivy?", // 14
        "I would say go green...", //15
        "I know the clown! He is a menace and me and batsy are here to stop him!", //16
        "The Joker? We broke his funny bone!", //17

        "Enough clowning around, the joke’s up!", //18
        "Why did the clown throw the clock out of the window? Because he wanted to see time fly!", //19
        "Wanna know why Alfred's so great. Because he earns his Penny's Worth", //20
        
        "What position did Batman play on his little-league team? He was the BATter!", //21
        "Why did Batman's date go badly? Because he has BAT breath!", //22
        "What is a Batman's favorite part of the joke? The PUNCH line!", //23
        "What does Batman put in his beverages? Just ice.", //24
        "What happens when Batman and I fight a steamroller? We become Flatman and Ribbon", //25
    };
       
    
    /**
     * Constructor for objects of class RobinBot
     */
    public RobinBot()
    {
        // initialise instance variables
        int x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  statement   the statement string
     * @param  key   the key string
     * @param  start   the start of the phrase
     * 
     * @return     the number of appearances
     */
    private int findKeyword(String statement, String key, int start)
    {
        String phrase = statement.trim();
        //  The only change to incorporate the startPos is in the line below
        int startNum = phrase.toLowerCase().indexOf(key.toLowerCase(), start);
        
        //  Refinement--make sure the key isn't part of a word 
        while (startNum >= 0) 
        {
            //  Find the string of length 1 before and after the word
            String before = " ", after = " "; 
            if (startNum > 0)
            {
                before = phrase.substring (startNum - 1, startNum).toLowerCase();
            }
            if (startNum + key.length() < phrase.length())
            {
                after = phrase.substring(startNum + key.length(), startNum + key.length() + 1).toLowerCase();
            }
            
            //  If before and after aren't letters, we've found the word
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
                    && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return startNum;
            }
            
            //  The last position didn't work, so let's find the next, if there is one.
            startNum = phrase.indexOf(key.toLowerCase(), startNum + 1);
            
        }
        
        return -1;
    }
    
    /**
     * Greeting Method, greets user with given name
     * @param  name   name given by user
     * @return     Hello (name) !
     */
     public String getGreeting(String name)
    {
        // expand code here
        return "Hello " + name + "!";
    }
    
    /**
     * Response Method, returns user with generated response
     * @param  name   name given by user
     * @param  statement   statement given by user
     * @return     RobinBot's Response to Statement
     */
     public String getResponse(String name, String statement)
    {
        // expand code here
        String response = "";
        if (statement.length() == 0)
        {
            response = quietResponse[generateRandInt(2)];
        }
        
        //smoke, smoking, smokes
        else if (findKeyword(statement, "smoke", 0) >= 0
                || findKeyword(statement, "smoking", 0) >= 0
                || findKeyword(statement, "smokes", 0) >= 0)
        {
            response = keywordResponse[0];
        }
        
        //italian, dessert, cannoli
        else if (findKeyword(statement, "italian", 0) >= 0
                || findKeyword(statement, "dessert", 0) >= 0
                || findKeyword(statement, "cannoli", 0) >= 0)
        {
            response = keywordResponse[1];
        }
        
        //pasta, ravioli
        else if (findKeyword(statement, "pasta", 0) >= 0
                || findKeyword(statement, "ravioli", 0) >= 0)
        {
            response = keywordResponse[2];
        }
        
        //hi, hello, greetings, hey
        else if (findKeyword(statement, "hi", 0) >= 0
                || findKeyword(statement, "hello", 0) >= 0
                || findKeyword(statement, "greetings", 0) >= 0
                || findKeyword(statement, "hey", 0) >= 0)
        {
            response = keywordResponse[3];
        }
        
        //my name, my name is, the name
        else if (findKeyword(statement, "my name", 0) >= 0
                || findKeyword(statement, "my name is", 0) >= 0
                || findKeyword(statement, "the name", 0) >= 0)
        {
            response = keywordResponse[4];
        }
        
        //help, please save
        else if (findKeyword(statement, "help", 0) >= 0
                || findKeyword(statement, "please save", 0) >= 0)
        {
            response = keywordResponse[5];
        }
        
        //birdbrain
        else if (findKeyword(statement, "birdbrain", 0) >= 0)
        {
            response = keywordResponse[6];
        }
        
        //pinhead
        else if (findKeyword(statement, "pinhead", 0) >= 0)
        {
            response = keywordResponse[7];
        }
        
        //flying graysons, flying, graysons
        else if (findKeyword(statement, "flying graysons", 0) >= 0
                || findKeyword(statement, "flying",0) >= 0
                || findKeyword(statement, "graysons",0) >= 0)
        {
            response = keywordResponse[8];
        }
        
        //mr. freeze, iceboy
        else if (findKeyword(statement, "mr. freeze", 0) >= 0
                || findKeyword(statement, "iceboy",0) >= 0)
        {
            response = keywordResponse[9 + generateRandInt(2)];
        }
        
        //cold, freezing, freeze, chilly, chill
        else if (findKeyword(statement, "freeze", 0) >= 0
                || findKeyword(statement, "cold",0) >= 0
                || findKeyword(statement, "freezing",0) >= 0
                || findKeyword(statement, "chilly",0) >= 0
                || findKeyword(statement, "chill",0) >= 0)
        {
            response = keywordResponse[11];
        }
        
        //batman, bat, bats
        else if (findKeyword(statement, "batman", 0) >= 0
                || findKeyword(statement, "bat",0) >= 0
                || findKeyword(statement, "bats",0) >= 0)
        {
            response = keywordResponse[12];
        }
        
        //poison ivy
        else if (findKeyword(statement, "poison ivy", 0) >= 0)
        {
            response = keywordResponse[13 + generateRandInt(3)];
        }
        
        //joker
        else if (findKeyword(statement, "joker", 0) >= 0)
        {
            response = keywordResponse[16 + generateRandInt(2)];
        }
        
        //clown
        else if (findKeyword(statement, "clown", 0) >= 0)
        {
            response = keywordResponse[18];
        }
        
        //alfred, alfred pennyworth, penny, butler
        else if (findKeyword(statement, "alfred",0) >= 0
                || findKeyword(statement, "alfred pennyworth",0) >= 0
                || findKeyword(statement, "penny",0) >= 0
                || findKeyword(statement, "butler",0) >= 0)
        {
            response = keywordResponse[20];
        }
        
        //joke
        else if (findKeyword(statement, "joke", 0) >= 0)
        {
            response = keywordResponse[21 + generateRandInt(5)];
        }

        // Responses which require transformations
        else if (findKeyword(statement, "I want to", 0) >= 0)
        {
            response = transformIWantToStatement(statement);
        }

        else
        {
            // Look for a two word (you <something> me)
            // pattern
            int startNum = findKeyword(statement, "you", 0);

            if (startNum >= 0
                    && findKeyword(statement, "me", startNum) >= 0)
            {
                response = transformYouMeStatement(statement);
            }
            else
            {
                response = getRandomResponse();
            }
        }
        return response;
    }
    
    public int generateRandInt(int length) {
        return (int)(Math.random() * (length - 1));
    }
    
    public String getRandomResponse() {
        int index = (int)(Math.random() * (9));
        return randomResponse[index];
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String transformIWantToStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int startNum = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(startNum + 9).trim();
        return "What would it mean to " + restOfStatement + "?";
    }
    
    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    private String transformYouMeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        
        int startNumOfYou = findKeyword (statement, "you", 0);
        int startNumOfMe = findKeyword (statement, "me", startNumOfYou + 3);
        
        String restOfStatement = statement.substring(startNumOfYou + 3, startNumOfMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }
    
}

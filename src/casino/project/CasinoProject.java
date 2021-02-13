
package casino.project;

import java.util.*;
public class CasinoProject {
private static Scanner input = new Scanner(System.in);
private static Random random = new Random();  
private static ArrayList<users> UserList = new ArrayList<>();
 
public static void main(String[] args) {
        mainMenu();
    }

public static void mainMenu() {
        System.out.println("welcome to the casino");
        while(true){
        System.out.println("what would you like to do?");
        System.out.println("1-register");
        System.out.println("2- view coins");
        System.out.println("3 - higher or lower");
        System.out.println("4 - slot machine");
        System.out.println("0 - exit");
        int userChoice = input.nextInt();

        switch (userChoice) {
            case 1:
                addUser();
                break;
            case 2:
                viewCoins();
                break;

            case 3:
                higherOrLower();
                break;

            case 4:
                slotMachine();
                break;

            case 0:

                System.exit(0);

        }

    }
    }
    public static void addUser() {
        
        System.out.println("please type in a name");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("you recieve 100 coins");
        int coins = 100;
     
        users newUser = new users(name,coins);
        UserList.add(newUser);

        System.out.println(newUser.toString());
    }
    public static void viewCoins() {
        if (UserList.isEmpty()) {
            System.out.println("sorry, there are no users right now");
        } else {
            for (int i = 0; i < UserList.size(); i++) {
                System.out.println(UserList.get(i).toString());
            }
        }
    }
    public static int payToPlay(){
      //System.out.println("test 1");
      int coins = getcoins();
      //System.out.println("test 2");
      if(coins!= -1){
          System.out.println("this game cost 5 coins");
          if(coins < 5){
              System.out.println("you do not have enough coins to play");
              return -1;
          }else{
              coins = coins - 5 ;
              System.out.println("your new total amount of coins is "+coins);
              UserList.get(coins).setCoins(coins);
              return 1;
          }
      }else{
          System.out.println("there has been an error please try again");
          return -1;
      }
    }
    public static int getcoins(){
      
      if (UserList.isEmpty()) {
      return -1;
      
       } else {
            System.out.println("please type in the name");
            String name = input.next();
            for (int i = 0; i < UserList.size(); i++) {
                users ListName = UserList.get(i);
                System.out.println(ListName);
                System.out.println(users.getCoins());   
                if(users.getCoins(ListName) >= 5){
                   System.out.println("sucessful");
                   return 1;
                }
                
            }
        } 
    return -1;

    }
    public static void slotMachine(){
    int play = payToPlay();
     while(play == 1){
       String playAgain = "yes";
       while(playAgain.equals("yes")){
    int bar = 0;   
    int bell = 0;  
    int plum = 0;  
    int orange = 0;
    int cherry = 0;
        for (int i = 1; i <= 3 ; i++){
        int rand = random.nextInt(5)+1;
        switch(rand){
            case 1:
                bar++;
                break;
            case 2:
                bell++;
                break;
            case 3:
                plum++;
                break;
            case 4:
                orange++;
               break;
            case 5:
                cherry++;
              break;
            
        }
        }
        System.out.println("bar "+bar+" bell "+bell+" plum "+plum+" orange "+orange+" cherry "+cherry);
        if(bar == 3){
                System.out.println("CONGRATULATIONS! YOU WIN 1000 COINS!");
                int coins = users.getCoins();
                coins = coins + 1000;
                UserList.get(coins).setCoins(coins);
                System.out.println("would you like to play again?");
                playAgain = input.next(); 
        }if(bar == 2){
                System.out.println("CONGRATULATIONS! YOU WIN 100 COINS!");
                int coins = users.getCoins();
                coins = coins + 100;
                UserList.get(coins).setCoins(coins);
                System.out.println("would you like to play again?");
                playAgain = input.next();  
        }if(bar == 1){
                System.out.println("CONGRATULATIONS! YOU WIN 10 COINS!");
                int coins = users.getCoins();
                coins = coins + 10;
                UserList.get(coins).setCoins(coins);
                System.out.println("would you like to play again?");
                playAgain = input.next(); 
        }if(bell == 3){
                System.out.println("CONGRATULATIONS! YOU WIN 100 COINS!");
                int coins = users.getCoins();
                coins = coins + 100;
                UserList.get(coins).setCoins(coins);
                System.out.println("would you like to play again?");
                playAgain = input.next(); 
        }if((plum == 3)||(orange == 3)||(cherry == 3)){
                System.out.println("CONGRATULATIONS! YOU WIN 100 COINS!");
                int coins = users.getCoins();
                coins = coins + 100;
                UserList.get(coins).setCoins(coins);
                System.out.println("would you like to play again?");
                playAgain = input.next(); 
        }else{
            System.out.println("you didnt win");
            System.out.println("would you like to play again?");
            playAgain = input.next();
        }
  

        }
     }
     
        
    }  
    public static void higherOrLower(){
            System.out.println("This games works by the computer picking a card from the deck and you have to guess if the next card is higher or lower Ace = 1");
            List<Integer>cards = new ArrayList<Integer>();
            cards.add(1); cards.add(2); cards.add(3); cards.add(4); cards.add(5); cards.add(6); cards.add(7); cards.add(8); cards.add(9); cards.add(10); cards.add(11); cards.add(12); cards.add(13); 
            //System.out.println(cards);
           int play = payToPlay();
           while(play == 1){
            String playAgain = "yes";
            while(playAgain.equals("yes")){
            System.out.println("new card");
            int randomCard1 = random.nextInt(13)+1;
            //System.out.println(randomCard1);
            if(randomCard1 == 1){
                System.out.println("Ace");
            }if(randomCard1 == 11){
                System.out.println("Jack");
            }if(randomCard1 == 12){
                System.out.println("Queen");
            }if(randomCard1 == 13){
                System.out.println("King");
            }else{
                System.out.println(randomCard1);
            }
            int randomCard2 = random.nextInt(13)+1;
            System.out.println("Higher or Lower");
            String userGuess = input.next();
            if(randomCard2 > randomCard1 && userGuess.equals("Higher")){
                System.out.println("Yes the new card was higher. 10 coins added to your account!");
                int coins = users.getCoins();
                coins = coins + 10;
                UserList.get(coins).setCoins(coins);
                System.out.println("would you like to play again?");
                playAgain = input.next();
            }if(randomCard2 > randomCard1 && userGuess.equals("Lower")){
              System.out.println("No the new card was higher. 10 coins removed from your account");
              int coins = users.getCoins();
               coins = coins - 10;
               UserList.get(coins).setCoins(coins);
               System.out.println("would you like to play again?");
               playAgain = input.next();
            }if(randomCard2 < randomCard1 && userGuess.equals("Lower")){
              System.out.println("Yes the new card was lower. 10 coins added to your account!");
                int coins = users.getCoins();
                coins = coins + 10;
                UserList.get(coins).setCoins(coins);
                System.out.println("would you like to play again?");
                playAgain = input.next();  
            }if(randomCard2 < randomCard1 && userGuess.equals("Higher")){
             System.out.println("No the new card was lower. 10 coins removed from your account");
              int coins = users.getCoins();
               coins = coins - 10;
               UserList.get(coins).setCoins(coins);
               System.out.println("would you like to play again?");
               playAgain = input.next();
            }
        }
        
    }
           System.out.println("You do not have enough coins to play this game");
    
}
}






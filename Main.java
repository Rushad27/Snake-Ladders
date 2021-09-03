import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
 
class SnakeNLadder
{
     
    final static int WINPOINT = 100;
     
     
    static Map < Integer , Integer > snake = new HashMap < Integer , Integer >();
    static Map < Integer , Integer > ladder = new HashMap< Integer , Integer >();
     
    {
        snake.put(99,54);
        snake.put(70,55);
        snake.put(52,42);
        snake.put(25,2);
        snake.put(95,72);
         
        ladder.put(6,25);
        ladder.put(11,40);
        ladder.put(60,85);
        ladder.put(46,90);
        ladder.put(17,69);
    }

public int rollDice()
{
    int n = 0;
    Random r = new Random();
    n=r.nextInt(7);
    return (n==0?1:n);
}

public int calculatePlayerValue(int player, int diceValue)
{
    player = player + diceValue;
      
    if(player > WINPOINT)
    {
        player = player - diceValue;
        return player;
    }
      
    if(null!=snake.get(player))
    {
        System.out.println("\nSWALLOWED BY SNAKE");
        player= snake.get(player);
    }
      
    if(null!=ladder.get(player))
    {
        System.out.println("\nCLIMBED UP A LADDER");
        player= ladder.get(player);
    }
    return player;
}

public boolean isWin(int player)
{
    return WINPOINT == player;
}

public void startGame()
{
    int player1 =0, player2=0;
    int currentPlayer=-1;
    Scanner scan = new Scanner(System.in);
    String str;
    int diceValue =0;
    do
    {
        System.out.println(currentPlayer==-1?"\n\nFIRST PLAYER'S TURN":"\n\nSECOND PLAYER'S TURN");
        System.out.println("Press R to roll Dice");
        str = scan.next();
        diceValue = rollDice();
          
          
        if(currentPlayer == -1)
        {
            player1 = calculatePlayerValue(player1,diceValue);
            System.out.println("First Player :: " + player1);
            System.out.println("Second Player :: " + player2);
            System.out.println("------------------");
            if(isWin(player1))
            {
                System.out.println("\nFIRST PLAYER WINS!!");
                return;
            }
        }
        else
        {
            player2 = calculatePlayerValue(player2,diceValue);
            System.out.println("First Player :: " + player1);
            System.out.println("Second Player :: " + player2);
            System.out.println("------------------");
            if(isWin(player2))
            {
                System.out.println("\nSECOND PLAYER WINS!!");
                return;
            }
        }
          
        currentPlayer= -currentPlayer;
          
          
          
    }while("R".equals(str));
}
     
}
 
public class Main {
 
    public static void main(String[] args) {
        System.out.print("\n***********************************************************\nSnake  positions: (99,54) (70,55) (52,42) (25,02) (95,72)\nLadder positions: (06,25) (11,40) (60,85) (46,90) (17,69)\nPress [R] to roll the dice.\n***********************************************************\n\n");
        SnakeNLadder s = new SnakeNLadder();
        s.startGame();
 
    }
 
}
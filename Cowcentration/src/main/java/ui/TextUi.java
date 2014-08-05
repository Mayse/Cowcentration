
package ui;

import gamelogic.Game;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author miikas
 */
public class TextUi {
    
   
    
   public static void run(){
       Scanner lukija = new Scanner(System.in);
       System.out.println("Cowcentration");
       System.out.println("How many players?");
      
       int playerCount = Integer.parseInt(lukija.nextLine());
       System.out.println("Naming players");
       List pelaajat = new ArrayList();
       for (int i = 0; i < playerCount; i++) {
           System.out.print("Name "+(i+1)+ ": ");
           pelaajat.add(lukija.nextLine());
           System.out.println("");
       }
       
       System.out.println("how many card pairs?");
       int cardCount = Integer.parseInt(lukija.nextLine());
       
       gamelogic.Game game = new Game(pelaajat, cardCount);
       
       System.out.println("game begins:");
       while (true) {
           System.out.println("current player: " + game.getCurrentPlayer());
           System.out.println("choose first card /(1-" + (cardCount*2) );
           int first = Integer.parseInt(lukija.nextLine());
           
           System.out.println("choose second card /(1-" + (cardCount*2));
           int second = Integer.parseInt(lukija.nextLine());
           
           try {
               if (game.compareCards(first, second)) {
               System.out.println("pair found");
               game.removeCard(first);
               game.removeCard(second);
               game.addPoint();
           }
           else {
               System.out.println("not a pair");
               game.nextPlayer();
           }
           } catch (Exception e) {
               System.out.println("problematic!");
           }
           if (game.gameOver()) {
               System.out.println("peli ohi");
               break;
           }
           
       }
   }
   
   }
   


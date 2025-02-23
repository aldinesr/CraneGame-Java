/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carnegametest222222;

import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
/**
 *
 * @author JustClick
 */
public class Crane {
    private BoxArea boxArea4;
    private BoxArea boxArea5;
    private SlideArea slideArea;
    private ClawStartPosition clawStartPosition;
    private double initialMoney;
    private int prizeQuantity;
    private Set<Prize> wonPrizes;
    private String playerName;
    private BoxArea boxPrixArea;
    private BoxArea boxPrincipaleArea;
    private Map<JLabel, Prize> objectPrizeMapping;
    
    public Crane(){
//        boxArea4 = new BoxArea();
//        boxArea5 = new BoxArea();
//        slideArea= new SlideArea();

        clawStartPosition = new ClawStartPosition();
        initialMoney = 0.0;
        wonPrizes = new HashSet<>();
        objectPrizeMapping = new HashMap<>();
    }
    public void setClawStartPosition(int x,int y){
        clawStartPosition.setX(x);
        clawStartPosition.setY(y);
    }
   public void startGame(double money) {
        if (money > 0) {
            initialMoney += money;
            
        } else {
            System.out.println("You have to insert a valid money$$$$$");
        }
     
    }

    public void setInitialMoney(double initialMoney) {
        this.initialMoney = initialMoney;
    }

    
     public void linkPrizeWithObject(JLabel object, Prize prize) {
        objectPrizeMapping.put(object, prize);
    }
     public Prize getPrizeForGameObject(JLabel object) {
        return objectPrizeMapping.get(object);
    }
     
    public String getPlayerName() {
        return playerName;
    }

    public void giveMoney(double money) {
        initialMoney += money;
    }
    public void setBoxArea4(BoxArea boxArea4) {
           this.boxArea4 = boxArea4;
       }

       public void setBoxArea5(BoxArea boxArea5) {
           this.boxArea5 = boxArea5;
       }
    public void generatePrizes() {
      
    }
   public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public BoxArea getBoxArea4() {
        return boxArea4;
    }

    public BoxArea getBoxArea5() {
        return boxArea5;
    }
   
    public double checkPrizes() {
        double totalValue = 0.0;
        for (Prize prize : wonPrizes) {
//            totalValue += prize.getValue();
        }
        return totalValue;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carnegametest222222;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.JLabel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 *
 * @author JustClick
 */
public class theGame extends javax.swing.JFrame {
    private boolean isFirstSpacePress = true;
    /**
     * Creates new form theGame
     */
    private Timer positionTimer;
    private String playerName;
    private int amount;
    private Crane carne;
    private BoxArea boitePrixArea;
    private BoxArea boitePrincipaleArea;
    private SlideArea slideArea;
    private Timer checkPositionTimer;
    private final int slideSpeed = 5;
    private static int endGame=0;
    private List<JLabel> prizesInsideBoitePrixArea = new ArrayList<>();

    private CraneArmMovVertical craneArmMovVertical;
    private static JLabel prizeLabel = null;
        
    private List<JLabel> prizeLabels = new ArrayList<>();
   
//   private CraneArmMov craneArmMov;
//    private CraneArmMov craneArmMovGriffe;
//    private CraneArmMov craneArmMovGrue;
//    private List<CraneArmMov> craneArmMovList;
//    
//private CraneArmMov craneArmMovGriffe;
        
        
    private CraneArmMov craneArmMov;
    
  private List<Prize> prizes;
          
Map<JLabel, PrizeType> objectPrizeMapping = new HashMap<>();
    public theGame(String playerName, int amount) {
    this.playerName = playerName;
    this.amount = amount;
    initComponents();
    

    
    
    
    carne = new Crane();
    carne.setPlayerName(playerName);
    

    boitePrixArea = new BoxArea(boitePrix.getX(), boitePrix.getY(), boitePrix.getWidth(), boitePrix.getHeight());
    boitePrincipaleArea = new BoxArea(boitePrincipale.getX(), boitePrincipale.getY(), boitePrincipale.getWidth(), boitePrincipale.getHeight());

    carne.setBoxArea5(boitePrixArea);
    carne.setBoxArea4(boitePrincipaleArea);
int yyy   =carne.getBoxArea5().getY();
int xxx   =carne.getBoxArea5().getX();
    System.out.println("box u"+yyy);
      System.out.println("box x"+xxx);
    int initialMovementSpeed = 5;

    // Vertical
   int placeVerticalObject1 = grue2.getY();
    int placeVerticalObject2 = griffe.getY();
//    JLabel mainObject = griffe;
//
//    List<JLabel> followerObjects = Arrays.asList(grue2);
    List<Integer> initialVerticalPositions = Arrays.asList(placeVerticalObject1, placeVerticalObject2);

    // Adjust vertical slide parameters
    int verticalSlideWidth = SlideAreaVertical.getWidth();
    int verticalSlideHeight = SlideAreaVertical.getHeight();
    int verticalSlideXPosition = SlideAreaVertical.getX();
    int verticalSlideYPosition = SlideAreaVertical.getY();

    slideArea = new SlideArea(verticalSlideWidth, verticalSlideHeight, verticalSlideXPosition, verticalSlideYPosition);
    JPanel horizontalSlidePanel = slideArea.getHorizontalSlidePanel();
    JPanel verticalSlidePanel = slideArea.getVerticalSlidePanel();

    List<JLabel> craneObjects = Arrays.asList(griffe, grue2, cercileforDesi);
    List<Integer> initialPositions = Arrays.asList(griffe.getX(), grue2.getX(), cercileforDesi.getX());
    System.out.println("Vertical Objects: " + craneObjects);

    craneArmMov = new CraneArmMov(craneObjects, slideArea, initialPositions, initialMovementSpeed);

    slideArea.add(horizontalSlidePanel);
    slideArea.add(verticalSlidePanel);
    slideArea.setVerticalSlideBounds(verticalSlideYPosition, verticalSlideHeight);

    carne.setInitialMoney(amount);
    

    // the object for vertical move:
//    CraneArmMovVertical craneArmMovVertical = new CraneArmMovVertical(slideArea, initialVerticalPositions, initialMovementSpeed);


    craneArmMovVertical = new CraneArmMovVertical(slideArea, initialVerticalPositions, initialMovementSpeed);
    craneArmMovVertical.addObject(grue2);
    craneArmMovVertical.addObject(griffe);
    
    //craneArmMovVertical.addObject(anotherObject);


//     craneArmMovVertical.startAutoMoveDown(); 
//    
//    


//prizes link

objectPrizeMapping = new HashMap<>();
objectPrizeMapping.put(bluePrize, PrizeType.BLUE_DIAMOND);
objectPrizeMapping.put(bagPrize, PrizeType.CASH);
objectPrizeMapping.put(prizeGreen, PrizeType.GREEN_DIAMOND);
objectPrizeMapping.put(redPrize, PrizeType.RED_DIAMOND);
objectPrizeMapping.put(moneyPrize, PrizeType.GOLD);


int positionY = 100;  
prizes = new ArrayList<>();
//List<Prize> prizes = new ArrayList<>();
prizes.add(new Prize(bluePrize, 4, PrizeType.BLUE_DIAMOND, new Position(bluePrize.getX(), bluePrize.getY())));
prizes.add(new Prize(bagPrize, 17, PrizeType.CASH, new Position(bagPrize.getX(), bagPrize.getY())));
prizes.add(new Prize(prizeGreen, 7, PrizeType.GREEN_DIAMOND, new Position(prizeGreen.getX(), prizeGreen.getY())));
prizes.add(new Prize(redPrize, 4, PrizeType.RED_DIAMOND, new Position(redPrize.getX(), redPrize.getY())));
prizes.add(new Prize(moneyPrize, 13, PrizeType.GOLD, new Position(moneyPrize.getX(), moneyPrize.getY())));

Position griffePosition = craneArmMovVertical.getObjectPosition(griffe);

//printPrizeDetails(prizes);
Prize prizeGreenObject = prizes.get(0);
 
    
    
    // griffe tracking position the 15985632485 try
        int griffePdosition = craneArmMovVertical.getGriffePositionTracking();
        int getgriffeXPositionTrackingg = craneArmMovVertical.getgriffeYPositionTracking();
        System.out.println("Griffe Position Tracking: " + griffePdosition);
 
        checkPositionTimer = new Timer(1, new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                int griffePosition = craneArmMovVertical.getGriffePositionTracking();
//                System.out.println("Ggriffe tracking position the 15985632485 try " + griffePosition);
                
                
                for (Prize prize : prizes) {
              
//                    int rangeofcatching= 10;
                    int range = 15;
                    
                  if (prize.getPosition().getY() == griffePosition &&
                    (prize.getPosition().getX() >= griffe.getX() - range &&
                     prize.getPosition().getX() <= griffe.getX() + range)
                   ) {
                     
//                     craneArmMovVertical.addObject(prize.getLabel());   
//                     System.out.println("print prize position"+prize.getPosition().getX());
//                     System.out.println("print griffex:"+griffe.getX());
                     
                    prizeLabel  = prize.getLabel();
                    
                    craneArmMovVertical.setMovingPrize(prize);
                    
                    
                     if (prizeLabel.getX() >= boitePrixArea.getX() &&
                        prizeLabel.getX() + prizeLabel.getWidth() <= boitePrixArea.getX() + boitePrixArea.getWidth() &&
                        prizeLabel.getY() >= boitePrixArea.getY() &&
                        prizeLabel.getY() + prizeLabel.getHeight() <= boitePrixArea.getY() + boitePrixArea.getHeight()) {
                    System.out.println("it sadded");
                    // Add the prizeLabel to the ArrayList if it's inside boitePrixArea
                    prizesInsideBoitePrixArea.add(prizeLabel);
                    System.out.println(prizesInsideBoitePrixArea);
                }
                    
                    
//                    verifyPrizeLabelsArea();
                    System.out.println(craneArmMovVertical.getMovingPrize());
                     
                     
                    }else{
//                       System.out.println("game over");
                 
//                     System.out.println(griffe.getX());
//                     System.out.println(bagPrize.getX());
                   
                    }
//                       List<Prize> prizesInsideBox = getPrizesInsideArea(prizes, boitePrixArea);
//                     
                  if(prizeLabel !=null){
                      prizeLabel.setLocation(griffe.getX(), griffe.getY());
                      prizeLabel.setVisible(true);
                      
                      if (!prizeLabels.contains(prizeLabel)) {
                          prizeLabels.add(prizeLabel);
//                        System.out.println("ttt"+prizeLabels.size());
                        
                        

}
                   
                    
                      
                  }
                       
                    }
      
            }
        });
        checkPositionTimer.setRepeats(true);
        checkPositionTimer.start();

        // Start the auto movement
//        craneArmMovVertical.startAutoMoveDown();


//to change 0 to 1 later

//for (int b = 0; b <= amount; b++) {
     displayPlayerInfo();   

    if(amount >=1){
    setupKeyBindings();

}
           
// new theEnd(carne).setVisible(true);

 
}
    
    
    private List<CraneArmMovVertical.LabelInfo> getLabelsInsideBoitePrixArea(List<CraneArmMovVertical.LabelInfo> labelInfoList) {
    int boitePrixX = boitePrixArea.getX();
    int boitePrixY = boitePrixArea.getY();
    int boitePrixWidth = boitePrixArea.getWidth();
    int boitePrixHeight = boitePrixArea.getHeight();

    List<CraneArmMovVertical.LabelInfo> labelsInsideBox = new ArrayList<>();

    for (CraneArmMovVertical.LabelInfo labelInfo : labelInfoList) {
        int labelX = labelInfo.getX();
        int labelY = labelInfo.getY();

        if ((labelX >= boitePrixX && labelX <= boitePrixX + boitePrixWidth) &&
            (labelY >= boitePrixY && labelY <= boitePrixY + boitePrixHeight)) {
            labelsInsideBox.add(labelInfo);
        }
    }

    return labelsInsideBox;
}
//    private void printLabelsInsideBoitePrixArea(List<CraneArmMovVertical.LabelInfo> labelInfoList) {
//        
//    int boitePrixX = boitePrixArea.getX();
//    int boitePrixY = boitePrixArea.getY();
//    int boitePrixWidth = boitePrixArea.getWidth();
//    int boitePrixHeight = boitePrixArea.getHeight();
//
//    for (CraneArmMovVertical.LabelInfo labelInfo : labelInfoList) {
//        System.out.println("Label Name: " + labelInfo.getName());
//        System.out.println("X Position: " + labelInfo.getX());
//        System.out.println("Y Position: " + labelInfo.getY());
//
//        int labelX = labelInfo.getX();
//        int labelY = labelInfo.getY();
//
//        if ((labelX >= boitePrixX && labelX <= boitePrixX + boitePrixWidth) &&
//            (labelY >= boitePrixY && labelY <= boitePrixY + boitePrixHeight)) {
//            System.out.println("Label is inside boitePrixArea");
//           
//            //  labelInfoList
//        } else {
//            System.out.println("Label is outside boitePrixArea");
//        }
//    }
//}

     private void finishGame() {
    
        this.dispose();

    List<CraneArmMovVertical.LabelInfo> labelInfoList = craneArmMovVertical.getLabelInfoList();
    calculateAndPrintLabelsInsideBox(labelInfoList);
      
//        theEnd endWindow = new theEnd(carne);
//        

    List<LabelInfoData> labelDataList = calculateAndPrintLabelsInsideBox(labelInfoList);

    theEnd endWindow = new theEnd(carne, labelDataList);
//List<CraneArmMovVertical.LabelInfo> labelInfoList = craneArmMovVertical.getLabelInfoList();
//for (CraneArmMovVertical.LabelInfo labelInfo : labelInfoList) {
//    System.out.println("Label Name: " + labelInfo.getName());
//    System.out.println("X Position: " + labelInfo.getX());
//    System.out.println("Y Position: " + labelInfo.getY());
//
//}
   
    
 
        endWindow.setVisible(true);
    }
private List<LabelInfoData> calculateAndPrintLabelsInsideBox(List<CraneArmMovVertical.LabelInfo> labelInfoList) {
    List<CraneArmMovVertical.LabelInfo> labelsInsideBox = getLabelsInsideBoitePrixArea(labelInfoList);
    List<LabelInfoData> labelDataList = new ArrayList<>();
    
    for (CraneArmMovVertical.LabelInfo labelInfo : labelsInsideBox) {
        System.out.println("Label Name: " + labelInfo.getName());
        String labelName = labelInfo.getName();
        double redDiamondValue = PrizeType.RED_DIAMOND.getBaseValue();
        double greenDiamondValue = PrizeType.GREEN_DIAMOND.getBaseValue();
        double blueDiamondValue = PrizeType.BLUE_DIAMOND.getBaseValue();
        double goldValue = PrizeType.GOLD.getBaseValue();
        double cashValue = PrizeType.CASH.getBaseValue();

        LabelInfoData labelInfoData = new LabelInfoData();
        labelInfoData.setLabelName(labelName);

        if ("redPrize".equals(labelName)) {
            labelInfoData.setMass(4);
            labelInfoData.setValue(redDiamondValue);
        } else if ("bluePrize".equals(labelName)) {
            labelInfoData.setMass(17);
            labelInfoData.setValue(blueDiamondValue);
        } else if ("bagPrize".equals(labelName)) {
            labelInfoData.setMass(8);
            labelInfoData.setValue(goldValue);
        } else if ("prizeGreen".equals(labelName)) {
            labelInfoData.setMass(7);
            labelInfoData.setValue(greenDiamondValue);
        } else if ("moneyPrize".equals(labelName)) {
            labelInfoData.setMass(13);
            labelInfoData.setValue(cashValue);
        }

        // Calculate and set the total
        double total = labelInfoData.getMass() * labelInfoData.getValue();
        labelInfoData.setTotal(total);

        // Add the LabelInfoData object to the new list
        labelDataList.add(labelInfoData);

        // Print the values
        System.out.println("Mass: " + labelInfoData.getMass());
        System.out.println("Value: " + labelInfoData.getValue());
        System.out.println("Total: " + labelInfoData.getTotal());
    }

    return labelDataList;
}

        public List<Prize> getPrizes() {
        return prizes;
    }
    public static void resetPrizeLabel() {
        
        prizeLabel = null;
    }
    
    private void printPrizeDetails(List<Prize> prizes) {
    for (Prize prize : prizes) {
        System.out.println("type: " + prize.getType());
        System.out.println("mass: " + prize.getMass());
        System.out.println("value: " + prize.getValue());
        System.out.println("position X: " + prize.getPosition().getX());
        System.out.println("position Y: " + prize.getPosition().getY());
        System.out.println("---------------------------");
        
    }
}
private void verifyPrizeLabelsArea() {
    int boitePrixX = boitePrix.getX();
    int boitePrixY = boitePrix.getY();

    Iterator<JLabel> iterator = prizeLabels.iterator();
    while (iterator.hasNext()) {
        JLabel prizeLabel = iterator.next();

        // Check if the label's position matches boitePrix
        if (prizeLabel.getX() == boitePrixX && prizeLabel.getY() == boitePrixY) {
            System.out.println("keep it");
        } else {
            // Remove the label if it's not in the area
            prizeLabel.setVisible(true);
            System.out.println("remove it");
            iterator.remove();
        }
    }
}
private void displayPrizes() {
    for (Prize prize : prizes) {
        System.out.println("Type: " + prize.getType() + ", X: " + prize.getPosition().getX() + ", Y: " + prize.getPosition().getY());
        
    }
}


private void setupKeyBindings() {
    endGame = amount;

    if (endGame > 0) {
        InputMap inputMap = SlideAreaVertical.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = SlideAreaVertical.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "leftAction");
        actionMap.put("leftAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (endGame > 0) {
                    craneArmMov.moveLeft(0);
                    craneArmMov.moveLeft(1);
                    craneArmMov.moveLeft(2);
                }
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "rightAction");
        actionMap.put("rightAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (endGame > 0) {
                    craneArmMov.moveRight(0);
                    craneArmMov.moveRight(1);
                    craneArmMov.moveRight(2);
                }
            }
        });
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "spaceAction");
        actionMap.put("spaceAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (endGame > 0) {
                                    
                    if (isFirstSpacePress) {
                        isFirstSpacePress = false;

                        if (craneArmMovVertical != null) {
                            craneArmMovVertical.startAutoMoveDown();
                            checkPositionTimer.start();
                          resetPrizeLabel();
                        } else {
                            System.out.println("craneArmMovVertical is null");
                        }
                    } else {
                        // Perform other actions for subsequent presses
                        System.out.println("Space key pressed again");
              
                        amount = amount - 1;
                        endGame = endGame - 1;
                        isFirstSpacePress = true;
                    
                        System.out.println(amount);
                        System.out.println("print end game " + amount);
                        checkPositionTimer.stop();
//                        resetPrizeLabel();

                     if (endGame == 0) {
    System.out.println("Game Over");

    // Schedule finishGame to be called after 15 seconds (15000 milliseconds)
    Timer timer = new Timer(5000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            finishGame();
        }
    });

    // Start the timer
    timer.setRepeats(false); // Set to false to execute only once
    timer.start();
}

                        if (craneArmMovVertical != null) {
                            craneArmMovVertical.startAutoMovePrize();
                        } else {
                            System.out.println("craneArmMovVertical is null");
                        }
                    }
                }
            }
        });
    }
}

      
//      private void startMonitoringGriffePosition() {
//    int delay = 100; // Set the delay in milliseconds (adjust as needed)
//    
//    positionTimer = new Timer(delay, new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            Position griffePosition = craneArmMovVertical.getObjectPosition(griffe);
//            if (griffePosition != null) {
//                int griffeY = griffePosition.getY();
//                System.out.println("Griffe Y Position: " + griffeY);
//            } else {
//                System.out.println("Griffe position not available");
//                positionTimer.stop(); // Stop the timer if the position is not available
//            }
//        }
//    });
//
//    positionTimer.start(); // Start the timer
//}


  private void startAutoMoveDown() {
    System.out.println("startAutoMoveDown called");
       craneArmMovVertical.startAutoMoveDown(); 
}

    private void stopAutoMoveDown() {
//        craneArmMovVertical.stopAutoMoveDown();
    }
 public static JLabel getPrizeLabel() {
        return prizeLabel;
    }
 
private List<Prize> getPrizesInsideArea(List<Prize> allPrizes, BoxArea area) {
    List<Prize> prizesInsideArea = new ArrayList<>();

    for (Prize prize : allPrizes) {
        Position prizePosition = prize.getPosition();
        int prizeX = prizePosition.getX();
        int prizeY = prizePosition.getY();

        // Print BoxArea details
        System.out.println("BoxArea: x=" + area.getX() + ", y=" + area.getY() + ", width=" + area.getWidth() + ", height=" + area.getHeight());

        if (area.isPointInside(prizeX, prizeY)) {
            prizesInsideArea.add(prize);

            // Print prize details
            System.out.println("Prize Type: " + prize.getType());
            System.out.println("Prize X: " + prizeX);
            System.out.println("Prize Y: " + prizeY);
            System.out.println("---------------");
        }
    }

    return prizesInsideArea;
}

private boolean isPrizeInsideBoitePrixArea(Prize prize) {
    int prizeX = prize.getPosition().getX();
    int prizeY = prize.getPosition().getY();

    int boitePrixX = boitePrixArea.getX();
    int boitePrixY = boitePrixArea.getY();
    int boitePrixWidth = boitePrixArea.getWidth();
    int boitePrixHeight = boitePrixArea.getHeight();

    return (prizeX >= boitePrixX && prizeX <= boitePrixX + boitePrixWidth) &&
           (prizeY >= boitePrixY && prizeY <= boitePrixY + boitePrixHeight);
}


 
 
 private void displayPlayerInfo() {
    if (playerName != null && !playerName.isEmpty()) {
        displayName.setText(playerName);
        displayAmount.setText(String.valueOf(amount));
        displayName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        displayName.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        displayAmount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        displayAmount.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
    } else {
        displayName.setText("No player information");
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bluePrize = new javax.swing.JLabel();
        bagPrize = new javax.swing.JLabel();
        prizeGreen = new javax.swing.JLabel();
        redPrize = new javax.swing.JLabel();
        moneyPrize = new javax.swing.JLabel();
        cercileforDesi = new javax.swing.JLabel();
        griffe = new javax.swing.JLabel();
        grue2 = new javax.swing.JLabel();
        boitePrix = new javax.swing.JLabel();
        boitePrincipale = new javax.swing.JLabel();
        displayAmount = new javax.swing.JLabel();
        displayName = new javax.swing.JLabel();
        gameBase = new javax.swing.JLabel();
        horizntalSlideArea = new javax.swing.JLabel();
        grue = new javax.swing.JLabel();
        backGround = new javax.swing.JLabel();
        SlideAreaVertical = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bluePrize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/prizes/2.png"))); // NOI18N
        getContentPane().add(bluePrize, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, -1, -1));
        moneyPrize.setName("bluePrize");

        bagPrize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/prizes/6.png"))); // NOI18N
        getContentPane().add(bagPrize, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, -1, -1));
        bagPrize.setName("bagPrize");

        prizeGreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/prizes/5.png"))); // NOI18N
        prizeGreen.setToolTipText("");
        getContentPane().add(prizeGreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, -1, -1));
        moneyPrize.setName("prizeGreen");

        redPrize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/prizes/1.png"))); // NOI18N
        getContentPane().add(redPrize, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, -1, -1));
        moneyPrize.setName("redPrize");

        moneyPrize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/prizes/3.png"))); // NOI18N
        getContentPane().add(moneyPrize, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, -1, -1));
        moneyPrize.setName("moneyPrize");

        cercileforDesi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/game/movingontheline.png"))); // NOI18N
        getContentPane().add(cercileforDesi, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        griffe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/game/griffe.png"))); // NOI18N
        getContentPane().add(griffe, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        grue2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/game/horizntalmoving.png"))); // NOI18N
        getContentPane().add(grue2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, -310, -1, -1));

        boitePrix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/game/box2.png"))); // NOI18N
        getContentPane().add(boitePrix, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, -1));

        boitePrincipale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/game/box1.png"))); // NOI18N
        getContentPane().add(boitePrincipale, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, -1));

        displayAmount.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        displayAmount.setForeground(new java.awt.Color(255, 255, 255));
        displayAmount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/game/label.png"))); // NOI18N
        displayAmount.setText("Amount");
        getContentPane().add(displayAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        displayName.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        displayName.setForeground(new java.awt.Color(255, 255, 255));
        displayName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displayName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/game/label.png"))); // NOI18N
        displayName.setText("player name");
        getContentPane().add(displayName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        gameBase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/game/base.png"))); // NOI18N
        getContentPane().add(gameBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, -1, -1));

        horizntalSlideArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/game/horzintalSlideArea.png"))); // NOI18N
        getContentPane().add(horizntalSlideArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 40, 700, 0));

        grue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/game/grue .png"))); // NOI18N
        getContentPane().add(grue, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 20, 800, -1));

        backGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.jpg"))); // NOI18N
        getContentPane().add(backGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 890, 520));

        javax.swing.GroupLayout SlideAreaVerticalLayout = new javax.swing.GroupLayout(SlideAreaVertical);
        SlideAreaVertical.setLayout(SlideAreaVerticalLayout);
        SlideAreaVerticalLayout.setHorizontalGroup(
            SlideAreaVerticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        SlideAreaVerticalLayout.setVerticalGroup(
            SlideAreaVerticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(SlideAreaVertical, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 700, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(theGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(theGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(theGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(theGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
//    List<Player> playerList = new ArrayList<>();
        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
       public void run() {
                new theGame("DefaultName", 0).setVisible(true);
            }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SlideAreaVertical;
    private javax.swing.JLabel backGround;
    private javax.swing.JLabel bagPrize;
    private javax.swing.JLabel bluePrize;
    private javax.swing.JLabel boitePrincipale;
    private javax.swing.JLabel boitePrix;
    private javax.swing.JLabel cercileforDesi;
    private javax.swing.JLabel displayAmount;
    private javax.swing.JLabel displayName;
    private javax.swing.JLabel gameBase;
    private javax.swing.JLabel griffe;
    private javax.swing.JLabel grue;
    private javax.swing.JLabel grue2;
    private javax.swing.JLabel horizntalSlideArea;
    private javax.swing.JLabel moneyPrize;
    private javax.swing.JLabel prizeGreen;
    private javax.swing.JLabel redPrize;
    // End of variables declaration//GEN-END:variables
}

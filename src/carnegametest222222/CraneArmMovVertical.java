/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carnegametest222222;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author JustClick
 */

public class CraneArmMovVertical {

     private List<JLabel> objects;
    private SlideArea slideArea;
    private int movementSpeed;
    private Timer autoMoveDownTimer;
    private boolean isAutoMoveDownInProgress = false;
    private List<Integer> initialVerticalPositions;
    private Prize movingPrize; 
 private Timer autoMovePrizeTimer;
    private boolean isAutoMovePrizeInProgress = false;
//       JLabel prizeLabel = theGame.getPrizeLabel();
    public int griffePositionTracking=0;
    public int griffeYPositionTracking=0;
        private List<LabelInfo> labelInfoList = new ArrayList<>();
    
    
    public CraneArmMovVertical(SlideArea slideArea, List<Integer> initialVerticalPositions, int movementSpeed) {
        this.objects = new ArrayList<>(); // Initialize the objects list
        this.slideArea = slideArea;
        this.movementSpeed = movementSpeed;
        this.initialVerticalPositions = initialVerticalPositions;
        this.movingPrize = null;
     this.labelInfoList = new ArrayList<>(); 
        autoMoveDownTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isAutoMoveDownInProgress) {
                    moveDown();
                }
            }
        });
        autoMoveDownTimer.setRepeats(true);
          autoMovePrizeTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isAutoMovePrizeInProgress) {
                    movePrize();
                }
            }
        });
        autoMovePrizeTimer.setRepeats(true);
    }
  public List<LabelInfo> getLabelInfoList() {
        return labelInfoList;
    }
    public List<JLabel> getObjects() {
        return objects;
    }
      public void startAutoMovePrize() {
        isAutoMovePrizeInProgress = true;
        autoMovePrizeTimer.start();
    }

    public void stopAutoMovePrize() {
        isAutoMovePrizeInProgress = false;
        autoMovePrizeTimer.stop();
    }
    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public void startAutoMoveDown() {

        
        isAutoMoveDownInProgress = true;
        autoMoveDownTimer.start();
    }
 

    public void stopAutoMoveDown() {
        isAutoMoveDownInProgress = false;
        autoMoveDownTimer.stop();
    }

    public void addObject(JLabel object) {
        objects.add(object);
    }

   private void moveDown() {
    if (slideArea == null || objects == null) {
        System.out.println("slideArea or objects is null");
        return;
    }

    int bottommostPosition = findBottommostPosition();
    int targetPosition = bottommostPosition + movementSpeed;

    boolean continueLoop = true;

    if (targetPosition <= slideArea.getHeight()) {
        for (JLabel object : objects) {
            object.setLocation(object.getX(), object.getY() + movementSpeed);
             
        }
 
   
       griffePositionTracking=objects.get(1).getY();
//        System.out.println("Objects New Position: " + griffePositionTracking);
        griffeYPositionTracking=objects.get(1).getX();      
//        System.out.println("Objects New Position: " + objects.get(1).getX());

    } else {
        resetObjectPositions();
        
        continueLoop = false;
        
    }

    if (!continueLoop) {
        stopAutoMoveDown();
    }
}
   
  private void movePrize() {
    if (slideArea == null || movingPrize == null) {
        System.out.println("slideArea or movingPrize is null");
        return;
    }

    int bottommostPosition = findBottommostPosition();
    int targetPosition = bottommostPosition + movementSpeed;

    boolean continueLoop = true;

    if (targetPosition <= slideArea.getHeight()) {
       
        JLabel prizeLabel = movingPrize.getLabel();
        
        int newY = prizeLabel.getY() + movementSpeed; 
        
    
        if (newY >= slideArea.getHeight() - prizeLabel.getHeight()) {
            prizeLabel.setLocation(prizeLabel.getX(), slideArea.getHeight() - prizeLabel.getHeight());
            griffePositionTracking = prizeLabel.getY();
            griffeYPositionTracking = prizeLabel.getX();
            continueLoop = false;
             System.out.println(" Stop Test test 1");
             
             LabelInfo labelInfo = new LabelInfo(prizeLabel.getName(), (int) prizeLabel.getX(), (int) prizeLabel.getY());
             System.out.println(prizeLabel.getName());
             
             labelInfoList.add(labelInfo);
                  
                     
                   
        } else {
            prizeLabel.setLocation(prizeLabel.getX(), newY);
            griffePositionTracking = newY;
            griffeYPositionTracking = prizeLabel.getX();
           
        }
    } else {
        // resetObjectPositions();
        continueLoop = false;
       
//        movingPrize=null;
    }

    if (!continueLoop) {
        stopAutoMovePrize();
    }
}


 
  public void setMovingPrize(Prize prize) {
        this.movingPrize = prize;
    }

   
 public Prize getMovingPrize() {
    return movingPrize;
}

public int getObjectsNewPositionY() {
    if (objects != null && objects.size() > 1) {
        return objects.get(1).getY();
    } else {

        return -1;
    }
}



     private void resetObjectPositions() {
        for (int i = 0; i < objects.size(); i++) {
            JLabel object = objects.get(i);
            int initialPosition = initialVerticalPositions.get(i);
            moveObjectToPosition(object, initialPosition);
        }
    }

       private void moveObjectToPosition(JLabel object, int targetPosition) {
        int currentPosition = object.getY();
        int speed = (currentPosition < targetPosition) ? movementSpeed : -movementSpeed;

        Timer returnTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((speed > 0 && object.getY() < targetPosition) || (speed < 0 && object.getY() > targetPosition)) {
                    object.setLocation(object.getX(), object.getY() + speed);
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        returnTimer.setRepeats(true);
        returnTimer.start();
    }

     
     
    private int findBottommostPosition() {
        int bottommost = Integer.MIN_VALUE;
        for (JLabel object : objects) {
            int position = object.getY() + object.getHeight();
            if (position > bottommost) {
                bottommost = position;
            }
        }
        return bottommost;
    }
    
    public List<Integer> getAllObjectYPositions() {
    List<Integer> yPositions = new ArrayList<>();
    for (JLabel object : objects) {
        int objectY = object.getY();
        yPositions.add(objectY);
    }
    return yPositions;
}
public Position getObjectPosition(JLabel object) {
    int objectIndex = objects.indexOf(object);
    if (objectIndex != -1 && objectIndex < initialVerticalPositions.size()) {
        int objectY = initialVerticalPositions.get(objectIndex);
        return new Position(object.getX(), objectY);
    } else {
        return null;
    }
}
 public int getGriffePositionTracking() {
        return griffePositionTracking;
    }
 public int getgriffeYPositionTracking(){
     return griffeYPositionTracking;
 }
 public  static class LabelInfo {
        private String name;
        private int x;
        private int y;

        public LabelInfo(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        public String getName() {
            return name;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
 }}
 
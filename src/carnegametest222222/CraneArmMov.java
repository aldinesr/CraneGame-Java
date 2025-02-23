/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carnegametest222222;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
/**
 *
 * @author JustClick
 */

public class CraneArmMov {
    private List<JLabel> objects;
    private SlideArea slideArea;
    private int objectWidth;
    private List<Integer> currentPositions;
    private int movementSpeed;
    
    
      public CraneArmMov(List<JLabel> objects, SlideArea slideArea, List<Integer> initialPositions, int movementSpeed) {
        this.objects = objects;
        this.slideArea = slideArea;
        this.objectWidth = objects.get(0).getWidth(); // Assuming all objects have the same width
        this.currentPositions = new ArrayList<>(initialPositions);
         this.movementSpeed = movementSpeed;
    }
 public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }
 
    public void moveLeft(int objectIndex) {
        int leftmostPosition = findLeftmostPosition();
        if (leftmostPosition - movementSpeed >= 0) {
            for (int i = 0; i < objects.size(); i++) {
                currentPositions.set(i, currentPositions.get(i) - movementSpeed);
                updateObjectPosition(i);
            }
        }
    }
  
     public void moveRight(int objectIndex) {
        int rightmostPosition = findRightmostPosition();
        if (rightmostPosition + movementSpeed <= slideArea.getWidth()) {
            for (int i = 0; i < objects.size(); i++) {
                currentPositions.set(i, currentPositions.get(i) + movementSpeed);
                updateObjectPosition(i);
            }
        }
    }
   private int findLeftmostPosition() {
        int leftmost = Integer.MAX_VALUE;
        for (int position : currentPositions) {
            if (position < leftmost) {
                leftmost = position;
            }
        }
        return leftmost;
    }

    private int findRightmostPosition() {
        int rightmost = Integer.MIN_VALUE;
        for (int i = 0; i < objects.size(); i++) {
            int position = currentPositions.get(i) + objects.get(i).getWidth();
            if (position > rightmost) {
                rightmost = position;
            }
        }
        return rightmost;
    }
    private void updateObjectPosition(int objectIndex) {
        int newX = currentPositions.get(objectIndex) + slideArea.getXPosition();
        int newY = objects.get(objectIndex).getY();
        objects.get(objectIndex).setLocation(newX, newY);
    }
}
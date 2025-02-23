/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carnegametest222222;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JLabel;
/**
 *
 * @author JustClick
 */
public class Prize {
    private static List<Prize> allPrizes = new ArrayList<>();
    private static List<JLabel> prizeLabels = new ArrayList<>();
    
    private static List<Prize> movedList = new ArrayList<>();
    private double mass;
    private PrizeType type;
    private double value;
    private Position position;
    private JLabel label;
    private JLabel movingPrize;
    
    public Prize(JLabel label, double mass, PrizeType type, Position position) {
        this.label = label;
        this.mass = mass;
        this.type = type;
        this.value = calculateValue();
        this.position = position;
        allPrizes.add(this); 
        prizeLabels.add(label);
         
    }
   private static Prize findPrizeByLabel(JLabel label) {
    for (Prize prize : allPrizes) {
        if (Objects.equals(prize.getLabel(), label)) {
            return prize;
        }
    }
    return null;
}
    public double getMass() {
        return mass;
    }
     public void setPositionXY(int x, int y) {
        this.position = new Position(x, y);
    }
    public static List<Prize> getAllPrizes() {
        return allPrizes;
    }
     public static List<Prize> getMovedList() {
        return movedList;
    }
     
    public static void setMovedList(List<Prize> movedList) {
        Prize.movedList = movedList;
    }
     
    public JLabel getLabel() {
        return label;
    }

    public void setMovingPrize(JLabel movingPrize) {
        this.movingPrize = movingPrize;
    }

    public JLabel getMovingPrize() {
        return movingPrize;
    }

    public void setMass(double mass) {
        this.mass = mass;
        this.value = calculateValue();
    }

    public double getValue() {
        return calculateValue();
    }

    public PrizeType getType() {
        return type;
    }

    public void setType(PrizeType type) {
        this.type = type;
        this.value = calculateValue();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    private double calculateValue() {
        return type.getBaseValue() * mass;
    }
    
    
    
}
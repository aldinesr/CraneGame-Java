/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carnegametest222222;

/**
 *
 * @author JustClick
 */
public class LabelInfoData {
    private String labelName;
    private int mass;
    private double value;
    private double total;

    public LabelInfoData(String labelName, int mass, double value, double total) {
        this.labelName = labelName;
        this.mass = mass;
        this.value = value;
        this.total = total;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public int getMass() {
        return mass;
    }
public LabelInfoData() {
    }
    public void setMass(int mass) {
        this.mass = mass;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

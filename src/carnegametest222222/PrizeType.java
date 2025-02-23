/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package carnegametest222222;

/**
 *
 * @author JustClick
 */
public enum PrizeType {
    RED_DIAMOND(450.58),
    GREEN_DIAMOND(102.00),
    BLUE_DIAMOND(97.08),
    GOLD(65.73),
    CASH(100.0);

    private final double baseValue;

    PrizeType(double baseValue) {
        this.baseValue = baseValue;
    }

    public double getBaseValue() {
        return baseValue;
    }
}


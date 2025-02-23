/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carnegametest222222;


import javax.swing.JPanel;

public class SlideArea extends JPanel {
    private JPanel horizontalSlidePanel;
    private JPanel verticalSlidePanel;
    private int width;
    private int height;
    private int xPosition;
    private int yPosition;

    public SlideArea(int width, int height, int xPosition, int yPosition) {
        this.width = width;
        this.height = height;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        initializeSlidePanels();
        setLayout(null);  // Set layout to null for manual positioning
        setBounds(xPosition, yPosition, width, height);
        add(horizontalSlidePanel);
        add(verticalSlidePanel);
        setVerticalSlideBounds(yPosition, height);  // Set initial bounds for the vertical slide panel
        setHorizontalSlideBounds(xPosition, width);  // Set initial bounds for the horizontal slide panel
    }

    private void initializeSlidePanels() {
        horizontalSlidePanel = new JPanel();
        verticalSlidePanel = new JPanel();
    }

    public JPanel getHorizontalSlidePanel() {
        return horizontalSlidePanel;
    }

    public JPanel getVerticalSlidePanel() {
        return verticalSlidePanel;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setVerticalSlideBounds(int y, int height) {
        verticalSlidePanel.setBounds(xPosition, y, width, height);
    }

    public void setHorizontalSlideBounds(int x, int width) {
        horizontalSlidePanel.setBounds(x, yPosition, width, height);
    }
}

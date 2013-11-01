import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * A bar appearing above the heads of units to indicate current health remaining and health missing.
 * 
 * @Dylan Graves
 * @version 1
 */
public class StatusBar extends Actor
{
    protected GreenfootImage bar;
    protected Color fullColor;
    protected Color missingColor;
    protected int width, height;
    public StatusBar(int width, int height, Color fullColor, Color missingColor) {
        this.fullColor = fullColor;
        this.missingColor = missingColor;
        this.width = width;
        this.height = height;
        bar = new GreenfootImage(50,10);
        updateBar(width);
    }
    
    public void updateBar(int amountFull){
        bar.setColor(fullColor);
        bar.fillRect(0, 0, amountFull, 5);
        bar.setColor(missingColor);
        bar.fillRect(amountFull, 0, 100 - amountFull, 5);
        setImage(bar);
    }
    
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}


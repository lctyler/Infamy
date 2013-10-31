import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * A bar appearing above the heads of units to indicate current health remaining and health missing.
 * 
 * @Dylan Graves
 * @version 1
 */
public class HealthBar extends StatusBar
{
    Human subject;
    GreenfootImage bar;
    public HealthBar(Human subject) {
        super(50, 10, new Color(50,120,0), new Color(200,50,0));
        this.subject = subject;
        bar = new GreenfootImage(100,10);
        updateBar();
    }
    
    public void updateBar(){
        super.updateBar(subject.getHealth()/2);
        setLocation(subject.getX(), subject.getY() - subject.getImage().getHeight()/2 - 1);
    }
    
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        updateBar();
    }    
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class StressBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StressBar extends StatusBar
{
    private WinstonCrowley subject;
    public StressBar(WinstonCrowley winst) {
       super(50, 10, new Color(255,0,0), new Color(255,255,255));
        this.subject = winst;
        updateBar();
    }
    
    public void updateBar(){
        super.updateBar(subject.getStress()/2);
        setLocation(subject.getX(), subject.getY() - subject.getImage().getHeight()/2 - 11);
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

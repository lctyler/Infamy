import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class GasButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GasButton extends HUD
{
    private int counter = 1000;
    
    /**
     * Act - do whatever the GasButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this) && counter == 0) {
            setImage("gas-button-pressed.png");
            counter = 1000;
            gasEm();
        }
        
        if (counter > 0)
        {
            counter--;
            if (counter == 0)
                setImage("gas-button.png");
        }
    }   
    
    private void gasEm()
    {
        List humanList = this.getWorld().getObjects(Human.class);
        
        for (Object hu : humanList)
            ((Human)hu).loseHealth(10);
    }
}

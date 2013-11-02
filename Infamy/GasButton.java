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
    private boolean pressed = true;
    public GasButton(){
        super();
        setImage("gas-button-pressed.png");
    }
    /**
     * Act - do whatever the GasButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void GasButton() {
        setImage("gas-button-pressed.png"); 
    }
    
    public void act() 
    {
        if (Greenfoot.mouseClicked(this) && !pressed) {
            setPressed();
            gasEm();
            Gas gas1 = new Gas();
            this.getWorld().addObject(gas1, 700, 300);
            Gas gas2 = new Gas();
            this.getWorld().addObject(gas2, 900, 300);
        }
    }   
    
    public void setPressed() {
        pressed = true;
        setImage("gas-button-pressed.png");
    }
    
    public void setAvailable() {
        pressed = false;
        setImage("gas-button.png");
    }
    
    private void gasEm()
    {
        List humanList = this.getWorld().getObjects(Human.class);
        
        for (Object hu : humanList)
            if (!((Human)hu instanceof WinstonCrowley))
            ((Human)hu).addDamageOverTime(40, 40);
        Greenfoot.playSound("gasSound.mp3");
    }
}

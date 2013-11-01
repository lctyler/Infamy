import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class FadingDialogue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FadingDialogue extends Movement
{
    public int FadingTimer;
    public int OpacityValue;
    public String message;
    public int x;
    public int y;
    boolean loop;
    public FadingDialogue(int xl, int yl, String messag)
    {
        x = xl;
        y = yl;
        message = messag;
        FadingTimer = 0;
        OpacityValue = 0;        
        MakeFadingDialogue(OpacityValue);
        loop = false;
    }
    /**
     * Act - do whatever the FadingDialogue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (FadingTimer%10 == 1)
        {
            System.out.println(OpacityValue);
            MakeFadingDialogue(OpacityValue);
            if (loop)
            {
                OpacityValue -= 20;
            }
            else
            {
                OpacityValue += 30;
            }
        }
        if (OpacityValue <= 0 && loop)
        {
            getWorld().removeObject(this);
        }
        else if (OpacityValue >= 255 && !loop)
        {
            loop = true;
            OpacityValue = 255;
        }
        FadingTimer++;
    }    
    
    public void MakeFadingDialogue(int opacity)
    {        
        GreenfootImage background = new GreenfootImage(message, 32, new Color(0,0,0,opacity), new Color(109, 128, 61, opacity));
        this.setImage(background);
        if (getWorld() != null)
            getWorld().addObject(this, x, y);
    }
}

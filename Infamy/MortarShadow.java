import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Mortar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MortarShadow extends Actor
{
    GreenfootImage shadow;
    Color shadowBlack;
    private int time;
    private int startTime;
    private int targetx;
    private int targety;
    private int size;
    private int dropTime;
    public MortarShadow (int targetx, int targety) {  
        time = 0;
        size = 50;
        getImage().setTransparency(0);
        startTime = 150;
        dropTime = 200;
        this.targetx = targetx;
        this.targety = targety;
    }
    
    public void drawShadow(int timeOffset){
        Color shadowBlack = new Color(0,0,0);
        shadow = new GreenfootImage(size,size);
        shadow.setColor(shadowBlack);
        shadow.fillOval((time - timeOffset)/4,
                       (time - timeOffset)/8, size - (time - timeOffset)/2,
                       size - (time - timeOffset)/2);
        setImage(shadow);
        getImage().setTransparency(100 + (time-timeOffset)/2);
        setLocation(targetx, targety);
    }
    
    public int getStartTime(){
        return startTime;
    }
    
    /**
     * Act - do whatever the Mortar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        time++;
        if(time == startTime){
            drawShadow(time);
        }
        if(time > dropTime){
            drawShadow(dropTime);
        }
        if(size - (time - startTime)/2 == 0)
            getWorld().removeObject(this);
    }    
}

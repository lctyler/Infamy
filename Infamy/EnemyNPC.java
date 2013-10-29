import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/**
 * Want to get them to engage evenly. 
 */
public class EnemyNPC extends German
{
    private static final long RELOAD_TIME = 4000;
    Flag enemyflag = null; 
    private boolean hasShot = false, advance = true; 
    long timer; 
    private boolean isDefender;
    private int runTimer = 0;
    
    public EnemyNPC(boolean defenderStatus) {
        isDefender = defenderStatus; 
    }
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Date d  = new Date();
        if ((d.getTime() - timer) > RELOAD_TIME ) {
            //System.out.println(d.getTime() - timer); 
            hasShot = false;
        }
        ArrayList<British> brits = spot(200); 
        if (brits != null && !hasShot) {
            //System.out.println(brits.size());
            int n = brits.size(); 
            int i = 0; 
            advance = false; 
            if ( n > 0)
                
                //i = Greenfoot.getRandomNumber(n);
                if (brits.size() != 0) {
                    //System.out.println("Shooting: " + brits.get(0).getX() + " " + brits.get(0).getY()); 
                    shoot(brits.get(0)); 
                    hasShot = true; 
                    timer = d.getTime(); 
                }
        }
        else {
            advance = true; 
        }
           
            
            
        
            enemyflag = (Flag)getWorld().getObjects(Flag.class).get(1);  
        if (brits.size() == 0 && !isDefender) {

            NPCAdvance();

            runTimer++;
            if (runTimer==24)
            {
                setImage("enemy-running-left-4.png");
                runTimer=0;  
            }
            if (runTimer==0) setImage("enemy-running-left-1.png");  
            if (runTimer==8) setImage("enemy-running-left-2.png");  
            if (runTimer==16) setImage("enemy-running-left-3.png");
           
        }
        else
            setImage("enemy-aiming-left.png");
    }
        // Spot bad guys. (if bad guys are there, crouch, and shoot) 
        // else: advance. 
        
    
    
    
    /**
     * Detects if there are any british soldiers in the search area. 
     */
    public ArrayList<British> spot(int range) {
       // System.out.println(getObjectsInRange(range, British.class).size());
        return (ArrayList<British>)getObjectsInRange(range, British.class);
         
    }
    
    public void shoot(British  target) {
        Greenfoot.playSound("gunFire.mp3");
        ((TutorialInfamyWorld)getWorld()).addBullet(this, target);
    }
}

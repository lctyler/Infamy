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
public class Enemy extends German
{
    private static final long RELOAD_TIME = 4000;
    Flag enemyflag = null; 
    private boolean hasShot = false; 
    long timer; 
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {;
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
            if ( n > 0)
                
                i = Greenfoot.getRandomNumber(n);
                if (brits.size() != 0) {
                    System.out.println("Shooting: " + brits.get(i).getX() + " " + brits.get(i).getY()); 
                    shoot(brits.get(i)); 
                    hasShot = true; 
                    timer = d.getTime(); 
                }
           }
           
            
            
        
            enemyflag = (Flag)getWorld().getObjects(Flag.class).get(1);  
            advance(); 
    }
        // Spot bad guys. (if bad guys are there, crouch, and shoot) 
        // else: advance. 
        
    
    
    public void advance() { 
        if (enemyflag.getX() < getX()) {
           setLocation(getX()-1, getY()); 
        }
        else {
           setLocation(getX()+1, getY());  
        }
        
         if (enemyflag.getY() < getY()) {
           setLocation(getX(), getY()- 1); 
        }
        else {
           setLocation(getX(), getY()+1);  
        }
        
    }
    /**
     * Detects if there are any british soldiers in the search area. 
     */
    public ArrayList<British> spot(int range) {
       // System.out.println(getObjectsInRange(range, British.class).size());
        return (ArrayList<British>)getObjectsInRange(range, British.class);
         
    }
    
    public void shoot(British  target) {
        ((InfamyWorld)getWorld()).addBullet(this, target);
    }
}

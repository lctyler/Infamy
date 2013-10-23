import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Movement
{
    private Actor target = null;
    
    private int x, y, posx, posy;
    
    public Bullet(Actor from, Actor target) {
        int x, y; 
        setLocation(from.getX(), from.getY());
        this.target = target; 
        x = target.getX(); 
        y = target.getY();
        posx = x; 
        posy = y;
        x += Greenfoot.getRandomNumber(4);
        y += Greenfoot.getRandomNumber(4); 
        
        this.x = x;
        this.x = y; 
        
        
        
    }
    
 
    
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      moveTowardsTarget();
      
       if (isAtWorldEdge()) { 
         getWorld().removeObject(this);     
          
      }
      
      kill(); 
      
     
          
    }
    
    
    public void moveTowardsTarget() {
        turnTowards(x, y);
        move(1); 
    }
    
    public void kill() {
        British brit = (British)getOneIntersectingObject(British.class);
        
        if (brit != null) {
            getWorld().removeObject(brit); 
            getWorld().removeObject(this); 
        }
        
        
       
    }
    
    
}

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
    private boolean targetMoved = false; 
    
    private int x, y, posx, posy;
    
    public Bullet(Actor from, Actor target) {
        //int tempX, tempY; 
        setLocation(from.getX(), from.getY());
        this.target = target; 
        x = target.getX(); 
        y = target.getY();
        posx = x; 
        posy = y;
       // x += Greenfoot.getRandomNumber(4);
       // y += Greenfoot.getRandomNumber(4); 
        
       // this.x = x;
        //this.x = y; 
        
      
        
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
      else {
         kill();     
      }
      
      
      
     
          
    }
    
    // prevention of the bullet from going towards one spot. 
    public void moveTowardsTarget() {
        if (getX() == x && getY() == y) {
            targetMoved = true;
        }
        
        if (!targetMoved) {
            turnTowards(x, y);
        }
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

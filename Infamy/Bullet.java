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
    private Actor source = null;
    private int x, y, posx, posy;
    
	    public Bullet(Actor from, int targetx, int targety) {
        setLocation(from.getX(), from.getY());
        this.target = target; 
        x = targetx; 
        y = targety;
        posx = x; 
        posy = y;
    }
	
    public Bullet(Actor from, Actor target) {
        //int tempX, tempY; 
        setLocation(from.getX(), from.getY());
        this.target = target;
        this.source = from;
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
    // set rotation thing. 
    public void moveTowardsTarget() {
        if (getX() >= x && getX() <= x + 10) {
            targetMoved = true;
        }
        
        if (!targetMoved) {
            turnTowards(x, y);
        }
        move(10); 
    }
    
    public void kill() {
<<<<<<< HEAD
        Dialogue target = (Dialogue)getOneIntersectingObject(Dialogue.class);
=======
        British brit = (British)getOneIntersectingObject(British.class);
        German germ = (German)getOneIntersectingObject(German.class);
>>>>>>> 4810551414170826bca846d0c51249d3ea03051c
        
        if (target != null && target != this.source) {
            getWorld().removeObject(target); 
            getWorld().removeObject(this); 
        }
        if (germ != null) {
            getWorld().removeObject(germ);
            getWorld().removeObject(this);
        }
    }
    
    
}

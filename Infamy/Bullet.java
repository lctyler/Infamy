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
    private final static int DAMAGE = 20; 
    
        public Bullet(Actor from, int targetx, int targety) {
       
        setImage("ant.png");     
        setLocation(from.getX(), from.getY());
        this.target = target; 
        x = targetx; 
        y = targety;
        posx = x; 
        posy = y;
        source = from; 
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
        Human target = (Human)getOneIntersectingObject(Human.class);
     
        if (target != null && target != this.source) {
            target.loseHealth(DAMAGE); 
            getWorld().removeObject(this);
       }
   }
    
    
}

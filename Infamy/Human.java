import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Human here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Human extends Movement
{
    protected Dialogue d; 
    int health = 100; 
    public Human() {
       d = new Dialogue();     
        
    }
    
    public int getHealth() {
       return health;     
        
    }
    
    public void loseHealth(int damage) {
       health -= damage;
       if (health <= 0) {
          die(); 
        }
    }
    
    public void die() {
        if (this instanceof British) {
            if (this instanceof WinstonCrowley)
                Greenfoot.setWorld(new DefeatWorld());
            ((TutorialInfamyWorld)this.getWorld()).decBCounter();
        }
        else {
               ((TutorialInfamyWorld)this.getWorld()).decGCounter();
        }
        
        getWorld().removeObject(this);
        
    }
    
    /**
     * Act - do whatever the Human wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void yield(int y) {
        setLocation(getX()- 1, y  - 1); 
        
    }
    
    
    public void NPCAdvance() {
       Flag enemyflag = null; 
       if (this instanceof German) {
        enemyflag = (Flag)getWorld().getObjects(Flag.class).get(1);
       }
       else {
          enemyflag = (Flag)getWorld().getObjects(Flag.class).get(0); 
        }
       List<Actor> inWay = null; 
        if (this instanceof German) {
          inWay = getObjectsAtOffset(-1, 0, Obstacle.class);
          //inWay.addAll(getObjectsAtOffset(-1, 0, Human.class));
        }
        else {
          inWay = getObjectsAtOffset(1, 0, Obstacle.class);
          //inWay.addAll(getObjectsAtOffset(-1, 0, Human.class));
        }
        if (inWay.size() == 0) {
            
            Human target = (Human)getOneIntersectingObject(Human.class);
            if (target != null) {
               target.yield(getY()); 
            }
            else {
            
                if (enemyflag.getX() < getX()) {
                   setLocation(getX()-1, getY()); 
                }
                else {
                   setLocation(getX()+1, getY());  
                }
                
                 if (enemyflag.getY() < getY() && enemyflag.getX() == getX()) {
                   setLocation(getX(), getY()- 1); 
                }
                else if (enemyflag.getX() == getX()) {
                   setLocation(getX(), getY()+1);  
                }
            }
           
       } else {
           
           for (Actor a : inWay ) {
           
            if (a instanceof Sandbag) {
                setLocation(getX(), getY()+ 1); 
            }
          }
       }
      
    }
    
    
    
}

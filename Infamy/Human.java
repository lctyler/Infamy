import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
}

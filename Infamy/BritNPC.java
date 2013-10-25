import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class NPC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BritNPC extends British
{
    public String Type;
    private static final long RELOAD_TIME = 4000;
    Flag enemyflag = null; 
    private boolean hasShot = false, advance = true; 
    long timer;
    
    public BritNPC(String npcType)
    {
        this.Type = npcType;
    }
    /**
     * Act - do whatever the NPC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Date d  = new Date();
        if ((d.getTime() - timer) > RELOAD_TIME ) {
            //System.out.println(d.getTime() - timer); 
            hasShot = false;
        }
        ArrayList<Actor> germans = spot(200); 
        if (germans != null && !hasShot) {
            //System.out.println(brits.size());
            int n = germans.size(); 
            int i = 0; 
            advance = false; 
            if ( n > 0)
                
                //i = Greenfoot.getRandomNumber(n);
                if (germans.size() != 0) {
                    System.out.println("Shooting: " + germans.get(0).getX() + " " + germans.get(0).getY()); 
                    shoot(germans.get(0)); 
                    hasShot = true; 
                    timer = d.getTime(); 
                }
        }
        else {
            advance = true; 
        }
           
            
            
        
            enemyflag = (Flag)getWorld().getObjects(Flag.class).get(0);  
        if (germans.size() == 0) {
            advance();
        }
    }    
    
    
    public void advance() { 
        if (enemyflag.getX() < getX()) {
           setLocation(getX()-1, getY()); 
        }
        else {
           setLocation(getX()+1, getY());  
        }
        
        if (getX() > (getWorld().getWidth() / 2)){
             if (enemyflag.getY() < getY()) {
                 setLocation(getX(), getY()- 1); 
                }
             else {
                  setLocation(getX(), getY()+1);  
                }
       }
        
    }
    
     /**
     * Detects if there are any british soldiers in the search area. 
     */
    public ArrayList<Actor> spot(int range) {
       // System.out.println(getObjectsInRange(range, British.class).size());
        return (ArrayList<Actor>)getObjectsInRange(range, German.class);
         
    }
    
    public void shoot(Actor target) {
        ((TutorialInfamyWorld)getWorld()).addBullet(this, target);
    }
    
}

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
    private boolean isDefender; 
    private int runTimer = 0;
    // total hack variable, just leave it alone!
    public boolean isDucking = false;
    
    public BritNPC(boolean defender)
    {
        isDefender = defender; 
    }
    /**
     * Act - do whatever the NPC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isDucking) {
            setImage("man-crouching-right.png");
            return;
        }
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
                if (germans.size() != 0 && !isRetreating()) {
                   // System.out.println("Shooting: " + germans.get(0).getX() + " " + germans.get(0).getY()); 
                    shoot(germans.get(0)); 
                    hasShot = true; 
                    timer = d.getTime(); 
                }
        }
        else {
            advance = !isRetreating(); 
        }
           
        enemyflag = (Flag)getWorld().getObjects(Flag.class).get(0);  
        if (isRetreating || germans.size() == 0 && !isDefender) {
            if(!isRetreating()){
                setCovered(false);
                NPCAdvance(1);
            }
            else if(isRetreating() && !isInTrench()){
                NPCAdvance(-1);
            }
            else if(isRetreating() && isInTrench()) {
                setCovered(true);
                //Change to cover image
                setImage("man-running-right-4.png");
            }
            if(!isCovered){
                runTimer++;
                if(!isRetreating()){
                    if (runTimer==18)
                    {
                        setImage("man-running-right-4.png");
                        runTimer=0;  
                    }
                    if (runTimer==0) setImage("man-running-right-1.png");  
                    if (runTimer==6) setImage("man-running-right-2.png");  
                    if (runTimer==12) setImage("man-running-right-3.png");
                }
                else {
                    if (runTimer==18)
                    {
                        setImage("man-running-right-4.png");
                        getImage().mirrorHorizontally();
                        runTimer=0;  
                    }
                    if (runTimer==0) {
                        setImage("man-running-right-1.png"); 
                        getImage().mirrorHorizontally();
                    }
                    if (runTimer==6){
                        setImage("man-running-right-2.png");
                        getImage().mirrorHorizontally();
                    }
                    if (runTimer==12){
                        setImage("man-running-right-3.png");
                        getImage().mirrorHorizontally();
                    }
                }
            }
        }
        if(isCovered())
            setImage("man-crouching-right.png");
        applyDamageOverTime();
    }    
    public boolean isDefender(){
        return isDefender;
    }
//    public void advance() { 
//         if (enemyflag.getX() < getX()) {
//            setLocation(getX()-1, getY()); 
//         }
//         else {
//            setLocation(getX()+1, getY());  
//         }
//         
//          if (enemyflag.getY() < getY() && enemyflag.getX() == getX()) {
//            setLocation(getX(), getY()- 1); 
//         }
//         else if (enemyflag.getX() == getX()) {
//            setLocation(getX(), getY()+1);  
//         }
//     }
    
     /**
     * Detects if there are any british soldiers in the search area. 
     */
    public ArrayList<Actor> spot(int range) {
       // System.out.println(getObjectsInRange(range, British.class).size());
        return (ArrayList<Actor>)getObjectsInRange(range, German.class);
         
    }
    
    public void shoot(Actor target) {
        Greenfoot.playSound("gunFire.mp3");
        ((HumanWorld)getWorld()).addBullet(this, target);
    }
    
}

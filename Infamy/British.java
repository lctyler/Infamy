import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class British here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class British extends Human {
    public boolean isInTrench() {
        return ((this.getY() > 300 && this.getX() > 75 && this.getX() < 160) ||
           (this.getY() < 300 && this.getX() > 120 && this.getX() < 160));
    }
    /**
     * Act - do whatever the British wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
    }    
}

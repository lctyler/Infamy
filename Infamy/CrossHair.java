import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrossHair here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrossHair extends Actor
{
    /**
     * Act - do whatever the CrossHair wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.getMouseInfo() != null)
            setLocation(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }    
}
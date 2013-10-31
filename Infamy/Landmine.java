import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Landmine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Landmine extends Actor
{
    public boolean Active;
    private final static int DAMAGE = 70; 
    public Landmine()
    {
        Active = false;
    }
    /**
     * Act - do whatever the Landmine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        CheckForEnemyProximity();
    }
    public void CheckForEnemyProximity()
    {
        German target = (German)getOneIntersectingObject(German.class);
        
        if (target != null && this.Active)
        {
            target.loseHealth(DAMAGE);
            getWorld().removeObject(this);
        }
    }
}

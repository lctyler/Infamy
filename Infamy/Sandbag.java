import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sandbag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sandbag extends Obstacle
{
    private boolean providesCover;
    public Sandbag() {
        providesCover = false;
      
    }
    
    public Sandbag(boolean providesCover){
        this.providesCover = providesCover;
    }
    
    /**
     * Act - do whatever the Sandbag wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(providesCover) {
            Bullet hit = (Bullet)(getOneIntersectingObject(Bullet.class));
            if(hit != null)
                this.getWorld().removeObject(hit);
        }
    }    
}

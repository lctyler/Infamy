import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinstonCrowley here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinstonCrowley extends British
{
    /**
     * Act - do whatever the WinstonCrowley wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
	    if(Greenfoot.mouseClicked(null)){
            MouseInfo info = Greenfoot.getMouseInfo();
            getWorld().addObject(new Bullet(this, info.getX(), info.getY()), 
                this.getX() + this.getImage().getWidth()/2 + 10, this.getY() - 10);
        }
        move();
        ExecuteDialogueInteraction();
    }    
}

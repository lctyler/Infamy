import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gas extends Actor
{
    private int counter = 0;
    
    public Gas() {
        setImage("gas.png");
    }
    
    /**
     * Act - do whatever the Gas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        this.setLocation(this.getX(), this.getY() - 1);
        
        if (counter == 150)
            this.getWorld().removeObject(this);
            
        counter++;
    }    
}

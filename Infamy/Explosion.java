import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    public int timer = 0;
    public Explosion(int scalex, int scaley) {
        setImage("explode.png");
        getImage().scale(scalex, scaley);
        GreenfootSound exSound = new GreenfootSound("explode.mp3");
        exSound.setVolume(80);
        exSound.play();
    }
    
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(timer > 10)
            getWorld().removeObject(this);
        timer++;
    }    
}

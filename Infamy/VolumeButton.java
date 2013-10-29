import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VolumeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VolumeButton extends HUD
{
    /**
     * Act - do whatever the VolumeButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean volumeOn; 
    public VolumeButton() {
        setImage("soundOn.png");
        volumeOn = true;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            volumeOn = !volumeOn;
            
            if (volumeOn) {
                setImage("soundOn.png");
            }
            else {
                setImage("soundOff.png"); 
            }
            
            ((TutorialInfamyWorld)this.getWorld()).toggleSound(volumeOn); 
        }
    }    
}

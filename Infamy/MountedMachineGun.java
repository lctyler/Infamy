import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MountedMachineGun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MountedMachineGun extends German
{
    private static int MAG_SIZE = 200;
    private int fireRate = 15;
    private int shotClock = 0;
    private int magazineLeft = MAG_SIZE;
    private int targetx;
    private int targety;
    private int ydirection = 10;
    private int xdirection = 20;
    
    public MountedMachineGun(int startTargetX, int startTargetY){
        targetx = startTargetX;
        targety = startTargetY;
        setImage("enemy-running-left-1.png");
    }
    
    /**
     * Act - do whatever the MountedMachineGun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(shotClock % fireRate == 0){
            ((HumanWorld)this.getWorld()).addBullet(this, targetx, targety);
        }
       // updateTargetX();
        updateTargetY();
        shotClock++;
    }    
    
    public void updateTargetX(){
        targetx += xdirection;
    }
    
    public void updateTargetY(){
        targety += ydirection;
        if(targety > getWorld().getHeight() || targety <= 0){
            ydirection = -1 * ydirection;   
            xdirection = -1 * xdirection;
        }
            
    }
}

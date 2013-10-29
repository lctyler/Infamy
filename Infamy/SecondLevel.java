import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class SecondLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondLevel extends HumanWorld
{
    private List alive;
    private GreenfootSound fireSound1;
    private GreenfootSound fireSound2;
    private MountedMachineGun gun1;
    private MountedMachineGun gun2;
    private WinstonCrowley winst;
     /* Constructor for objects of class SecondLevel.
     * 
     */
    public SecondLevel()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1);
        populate();
        fireSound1 = new GreenfootSound("MachineGunFire.wav");
        fireSound2 = new GreenfootSound("MachineGunFire2.wav");
    }
    
    public void populate(){
       winst = new WinstonCrowley();
       this.addHuman(winst, 50,500);
       gun1 = new MountedMachineGun(0,this.getHeight());
       this.addHuman(gun1, 875, 110);
       gun2 = new MountedMachineGun(0,0);
       this.addHuman(gun2, 890, 400);
       
       CrossHair crosshair = new CrossHair();
       this.addObject(crosshair,0,0);
    }
    
    public void act() {
        alive = getObjects(MountedMachineGun.class);
        updateMusic();
        if(winst.getX() > 800 && alive.size() ==0)
            secondLevelWin();
    }
    
    public void secondLevelWin(){
        Greenfoot.setWorld(new WinWorld(Human.Score));
    }
    
    public void updateMusic(){
        fireSound1.playLoop();
        fireSound2.playLoop();
        if(!alive.contains(gun1)) {
            fireSound1.stop();
        }
        if(!alive.contains(gun2)) {
            fireSound2.stop();
        }
    }
}
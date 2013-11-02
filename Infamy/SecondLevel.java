import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.*;
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
    private boolean guyCharges = false;
    private BritNPC brit1;
    private long levelStart; 
    private boolean talkFlag = false;
     /* Constructor for objects of class SecondLevel.
     * 
     */
    public SecondLevel()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1);
        populate();
        Date d = new Date();
        levelStart = d.getTime(); 
        fireSound1 = new GreenfootSound("MachineGunFire.wav");
        fireSound2 = new GreenfootSound("MachineGunFire2.wav");
    }
    
    public void populate(){
        //Sandbags
        
        Sandbag sb2 = new Sandbag(true);
        addObject(sb2, 550, 150);
        Sandbag sb22 = new Sandbag(true);
        addObject(sb22, 550, 120);
        Sandbag sb222 = new Sandbag(true);
        addObject(sb222, 550, 100);
        Sandbag sb4 = new Sandbag(true);
        addObject(sb4, 350, 250);
         Sandbag sb44 = new Sandbag(true);
        addObject(sb44, 350, 220);
       
       
        BarbedWire bw1 = new BarbedWire();
        addObject(bw1, 350, 450);
        BarbedWire bw2 = new BarbedWire();
        addObject(bw2, 350, 520);
        //Winston
        winst = new WinstonCrowley();
        this.addHuman(winst, 130, 450);
        //British
        //Machine Guns
        brit1 = new BritNPC(false);
        BritNPC brit2 = new BritNPC(false);
      
       Flag g = new Flag("German");
        this.addObject(g,976, 225);
       this.addHuman(brit2, 300, 210);
       this.addHuman(brit1, 480, 140);
        brit1.isDucking = true;
        brit2.isDucking = true;
       gun1 = new MountedMachineGun(875,0,this.getHeight());
       this.addHuman(gun1, 875, 110);
       gun2 = new MountedMachineGun(890,0,0);
       this.addHuman(gun2, 890, 400);
       
       CrossHair crosshair = new CrossHair();
       this.addObject(crosshair,0,0);
       
        FadingDialogue f = new FadingDialogue(512, 50, "1916 France, Battle of Verdun", 10, 10);
        addObject(f, 512, 50);
       super.populate();
        FadingDialogue z = new FadingDialogue(512, 50, "Bloody hell Winston, help us out!\nTake out the machine gunners", 10, 10);
        addObject(z, 500, 200);
    }
    
    public void act() {
        super.act();
        Date d = new Date(); 
        alive = getObjects(MountedMachineGun.class);
        updateMusic();
        if(winst.getX() > 800 && alive.size() ==0)
           this.TutorialWin();
           
        if (d.getTime() - levelStart > 10000 && !guyCharges) {
            guyCharges = true; 
            FadingDialogue f = new FadingDialogue(480, 100, "I can't stand it....Charge!!!", 10, 10);
            addObject(f, 480, 100);
            brit1.isDucking = false;
            brit1.setLocation(brit1.getX(), brit1.getY()+1);
        }
        
        if (d.getTime() - levelStart > 20000 && !talkFlag) {
            talkFlag = true;
             FadingDialogue z = new FadingDialogue(480, 100, "Try flanking north!", 10, 10);
            addObject(z, 300, 200);
        }
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

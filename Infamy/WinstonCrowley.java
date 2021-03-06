import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.*;
/**
 * Write a description of class WinstonCrowley here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinstonCrowley extends British
{
    private final int SHOOT_RANGE = 500;
    private final int[] xLoc = {250, 275, 300, 325, 350};
    private final int yLoc = 550;  
    private int runTimer = 0;
    private boolean loaded = true;
    private int lastShot = 0;
    private int shootSpeed = 20;
    private int reloadClock = 0;
    private int reload = 100;
    private int magazineRemaining = 5;
    private int landMineTimer = 0;
    private HealthBar insanityBar;
    public boolean firstLoad = true;
    private ArrayList<GreenfootImage> runningImages;
    Dialogue reloadDialogue = new Dialogue();
    private ArrayList<Landmine> landmines;
    private boolean hasBomb = false; 
    private GreenfootImage ammoCount; 
    private int stress = 0;
    private StressBar stressBar;
    private Direction lastDir = Direction.EAST;
    private int idleCount = 50;
    
    
    public WinstonCrowley()
    {
        Landmine landmine1 = new Landmine();
        Landmine landmine2 = new Landmine();
        Landmine landmine3 = new Landmine();
        landmines = new ArrayList<Landmine>();
        landmines.add(landmine1);
        landmines.add(landmine2);
        landmines.add(landmine3);
        
    }
    
    /**
     * Act - do whatever the WinstonCrowley wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void giveBomb() {
        hasBomb = true;
    }
    
    public void plantBomb() {
        if (Greenfoot.isKeyDown("e") && getWorld() instanceof BombTheBase &&
         getOneIntersectingObject(XMarks.class) != null) {
            ((BombTheBase)getWorld()).bombIsPlanted(); 
            hasBomb = false; 
        }
    }
    
    
    public boolean inRange() {
        ArrayList<Actor> germans = (ArrayList<Actor>)getObjectsInRange(SHOOT_RANGE, German.class);
        return !germans.isEmpty(); 
    }
    
    public void increaseStress(int amount) {
        if (stress + amount < 100){
            stress += amount;
        } else {
            stress = 100;
        }
    }
    
    public void setStress(int amount) {
        stress = amount;
    }
    
    public int getStress() {
        return stress;
    }
    
  
    
    public void createStressBar() {
        stressBar = new StressBar(this);
        this.getWorld().addObject(stressBar,getX(),getY() - getImage().getHeight()/2 - 11);
    }
    
    public void act() 
    {   
        
        
        setCovered(Greenfoot.isKeyDown("c") && isInTrench());
        plantBomb();
        
        if (Greenfoot.mouseClicked(null) && loaded && lastShot / shootSpeed > 0 && !hasBomb && !isCovered()) {
            increaseStress(5);
            if(--magazineRemaining == 0){
               reloadClock = 0;
               loaded = false;
            }
            
          
            lastShot = 0;
            MouseInfo info = Greenfoot.getMouseInfo();
            Greenfoot.playSound("gunFire.mp3");
            getWorld().addObject(new Bullet(this, info.getX(), info.getY()), 
            this.getX() + this.getImage().getWidth()/2 + 10, this.getY() - 10);
        }else if(!loaded){
            if(reloadClock / reload > 0) {
                loaded = true;
                magazineRemaining = 5;
                
            } else {
                reloadClock++;
            }
        } else {
            lastShot++;
        }
        
        
        
        if(!loaded) {
             GreenfootImage reloadMessage = new GreenfootImage("Reloading", 30
                                    , Color.WHITE, new Color(0,0,0,Color.TRANSLUCENT));
             reloadDialogue.setImage(reloadMessage);
             this.getWorld().addObject(reloadDialogue, 50, this.getWorld().getHeight() - 50);
        } else {
             this.getWorld().removeObject(reloadDialogue);
             
        }
        
        if(move())
        {
            if(dir == Direction.NORTH || dir == Direction.SOUTH)
            {
                dir = lastDir;
            }
            runTimer++;
            idleCount = 50;
            if (runTimer==24)
            {
                if (dir == Direction.EAST)
                {
                    setImage("winston-running-right-4.png");
                    lastDir = Direction.EAST;
                }
                else
                {
                    setImage("winston-running-right-4.png");
                    getImage().mirrorHorizontally();
                    lastDir = Direction.WEST;
                }
                runTimer=0;  
            }

            if (runTimer==0 ) 
            {
                if (dir == Direction.EAST)
                {
                    if (!hasBomb)
                    setImage("winston-running-right-1.png");
                    else setImage("wbr1.png"); 
                    lastDir = Direction.EAST;
                }else
                {
                    if (!hasBomb)
                    setImage("winston-running-right-1.png");
                    else setImage("wbr1.png"); 
                    getImage().mirrorHorizontally();                
                    lastDir = Direction.WEST;
                }
            }
            if (runTimer==8) 
            {
                if (dir == Direction.EAST)
                {
                    if (!hasBomb)
                    setImage("winston-running-right-2.png");
                    else setImage("wbr2.png"); 
                    lastDir = Direction.EAST;
                }
                else
                {
                    if (!hasBomb)
                    setImage("winston-running-right-2.png");
                    else setImage("wbr2.png"); 
                    getImage().mirrorHorizontally();               
                    lastDir = Direction.WEST;
                }
            } 
            if (runTimer==16) 
            {
                if (dir == Direction.EAST)
                {
                    if (!hasBomb)
                    setImage("winston-running-right-3.png");
                    else setImage("wbr1.png"); 
                    lastDir = Direction.EAST;
                }
                else
                {
                    if (!hasBomb)
                    setImage("winston-running-right-3.png");
                    else setImage("wbr1.png"); 
                    getImage().mirrorHorizontally();            
                    lastDir = Direction.WEST;
                }
            }
        }
        else {
            if (!hasBomb)
            {
                idleCount++;
                if (idleCount < 200)
                    setImage("winston-aiming-right.png");
                else if (idleCount >= 200 && idleCount < 240)
                    setImage("winston-chilling-1.png");
                else if (idleCount >= 240 && idleCount < 280)
                    setImage("winston-chilling-2.png");
                else if (idleCount >= 280 && idleCount < 320)
                    setImage("winston-chilling-1.png");
                else if (idleCount >= 320)
                {
                    idleCount = 50;
                    setImage("winston-aiming-right.png");
                }
            }
            else 
            setImage("wbr1.png"); 
            lastDir = Direction.EAST;
        }
        if(isCovered()) {
            setImage("winston-crouching-right.png");
        }
        if (Greenfoot.isKeyDown("space") && Greenfoot.getKey() == null && landMineTimer > 300)
        {
            if (!landmines.isEmpty())
            {
                Landmine derp = landmines.get(0);
                derp.Active = true;                
                getWorld().addObject(derp, this.getX(), this.getY());
                landmines.remove(0);
                landMineTimer=0;
                if (!((HumanWorld)getWorld()).l1Gone)
                {
                    ((HumanWorld)getWorld()).removeObject(((HumanWorld)getWorld()).l1);
                    ((HumanWorld)getWorld()).l1Gone = true;
                }
                else if(!((HumanWorld)getWorld()).l2Gone)
                {
                    ((HumanWorld)getWorld()).removeObject(((HumanWorld)getWorld()).l2);
                    ((HumanWorld)getWorld()).l2Gone = true;
                }
                else
                {
                    ((HumanWorld)getWorld()).removeObject(((HumanWorld)getWorld()).l3);                    
                }
            }
        }
        landMineTimer++;
        d.ExecuteDialogueInteraction();
        applyDamageOverTime();
    }    
}

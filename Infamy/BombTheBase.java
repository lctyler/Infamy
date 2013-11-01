import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class BombTheBase here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombTheBase extends HumanWorld
{
    public final int BOMB_TIMER = 1000;
    public Dialogue dia;
    public Dialogue tutorialDiaIntro;
    public Dialogue tutorialDia;
    public int dialogueCounter;
    public int dialogueTimer;
    public Flag germanFlag;
    public Flag britishFlag;
  
    

    
    
    /**
     * Constructor for objects of class BombTheBase.
     * 
     */
    public BombTheBase()
    {    
        super(1024, 600, 1);
       
        dialogueTimer = 0;
        setBackground("Background.png");
        dialogueCounter = 0;
        populate();
        
        spawnWave(GERM, 2, false); 
        spawnWave(BRIT, 4, false); 
        spawnG = true;
        spawnB = true; 
        this.britAmmount = 4;
        this.britSpawn = 6000;
        this.germSpawn = 20000;
    }
    
    
  
    public void populate() {

        
       germanFlag = new Flag("German"); 
        addObject(germanFlag, 974, 245);
        germanFlag.winCond = false;
        
        britishFlag = new Flag("British"); 
        addObject(britishFlag, 50, 245); 
        

        EnemyNPC germanDefender1 = new EnemyNPC(true);
        addHuman(germanDefender1, 900, 400); 
        
        EnemyNPC germanDefender2 = new EnemyNPC(true); 
        addHuman(germanDefender2, 900, 100); 
        
        
       CrossHair crosshair = new CrossHair();
       addObject(crosshair, 0, 0);
        
       
       
       GasButton gb = new GasButton();
       addObject(gb, 512, 550);
         VolumeButton vb = new VolumeButton();
        addObject(vb, 450, 550);
       Sandbag sb2 = new Sandbag();
       //sb2.turn(90);
       addObject(sb2, 500, 400);
       Sandbag sb3 = new Sandbag();
       //sb3.turn(90);
       addObject(sb3, 300, 375);
       Sandbag sb4 = new Sandbag();
       //sb4.turn(90);
       addObject(sb4, 400, 190);

       //FadingDialogue f = new FadingDialogue(512, 50, "1912 France, 87th Infantry", 10, 10);
        //addObject(f, 512, 50);
       FadingDialogue g = new FadingDialogue(512, 480, "Plant the bomb in the base!!\n Move with AWSD as shoot with mouse1", 10, 10);
       addObject(g, 512, 480);

        BritNPC npc2 = new BritNPC(true);
        addHuman(npc2, 130, 400);
        BritNPC npc1 = new BritNPC(true);
        addHuman(npc1, 130, 100);
        
        WinstonCrowley move = new WinstonCrowley();
        addHuman(move, 95, 500);
        move.giveBomb(); 
        
       x = new XMarks(); 
        
        addObject(x, 900, 245);
        
        Date d  = new Date();
        
        if (bombPlanted && d.getTime() - t1 > 10000) {
            bombExplodes();
            
        }
   
        
        
    }
    
    
    
    public void bombIsPlanted() {
        FadingDialogue f = new FadingDialogue(512, 50, "Bomb is planted.. Get out of there now!", 10, 10);
        addObject(f, 512, 50);
        Date d = new Date();
        t1 = d.getTime(); 
        bombPlanted = true;
        
    }
}

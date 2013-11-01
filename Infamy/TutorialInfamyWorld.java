import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.*;
/**
 * Write a description of class InfamyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialInfamyWorld extends HumanWorld
{

   
    public Dialogue dia;
    public Dialogue tutorialDiaIntro;
    public Dialogue tutorialDia;
    public int dialogueCounter;
    public int dialogueTimer;
   

    
    /**
     * Constructor for objects of class InfamyWorld.
     * 
     */
    public TutorialInfamyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super(1024, 600, 1);
       
        dialogueTimer = 0;
        setBackground("Background.png");
        dialogueCounter = 0;
        populate();
        
        spawnWave(GERM, NUM_ADVANCERS, false); 
        spawnWave(BRIT, NUM_ADVANCERS, false); 
        spawnG = true;
        spawnB = true;        
    }
  
    public void populate() {

        super.populate();
        Flag germanFlag = new Flag("german"); 
        addObject(germanFlag, 974, 245);
        
        Flag britishFlag = new Flag("British"); 
        addObject(britishFlag, 50, 245); 
        

        EnemyNPC germanDefender1 = new EnemyNPC(true);
        addHuman(germanDefender1, 900, 400); 
        
        EnemyNPC germanDefender2 = new EnemyNPC(true); 
        addHuman(germanDefender2, 900, 100); 
        

       CrossHair crosshair = new CrossHair();
       addObject(crosshair, 0, 0);
        
       Sandbag sb1 = new Sandbag();
       //sb1.turn(90);
       addObject(sb1, 600, 130);
       
       GasButton gb = new GasButton();
       addObject(gb, 512, 550);

       Sandbag sb2 = new Sandbag();
       //sb2.turn(90);
       addObject(sb2, 500, 400);
       Sandbag sb3 = new Sandbag();
       //sb3.turn(90);
       addObject(sb3, 300, 375);
       Sandbag sb4 = new Sandbag();
       //sb4.turn(90);
       addObject(sb4, 400, 190);

       FadingDialogue f = new FadingDialogue(512, 50, "1912 France, 87th Infantry", 10, 10);
        addObject(f, 512, 50);
       FadingDialogue g = new FadingDialogue(512, 480, "Kill all the enemies and capture the flag!!\n Move with AWSD as shoot with mouse1", 10, 10);
       addObject(g, 512, 480);

        BritNPC npc2 = new BritNPC(true);
        addHuman(npc2, 130, 400);
        BritNPC npc1 = new BritNPC(true);
        addHuman(npc1, 130, 100);
        
        WinstonCrowley move = new WinstonCrowley();
        addHuman(move, 95, 500);
    }
}
    
  

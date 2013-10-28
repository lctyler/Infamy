import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.*;
/**
 * Write a description of class InfamyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialInfamyWorld extends World
{
    public final int NUM_ADVANCERS = 3;
    public final String BRIT = "british"; 
    public final String GERM = "german"; 
    public final int BRIT_X = 200; 
    public final int GERM_X = 750; 
    public final int[] Y_SET = {135, 235, 335}; 
   
    public Dialogue dia;
    public Dialogue tutorialDiaIntro;
    public Dialogue tutorialDia;
    public int dialogueCounter;
    public ArrayList<Human> GermanAdvancers, BritAdvancers; 
    public int bCounter, gCounter;
    public long baseTimeG, baseTimeB;
    public boolean spawnG, spawnB; 
    /**
     * Constructor for objects of class InfamyWorld.
     * 
     */
    public TutorialInfamyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1);
        populate();
        setBackground("Background.png");
        dialogueCounter = 0;
        AddTutorialDialogue("Hey Winston!!\nCome over here!", 200, 300, false);
        AddTutorialDialogue("Talk to your fellow soldier and\nother NPC's by pressing the 'e' key.\nMove Winston with the 'wasd' keys.", 400, 100, true);
        bCounter = gCounter = 0;
        spawnWave(GERM, NUM_ADVANCERS, false); 
        spawnWave(BRIT, NUM_ADVANCERS, false); 
        spawnG = false;
        spawnB = false;
        
    }
    public void decBCounter() {
        bCounter--;
    }
    
    public void decGCounter() {
        gCounter--;
    }
    
    public void spawnWave(String type, int ammount, boolean rand) {
        for (int i = 0; i < ammount; i++) {
            if (type.equals(BRIT)) {
               BritNPC adv = new BritNPC(false); 
               addObject(adv, BRIT_X, Y_SET[i]);
               bCounter++; 
              
            }
            else {
                EnemyNPC adv = new EnemyNPC(false);
                addObject(adv, GERM_X, Y_SET[i]);
                gCounter++; 
            }
        }
        
    }
    
    
    public void act() {
        Date d  = new Date();
        
        if ((d.getTime() - baseTimeB) > 10000 ) {
           spawnB = true;
        }
        if ((d.getTime() - baseTimeG) > 10000 ) {
           spawnG = true; 
        }
        System.out.println("B: " + bCounter + " G: " + gCounter); 
        
        if(spawnB && bCounter == 0) {
            spawnWave(BRIT, 1, true);
            spawnB = false;
            baseTimeB = d.getTime(); 
        }
        
        if (spawnG && gCounter == 0) {
            spawnWave(GERM, 1, true);
            spawnG = false;
            baseTimeG = d.getTime(); 
        }
    }
    
    public void populate() {

        
        Flag germanFlag = new Flag("german"); 
        addObject(germanFlag, 900, 245);
        
        Flag britishFlag = new Flag("British"); 
        addObject(britishFlag, 130, 245); 
        

        EnemyNPC germanDefender1 = new EnemyNPC(true);
        addObject(germanDefender1, 900, 400); 
        
        EnemyNPC germanDefender2 = new EnemyNPC(true); 
        addObject(germanDefender2, 900, 100); 
        

       CrossHair crosshair = new CrossHair();
       addObject(crosshair, 0, 0);
        
       Sandbag sb1 = new Sandbag();
       addObject(sb1, 600, 130);

        

        BritNPC npc2 = new BritNPC(true);
        addObject(npc2, 130, 400);
        BritNPC npc1 = new BritNPC(true);
        addObject(npc1, 130, 100);
        
        WinstonCrowley move = new WinstonCrowley();
        addObject(move, 95, 500);
    }
    
    public void RemoveDialogueBoxes()
    {
        removeObject(dia);
        dialogueCounter = 0;
    }
    /**
     * Try to add in the bullet here. Call from 
     */
    public void addBullet(Actor source, Actor target) {
        addObject(new Bullet(source, target), source.getX(), source.getY()); 
        
    }
    
    public void AddDialogueBox(String message, int x, int y)
    {
        if (dialogueCounter == 0)
        {
            dia = new Dialogue();
            GreenfootImage textImage = new GreenfootImage(message, 24, Color.BLACK, Color.WHITE);
            textImage.drawString(message, x, y);
            
            GreenfootImage image = new GreenfootImage(textImage.getWidth()+12, textImage.getHeight()+12);  
            image.setColor(Color.RED);  
            image.fill();  
            image.setColor(Color.WHITE);  
            image.fillRect(3, 3, image.getWidth()-6, image.getHeight()-6);  
            image.drawImage(textImage, 6, 6);
            dia.setImage(image);
            addObject(dia, x, y);
            dialogueCounter = 1;
        }
        removeObject(tutorialDia);
        removeObject(tutorialDiaIntro);
    }
    
    public void TutorialWin()
    {
        //System.out.println("Winning");
        Greenfoot.setWorld(new FirstLevel());
    }
    
    private void AddTutorialDialogue(String message, int x, int y, boolean intro)
    {
        if (intro)
        {
            tutorialDiaIntro = new Dialogue();
        }
        else
        {
            tutorialDia = new Dialogue();
        }
        GreenfootImage textImage = new GreenfootImage(message, 24, Color.BLACK, Color.WHITE);
        textImage.drawString(message, x, y);
        
        GreenfootImage image = new GreenfootImage(textImage.getWidth()+12, textImage.getHeight()+12);  
        image.setColor(Color.RED);  
        image.fill();  
        image.setColor(Color.WHITE);  
        image.fillRect(3, 3, image.getWidth()-6, image.getHeight()-6);  
        image.drawImage(textImage, 6, 6);
        
        if (intro)
        {
            tutorialDiaIntro.setImage(image);
            addObject(tutorialDiaIntro, x, y);
        }
        else
        {
            tutorialDia.setImage(image);
            addObject(tutorialDia, x, y);
        }
        
        
        dialogueCounter = 1;
    }
}

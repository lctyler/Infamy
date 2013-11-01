import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
/**
 * Write a description of class HumanWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HumanWorld extends World
{
    protected int bCounter,gCounter;
    public final int NUM_ADVANCERS_3 = 3;
    public final int NUM_ADVANCERS_4 = 4; 
    public final String BRIT = "british"; 
    public final String GERM = "german"; 
    public final int BRIT_X = 200; 
    public final int GERM_X = 750; 
    public final int[] Y_SET = {115, 225, 335, 455, 500}; 
    public boolean bombPlanted = false; 
    
    
    public Dialogue dia;
    public Dialogue tutorialDiaIntro;
    public Dialogue tutorialDia;
    public int dialogueCounter;
    public int dialogueTimer;
    public int britAmmount = 1;
    public int germAmmount = 2;
    public long baseTimeG, baseTimeB;
    public boolean spawnG, spawnB; 
    public GreenfootSound bgMusic ;
    public boolean playmusic = true;
    public int germSpawn = 10000;
    public int britSpawn = 12000;
    public long t1, t2; 
    public XMarks x;
    
    
  
    
    /**
     * Constructor for objects of class HumanWorld.
     * 
     */
    public HumanWorld(int width, int height, int pixels)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, pixels); 
        bCounter = gCounter = 0;
    }
    
    public void addHuman(Human person, int x, int y){
        addObject(person, x, y);
        person.createHealthBar();
        if(person instanceof WinstonCrowley){
            ((WinstonCrowley)person).createStressBar();
        }
    }
    
    public void decBCounter() {
        bCounter--;
    }
    
    public void decGCounter() {
        gCounter--;
    }
    
    
    public void defeat() {
        int count = getObjects(BritNPC.class).size();
        Human.Score += count * 50;
        Human.Score += 500;
        Greenfoot.setWorld(new DefeatWorld(Human.Score));
    }
    
      public void TutorialWin()
    {
        int count = getObjects(BritNPC.class).size();
        Human.Score += count * 50;
        Human.Score += 500;         
        
        if (this instanceof TutorialInfamyWorld ) {
            Greenfoot.setWorld(new CutSceneToSecondLevel());
        }
        else if (this instanceof SecondLevel) {
            Greenfoot.setWorld(new WinWorld(Human.Score)); 
        } 
         else if (this instanceof BombTheBase) {
            Greenfoot.setWorld(new WinWorld(Human.Score)); 
        } 
    } 
    
    
    /**
     * Try to add in the bullet here. Call from 
     */
    public void addBullet(Actor source, Actor target) {
        addObject(new Bullet(source, target), source.getX(), source.getY()); 
    }
    
    public void addBullet(Actor source, int targetx, int targety){
        addObject(new Bullet(source, targetx, targety), source.getX(), source.getY());
    }
    
    public void addItem(Actor item, int x , int y) {
        addObject(item, x, y);
    }
    
    public void removeItem(Actor item) {
        removeObject(item); 
    }


 public void spawnWave(String type, int ammount, boolean rand) {
      
    //int x  = Greenfoot.getRandomNumber(2);
    int x = 0;
    for (int i = 0; i < ammount; i++) {
        x = i;
        if (type.equals(BRIT)) {
           BritNPC adv = new BritNPC(false); 
           addHuman(adv, BRIT_X, Y_SET[x]);
           bCounter++; 
          
        }
        else {
            EnemyNPC adv = new EnemyNPC(false);
            addHuman(adv, GERM_X, Y_SET[x]);
            gCounter++; 
        }
    }
        
 }
 
 public void toggleSound(boolean volumeOn) {
        
   
       if (volumeOn) {
           bgMusic.play(); 
        }
        else {
           bgMusic.pause(); 
        }
    }
    
     public void playMusic() {
        if (playmusic) {
           bgMusic = new GreenfootSound("FiveArmies.mp3"); 
           bgMusic.play();
           playmusic = false;
        }
        
    }
    
 public void act() {
        Date d  = new Date();
        playMusic(); 
        dialogueTimer++;
        if (dialogueTimer == 500)
        {
            removeObject(tutorialDia);
        }
        if ((d.getTime() - baseTimeB) > britSpawn ) {
           spawnB = true;
        }
        if ((d.getTime() - baseTimeG) > germSpawn ) {
           spawnG = true; 
        }
       
      
        if(spawnB && bCounter == 0) {
            spawnWave(BRIT,britAmmount, true);
            spawnB = false;
            baseTimeB = d.getTime(); 
        }
        
        if (spawnG && gCounter == 0) {
            spawnWave(GERM, germAmmount, true);
            spawnG = false;
            baseTimeG = d.getTime(); 
        }
        
        if (bombPlanted && d.getTime() - t1 > 10000) {
            bombExplodes();
            
        }
   }
   
    public void RemoveDialogueBoxes()
    {
        removeObject(dia);
        dialogueCounter = 0;
    }
    public void bombExplodes() {
        List<Human> inRange = x.getPeopleToKill();
        for (Human h : inRange) {
            h.die();
        }
        this.TutorialWin();
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
    
    protected void AddTutorialDialogue(String message, int x, int y, boolean intro)
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
   

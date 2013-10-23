import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class InfamyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InfamyWorld extends World
{
    public Dialogue dia;
    public Dialogue tutorialDia;
    public int dialogueCounter;
    /**
     * Constructor for objects of class InfamyWorld.
     * 
     */
    public InfamyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        populate();
        setBackground("Tutorial-BG-working-nochar.png");
        dialogueCounter = 0;
        AddTutorialDialogue("Enemies are coming!\nTalk to your fellow soldier and\nother NPC's by pressing the 'e' key.\nMove Winston with the 'wasd' keys.", 400, 100);
    }
    
    public void populate()
    {        
        WinstonCrowley move = new WinstonCrowley();
        addObject(move, 95, 500);        
        
        NPC npc = new NPC("TutorialNPC");
        addObject(npc, 90, 300);
        
        NPC npc1 = new NPC("TutorialNPC");
        addObject(npc1, 90, 100);
        
       
        
        Flag germanFlag = new Flag("german"); 
        addObject(germanFlag, 700, 245);
        
        Flag britishFlag = new Flag("British"); 
        addObject(britishFlag, 90, 200); 
        
        Enemy german = new Enemy();
        addObject(german, 700, 400); 
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
    }
    
    private void AddTutorialDialogue(String message, int x, int y)
    {
        tutorialDia = new Dialogue();
        GreenfootImage textImage = new GreenfootImage(message, 24, Color.BLACK, Color.WHITE);
        textImage.drawString(message, x, y);
        
        GreenfootImage image = new GreenfootImage(textImage.getWidth()+12, textImage.getHeight()+12);  
        image.setColor(Color.RED);  
        image.fill();  
        image.setColor(Color.WHITE);  
        image.fillRect(3, 3, image.getWidth()-6, image.getHeight()-6);  
        image.drawImage(textImage, 6, 6);
        tutorialDia.setImage(image);
        addObject(tutorialDia, x, y);
        dialogueCounter = 1;
    }
}

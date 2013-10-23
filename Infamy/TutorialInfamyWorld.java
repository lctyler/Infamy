import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class InfamyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialInfamyWorld extends World
{
    public Dialogue dia;
    public Dialogue tutorialDiaIntro;
    public Dialogue tutorialDia;
    public int dialogueCounter;
    /**
     * Constructor for objects of class InfamyWorld.
     * 
     */
    public TutorialInfamyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        populate();
        setBackground("Tutorial-BG-working-nochar.png");
        dialogueCounter = 0;
        AddTutorialDialogue("Hey Winston!!\nCome over here!", 200, 300, false);
        AddTutorialDialogue("Talk to your fellow soldier and\nother NPC's by pressing the 'e' key.\nMove Winston with the 'wasd' keys.", 400, 100, true);
    }
    
    public void populate()
    {        
        WinstonCrowley move = new WinstonCrowley();
        addObject(move, 95, 500);        
        
        NPC npc = new NPC("TutorialNPC");
        addObject(npc, 90, 300);
        
        NPC npc1 = new NPC("TutorialNPC");
        addObject(npc1, 90, 100);
        
        NPC npc2 = new NPC("TutorialNPC");
        addObject(npc2, 90, 200);
        
        XMarksTheSpot xSpot = new XMarksTheSpot();
        addObject(xSpot, 500, 300);
    }
    
    public void RemoveDialogueBoxes()
    {
        removeObject(dia);
        dialogueCounter = 0;
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
        //Greenfoot.setWorld(new World());
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

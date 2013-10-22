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
    }
    
    public void populate()
    {        
        WinstonCrowley move = new WinstonCrowley();
        addObject(move, 400, 300);        
        
        NPC npc = new NPC("NPC");
        addObject(npc, 100, 300);       
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
    }
}

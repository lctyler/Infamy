import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class DefeatWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DefeatWorld extends World
{
    Dialogue score;
    /**
     * Constructor for objects of class DefeatWorld.
     * 
     */
    public DefeatWorld(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1); 
        AddScoreDialogue("Your Score:" + score, 512, 400);
    }
    
    private void AddScoreDialogue(String message, int x, int y)
    {

        score = new Dialogue();
    
        GreenfootImage textImage = new GreenfootImage(message, 56, Color.BLACK, Color.WHITE);
        textImage.drawString(message, x, y);
        
        GreenfootImage image = new GreenfootImage(textImage.getWidth()+12, textImage.getHeight()+12);  
        image.setColor(Color.BLACK);  
        image.fill();  
        image.setColor(Color.WHITE);  
        image.fillRect(3, 3, image.getWidth()-6, image.getHeight()-6);  
        image.drawImage(textImage, 6, 6);
        
        score.setImage(image);
        addObject(score, x, y);
        
    }
}

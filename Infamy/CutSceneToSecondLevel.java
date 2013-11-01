import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class CutSceneToSecondLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CutSceneToSecondLevel extends World
{
    private Dialogue dia;
    private Dialogue dial;
    private Dialogue diaCutscene;
    private Dialogue backgroundDia;
    private int cutscene;
    /**
     * Constructor for objects of class CutSceneToSecondLevel.
     * 
     */
    public CutSceneToSecondLevel()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1);
        Cutscene();
        setBackground("insaneAsylum.jpg");
        cutscene = 1;
    }
    
    public void act()
    {
        if (cutscene == 2 && Greenfoot.mousePressed(null))
        {
            Greenfoot.setWorld(new SecondLevel());
        }
        if (cutscene == 1 && Greenfoot.mousePressed(null))
        {
            Cutscene2();
            cutscene = 2;
        }
        
    }
    
    public void Cutscene2()
    {
        backgroundDia = new Dialogue();
        GreenfootImage background = new GreenfootImage(1024,100);
        background.fillRect(0,0, 1024, 100);
        backgroundDia.setImage(background);
        addObject(backgroundDia, 512, 550);
        diaCutscene = new Dialogue();
        GreenfootImage textImage = new GreenfootImage("Nurse: Unfortunantely we cannot stop now we must continue to help you get better!", 32, Color.WHITE, Color.BLACK);
        
        
        GreenfootImage image = new GreenfootImage(textImage.getWidth()+12,textImage.getHeight()+12);  
        image.setColor(Color.BLACK);  
        image.drawImage(textImage, 0, 0);
        diaCutscene.setImage(image);
        addObject(diaCutscene, 512, 550);
    }
    
    public void Cutscene()
    {
        backgroundDia = new Dialogue();
        GreenfootImage background = new GreenfootImage(1024,100);
        background.fillRect(0,0, 1024, 100);
        backgroundDia.setImage(background);
        addObject(backgroundDia, 512, 550);
        diaCutscene = new Dialogue();
        GreenfootImage textImage = new GreenfootImage("Nurse: ...Oh my this sounds very dreadful Mr. Winston...", 32, Color.WHITE, Color.BLACK);
        
        
        GreenfootImage image = new GreenfootImage(textImage.getWidth()+12,textImage.getHeight()+12);  
        image.setColor(Color.BLACK);  
        image.drawImage(textImage, 0, 0);
        diaCutscene.setImage(image);
        addObject(diaCutscene, 512, 550);
    }
}

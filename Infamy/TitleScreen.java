import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    private Dialogue dia;
    private Dialogue dial;
    private GreenfootSound titleMusic;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {
        super(1024, 600, 1);
        AddButtons();
        titleMusic = new GreenfootSound("titleScreen.mp3");
    }
    
    public void act()
    {
        if (!titleMusic.isPlaying())
        {
            titleMusic.play();
        }
        if(Greenfoot.mouseClicked(dia))
        {
            Greenfoot.setWorld(new TutorialInfamyWorld());
            titleMusic.stop();
        }
        if(Greenfoot.mouseClicked(dial))
        {
            Greenfoot.setWorld(new InstructionScreen());
        }
    }
    
    public void AddButtons()
    {
        dia = new Dialogue();
        GreenfootImage textImage = new GreenfootImage("Enter Battle", 56, Color.BLACK, new Color(109, 128, 61));
        textImage.drawString("Enter Battle", 512, 300);
        
        GreenfootImage image = new GreenfootImage(textImage.getWidth()+12, textImage.getHeight()+12);  
        image.setColor(new Color(109, 128, 61));  
        image.fill();  
        image.setColor(Color.BLACK);  
        image.fillRect(3, 3, image.getWidth()-6, image.getHeight()-6);  
        image.drawImage(textImage, 6, 6);
        dia.setImage(image);
        addObject(dia, 512, 300);
        
        //Instructions Button
        dial = new Dialogue();
        GreenfootImage textImager = new GreenfootImage("Instructions", 56,  new Color(109, 128, 61), Color.BLACK);
        textImager.drawString("Enter Battle", 512, 300);
        
        GreenfootImage imager = new GreenfootImage(textImager.getWidth()+12, textImager.getHeight()+12);  
        imager.setColor(Color.BLACK);  
        imager.fill();  
        imager.setColor(new Color(109, 128, 61));  
        imager.fillRect(3, 3, imager.getWidth()-6, imager.getHeight()-6);  
        imager.drawImage(textImager, 6, 6);
        dial.setImage(imager);
        addObject(dial, 512, 450);
    }
}

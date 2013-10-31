import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
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
    private Dialogue diaCutscene;
    private Dialogue backgroundDia;
    private GreenfootSound titleMusic;
    private int cutscene;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {
        super(1024, 600, 1);
        AddButtons();
        titleMusic = new GreenfootSound("titleScreen.mp3");
        cutscene = 0;
    }
    
    public void act()
    {
        if (!titleMusic.isPlaying())
        {
            titleMusic.play();
        }
        if(Greenfoot.mouseClicked(dia))
        {
            removeObject(dia);
            removeObject(dial);
            setBackground("nurses.jpg");
            Cutscene();
            cutscene = 1;
            
        }
        if(cutscene == 3 && Greenfoot.mousePressed(null))
        {
            Greenfoot.setWorld(new TutorialInfamyWorld());
            titleMusic.stop();
        }
        if(Greenfoot.mouseClicked(dial))
        {
            Greenfoot.setWorld(new InstructionScreen());
        }
        if (cutscene == 2 && Greenfoot.mousePressed(null))
        {
            Cutscene3();
            cutscene=3;
        }
        if (cutscene == 1 && Greenfoot.mousePressed(null))
        {
            Cutscene2();
            cutscene = 2;
        }
        
    }
    public void Cutscene3()
    {
        backgroundDia = new Dialogue();
        GreenfootImage background = new GreenfootImage(1024,300);
        background.fillRect(0,0, 1024, 300);
        backgroundDia.setImage(background);
        addObject(backgroundDia, 512, 500);
        
        
        diaCutscene = new Dialogue();
        GreenfootImage textImage = new GreenfootImage("Nurse: In order for you to move beyond the horrors of your past, you must face your memories.", 32, Color.WHITE, Color.BLACK);
                
        GreenfootImage image = new GreenfootImage(textImage.getWidth()+12,textImage.getHeight()+12);  
        image.setColor(Color.BLACK);  
        image.drawImage(textImage, 0, 0);
        diaCutscene.setImage(image);
        addObject(diaCutscene, 512, 400);
        
        
        dia = new Dialogue();
        GreenfootImage textImager = new GreenfootImage("Can you take me through your most troublesome memories from the battlefield?", 32, Color.WHITE, Color.BLACK);
                
        GreenfootImage imager = new GreenfootImage(textImager.getWidth()+12,textImager.getHeight()+12);  
        imager.setColor(Color.BLACK);  
        imager.drawImage(textImager, 0, 0);
        dia.setImage(imager);
        addObject(dia, 512, 450);
    }
    public void Cutscene2()
    {
        backgroundDia = new Dialogue();
        GreenfootImage background = new GreenfootImage(1024,300);
        background.fillRect(0,0, 1024, 300);
        backgroundDia.setImage(background);
        addObject(backgroundDia, 512, 500);
        
        
        diaCutscene = new Dialogue();
        GreenfootImage textImage = new GreenfootImage("Nurse: It was 1916 when you first entered the Great War… ", 32, Color.WHITE, Color.BLACK);
                
        GreenfootImage image = new GreenfootImage(textImage.getWidth()+12,textImage.getHeight()+12);  
        image.setColor(Color.BLACK);  
        image.drawImage(textImage, 0, 0);
        diaCutscene.setImage(image);
        addObject(diaCutscene, 512, 400);
        
        
        dia = new Dialogue();
        GreenfootImage textImager = new GreenfootImage("The horrors you witnessed and committed have taken a serious toll on your mental health…", 32, Color.WHITE, Color.BLACK);
                
        GreenfootImage imager = new GreenfootImage(textImager.getWidth()+12,textImager.getHeight()+12);  
        imager.setColor(Color.BLACK);  
        imager.drawImage(textImager, 0, 0);
        dia.setImage(imager);
        addObject(dia, 512, 450);
        
        
        
        dial = new Dialogue();
        GreenfootImage textImagel = new GreenfootImage("Now you are living in a psychiatric care hospital in London to aid your PTSD…", 32, Color.WHITE, Color.BLACK);
                
        GreenfootImage imagel = new GreenfootImage(textImagel.getWidth()+12,textImagel.getHeight()+12);  
        imagel.setColor(Color.BLACK);  
        imagel.drawImage(textImagel, 0, 0);
        dial.setImage(imagel);
        addObject(dial, 512, 500);
        

    }
    
    public void Cutscene()
    {
        backgroundDia = new Dialogue();
        GreenfootImage background = new GreenfootImage(1024,300);
        background.fillRect(0,0, 1024, 300);
        backgroundDia.setImage(background);
        addObject(backgroundDia, 512, 500);
        diaCutscene = new Dialogue();
        GreenfootImage textImage = new GreenfootImage("Nurse: ...Alright let’s review your trauma history...", 32, Color.WHITE, Color.BLACK);
        
        
        GreenfootImage image = new GreenfootImage(textImage.getWidth()+12,textImage.getHeight()+12);  
        image.setColor(Color.BLACK);  
        image.drawImage(textImage, 0, 0);
        diaCutscene.setImage(image);
        addObject(diaCutscene, 512, 400);
    }
    
    public void AddButtons()
    {
        dia = new Dialogue();
        GreenfootImage textImage = new GreenfootImage("Enter Battle", 56, Color.BLACK, new Color(109, 128, 61));
        
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

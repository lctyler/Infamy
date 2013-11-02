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
    Dialogue crazy;
    Dialogue diaCutscene;
    int ActualScore;
    /**
     * Constructor for objects of class DefeatWorld.
     * 
     */
    public DefeatWorld(int scor)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1);
        ActualScore = scor;
        CutsceneStory();        
    }
    
    public void act()
    {
        if(Greenfoot.mousePressed(null))
        {
            removeObject(diaCutscene);
            setBackground("defeat-screen.png");
            AddScoreDialogue("Your Score:" + ActualScore, 512, 400);
            if (ActualScore < 500) {
                AddCrazyDialogue();
                Greenfoot.playSound("crazyLaugh.mp3");
            }
        }
    }
    
    public void CutsceneStory()
    {
        setBackground("cutScene.png");
        
        diaCutscene = new Dialogue();
        GreenfootImage textImage = new GreenfootImage("I understand that this can be stressful,\nlets try this again tomorrow....", 32, Color.WHITE, new Color(50,50,50));
                
        GreenfootImage image = new GreenfootImage(textImage.getWidth()+12,textImage.getHeight()+12);  
        image.setColor(Color.BLACK);  
        image.drawImage(textImage, 0, 0);
        diaCutscene.setImage(image);
        addObject(diaCutscene, 270, 200);
    }
    
    private void AddCrazyDialogue()
    {
        crazy = new Dialogue();
    
        GreenfootImage textImage = new GreenfootImage("You went crazy from PTSD...", 48, Color.BLACK, Color.WHITE);
        //textImage.drawString(message, x, y);
        
        GreenfootImage image = new GreenfootImage(textImage.getWidth()+12, textImage.getHeight()+12);  
        image.setColor(Color.BLACK);  
        image.fill();  
        image.setColor(Color.WHITE);  
        image.fillRect(3, 3, image.getWidth()-6, image.getHeight()-6);  
        image.drawImage(textImage, 6, 6);
        
        crazy.setImage(image);
        addObject(crazy, 512, 300);
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

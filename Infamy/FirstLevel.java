import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class FirstLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FirstLevel extends World
{
    private GreenfootImage scrollImage;
    private int winstonPosX;
    private int winstonPosY;
    /**
     * Constructor for objects of class FirstLevel.
     * 
     */
    public FirstLevel()
    {
        super(800, 600, 1);
        scrollImage = new GreenfootImage("bigBackground.jpg");//1600X1200
        setBackground(scrollImage);
        winstonPosX = 200;
        winstonPosY = 300;
        //getBackground().drawImage(scrollImage, 0, 0);
        populate();
    }
    
    public void populate()
    {
        WinstonCrowley winst = new WinstonCrowley();
        addObject(winst, 200, 300);
        
        //EnemyNPC german = new EnemyNPC();
        //addObject(german, 700, 400);
        
        //Flag germanFlag = new Flag("german"); 
        //addObject(germanFlag, 700, 245);
        
        //Flag britishFlag = new Flag("British"); 
        //addObject(britishFlag, 90, 200);
    }
    
    public void act()
    {
        setBackground(new GreenfootImage(this.getWidth(), this.getHeight()));
        UpdateWorldMap();
    }
    
    public void UpdateWorldMap()
    {
        List<WinstonCrowley> list = getObjects(WinstonCrowley.class);
        WinstonCrowley winston = list.get(0);
        winstonPosX = winston.getX() + winstonPosX - 200;
        winstonPosY = winston.getY() + winstonPosY - 300;
        int x = 200 - winstonPosX;//winston.getX();
        int y = 300 - winstonPosY;//winston.getY();
        System.out.println(x + " " + y);
        getBackground().drawImage(scrollImage, x, y);
        //for(int i = 0; i < 1600; i++)
         //for (int j = 0; j < 300; j++)
            //getBackground().drawImage(scrollImage, i, j);
        winston.setLocation(200, 300);
        
    }
}

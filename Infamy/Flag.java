import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Flag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flag extends Actor
{
    public String nationality;    
   
    public Flag(String nationality) {
        this.nationality = nationality;
        if (nationality.equals("British")) {
            setImage("British Flag.png");
        }
        else {
            setImage("German Flag.png");
        }
            
    }
   
    
    /**
     * Act - do whatever the Flag wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      CheckTutorialWin();
    }
    
    public void CheckTutorialWin()
    {
        if (nationality.equals("British") && getOneIntersectingObject(German.class) != null) {
           ((HumanWorld)getWorld()).defeat();
        }
        else if (nationality.equals("German") && getOneIntersectingObject(British.class) != null) {
            ((HumanWorld)getWorld()).TutorialWin();
        }
    }
}

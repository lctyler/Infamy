import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class XMarksTheSpot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class XMarksTheSpot extends Dialogue
{
    /**
     * Act - do whatever the XMarksTheSpot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        CheckTutorialWin();
    }    
    
    private void CheckTutorialWin()
    {
        try
        {
            Actor actors = getOneIntersectingObject(java.lang.Class.forName("WinstonCrowley"));
            if (actors != null)
            {
                ((TutorialInfamyWorld)this.getWorld()).TutorialWin();
            }
        }
        catch (Exception e)
        {
        }
    }
}

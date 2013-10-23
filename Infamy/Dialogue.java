import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
/**
 * Write a description of class Dialogue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dialogue extends Movement
{
    /**
     * Act - do whatever the Dialogue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public void ExecuteDialogueInteraction()
    {
        try
        {
            List<NPC> neighbors = getNeighbours(60, true, java.lang.Class.forName("NPC"));
            if (neighbors.isEmpty())
            {
                ((TutorialInfamyWorld)this.getWorld()).RemoveDialogueBoxes();
            }
            else if (neighbors.get(0).Type.equals("TutorialNPC") && Greenfoot.isKeyDown("e"))
            {
                MakeMessage("Good Day laddy! Aim with your cursor and click to fire your weapon!\nTry it out on the incoming enemies! The goal of the tutorial is to beat\nthe other side and plant the British flag on the X!", 400, neighbors.get(0).getY());
            }
        }
        catch (Exception e)
        {
        }
    }
    
    public void MakeMessage(String message, int x, int y)
    {        
        ((TutorialInfamyWorld)this.getWorld()).AddDialogueBox(message, x, y);
    }
}

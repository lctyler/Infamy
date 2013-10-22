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
                ((InfamyWorld)this.getWorld()).RemoveDialogueBoxes();
            }
            else if (neighbors.get(0).Type.equals("TutorialNPC") && Greenfoot.isKeyDown("e"))
            {
                MakeMessage("Good Day laddy!\nAim with your cursor and\nclick to fire your weapon!\nTry it out on the incoming enemies!", neighbors.get(0).getX(), neighbors.get(0).getY());
            }
        }
        catch (Exception e)
        {
        }
    }
    
    public void MakeMessage(String message, int x, int y)
    {        
        ((InfamyWorld)this.getWorld()).AddDialogueBox(message, 300, 300);
    }
}

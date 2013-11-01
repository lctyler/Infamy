import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class XMarks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class XMarks extends Actor
{
    /**
     * Act - do whatever the XMarks wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    
    public List<Human> getPeopleToKill() {
        return getObjectsInRange(300, Human.class);
    }
}

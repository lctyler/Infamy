import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HumanWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HumanWorld extends World
{

    /**
     * Constructor for objects of class HumanWorld.
     * 
     */
    public HumanWorld(int width, int height, int pixels)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, pixels); 
    }
    
    public void addHuman(Human person, int x, int y){
        addObject(person, x, y);
        person.createHealthBar();
    }
}

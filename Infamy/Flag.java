import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flag extends Actor
{
    
    private String nationality;  
    
   
    public Flag(String nationality) {
        if (nationality.equals("British")) {
            setImage("british.png");
        }
        else {
            setImage("german.png");
        }
            
    }
   
    
    /**
     * Act - do whatever the Flag wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      // Want a cool wave animation
      if (isTouching(EnemyNPC.class)) {
        // end the game.   
      }
    }    
    
}

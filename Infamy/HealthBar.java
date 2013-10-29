import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A bar appearing above the heads of units to indicate current health remaining and health missing.
 * 
 * @Dylan Graves
 * @version 1
 */
public class HealthBar extends Actor
{
    Human subject;
    GreenfootImage bar;
    public HealthBar(Human subject) {
        this.subject = subject;
        bar = new GreenfootImage(100,10);
        updateBar();
    }
    
    public void updateBar(){
        bar.setColor(new java.awt.Color(50,120,0));
        bar.fillRect(0, 0, subject.getHealth(), 5);
        bar.setColor(new java.awt.Color(200,50,0));
        bar.fillRect(subject.getHealth(), 0, 100 - subject.getHealth(), 5);
        setImage(bar);
        setLocation(subject.getX(), subject.getY() - subject.getImage().getHeight()/2 - 1);
    }
    
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        updateBar();
    }    
}

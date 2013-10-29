import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DamageOverTime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DamageOverTime
{
    private int damage;
    private int time;
    private int damageLeft;
    public DamageOverTime(int damage, int time){
        this.damage = damage;
        this.time = time;
        this.damageLeft = damage;
    }
    /*Calculates how much damage should be done per frame*/
    public int getDamagePerTick(){
        return damage/time;
    }
    /*Returns how much damage has not been dealt*/
    public int getDamageLeft(){
        return damageLeft;
    }
    /*Call when damage has been dealt*/
    public void decrementDamageLeft(){
        damageLeft -= getDamagePerTick();
    }
}

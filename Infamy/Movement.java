import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Movement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Movement extends Actor
{
    public enum Direction
    {
        EAST,
        NORTH,
        SOUTH,
        WEST,
        NONE
    }
    /**
     * Act - do whatever the Movement wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    }
    
    private boolean canMove(int xMove, int yMove, Direction dir, Direction dir2)
    {
        World world = this.getWorld();
        if (world.getWidth() > xMove && 0 < xMove)
        {
            if (world.getHeight() > yMove && 0 < yMove)
            {
               if ((dir == Direction.NORTH || dir2 == Direction.NORTH) && getOneObjectAtOffset(0,-1, null) != null)
               {
                    return false;
               }
               if ((dir == Direction.SOUTH || dir2 == Direction.SOUTH) && getOneObjectAtOffset(0,1, null) != null)
               {
                    return false;
               }
               if ((dir == Direction.EAST || dir2 == Direction.EAST) && getOneObjectAtOffset(1,0, null) != null)
               {
                    return false;
               }
               if ((dir == Direction.WEST || dir2 == Direction.WEST) && getOneObjectAtOffset(-1,0, null) != null)
               {
                    return false;
               }
               return true;
            }
        }
        return false;
    }
    
    public boolean move ()
    {
        if (Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("d"))
        {
            if (canMove(this.getX() + 1, this.getY() - 1, Direction.NORTH, Direction.EAST))
            {
                this.setLocation(this.getX() + 1, this.getY() - 1);
            }
            return true;
        }
        else if (Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("a"))
        {
            if (canMove(this.getX() - 1, this.getY() - 1, Direction.NORTH, Direction.WEST))
            {
                this.setLocation(this.getX() - 1, this.getY() - 1);
            }
            return true;
        }
        else if (Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("d"))
        {
            if (canMove(this.getX() + 1, this.getY() + 1, Direction.SOUTH, Direction.EAST))
            {
                this.setLocation(this.getX() + 1, this.getY() + 1);
            }
            return true;
        }
        else if (Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a"))
        {
            if (canMove(this.getX() - 1, this.getY() + 1, Direction.SOUTH, Direction.WEST))
            {
                this.setLocation(this.getX() - 1, this.getY() + 1);
            }
            return true;
        }
        else if (Greenfoot.isKeyDown("w"))
        {
            if (canMove(this.getX(), this.getY() - 1, Direction.WEST, Direction.NONE))
            {
                this.setLocation(this.getX(), this.getY() - 1);
            }
            return true;
        }
        else if (Greenfoot.isKeyDown("a"))
        {
            if (canMove(this.getX() - 1, this.getY(), Direction.WEST, Direction.NONE))
            {
                this.setLocation(this.getX() - 1, this.getY());
            }
            return true;
        }
        else if (Greenfoot.isKeyDown("s"))
        {
            if (canMove(this.getX(), this.getY() + 1, Direction.SOUTH, Direction.NONE))
            {
                this.setLocation(this.getX(), this.getY() + 1);
            }
            return true;
        }
        else if (Greenfoot.isKeyDown("d"))
        {
            if (canMove(this.getX() + 1, this.getY(), Direction.EAST, Direction.NONE))
            {
                this.setLocation(this.getX() + 1, this.getY());
            }
            return true;
        }
        return false;
    }
    
    public boolean isAtWorldEdge()
    {
        World world = getWorld();
        return this.getX() == 0 || this.getX() == world.getWidth()-1 || this.getY() == 0 || this.getY() == world.getHeight()-1;
    }
}

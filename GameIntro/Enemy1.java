import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends Actor {
    private int lifes = 5;
    /**
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        moveAndTurn();
        eat();
    }

    public void moveAndTurn() {
        Actor heroe = (Heroe) getWorld().getObjects(Heroe.class).get(0);
        turnTowards(heroe.getX(), heroe.getY());
        move(3);
    }

    public void eat() 
    {
        Actor heroe = getOneObjectAtOffset(0, 0, Heroe.class);
        if (heroe != null) 
        {
            World world = getWorld();
            world.removeObject(heroe);
        }
    }

    public void decreaseLife() 
    {
        lifes--;
        if (lifes <= 0) 
        {
            die();
        }
    }

    public void die() 
    {
        World world = getWorld();
        if (world != null) 
        {
            world.removeObject(this);
        }
    }

    public int getLifes() 
    {
        return lifes;
    }
}

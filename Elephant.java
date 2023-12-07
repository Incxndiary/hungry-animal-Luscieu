import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootSound pizzaSound = new GreenfootSound("pizza.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    String facing = "right";
    
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }
        setImage(idleRight[0]);
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100); 
        }
        setImage(idleLeft[0]);
    }
    
    int imageIndex = 0;
    public void animateElephant()
    {
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("w"))
        {
            turn(-90);
            move(10); 
            turn(90);
        }
        if(Greenfoot.isKeyDown("a"))
        {
            move(-10);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("s"))
        {
            turn(90);
            move(10);
            turn(-90);
        }
        if(Greenfoot.isKeyDown("d"))
        {
            move(10);
            facing = "right";
        }
        
        if(isTouching(Pizza.class))
        {
            removeTouching(Pizza.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnPizza();
            world.scoreIncrease();
            pizzaSound.play();
        }
        
        animateElephant();
    }
}
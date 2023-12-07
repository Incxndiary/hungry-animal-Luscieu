import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * TitleScreen.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Speedy Elephant", 70);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(titleLabel, getWidth()/2, getHeight()/2 - getHeight()/4);
        tutorial();
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    public void tutorial()
    {
        Elephant elephant = new Elephant();
        addObject(elephant, getWidth()/2, getHeight()/2);
        Label controls = new Label("Use WASD to move", 30);
        addObject(controls, getWidth()/2, getHeight()/2 - 40);
        Label important = new Label("Hit 'shift' to dash", 50);
        addObject(important, getWidth()/2, getHeight()/2+60);
        Label start = new Label("Hit spacebar to start", 70);
        addObject(start, getWidth()/2, getHeight()/2 + getHeight()/3);
    }
}
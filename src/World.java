import java.awt.event.KeyEvent;
import java.util.*;

public class World
{
    private double timeSpeed;
    private double gravity;
    private double deltaTime;
    private double passedTime = 0;
    private boolean paused;
    private Randomizer randomizer;
    private Grid grid;
    private Resumer start;
    private Digit[] digits;

    public World(ProgramContainer pc, double gravity, double timeSpeed)
    {
        this.gravity = gravity;
        this.timeSpeed = timeSpeed;
        this.paused = true;
        grid = new Grid();
        digits = new Digit[81];
        for(int i = 0; i < 81; i++)
        {
               digits[i] = new Digit("digit.png", 4 + (i % 9) * 44, 4 + (i / 9) * 44, 41, 41, i);
               digits[i].imageSwap();
        }
        randomizer = new Randomizer("random.png", 460, 280, 69, 69);
        start = new Resumer("play.png", "pause.png", 460, 50, 69, 69);
    }

    public void update(ProgramContainer pc, double currentTime)
    {
        pause(pc);
        deltaTime = (currentTime - passedTime) * 60;
        passedTime = currentTime;
        start.click(pc);
        randomizer.click(pc, grid, start);
        for(int i = 0; i < 81; i++)
        {
            digits[i].click(pc, digits);
            digits[i].change(pc, grid);
        }
        paused = start.resume(paused);
        if(paused == true)
        {
            grid.update(pc, currentTime);
        }
    }
    public void render(ProgramContainer pc, Renderer r)
    {
        r.drawImage(pc, grid.getGrid(), 0, 0);
        for(int i = 0; i < 81; i++)
        {
            r.drawImage(pc, digits[i].getImg(), digits[i].getPosX(), digits[i].getPosY());
        }
        grid.render(pc, r);
        r.drawImage(pc, randomizer.getImg(), randomizer.getPosX(), randomizer.getPosY());
        r.drawImage(pc, start.getImg(), start.getPosX(), start.getPosY());
    }
    public void pause(ProgramContainer pc)
    {
        if((paused == true) && (pc.getInput().isKeyDown(KeyEvent.VK_P)))
        {
            paused = false;
        }
        else if((paused == false) && (pc.getInput().isKeyDown(KeyEvent.VK_P)))
        {
            paused = true;
        }
    }
    public boolean isPaused() {
        return paused;
    }
}

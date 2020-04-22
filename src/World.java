import java.awt.event.KeyEvent;
import java.util.*;

public class World
{
    private double timeSpeed;
    private double gravity;
    private double deltaTime;
    private double passedTime = 0;
    private boolean paused;

    private Grid grid;
    private Resumer start;

    public World(ProgramContainer pc, double gravity, double timeSpeed)
    {
        this.gravity = gravity;
        this.timeSpeed = timeSpeed;
        this.paused = true;
        grid = new Grid();
        start = new Resumer("play.png", "pause.png", 467, 53, 64, 64);
    }

    public void update(ProgramContainer pc, double currentTime)
    {
        pause(pc);
        deltaTime = (currentTime - passedTime) * 60;
        passedTime = currentTime;
        start.click(pc);
        paused = start.resume(paused);
        if(paused == true)
        {
            grid.update(pc, currentTime);
        }
    }
    public void render(ProgramContainer pc, Renderer r)
    {
        grid.render(pc, r);
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

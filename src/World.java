import java.awt.event.KeyEvent;
import java.util.*;

public class World
{
    private double timeSpeed;
    private double gravity;
    private double deltaTime;
    private double passedTime = 0;
    private boolean paused;

    public World(ProgramContainer pc, double gravity, double timeSpeed)
    {
        this.gravity = gravity;
        this.timeSpeed = timeSpeed;
        this.paused = true;
    }

    public void update(ProgramContainer pc, double currentTime)
    {
        pause(pc);
        deltaTime = (currentTime - passedTime) * 60;
        passedTime = currentTime;
        if(paused == false)
        {

        }
    }
    public void render(ProgramContainer pc, Renderer r)
    {

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

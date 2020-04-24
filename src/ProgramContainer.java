import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class ProgramContainer implements Runnable
{
    private Thread thread;
    private Window window;
    private Renderer renderer;
    private Input input;
    private Camera camera;
    private AbstractProgram program;
    private World world;


    private int fps;

    private boolean running = false;
    private final  double UPDATE_CAP = 1.0 / 90.0;
    private int width = 600, height = 400;
    private double time = 0;
    private double passedTime = 0;
    private float scale = 2.0f;
    private  String title = "title";

    public ProgramContainer(AbstractProgram program)
    {
        this.program = program;
    }
    public void start()
    {
        window = new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);
        camera = new Camera();
        thread = new Thread(this);
        world = new World(this,9.81, 1.0);
        thread.run();
    }
    public void stop()
    {

    }
    public void run()
    {
        running = true;
        boolean render = false;
        double firstTime = 0;
        time = System.nanoTime() / 1000000000.0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double unprocessedTime = 0;
        double frameTime = 0;
        int frames = 0;
        double absoluteTime = System.nanoTime() / 1000000000.0;
        fps = 0;
        while(running)
        {
            render = false;
            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;
            unprocessedTime += passedTime;
            frameTime += passedTime;

            while(unprocessedTime >= UPDATE_CAP)
            {
                unprocessedTime -= UPDATE_CAP;
                render = true;
                time = System.nanoTime() / 1000000000.0 - absoluteTime;
                program.update(this, time);
                input.update();
                if(frameTime >= 1.0)
                {
                    time++;
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                }
            }
            if(render)
            {
                renderer.clear();
                program.render(this, renderer);
                window.update();
                frames++;
            }
            else
            {
                try
                {
                    Thread.sleep(1);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
        dispose();
    }

    public void forceRender()
    {
        renderer.clear();
        program.render(this, renderer);
        window.update();
    }

    private void dispose()
    {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getScale() {
        return scale;
    }

    public String getTitle() {
        return title;
    }

    public Window getWindow() {
        return window;
    }

    public Input getInput() {
        return input;
    }

    public Camera getCamera() {
        return camera;
    }

    public World getWorld() {
        return world;
    }

    public int getFps() {
        return fps;
    }

    public double getTime() {
        return passedTime;
    }

}

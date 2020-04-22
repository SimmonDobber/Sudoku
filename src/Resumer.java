public class Resumer extends Button
{

    Resumer(String path, int posX, int posY, int width, int height) {
        super(path, posX, posY, width, height);
    }
    Resumer(String path, String path2, int posX, int posY, int width, int height) {
        super(path, path2, posX, posY, width, height);
    }
    public boolean resume(boolean paused)
    {
        if(paused != isClicked)
            return !paused;
        return paused;
    }
}

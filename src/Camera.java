import java.awt.event.KeyEvent;

public class Camera
{
    public static int offX = 0;
    public static int offY = 0;
    public Camera()
    {

    }
    public void cameraControl(ProgramContainer pc)
    {
        if(pc.getInput().isKey(KeyEvent.VK_A))
        {
            offX++;
        }
        if(pc.getInput().isKey(KeyEvent.VK_D))
        {
            offX--;
        }
        if(pc.getInput().isKey(KeyEvent.VK_W))
        {
            offY++;
        }
        if(pc.getInput().isKey(KeyEvent.VK_S))
        {
            offY--;
        }
    }
}

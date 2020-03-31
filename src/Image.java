import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;

public class Image
{
    private int w, h;
    private int[] p;
    private int[] r;

    public Image(String path, int width, int height)
    {
        BufferedImage image = null;
        try
        {
            image = ImageIO.read(Image.class.getResourceAsStream((path)));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        w = image.getWidth();
        h = image.getHeight();
        r = image.getRGB(0, 0, w, h, null, 0, w);
        p = new int[width * height];
        rescale(width, height);
        image.flush();
    }

    private void rescale(int nwidth, int nheight)
    {
        double sw = ((double)(nwidth) / (double)(w));
        double sh = ((double)(nheight) / (double)(h));
        for(int j = 0; j < nheight; j++)
        {
            for(int i = 0; i < nwidth; i++)
            {
                p[i + j * nwidth] = r[(int)((double)(i) / (double)(sw)) + (int)((double)(j) / (double)(sh)) * w];
            }
        }
        w = nwidth;
        h = nheight;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int[] getP() {
        return p;
    }

    public void setP(int[] p) {
        this.p = p;
    }
}

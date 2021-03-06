import java.awt.image.DataBufferInt;

public class Renderer
{
    private int pW, pH;
    private int[] p;
    private Font font = Font.STANDARD;
    Renderer(ProgramContainer pc)
    {
        pW = pc.getWidth();
        pH = pc.getHeight();
        p = ((DataBufferInt)pc.getWindow().getImage().getRaster().getDataBuffer()).getData();
    }
    public void clear()
    {
        for(int i = 0; i < p.length; i++)
        {
            p[i] = 0xFF000000;
        }
    }

    public void setPixel(int x,int y, int value)
    {
        if((x < 0 || x >= pW || y < 0 || y>= pH) || value == 0xFFFF00FF)
        return;
        p[x + y * pW] = value;
    }
    public void drawText(ProgramContainer pc, String text, int offX, int offY, int color)
    {
        int offset = 0;
        for(int i = 0; i < text.length(); i++)
        {
            int unicode = text.codePointAt(i) - 32;

            for(int y = 0; y < font.getFontImage().getH(); y++)
            {
                for(int x = 0; x < font.getWidths()[unicode]; x++)
                {
                    if(font.getFontImage().getP()[(x + font.getOffsets()[unicode]) + y * font.getFontImage().getW()] == 0xFF000000)
                    {
                        setPixel(x + offX + offset + pc.getCamera().offX, y + offY + pc.getCamera().offY, color);
                    }
                }
            }
            offset += font.getWidths()[unicode];
        }
    }
    public void drawStaticText(ProgramContainer pc, String text, int offX, int offY, int color)
    {
        int offset = 0;

        for(int i = 0; i < text.length(); i++)
        {
            int unicode = text.codePointAt(i) - 32;

            for(int y = 0; y < font.getFontImage().getH(); y++)
            {
                for(int x = 0; x < font.getWidths()[unicode]; x++)
                {
                    if(font.getFontImage().getP()[(x + font.getOffsets()[unicode]) + y * font.getFontImage().getW()] == 0xFF000000)
                    {
                        setPixel(x + offX + offset, y + offY, color);
                    }
                }
            }
            offset += font.getWidths()[unicode];
        }
    }
    public void drawImage(ProgramContainer pc, Image image, int offX, int offY)
    {
        int newX = 0;
        int newY = 0;
        int newWidth = image.getW();
        int newHeight = image.getH();

        if(offX < -newWidth)
            return;
        if(offY < -newHeight)
            return;
        if(offX >= pW)
            return;
        if(offY >= pH)
            return;
        if(offX < 0)
            newX -= offX;
        if(offY < 0)
            newY -= offY;
        if(newWidth + offX >= pW)
            newWidth = pW - offX;
        if(newHeight + offY >= pH)
            newHeight = pH - offY;

        for(int y = newY; y < newHeight; y++)
        {
            for(int x = newX; x < newWidth; x++)
            {
                setPixel(x + offX + pc.getCamera().offX, y + offY + pc.getCamera().offY, image.getP()[x + y * image.getW()]);
            }
        }
    }
    public void drawStaticImage(ProgramContainer pc, Image image, int offX, int offY)
    {
        int newX = 0;
        int newY = 0;
        int newWidth = image.getW();
        int newHeight = image.getH();

        if(offX < -newWidth)
            return;
        if(offY < -newHeight)
            return;
        if(offX >= pW)
            return;
        if(offY >= pH)
            return;
        if(offX < 0)
            newX -= offX;
        if(offY < 0)
            newY -= offY;
        if(newWidth + offX >= pW)
            newWidth = pW - offX;
        if(newHeight + offY >= pH)
            newHeight = pH - offY;

        for(int y = newY; y < newHeight; y++)
        {
            for(int x = newX; x < newWidth; x++)
            {
                setPixel(x + offX, y + offY, image.getP()[x + y * image.getW()]);
            }
        }
    }
}

public class Font
{
    public static final Font STANDARD = new Font("font.png");

    private Image fontImage;
    private int[] offsets;
    private int[] widths;

    public Font(String path)
    {
        fontImage = new Image(path, 1184, 23);
        offsets = new int[96];
        widths = new int[96];

        int unicode = 0;

        for(int i = 0; i < fontImage.getW(); i++)
        {
            if(fontImage.getP()[i] == 0xFF0000FF)
            {
                offsets[unicode] = i;
            }
            if(fontImage.getP()[i] == 0xFFFFFF00)
            {
                widths[unicode] = i - offsets[unicode];
                unicode++;
            }
        }
    }

    public Image getFontImage() {
        return fontImage;
    }

    public int[] getOffsets() {
        return offsets;
    }

    public int[] getWidths() {
        return widths;
    }
}

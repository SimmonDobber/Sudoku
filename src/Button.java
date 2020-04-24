import java.awt.event.MouseEvent;

public class Button {
    protected int posX;
    protected int posY;
    protected int width;
    protected int height;
    protected Image img;
    protected Image img2;
    protected boolean isClicked;

    Button(String path, int posX, int posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        img = new Image(path, width, height);
        img2 = new Image("blank.png", width, height);
        isClicked = false;
    }

    Button(String path, String path2, int posX, int posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        img = new Image(path, width, height);
        img2 = new Image(path2, width, height);
        isClicked = false;
    }

    protected boolean isOnButton(ProgramContainer pc) {
        if ((pc.getInput().getMouseX() >= posX) && (pc.getInput().getMouseX() <= posX + width) && (pc.getInput().getMouseY() >= posY) && (pc.getInput().getMouseY() <= posY + height))
            return true;
        return false;
    }


    public void imageSwap() {
        Image i;
        i = img;
        img = img2;
        img2 = i;
    }

    public void click(ProgramContainer pc) {
        if ((isClicked == false) && (pc.getInput().isButtonDown(MouseEvent.BUTTON1)) && (isOnButton(pc) == true)) {
            isClicked = true;
            imageSwap();
        } else if ((isClicked == true) && (pc.getInput().isButtonDown(MouseEvent.BUTTON1)) && (isOnButton(pc)) == true) {
            isClicked = false;
            imageSwap();
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Image getImg() {
        return img;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }
}

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Digit extends Button
{
    private int number;
    Digit(String path, int posX, int posY, int width, int height, int i) {
        super(path, posX, posY, width, height);
        this.number = i;
    }
    Digit(String path, String path2, int posX, int posY, int width, int height, int i) {
        super(path, path2, posX, posY, width, height);
        this.number = i;
    }
    public void click(ProgramContainer pc, Digit[] digits) {
        if ((isClicked == false) && (pc.getInput().isButtonDown(MouseEvent.BUTTON1)) && (isOnButton(pc) == true)) {

            for(int i = 0; i < 81; i++)
            {
                if(digits[i].isClicked() == true)
                    digits[i].imageSwap();
                digits[i].setClicked(false);
            }
            isClicked = true;
            imageSwap();
        } else if ((isClicked == true) && (pc.getInput().isButtonDown(MouseEvent.BUTTON1)) && (isOnButton(pc)) == true) {
            isClicked = false;
            imageSwap();
        }
    }
    void change(ProgramContainer pc, Grid grid)
    {
        if((isClicked == true) && (pc.getInput().isKeyDown(KeyEvent.VK_0)))
        {
            isClicked = false;
            grid.getGiven()[number] = false;
            if(grid.getDigits()[number] != 0)
            {
                grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = false;
                grid.getRows()[number / 9][grid.getDigits()[number] - 1] = false;
                grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = false;
            }
            grid.getDigits()[number] = 0;
            imageSwap();
        }
        else if((isClicked == true) && (pc.getInput().isKeyDown(KeyEvent.VK_1)))
        {
            isClicked = false;
            grid.getGiven()[number] = true;
            if(grid.getDigits()[number] != 0)
            {
                grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = false;
                grid.getRows()[number / 9][grid.getDigits()[number] - 1] = false;
                grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = false;
            }
            grid.getDigits()[number] = 1;
            grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = true;
            grid.getRows()[number / 9][grid.getDigits()[number] - 1] = true;
            grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = true;
            imageSwap();
        }
        else if((isClicked == true) && (pc.getInput().isKeyDown(KeyEvent.VK_2)))
        {
            isClicked = false;
            grid.getGiven()[number] = true;
            if(grid.getDigits()[number] != 0)
            {
                grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = false;
                grid.getRows()[number / 9][grid.getDigits()[number] - 1] = false;
                grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = false;
            }
            grid.getDigits()[number] = 2;
            grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = true;
            grid.getRows()[number / 9][grid.getDigits()[number] - 1] = true;
            grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = true;
            imageSwap();
        }
        else if((isClicked == true) && (pc.getInput().isKeyDown(KeyEvent.VK_3)))
        {
            isClicked = false;
            grid.getGiven()[number] = true;
            if(grid.getDigits()[number] != 0)
            {
                grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = false;
                grid.getRows()[number / 9][grid.getDigits()[number] - 1] = false;
                grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = false;
            }
            grid.getDigits()[number] = 3;
            grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = true;
            grid.getRows()[number / 9][grid.getDigits()[number] - 1] = true;
            grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = true;
            imageSwap();
        }
        else if((isClicked == true) && (pc.getInput().isKeyDown(KeyEvent.VK_4)))
        {
            isClicked = false;
            grid.getGiven()[number] = true;
            if(grid.getDigits()[number] != 0)
            {
                grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = false;
                grid.getRows()[number / 9][grid.getDigits()[number] - 1] = false;
                grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = false;
            }
            grid.getDigits()[number] = 4;
            grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = true;
            grid.getRows()[number / 9][grid.getDigits()[number] - 1] = true;
            grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = true;
            imageSwap();
        }
        else if((isClicked == true) && (pc.getInput().isKeyDown(KeyEvent.VK_5)))
        {
            isClicked = false;
            grid.getGiven()[number] = true;
            if(grid.getDigits()[number] != 0)
            {
                grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = false;
                grid.getRows()[number / 9][grid.getDigits()[number] - 1] = false;
                grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = false;
            }
            grid.getDigits()[number] = 5;
            grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = true;
            grid.getRows()[number / 9][grid.getDigits()[number] - 1] = true;
            grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = true;
            imageSwap();
        }
        else if((isClicked == true) && (pc.getInput().isKeyDown(KeyEvent.VK_6)))
        {
            isClicked = false;
            grid.getGiven()[number] = true;
            if(grid.getDigits()[number] != 0)
            {
                grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = false;
                grid.getRows()[number / 9][grid.getDigits()[number] - 1] = false;
                grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = false;
            }
            grid.getDigits()[number] = 6;
            grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = true;
            grid.getRows()[number / 9][grid.getDigits()[number] - 1] = true;
            grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = true;
            imageSwap();
        }
        else if((isClicked == true) && (pc.getInput().isKeyDown(KeyEvent.VK_7)))
        {
            isClicked = false;
            grid.getGiven()[number] = true;
            if(grid.getDigits()[number] != 0)
            {
                grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = false;
                grid.getRows()[number / 9][grid.getDigits()[number] - 1] = false;
                grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = false;
            }
            grid.getDigits()[number] = 7;
            grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = true;
            grid.getRows()[number / 9][grid.getDigits()[number] - 1] = true;
            grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = true;
            imageSwap();
        }
        else if((isClicked == true) && (pc.getInput().isKeyDown(KeyEvent.VK_8)))
        {
            isClicked = false;
            grid.getGiven()[number] = true;
            if(grid.getDigits()[number] != 0)
            {
                grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = false;
                grid.getRows()[number / 9][grid.getDigits()[number] - 1] = false;
                grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = false;
            }
            grid.getDigits()[number] = 8;
            grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = true;
            grid.getRows()[number / 9][grid.getDigits()[number] - 1] = true;
            grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = true;
            imageSwap();
        }
        else if((isClicked == true) && (pc.getInput().isKeyDown(KeyEvent.VK_9)))
        {
            isClicked = false;
            grid.getGiven()[number] = true;
            if(grid.getDigits()[number] != 0)
            {
                grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = false;
                grid.getRows()[number / 9][grid.getDigits()[number] - 1] = false;
                grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = false;
            }
            grid.getDigits()[number] = 9;
            grid.getColumns()[number % 9][grid.getDigits()[number] - 1] = true;
            grid.getRows()[number / 9][grid.getDigits()[number] - 1] = true;
            grid.getBoxes()[(number / 27) * 3 + (number % 9) / 3][grid.getDigits()[number] - 1] = true;
            imageSwap();
        }
    }
}

import java.awt.event.MouseEvent;

public class Randomizer extends Button
{
    private int amount;
    private int left;
    private int current;
    private int value;
    Randomizer(String path, int posX, int posY, int width, int height) {
        super(path, posX, posY, width, height);
    }
    Randomizer(String path, String path2, int posX, int posY, int width, int height) {
        super(path, path2, posX, posY, width, height);
    }
    public void click(ProgramContainer pc, Grid grid, Resumer start)
    {
        if(start.isClicked() == true)
            return;
        if((pc.getInput().isButtonDown(MouseEvent.BUTTON1)) && (isOnButton(pc) == true))
        {
            grid.setCurrent(0);
            grid.setPrecurrent(0);
            grid.setIteration(0);
            for(int i = 0; i < 81; i++)
            {
                grid.getGiven()[i] = false;
                grid.getDigits()[i] = 0;
                grid.getColumns()[i % 9][i / 9] = false;
                grid.getRows()[i % 9][i / 9] = false;
                grid.getBoxes()[i % 9][i / 9] = false;
            }
            amount = (int)(System.nanoTime() % 21 + 10);
            System.out.println(amount);
            left = amount;
            while(left > 0)
            {
                current = (int)(System.nanoTime() % 81);
                value = (int)(System.nanoTime() % 9 + 1);
                if((grid.getDigits()[current] == 0) && (grid.getColumns()[current % 9][value - 1] == false) && (grid.getRows()[current / 9][value - 1] == false) && (grid.getBoxes()[(current / 27) * 3 + (current % 9) / 3][value - 1] == false))
                {
                    grid.getDigits()[current] = value;
                    grid.getGiven()[current] = true;
                    grid.getColumns()[current % 9][value - 1] = true;
                    grid.getRows()[current / 9][value - 1] = true;
                    grid.getBoxes()[(current / 27) * 3 + (current % 9) / 3][value - 1] = true;
                    left--;
                }
            }
        }
     }
}

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class Grid
{
    private Image grid;
    private int[] digits;
    private boolean[] given;
    private boolean rows[][];
    private boolean columns[][];
    private boolean boxes[][];
    private int current;
    private int iteration = 0;
    private int precurrent;
    public Grid()
    {
        grid = new Image("grid.png", 400, 400);
        current = 0;
        precurrent = 0;
        digits = new int[81];
        for(int i = 0; i < 81; i++)
        {
                   digits[i] = 0;
        }
        given = new boolean[81];
        rows = new boolean[9][9];
        columns = new boolean[9][9];
        boxes = new boolean[9][9];
        for(int i = 0; i < 81; i++)
        {
            given[i] = false;
            if(digits[i] != 0)
                given[i] = true;
            else
                given[i] = false;
        }
        for(int i = 0; i < 81; i++)
        {
            if(digits[i] != 0)
            {
                rows[i / 9][digits[i] - 1] = true;
                columns[i % 9][digits[i] - 1] = true;
                boxes[(i / 27) * 3 + (i % 9) / 3][digits[i] - 1] = true;
            }
        }
    }
    public void render(ProgramContainer pc, Renderer r)
    {
        for(int i = 0; i < 81; i++)
            if((digits[i] != 0) && (given[i] == false))
                r.drawText(pc, Integer.toString(digits[i]), 18 + (i % 9) * 44, 13 + (i / 9) * 44, 0xFF008591);
            else if((digits[i] != 0) && (given[i] == true))
                r.drawText(pc, Integer.toString(digits[i]), 18 + (i % 9) * 44, 13 + (i / 9) * 44, 0xFF00FF00);
    }
    public void update(ProgramContainer pc, double dt)
    {
        if(current == -1)
        {
            System.out.println("unsolvable");
            pc.forceRender();
            return;
        }
        if(current == 81)
        {
            pc.forceRender();
            return;
        }
        iteration++;
        System.out.println(iteration);
        if(given[current] == true)
        {
            if(precurrent > current)
            {
                current--;
                precurrent = current + 1;
            }
            else
            {
                current++;
                precurrent = current - 1;
            }
            pc.forceRender();
            return;
        }
        if(digits[current] == 9)
        {
            digits[current] = 0;
            rows[current / 9][8] = false;
            columns[current % 9][8] = false;
            boxes[(current / 27) * 3 + (current % 9) / 3][8] = false;
            precurrent = current;
            current--;
            pc.forceRender();
            return;
        }
        if(digits[current] != 0)
        {
            rows[current / 9][digits[current] - 1] = false;
            columns[current % 9][digits[current] - 1] = false;
            boxes[(current / 27) * 3 + (current % 9) / 3][digits[current] - 1] = false;
        }
         for(int i = digits[current]; i < 9; i++)
        {
            if((rows[current / 9][i] == false) && (columns[current % 9][i] == false) && (boxes[(current / 27) * 3 + (current % 9) / 3][i] == false))
            {
                rows[current / 9][i] = true;
                columns[current % 9][i] = true;
                boxes[(current / 27) * 3 + (current % 9) / 3][i] = true;
                digits[current] = i + 1;
                precurrent = current;
                current++;
                break;
            }
            if(i == 8)
            {

                digits[current] = 0;
                if(digits[current] != 0)
                {
                    rows[current / 9][digits[current] - 1] = false;
                    columns[current % 9][digits[current] - 1] = false;
                    boxes[(current / 27) * 3 + (current % 9) / 3][digits[current] - 1] = false;
                }
                precurrent = current;
                current--;
            }
        }
        pc.forceRender();
    }

    public Image getGrid() {
        return grid;
    }

    public int[] getDigits() {
        return digits;
    }

    public boolean[] getGiven() {
        return given;
    }

    public boolean[][] getRows() {
        return rows;
    }

    public boolean[][] getColumns() {
        return columns;
    }

    public boolean[][] getBoxes() {
        return boxes;
    }

    public void setDigits(int[] digits) {
        this.digits = digits;
    }

    public void setGiven(boolean[] given) {
        this.given = given;
    }

    public void setRows(boolean[][] rows) {
        this.rows = rows;
    }

    public void setColumns(boolean[][] columns) {
        this.columns = columns;
    }

    public void setBoxes(boolean[][] boxes) {
        this.boxes = boxes;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public void setPrecurrent(int precurrent) {
        this.precurrent = precurrent;
    }
}

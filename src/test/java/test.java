import com.ucc.colorPalette.ColourTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class test {
    static void testConstructorValidInput() {
        // Test constructor with a valid number of colors (power of two, greater than 1, and less than 1025)
        System.out.println("Testing Constructor with valid input");
        try {
            ColourTable colourTable = new ColourTable(8);
            assertNotNull(colourTable);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static void testConstructorInvalidInput(){
        System.out.println("Testing Constructor with invalid input");
        // Creating a ColourTable object without specifying a valid palette size throws an exception
        try{
            ColourTable table = new ColourTable(7);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static void testAddColour(){
        System.out.println("Testing adding colour");
        // Test add colour method
        try{
            ColourTable table = new ColourTable(8);
            table.addColour(new int[]{128, 128, 128});
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static void testExceededSizeException(){
        System.out.println("Testing exceeding palette size");
        // Test Exceeded Size Exception
        try{
            ColourTable table = new ColourTable(2);
            table.addColour(new int[]{128, 128, 128});
            table.addColour(new int[]{128, 128, 128});
            table.addColour(new int[]{128, 128, 128});
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        testConstructorValidInput();
        testConstructorInvalidInput();
        testAddColour();
        testExceededSizeException();
    }

}

import com.ucc.colorPalette.ColourTable;
import org.junit.jupiter.api.Test;
import javax.naming.SizeLimitExceededException;
import static org.junit.jupiter.api.Assertions.*;
public class test {
    static void testConstructorValidInput() {
        // Test constructor with a valid number of colors (power of two, greater than 1, and less than 1025)
        System.out.println("Testing Constructor with valid input");
        try {
            ColourTable colourTable = new ColourTable(8);
            assertNotNull(colourTable);
            System.out.println(0);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    static void testConstructorInvalidInput() {
        // Creating a ColourTable object without specifying a valid palette size throws an exception
        System.out.println("Testing Constructor with invalid input");
        try {
            assertThrows(IllegalArgumentException.class, () -> {
                ColourTable table = new ColourTable(7);
            }, "Expected IllegalArgumentException, but no exception was thrown");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(0);
    }

    static void testAddColour(){
        // Test add colour method
        System.out.println("Testing adding colour");
        try{
            ColourTable table = new ColourTable(8);
            table.addColour(new int[]{128, 128, 128});
            System.out.println(0);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    static void testExceededSizeException(){
        // Test Exceeded Size Exception
        System.out.println("Testing exceeding palette size");
        ColourTable table = null;
        try {
            table = new ColourTable(2);
            table.addColour(new int[]{128, 128, 128});
            table.addColour(new int[]{128, 128, 128});
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (table != null) {
                ColourTable finalTable = table;
                assertThrows(SizeLimitExceededException.class, () -> finalTable.addColour(new int[]{128, 128, 128}));
            }
            System.out.println(0);
        }
    }
    public static void main(String[] args){
        testConstructorValidInput();
        testConstructorInvalidInput();
        testAddColour();
        testExceededSizeException();
    }

}

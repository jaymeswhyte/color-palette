import com.ucc.colorPalette.ColourTable;
public class test {
    public static void main(String[] args) {
        // A constructor for a ColourTable object with a single parameter that specifies the number of
        //colours in the palette (the number of elements allowed in the colour lookup table
        ColourTable table = new ColourTable(8);

        // The number of colours in the palette must be a power of two and greater than 1 (e.g. 2, 4, 8…) and
        //less than 1025
        // Creating a ColourTable object without specifying a valid palette size throws an exception
        ColourTable table2 = new ColourTable(7);
        // A method add that enables a developer to add a 24-bit RGB colour to the colour table
        // Exceeding the capacity of the ColourTable results in an exception
    }

}

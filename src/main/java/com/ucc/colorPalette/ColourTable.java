package com.ucc.colorPalette;
import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.List;

public class ColourTable {
    private List<int[]> table;
    private int colourIndex = 0;
    // Constructor
    public ColourTable(int numberOfColours) throws IllegalArgumentException {
        // The number of colours in the palette must be a power of two and greater than 1 (e.g. 2, 4, 8…) and
        //less than 1025
        if(numberOfColours>1 && numberOfColours<1025 && isPowerOfTwo(numberOfColours)){
            table = new ArrayList<>(numberOfColours);
            initializeColourTable(numberOfColours);
        }
        else{
            throw new IllegalArgumentException("Invalid Input");
        }

    }

    private void initializeColourTable(int len) {
        for (int i = 0; i < len; i++) {
            table.add(new int[]{0, 0, 0});
        }
    }

    // A method add that enables a developer to add a 24-bit RGB colour to the colour table
    public void addColour(int[] newColour)throws SizeLimitExceededException {
        if(colourIndex < table.size()){
            table.set(colourIndex, newColour);
            colourIndex++;
        }
        else{
            throw new SizeLimitExceededException("Table is full!");
        }
    }

    private boolean isPowerOfTwo(int num) {
        while (num != 1) {
            if (num % 2 != 0)
                return false;
            num = num / 2;
        }
        return true;
    }

}

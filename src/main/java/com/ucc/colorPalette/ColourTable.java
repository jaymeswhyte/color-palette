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
        // Don't add duplicate colours
        if(table.contains(newColour)){
            return;
        }
        // Check table isn't full
        if(colourIndex < table.size()){
            // Check input contains 3 values
            if(newColour.length == 3){
                // Check colours are within acceptable 8-bit range
                for(int i=0; i<newColour.length; i++){
                    if(0>newColour[i] || newColour[i]>256){
                        throw new IllegalArgumentException("Values must be 0-256");
                    }
                }
                table.set(colourIndex, newColour);
                colourIndex++;
            }
            else{
                throw new IllegalArgumentException("Colour must contain 3 values for R,G and B");
            }
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

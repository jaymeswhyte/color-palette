package com.ucc.colorPalette;
import java.util.ArrayList;
import java.util.List;

public class ColourTable {
    private List<int[]> table;
    // Constructor
    public ColourTable(int numberOfColors) {
        table = new ArrayList<>(numberOfColors);
        initializeColorTable();
    }

    private void initializeColorTable() {
        for (int i = 0; i < table.size(); i++) {
            table.add(new int[]{0, 0, 0});
        }
    }

}

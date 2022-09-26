package com.lagodka.santa;

import com.opencsv.bean.CsvToBeanFilter;

public class EmptyLineFilter implements CsvToBeanFilter {
    @Override
    public boolean allowLine(String[] line) {
        boolean blankLine = line.length == 1;
        return !blankLine;
    }
}

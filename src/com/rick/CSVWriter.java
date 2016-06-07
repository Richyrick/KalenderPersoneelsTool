package com.rick;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Rick on 7-6-2016.
 */
public class CSVWriter {

    public CsvPreference customCsvPreference(){
        return new CsvPreference.Builder('|', ',', "\n").build();
    }

    public static void writeCSV(ArrayList<Werkdag> dagen) throws IOException {
        ICsvBeanWriter beanWriter = null;
        try {
            beanWriter = new CsvBeanWriter(new FileWriter("dagen"), CsvPreference.STANDARD_PREFERENCE);

            // the header elements are used to map the bean values to each column (names must match)
            final String[] header = new String[] { "Subject", "Start Date", "Start Time", "End Time", "Location"};
            final CellProcessor[] processors = getProcessors();

            // write the header
            beanWriter.writeHeader(header);

            // write the beans
            for(final Werkdag werkdag : dagen ) {
                beanWriter.write(werkdag, header, processors);
            }
        } finally {
            if( beanWriter != null ) {
                beanWriter.close();
            }
        }
    }

    private static CellProcessor[] getProcessors() {
        return new CellProcessor[]{
                new NotNull(),
                null,
                null,
                null,
                null
        };

    }
}

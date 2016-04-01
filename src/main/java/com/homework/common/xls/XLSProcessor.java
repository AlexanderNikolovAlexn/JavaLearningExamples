package com.homework.common.xls;

import java.io.File;

public interface XLSProcessor {

    public void saveDataFromExcellTodatabase(File xlsFile);
    public void getDataFromDatabaseToExcell();

}

/**
 * <h4>FeatureDomain:</h4>
 *     Finance
 *
 * <h4>FeatureDescription:</h4>
 *     software for financeplaning and management
 * 
 * @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
 * @category collaboration
 * @copyright Copyright (c) 2006-2014, Michael Schreiner
 * @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package de.yitf.utils.dpsfinancetools;

import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 * <h4>FeatureDomain:</h4>
 *     finance
 * <h4>FeatureDescription:</h4>
 *     encapsulate the Sheet-implementation of POI
 * 
 * @package de.mat.utils.imageimporteditor
 * @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
 * @category finance
 * @copyright Copyright (c) 2006-2014, Michael Schreiner
 * @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0
 */
public class Sheet {
    String sheetName = null;
    Workbook workBook = null;
    HSSFSheet hssfSheet = null;

    public Sheet(Workbook workBook, String sheetName, HSSFSheet hssfSheet) {
        super();
        this.sheetName = sheetName;
        this.workBook = workBook;
        this.hssfSheet = hssfSheet;
    }

    /**
     * @return the sheetName
     */
    public String getSheetName() {
        return sheetName;
    }
    /**
     * @param sheetName the sheetName to set
     */
    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }
    /**
     * @return the workBook
     */
    public Workbook getWorkBook() {
        return workBook;
    }
    /**
     * @param workBook the workBook to set
     */
    public void setWorkBook(Workbook workBook) {
        this.workBook = workBook;
    }
    /**
     * @return the sheet
     */
    public HSSFSheet getHssfSheet() {
        return hssfSheet;
    }
    /**
     * @param sheet the sheet to set
     */
    public void setHssfSheet(HSSFSheet hssfSheet) {
        this.hssfSheet = hssfSheet;
    }
}


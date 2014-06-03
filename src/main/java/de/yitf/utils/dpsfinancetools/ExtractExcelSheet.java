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

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * <h4>FeatureDomain:</h4>
 *     finance
 * <h4>FeatureDescription:</h4>
 *     abstract Importer for excel-sheets
 * 
 * @package de.mat.utils.imageimporteditor
 * @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
 * @category finance
 * @copyright Copyright (c) 2006-2014, Michael Schreiner
 * @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0
 */
public abstract class ExtractExcelSheet {


    public static final Logger LOG = Logger.getLogger(ExtractExcelSheet.class);

    public ExtractExcelSheet() {
    }

    public void init(String configPath) throws Exception {
    }

    public void close() {
    }


    /**
     * <h4>FeatureDomain:</h4>
     *     Finance
     * <h4>FeatureDescription:</h4>
     *     read and prints out data for profileName from sheetName in fileName.
     *     If not date set, use defaultDateStr
     * <h4>FeatureResult:</h4>
     *   <ul>
     *     <li>prints STDOUT - records found for profile
     *   </ul> 
     * <h4>FeatureKeywords:</h4>
     *     Finance
     * @param fileName - file to read
     * @param sheetName - name of the sheet in filename
     * @param profileName - name of the profile
     * @param defaultDateStr - date to use if no date found for record
     * @throws Exception
     */
    public abstract void execute(String fileName, String sheetName, String profileName, String defaultDateStr) throws Exception;

    /**
     * <h4>FeatureDomain:</h4>
     *     Finance
     * <h4>FeatureDescription:</h4>
     *     read sheetName in fileName.
     * <h4>FeatureResult:</h4>
     *   <ul>
     *     <li>returnValue Sheet - the sheet to read
     *   </ul> 
     * <h4>FeatureKeywords:</h4>
     *     Finance
     * @param fileName - file to read
     * @param sheetName - sheet to read
     * @return - the sheet to read
     * @throws Exception
     */
    public Sheet getWorkBookSheet(String fileName, String sheetName) throws Exception {
        // check parameter
        if (Support.isEmpty(fileName)) {
            throw new IllegalArgumentException("Filename expected");
        }
        if (Support.isEmpty(sheetName)) {
            throw new IllegalArgumentException("Sheetname expected");
        }

        // read sheet from file
        InputStream input = new FileInputStream(fileName);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(input);
        if (Support.isEmpty(hssfWorkbook)) {
            throw new IllegalArgumentException("Cant read Workbook: " + fileName);
        }
        Workbook workbook = new Workbook(fileName, hssfWorkbook);
        HSSFSheet hssfSheet = hssfWorkbook.getSheet(sheetName);
        if (Support.isEmpty(hssfSheet)) {
            throw new IllegalArgumentException("Cant find Sheet:" + sheetName + " in Workbook: " + fileName);
        }
        Sheet sheet = new Sheet(workbook, sheetName, hssfSheet);

        return sheet;
    }

    /**
     * <h4>FeatureDomain:</h4>
     *     Finance
     * <h4>FeatureDescription:</h4>
     *     configure the ImportProfile profileName for the current sheet.
     *     Search for keywords and configure the regions where the data is found
     *     as DefImportBereiche.  
     * <h4>FeatureResult:</h4>
     *   <ul>
     *     <li>returnValue DefImportprofile - the configured ImportProfile for this sheet
     *   </ul> 
     * <h4>FeatureKeywords:</h4>
     *     Finance
     * @param sheet - sheet to import
     * @param profileName - profile to import
     * @return - configured profile
     * @throws Exception
     */
    public abstract DefImportProfile getWorkBookProfile(Sheet sheet, String profileName ) throws Exception;

    
    public abstract List<Record> readRecordBlock(Sheet sheet, DefImportBereich ib, String type, Date defaultDate) throws Exception;
    
    
    /**
     * <h4>FeatureDomain:</h4>
     *     Finance
     * <h4>FeatureDescription:</h4>
     *     search in in the sheet between the borders of searchAnchor for the keyword
     * <h4>FeatureResult:</h4>
     *   <ul>
     *     <li>returnValue Anchor - the anchor that points to the found keyword
     *   </ul> 
     * <h4>FeatureKeywords:</h4>
     *     Finance
     * @param sheet - sheet to search
     * @param searchAnchor -. region to search
     * @param keyword - keyword to find
     * @return - anchor where the keyword is found
     */
    public Anchor searchForKeyword(Sheet sheet, Anchor searchAnchor, String keyword) {
        // check parameter
        if (Support.isEmpty(sheet)) {
            return null;
        }
        if (Support.isEmpty(searchAnchor)) {
            return null;
        }

        // read regionborder
        int x1, y1, x2, y2;
        x1 = searchAnchor.getDx1();
        y1 = searchAnchor.getDy1();
        x2 = searchAnchor.getDx2();
        y2 = searchAnchor.getDy2();

        // iterate region and search keyword
        Anchor resSearchAnchor = null;
        LOG.debug("searchForKeyword for: " + keyword + " in " + searchAnchor);
        for (int curRowNr = y1; curRowNr <= y2; curRowNr++) {
            for (int curColNr = x1; curColNr <= x2; curColNr++) {
                if (checkIfKeyword(sheet, curColNr, curRowNr, keyword)) {
                    // if keyword found: return it
                    resSearchAnchor =
                        new Anchor(curColNr, curRowNr, curColNr, curRowNr);
                    LOG.debug("searchForKeyword found: " + curColNr + "," + curRowNr  + " = " + keyword);
                    return resSearchAnchor;
                }
            }
        }
        LOG.debug("searchForKeyword not found: " + keyword);

        return resSearchAnchor;
    }

    /**
     * <h4>FeatureDomain:</h4>
     *     Finance
     * <h4>FeatureDescription:</h4>
     *     check if the column in the sheet contains the keyword
     * <h4>FeatureResult:</h4>
     *   <ul>
     *     <li>returnValue boolean - contains or contains not the keyword
     *   </ul> 
     * <h4>FeatureKeywords:</h4>
     *     Finance
     * @param sheet - sheet to search
     * @param colNr - nr of column
     * @param rowNr - nr of row
     * @param keyword - keyword to find
     * @return - cainbtains or contains not
     */
    public boolean checkIfKeyword(Sheet sheet, int colNr, int rowNr, String keyword) {
        boolean found = false;

        // read cell
        if (Support.isEmpty(sheet)) {
            return false;
        }
        HSSFSheet hssfSheet = sheet.getHssfSheet();
        if (Support.isEmpty(hssfSheet)) {
            return false;
        }
        HSSFRow row = hssfSheet.getRow(rowNr);
        if (Support.isEmpty(row)) {
            return false;
        }
        HSSFCell cell = row.getCell(new Integer(colNr).shortValue());
        if (Support.isEmpty(cell)) {
            return false;
        }

        // check value
        String value = cell.toString();
        if (Support.isEmpty(value) && Support.isEmpty(keyword)) {
            return true;
        }
        if (Support.isEmpty(value)) {
            return false;
        }

        LOG.debug("checkIfKeyword (" + colNr + "," + rowNr  + "):" + value + "=" + keyword);
        if (value.equalsIgnoreCase(keyword)) {
            return true;
        }

        return found;
    }
}

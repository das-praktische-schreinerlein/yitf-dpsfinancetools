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


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 * <h4>FeatureDomain:</h4>
 *     finance
 * <h4>FeatureDescription:</h4>
 *     Importer for Fonds-data from excel-sheets
 * 
 * @package de.mat.utils.imageimporteditor
 * @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
 * @category finance
 * @copyright Copyright (c) 2006-2014, Michael Schreiner
 * @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0
 */
public class ExtractExcelSheetFonds extends ExtractExcelSheet {

    @Override
    public void execute(String fileName, String sheetName, String profileName, String defaultDateStr) throws Exception {
        // check parameter
        if (Support.isEmpty(profileName)) {
            throw new IllegalArgumentException("Profile expected");
        }

        // read sheet
        LOG.info("Lese Daten für " + fileName + " " + sheetName + " " + profileName);
        Sheet sheet = this.getWorkBookSheet(fileName, sheetName);

        // read importprofile
        DefImportProfileFonds ip =
            (DefImportProfileFonds) this.getWorkBookProfile(sheet, profileName);
        LOG.info("ImportProfile for " + fileName + " " + sheetName + " " + profileName + ip);

        // read records for importprofile
        Map<String, List<Record>> recordMap = new HashMap<String, List<Record>>();
        Date defaultDate = Support.dateF.parse(defaultDateStr);
        recordMap.put("Fonds", this.readRecordBlock(sheet, ip.getIbFonds(), "Fonds", defaultDate));

        // print records
        LOG.info("eingelesene Records für " + fileName + " " + sheetName + " " + profileName);
        LOG.info("B_SRC;B_TYPE;B_DATE;B_BETRAG;B_DESC;GRUPPE1;GRUPPE2");
//        System.out.println("B_SRC;B_TYPE;B_DATE;B_BETRAG;B_DESC;GRUPPE1;GRUPPE2");
        for (Iterator<String> iter = recordMap.keySet().iterator(); iter.hasNext();) {
            List<Record> recordList = (List<Record>)recordMap.get(iter.next().toString());
            for (Iterator<Record> iterRecords = recordList.iterator(); iterRecords.hasNext();) {
                RecordFonds record = (RecordFonds)iterRecords.next();
                LOG.info(record);
                System.out.println(record);
            }
        }
    }


    @Override
    public DefImportProfile getWorkBookProfile(Sheet sheet, String profileName ) throws Exception {
        // check parameter
        if (Support.isEmpty(sheet)) {
            throw new IllegalArgumentException("Sheet expected");
        }
        if (Support.isEmpty(profileName)) {
            throw new IllegalArgumentException("profileName expected");
        }

        // read importprofile
        DefImportProfile ip = null;
        if (profileName.equalsIgnoreCase("200603")) {
            // read profile 200603
            ip = this.getWorkBookProfile200603(sheet);
        } else if (profileName.equalsIgnoreCase("200604")) {
            // read profile 200604
            ip = this.getWorkBookProfile200604(sheet);
        } else {
            // unknown profile
            throw new IllegalArgumentException("profileName:" +  profileName + " not supported");
        }


        return ip;
    }


    @Override
    public List<Record> readRecordBlock(Sheet sheet, DefImportBereich ibOrig, String type, Date defaultDate) throws Exception {
        // check parameter
        if (Support.isEmpty(sheet)) {
            throw new IllegalArgumentException("Sheet expected");
        }
        if (Support.isEmpty(ibOrig)) {
            throw new IllegalArgumentException("ImportBereich expected");
        }
        
        // define var
        DefImportBereichFonds ib = (DefImportBereichFonds)ibOrig;
        String src = sheet.getWorkBook().getFileName() + "-" +  sheet.getSheetName();
        HSSFSheet hssfSheet = sheet.getHssfSheet();
        List<Record> recordlist = new ArrayList<Record>();
        Anchor dateRow = ib.getDateRow();
        Anchor isinCol = ib.getIsinCol();
        Anchor nameCol = ib.getNameCol();
        Anchor betragCol = ib.getBetragCol();
        Anchor startCol = ib.getStartCol();
        Anchor endCol = ib.getEndCol();
        Anchor verkaufCol = ib.getVerkaufCol();
        Anchor countCol = ib.getCountCol();
        Anchor kursCol = ib.getKursCol();

        if (! Support.isEmpty(isinCol) && ! Support.isEmpty(countCol)
                && ! Support.isEmpty(kursCol)) {
         // read configured region
            int y1 = isinCol.getDy1();
            int y2 = isinCol.getDy2();

            short isinX = new Integer(isinCol.getDx1()).shortValue();
            short nameX = new Integer(nameCol.getDx1()).shortValue();
            short betragX = new Integer(betragCol.getDx1()).shortValue();
            short startX = new Integer(startCol.getDx1()).shortValue();
            short endX = new Integer(endCol.getDx1()).shortValue();
            short verkaufX = new Integer(verkaufCol.getDx1()).shortValue();
            short countX = new Integer(countCol.getDx1()).shortValue();
            short kursX = new Integer(kursCol.getDx1()).shortValue();

            // iterate rows
            for (int curRowNr = y1; curRowNr <= y2; curRowNr++) {
                // read columns
                HSSFCell isinCell = hssfSheet.getRow(curRowNr).getCell(isinX);
                HSSFCell nameCell = hssfSheet.getRow(curRowNr).getCell(nameX);
                HSSFCell betragCell = hssfSheet.getRow(curRowNr).getCell(betragX);
                HSSFCell startCell = hssfSheet.getRow(curRowNr).getCell(startX);
                HSSFCell endCell = hssfSheet.getRow(curRowNr).getCell(endX);
                HSSFCell verkaufCell = hssfSheet.getRow(curRowNr).getCell(verkaufX);
                HSSFCell countCell = hssfSheet.getRow(curRowNr).getCell(countX);
                HSSFCell kursCell = hssfSheet.getRow(curRowNr).getCell(kursX);

                // use only filled columns
                if (! Support.isEmpty(isinCell) &&  ! Support.isEmpty(countCell)
                        && ! Support.isEmpty(kursCell)) {
                    
                    // read data
                    String isin = isinCell.toString();
                    String name = nameCell.toString();
                    Float betrag = new Float(betragCell.getNumericCellValue());
                    Float count = new Float(countCell.getNumericCellValue());
                    Float kurs = new Float(kursCell.getNumericCellValue());
                    
                    // read date
                    Date date = defaultDate;
                    Date start = startCell.getDateCellValue();
                    Date end = endCell.getDateCellValue();
                    Date verkauf = verkaufCell.getDateCellValue();

                    // create record
                    RecordFonds record = new RecordFonds(src, type, date, isin, name, betrag, start, end, verkauf, count, kurs);
                    recordlist.add(record);
                }
            }
        }

        return recordlist;
    }


    /**
     * <h4>FeatureDomain:</h4>
     *     Finance
     * <h4>FeatureDescription:</h4>
     *     configure the ImportProfileFonds 200603 for the current sheet.
     *     Search for keywords and configure the regions where the data is found
     *     as DefImportBereiche.  
     * <h4>FeatureResult:</h4>
     *   <ul>
     *     <li>returnValue DefImportProfileFonds - the configured ImportProfile for this sheet
     *   </ul> 
     * <h4>FeatureKeywords:</h4>
     *     Finance
     * @param sheet - sheet to import
     * @return - configured profile
     * @throws Exception
     */
    public DefImportProfileFonds getWorkBookProfile200603(Sheet sheet) throws Exception {
        // check parameter
        if (Support.isEmpty(sheet)) {
            throw new IllegalArgumentException("Sheet expected");
        }

        // define vars
        DefImportBereichFonds ibFonds = null;
        Anchor searchAnchor = null;
        Anchor resSearchAnchor = null;

        // search for Ue "monatliche Anlage"
        searchAnchor = new Anchor(2, 2, 2, 1000);
        resSearchAnchor = this.searchForKeyword(sheet, searchAnchor, "monatliche Anlage");
        // search block
        if (resSearchAnchor != null) {
            // set startrow and endrow
            int startRow = resSearchAnchor.getDy1()+1;
            int endRow = resSearchAnchor.getDy1()+1;

            // search for first empty date-field
            int labelRow = resSearchAnchor.getDy1();
            endRow = 1000;
            searchAnchor = new Anchor(0, startRow, 0, endRow);
            resSearchAnchor = this.searchForKeyword(sheet, searchAnchor, "");
            if (resSearchAnchor != null) {
                endRow = resSearchAnchor.getDy1()-1;
            }

            // check start of fond-region
            if (checkIfKeyword(sheet, 1, labelRow, "Fond")
                    && checkIfKeyword(sheet, 2, labelRow, "monatliche Anlage")
                    && checkIfKeyword(sheet, 3, labelRow, "Depot")
                    && checkIfKeyword(sheet, 4, labelRow, "Start des Sparplans")
                    && checkIfKeyword(sheet, 5, labelRow, "Ende des Sparplans")
                    && checkIfKeyword(sheet, 6, labelRow, "Verkauf")
                    && checkIfKeyword(sheet, 7, labelRow, "Anteile")
                    && checkIfKeyword(sheet, 8, labelRow, "Kurs")
            ) {
                // define importregion between first and last empty date 
                Anchor dateCol = new Anchor(5, startRow, 5, endRow);
                Anchor isinCol = new Anchor(0, startRow, 0, endRow);
                Anchor nameCol = new Anchor(1, startRow, 1, endRow);
                Anchor betragCol = new Anchor(2, startRow, 2, endRow);
                Anchor startCol = new Anchor(4, startRow, 4, endRow);
                Anchor endCol = new Anchor(5, startRow, 5, endRow);
                Anchor verkaufCol = new Anchor(6, startRow, 6, endRow);
                Anchor countCol = new Anchor(7, startRow, 7, endRow);
                Anchor kursCol = new Anchor(8, startRow, 8, endRow);
                ibFonds = new DefImportBereichFonds(dateCol, true, isinCol, nameCol, betragCol, startCol, endCol, verkaufCol, countCol, kursCol);

            }
        }

        // create importprofile
        DefImportProfileFonds ip =
            new DefImportProfileFonds(ibFonds);

        return ip;
    }

    /**
     * <h4>FeatureDomain:</h4>
     *     Finance
     * <h4>FeatureDescription:</h4>
     *     configure the ImportProfileFonds 200604 for the current sheet.
     *     Search for keywords and configure the regions where the data is found
     *     as DefImportBereiche.  
     * <h4>FeatureResult:</h4>
     *   <ul>
     *     <li>returnValue DefImportProfileFonds - the configured ImportProfile for this sheet
     *   </ul> 
     * <h4>FeatureKeywords:</h4>
     *     Finance
     * @param sheet - sheet to import
     * @return - configured profile
     * @throws Exception
     */
    public DefImportProfileFonds getWorkBookProfile200604(Sheet sheet) throws Exception {
        // check parameter
        if (Support.isEmpty(sheet)) {
            throw new IllegalArgumentException("Sheet expected");
        }

        // define vars
        DefImportBereichFonds ibFonds = null;
        Anchor searchAnchor = null;
        Anchor resSearchAnchor = null;

        // search for Ue "monatliche Anlage"
        searchAnchor = new Anchor(2, 2, 2, 1000);
        resSearchAnchor = this.searchForKeyword(sheet, searchAnchor, "monatliche Anlage");
        // search block
        if (resSearchAnchor != null) {
            // set startrow and endrow
            int startRow = resSearchAnchor.getDy1()+1;
            int endRow = resSearchAnchor.getDy1()+1;

            // search for first empty date-field
            int labelRow = resSearchAnchor.getDy1();
            endRow = 1000;
            searchAnchor = new Anchor(0, startRow, 0, endRow);
            resSearchAnchor = this.searchForKeyword(sheet, searchAnchor, "");
            if (resSearchAnchor != null) {
                endRow = resSearchAnchor.getDy1()-1;
            }

            // check start of fond-region
            if (checkIfKeyword(sheet, 1, labelRow, "Fond")
                    && checkIfKeyword(sheet, 2, labelRow, "monatliche Anlage")
                    && checkIfKeyword(sheet, 3, labelRow, "Depotbank")
                    && checkIfKeyword(sheet, 4, labelRow, "Start des Sparplans")
                    && checkIfKeyword(sheet, 5, labelRow, "Ende des Sparplans")
                    && checkIfKeyword(sheet, 6, labelRow, "Verkauf")
                    && checkIfKeyword(sheet, 7, labelRow, "Anteile")
                    && checkIfKeyword(sheet, 8, labelRow, "Kurs")
            ) {
                // define importregion between first and last empty date 
                Anchor dateCol = new Anchor(5, startRow, 5, endRow);
                Anchor isinCol = new Anchor(0, startRow, 0, endRow);
                Anchor nameCol = new Anchor(1, startRow, 1, endRow);
                Anchor betragCol = new Anchor(2, startRow, 2, endRow);
                Anchor startCol = new Anchor(4, startRow, 4, endRow);
                Anchor endCol = new Anchor(5, startRow, 5, endRow);
                Anchor verkaufCol = new Anchor(6, startRow, 6, endRow);
                Anchor countCol = new Anchor(7, startRow, 7, endRow);
                Anchor kursCol = new Anchor(8, startRow, 8, endRow);
                ibFonds = new DefImportBereichFonds(dateCol, true, isinCol, nameCol, betragCol, startCol, endCol, verkaufCol, countCol, kursCol);

            }
        }

        // create importprofile
        DefImportProfileFonds ip =
            new DefImportProfileFonds(ibFonds);

        return ip;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final ExtractExcelSheetFonds ies = new ExtractExcelSheetFonds();
        try {
            ies.init(args[0]);
            ies.execute(args[1], args[2], args[3], args[4]);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ies.close();
        }
    }
}

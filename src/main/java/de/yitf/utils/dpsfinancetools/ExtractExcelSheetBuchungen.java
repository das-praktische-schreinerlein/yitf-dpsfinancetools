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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import de.yitf.utils.dpsfinancetools.Support.StatusConfig;

/**
 * <h4>FeatureDomain:</h4>
 *     finance
 * <h4>FeatureDescription:</h4>
 *     Importer for Buchungs-data from excel-sheets
 * 
 * @package de.mat.utils.imageimporteditor
 * @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
 * @category finance
 * @copyright Copyright (c) 2006-2014, Michael Schreiner
 * @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0
 */
public class ExtractExcelSheetBuchungen extends ExtractExcelSheet {

    /**
     *
     * define primary keywords
     *
     */
    public static String GROUP1_Weggehen = "Weggehen";
    public static String GROUP1_Einkaufen = "Einkaufen";
    public static String GROUP1_Klettern = "Klettern";
    public static String GROUP1_Imbiss = "Imbiss";
    public static String GROUP1_Bowlen = "Bowlen";
    public static String GROUP1_Urania = "Urania";
    public static String GROUP1_Urlaub = "Urlaub";
    public static String GROUP1_Investition = "Investition";
    public static String GROUP1_Harry = "Harry";
    public static String GROUP1_Arzt = "Arzt";
    public static String GROUP1_Kredit = "Kredit";
    public static String GROUP1_Rueckzahlung = "Rückzahlung";
    public static String GROUP1_Sonstiges = "Sonstiges";
    public static String GROUP1_Geschenk = "Geschenk";
    public static String GROUP1_Auto = "Auto";
    public static String GROUP1_Benzin = "Benzin";
    public static String GROUP1_Handy = "Handy";
    public static String GROUP1_Miete = "Miete";

    // define pattern
    public static String defaultPatternEnd = ".*";
    public static String defaultPatternStart = "^";
    public static Map<String, StatusConfig> patternConfigsGroup1 = 
                    new LinkedHashMap<String, StatusConfig>();
    static {
        // Optionen-Patter
        patternConfigsGroup1.put(GROUP1_Weggehen,
                new Support.StatusConfig(GROUP1_Weggehen,
                        Pattern.compile(defaultPatternStart + GROUP1_Weggehen + defaultPatternEnd),
                        GROUP1_Weggehen
                        ));
        patternConfigsGroup1.put(GROUP1_Einkaufen,
                new Support.StatusConfig(GROUP1_Einkaufen,
                        Pattern.compile(defaultPatternStart + GROUP1_Einkaufen + defaultPatternEnd),
                        GROUP1_Einkaufen
                        ));
        patternConfigsGroup1.put(GROUP1_Klettern,
                new Support.StatusConfig(GROUP1_Klettern,
                        Pattern.compile(defaultPatternStart + GROUP1_Klettern + defaultPatternEnd),
                        GROUP1_Klettern
                        ));
        patternConfigsGroup1.put(GROUP1_Imbiss,
                new Support.StatusConfig(GROUP1_Imbiss,
                        Pattern.compile(defaultPatternStart + GROUP1_Imbiss + defaultPatternEnd),
                        GROUP1_Imbiss
                        ));
        patternConfigsGroup1.put(GROUP1_Bowlen,
                new Support.StatusConfig(GROUP1_Bowlen,
                        Pattern.compile(defaultPatternStart + GROUP1_Bowlen + defaultPatternEnd),
                        GROUP1_Bowlen
                        ));
        patternConfigsGroup1.put(GROUP1_Urania,
                new Support.StatusConfig(GROUP1_Urania,
                        Pattern.compile(defaultPatternStart + GROUP1_Urania + defaultPatternEnd),
                        GROUP1_Urania
                        ));
        patternConfigsGroup1.put(GROUP1_Urlaub,
                new Support.StatusConfig(GROUP1_Urlaub,
                        Pattern.compile(defaultPatternStart + GROUP1_Urlaub + defaultPatternEnd),
                        GROUP1_Urlaub
                        ));
        patternConfigsGroup1.put(GROUP1_Investition,
                new Support.StatusConfig(GROUP1_Investition,
                        Pattern.compile(defaultPatternStart + GROUP1_Investition + defaultPatternEnd),
                        GROUP1_Investition
                        ));
        patternConfigsGroup1.put(GROUP1_Harry,
                new Support.StatusConfig(GROUP1_Harry,
                        Pattern.compile(defaultPatternStart + GROUP1_Harry + defaultPatternEnd),
                        GROUP1_Harry
                        ));
        patternConfigsGroup1.put(GROUP1_Arzt,
                new Support.StatusConfig(GROUP1_Arzt,
                        Pattern.compile(defaultPatternStart + GROUP1_Arzt + defaultPatternEnd),
                        GROUP1_Arzt
                        ));
        patternConfigsGroup1.put(GROUP1_Kredit,
                new Support.StatusConfig(GROUP1_Kredit,
                        Pattern.compile(defaultPatternStart + GROUP1_Kredit + defaultPatternEnd),
                        GROUP1_Kredit
                        ));
        patternConfigsGroup1.put(GROUP1_Rueckzahlung,
                new Support.StatusConfig(GROUP1_Rueckzahlung,
                        Pattern.compile(defaultPatternStart + GROUP1_Rueckzahlung + defaultPatternEnd),
                        GROUP1_Rueckzahlung
                        ));
        patternConfigsGroup1.put(GROUP1_Sonstiges,
                new Support.StatusConfig(GROUP1_Sonstiges,
                        Pattern.compile(defaultPatternStart + GROUP1_Sonstiges + defaultPatternEnd),
                        GROUP1_Sonstiges
                        ));
        patternConfigsGroup1.put(GROUP1_Geschenk,
                new Support.StatusConfig(GROUP1_Geschenk,
                        Pattern.compile(defaultPatternStart + GROUP1_Geschenk + defaultPatternEnd),
                        GROUP1_Geschenk
                        ));
        patternConfigsGroup1.put(GROUP1_Auto,
                new Support.StatusConfig(GROUP1_Auto,
                        Pattern.compile(defaultPatternStart + GROUP1_Auto + defaultPatternEnd),
                        GROUP1_Auto
                        ));
        patternConfigsGroup1.put(GROUP1_Benzin,
                new Support.StatusConfig(GROUP1_Benzin,
                        Pattern.compile(defaultPatternStart + GROUP1_Benzin + defaultPatternEnd),
                        GROUP1_Benzin
                        ));
        patternConfigsGroup1.put(GROUP1_Handy,
                new Support.StatusConfig(GROUP1_Handy,
                        Pattern.compile(defaultPatternStart + GROUP1_Handy + defaultPatternEnd),
                        GROUP1_Handy
                        ));
        patternConfigsGroup1.put(GROUP1_Miete,
                new Support.StatusConfig(GROUP1_Miete,
                        Pattern.compile(defaultPatternStart + GROUP1_Miete + defaultPatternEnd),
                        GROUP1_Miete
                        ));

        // export to Record
        RecordBuchungen.patternConfigsGroup1 = patternConfigsGroup1;
    }

    /**
     *
     * secondary keywords: URLAUB
     *
     */
    public static String GROUP2_Urlaub_Weggehen = "Urlaub: Weggehen";
    public static String GROUP2_Urlaub_Einkaufen = "Urlaub: Einkaufen";
    public static String GROUP2_Urlaub_Aktiv = "Urlaub: Aktiv";
    public static String GROUP2_Urlaub_Imbiss = "Urlaub: Imbiss";
    public static String GROUP2_Urlaub_Fahrkarte = "Urlaub: Fahrkarte";
    public static String GROUP2_Urlaub_Taxi = "Urlaub: Taxi";
    public static String GROUP2_Urlaub_Auto = "Urlaub: Auto";
    public static String GROUP2_Urlaub_Unterkunft = "Urlaub: Unterkunft";

    // define pattern
    public static Map<String, StatusConfig> patternConfigsGroup2 = 
                    new LinkedHashMap<String, StatusConfig>();
    static {
        // Optionen-Patter
        patternConfigsGroup2.put(GROUP2_Urlaub_Weggehen,
                new Support.StatusConfig(GROUP2_Urlaub_Weggehen,
                        Pattern.compile(defaultPatternStart + GROUP2_Urlaub_Weggehen + defaultPatternEnd),
                        GROUP2_Urlaub_Weggehen
                        ));
        patternConfigsGroup2.put(GROUP2_Urlaub_Einkaufen,
                new Support.StatusConfig(GROUP2_Urlaub_Einkaufen,
                        Pattern.compile(defaultPatternStart + GROUP2_Urlaub_Einkaufen + defaultPatternEnd),
                        GROUP2_Urlaub_Einkaufen
                        ));
        patternConfigsGroup2.put(GROUP2_Urlaub_Aktiv,
                new Support.StatusConfig(GROUP2_Urlaub_Aktiv,
                        Pattern.compile(defaultPatternStart + GROUP2_Urlaub_Aktiv + defaultPatternEnd),
                        GROUP2_Urlaub_Aktiv
                        ));
        patternConfigsGroup2.put(GROUP2_Urlaub_Imbiss,
                new Support.StatusConfig(GROUP2_Urlaub_Imbiss,
                        Pattern.compile(defaultPatternStart + GROUP2_Urlaub_Imbiss + defaultPatternEnd),
                        GROUP2_Urlaub_Imbiss
                        ));
        patternConfigsGroup2.put(GROUP2_Urlaub_Fahrkarte,
                new Support.StatusConfig(GROUP2_Urlaub_Fahrkarte,
                        Pattern.compile(defaultPatternStart + GROUP2_Urlaub_Fahrkarte + defaultPatternEnd),
                        GROUP2_Urlaub_Fahrkarte
                        ));
        patternConfigsGroup2.put(GROUP2_Urlaub_Taxi,
                new Support.StatusConfig(GROUP2_Urlaub_Taxi,
                        Pattern.compile(defaultPatternStart + GROUP2_Urlaub_Taxi + defaultPatternEnd),
                        GROUP2_Urlaub_Taxi
                        ));
        patternConfigsGroup2.put(GROUP2_Urlaub_Auto,
                new Support.StatusConfig(GROUP2_Urlaub_Auto,
                        Pattern.compile(defaultPatternStart + GROUP2_Urlaub_Auto + defaultPatternEnd),
                        GROUP2_Urlaub_Auto
                        ));
        patternConfigsGroup2.put(GROUP2_Urlaub_Unterkunft,
                new Support.StatusConfig(GROUP2_Urlaub_Unterkunft,
                        Pattern.compile(defaultPatternStart + GROUP2_Urlaub_Unterkunft + defaultPatternEnd),
                        GROUP2_Urlaub_Unterkunft
                        ));

        // export to Record
        RecordBuchungen.patternConfigsGroup2 = patternConfigsGroup2;
    }



    public static final Logger LOG = Logger.getLogger(ExtractExcelSheetBuchungen.class);

    public ExtractExcelSheetBuchungen() {
    }

    @Override
    public void execute(String fileName, String sheetName, String profileName, String defaultDateStr) throws Exception {
        // check parameter
        if (Support.isEmpty(profileName)) {
            throw new IllegalArgumentException("Profile expected");
        }

        // read sheet
        LOG.info("Lese Daten for " + fileName + " " + sheetName + " " + profileName);
        Sheet sheet = this.getWorkBookSheet(fileName, sheetName);

        // read importprofile
        DefImportProfileBuchungen ip =
            (DefImportProfileBuchungen) this.getWorkBookProfile(sheet, profileName);
        LOG.info("ImportProfile for " + fileName + " " + sheetName + " " + profileName + ip);

        // read records
        Map<String, List<Record>> recordMap = new HashMap<String, List<Record>>();
        Date defaultDate = Support.dateF.parse(defaultDateStr);
        recordMap.put("FixEinnahmen", this.readRecordBlock(sheet, ip.getIbFixEinnahmen(), "FixEinnahmen", defaultDate));
        recordMap.put("FixAusgaben", this.readRecordBlock(sheet, ip.getIbFixAusgaben(), "FixAusgaben", defaultDate));
        recordMap.put("SonderEinnahmen", this.readRecordBlock(sheet, ip.getIbSonderEinnahmen(), "SonderEinnahmen", defaultDate));
        recordMap.put("SonderAusgaben", this.readRecordBlock(sheet, ip.getIbSonderAusgaben(), "SonderAusgaben", defaultDate));
        recordMap.put("RegularAusgaben", this.readRecordBlock(sheet, ip.getIbRegularAusgaben(), "RegularAusgaben", defaultDate));

        // print Records
        LOG.info("eingelesene Records fuer " + fileName + " " + sheetName + " " + profileName);
        LOG.info("B_SRC;B_TYPE;B_DATE;B_BETRAG;B_DESC;GRUPPE1;GRUPPE2");
//        System.out.println("B_SRC;B_TYPE;B_DATE;B_BETRAG;B_DESC;GRUPPE1;GRUPPE2");
        for (Iterator<String> iter = recordMap.keySet().iterator(); iter.hasNext();) {
            List<Record> recordList = (List<Record>)recordMap.get(iter.next().toString());
            for (Iterator<Record> iterRecords = recordList.iterator(); iterRecords.hasNext();) {
                RecordBuchungen record = (RecordBuchungen)iterRecords.next();
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

        // read profile
        DefImportProfile ip = null;
        if (profileName.equalsIgnoreCase("200603")) {
            //read profile 200603
            ip = this.getWorkBookProfile200603(sheet);
        } else if (profileName.equalsIgnoreCase("200604")) {
                //read profile 200604
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
       
        // define vars
        DefImportBereichBuchungen ib = (DefImportBereichBuchungen)ibOrig;
        String src = sheet.getWorkBook().getFileName() + "-" +  sheet.getSheetName();
        HSSFSheet hssfSheet = sheet.getHssfSheet();
        List<Record> recordlist = new ArrayList<Record>();
        Anchor dateRow = ib.getDateRow();
        Anchor valueRow = ib.getValueRow();
        Anchor descRow = ib.getDescRow();

        if (! Support.isEmpty(valueRow) && ! Support.isEmpty(descRow)) {
            // read configured region
            int y1 = valueRow.getDy1();
            int y2 = valueRow.getDy2();
            short valueX = new Integer(valueRow.getDx1()).shortValue();
            short descX = new Integer(descRow.getDx1()).shortValue();
            short dateX = -1;
            if (! Support.isEmpty(dateRow) && ! ib.isFlagSetYear()) {
                dateX = new Integer(dateRow.getDx1()).shortValue();
            }

            // iterate rows
            for (int curRowNr = y1; curRowNr <= y2; curRowNr++) {
                // read columns
                HSSFCell valueCell = hssfSheet.getRow(curRowNr).getCell(valueX);
                HSSFCell descCell = hssfSheet.getRow(curRowNr).getCell(descX);
                // use only filled columns
                if (! Support.isEmpty(valueCell) &&  ! Support.isEmpty(descCell)) {
                    // read data
                    Float value = new Float(valueCell.getNumericCellValue());
                    String desc = descCell.toString();
                    
                    // use only valid columns
                    if (! Support.isEmpty(value) && (value.floatValue()>0)) {
                        // read date
                        Date date = defaultDate;
                        if ((dateX >= 0) && ! ib.isFlagSetYear()) {
                            HSSFCell dateCell = hssfSheet.getRow(curRowNr).getCell(dateX);
                            date = dateCell.getDateCellValue();
                        }
                        if (Support.isEmpty(desc)) {
                            desc = "UNBEKANNT";
                        }

                        // create record
                        RecordBuchungen record = new RecordBuchungen(src, type, date, value, desc);
                        recordlist.add(record);
                    }
                }
            }
        }

        return recordlist;
    }


    /**
     * <h4>FeatureDomain:</h4>
     *     Finance
     * <h4>FeatureDescription:</h4>
     *     configure the ImportProfileBuchung 200603 for the current sheet.
     *     Search for keywords and configure the regions where the data is found
     *     as DefImportBereiche.  
     * <h4>FeatureResult:</h4>
     *   <ul>
     *     <li>returnValue DefImportProfileBuchung - the configured ImportProfile for this sheet
     *   </ul> 
     * <h4>FeatureKeywords:</h4>
     *     Finance
     * @param sheet - sheet to import
     * @return - configured profile
     * @throws Exception
     */
    public DefImportProfile getWorkBookProfile200603(Sheet sheet) throws Exception {
        // check parameter
        if (Support.isEmpty(sheet)) {
            throw new IllegalArgumentException("Sheet expected");
        }

        // define vars
        DefImportBereichBuchungen ibFixEinnahmen = null;
        DefImportBereichBuchungen ibFixAusgaben = null;
        DefImportBereichBuchungen ibSonderEinnahmen = null;
        DefImportBereichBuchungen ibSonderAusgaben = null;
        DefImportBereichBuchungen ibRegularAusgaben = null;
        Anchor searchAnchor = null;
        Anchor resSearchAnchor = null;

        // search for Ue "Fix"
        searchAnchor = new Anchor(0, 2, 0, 100);
        resSearchAnchor = this.searchForKeyword(sheet, searchAnchor, "FIX");
        // search block
        if (resSearchAnchor != null) {
            // set startrow and endrow
            int startRow = 2;
            int endRow = resSearchAnchor.getDy1()-1;

            // search for header buchungen-region Einnahmen
            if (checkIfKeyword(sheet, 0, 0, "Einnahmen")
                    && checkIfKeyword(sheet, 0, 1, "Name")
                    && checkIfKeyword(sheet, 1, 1, "Betrag")) {
                    // define anchor between row 2 and found location "Fix"
                Anchor dateRow = null;
                Anchor valueRow = new Anchor(1, startRow, 1, endRow);
                Anchor descRow = new Anchor(0, startRow, 0, endRow);
                    ibFixEinnahmen = new DefImportBereichBuchungen(dateRow, true, valueRow, descRow);
            }

            // search for header buchungen-region Ausgaben
            if (checkIfKeyword(sheet, 2, 0, "Ausgaben")
                    && checkIfKeyword(sheet, 2, 1, "Name")
                    && checkIfKeyword(sheet, 5, 1, "Gesamtbetrag")
                    && checkIfKeyword(sheet, 8, 1, "Ü-Termien")) {
                // define anchor between row 2 and found location "Fix"
                Anchor dateRow = new Anchor(8, startRow, 8, endRow);
                Anchor valueRow = new Anchor(5, startRow, 5, endRow);
                Anchor descRow = new Anchor(2, startRow, 2, endRow);
                ibFixAusgaben = new DefImportBereichBuchungen(dateRow, true, valueRow, descRow);
            }

            // search for first empty date-field
            int labelRow = resSearchAnchor.getDy1()+1;
            startRow = resSearchAnchor.getDy1()+2;
            endRow = 1000;
            searchAnchor = new Anchor(0, startRow, 0, endRow);
            resSearchAnchor = this.searchForKeyword(sheet, searchAnchor, "");
            if (resSearchAnchor != null) {
                endRow = resSearchAnchor.getDy1()-1;
            }

            // search for header buchungen-region variable Einnahmen/Ausgaben
            if (checkIfKeyword(sheet, 1, labelRow, "Betrag")
                    && checkIfKeyword(sheet, 2, labelRow, "Einnahmen")
                    && checkIfKeyword(sheet, 3, labelRow, "Betrag")
                    && checkIfKeyword(sheet, 4, labelRow, "Sonderausgaben")
                    && checkIfKeyword(sheet, 5, labelRow, "Betrag")
                    && checkIfKeyword(sheet, 6, labelRow, "reg. Ausgaben")
            ) {
                // define importregion between first and last empty date 
                Anchor dateRow = new Anchor(0, startRow, 0, endRow);
                Anchor valueRow = new Anchor(1, startRow, 1, endRow);
                Anchor descRow = new Anchor(2, startRow, 2, endRow);
                ibSonderEinnahmen = new DefImportBereichBuchungen(dateRow, false, valueRow, descRow);

                valueRow = new Anchor(3, startRow, 3, endRow);
                descRow = new Anchor(4, startRow, 4, endRow);
                ibSonderAusgaben = new DefImportBereichBuchungen(dateRow, false, valueRow, descRow);

                valueRow = new Anchor(5, startRow, 5, endRow);
                descRow = new Anchor(6, startRow, 6, endRow);
                ibRegularAusgaben = new DefImportBereichBuchungen(dateRow, false, valueRow, descRow);
            }
        }

        // create importprofile
        DefImportProfileBuchungen ip =
            new DefImportProfileBuchungen(ibFixEinnahmen, ibFixAusgaben, ibSonderEinnahmen, ibSonderAusgaben, ibRegularAusgaben);

        return ip;
    }

    /**
     * <h4>FeatureDomain:</h4>
     *     Finance
     * <h4>FeatureDescription:</h4>
     *     configure the ImportProfileBuchung 200604 for the current sheet.
     *     Search for keywords and configure the regions where the data is found
     *     as DefImportBereiche.  
     * <h4>FeatureResult:</h4>
     *   <ul>
     *     <li>returnValue DefImportProfileBuchung - the configured ImportProfile for this sheet
     *   </ul> 
     * <h4>FeatureKeywords:</h4>
     *     Finance
     * @param sheet - sheet to import
     * @return - configured profile
     * @throws Exception
     */
    public DefImportProfile getWorkBookProfile200604(Sheet sheet) throws Exception {
        // check parameter
        if (Support.isEmpty(sheet)) {
            throw new IllegalArgumentException("Sheet expected");
        }

        // define vars
        DefImportBereichBuchungen ibFixEinnahmen = null;
        DefImportBereichBuchungen ibFixAusgaben = null;
        DefImportBereichBuchungen ibSonderEinnahmen = null;
        DefImportBereichBuchungen ibSonderAusgaben = null;
        DefImportBereichBuchungen ibRegularAusgaben = null;
        Anchor searchAnchor = null;
        Anchor resSearchAnchor = null;

        // search for Ue "Fix"
        searchAnchor = new Anchor(0, 2, 0, 100);
        resSearchAnchor = this.searchForKeyword(sheet, searchAnchor, "FIX");
        // search block
        if (resSearchAnchor != null) {
            // set startrow and endrow
            int startRow = 4;
            int endRow = resSearchAnchor.getDy1()-1;

            // search for header buchungen-region Einnahmen
            if (checkIfKeyword(sheet, 0, startRow-2, "Einnahmen")
                    && checkIfKeyword(sheet, 0, startRow-1, "Name")
                    && checkIfKeyword(sheet, 1, startRow-1, "Betrag")) {
                    // define anchor between row 4 and found location "Fix"
                Anchor dateRow = null;
                Anchor valueRow = new Anchor(1, startRow, 1, endRow);
                Anchor descRow = new Anchor(0, startRow, 0, endRow);
                    ibFixEinnahmen = new DefImportBereichBuchungen(dateRow, true, valueRow, descRow);
            }

            // search for header buchungen-region Ausgaben
            if (checkIfKeyword(sheet, 2, startRow-2, "Ausgaben")
                    && checkIfKeyword(sheet, 2, startRow-1, "Name")
                    && checkIfKeyword(sheet, 5, startRow-1, "Gesamtbetrag")
                    && checkIfKeyword(sheet, 8, startRow-1, "Ü-Termien")) {
                // define anchor between row 4 and found location "Fix"
                Anchor dateRow = new Anchor(8, startRow, 8, endRow);
                Anchor valueRow = new Anchor(5, startRow, 5, endRow);
                Anchor descRow = new Anchor(2, startRow, 2, endRow);
                ibFixAusgaben = new DefImportBereichBuchungen(dateRow, true, valueRow, descRow);
            }

            // search for first empty date-field
            int labelRow = resSearchAnchor.getDy1()+4;
            startRow = resSearchAnchor.getDy1()+5;
            endRow = 1000;
            searchAnchor = new Anchor(0, startRow, 0, endRow);
            resSearchAnchor = this.searchForKeyword(sheet, searchAnchor, "");
            if (resSearchAnchor != null) {
                endRow = resSearchAnchor.getDy1()-1;
            }

            // search for header buchungen-region variable Einnahmen/Ausgaben
            if (checkIfKeyword(sheet, 1, labelRow, "Betrag")
                    && checkIfKeyword(sheet, 2, labelRow, "Einnahmen")
                    && checkIfKeyword(sheet, 3, labelRow, "Betrag")
                    && checkIfKeyword(sheet, 4, labelRow, "Sonderausgaben")
                    && checkIfKeyword(sheet, 5, labelRow, "Betrag")
                    && checkIfKeyword(sheet, 6, labelRow, "regelmässige Ausgaben")
            ) {
                // define importregion between first and last empty date 
                Anchor dateRow = new Anchor(0, startRow, 0, endRow);
                Anchor valueRow = new Anchor(1, startRow, 1, endRow);
                Anchor descRow = new Anchor(2, startRow, 2, endRow);
                ibSonderEinnahmen = new DefImportBereichBuchungen(dateRow, false, valueRow, descRow);

                valueRow = new Anchor(3, startRow, 3, endRow);
                descRow = new Anchor(4, startRow, 4, endRow);
                ibSonderAusgaben = new DefImportBereichBuchungen(dateRow, false, valueRow, descRow);

                valueRow = new Anchor(5, startRow, 5, endRow);
                descRow = new Anchor(6, startRow, 6, endRow);
                ibRegularAusgaben = new DefImportBereichBuchungen(dateRow, false, valueRow, descRow);
            }
        }

        // create importprofile
        DefImportProfileBuchungen ip =
            new DefImportProfileBuchungen(ibFixEinnahmen, ibFixAusgaben, ibSonderEinnahmen, ibSonderAusgaben, ibRegularAusgaben);

        return ip;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final ExtractExcelSheetBuchungen ies = new ExtractExcelSheetBuchungen();
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

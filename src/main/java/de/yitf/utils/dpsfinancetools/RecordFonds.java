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

import java.util.Date;

/**
 * <h4>FeatureDomain:</h4>
 *     finance
 * <h4>FeatureDescription:</h4>
 *     record with Fonds-data from a excel-sheet
 * 
 * @package de.mat.utils.imageimporteditor
 * @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
 * @category finance
 * @copyright Copyright (c) 2006-2014, Michael Schreiner
 * @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0
 */
public class RecordFonds extends Record{

    public String isin = null;
    public String name = null;
    public Float betrag = null;
    public Date start = null;
    public Date end = null;
    public Date verkauf = null;
    public Float count = null;
    public Float kurs = null;

    public RecordFonds(String src, String type, Date date, String isin,
            String name, Float betrag, Date start, Date end, Date verkauf,
            Float count, Float kurs) {
        super(src, type, date);
        this.isin = isin;
        this.name = name;
        this.betrag = betrag;
        this.start = start;
        this.end = end;
        this.verkauf = verkauf;
        this.count = count;
        this.kurs = kurs;
    }

    /**
     * @return the isin
     */
    public String getIsin() {
        return isin;
    }

    /**
     * @param isin the isin to set
     */
    public void setIsin(String isin) {
        this.isin = isin;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the betrag
     */
    public Float getBetrag() {
        return betrag;
    }

    /**
     * @param betrag the betrag to set
     */
    public void setBetrag(Float betrag) {
        this.betrag = betrag;
    }

    /**
     * @return the start
     */
    public Date getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public Date getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     * @return the verkauf
     */
    public Date getVerkauf() {
        return verkauf;
    }

    /**
     * @param verkauf the verkauf to set
     */
    public void setVerkauf(Date verkauf) {
        this.verkauf = verkauf;
    }

    /**
     * @return the count
     */
    public Float getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(Float count) {
        this.count = count;
    }

    /**
     * @return the kurs
     */
    public Float getKurs() {
        return kurs;
    }

    /**
     * @param kurs the kurs to set
     */
    public void setKurs(Float kurs) {
        this.kurs = kurs;
    }

    public String toString() {
        String betragStr = Support.dF.format(betrag);
        String countStr = Support.dF.format(count);
        String kursStr = Support.dF.format(kurs);
        String startStr = Support.dateF.format(start);
        String endeStr = Support.dateF.format(end);
        String verkaufStr = Support.dateF.format(verkauf);
        return super.toString() + ";" + isin+";" + name  + ";" + betragStr
            + ";" + startStr + ";" + endeStr + ";"
            + verkaufStr + ";" + countStr + ";" + kursStr;
    }
}

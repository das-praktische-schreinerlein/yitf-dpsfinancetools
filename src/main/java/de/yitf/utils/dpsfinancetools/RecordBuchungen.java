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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * <h4>FeatureDomain:</h4>
 *     finance
 * <h4>FeatureDescription:</h4>
 *     record with Buchung-data from a excel-sheet
 * 
 * @package de.mat.utils.imageimporteditor
 * @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
 * @category finance
 * @copyright Copyright (c) 2006-2014, Michael Schreiner
 * @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0
 */
public class RecordBuchungen extends Record{

    public String src = null;
    public String type = null;
    public Float betrag = null;
    public Date datum = null;
    public String desc = null;
    public static Map patternConfigsGroup1 = new LinkedHashMap();
    public static Map patternConfigsGroup2 = new LinkedHashMap();

    public RecordBuchungen(String src, String type, Date datum, Float betrag, String desc) {
        super(src, type, datum);
        this.betrag = betrag;
        this.desc = desc;
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
     * @return the datum
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    public String getDescGroup1() {
        String descGroup = desc;
        if (Support.isEmpty(descGroup)) {
            return descGroup;
        }

        descGroup.trim();
        // Gruppen extrahieren
        for (Iterator iter = patternConfigsGroup1.values().iterator();iter.hasNext();) {
            Support.StatusConfig statusConfig = (Support.StatusConfig)iter.next();
            Matcher matcher = statusConfig.pattern.matcher(descGroup);
            if (matcher.matches()) {
                descGroup = statusConfig.key;
                return descGroup;
            }
        }

        if (! Support.isEmpty(descGroup) && descGroup.indexOf(":") > 0) {
            descGroup = descGroup.substring(0, descGroup.indexOf(":"));
            descGroup.trim();
        }

        return descGroup;
    }

    public String getDescGroup2() {
        String descGroup = desc;
        if (Support.isEmpty(descGroup)) {
            return descGroup;
        }

        descGroup.trim();
        // Gruppen extrahieren
        for (Iterator iter = patternConfigsGroup2.values().iterator();iter.hasNext();) {
            Support.StatusConfig statusConfig = (Support.StatusConfig)iter.next();
            Matcher matcher = statusConfig.pattern.matcher(descGroup);
            if (matcher.matches()) {
                descGroup = statusConfig.key;
                return descGroup;
            }
        }

        if (! Support.isEmpty(descGroup) && descGroup.indexOf("-") > 0) {
            descGroup = descGroup.substring(0, descGroup.indexOf("-"));
            descGroup.trim();
        }

        return descGroup;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String toString() {
        String betragStr = Support.dF.format(betrag);
        return super.toString() + ";" + betragStr
        + ";" + desc+";" + getDescGroup1() + ";" + getDescGroup2();
    }
}

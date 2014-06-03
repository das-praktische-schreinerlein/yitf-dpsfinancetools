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

/**
 * <h4>FeatureDomain:</h4>
 *     finance
 * <h4>FeatureDescription:</h4>
 *     definition of the the importregion for Fonds in excel-sheets
 * 
 * @package de.mat.utils.imageimporteditor
 * @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
 * @category finance
 * @copyright Copyright (c) 2006-2014, Michael Schreiner
 * @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0
 */
public class DefImportBereichFonds extends DefImportBereich{
    Anchor isinCol;
    Anchor nameCol;
    Anchor betragCol;
    Anchor startCol;
    Anchor endCol;
    Anchor verkaufCol;
    Anchor countCol;
    Anchor kursCol;


    public DefImportBereichFonds(Anchor dateCol, boolean flagSetYear,
            Anchor isinCol, Anchor nameCol, Anchor betragCol, Anchor startCol,
            Anchor endCol, Anchor verkaufCol, Anchor countCol, Anchor kursCol) {
        super();
        this.dateRow = dateCol;
        this.flagSetYear = flagSetYear;
        this.isinCol = isinCol;
        this.nameCol = nameCol;
        this.betragCol = betragCol;
        this.startCol = startCol;
        this.endCol = endCol;
        this.verkaufCol = verkaufCol;
        this.countCol = countCol;
        this.kursCol = kursCol;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "ImportBereichFonds [betragCol=" + betragCol + ", countCol="
                + countCol + ", dateRow=" + dateRow + ", endCol=" + endCol
                + ", flagSetYear=" + flagSetYear + ", isinCol=" + isinCol
                + ", kursCol=" + kursCol + ", nameCol=" + nameCol
                + ", startCol=" + startCol + ", verkaufCol=" + verkaufCol + "]";
    }

    /**
     * @return the isinCol
     */
    public Anchor getIsinCol() {
        return isinCol;
    }

    /**
     * @param isinCol the isinCol to set
     */
    public void setIsinCol(Anchor isinCol) {
        this.isinCol = isinCol;
    }

    /**
     * @return the nameCol
     */
    public Anchor getNameCol() {
        return nameCol;
    }

    /**
     * @param nameCol the nameCol to set
     */
    public void setNameCol(Anchor nameCol) {
        this.nameCol = nameCol;
    }

    /**
     * @return the betragCol
     */
    public Anchor getBetragCol() {
        return betragCol;
    }

    /**
     * @param betragCol the betragCol to set
     */
    public void setBetragCol(Anchor betragCol) {
        this.betragCol = betragCol;
    }

    /**
     * @return the startCol
     */
    public Anchor getStartCol() {
        return startCol;
    }

    /**
     * @param startCol the startCol to set
     */
    public void setStartCol(Anchor startCol) {
        this.startCol = startCol;
    }

    /**
     * @return the endCol
     */
    public Anchor getEndCol() {
        return endCol;
    }

    /**
     * @param endCol the endCol to set
     */
    public void setEndCol(Anchor endCol) {
        this.endCol = endCol;
    }

    /**
     * @return the verkaufCol
     */
    public Anchor getVerkaufCol() {
        return verkaufCol;
    }

    /**
     * @param verkaufCol the verkaufCol to set
     */
    public void setVerkaufCol(Anchor verkaufCol) {
        this.verkaufCol = verkaufCol;
    }

    /**
     * @return the countCol
     */
    public Anchor getCountCol() {
        return countCol;
    }

    /**
     * @param countCol the countCol to set
     */
    public void setCountCol(Anchor countCol) {
        this.countCol = countCol;
    }

    /**
     * @return the kursCol
     */
    public Anchor getKursCol() {
        return kursCol;
    }

    /**
     * @param kursCol the kursCol to set
     */
    public void setKursCol(Anchor kursCol) {
        this.kursCol = kursCol;
    }

}

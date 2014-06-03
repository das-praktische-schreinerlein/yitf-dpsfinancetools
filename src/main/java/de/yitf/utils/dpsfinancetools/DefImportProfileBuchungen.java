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
 *     definition of the importprofile for Buchungen in excel-sheets
 * 
 * @package de.mat.utils.imageimporteditor
 * @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
 * @category finance
 * @copyright Copyright (c) 2006-2014, Michael Schreiner
 * @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0
 */
public class DefImportProfileBuchungen extends DefImportProfile {

    DefImportBereichBuchungen ibFixEinnahmen;
    DefImportBereichBuchungen ibFixAusgaben;
    DefImportBereichBuchungen ibSonderEinnahmen;
    DefImportBereichBuchungen ibSonderAusgaben;
    DefImportBereichBuchungen ibRegularAusgaben;

    public DefImportProfileBuchungen() {
    }

    public DefImportProfileBuchungen(DefImportBereichBuchungen ibFixEinnahmen,
            DefImportBereichBuchungen ibFixAusgaben, DefImportBereichBuchungen ibSonderEinnahmen,
            DefImportBereichBuchungen ibSonderAusgaben, DefImportBereichBuchungen ibRegularAusgaben) {
        this();
        this.ibFixEinnahmen = ibFixEinnahmen;
        this.ibFixAusgaben = ibFixAusgaben;
        this.ibSonderEinnahmen = ibSonderEinnahmen;
        this.ibSonderAusgaben = ibSonderAusgaben;
        this.ibRegularAusgaben = ibRegularAusgaben;
    }

    public String toString() {
        return "ImportProfile "
           + " ibFixEinnahmen:" + ibFixEinnahmen + "\n"
           + " ibFixAusgaben:" + ibFixAusgaben + "\n"
           + " ibSonderEinnahmen:" + ibSonderEinnahmen + "\n"
           + " ibSonderAusgaben:" + ibSonderAusgaben + "\n"
           + " ibRegularAusgaben:" + ibRegularAusgaben + "\n";
    }

    /**
     * @return the ibFixEinnahmen
     */
    public DefImportBereichBuchungen getIbFixEinnahmen() {
        return ibFixEinnahmen;
    }

    /**
     * @param ibFixEinnahmen the ibFixEinnahmen to set
     */
    public void setIbFixEinnahmen(DefImportBereichBuchungen ibFixEinnahmen) {
        this.ibFixEinnahmen = ibFixEinnahmen;
    }

    /**
     * @return the ibFixAusgaben
     */
    public DefImportBereichBuchungen getIbFixAusgaben() {
        return ibFixAusgaben;
    }

    /**
     * @param ibFixAusgaben the ibFixAusgaben to set
     */
    public void setIbFixAusgaben(DefImportBereichBuchungen ibFixAusgaben) {
        this.ibFixAusgaben = ibFixAusgaben;
    }

    /**
     * @return the ibSonderEinnahmen
     */
    public DefImportBereichBuchungen getIbSonderEinnahmen() {
        return ibSonderEinnahmen;
    }

    /**
     * @param ibSonderEinnahmen the ibSonderEinnahmen to set
     */
    public void setIbSonderEinnahmen(DefImportBereichBuchungen ibSonderEinnahmen) {
        this.ibSonderEinnahmen = ibSonderEinnahmen;
    }

    /**
     * @return the ibSonderAusgaben
     */
    public DefImportBereichBuchungen getIbSonderAusgaben() {
        return ibSonderAusgaben;
    }

    /**
     * @param ibSonderAusgaben the ibSonderAusgaben to set
     */
    public void setIbSonderAusgaben(DefImportBereichBuchungen ibSonderAusgaben) {
        this.ibSonderAusgaben = ibSonderAusgaben;
    }

    /**
     * @return the ibRegularAusgaben
     */
    public DefImportBereichBuchungen getIbRegularAusgaben() {
        return ibRegularAusgaben;
    }

    /**
     * @param ibRegularAusgaben the ibRegularAusgaben to set
     */
    public void setIbRegularAusgaben(DefImportBereichBuchungen ibRegularAusgaben) {
        this.ibRegularAusgaben = ibRegularAusgaben;
    }
}

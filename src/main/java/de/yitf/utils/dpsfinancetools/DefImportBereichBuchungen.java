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
 *     definition of the importregion for Buchungen in excel-sheets
 * 
 * @package de.mat.utils.imageimporteditor
 * @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
 * @category finance
 * @copyright Copyright (c) 2006-2014, Michael Schreiner
 * @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0
 */
public class DefImportBereichBuchungen extends DefImportBereich {
    Anchor valueRow;
    Anchor descRow;

    public DefImportBereichBuchungen(Anchor dateRow, boolean flagSetYear,
            Anchor valueRow, Anchor descRow) {
        super();
        this.dateRow = dateRow;
        this.flagSetYear = flagSetYear;
        this.valueRow = valueRow;
        this.descRow = descRow;
    }

    public String toString() {
        return "[ImportBereich "
           + " {dateRow:" + dateRow + "}"
           + " {flagSetYear:" + flagSetYear + "}"
           + " {valueRow:" + valueRow + "}"
           + " {descRow:" + descRow +  "}]";
    }

    /**
     * @return the valueRow
     */
    public Anchor getValueRow() {
        return valueRow;
    }
    /**
     * @param valueRow the valueRow to set
     */
    public void setValueRow(Anchor valueRow) {
        this.valueRow = valueRow;
    }
    /**
     * @return the descRow
     */
    public Anchor getDescRow() {
        return descRow;
    }
    /**
     * @param descRow the descRow to set
     */
    public void setDescRow(Anchor descRow) {
        this.descRow = descRow;
    }
}

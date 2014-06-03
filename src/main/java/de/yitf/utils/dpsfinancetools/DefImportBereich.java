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
 *     abstract definition of a importregion in excel-sheets
 * 
 * @package de.mat.utils.imageimporteditor
 * @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
 * @category finance
 * @copyright Copyright (c) 2006-2014, Michael Schreiner
 * @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0
 */
public abstract class DefImportBereich {
    Anchor dateRow;
    boolean flagSetYear = false;

    /**
     * @return the dateRowStart
     */
    public Anchor getDateRow() {
        return dateRow;
    }
    /**
     * @param dateRow the dateRow to set
     */
    public void setDateRow(Anchor dateRow) {
        this.dateRow = dateRow;
    }
    /**
     * @return the flagSetYear
     */
    public boolean isFlagSetYear() {
        return flagSetYear;
    }
    /**
     * @param flagSetYear the flagSetYear to set
     */
    public void setFlagSetYear(boolean flagSetYear) {
        this.flagSetYear = flagSetYear;
    }
}

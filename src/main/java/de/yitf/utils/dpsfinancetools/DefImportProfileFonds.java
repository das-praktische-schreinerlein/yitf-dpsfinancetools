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
 *     definition of the importprofile for Fonds in excel-sheet
 * 
 * @package de.mat.utils.imageimporteditor
 * @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
 * @category finance
 * @copyright Copyright (c) 2006-2014, Michael Schreiner
 * @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0
 */
public class DefImportProfileFonds extends DefImportProfile {

    DefImportBereichFonds ibFonds;

    public DefImportProfileFonds() {
    }

    public DefImportProfileFonds(DefImportBereichFonds ibFonds) {
        super();
        this.ibFonds = ibFonds;
    }

    /**
     * @return the ibFonds
     */
    public DefImportBereichFonds getIbFonds() {
        return ibFonds;
    }

    /**
     * @param ibFonds the ibFonds to set
     */
    public void setIbFonds(DefImportBereichFonds ibFonds) {
        this.ibFonds = ibFonds;
    }


}

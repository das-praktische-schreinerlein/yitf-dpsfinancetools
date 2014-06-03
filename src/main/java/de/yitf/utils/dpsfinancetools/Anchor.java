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

import org.apache.poi.hssf.usermodel.HSSFChildAnchor;

/**
 * <h4>FeatureDomain:</h4>
 *     finance
 * <h4>FeatureDescription:</h4>
 *     encapsulate the Anchor-implementation of POI
 * 
 * @package de.yitf.utils.dpsfinancetools
 * @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
 * @category finance
 * @copyright Copyright (c) 2006-2014, Michael Schreiner
 * @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0
 */
public class Anchor extends HSSFChildAnchor {

    public Anchor (int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    public String toString() {
        return "Pos("
            + this.getDx1() + ","
            + this.getDy1() + ","
            + this.getDx2() + ","
            + this.getDy2() + ")";
    }
}

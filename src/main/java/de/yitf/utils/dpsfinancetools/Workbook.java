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

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * <h4>FeatureDomain:</h4>
 *     finance
 * <h4>FeatureDescription:</h4>
 *     encapsulate the Workbook-implementation of POI
 * 
 * @package de.mat.utils.imageimporteditor
 * @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
 * @category finance
 * @copyright Copyright (c) 2006-2014, Michael Schreiner
 * @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0
 */
public class Workbook {
    String fileName = null;
    HSSFWorkbook hssfWorkbook = null;

    public Workbook(String fileName, HSSFWorkbook hssfWorkbook) {
        super();
        this.fileName = fileName;
        this.hssfWorkbook = hssfWorkbook;
    }
    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }
    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    /**
     * @return the hssfWorkbook
     */
    public HSSFWorkbook getHssfWorkbook() {
        return hssfWorkbook;
    }
    /**
     * @param hssfWorkbook the hssfWorkbook to set
     */
    public void setHssfWorkbook(HSSFWorkbook hssfWorkbook) {
        this.hssfWorkbook = hssfWorkbook;
    }
}

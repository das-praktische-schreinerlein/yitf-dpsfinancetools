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

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * <h4>FeatureDomain:</h4>
 *     finance
 * <h4>FeatureDescription:</h4>
 *     some support-functions and utils
 * 
 * @package de.mat.utils.imageimporteditor
 * @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
 * @category finance
 * @copyright Copyright (c) 2006-2014, Michael Schreiner
 * @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0
 */
public class Support {

    public static final SimpleDateFormat dateF = new SimpleDateFormat("dd.MM.yyyy");
    public static final DecimalFormat dF = new DecimalFormat ( ",##0.00" );

    static class StatusConfig {
        public String key = null;
        public Pattern pattern = null;
        public String status = null;

        public StatusConfig(String key, Pattern pattern, String status) {
            super();
            this.key = key;
            this.pattern = pattern;
            this.status = status;
        }
    }

    public static boolean isEmpty(Object obj) {
        if (obj instanceof String) {
            return ((String) obj).length() == 0;
        } else if (obj == null) {
            return true;
        } else if (obj.getClass().isArray()) {
            // Array -> Typ testen
            final Class objClass = obj.getClass().getComponentType();
            if (!objClass.isPrimitive()) {
                // Object-Array
                return ((Object[]) obj).length == 0;
            }
            final String className = objClass.getName();
            if ("boolean".equals(className)) {
                return ((boolean[]) obj).length == 0;
            }
            if ("byte".equals(className)) {
                return ((byte[]) obj).length == 0;
            }
            if ("char".equals(className)) {
                return ((char[]) obj).length == 0;
            }
            if ("int".equals(className)) {
                return ((int[]) obj).length == 0;
            }
            if ("long".equals(className)) {
                return ((long[]) obj).length == 0;
            }
            if ("float".equals(className)) {
                return ((float[]) obj).length == 0;
            }
            if ("double".equals(className)) {
                return ((double[]) obj).length == 0;
            }
            throw new IllegalArgumentException(obj.toString());
        } else if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        } else if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        } else {
            return false;
        }
    }
}

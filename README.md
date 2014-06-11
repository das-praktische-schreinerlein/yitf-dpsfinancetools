yitf-dpsfinancetools - "Das praktische Schreinerlein" - Finanztools
=====================

# Desc
A toolset for financial planning and management
It contains Excel-sheets and some java-progs to convert data between those sheets.
But be aware, all Excel-Sheets are in German ;-)

## "Finanzplanung"
With excel/finanzplanung.xls you can configure and play finance scenarios like: 
how will your financial situation be if you are unemployed or how will it develop if you buy your 
own house.
 
## "Haushaltsbuch"
With excel/haushaltsbuch.xls you can plan and document all your expenses.

## "Finanzübersicht"
After data-export from "Finanzplanung" with the javaprogs, you can
analyse them in excel/finanzuebersicht.xls. It gives you an overview over your
expenses or visualize trends with the help of charts etc.

# TODO for me
- [ ] documentation
- [ ] use and optimize it :-)

# History and milestones
- 2014 
   - prepared the tools for going public (documentation...) 
   - separated the public-tools
- 2013
   - first version of finanzplanung.xls
- 2007
   - java-progs and first version of finanzuebersicht.xls
- 2006
   - extended version of the excel haushaltsbuch.xls
- 2003
   - initial version of the excel haushaltsbuch.xls

# Requires
- for building
   - maven
   - IDE (I built it with eclipse)
- to use
   - excel
- to manage and synchronize
   - java

# Install
- save the project to 
```bat
D:\public_projects\dpsfinance
```

- import project to Eclipse

- run maven 
```bat
cd d:\public_projects\dpsfinance
mvn compile
mvn org.apache.maven.plugins:maven-assembly-plugin:assembly
```

# Configure
- update pathes in 
   - config/config-dpsfinance.bat

# Example
- change
   - excel/finanzplanung.xls
   - excel/haushaltsbuch.xls
   - excel/finanzuebersicht.xls
   - excel/extractBuchungen.bat
   - excel/extractFonds.bat

- change
```bat
cd d:\public_projects\dpsfinance
excel\extractBuchungen.bat
excel\extractFonds.bat
```
Then open excel/finanzuebersicht.xls and update the sheets "Buchungen", "Fonds".

# Thanks to
- https://github.com/apache/poi

# License
```bat
/**
 * @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
 * @category finance
 * @copyright Copyright (c) 2003-2014, Michael Schreiner
 * @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
```

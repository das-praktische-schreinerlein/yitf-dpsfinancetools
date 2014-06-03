rem <h4>FeatureDomain:</h4>
rem     Publishing
rem <h4>FeatureDescription:</h4>
rem     export variables and config for use of pdftools
rem 
rem @package de.mat.utils.pdftools
rem @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
rem @category Publishing
rem @copyright Copyright (c) 2011-2014, Michael Schreiner
rem @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0


rem set mypath
set DPSFINANCECONFIGBASEPATH=%~dp0
set DPSFINANCETOOLBASEPATH=%DPSFINANCECONFIGBASEPATH%..\sbin\

rem set cmd
set CP="%DPSFINANCETOOLBASEPATH%..\target\dpsfinancetools-1.0-SNAPSHOT-jar-with-dependencies.jar"
set JAVAOPTIONS=-Xmx512m -Xms128m -Dlog4j.configuration=file:%DPSFINANCECONFIGBASEPATH%\log4j.properties

set CFG="%DPSFINANCECONFIGBASEPATH%\conf"
set PROG_EXTRACTBUCHUNGEN=de.yitf.utils.dpsfinancetools.ExtractExcelSheetBuchungen
set PROG_EXTRACTFONDS=de.yitf.utils.dpsfinancetools.ExtractExcelSheetFonds


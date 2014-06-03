echo off
rem <h4>FeatureDomain:</h4>
rem     Fiance
rem <h4>FeatureDescription:</h4>
rem     extract Fonds from the haushaltsbuch-Excelsheet
rem 
rem @author Michael Schreiner <michael.schreiner@your-it-fellow.de>
rem @category Finance
rem @copyright Copyright (c) 2006-2014, Michael Schreiner
rem @license http://mozilla.org/MPL/2.0/ Mozilla Public License 2.0

rem set mypath
set EXAMPLEBASEPATH=%~dp0
set DPSFINANCEBASEPATH=%EXAMPLEBASEPATH%\..\
set DPSFINANCESCRIPTPATH=%DPSFINANCEBASEPATH%\sbin

rem init configs
call %DPSFINANCEBASEPATH%\config\config-dpsfinance.bat

rem configure
set CMD=java %JAVAOPTIONS% -cp %CP% %PROG_EXTRACTFONDS% %CFG%
set EXCELFILE=%EXAMPLEBASEPATH%\haushaltsbuch.xls
set PROFILE=200604
set OUTFILE=%EXAMPLEBASEPATH%\fonds.csv


rem change CodePage
CHCP 1252 > null

rem start Imports
set YEAR=2013
echo F_SRC;F_TYPE;F_DATE;F_ISIN;F_FOND;F_BETRAG;F_START;F_ENDE;F_VERKAUF;F_COUNT;F_KURS > %OUTFILE%

set YEAR=2013
%CMD% %EXCELFILE% "Oktober %YEAR%" %PROFILE% 01.10.%YEAR%  >> %OUTFILE%
%CMD% %EXCELFILE% "November %YEAR%" %PROFILE% 01.11.%YEAR%  >> %OUTFILE%
%CMD% %EXCELFILE% "Dezember %YEAR%" %PROFILE% 01.12.%YEAR%  >> %OUTFILE%

set YEAR=2014
%CMD% %EXCELFILE% "Januar %YEAR%" %PROFILE% 01.01.%YEAR%  >> %OUTFILE%

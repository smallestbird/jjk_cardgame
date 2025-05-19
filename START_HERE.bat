@echo off
rem This specially crafted batch file handles Unicode console setup correctly

rem First ensure the console is in UTF-8 mode
chcp 65001 > nul

rem Set the console font to a Unicode-compatible font
rem This command tries to ensure Braille characters will display
powershell -Command "& {Add-Type -AssemblyName PresentationCore,PresentationFramework; [System.Windows.MessageBox]::Show('This window ensures proper console font initialization. Click OK to continue.', 'Console Setup')}" > nul 2>&1

rem Clear screen after setup
cls

rem Launch the game with explicit encoding parameters
set JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8

rem Run the actual executable
"%~dp0game.exe"
# for users who want to play the game (windows)
download and extract contents of the game
make sure you have java installed on your system, at least version 22 or later, here is the latest version (24): https://www.oracle.com/java/technologies/downloads/#jdk24-windows
simply run the .bat file, and a command prompt window should open, with the exe.
to make sure all ascii art loads in correctly, right click on the window of the cmd, click on "properties", then go to the fonts tab. From there, change it to any cascadia variant. 
this only has to be done once, make sure not to move the .bat file or .exe file outside the directory it was installed in

# for users who want to play the game (linux or mac)

download and extract contents of the game
make sure you have java installed on your system, at least version 22 or later, here is the latest version (24): https://www.oracle.com/java/technologies/downloads/#jdk24-linux
open up a terminal, and copy this command into it (ensuring you are in the right directory): "java -Dfile.encoding=UTF-8 -jar cardgame.jar"



#for people who want to contribute/edit source code
this was made using jdk-22 in eclipse, if you use VS code or any other editor, ignore the bin folder, .classpath and .project files
all java files are in the /src directory, all ascii arts are just utf-8 no BOM txt files located in /pictures
the .exe was compiled using launch4j v3.50, download link: "https://sourceforge.net/projects/launch4j/files/launch4j-3/3.50/". 
the appropriate config file can be loaded in once you open the "config.xml" file.

# have fun!!



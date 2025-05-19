# for users who want to play the game (windows)
Download and extract contents of the game.
Make sure you have java installed on your system, at least version 22 or later, here is the latest version (24): https://www.oracle.com/java/technologies/downloads/#jdk24-windows.
Simply run the .bat file, and a command prompt window should open. DO NOT DOUBLE CLICK THE .EXE, this will not properly load in the braille ascii characters.
To make sure all ascii art loads in correctly, right click on the window of the cmd, click on "properties", then go to the fonts tab. From there, change it to any cascadia variant(if it is not there, try MS gothic or NSimSun), this only has to be done once. 
Make sure not to move the .bat file or .exe file outside the directory it was installed in.
Finally, if you want, you can delete the bin and src folder, as well as the config.xml, .project and .classpath files. You can also delete the .jar file, as well as the read me, but it is strongly advised against, since you can always use the jar to run the game in case the .exe or .bat does not work. It is neccasery to keep the pictures folder to allow the ascii art to load in

# for users who want to play the game (linux or mac)

Download and extract contents of the game.
Make sure you have java installed on your system, at least version 22 or later, here is the latest version (24): https://www.oracle.com/java/technologies/downloads/#jdk24-linux
Open up a terminal, and copy this command into it (ensure you are in the right directory. Eg: assuming the jar is in downloads, use this command: "cd ~/Downlods" before running the following command): "java -Dfile.encoding=UTF-8 -jar cardgame.jar". 
You might need to mess around with the fonts in order to get the braille characters to show up correctly.
Finally, if you want, you can delete the bin and src folder, the config.xml, .project and .classpath files, and the .exe and .bat files, just make sure you keep the pictures folder.



# for people who want to contribute/edit source code
This was made using jdk-22 in eclipse, if you use VS code or any other editor, ignore the bin folder, .classpath and .project files.
All java files are in the /src directory, all ascii arts are just utf-8 no BOM txt files located in /pictures.
The .exe was compiled using launch4j v3.50, download link: "https://sourceforge.net/projects/launch4j/files/launch4j-3/3.50/". 
The appropriate config file can be loaded in once you open the "config.xml" file.

# have fun!!



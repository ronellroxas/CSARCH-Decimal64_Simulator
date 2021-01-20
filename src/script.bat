@echo off

MODE CON COLS=30 LINES=2

echo Compiling Main...
javac *.java

cd scripts
echo Compiling Controllers...
start /min compileController.bat
echo Compiling Views...
start /min compileView.bat

cd ..
echo Running
java Main

exit

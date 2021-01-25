@echo off

MODE CON COLS=30 LINES=2
cd ..
cd view
del *.class
javac *.java

exit
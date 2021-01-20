@echo off

MODE CON COLS=30 LINES=2
echo Creating JAR File...
jar -cvmf META-INF/MANIFEST.txt dec64sim.jar *.class view/*.class model/*.class controller/*.class

exit
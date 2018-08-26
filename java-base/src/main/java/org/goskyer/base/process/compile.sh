#!/usr/bin/env bash
if [ -d classes ]; then
    rm -rf classes;
fi
mkdir classes
javac -cp $JAVA_HOME/lib/tools.jar org/goskyer/process/Getter* -d classes/
javac -cp classes -d classes -processor org.goskyer.base.process.GetterProcessor org/goskyer/test/process/App.java
javap -p classes org/goskyer/test/process/classes/App.class
java -cp classes org.goskyer.base.process.GetterProcessor.App
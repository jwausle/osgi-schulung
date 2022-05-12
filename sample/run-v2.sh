#!/bin/bash
# for jar in $(find . | grep target | grep jar$ | egrep '(consumer|provider)') ; do cp $jar sample ; done
# bash sample/run-v2.sh

CLASSPATH=$(dirname $0)/de.jwausle.osgi.api.consumer.v2.jar\
:$(dirname $0)/de.jwausle.osgi.api.consumer.v1.jar\
:$(dirname $0)/de.jwausle.osgi.api.provider.v1.jar\
:$(dirname $0)/de.jwausle.osgi.api.provider.v2.jar

java -cp $CLASSPATH de.jwausle.osgi.api.consumer.v2.internal.Main

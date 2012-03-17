#!/bin/bash


for p in `ps -ef | grep tomcat2 | awk '{print $2}'`; do 
	kill -9 $p; 
done;

echo "tomcat2 killed ..."

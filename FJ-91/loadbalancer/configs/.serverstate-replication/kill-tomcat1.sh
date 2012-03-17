#!/bin/bash


for p in `ps -ef | grep tomcat1 | awk '{print $2}'`; do 
	kill -9 $p; 
done;

echo "tomcat1 killed ..."

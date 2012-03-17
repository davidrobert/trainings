#!/bin/bash

for p in `ps -ef | grep haproxy | awk '{print $2}'`; do 
	kill -9 $p; 
done;

echo "haproxy shut down ..."

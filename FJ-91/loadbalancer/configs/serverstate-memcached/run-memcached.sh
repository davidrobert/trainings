#!/bin/sh

echo "memcached deve estar instalado na maquina, apt-get install memcached"
memcached -p 11211 -u memcached -m 64 -M -vv &
memcached -p 11212 -u memcached -m 64 -M -vv &

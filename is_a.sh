#! /usr/bin/env bash

grep -h extends *.java | sed "s/public//g" | sed "s/class//g" | sed "s/abstract//g" | sed "s/extends/is a/g" | sed "s/implements.*//g" | sed "s/^[ \t]*//"


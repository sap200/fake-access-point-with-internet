#!/bin/env bash

#macchanger

ifconfig wlan0 down
macchanger -r wlan0
ifconfig wlan0 up

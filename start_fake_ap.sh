#!/bin/env bash

#change mac address
bash macchanger.sh

#step1: flush ip tables
bash flushiptables.sh

#step2: start dnsmasq
dnsmasq -C dnsmasq.conf


#set the ip and netmask
ifconfig wlan0 192.134.21.1 netmask 255.255.255.0

#give the internet access
bash enable_internet.sh

#step3: start hostapd.conf
hostapd hostapd.conf -B

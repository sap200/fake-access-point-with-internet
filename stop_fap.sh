#!/bin/env bash

pkill dnsmasq
pkill hostapd
bash flushiptables.sh

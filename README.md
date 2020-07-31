# fake-access-point-with-internet
A simple GUI to create fake access point with enabled internet

# Requirements
a) jdk-10.0.2  use the link to download: https://www.oracle.com/java/technologies/java-archive-javase10-downloads.html
b) macchanger,  run this commands to download: apt-get update & apt-get install macchanger
c) apache server, use apt-get install apache2
d) dnsmasq use, apt-get install dnsmasq
e) hostapd use, apt-get install hostapd

# Steps to Use
a) copy jdk-10.0.2 to /opt, The hierarchy should be /opt/jdk-10.0.2/bin/java
b) chmod +x fap.sh
c) chmod +x sniffer.sh
d) ./fap.sh
e) ./sniffer.sh


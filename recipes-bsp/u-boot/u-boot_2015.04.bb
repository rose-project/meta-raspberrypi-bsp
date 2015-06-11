# u-boot mainline for the Raspberry Pi
require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "dtc-native"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git;tag=${PV}"
SRC_URI_append_raspberrypi1 = " file://0001-Environment-for-Raspberry-Pi-1.patch"
SRC_URI_append_raspberrypi2 = " file://0001-Environment-for-Raspberry-Pi-2.patch"

PR = "r1"
PV = "v2015.04"

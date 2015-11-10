include u-boot-rpi.inc

#PV = "v2015.10"

SRCREV = "e490ad25eb3dc4f075ed33b4b00b1f97071fcf3d"
#SRCBRANCH = "rpi"

SRC_URI_append_raspberrypi1 = " file://0001-Environment-for-Raspberry-Pi-1.patch"
SRC_URI_append_raspberrypi2 = " file://0001-Environment-for-Raspberry-Pi-2.patch"

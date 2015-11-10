require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION="U-Boot based on mainline, optimized for Raspberry PI 1/2"
PROVIDES += "u-boot"


LICENCE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

COMPATIBLE_MACHINE = "(raspberrypi1|raspberrypi2)"

SRCBRANCH ??= "rpi"

SRC_URI = "git://github.com/Ferocity/u-boot.git;branch=${SRCBRANCH}"




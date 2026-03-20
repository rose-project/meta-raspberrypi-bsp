FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://${MACHINE}_defconfig;subdir=git/configs \
"

COMPATIBLE_MACHINE = "^raspberrypi[45]$"

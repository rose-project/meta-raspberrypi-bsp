FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://${MACHINE}_defconfig;subdir=${S}/configs \
    file://${UBOOT_ENV_SRC} \
"

UBOOT_ENV_SRC = "${MACHINE}-boot.txt"
UBOOT_ENV = "boot"
UBOOT_ENV_SUFFIX = "scr"

COMPATIBLE_MACHINE = "^raspberrypi[45]$"

SUMMARY = "Mainline Linux Kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel kernel-yocto

LINUX_VERSION ?= "6.17-rc4"
LINUX_VERSION_EXTENSION = "-rose"

KBRANCH ?= "master"

#v6.17-rc4
SRCREV = "f83ec76bf285bea5727f478a68b894f5543ca76e"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=${KBRANCH} \
    file://industrial-ethernet.cfg \
    file://usb-ethernet.cfg \
    file://defconfig \
    file://0001-microchip_t1-LAN887X-Missing-phydev-updates.patch \
    "

S = "${WORKDIR}/git"

KCONFIG_MODE = "--alldefconfig"

LINUX_VERSION_EXTENSION = "-rose"
COMPATIBLE_MACHINE = "^raspberrypi[4]$"

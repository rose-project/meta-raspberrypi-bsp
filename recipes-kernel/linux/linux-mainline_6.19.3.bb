SUMMARY = "Mainline Linux Kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel kernel-yocto

LINUX_VERSION ?= "6.19.3"
LINUX_VERSION_EXTENSION = "-rose"

KBRANCH = "linux-6.19.y"

SRCREV = "598cf272195d27d2a45462baa051959dc53690e5"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=${KBRANCH} \
    file://industrial-ethernet.cfg \
    file://usb-ethernet.cfg \
    file://defconfig \
    "

S = "${WORKDIR}/git"

KCONFIG_MODE = "--alldefconfig"

COMPATIBLE_MACHINE = "^raspberrypi[45]$"
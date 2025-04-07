SUMMARY = "Mainline Linux Kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel kernel-yocto

LINUX_VERSION ?= "6.14.1"
LINUX_BRANCH ?= "linux-6.14.y"

SRCREV = "22a8fa206fbb8df658d43dedb2096efc291bc574"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=${LINUX_BRANCH} \
    file://defconfig \
    file://industrial-ethernet.cfg \
    file://usb-ethernet.cfg \
    file://debug-lan887x.patch \
    "

S = "${WORKDIR}/git"

KCONFIG_MODE = "--alldefconfig"

LINUX_VERSION_EXTENSION = "-rose"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "^raspberrypi[4]$"

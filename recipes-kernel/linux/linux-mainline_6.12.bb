SUMMARY = "Mainline Linux Kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel kernel-yocto

LINUX_VERSION ?= "6.12.1"
LINUX_BRANCH ?= "linux-6.12.y"

SRCREV = "d390303b28dabbb91b2d32016a4f72da478733b9"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=${LINUX_BRANCH} \
    file://defconfig \
    file://industrial-ethernet.cfg \
    file://usb-ethernet.cfg \
    "

S = "${WORKDIR}/git"

KCONFIG_MODE = "--alldefconfig"

LINUX_VERSION_EXTENSION = "-rose"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "(^raspberrypi4$)"

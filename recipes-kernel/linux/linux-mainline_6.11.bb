SUMMARY = "Mainline Linux Kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel kernel-yocto

LINUX_VERSION ?= "6.11.2"
LINUX_BRANCH ?= "linux-6.11.y"

SRCREV = "7aa21fec187b7bc2a55be4daad4585098e2f47df"
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

# This file was derived from the linux-yocto-custom.bb recipe in
# oe-core.
#
# linux-yocto-custom.bb:
#
#   A yocto-bsp-generated kernel recipe that uses the linux-yocto and
#   oe-core kernel classes to apply a subset of yocto kernel
#   management to git managed kernel repositories.
#
# Warning:
#
#   Building this kernel without providing a defconfig or BSP
#   configuration will result in build or boot errors. This is not a
#   bug.
#
# Notes:
#
#   patches: patches can be merged into to the source git tree itself,
#            added via the SRC_URI, or controlled via a BSP
#            configuration.
#
#   example configuration addition:
#            SRC_URI += "file://smp.cfg"
#   example patch addition:
#            SRC_URI += "file://0001-linux-version-tweak.patch
#   example feature addition:
#            SRC_URI += "file://feature.scc"
#

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;bareclone=1;branch=${KBRANCH} "

SRC_URI += "file://${KMACHINE}_defconfig "

SRC_URI_raspberrypi1 += "file://raspberrypi1_defconfig \
            file://bcm2708.dtsi \
            file://bcm2708-rpi-b.dts \
            file://bcm2708-rpi-b-plus.dts \
	    file://raspberrypi1.scc \
            file://raspberrypi1.cfg \
            file://raspberrypi1-user-config.cfg \
            file://raspberrypi1-user-patches.scc \
	"

SRC_URI_raspberrypi2 += "file://raspberrypi2_defconfig \
            file://bcm2709.dtsi \
            file://bcm2709-rpi-2-b.dts \
	    file://raspberrypi2.scc \
            file://raspberrypi2.cfg \
            file://raspberrypi2-user-config.cfg \
            file://raspberrypi2-user-patches.scc \
	"

LINUX_VERSION ?= "4.0.4"
LINUX_VERSION_EXTENSION ?= "-raspberrypi-bsp"

SRCREV="${AUTOREV}"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_raspberrypi-bsp = "raspberrypi1 raspberrypi2"

do_configure_prepend() {
	cp "${WORKDIR}/${KMACHINE}_defconfig" "${WORKDIR}/defconfig"
}

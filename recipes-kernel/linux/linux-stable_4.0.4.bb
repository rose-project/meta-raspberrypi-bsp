inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;bareclone=1;branch=${KBRANCH} \
	file://0001-add-bcm2708-and-bcm2709-device-tree-config.patch \
	"

SRC_URI += "file://${KMACHINE}_defconfig "

SRC_URI_append_raspberrypi1 += " \
            file://bcm2708.dtsi \
            file://bcm2708-rpi-b.dts \
            file://bcm2708-rpi-b-plus.dts \
	    file://raspberrypi1.scc \
            file://raspberrypi1.cfg \
            file://raspberrypi1-user-config.cfg \
            file://raspberrypi1-user-patches.scc \
	"

SRC_URI_append_raspberrypi2 += " \
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

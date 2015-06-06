inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://github.com/raspberrypi/linux.git;protocol=git;branch=rpi-3.18.y \
	file://${KMACHINE}_defconfig \
	"

SRC_URI_append_raspberrypi1 = " \
	file://raspberrypi1.cfg \
	file://raspberrypi1.scc \
	file://raspberrypi1-user-config.cfg \
	file://raspberrypi1-user-patches.scc \
	"

SRC_URI_append_raspberrypi2 = " \
	file://raspberrypi2.cfg \
	file://raspberrypi2.scc \
	file://raspberrypi2-user-config.cfg \
	file://raspberrypi2-user-patches.scc \
	"

SRCREV = "d64fa8121fca9883d6fb14ca06d2abf66496195e"

LINUX_VERSION ?= "3.18.11"
LINUX_VERSION_EXTENSION ?= "-raspberrypi-bsp"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_raspberrypi-bsp = "raspberrypi1 raspberrypi2"

do_configure_prepend() {
	cp "${WORKDIR}/${KMACHINE}_defconfig" "${WORKDIR}/defconfig"
}

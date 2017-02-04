inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git;nocheckout=1;branch=master;name=kernel \
	"

SRC_URI_append_raspberrypi1 = "file://bcm2835.cfg \
	file://neon.cfg \
	"
SRC_URI_append_raspberrypi2 = "file://bcm2836.cfg \
	file://neon.cfg \
	"
SRC_URI_append_raspberrypi3 = " \
	file://raspberrypi3.cfg \
	"

LINUX_VERSION ?= "4.8"
LINUX_VERSION_EXTENSION = "-rose"

# tag: v4.8 ddf6b1a7de691080a203e6ce1dff4331e1770825
SRCREV = "ddf6b1a7de691080a203e6ce1dff4331e1770825"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "(raspberrypi1|raspberrypi2|raspberrypi3)"

KARCH_raspberrypi1 = "arm"
KARCH_raspberrypi2 = "arm"
KARCH_raspberrypi3 = "arm64"

KERNEL_DEVICETREE_raspberrypi1 = "\
	bcm2835-rpi-a-plus.dtb  \
	bcm2835-rpi-b-plus.dtb \
	bcm2835-rpi-b-rev2.dtb \
	bcm2835-rpi-b.dtb \
	"

KERNEL_DEVICETREE_raspberrypi2 = "\
	bcm2836-rpi-2-b.dtb \
	"

KERNEL_DEVICETREE_raspberrypi3 = "\
	broadcom/bcm2837-rpi-3-b.dtb \
	"

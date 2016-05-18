inherit kernel
require recipes-kernel/linux/linux-yocto.inc

KBRANCH="rpi-${SRCPV}.y"
SRC_URI = " \
	git://github.com/raspberrypi/linux.git;protocol=git;nocheckout=1;branch=rpi-4.5.y;name=machine \
	"

SRC_URI_append_raspberrypi1 = " \
	file://raspberrypi1.cfg \
	"

SRC_URI_append_raspberrypi2 = " \
	file://raspberrypi2.cfg \
	"


LINUX_VERSION ?= "4.5"
LINUX_VERSION_EXTENSION = "-raspberrypi-bsp"

SRCREV_machine="00aca6d5b9651c93c44a20f6a956cf8bfc261a6b"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"


COMPATIBLE_MACHINE = "(raspberrypi1|raspberrypi2)"

KERNEL_DEVICETREE_raspberrypi1 = "\
	bcm2835-rpi-a-plus.dtb  \
	bcm2835-rpi-b-plus.dtb \
	bcm2835-rpi-b-rev2.dtb \
	bcm2835-rpi-b.dtb \
	"

KERNEL_DEVICETREE_raspberrypi2 = "\
	bcm2836-rpi-2-b.dtb \
	"

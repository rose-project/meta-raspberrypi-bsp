inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git;nocheckout=1;branch=master;name=machine \
	file://bcm2835.cfg \
	file://neon.cfg \
	file://vc4-devicetree.patch \
	"

LINUX_VERSION ?= "4.6"
LINUX_VERSION_EXTENSION = "-rose"

# Modify SRCREV to a different commit hash in a copy of this recipe to
# build a different release of the Linux kernel.
# tag: v4.6 2dcd0af568b0cf583645c8a317dd12e344b1c72a
SRCREV_machine="2dcd0af568b0cf583645c8a317dd12e344b1c72a"

PV = "${LINUX_VERSION}+git${SRCPV}"

# Override COMPATIBLE_MACHINE to include your machine in a copy of this recipe
# file. Leaving it empty here ensures an early explicit build failure.
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

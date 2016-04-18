inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# Override SRC_URI in a copy of this recipe to point at a different source
# tree if you do not want to build from Linus' tree.
KBRANCH="rpi-${SRCPV}.y"
SRC_URI = " \
	git://github.com/raspberrypi/linux.git;protocol=git;nocheckout=1;branch=rpi-4.6.y;name=machine \
	"

SRC_URI_append_raspberrypi1 = " \
	file://raspberrypi1.cfg \
	"

SRC_URI_append_raspberrypi2 = " \
	file://raspberrypi2.cfg \
	"


LINUX_VERSION ?= "4.6"
LINUX_VERSION_EXTENSION = "-raspberrypi-bsp"

# Modify SRCREV to a different commit hash in a copy of this recipe to
# build a different release of the Linux kernel.
# tag: v4.5 b562e44f507e863c6792946e4e1b1449fbbac85d
SRCREV_machine="f795e8abac6f05145ef78deb42b0c4ae9a960ad6"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"


do_deploy_append() {
	if test -n "${KERNEL_DEVICETREE}"; then
		for DTB in ${KERNEL_DEVICETREE}; do
			cd ${DEPLOYDIR}
			ln -sf ${DTB_NAME}.dtb zImage.dtb
			cd -
		done
	fi
}

COMPATIBLE_MACHINE = "(raspberrypi1|raspberrypi2)"


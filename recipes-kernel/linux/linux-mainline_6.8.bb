SUMMARY = "Mainline Linux Kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel

LINUX_VERSION ?= "6.8.5"
LINUX_BRANCH ?= "linux-6.8.y"

SRCREV = "b95f2066a910ace64787dc4f3e1dfcb2e7e71718"
SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=${LINUX_BRANCH} \
	file://raspberrypi4/defconfig \
	"

kernel_do_configure:prepend() {
	cp "${WORKDIR}/${MACHINE}/defconfig" "${B}/.config"
}

S = "${WORKDIR}/git"

LINUX_VERSION_EXTENSION = "-rose"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "(^raspberrypi4$)"

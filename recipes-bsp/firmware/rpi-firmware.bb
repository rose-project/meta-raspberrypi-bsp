DESCRIPTION = "Closed source binary files to help boot the ARM on the BCM2835."
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://boot/LICENCE.broadcom;md5=c403841ff2837657b2ed8e5bb474ac8d"

PV = "1.20240306"
SRCREV = "fa7d6b8f5d4f103987ffefc7202ed25c93cd3087"

SRC_URI = "git://github.com/raspberrypi/firmware.git;protocol=https;branch=stable"

S = "${WORKDIR}/git"

inherit deploy

DEPENDS = "rpi-config"

COMPATIBLE_MACHINE = "^raspberrypi.*"

do_deploy() {
    FIRMWARE_DEPLOYDIR=${DEPLOYDIR}/firmware
    mkdir ${FIRMWARE_DEPLOYDIR}
    cp ${S}/boot/bootcode.bin ${FIRMWARE_DEPLOYDIR}
    cp ${S}/boot/start.elf ${FIRMWARE_DEPLOYDIR}
    cp ${S}/boot/fixup.dat ${FIRMWARE_DEPLOYDIR}
    cp ${S}/boot/start4.elf ${FIRMWARE_DEPLOYDIR}
    cp ${S}/boot/fixup4.dat ${FIRMWARE_DEPLOYDIR}
    cp ${S}/boot/LICENCE.broadcom ${FIRMWARE_DEPLOYDIR}
}

addtask deploy before do_build after do_compile

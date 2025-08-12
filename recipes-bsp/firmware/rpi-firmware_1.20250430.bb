DESCRIPTION = "Closed source binary files to help boot the ARM on the BCM2835."
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://boot/LICENCE.broadcom;md5=c403841ff2837657b2ed8e5bb474ac8d"

SRC_URI = "https://github.com/raspberrypi/firmware/releases/download/${PV}/raspi-firmware_${PV}.orig.tar.xz;name=firmware"
SRC_URI[firmware.sha256sum] = "25bcff5992c6d7057de4a5c6834b7f90b7136fe12aa63fa32793329bf74a95bf"

inherit deploy

DEPENDS = "rpi-config"

COMPATIBLE_MACHINE = "^raspberrypi.*"

S = "${WORKDIR}/raspi-firmware-${PV}"

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

# Raspberry Pi firmware blobs

SRC_URI = " \
    https://github.com/raspberrypi/firmware/raw/5c1848771795600170250a0ea1ff4a509e20859e/boot/bootcode.bin;name=bootcode.bin \
    https://github.com/raspberrypi/firmware/raw/5c1848771795600170250a0ea1ff4a509e20859e/boot/start.elf;name=start.elf \
    https://github.com/raspberrypi/firmware/raw/master/boot/LICENCE.broadcom;name=license \
    "

SRC_URI[bootcode.bin.md5sum] = "06e8e69c96e73bbf66403e1229d3f151"
SRC_URI[bootcode.bin.sha256sum] = "6149c038b67e22c826bcdc28a7b59b91bded089eddf506c25df96af88e7846f4"
SRC_URI[start.elf.md5sum] = "fe63c1104652b0c6d660267d74a3e16a"
SRC_URI[start.elf.sha256sum] = "d1b9e6921ccad3c82fde6044896a3def42b33398062350fa7a1872e49b5558a7"
SRC_URI[license.md5sum] = "4a4d169737c0786fb9482bb6d30401d1"
SRC_URI[license.sha256sum] = "ba76edfc10a248166d965b8eaf320771c44f4f432d4fce2fd31fd272e7038add"

PV = "20150530"

S = "${WORKDIR}"

inherit deploy

RDEPENDS_${PN} = "rpi-config"
DESCRIPTION = "Closed source binary files to help boot the ARM on the BCM2835."
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://LICENCE.broadcom;md5=4a4d169737c0786fb9482bb6d30401d1"

COMPATIBLE_MACHINE = "raspberrypi(1|2)"

PR = "r1"

do_deploy() {
    cp ${S}/bootcode.bin ${DEPLOYDIR}/
    cp ${S}/start.elf ${DEPLOYDIR}/
}

addtask deploy before do_build after do_compile

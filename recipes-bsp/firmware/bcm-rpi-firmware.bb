# Raspberry Pi firmware blobs

SRC_URI = " \
    https://github.com/raspberrypi/firmware/raw/c53b9e5b5ce76487b105f4b9cc23db80860e51a3/boot/bootcode.bin;name=bootcode.bin \
    https://github.com/raspberrypi/firmware/raw/c53b9e5b5ce76487b105f4b9cc23db80860e51a3/boot/start.elf;name=start.elf \ 
    https://github.com/raspberrypi/firmware/raw/c53b9e5b5ce76487b105f4b9cc23db80860e51a3/boot/LICENCE.broadcom;name=license \
    "
SRC_URI[bootcode.bin.md5sum] = "5bbb5f25dfe16f2871d5defcc48ac9ff"
SRC_URI[bootcode.bin.sha256sum] = "a11bd31647c25712648757be75a19fa78c1df6f2409c7bf9bd202903f0421c0c"
SRC_URI[start.elf.md5sum] = "0b817fc3c3e56a5052c230f6f8f2ff44"
SRC_URI[start.elf.sha256sum] = "83a25a52a8566e389fddef82f6dc7cfed00d491eb8f301039416b4a5baa9fe35"
SRC_URI[license.md5sum] = "4a4d169737c0786fb9482bb6d30401d1"
SRC_URI[license.sha256sum] = "ba76edfc10a248166d965b8eaf320771c44f4f432d4fce2fd31fd272e7038add"

PV = "20161101"

S = "${WORKDIR}"

inherit deploy

RDEPENDS_${PN} = "rpi-config"
DESCRIPTION = "Closed source binary files to help boot the ARM on the BCM2835."
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://LICENCE.broadcom;md5=4a4d169737c0786fb9482bb6d30401d1"

COMPATIBLE_MACHINE = "raspberrypi(1|2|3)"

PR = "r1"

do_deploy() {
    cp ${S}/bootcode.bin ${DEPLOYDIR}/
    cp ${S}/start.elf ${DEPLOYDIR}/
}

addtask deploy before do_build after do_compile

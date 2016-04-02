# Raspberry Pi firmware blobs

SRC_URI = " \
    https://github.com/raspberrypi/firmware/raw/046effa13ebc4cc7601df4f06f4834bd0eebb0f8/boot/bootcode.bin;name=bootcode.bin \
    https://github.com/raspberrypi/firmware/raw/046effa13ebc4cc7601df4f06f4834bd0eebb0f8/boot/start.elf;name=start.elf \
    https://github.com/raspberrypi/firmware/raw/046effa13ebc4cc7601df4f06f4834bd0eebb0f8/boot/LICENCE.broadcom;name=license \
    "
SRC_URI[bootcode.bin.md5sum] = "84d279839c772d3a040b80187388975b"
SRC_URI[bootcode.bin.sha256sum] = "6c5eea9ed8fbdb1fbebd32c543bc4f94e43b06154d665b03a34164903478a9de"
SRC_URI[start.elf.md5sum] = "b9e68841248012ddb2405504d8bd1070"
SRC_URI[start.elf.sha256sum] = "92c114331190425860e8b883a3d9472957c7493f282b4e0969647580c6c4e09e"
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

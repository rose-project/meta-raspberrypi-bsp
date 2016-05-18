# Raspberry Pi firmware blobs

SRC_URI = " \
    https://github.com/raspberrypi/firmware/raw/e0fedf15518eef8a56f41113abd5ec8171e3981c/boot/bootcode.bin;name=bootcode.bin \
    https://github.com/raspberrypi/firmware/raw/e0fedf15518eef8a56f41113abd5ec8171e3981c/boot/start.elf;name=start.elf \ 
    https://github.com/raspberrypi/firmware/raw/e0fedf15518eef8a56f41113abd5ec8171e3981c/boot/LICENCE.broadcom;name=license \
    "
SRC_URI[bootcode.bin.md5sum] = "0a844d5ceadba293d3945ef542851af9"
SRC_URI[bootcode.bin.sha256sum] = "37d91c3a1b2fc31a272ce089dcadbc68e78604b4668b74449980d5f7c0467761"
SRC_URI[start.elf.md5sum] = "e0b80e7a679a0e26bda055176bd022b9"
SRC_URI[start.elf.sha256sum] = "87e997c32e526f0cdf21136464ae54b37fa6a23be107ae098e8182cb87a1178d"
SRC_URI[license.md5sum] = "4a4d169737c0786fb9482bb6d30401d1"
SRC_URI[license.sha256sum] = "ba76edfc10a248166d965b8eaf320771c44f4f432d4fce2fd31fd272e7038add"

PV = "20160517"

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

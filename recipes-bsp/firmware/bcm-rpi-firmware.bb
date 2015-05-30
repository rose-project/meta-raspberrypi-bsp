# Raspberry Pi firmware blobs

SRC_URI = " \
    https://github.com/raspberrypi/firmware/raw/master/boot/bootcode.bin;name=bootcode.bin \
    https://github.com/raspberrypi/firmware/raw/master/boot/start.elf;name=start.elf \
    https://github.com/raspberrypi/firmware/raw/master/boot/LICENCE.broadcom;name=license \
    "

SRC_URI[bootcode.bin.md5sum] = "06e8e69c96e73bbf66403e1229d3f151"
SRC_URI[bootcode.bin.sha256sum] = "6149c038b67e22c826bcdc28a7b59b91bded089eddf506c25df96af88e7846f4"
SRC_URI[start.elf.md5sum] = "13b80800872c01298fa6281b01773f56"
SRC_URI[start.elf.sha256sum] = "7cd392b32d2bfdf6c46b65a62f3fc5771e88fa35205f98e109ef1bac953a8177"
SRC_URI[license.md5sum] = "e86e693d19572ee64cc8b17fb062faa9"
SRC_URI[license.sha256sum] = "f60358cc6ed4b7c49f0c5faf1cd8f604705c2e3fd25c0048ea3243596795f789"

PV = "20150530"

S = "${WORKDIR}"

RDEPENDS_${PN} = "rpi-config"
DESCRIPTION = "Closed source binary files to help boot the ARM on the BCM2835."
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://LICENCE.broadcom;md5=e86e693d19572ee64cc8b17fb062faa9"

COMPATIBLE_MACHINE = "raspberrypi(1|2)"

PR = "r1"

do_deploy() {
    cp ${S}/bootcode.bin ${DEPLOYDIR}/${PN}
    echo "copy start.elf: ${S}/start.elf ${DEPLOYDIR}/${PN}" 
    cp ${S}/start.elf ${DEPLOYDIR}/${PN}
}

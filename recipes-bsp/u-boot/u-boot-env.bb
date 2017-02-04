DESCRIPTION = "Raspberry Pi U-Boot environment script"

SRC_URI = " \
    file://${MACHINE}-boot.txt \
    file://LICENSE \
    "

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=956139f0411412ea77671fedb9915d38"

S = "${WORKDIR}"

inherit deploy

DEPENDS = "u-boot-mkimage-native"
RDEPENDS_${PN} = "rpi-config"


COMPATIBLE_MACHINE = "raspberrypi(1|2|3)"

PR = "r1"

do_compile() {
    uboot-mkimage -T script -C none -n boot.scr -d ${S}/${MACHINE}-boot.txt ${WORKDIR}/boot.scr
}

do_deploy() {
    install -d ${DEPLOYDIR}
    install ${WORKDIR}/boot.scr ${DEPLOYDIR}/boot.scr
}

addtask deploy before do_package after do_install
do_deploy[dirs] += "${DEPLOYDIR}"

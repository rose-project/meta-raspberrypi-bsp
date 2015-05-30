DESCRIPTION = "config.txt for Raspberry Pi firmware"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

COMPATIBLE_MACHINE = "raspberrypi(1|2)"

SRC_URI = "file://config.txt \
          "

S = "${WORKDIR}"

PR = "r1"

do_deploy() {
    cp ${S}/config.txt ${DEPLOYDIR}
}

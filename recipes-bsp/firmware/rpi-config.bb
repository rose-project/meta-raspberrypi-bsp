DESCRIPTION = "config.txt for Raspberry Pi firmware"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

COMPATIBLE_MACHINE = "^raspberrypi.*"

SRC_URI = "file://config.txt \
          "

inherit deploy

S = "${WORKDIR}"

PR = "r1"

do_deploy() {
    install -m 0644 config.txt ${DEPLOYDIR}
}

addtask deploy after do_compile

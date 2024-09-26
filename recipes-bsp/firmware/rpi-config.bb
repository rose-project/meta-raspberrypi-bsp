DESCRIPTION = "config.txt for Raspberry Pi firmware"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

COMPATIBLE_MACHINE = "^raspberrypi.*"

SRC_URI = "file://config.txt \
          "

inherit deploy

S = "${WORKDIR}"

PR = "r1"

export ENABLE_JTAG = "${@bb.utils.contains("MACHINE_FEATURES", "jtag", "1", "0", d)}"

do_deploy() {
    install -m 0644 config.txt ${DEPLOYDIR}
    cp ${S}/config.txt ${DEPLOYDIR}

    if [ "$ENABLE_JTAG" = "1" ]; then
        printf "enable_jtag_gpio=1\n" >> ${DEPLOYDIR}/config.txt
    fi
}

addtask deploy after do_compile

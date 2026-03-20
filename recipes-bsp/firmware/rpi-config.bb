DESCRIPTION = "config.txt for Raspberry Pi firmware"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

COMPATIBLE_MACHINE = "^raspberrypi.*"

inherit deploy

S = "${WORKDIR}"

PR = "r3"

BOOTLOADER_PROVIDER = "${PREFERRED_PROVIDER_virtual/bootloader}"
UBOOT_IMAGE_NAME ?= "${@d.getVar('UBOOT_BINARY') or 'u-boot.bin'}"


# defined in <machine>.conf
RPI_CMDLINE_ROOT ?= "${ROOT_DEV}"
RPI_CMDLINE_ROOT_FSTYPE ?= "ext4"
RPI_CMDLINE_EXTRA ?= "rootwait"


def rpi_console_arg(d):
    """Derive console=<tty>,<baud> from the first SERIAL_CONSOLES entry."""
    serial = (d.getVar("SERIAL_CONSOLES") or "").split()
    if not serial:
        return ""

    first = serial[0]
    parts = [p.strip() for p in first.split(";")]
    if len(parts) != 2:
        return ""

    baud, tty = parts
    if not baud or not tty:
        return ""

    return f"console={tty},{baud}"


RPI_CONSOLE_ARG = "${@rpi_console_arg(d)}"

do_deploy() {
    rm -f ${WORKDIR}/config.txt
    rm -f ${WORKDIR}/cmdline.txt
    echo "arm_64bit=1" >> ${WORKDIR}/config.txt
    bootloader="${BOOTLOADER_PROVIDER}"
    # Match the selected bootloader so the firmware loads the right binary
    case "${bootloader}" in
        *u-boot*)
            kernel_target="${UBOOT_IMAGE_NAME}"
            ;;
        *)
            kernel_target="${KERNEL_IMAGETYPE}"
            ;;
    esac
    echo "kernel=${kernel_target}" >> ${WORKDIR}/config.txt
    echo "device_tree=${SELECTED_DEVICETREE}" >> ${WORKDIR}/config.txt
    echo "enable_uart=1" >> ${WORKDIR}/config.txt

    cmdline="root=${RPI_CMDLINE_ROOT} rootfstype=${RPI_CMDLINE_ROOT_FSTYPE}"
    if [ -n "${RPI_CMDLINE_EXTRA}" ]; then
        cmdline="${cmdline} ${RPI_CMDLINE_EXTRA}"
    fi
    if [ -n "${RPI_CONSOLE_ARG}" ]; then
        cmdline="${RPI_CONSOLE_ARG} ${cmdline}"
    fi

    echo "${cmdline}" > ${WORKDIR}/cmdline.txt

    install -m 0644 config.txt ${DEPLOYDIR}
    install -m 0644 cmdline.txt ${DEPLOYDIR}
}

addtask deploy after do_compile

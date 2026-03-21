#@TYPE: Machine
#@NAME: Raspberry Pi common config
#@DESCRIPTION: Common machine configuration for the Raspberry Pi

MACHINEOVERRIDES = "raspberrypi:${MACHINE}:"

IMAGE_FSTYPES ?= "tar.bz2 wic.bz2"
WKS_FILE ?= "sdimage-${MACHINE}.wks"

MACHINE_EXTRA_RRECOMMENDS += "\
    kernel-modules \
    linux-firmware \
    "

EXTRA_IMAGEDEPENDS += "u-boot rpi-firmware"
do_image_wic[depends] += " \
    virtual/kernel:do_deploy \
    rpi-firmware:do_deploy \
    u-boot:do_deploy \
    "


IMAGE_FSTYPES += "tar.bz2"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-mainline"
PREFERRED_VERSION_linux-mainline ?= "6.19%"
PREFERRED_PROVIDER_virtual/bootloader ??= "u-boot"

UBOOT_MACHINE = "${MACHINE}_defconfig"

MACHINE_FEATURES += " \
    usbgadget \
    usbhost \
    vfat \
    ext2 \
    alsa \
    bluetooth \
    wifi \
    "

def get_dtb_files(d):
    paths = d.getVar("KERNEL_DEVICETREE").split()
    dtb_files = ""
    for path in paths:
        dtb_files += " " + path.split("/")[-1]
    return dtb_files


IMAGE_BOOT_FILES ?= "u-boot.bin boot.scr ${KERNEL_IMAGETYPE} ${@get_dtb_files(d)} firmware/* config.txt cmdline.txt"
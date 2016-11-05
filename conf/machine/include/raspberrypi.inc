#@TYPE: Machine
#@NAME: Raspberry Pi common config

#@DESCRIPTION: Common machine configuration for the Raspberry Pi 1, 2 and 3

MACHINE_OVERRIDES = "raspberrypi:${MACHINE}"

MACHINE_EXTRA_RRECOMMENDS = " kernel-modules kernel-devicetree"

EXTRA_IMAGEDEPENDS += "u-boot u-boot-env bcm-rpi-firmware"

# Wic dependencies to create MBR partitions
EXTRA_IMAGEDEPENDS += "dosfstools-native mtools-native parted-native"

IMAGE_FSTYPES += "tar.bz2"

SERIAL_CONSOLE = "115200 ttyAMA0"

KERNEL_IMAGETYPE = "zImage"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

UBOOT_SUFFIX = "bin"
UBOOT_ENTRYPOINT = "0x80008000"
UBOOT_LOADADDRESS = "0x80008000"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-mainline"
PREFERRED_VERSION_virtual/kernel = "4.8%"
PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot"
PREFERRED_PROVIDER_virtual/egl ?= "mesa"
PREFERRED_PROVIDER_virtual/libgles2 ?= "mesa"
PREFERRED_PROVIDER_virtual/libgl ?= "mesa"
PREFERRED_PROVIDER_virtual/mesa ?= "mesa"
PREFERRED_PROVIDER_jpeg = "libjpeg-turbo"


MACHINE_FEATURES = " \
    usbgadget \
    usbhost \
    keyboard \
    vfat \
    ext2 \
    alsa \
    bluetooth \
    wifi \
    sdio \
    "

IMAGE_BOOT_FILES ?= "u-boot.${UBOOT_SUFFIX} boot.scr ${KERNEL_IMAGETYPE} bootcode.bin start.elf config.txt"

#@TYPE: Machine
#@NAME: Raspberry Pi common config

#@DESCRIPTION: Common machine configuration for the Raspberry Pi 1 and 2


MACHINE_EXTRA_RRECOMMENDS = " kernel-modules kernel-devicetree"

EXTRA_IMAGEDEPENDS += "u-boot bcm-rpi-firmware"

IMAGE_FSTYPES += "tar.bz2"

SERIAL_CONSOLE = "115200 ttyAMA0"

KERNEL_IMAGETYPE = "zImage"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

UBOOT_SUFFIX = "bin"
UBOOT_ENTRYPOINT = "0x80008000"
UBOOT_LOADADDRESS = "0x80008000"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-raspberrypi"
PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot"
PREFERRED_PROVIDER_virtual/egl ?= "userland"
PREFERRED_PROVIDER_virtual/libgles2 ?= "userland"
PREFERRED_PROVIDER_virtual/libgl ?= "mesa-gl"
PREFERRED_PROVIDER_virtual/mesa ?= "mesa-gl"

PREFERRED_VERSION_linux-custom = "v4.0.4"

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

# FIXME: devtree files
IMAGE_BOOT_FILES ?= "u-boot.${UBOOT_SUFFIX} zImage bootcode.bin start.elf config.txt"

require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "dtc-native"

# This revision corresponds to the tag "v2016.09.01"
SRCREV = "d8bdfc80da39211d95f10d24e79f2e867305f71b"

PV = "v2016.11-rc3+git${SRCPV}"

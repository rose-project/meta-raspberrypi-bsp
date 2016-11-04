require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "dtc-native"

# This revision corresponds to the tag "v2016.09.01"
SRCREV = "f3363c060497515ca8b71451cb56f3ec0abacaa9"

PV = "v2016.09.01+git${SRCPV}"

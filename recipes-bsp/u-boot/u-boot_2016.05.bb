require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "dtc-native"

# This revision corresponds to the tag "v2016.03"
# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "a398e7aa216279652dd380d3ecd3683b3b5e588e"

PV = "v2016.05-rc3+git${SRCPV}"

# The linux-mainline recipe itself lives in meta-rose, since both BSPs share the
# kernel version, the lan887x PHY patches and the ethernet config fragments. What
# belongs here is only the part that is about this board: the base defconfig.
#
# file://defconfig resolves through FILESOVERRIDES, so raspberrypi4 picks up
# linux-mainline/raspberrypi4/defconfig and raspberrypi5 its own.

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# Machine scoped: both BSPs bbappend this recipe, and the append is applied
# whichever machine is being built.
SRC_URI:append:raspberrypi = " file://defconfig"

COMPATIBLE_MACHINE:raspberrypi = "^raspberrypi[45]$"

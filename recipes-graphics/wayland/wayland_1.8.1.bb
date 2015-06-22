SUMMARY = "Wayland, a protocol between a compositor and clients"
DESCRIPTION = "Wayland is a protocol for a compositor to talk to its clients \
as well as a C library implementation of that protocol. The compositor can be \
a standalone display server running on Linux kernel modesetting and evdev \
input devices, an X application, or a wayland client itself. The clients can \
be traditional applications, X servers (rootless or fullscreen) or other \
display servers."
HOMEPAGE = "http://wayland.freedesktop.org"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://COPYING;md5=1d4476a7d98dd5691c53d4d43a510c72 \
                    file://src/wayland-server.c;endline=21;md5=079ae21dbf98ada52ec23744851b0a5c"

SRC_URI = "http://wayland.freedesktop.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[md5sum] = "6e877877c3e04cfb865cfcd0733c9ab1"
SRC_URI[sha256sum] = "f17c938d1c24fd0a10f650a623a2775d329db3168b5732e498b08388ec776fc8"

inherit autotools pkgconfig

DEPENDS = "expat libffi wayland-native"

EXTRA_OECONF = "--disable-documentation --disable-scanner"
EXTRA_OECONF_class-native = "--disable-documentation --enable-scanner"

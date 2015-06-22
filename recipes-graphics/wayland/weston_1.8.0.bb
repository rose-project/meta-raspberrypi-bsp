SUMMARY = "Weston, a Wayland compositor"
DESCRIPTION = "Weston is the reference implementation of a Wayland compositor"
HOMEPAGE = "http://wayland.freedesktop.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=275efac2559a224527bd4fd593d38466 \
                    file://src/compositor.c;endline=23;md5=a9793f1edc8d1a4c344ca8ae252352fb"

SRC_URI = "http://wayland.freedesktop.org/releases/${BPN}-${PV}.tar.xz \
"
SRC_URI[md5sum] = "24cb8a7ed0535b4fc3642643988dab36"
SRC_URI[sha256sum] = "8963e69f328e815cec42c58046c4af721476c7541bb7d9edc71740fada5ad312"

inherit autotools pkgconfig

DEPENDS = "libpam libinput libxkbcommon gdk-pixbuf pixman cairo glib-2.0 jpeg"
DEPENDS += "wayland virtual/egl pango"

#EXTRA_OECONF = "--enable-setuid-install \
#                --disable-xwayland \
#                --enable-simple-clients \
#                --enable-clients \
#                --enable-demo-clients-install \
#                --disable-libunwind \
#                --disable-rpi-compositor \
#                --disable-rdp-compositor \
#                "

#EXTRA_OECONF = "--disable-x11-compositor \
#    --disable-drm-compositor \
#    --disable-wayland-compositor \
#    --enable-weston-launch \
#    --disable-simple-egl-clients \
#    --disable-egl \
#    --disable-libunwind \
#    --disable-colord \
#    --disable-resize-optimization \
#    --disable-xwayland-test \
#    --with-cairo=image \
#    WESTON_NATIVE_BACKEND=rpi-backend.so \
#    "


EXTRA_OECONF = "--disable-egl \
    "

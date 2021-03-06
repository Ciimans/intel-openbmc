SUMMARY = "NV Overlay Sync"
DESCRIPTION = "Script to periodically sync the overlay to NV storage"

S = "${WORKDIR}"
SRC_URI = "file://nv-sync.service \
"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${INTELBASE}/COPYING.apache-2.0;md5=34400b68072d710fecd0a2940a0d1658"

inherit systemd

FILES_${PN} += "${systemd_system_unitdir}/nv-sync.service"

do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/nv-sync.service ${D}${systemd_system_unitdir}
}

SYSTEMD_SERVICE_${PN} += " nv-sync.service"

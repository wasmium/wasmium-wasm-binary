package org.wasmium.wasm.binary.tree.sections

import org.wasmium.wasm.binary.tree.ExternalKind
import org.wasmium.wasm.binary.tree.SectionKind
import org.wasmium.wasm.binary.visitors.ExportSectionVisitor

public class ExportSectionNode : SectionNode(SectionKind.EXPORT), ExportSectionVisitor {
    public val exports: MutableList<ExportTypeNode> = mutableListOf()

    public fun accept(exportSectionVisitor: ExportSectionVisitor) {
        for (exportType in exports) {
            exportSectionVisitor.visitExport(exportType.exportIndex, exportType.kind, exportType.index, exportType.name)
        }

        exportSectionVisitor.visitEnd()
    }

    public override fun visitExport(exportIndex: UInt, externalKind: ExternalKind, itemIndex: UInt, name: String) {
        exports.add(ExportTypeNode(exportIndex, name, externalKind, itemIndex))
    }

    public override fun visitEnd() {
        // empty
    }
}

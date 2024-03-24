package org.wasmium.wasm.binary.reader

import org.wasmium.wasm.binary.WasmSource
import org.wasmium.wasm.binary.visitors.ModuleVisitor

public class DataCountSectionReader(
    private val context: ReaderContext,
) {
    public fun readDataCountSection(source: WasmSource, visitor: ModuleVisitor) {
        val dataCount = source.readVarUInt32()

        // TODO check count

        val dataCountSectionVisitor = visitor.visitDataCountSection(dataCount)
        dataCountSectionVisitor?.visitEnd()
    }
}

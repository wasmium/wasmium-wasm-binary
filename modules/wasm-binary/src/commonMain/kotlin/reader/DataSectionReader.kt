package org.wasmium.wasm.binary.reader

import org.wasmium.wasm.binary.ParserException
import org.wasmium.wasm.binary.WasmBinary
import org.wasmium.wasm.binary.WasmSource
import org.wasmium.wasm.binary.visitors.ModuleVisitor

public class DataSectionReader(
    private val context: WasmBinaryContext,
    private val dataSegmentReader: DataSegmentReader = DataSegmentReader(context),
) {
    public fun readDataSection(source: WasmSource, visitor: ModuleVisitor) {
        val dataSegmentCount = source.readVarUInt32()

        if (dataSegmentCount >= 0u && context.numberTotalMemories == 0u) {
            throw ParserException("Data section without memory section")
        }

        if (dataSegmentCount > WasmBinary.MAX_DATA_SEGMENTS) {
            throw ParserException("Number of data segments ${context.numberGlobals} exceed the maximum of ${WasmBinary.MAX_DATA_SEGMENTS}")
        }

        val dataVisitor = visitor.visitDataSection()
        for (index in 0u until dataSegmentCount) {
            dataSegmentReader.readDataSegment(source, index, dataVisitor)
        }

        dataVisitor.visitEnd()
    }
}
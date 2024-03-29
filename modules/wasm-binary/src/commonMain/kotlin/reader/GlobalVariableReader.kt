package org.wasmium.wasm.binary.reader

import org.wasmium.wasm.binary.ParserException
import org.wasmium.wasm.binary.WasmBinaryReader
import org.wasmium.wasm.binary.visitors.GlobalSectionVisitor

public class GlobalVariableReader(
    private val context: ReaderContext,
    private val initializerExpressionReader: InitializerExpressionReader = InitializerExpressionReader(context),
) {
    public fun readGlobalVariable(source: WasmBinaryReader, index: UInt, globalVisitor: GlobalSectionVisitor?) {
        val globalIndex = context.numberGlobalImports + index

        val contentType = source.readType()
        if (!contentType.isValueType()) {
            throw ParserException("Invalid global type: %#$contentType")
        }

        val mutable = source.readVarUInt1() == 1u

        val globalVariableVisitor = globalVisitor?.visitGlobalVariable(globalIndex)
        globalVariableVisitor?.visitGlobalVariable(contentType, mutable)

        val initializerExpressionVisitor = globalVariableVisitor?.visitInitializerExpression()
        initializerExpressionReader.readInitExpression(source, initializerExpressionVisitor, false)
        initializerExpressionVisitor?.visitEnd()

        globalVariableVisitor?.visitEnd()
    }
}

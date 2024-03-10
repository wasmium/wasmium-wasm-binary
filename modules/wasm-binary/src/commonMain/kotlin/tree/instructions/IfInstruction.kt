package org.wasmium.wasm.binary.tree.instructions

import org.wasmium.wasm.binary.tree.Opcode
import org.wasmium.wasm.binary.tree.WasmType
import org.wasmium.wasm.binary.visitors.FunctionBodyVisitor

public class IfInstruction(public override val blockType: Array<WasmType>) : TypeInstruction {
    public override val opcode: Opcode = Opcode.IF

    override fun accept(functionBodyVisitor: FunctionBodyVisitor) {
        functionBodyVisitor.visitIfInstruction(blockType)
    }
}

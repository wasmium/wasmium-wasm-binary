package org.wasmium.wasm.binary.tree.instructions

import org.wasmium.wasm.binary.tree.Opcode
import org.wasmium.wasm.binary.visitors.FunctionBodyVisitor

public class SetGlobalInstruction(override val index: UInt) : IndexInstruction {
    public override val opcode: Opcode = Opcode.SET_GLOBAL

    override fun accept(functionBodyVisitor: FunctionBodyVisitor) {
        functionBodyVisitor.visitSetGlobalInstruction(index)
    }
}
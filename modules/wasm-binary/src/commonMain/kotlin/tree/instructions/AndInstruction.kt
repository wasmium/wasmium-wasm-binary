package org.wasmium.wasm.binary.tree.instructions

import org.wasmium.wasm.binary.tree.Opcode
import org.wasmium.wasm.binary.visitors.FunctionBodyVisitor

public class AndInstruction(public override val opcode: Opcode) : NoneInstruction {
    public override fun accept(functionBodyVisitor: FunctionBodyVisitor) {
        functionBodyVisitor.visitAndInstruction(opcode)
    }
}

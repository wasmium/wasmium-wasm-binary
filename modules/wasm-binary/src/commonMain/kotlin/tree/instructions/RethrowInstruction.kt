package org.wasmium.wasm.binary.tree.instructions

import org.wasmium.wasm.binary.visitors.FunctionBodyVisitor
import org.wasmium.wasm.binary.tree.Opcode

public class RethrowInstruction : NoneInstruction {
    public override val opcode: Opcode = Opcode.RETHROW

    override fun accept(functionBodyVisitor: FunctionBodyVisitor) {
        functionBodyVisitor.visitRethrowInstruction()
    }
}

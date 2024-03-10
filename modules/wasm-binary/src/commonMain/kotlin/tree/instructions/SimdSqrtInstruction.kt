package org.wasmium.wasm.binary.tree.instructions

import org.wasmium.wasm.binary.visitors.FunctionBodyVisitor
import org.wasmium.wasm.binary.tree.Opcode

public class SimdSqrtInstruction(public override val opcode: Opcode) : NoneInstruction {
    override fun accept(functionBodyVisitor: FunctionBodyVisitor) {
        functionBodyVisitor.visitSimdSqrtInstruction(opcode)
    }
}

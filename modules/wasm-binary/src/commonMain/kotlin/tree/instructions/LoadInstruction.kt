package org.wasmium.wasm.binary.tree.instructions

import org.wasmium.wasm.binary.visitors.FunctionBodyVisitor
import org.wasmium.wasm.binary.tree.Opcode

public class LoadInstruction(
    public override val opcode: Opcode,
    public override val alignment: UInt,
    public override val offset: UInt,
) : AlignOffsetInstruction {
    override fun accept(functionBodyVisitor: FunctionBodyVisitor) {
        functionBodyVisitor.visitLoadInstruction(opcode, alignment, offset)
    }
}

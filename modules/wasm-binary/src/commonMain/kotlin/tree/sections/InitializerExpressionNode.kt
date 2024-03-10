package org.wasmium.wasm.binary.tree.sections

import org.wasmium.wasm.binary.tree.V128Value
import org.wasmium.wasm.binary.tree.instructions.*
import org.wasmium.wasm.binary.visitors.InitializerExpressionVisitor
import org.wasmium.wasm.binary.tree.Opcode.*

public class InitializerExpressionNode : InitializerExpressionVisitor {
    public val instructions: MutableList<Instruction> = mutableListOf<Instruction>()

    public fun accept(initializerExpressionVisitor: InitializerExpressionVisitor) {
        for (instruction in instructions) {
            when (instruction.opcode) {
                I32_CONST -> {
                    val constInt32Instruction: ConstInt32Instruction = instruction as ConstInt32Instruction
                    initializerExpressionVisitor.visitInitExprI32ConstExpr(constInt32Instruction.value)
                }

                I64_CONST -> {
                    val constInt64Instruction: ConstInt64Instruction = instruction as ConstInt64Instruction
                    initializerExpressionVisitor.visitInitExprI64ConstExpr(constInt64Instruction.value)
                }

                F32_CONST -> {
                    val constFloat32Instruction: ConstFloat32Instruction = instruction as ConstFloat32Instruction
                    initializerExpressionVisitor.visitInitExprF32ConstExpr(constFloat32Instruction.value)
                }

                F64_CONST -> {
                    val constFloat64Instruction: ConstFloat64Instruction = instruction as ConstFloat64Instruction
                    initializerExpressionVisitor.visitInitExprF64ConstExpr(constFloat64Instruction.value)
                }

                V128_CONST -> {
                    val simdConstInstruction: SimdConstInstruction = instruction as SimdConstInstruction
                    initializerExpressionVisitor.visitInitExprV128ConstExpr(simdConstInstruction.value)
                }

                GET_GLOBAL -> {
                    val getGlobalInstruction: GetGlobalInstruction = instruction as GetGlobalInstruction
                    initializerExpressionVisitor.visitInitExprGetGlobalExpr(getGlobalInstruction.index)
                }

                END -> initializerExpressionVisitor.visitInitExprEnd()

                else -> throw IllegalArgumentException()
            }
        }
    }

    public override fun visitInitExprI32ConstExpr(value: Int) {
        instructions.add(ConstInt32Instruction(value))
    }

    public override fun visitInitExprI64ConstExpr(value: Long) {
        instructions.add(ConstInt64Instruction(value))
    }

    public override fun visitInitExprF32ConstExpr(value: Float) {
        instructions.add(ConstFloat32Instruction(value))
    }

    public override fun visitInitExprF64ConstExpr(value: Double) {
        instructions.add(ConstFloat64Instruction(value))
    }

    override fun visitInitExprGetGlobalExpr(globalIndex: UInt) {
        instructions.add(GetGlobalInstruction(globalIndex))
    }

    public override fun visitInitExprV128ConstExpr(value: V128Value) {
        instructions.add(SimdConstInstruction(value))
    }

    public override fun visitInitExprEnd() {
        instructions.add(EndInstruction())
    }

    public override fun visitEnd() {
        // empty
    }
}

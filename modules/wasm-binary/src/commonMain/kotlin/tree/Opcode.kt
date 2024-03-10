package org.wasmium.wasm.binary.tree

import org.wasmium.wasm.binary.Features

/**
 * List of WebAssembly opcodes.
 */
public enum class Opcode(
    public val param1: WasmType?,
    public val param2: WasmType?,
    public val param3: WasmType?,
    public val result: WasmType?,
    /** Prefix of the opcode. The prefix is a byte type. */
    public val prefix: Int,
    /** Code of {@link Opcode}. */
    public val code: Int,
    /** Name of the opcode.*/
    public val opcodeName: String,
) {
    UNREACHABLE(null, null, null, null, 0, 0x00, "unreachable"),
    NOP(null, null, null, null, 0, 0x01, "nop"),
    BLOCK(null, null, null, null, 0, 0x02, "block"),
    LOOP(null, null, null, null, 0, 0x03, "loop"),
    IF(null, null, null, null, 0, 0x04, "if"),
    ELSE(null, null, null, null, 0, 0x05, "else"),
    TRY(null, null, null, null, 0, 0x06, "try"),
    CATCH(null, null, null, null, 0, 0x07, "catch"),
    THROW(null, null, null, null, 0, 0x08, "throw"),
    RETHROW(null, null, null, null, 0, 0x09, "rethrow"),
    IF_EXCEPT(null, null, null, null, 0, 0x0a, "if_except"),
    END(null, null, null, null, 0, 0x0B, "end"),
    BR(null, null, null, null, 0, 0x0C, "br"),
    BR_IF(null, null, null, null, 0, 0x0D, "br_if"),
    BR_TABLE(null, null, null, null, 0, 0x0E, "br_table"),
    RETURN(null, null, null, null, 0, 0x0F, "return"),
    CALL(null, null, null, null, 0, 0x10, "call"),
    CALL_INDIRECT(null, null, null, null, 0, 0x11, "call_indirect"),
    DROP(null, null, null, null, 0, 0x1A, "drop"),
    SELECT(null, null, null, null, 0, 0x1B, "select"),
    GET_LOCAL(null, null, null, null, 0, 0x20, "get_local"),
    SET_LOCAL(null, null, null, null, 0, 0x21, "set_local"),
    TEE_LOCAL(null, null, null, null, 0, 0x22, "tee_local"),
    GET_GLOBAL(null, null, null, null, 0, 0x23, "get_global"),
    SET_GLOBAL(null, null, null, null, 0, 0x24, "set_global"),
    I32_LOAD(null, null, null, null, 0, 0x28, "i32.load"),
    I64_LOAD(null, null, null, null, 0, 0x29, "i64.load"),
    F32_LOAD(null, null, null, null, 0, 0x2A, "f32.load"),
    F64_LOAD(null, null, null, null, 0, 0x2B, "f64.load"),
    I32_LOAD8_S(null, null, null, null, 0, 0x2C, "i32.load8_s"),
    I32_LOAD8_U(null, null, null, null, 0, 0x2D, "i32.load8_u"),
    I32_LOAD16_S(null, null, null, null, 0, 0x2E, "i32.load16_s"),
    I32_LOAD16_U(null, null, null, null, 0, 0x2F, "i32.load16_u"),
    I64_LOAD8_S(null, null, null, null, 0, 0x30, "i64.load8_s"),
    I64_LOAD8_U(null, null, null, null, 0, 0x31, "i64.load8_u"),
    I64_LOAD16_S(null, null, null, null, 0, 0x32, "i64.load16_s"),
    I64_LOAD16_U(null, null, null, null, 0, 0x33, "i64.load16_u"),
    I64_LOAD32_S(null, null, null, null, 0, 0x34, "i64.load32_s"),
    I64_LOAD32_U(null, null, null, null, 0, 0x35, "i64.load32_u"),
    I32_STORE(null, null, null, null, 0, 0x36, "i32.store"),
    I64_STORE(null, null, null, null, 0, 0x37, "i64.store"),
    F32_STORE(null, null, null, null, 0, 0x38, "f32.store"),
    F64_STORE(null, null, null, null, 0, 0x39, "f64.store"),
    I32_STORE8(null, null, null, null, 0, 0x3A, "i32.store8"),
    I32_STORE16(null, null, null, null, 0, 0x3B, "i32.store16"),
    I64_STORE8(null, null, null, null, 0, 0x3C, "i64.store8"),
    I64_STORE16(null, null, null, null, 0, 0x3D, "i64.store16"),
    I64_STORE32(null, null, null, null, 0, 0x3E, "i64.store32"),
    MEMORY_SIZE(null, null, null, null, 0, 0x3F, "memory.size"),
    MEMORY_GROW(null, null, null, null, 0, 0x40, "memory.grow"),
    I32_CONST(null, null, null, null, 0, 0x41, "i32.const"),
    I64_CONST(null, null, null, null, 0, 0x42, "i64.const"),
    F32_CONST(null, null, null, null, 0, 0x43, "f32.const"),
    F64_CONST(null, null, null, null, 0, 0x44, "i64.const"),
    I32_EQZ(null, null, null, null, 0, 0x45, "i32.eqz"),
    I32_EQ(null, null, null, null, 0, 0x46, "i32.eq"),
    I32_NE(null, null, null, null, 0, 0x47, "i32.ne"),
    I32_LT_S(null, null, null, null, 0, 0x48, "i32.lt_s"),
    I32_LT_U(null, null, null, null, 0, 0x49, "i32.lt_u"),
    I32_GT_S(null, null, null, null, 0, 0x4A, "i32.gt_s"),
    I32_GT_U(null, null, null, null, 0, 0x4B, "i32.gt_u"),
    I32_LE_S(null, null, null, null, 0, 0x4C, "i32.le_s"),
    I32_LE_U(null, null, null, null, 0, 0x4D, "i32.le_u"),
    I32_GE_S(null, null, null, null, 0, 0x4E, "i32.ge_s"),
    I32_GE_U(null, null, null, null, 0, 0x4F, "i32.ge_u"),
    I64_EQZ(null, null, null, null, 0, 0x50, "i64.eqz"),
    I64_EQ(null, null, null, null, 0, 0x51, "i64.eq"),
    I64_NE(null, null, null, null, 0, 0x52, "i64.ne"),
    I64_LT_S(null, null, null, null, 0, 0x53, "i64.lt_s"),
    I64_LT_U(null, null, null, null, 0, 0x54, "i64.lt_u"),
    I64_GT_S(null, null, null, null, 0, 0x55, "i64.gt_s"),
    I64_GT_U(null, null, null, null, 0, 0x56, "i64.gt_u"),
    I64_LE_S(null, null, null, null, 0, 0x57, "i64.le_s"),
    I64_LE_U(null, null, null, null, 0, 0x58, "i64.le_u"),
    I64_GE_S(null, null, null, null, 0, 0x59, "i64.ge_s"),
    I64_GE_U(null, null, null, null, 0, 0x5A, "i64.ge_u"),
    F32_EQ(null, null, null, null, 0, 0x5B, "f32.eq"),
    F32_NE(null, null, null, null, 0, 0x5C, "f32.ne"),
    F32_LT(null, null, null, null, 0, 0x5D, "f32.lt"),
    F32_GT(null, null, null, null, 0, 0x5E, "f32.gt"),
    F32_LE(null, null, null, null, 0, 0x5F, "f32.le"),
    F32_GE(null, null, null, null, 0, 0x60, "f32.ge"),
    F64_EQ(null, null, null, null, 0, 0x61, "f64.eq"),
    F64_NE(null, null, null, null, 0, 0x62, "f64.ne"),
    F64_LT(null, null, null, null, 0, 0x63, "f64.lt"),
    F64_GT(null, null, null, null, 0, 0x64, "f64.gt"),
    F64_LE(null, null, null, null, 0, 0x65, "f64.le"),
    F64_GE(null, null, null, null, 0, 0x66, "f64.ge"),
    I32_CLZ(null, null, null, null, 0, 0x67, "i32.clz"),
    I32_CTZ(null, null, null, null, 0, 0x68, "i32.ctz"),
    I32_POPCNT(null, null, null, null, 0, 0x69, "i32.popcnt"),
    I32_ADD(null, null, null, null, 0, 0x6A, "i32.add"),
    I32_SUB(null, null, null, null, 0, 0x6B, "i32.sub"),
    I32_MUL(null, null, null, null, 0, 0x6C, "i32.mul"),
    I32_DIV_S(null, null, null, null, 0, 0x6D, "i32.div_s"),
    I32_DIV_U(null, null, null, null, 0, 0x6E, "i32.div_u"),
    I32_REM_S(null, null, null, null, 0, 0x6F, "i32.rem_s"),
    I32_REM_U(null, null, null, null, 0, 0x70, "i32.rem_u"),
    I32_AND(null, null, null, null, 0, 0x71, "i32.and"),
    I32_OR(null, null, null, null, 0, 0x72, "i32.or"),
    I32_XOR(null, null, null, null, 0, 0x73, "i32.xor"),
    I32_SHL(null, null, null, null, 0, 0x74, "i32.shl"),
    I32_SHR_S(null, null, null, null, 0, 0x75, "i32.shr_s"),
    I32_SHR_U(null, null, null, null, 0, 0x76, "i32.shr_u"),
    I32_ROTL(null, null, null, null, 0, 0x77, "i32.rotl"),
    I32_ROTR(null, null, null, null, 0, 0x78, "i32.rotr"),
    I64_CLZ(null, null, null, null, 0, 0x79, "i32.clz"),
    I64_CTZ(null, null, null, null, 0, 0x7A, "i32.ctz"),
    I64_POPCNT(null, null, null, null, 0, 0x7B, "i32.popcnt"),
    I64_ADD(null, null, null, null, 0, 0x7C, "i64.add"),
    I64_SUB(null, null, null, null, 0, 0x7D, "i64.sub"),
    I64_MUL(null, null, null, null, 0, 0x7E, "i64.mul"),
    I64_DIV_S(null, null, null, null, 0, 0x7F, "i64.div_s"),
    I64_DIV_U(null, null, null, null, 0, 0x80, "i64.div_u"),
    I64_REM_S(null, null, null, null, 0, 0x81, "i64.rem_s"),
    I64_REM_U(null, null, null, null, 0, 0x82, "i64.rem_u"),
    I64_AND(null, null, null, null, 0, 0x83, "i64.and"),
    I64_OR(null, null, null, null, 0, 0x84, "i64.or"),
    I64_XOR(null, null, null, null, 0, 0x85, "i64.xor"),
    I64_SHL(null, null, null, null, 0, 0x86, "i64.shl"),
    I64_SHR_S(null, null, null, null, 0, 0x87, "i64.shl_s"),
    I64_SHR_U(null, null, null, null, 0, 0x88, "i64.shl_u"),
    I64_ROTL(null, null, null, null, 0, 0x89, "i64.rotl"),
    I64_ROTR(null, null, null, null, 0, 0x8A, "i64.rotr"),
    F32_ABS(null, null, null, null, 0, 0x8B, "f32.abs"),
    F32_NEG(null, null, null, null, 0, 0x8C, "f32.neg"),
    F32_CEIL(null, null, null, null, 0, 0x8D, "f32.ceil"),
    F32_FLOOR(null, null, null, null, 0, 0x8E, "f32.floor"),
    F32_TRUNC(null, null, null, null, 0, 0x8F, "f32.trunc"),
    F32_NEAREST(null, null, null, null, 0, 0x90, "f32.nearest"),
    F32_SQRT(null, null, null, null, 0, 0x91, "f32.sqrt"),
    F32_ADD(null, null, null, null, 0, 0x92, "f32.add"),
    F32_SUB(null, null, null, null, 0, 0x93, "f32.sub"),
    F32_MUL(null, null, null, null, 0, 0x94, "f32.mul"),
    F32_DIV(null, null, null, null, 0, 0x95, "f32.div"),
    F32_MIN(null, null, null, null, 0, 0x96, "f32.min"),
    F32_MAX(null, null, null, null, 0, 0x97, "f32.max"),
    F32_COPYSIGN(null, null, null, null, 0, 0x98, "f32.copysign"),
    F64_ABS(null, null, null, null, 0, 0x99, "f64.abs"),
    F64_NEG(null, null, null, null, 0, 0x9A, "f64.neg"),
    F64_CEIL(null, null, null, null, 0, 0x9B, "f64.ceil"),
    F64_FLOOR(null, null, null, null, 0, 0x9C, "f64.floor"),
    F64_TRUNC(null, null, null, null, 0, 0x9D, "f64.trunc"),
    F64_NEAREST(null, null, null, null, 0, 0x9E, "f64.nearest"),
    F64_SQRT(null, null, null, null, 0, 0x9F, "f64.sqrt"),
    F64_ADD(null, null, null, null, 0, 0xA0, "f64.add"),
    F64_SUB(null, null, null, null, 0, 0xA1, "f64.sub"),
    F64_MUL(null, null, null, null, 0, 0xA2, "f64.mul"),
    F64_DIV(null, null, null, null, 0, 0xA3, "f64.div"),
    F64_MIN(null, null, null, null, 0, 0xA4, "f64.min"),
    F64_MAX(null, null, null, null, 0, 0xA5, "f64.max"),
    F64_COPYSIGN(null, null, null, null, 0, 0xA6, "f64.copysign"),
    I32_WRAP_I64(null, null, null, null, 0, 0xA7, "i32.wrap/i64"),
    I32_TRUNC_SF32(null, null, null, null, 0, 0xA8, "i32.trunc_s/f32"),
    I32_TRUNC_UF32(null, null, null, null, 0, 0xA9, "i32.trunc_u/f32"),
    I32_TRUNC_SF64(null, null, null, null, 0, 0xAA, "i32.trunc_s/f64"),
    I32_TRUNC_UF64(null, null, null, null, 0, 0xAB, "i32.trunc_u/f64"),
    I64_EXTEND_SI32(null, null, null, null, 0, 0xAC, "i64.extend_s/i32"),
    I64_EXTEND_UI32(null, null, null, null, 0, 0xAD, "i64.extend_u/i32"),
    I64_TRUNC_SF32(null, null, null, null, 0, 0xAE, "i64.trunc_s/f32"),
    I64_TRUNC_UF32(null, null, null, null, 0, 0xAF, "i64.trunc_u/f32"),
    I64_TRUNC_SF64(null, null, null, null, 0, 0xB0, "i64.trunc_s/f64"),
    I64_TRUNC_UF64(null, null, null, null, 0, 0xB1, "i64.trunc_u/f64"),
    F32_CONVERT_SI32(null, null, null, null, 0, 0xB2, "f32.convert_s/i32"),
    F32_CONVERT_UI32(null, null, null, null, 0, 0xB3, "f32.convert_u/i32"),
    F32_CONVERT_SI64(null, null, null, null, 0, 0xB4, "f32.convert_s/i64"),
    F32_CONVERT_UI64(null, null, null, null, 0, 0xB5, "f32.convert_u/i64"),
    F32_DEMOTE_F64(null, null, null, null, 0, 0xB6, "f32.demote/f64"),
    F64_CONVERT_SI32(null, null, null, null, 0, 0xB7, "f64.convert_s/i32"),
    F64_CONVERT_UI32(null, null, null, null, 0, 0xB8, "f64.convert_u/i32"),
    F64_CONVERT_SI64(null, null, null, null, 0, 0xB9, "f64.convert_s/i64"),
    F64_CONVERT_UI64(null, null, null, null, 0, 0xBA, "f64.convert_u/i64"),
    F64_PROMOTE_F32(null, null, null, null, 0, 0xBB, "f64.promote/f32"),
    I32_REINTERPRET_F32(null, null, null, null, 0, 0xBC, "i32.reinterpret/f32"),
    I64_REINTERPRET_F64(null, null, null, null, 0, 0xBD, "i64.reinterpret/f64"),
    F32_REINTERPRET_I32(null, null, null, null, 0, 0xBE, "f32.reinterpret/i32"),
    F64_REINTERPRET_I64(null, null, null, null, 0, 0xBF, "f64.reinterpret/i64"),

    I32_EXTEND8_S(null, null, null, null, 0, 0xC0, "i32.extend8_s"),
    I32_EXTEND16_S(null, null, null, null, 0, 0xC1, "i32.extend16_s"),
    I64_EXTEND8_S(null, null, null, null, 0, 0xC2, "i64.extend8_s"),
    I64_EXTEND16_S(null, null, null, null, 0, 0xC3, "i64.extend16_s"),
    I64_EXTEND32_S(null, null, null, null, 0, 0xC4, "i64.extend32_s"),

    I32_TRUNC_S_SAT_F32(null, null, null, null, 0xfc, 0x00, "i32.trunc_s:sat/f32"),
    I32_TRUNC_U_SAT_F32(null, null, null, null, 0xfc, 0x01, "i32.trunc_u:sat/f32"),
    I32_TRUNC_S_SAT_F64(null, null, null, null, 0xfc, 0x02, "i32.trunc_s:sat/f64"),
    I32_TRUNC_U_SAT_F64(null, null, null, null, 0xfc, 0x03, "i32.trunc_u:sat/f64"),
    I64_TRUNC_S_SAT_F32(null, null, null, null, 0xfc, 0x04, "i64.trunc_s:sat/f32"),
    I64_TRUNC_U_SAT_F32(null, null, null, null, 0xfc, 0x05, "i64.trunc_u:sat/f32"),
    I64_TRUNC_S_SAT_F64(null, null, null, null, 0xfc, 0x06, "i64.trunc_s:sat/f64"),
    I64_TRUNC_U_SAT_F64(null, null, null, null, 0xfc, 0x07, "i64.trunc_u:sat/f64"),

    ATOMIC_WAKE(null, null, null, null, 0xfe, 0x00, "atomic.wake"),
    I32_ATOMIC_WAIT(null, null, null, null, 0xfe, 0x01, "i32.atomic.wait"),
    I64_ATOMIC_WAIT(null, null, null, null, 0xfe, 0x02, "i64.atomic.wait"),
    I32_ATOMIC_LOAD(null, null, null, null, 0xfe, 0x10, "i32.atomic.load"),
    I64_ATOMIC_LOAD(null, null, null, null, 0xfe, 0x11, "i64.atomic.load"),
    I32_ATOMIC_LOAD8_U(null, null, null, null, 0xfe, 0X12, "i32.atomic.load8_u"),
    I32_ATOMIC_LOAD16_U(null, null, null, null, 0xfe, 0X13, "i32.atomic.load16_u"),
    I64_ATOMIC_LOAD8_U(null, null, null, null, 0xfe, 0X14, "i64.atomic.load8_u"),
    I64_ATOMIC_LOAD16_U(null, null, null, null, 0xfe, 0X15, "i64.atomic.load16_u"),
    I64_ATOMIC_LOAD32_U(null, null, null, null, 0xfe, 0X16, "i64.atomic.load32_u"),
    I32_ATOMIC_STORE(null, null, null, null, 0xfe, 0X17, "i32.atomic.store"),
    I64_ATOMIC_STORE(null, null, null, null, 0xfe, 0X18, "i64.atomic.store"),
    I32_ATOMIC_STORE8(null, null, null, null, 0xfe, 0X19, "i32.atomic.store8"),
    I32_ATOMIC_STORE16(null, null, null, null, 0xfe, 0X1A, "i32.atomic.store16"),
    I64_ATOMIC_STORE8(null, null, null, null, 0xfe, 0X1B, "i64.atomic.store8"),
    I64_ATOMIC_STORE16(null, null, null, null, 0xfe, 0x1c, "i64.atomic.store16"),
    I64_ATOMIC_STORE32(null, null, null, null, 0xfe, 0x1d, "i64.atomic.store32"),
    I32_ATOMIC_RMW_ADD(null, null, null, null, 0xfe, 0X1E, "i32.atomic.rmw.add"),
    I64_ATOMIC_RMW_ADD(null, null, null, null, 0xfe, 0X1F, "i64.atomic.rmw.add"),
    I32_ATOMIC_RMW8_U_ADD(null, null, null, null, 0xfe, 0X20, "i32.atomic.rmw8_u.add"),
    I32_ATOMIC_RMW16_U_ADD(null, null, null, null, 0xfe, 0X21, "i32.atomic.rmw16_u.add"),
    I64_ATOMIC_RMW8_U_ADD(null, null, null, null, 0xfe, 0X22, "i64.atomic.rmw8_u.add"),
    I64_ATOMIC_RMW16_U_ADD(null, null, null, null, 0xfe, 0X23, "i64.atomic.rmw16_u.add"),
    I64_ATOMIC_RMW32_U_ADD(null, null, null, null, 0xfe, 0X24, "i64.atomic.rmw32_u.add"),
    I32_ATOMIC_RMW_SUB(null, null, null, null, 0xfe, 0X25, "i32.atomic.rmw.sub"),
    I64_ATOMIC_RMW_SUB(null, null, null, null, 0xfe, 0X26, "i64.atomic.rmw.sub"),
    I32_ATOMIC_RMW8_U_SUB(null, null, null, null, 0xfe, 0X27, "i32.atomic.rmw8_u.sub"),
    I32_ATOMIC_RMW16_U_SUB(null, null, null, null, 0xfe, 0X28, "i32.atomic.rmw16_u.sub"),
    I64_ATOMIC_RMW8_U_SUB(null, null, null, null, 0xfe, 0X29, "i64.atomic.rmw8_u.sub"),
    I64_ATOMIC_RMW16_U_SUB(null, null, null, null, 0xfe, 0X2A, "i64.atomic.rmw16_u.sub"),
    I64_ATOMIC_RMW32_U_SUB(null, null, null, null, 0xfe, 0X2B, "i64.atomic.rmw32_u.sub"),
    I32_ATOMIC_RMW_AND(null, null, null, null, 0xfe, 0X2C, "i32.atomic.rmw.and"),
    I64_ATOMIC_RMW_AND(null, null, null, null, 0xfe, 0X2D, "i64.atomic.rmw.and"),
    I32_ATOMIC_RMW8_U_AND(null, null, null, null, 0xfe, 0X2E, "i32.atomic.rmw8_u.and"),
    I32_ATOMIC_RMW16_U_AND(null, null, null, null, 0xfe, 0X2F, "i32.atomic.rmw16_u.and"),
    I64_ATOMIC_RMW8_U_AND(null, null, null, null, 0xfe, 0X30, "i64.atomic.rmw8_u.and"),
    I64_ATOMIC_RMW16_U_AND(null, null, null, null, 0xfe, 0X31, "i64.atomic.rmw16_u.and"),
    I64_ATOMIC_RMW32_U_AND(null, null, null, null, 0xfe, 0X32, "i64.atomic.rmw32_u.and"),
    I32_ATOMIC_RMW_OR(null, null, null, null, 0xfe, 0X33, "i32.atomic.rmw.or"),
    I64_ATOMIC_RMW_OR(null, null, null, null, 0xfe, 0X34, "i64.atomic.rmw.or"),
    I32_ATOMIC_RMW8_U_OR(null, null, null, null, 0xfe, 0X35, "i32.atomic.rmw8_u.or"),
    I32_ATOMIC_RMW16_U_OR(null, null, null, null, 0xfe, 0X36, "i32.atomic.rmw16_u.or"),
    I64_ATOMIC_RMW8_U_OR(null, null, null, null, 0xfe, 0X37, "i64.atomic.rmw8_u.or"),
    I64_ATOMIC_RMW16_U_OR(null, null, null, null, 0xfe, 0X38, "i64.atomic.rmw16_u.or"),
    I64_ATOMIC_RMW32_U_OR(null, null, null, null, 0xfe, 0X39, "i64.atomic.rmw32_u.or"),
    I32_ATOMIC_RMW_XOR(null, null, null, null, 0xfe, 0X3A, "i32.atomic.rmw.xor"),
    I64_ATOMIC_RMW_XOR(null, null, null, null, 0xfe, 0X3B, "i64.atomic.rmw.xor"),
    I32_ATOMIC_RMW8_U_XOR(null, null, null, null, 0xfe, 0X3C, "i32.atomic.rmw8_u.xor"),
    I32_ATOMIC_RMW16_U_XOR(null, null, null, null, 0xfe, 0X3D, "i32.atomic.rmw16_u.xor"),
    I64_ATOMIC_RMW8_U_XOR(null, null, null, null, 0xfe, 0X3E, "i64.atomic.rmw8_u.xor"),
    I64_ATOMIC_RMW16_U_XOR(null, null, null, null, 0xfe, 0X3F, "i64.atomic.rmw16_u.xor"),
    I64_ATOMIC_RMW32_U_XOR(null, null, null, null, 0xfe, 0X40, "i64.atomic.rmw32_u.xor"),
    I32_ATOMIC_RMW_XCHG(null, null, null, null, 0xfe, 0X41, "i32.atomic.rmw.xchg"),
    I64_ATOMIC_RMW_XCHG(null, null, null, null, 0xfe, 0X42, "i64.atomic.rmw.xchg"),
    I32_ATOMIC_RMW8_U_XCHG(null, null, null, null, 0xfe, 0X43, "i32.atomic.rmw8_u.xchg"),
    I32_ATOMIC_RMW16_U_XCHG(null, null, null, null, 0xfe, 0X44, "i32.atomic.rmw16_u.xchg"),
    I64_ATOMIC_RMW8_U_XCHG(null, null, null, null, 0xfe, 0X45, "i64.atomic.rmw8_u.xchg"),
    I64_ATOMIC_RMW16_U_XCHG(null, null, null, null, 0xfe, 0X46, "i64.atomic.rmw16_u.xchg"),
    I64_ATOMIC_RMW32_U_XCHG(null, null, null, null, 0xfe, 0X47, "i64.atomic.rmw32_u.xchg"),
    I32_ATOMIC_RMW_CMPXCHG(null, null, null, null, 0xfe, 0X48, "i32.atomic.rmw.cmpxchg"),
    I64_ATOMIC_RMW_CMPXCHG(null, null, null, null, 0xfe, 0X49, "i64.atomic.rmw.cmpxchg"),
    I32_ATOMIC_RMW8_U_CMPXCHG(null, null, null, null, 0xfe, 0X4A, "i32.atomic.rmw8_u.cmpxchg"),
    I32_ATOMIC_RMW16_U_CMPXCHG(null, null, null, null, 0xfe, 0X4B, "i32.atomic.rmw16_u.cmpxchg"),
    I64_ATOMIC_RMW8_U_CMPXCHG(null, null, null, null, 0xfe, 0X4C, "i64.atomic.rmw8_u.cmpxchg"),
    I64_ATOMIC_RMW16_U_CMPXCHG(null, null, null, null, 0xfe, 0X4D, "i64.atomic.rmw16_u.cmpxchg"),
    I64_ATOMIC_RMW32_U_CMPXCHG(null, null, null, null, 0xfe, 0X4E, "i64.atomic.rmw32_u.cmpxchg"),

    V128_CONST(null, null, null, null, 0xfd, 0x00, "v128.const"),
    V128_LOAD(null, null, null, null, 0xfd, 0x01, "v128.load"),
    V128_STORE(null, null, null, null, 0xfd, 0x02, "v128.store"),
    I8X16_SPLAT(null, null, null, null, 0xfd, 0x03, "i8x16.splat"),
    I16X8_SPLAT(null, null, null, null, 0xfd, 0x04, "i16x8.splat"),
    I32X4_SPLAT(null, null, null, null, 0xfd, 0x05, "i32x4.splat"),
    I64X2_SPLAT(null, null, null, null, 0xfd, 0x06, "i16x2.splat"),
    F32X4_SPLAT(null, null, null, null, 0xfd, 0x07, "i32x4.splat"),
    F64X2_SPLAT(null, null, null, null, 0xfd, 0x08, "i64x2.splat"),
    I8X16_EXTRACT_LANE_S(null, null, null, null, 0xfd, 0x09, "i8x16.extract_lane_s"),
    I8X16_EXTRACT_LANE_U(null, null, null, null, 0xfd, 0x0a, "i8x16.extract_lane_u"),
    I16X8_EXTRACT_LANE_S(null, null, null, null, 0xfd, 0x0b, "i16x8.extract_lane_s"),
    I16X8_EXTRACT_LANE_U(null, null, null, null, 0xfd, 0x0c, "i16x8.extract_lane_u"),
    I32X4_EXTRACT_LANE(null, null, null, null, 0xfd, 0x0d, "i32x4.extract_lane"),
    I64X2_EXTRACT_LANE(null, null, null, null, 0xfd, 0x0e, "i64x2.extract_lane"),
    F32X4_EXTRACT_LANE(null, null, null, null, 0xfd, 0x0f, "i32x4.extract_lane"),
    F64X2_EXTRACT_LANE(null, null, null, null, 0xfd, 0x10, "i64X2.extract_lane"),
    I8X16_REPLACE_LANE(null, null, null, null, 0xfd, 0x11, "i8X16.replace_lane"),
    I16X8_REPLACE_LANE(null, null, null, null, 0xfd, 0x12, "i16X8.replace_lane"),
    I32X4_REPLACE_LANE(null, null, null, null, 0xfd, 0x13, "i32X4.replace_lane"),
    I64X2_REPLACE_LANE(null, null, null, null, 0xfd, 0x14, "i64X2.replace_lane"),
    F32X4_REPLACE_LANE(null, null, null, null, 0xfd, 0x15, "i32X4.replace_lane"),
    F64X2_REPLACE_LANE(null, null, null, null, 0xfd, 0x16, "i64X2.replace_lane"),
    V8X16_SHUFFLE(null, null, null, null, 0xfd, 0x17, "v8X16.shuffle"),
    I8X16_ADD(null, null, null, null, 0xfd, 0x18, "i8x16.add"),
    I16X8_ADD(null, null, null, null, 0xfd, 0x19, "i16x8.add"),
    I32X4_ADD(null, null, null, null, 0xfd, 0x1a, "i32x4.add"),
    I64X2_ADD(null, null, null, null, 0xfd, 0x1b, "i16x2.add"),
    I8X16_SUB(null, null, null, null, 0xfd, 0x1c, "i8x16.sub"),
    I16X8_SUB(null, null, null, null, 0xfd, 0x1d, "i16x8.sub"),
    I32X4_SUB(null, null, null, null, 0xfd, 0x1e, "i32x4.sub"),
    I64X2_SUB(null, null, null, null, 0xfd, 0x1f, "i16x2.sub"),
    I8X16_MUL(null, null, null, null, 0xfd, 0x20, "i8x16.mul"),
    I16X8_MUL(null, null, null, null, 0xfd, 0x21, "i16x8.mul"),
    I32X4_MUL(null, null, null, null, 0xfd, 0x22, "i32x4.mul"),
    I8X16_NEG(null, null, null, null, 0xfd, 0x23, "i8x16.neg"),
    I16X8_NEG(null, null, null, null, 0xfd, 0x24, "i16x8.neg"),
    I32X4_NEG(null, null, null, null, 0xfd, 0x25, "i32x4.neg"),
    I64X2_NEG(null, null, null, null, 0xfd, 0x26, "i16x2.neg"),
    I8X16_ADD_SATURATE_S(null, null, null, null, 0xfd, 0x27, "i8x16.add_saturate_s"),
    I8X16_ADD_SATURATE_U(null, null, null, null, 0xfd, 0x28, "i8x16.add_saturate_u"),
    I16X8_ADD_SATURATE_S(null, null, null, null, 0xfd, 0x29, "i16x8.add_saturate_s"),
    I16X8_ADD_SATURATE_U(null, null, null, null, 0xfd, 0x2a, "i16x8.add_saturate_u"),
    I8X16_SUB_SATURATE_S(null, null, null, null, 0xfd, 0x2b, "i8x16.sub_saturate_s"),
    I8X16_SUB_SATURATE_U(null, null, null, null, 0xfd, 0x2c, "i8x16.sub_saturate_u"),
    I16X8_SUB_SATURATE_S(null, null, null, null, 0xfd, 0x2d, "i16x8.sub_saturate_s"),
    I16X8_SUB_SATURATE_U(null, null, null, null, 0xfd, 0x2e, "i16x8.sub_saturate_u"),
    I8X16_SHL(null, null, null, null, 0xfd, 0x2f, "i8x16.shl"),
    I16X8_SHL(null, null, null, null, 0xfd, 0x30, "i16X8.shl"),
    I32X4_SHL(null, null, null, null, 0xfd, 0x31, "i32X4.shl"),
    I64X2_SHL(null, null, null, null, 0xfd, 0x32, "i64X2.shl"),
    I8X16_SHL_S(null, null, null, null, 0xfd, 0x33, "i8x16.shl_s"),
    I8X16_SHL_U(null, null, null, null, 0xfd, 0x34, "i8x16.shl_u"),
    I16X8_SHL_S(null, null, null, null, 0xfd, 0x35, "i16X8.shl_s"),
    I16X8_SHL_U(null, null, null, null, 0xfd, 0x36, "i16X8.shl_u"),
    I32X4_SHL_S(null, null, null, null, 0xfd, 0x37, "i32X4.shl_s"),
    I32X4_SHL_U(null, null, null, null, 0xfd, 0x38, "i32X4.shl_u"),
    I64X2_SHL_S(null, null, null, null, 0xfd, 0x39, "i64X2.shl_s"),
    I64X2_SHL_U(null, null, null, null, 0xfd, 0x3a, "i64X2.shl_u"),
    V128_AND(null, null, null, null, 0xfd, 0x3b, "v128.and"),
    V128_OR(null, null, null, null, 0xfd, 0x3c, "v128.or"),
    V128_XOR(null, null, null, null, 0xfd, 0x3d, "v128.xor"),
    V128_NOT(null, null, null, null, 0xfd, 0x3e, "v128.not"),
    V128_BITSELECT(null, null, null, null, 0xfd, 0x3f, "v128.bitselect"),
    I8X16_ANY_TRUE(null, null, null, null, 0xfd, 0x40, "i8x16.anytrue"),
    I16X8_ANY_TRUE(null, null, null, null, 0xfd, 0x41, "i16x8.anytrue"),
    I32X4_ANY_TRUE(null, null, null, null, 0xfd, 0x42, "i32x4.anytrue"),
    I64X2_ANY_TRUE(null, null, null, null, 0xfd, 0x43, "i64x2.anytrue"),
    I8X16_ALL_TRUE(null, null, null, null, 0xfd, 0x44, "i8x16.anytrue"),
    I16X8_ALL_TRUE(null, null, null, null, 0xfd, 0x45, "i16x8.anytrue"),
    I32X4_ALL_TRUE(null, null, null, null, 0xfd, 0x46, "i32x4.anytrue"),
    I64X2_ALL_TRUE(null, null, null, null, 0xfd, 0x47, "i64x2.anytrue"),
    I8X16_EQ(null, null, null, null, 0xfd, 0x48, "i8x16.eq"),
    I16X8_EQ(null, null, null, null, 0xfd, 0x49, "i16x8.eq"),
    I32X4_EQ(null, null, null, null, 0xfd, 0x4a, "i32x4.eq"),
    F32X4_EQ(null, null, null, null, 0xfd, 0x4b, "f32x4.eq"),
    F64X2_EQ(null, null, null, null, 0xfd, 0x4c, "i64x2.eq"),
    I8X16_NE(null, null, null, null, 0xfd, 0x4d, "i8x16.ne"),
    I16X8_NE(null, null, null, null, 0xfd, 0x4e, "i16x8.ne"),
    I32X4_NE(null, null, null, null, 0xfd, 0x4f, "i32x4.ne"),
    F32X4_NE(null, null, null, null, 0xfd, 0x50, "f32x4.ne"),
    F64X2_NE(null, null, null, null, 0xfd, 0x51, "f64x2.ne"),

    I8X16_LT_S(null, null, null, null, 0xfd, 0x52, "i8x16.lt_s"),
    I8X16_LT_U(null, null, null, null, 0xfd, 0x53, "i8x16.lt_u"),
    I16X8_LT_S(null, null, null, null, 0xfd, 0x54, "i16x8.lt_s"),
    I16X8_LT_U(null, null, null, null, 0xfd, 0x55, "i16x8.lt_u"),
    I32X4_LT_S(null, null, null, null, 0xfd, 0x56, "i32x4.lt_s"),
    I32X4_LT_U(null, null, null, null, 0xfd, 0x57, "i32x4.lt_u"),
    F32X4_LT(null, null, null, null, 0xfd, 0x58, "f32x4.lt"),
    F64X2_LT(null, null, null, null, 0xfd, 0x59, "f64x2.lt"),

    I8X16_LE_S(null, null, null, null, 0xfd, 0x5a, "i8x16.le_s"),
    I8X16_LE_U(null, null, null, null, 0xfd, 0x5b, "i8x16.le_u"),
    I16X8_LE_S(null, null, null, null, 0xfd, 0x5c, "i16x8.le_s"),
    I16X8_LE_U(null, null, null, null, 0xfd, 0x5d, "i16x8.le_u"),
    I32X4_LE_S(null, null, null, null, 0xfd, 0x5e, "i32x4.le_s"),
    I32X4_LE_U(null, null, null, null, 0xfd, 0x5f, "i32x4.le_u"),
    F32X4_LE(null, null, null, null, 0xfd, 0x60, "f32x4.le"),
    F64X2_LE(null, null, null, null, 0xfd, 0x61, "f64x2.le"),

    I8X16_GT_S(null, null, null, null, 0xfd, 0x62, "i8x16.gt_s"),
    I8X16_GT_U(null, null, null, null, 0xfd, 0x63, "i8x16.gt_u"),
    I16X8_GT_S(null, null, null, null, 0xfd, 0x64, "i16x8.gt_s"),
    I16X8_GT_U(null, null, null, null, 0xfd, 0x65, "i16x8.gt_u"),
    I32X4_GT_S(null, null, null, null, 0xfd, 0x66, "i32x4.gt_s"),
    I32X4_GT_U(null, null, null, null, 0xfd, 0x67, "i32x4.gt_u"),
    F32X4_GT(null, null, null, null, 0xfd, 0x68, "f32x4.gt"),
    F64X2_GT(null, null, null, null, 0xfd, 0x69, "f64x2.gt"),

    I8X16_GE_S(null, null, null, null, 0xfd, 0x6a, "i8x16.ge_s"),
    I8X16_GE_U(null, null, null, null, 0xfd, 0x6b, "i8x16.ge_u"),
    I16X8_GE_S(null, null, null, null, 0xfd, 0x6c, "i16x8.ge_s"),
    I16X8_GE_U(null, null, null, null, 0xfd, 0x6d, "i16x8.ge_u"),
    I32X4_GE_S(null, null, null, null, 0xfd, 0x6e, "i32x4.ge_s"),
    I32X4_GE_U(null, null, null, null, 0xfd, 0x6f, "i32x4.ge_u"),
    F32X4_GE(null, null, null, null, 0xfd, 0x70, "f32x4.ge"),
    F64X2_GE(null, null, null, null, 0xfd, 0x71, "f64x2.ge"),

    F32X4_NEG(null, null, null, null, 0xfd, 0x72, "f32x4.neg"),
    F64X2_NEG(null, null, null, null, 0xfd, 0x73, "f64x2.neg"),
    F32X4_ABS(null, null, null, null, 0xfd, 0x74, "f32x4.abs"),
    F64X2_ABS(null, null, null, null, 0xfd, 0x75, "f64x2.abs"),
    F32X4_MIN(null, null, null, null, 0xfd, 0x76, "f32x4.min"),
    F64X2_MIN(null, null, null, null, 0xfd, 0x77, "f64x2.min"),
    F32X4_MAX(null, null, null, null, 0xfd, 0x78, "f32x4.max"),
    F64X2_MAX(null, null, null, null, 0xfd, 0x79, "f64x2.max"),
    F32X4_ADD(null, null, null, null, 0xfd, 0x7a, "f32x4.add"),
    F64X2_ADD(null, null, null, null, 0xfd, 0x7b, "f64x2.add"),
    F32X4_SUB(null, null, null, null, 0xfd, 0x7c, "f32x4.sub"),
    F64X2_SUB(null, null, null, null, 0xfd, 0x7d, "f64x2.sub"),
    F32X4_DIV(null, null, null, null, 0xfd, 0x7e, "f32x4.div"),
    F64X2_DIV(null, null, null, null, 0xfd, 0x7f, "f64x2.div"),
    F32X4_MUL(null, null, null, null, 0xfd, 0x80, "f32x4.mul"),
    F64X2_MUL(null, null, null, null, 0xfd, 0x81, "f64x2.mul"),
    F32X4_SQRT(null, null, null, null, 0xfd, 0x82, "f32x4.sqrt"),
    F64X2_SQRT(null, null, null, null, 0xfd, 0x83, "f64x2.sqrt"),

    F32X4_CONVERT_S_I32X4(null, null, null, null, 0xfd, 0x84, "f32x4.convert_s/i32x4"),
    F32X4_CONVERT_U_I32X4(null, null, null, null, 0xfd, 0x85, "f32x4.convert_u/i32x4"),
    F64X2_CONVERT_S_I64X2(null, null, null, null, 0xfd, 0x86, "f64x2.convert_s/i64x2"),
    F64X2_CONVERT_U_I64X2(null, null, null, null, 0xfd, 0x87, "f62x2.convert_u/i64x2"),
    I32X4_TRUNC_S_F32X4_SAT(null, null, null, null, 0xfd, 0x88, "i32x4.trunc_s/f32x4:sat"),
    I32X4_TRUNC_U_F32X4_SAT(null, null, null, null, 0xfd, 0x89, "i32x4.trunc_u/f32x4:sat"),
    I64X2_TRUNC_S_F64X2_SAT(null, null, null, null, 0xfd, 0x8a, "i64x2.trunc_s/f64x2:sat"),
    I64X2_TRUNC_U_F64X2_SAT(null, null, null, null, 0xfd, 0x8b, "i64x2.trunc_u/f64x2:sat"),
    // end
    ;

    /**
     * Opcode value. Used for fast access.
     */
    public val opcode: Int = createOpcode(prefix, code)

    private fun createOpcode(prefix: Int, code: Int): Int {
        return prefix shl 8 or code
    }

    /**
     * Get the `Opcode` with a given value.
     *
     * @param code The code.
     *
     * @return The `Opcode` with the given value.
     */
    public fun fromCode(code: Int): Opcode {
        return fromPrefix(0, code)
    }

    public fun fromPrefix(prefix: Int, code: Int): Opcode {
        for (opcode in values()) {
            if (opcode.prefix == prefix && opcode.code == code) {
                return opcode
            }
        }

        throw IllegalArgumentException("Invalid Opcode with prefix=$prefix and code=$code")
    }

    public fun hasPrefix(): Boolean {
        return prefix != 0
    }

    public fun getLength(): Int {
        return if (hasPrefix()) 2 else 1
    }

    public fun isEnabled(features: Features): Boolean {
        return when (this) {
            TRY, CATCH,
            IF_EXCEPT,
            THROW,
            RETHROW -> features.isExceptionsEnabled

            I32_TRUNC_S_SAT_F32,
            I32_TRUNC_U_SAT_F32,
            I32_TRUNC_S_SAT_F64,
            I32_TRUNC_U_SAT_F64,
            I64_TRUNC_S_SAT_F32,
            I64_TRUNC_U_SAT_F32,
            I64_TRUNC_S_SAT_F64,
            I64_TRUNC_U_SAT_F64 -> features.isSaturatingFloatToIntEnabled

            I32_EXTEND8_S,
            I32_EXTEND16_S,
            I64_EXTEND8_S,
            I64_EXTEND16_S,
            I64_EXTEND32_S,
            ATOMIC_WAKE,
            I32_ATOMIC_WAIT,
            I64_ATOMIC_WAIT,
            I32_ATOMIC_LOAD,
            I64_ATOMIC_LOAD,
            I32_ATOMIC_LOAD8_U,
            I32_ATOMIC_LOAD16_U,
            I64_ATOMIC_LOAD8_U,
            I64_ATOMIC_LOAD16_U,
            I64_ATOMIC_LOAD32_U,
            I32_ATOMIC_STORE,
            I64_ATOMIC_STORE,
            I32_ATOMIC_STORE8,
            I32_ATOMIC_STORE16,
            I64_ATOMIC_STORE8,
            I64_ATOMIC_STORE16,
            I64_ATOMIC_STORE32,
            I32_ATOMIC_RMW_ADD,
            I64_ATOMIC_RMW_ADD,
            I32_ATOMIC_RMW8_U_ADD,
            I32_ATOMIC_RMW16_U_ADD,
            I64_ATOMIC_RMW8_U_ADD,
            I64_ATOMIC_RMW16_U_ADD,
            I64_ATOMIC_RMW32_U_ADD,
            I32_ATOMIC_RMW_SUB,
            I64_ATOMIC_RMW_SUB,
            I32_ATOMIC_RMW8_U_SUB,
            I32_ATOMIC_RMW16_U_SUB,
            I64_ATOMIC_RMW8_U_SUB,
            I64_ATOMIC_RMW16_U_SUB,
            I64_ATOMIC_RMW32_U_SUB,
            I32_ATOMIC_RMW_AND,
            I64_ATOMIC_RMW_AND,
            I32_ATOMIC_RMW8_U_AND,
            I32_ATOMIC_RMW16_U_AND,
            I64_ATOMIC_RMW8_U_AND,
            I64_ATOMIC_RMW16_U_AND,
            I64_ATOMIC_RMW32_U_AND,
            I32_ATOMIC_RMW_OR,
            I64_ATOMIC_RMW_OR,
            I32_ATOMIC_RMW8_U_OR,
            I32_ATOMIC_RMW16_U_OR,
            I64_ATOMIC_RMW8_U_OR,
            I64_ATOMIC_RMW16_U_OR,
            I64_ATOMIC_RMW32_U_OR,
            I32_ATOMIC_RMW_XOR,
            I64_ATOMIC_RMW_XOR,
            I32_ATOMIC_RMW8_U_XOR,
            I32_ATOMIC_RMW16_U_XOR,
            I64_ATOMIC_RMW8_U_XOR,
            I64_ATOMIC_RMW16_U_XOR,
            I64_ATOMIC_RMW32_U_XOR,
            I32_ATOMIC_RMW_XCHG,
            I64_ATOMIC_RMW_XCHG,
            I32_ATOMIC_RMW8_U_XCHG,
            I32_ATOMIC_RMW16_U_XCHG,
            I64_ATOMIC_RMW8_U_XCHG,
            I64_ATOMIC_RMW16_U_XCHG,
            I64_ATOMIC_RMW32_U_XCHG,
            I32_ATOMIC_RMW_CMPXCHG,
            I64_ATOMIC_RMW_CMPXCHG,
            I32_ATOMIC_RMW8_U_CMPXCHG,
            I32_ATOMIC_RMW16_U_CMPXCHG,
            I64_ATOMIC_RMW8_U_CMPXCHG,
            I64_ATOMIC_RMW16_U_CMPXCHG,
            I64_ATOMIC_RMW32_U_CMPXCHG -> features.isThreadsEnabled

            V128_CONST,
            V128_LOAD,
            V128_STORE,
            I8X16_SPLAT,
            I16X8_SPLAT,
            I32X4_SPLAT,
            I64X2_SPLAT,
            F32X4_SPLAT,
            F64X2_SPLAT,
            I8X16_EXTRACT_LANE_S,
            I8X16_EXTRACT_LANE_U,
            I16X8_EXTRACT_LANE_S,
            I16X8_EXTRACT_LANE_U,
            I32X4_EXTRACT_LANE,
            I64X2_EXTRACT_LANE,
            F32X4_EXTRACT_LANE,
            F64X2_EXTRACT_LANE,
            I8X16_REPLACE_LANE,
            I16X8_REPLACE_LANE,
            I32X4_REPLACE_LANE,
            I64X2_REPLACE_LANE,
            F32X4_REPLACE_LANE,
            F64X2_REPLACE_LANE,
            V8X16_SHUFFLE,
            I8X16_ADD,
            I16X8_ADD,
            I32X4_ADD,
            I64X2_ADD,
            I8X16_SUB,
            I16X8_SUB,
            I32X4_SUB,
            I64X2_SUB,
            I8X16_MUL,
            I16X8_MUL,
            I32X4_MUL,
            I8X16_NEG,
            I16X8_NEG,
            I32X4_NEG,
            I64X2_NEG,
            I8X16_ADD_SATURATE_S,
            I8X16_ADD_SATURATE_U,
            I16X8_ADD_SATURATE_S,
            I16X8_ADD_SATURATE_U,
            I8X16_SUB_SATURATE_S,
            I8X16_SUB_SATURATE_U,
            I16X8_SUB_SATURATE_S,
            I16X8_SUB_SATURATE_U,
            I8X16_SHL,
            I16X8_SHL,
            I32X4_SHL,
            I64X2_SHL,
            I8X16_SHL_S,
            I8X16_SHL_U,
            I16X8_SHL_S,
            I16X8_SHL_U,
            I32X4_SHL_S,
            I32X4_SHL_U,
            I64X2_SHL_S,
            I64X2_SHL_U,
            V128_AND,
            V128_OR,
            V128_XOR,
            V128_NOT,
            V128_BITSELECT,
            I8X16_ANY_TRUE,
            I16X8_ANY_TRUE,
            I32X4_ANY_TRUE,
            I64X2_ANY_TRUE,
            I8X16_ALL_TRUE,
            I16X8_ALL_TRUE,
            I32X4_ALL_TRUE,
            I64X2_ALL_TRUE,
            I8X16_EQ,
            I16X8_EQ,
            I32X4_EQ,
            F32X4_EQ,
            F64X2_EQ,
            I8X16_NE,
            I16X8_NE,
            I32X4_NE,
            F32X4_NE,
            F64X2_NE,
            I8X16_LT_S,
            I8X16_LT_U,
            I16X8_LT_S,
            I16X8_LT_U,
            I32X4_LT_S,
            I32X4_LT_U,
            F32X4_LT,
            F64X2_LT,
            I8X16_LE_S,
            I8X16_LE_U,
            I16X8_LE_S,
            I16X8_LE_U,
            I32X4_LE_S,
            I32X4_LE_U,
            F32X4_LE,
            F64X2_LE,
            I8X16_GT_S,
            I8X16_GT_U,
            I16X8_GT_S,
            I16X8_GT_U,
            I32X4_GT_S,
            I32X4_GT_U,
            F32X4_GT,
            F64X2_GT,
            I8X16_GE_S,
            I8X16_GE_U,
            I16X8_GE_S,
            I16X8_GE_U,
            I32X4_GE_S,
            I32X4_GE_U,
            F32X4_GE,
            F64X2_GE,
            F32X4_NEG,
            F64X2_NEG,
            F32X4_ABS,
            F64X2_ABS,
            F32X4_MIN,
            F64X2_MIN,
            F32X4_MAX,
            F64X2_MAX,
            F32X4_ADD,
            F64X2_ADD,
            F32X4_SUB,
            F64X2_SUB,
            F32X4_DIV,
            F64X2_DIV,
            F32X4_MUL,
            F64X2_MUL,
            F32X4_SQRT,
            F64X2_SQRT,
            F32X4_CONVERT_S_I32X4,
            F32X4_CONVERT_U_I32X4,
            F64X2_CONVERT_S_I64X2,
            F64X2_CONVERT_U_I64X2,
            I32X4_TRUNC_S_F32X4_SAT,
            I32X4_TRUNC_U_F32X4_SAT,
            I64X2_TRUNC_S_F64X2_SAT,
            I64X2_TRUNC_U_F64X2_SAT -> features.isSimdEnabled

            else -> true
        }
    }

    public fun isPrefix(value: Int): Boolean {
        return (value == PREFIX_NUMERIC) || (value == PREFIX_THREADS) || (value == PREFIX_SIMD)
    }

    public companion object {
        public const val PREFIX_NUMERIC: Int = 0xfc
        public const val PREFIX_THREADS: Int = 0xfe
        public const val PREFIX_SIMD: Int = 0xfd
    }
}

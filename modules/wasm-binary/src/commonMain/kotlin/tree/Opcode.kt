package org.wasmium.wasm.binary.tree

import org.wasmium.wasm.binary.Features

public const val PREFIX_GC: Int = 0xFB
public const val PREFIX_FC: Int = 0xFC
public const val PREFIX_SIMD: Int = 0xFD
public const val PREFIX_THREADS: Int = 0xFE

/**
 * List of WebAssembly opcodes.
 */
public enum class Opcode(
    /** Prefix of the opcode. The prefix is a byte type. */
    public val prefix: Int,
    /** Code of {@link Opcode}. */
    public val codeId: Int,
    /** Name of the opcode.*/
    public val code: String,
) {
    UNREACHABLE(0, 0x00, "unreachable"),
    NOP(0, 0x01, "nop"),
    BLOCK(0, 0x02, "block"),
    LOOP(0, 0x03, "loop"),
    IF(0, 0x04, "if"),
    ELSE(0, 0x05, "else"),
    TRY(0, 0x06, "try"),
    CATCH(0, 0x07, "catch"),
    THROW(0, 0x08, "throw"),
    RETHROW(0, 0x09, "rethrow"),
    THROW_REF(0, 0x0a, "throw_ref"),
    END(0, 0x0B, "end"),
    BR(0, 0x0C, "br"),
    BR_IF(0, 0x0D, "br_if"),
    BR_TABLE(0, 0x0E, "br_table"),
    RETURN(0, 0x0F, "return"),
    CALL(0, 0x10, "call"),
    CALL_INDIRECT(0, 0x11, "call_indirect"),
    RETURN_CALL(0, 0x12, "return_call"),
    RETURN_CALL_INDIRECT(0, 0x13, "return_call_indirect"),
    CALL_REF(0, 0x14, "call_ref"),
    RETURN_CALL_REF(0, 0x15, "return_call_ref"),
    DELEGATE(0, 0x18, "delegate"),
    CATCH_ALL(0, 0x19, "catch_all"),
    DROP(0, 0x1A, "drop"),
    SELECT(0, 0x1B, "select"),
    SELECT_T(0, 0x1C, "select_t"),
    TRY_TABLE(0, 0x1F, "try_table"),
    GET_LOCAL(0, 0x20, "get_local"),
    SET_LOCAL(0, 0x21, "set_local"),
    TEE_LOCAL(0, 0x22, "tee_local"),
    GET_GLOBAL(0, 0x23, "get_global"),
    SET_GLOBAL(0, 0x24, "set_global"),
    GET_TABLE(0, 0x25, "get_table"),
    SET_TABLE(0, 0x26, "set_table"),
    I32_LOAD(0, 0x28, "i32.load"),
    I64_LOAD(0, 0x29, "i64.load"),
    F32_LOAD(0, 0x2A, "f32.load"),
    F64_LOAD(0, 0x2B, "f64.load"),
    I32_LOAD8_S(0, 0x2C, "i32.load8_s"),
    I32_LOAD8_U(0, 0x2D, "i32.load8_u"),
    I32_LOAD16_S(0, 0x2E, "i32.load16_s"),
    I32_LOAD16_U(0, 0x2F, "i32.load16_u"),
    I64_LOAD8_S(0, 0x30, "i64.load8_s"),
    I64_LOAD8_U(0, 0x31, "i64.load8_u"),
    I64_LOAD16_S(0, 0x32, "i64.load16_s"),
    I64_LOAD16_U(0, 0x33, "i64.load16_u"),
    I64_LOAD32_S(0, 0x34, "i64.load32_s"),
    I64_LOAD32_U(0, 0x35, "i64.load32_u"),
    I32_STORE(0, 0x36, "i32.store"),
    I64_STORE(0, 0x37, "i64.store"),
    F32_STORE(0, 0x38, "f32.store"),
    F64_STORE(0, 0x39, "f64.store"),
    I32_STORE8(0, 0x3A, "i32.store8"),
    I32_STORE16(0, 0x3B, "i32.store16"),
    I64_STORE8(0, 0x3C, "i64.store8"),
    I64_STORE16(0, 0x3D, "i64.store16"),
    I64_STORE32(0, 0x3E, "i64.store32"),
    MEMORY_SIZE(0, 0x3F, "memory.size"),
    MEMORY_GROW(0, 0x40, "memory.grow"),
    I32_CONST(0, 0x41, "i32.const"),
    I64_CONST(0, 0x42, "i64.const"),
    F32_CONST(0, 0x43, "f32.const"),
    F64_CONST(0, 0x44, "i64.const"),
    I32_EQZ(0, 0x45, "i32.eqz"),
    I32_EQ(0, 0x46, "i32.eq"),
    I32_NE(0, 0x47, "i32.ne"),
    I32_LT_S(0, 0x48, "i32.lt_s"),
    I32_LT_U(0, 0x49, "i32.lt_u"),
    I32_GT_S(0, 0x4A, "i32.gt_s"),
    I32_GT_U(0, 0x4B, "i32.gt_u"),
    I32_LE_S(0, 0x4C, "i32.le_s"),
    I32_LE_U(0, 0x4D, "i32.le_u"),
    I32_GE_S(0, 0x4E, "i32.ge_s"),
    I32_GE_U(0, 0x4F, "i32.ge_u"),
    I64_EQZ(0, 0x50, "i64.eqz"),
    I64_EQ(0, 0x51, "i64.eq"),
    I64_NE(0, 0x52, "i64.ne"),
    I64_LT_S(0, 0x53, "i64.lt_s"),
    I64_LT_U(0, 0x54, "i64.lt_u"),
    I64_GT_S(0, 0x55, "i64.gt_s"),
    I64_GT_U(0, 0x56, "i64.gt_u"),
    I64_LE_S(0, 0x57, "i64.le_s"),
    I64_LE_U(0, 0x58, "i64.le_u"),
    I64_GE_S(0, 0x59, "i64.ge_s"),
    I64_GE_U(0, 0x5A, "i64.ge_u"),
    F32_EQ(0, 0x5B, "f32.eq"),
    F32_NE(0, 0x5C, "f32.ne"),
    F32_LT(0, 0x5D, "f32.lt"),
    F32_GT(0, 0x5E, "f32.gt"),
    F32_LE(0, 0x5F, "f32.le"),
    F32_GE(0, 0x60, "f32.ge"),
    F64_EQ(0, 0x61, "f64.eq"),
    F64_NE(0, 0x62, "f64.ne"),
    F64_LT(0, 0x63, "f64.lt"),
    F64_GT(0, 0x64, "f64.gt"),
    F64_LE(0, 0x65, "f64.le"),
    F64_GE(0, 0x66, "f64.ge"),
    I32_CLZ(0, 0x67, "i32.clz"),
    I32_CTZ(0, 0x68, "i32.ctz"),
    I32_POPCNT(0, 0x69, "i32.popcnt"),
    I32_ADD(0, 0x6A, "i32.add"),
    I32_SUB(0, 0x6B, "i32.sub"),
    I32_MUL(0, 0x6C, "i32.mul"),
    I32_DIV_S(0, 0x6D, "i32.div_s"),
    I32_DIV_U(0, 0x6E, "i32.div_u"),
    I32_REM_S(0, 0x6F, "i32.rem_s"),
    I32_REM_U(0, 0x70, "i32.rem_u"),
    I32_AND(0, 0x71, "i32.and"),
    I32_OR(0, 0x72, "i32.or"),
    I32_XOR(0, 0x73, "i32.xor"),
    I32_SHL(0, 0x74, "i32.shl"),
    I32_SHR_S(0, 0x75, "i32.shr_s"),
    I32_SHR_U(0, 0x76, "i32.shr_u"),
    I32_ROTL(0, 0x77, "i32.rotl"),
    I32_ROTR(0, 0x78, "i32.rotr"),
    I64_CLZ(0, 0x79, "i32.clz"),
    I64_CTZ(0, 0x7A, "i32.ctz"),
    I64_POPCNT(0, 0x7B, "i32.popcnt"),
    I64_ADD(0, 0x7C, "i64.add"),
    I64_SUB(0, 0x7D, "i64.sub"),
    I64_MUL(0, 0x7E, "i64.mul"),
    I64_DIV_S(0, 0x7F, "i64.div_s"),
    I64_DIV_U(0, 0x80, "i64.div_u"),
    I64_REM_S(0, 0x81, "i64.rem_s"),
    I64_REM_U(0, 0x82, "i64.rem_u"),
    I64_AND(0, 0x83, "i64.and"),
    I64_OR(0, 0x84, "i64.or"),
    I64_XOR(0, 0x85, "i64.xor"),
    I64_SHL(0, 0x86, "i64.shl"),
    I64_SHR_S(0, 0x87, "i64.shl_s"),
    I64_SHR_U(0, 0x88, "i64.shl_u"),
    I64_ROTL(0, 0x89, "i64.rotl"),
    I64_ROTR(0, 0x8A, "i64.rotr"),
    F32_ABS(0, 0x8B, "f32.abs"),
    F32_NEG(0, 0x8C, "f32.neg"),
    F32_CEIL(0, 0x8D, "f32.ceil"),
    F32_FLOOR(0, 0x8E, "f32.floor"),
    F32_TRUNC(0, 0x8F, "f32.trunc"),
    F32_NEAREST(0, 0x90, "f32.nearest"),
    F32_SQRT(0, 0x91, "f32.sqrt"),
    F32_ADD(0, 0x92, "f32.add"),
    F32_SUB(0, 0x93, "f32.sub"),
    F32_MUL(0, 0x94, "f32.mul"),
    F32_DIV(0, 0x95, "f32.div"),
    F32_MIN(0, 0x96, "f32.min"),
    F32_MAX(0, 0x97, "f32.max"),
    F32_COPYSIGN(0, 0x98, "f32.copysign"),
    F64_ABS(0, 0x99, "f64.abs"),
    F64_NEG(0, 0x9A, "f64.neg"),
    F64_CEIL(0, 0x9B, "f64.ceil"),
    F64_FLOOR(0, 0x9C, "f64.floor"),
    F64_TRUNC(0, 0x9D, "f64.trunc"),
    F64_NEAREST(0, 0x9E, "f64.nearest"),
    F64_SQRT(0, 0x9F, "f64.sqrt"),
    F64_ADD(0, 0xA0, "f64.add"),
    F64_SUB(0, 0xA1, "f64.sub"),
    F64_MUL(0, 0xA2, "f64.mul"),
    F64_DIV(0, 0xA3, "f64.div"),
    F64_MIN(0, 0xA4, "f64.min"),
    F64_MAX(0, 0xA5, "f64.max"),
    F64_COPYSIGN(0, 0xA6, "f64.copysign"),
    I32_WRAP_I64(0, 0xA7, "i32.wrap/i64"),
    I32_TRUNC_SF32(0, 0xA8, "i32.trunc_s/f32"),
    I32_TRUNC_UF32(0, 0xA9, "i32.trunc_u/f32"),
    I32_TRUNC_SF64(0, 0xAA, "i32.trunc_s/f64"),
    I32_TRUNC_UF64(0, 0xAB, "i32.trunc_u/f64"),
    I64_EXTEND_SI32(0, 0xAC, "i64.extend_s/i32"),
    I64_EXTEND_UI32(0, 0xAD, "i64.extend_u/i32"),
    I64_TRUNC_SF32(0, 0xAE, "i64.trunc_s/f32"),
    I64_TRUNC_UF32(0, 0xAF, "i64.trunc_u/f32"),
    I64_TRUNC_SF64(0, 0xB0, "i64.trunc_s/f64"),
    I64_TRUNC_UF64(0, 0xB1, "i64.trunc_u/f64"),
    F32_CONVERT_SI32(0, 0xB2, "f32.convert_s/i32"),
    F32_CONVERT_UI32(0, 0xB3, "f32.convert_u/i32"),
    F32_CONVERT_SI64(0, 0xB4, "f32.convert_s/i64"),
    F32_CONVERT_UI64(0, 0xB5, "f32.convert_u/i64"),
    F32_DEMOTE_F64(0, 0xB6, "f32.demote/f64"),
    F64_CONVERT_SI32(0, 0xB7, "f64.convert_s/i32"),
    F64_CONVERT_UI32(0, 0xB8, "f64.convert_u/i32"),
    F64_CONVERT_SI64(0, 0xB9, "f64.convert_s/i64"),
    F64_CONVERT_UI64(0, 0xBA, "f64.convert_u/i64"),
    F64_PROMOTE_F32(0, 0xBB, "f64.promote/f32"),
    I32_REINTERPRET_F32(0, 0xBC, "i32.reinterpret/f32"),
    I64_REINTERPRET_F64(0, 0xBD, "i64.reinterpret/f64"),
    F32_REINTERPRET_I32(0, 0xBE, "f32.reinterpret/i32"),
    F64_REINTERPRET_I64(0, 0xBF, "f64.reinterpret/i64"),
    I32_EXTEND8_S(0, 0xC0, "i32.extend8_s"),
    I32_EXTEND16_S(0, 0xC1, "i32.extend16_s"),
    I64_EXTEND8_S(0, 0xC2, "i64.extend8_s"),
    I64_EXTEND16_S(0, 0xC3, "i64.extend16_s"),
    I64_EXTEND32_S(0, 0xC4, "i64.extend32_s"),
    REF_NULL(0, 0xD0, "ref.null"),
    REF_IS_NULL(0, 0xD1, "ref.is_null"),
    REF_FUNC(0, 0xD2, "ref.func"),
    REF_AS_NON_NULL(0, 0xD3, "ref.as_non_null"),
    BR_ON_NULL(0, 0xD4, "br_on_null"),
    REF_EQ(0, 0xD5, "ref.eq"),
    BR_ON_NON_NULL(0, 0xD6, "be_on_non_null"),

    I32_TRUNC_S_SAT_F32(PREFIX_FC, 0x00, "i32.trunc_s:sat/f32"),
    I32_TRUNC_U_SAT_F32(PREFIX_FC, 0x01, "i32.trunc_u:sat/f32"),
    I32_TRUNC_S_SAT_F64(PREFIX_FC, 0x02, "i32.trunc_s:sat/f64"),
    I32_TRUNC_U_SAT_F64(PREFIX_FC, 0x03, "i32.trunc_u:sat/f64"),
    I64_TRUNC_S_SAT_F32(PREFIX_FC, 0x04, "i64.trunc_s:sat/f32"),
    I64_TRUNC_U_SAT_F32(PREFIX_FC, 0x05, "i64.trunc_u:sat/f32"),
    I64_TRUNC_S_SAT_F64(PREFIX_FC, 0x06, "i64.trunc_s:sat/f64"),
    I64_TRUNC_U_SAT_F64(PREFIX_FC, 0x07, "i64.trunc_u:sat/f64"),
    MEMORY_INIT(PREFIX_FC, 0x08, "memory.init"),
    DATA_DROP(PREFIX_FC, 0x09, "data.drop"),
    MEMORY_COPY(PREFIX_FC, 0x0A, "memory.copy"),
    MEMORY_FILL(PREFIX_FC, 0x0B, "memory.fill"),
    TABLE_INIT(PREFIX_FC, 0x0C, "table.init"),
    ELEMENT_DROP(PREFIX_FC, 0x0D, "elem.drop"),
    TABLE_COPY(PREFIX_FC, 0x0E, "table.copy"),
    TABLE_GROW(PREFIX_FC, 0x0F, "table.grow"),
    TABLE_SIZE(PREFIX_FC, 0xA0, "table.size"),
    TABLE_FILL(PREFIX_FC, 0xA1, "table.fill"),

    MEMORY_ATOMIC_NOTIFY(PREFIX_THREADS, 0x00, "memory.atomic.notify"),
    MEMORY_ATOMIC_WAIT32(PREFIX_THREADS, 0x01, "memory.atomic.wait32"),
    MEMORY_ATOMIC_WAIT64(PREFIX_THREADS, 0x02, "memory.atomic.wait64"),
    ATOMIC_FENCE(PREFIX_THREADS, 0x03, "atomic.fence"),
    I32_ATOMIC_LOAD(PREFIX_THREADS, 0x10, "i32.atomic.load"),
    I64_ATOMIC_LOAD(PREFIX_THREADS, 0x11, "i64.atomic.load"),
    I32_ATOMIC_LOAD8_U(PREFIX_THREADS, 0x12, "i32.atomic.load8_u"),
    I32_ATOMIC_LOAD16_U(PREFIX_THREADS, 0x13, "i32.atomic.load16_u"),
    I64_ATOMIC_LOAD8_U(PREFIX_THREADS, 0x14, "i64.atomic.load8_u"),
    I64_ATOMIC_LOAD16_U(PREFIX_THREADS, 0x15, "i64.atomic.load16_u"),
    I64_ATOMIC_LOAD32_U(PREFIX_THREADS, 0x16, "i64.atomic.load32_u"),
    I32_ATOMIC_STORE(PREFIX_THREADS, 0x17, "i32.atomic.store"),
    I64_ATOMIC_STORE(PREFIX_THREADS, 0x18, "i64.atomic.store"),
    I32_ATOMIC_STORE8(PREFIX_THREADS, 0x19, "i32.atomic.store8"),
    I32_ATOMIC_STORE16(PREFIX_THREADS, 0x1A, "i32.atomic.store16"),
    I64_ATOMIC_STORE8(PREFIX_THREADS, 0x1B, "i64.atomic.store8"),
    I64_ATOMIC_STORE16(PREFIX_THREADS, 0x1c, "i64.atomic.store16"),
    I64_ATOMIC_STORE32(PREFIX_THREADS, 0x1d, "i64.atomic.store32"),
    I32_ATOMIC_RMW_ADD(PREFIX_THREADS, 0x1E, "i32.atomic.rmw.add"),
    I64_ATOMIC_RMW_ADD(PREFIX_THREADS, 0x1F, "i64.atomic.rmw.add"),
    I32_ATOMIC_RMW8_U_ADD(PREFIX_THREADS, 0x20, "i32.atomic.rmw8_u.add"),
    I32_ATOMIC_RMW16_U_ADD(PREFIX_THREADS, 0x21, "i32.atomic.rmw16_u.add"),
    I64_ATOMIC_RMW8_U_ADD(PREFIX_THREADS, 0x22, "i64.atomic.rmw8_u.add"),
    I64_ATOMIC_RMW16_U_ADD(PREFIX_THREADS, 0x23, "i64.atomic.rmw16_u.add"),
    I64_ATOMIC_RMW32_U_ADD(PREFIX_THREADS, 0x24, "i64.atomic.rmw32_u.add"),
    I32_ATOMIC_RMW_SUB(PREFIX_THREADS, 0x25, "i32.atomic.rmw.sub"),
    I64_ATOMIC_RMW_SUB(PREFIX_THREADS, 0x26, "i64.atomic.rmw.sub"),
    I32_ATOMIC_RMW8_U_SUB(PREFIX_THREADS, 0x27, "i32.atomic.rmw8_u.sub"),
    I32_ATOMIC_RMW16_U_SUB(PREFIX_THREADS, 0x28, "i32.atomic.rmw16_u.sub"),
    I64_ATOMIC_RMW8_U_SUB(PREFIX_THREADS, 0x29, "i64.atomic.rmw8_u.sub"),
    I64_ATOMIC_RMW16_U_SUB(PREFIX_THREADS, 0x2A, "i64.atomic.rmw16_u.sub"),
    I64_ATOMIC_RMW32_U_SUB(PREFIX_THREADS, 0x2B, "i64.atomic.rmw32_u.sub"),
    I32_ATOMIC_RMW_AND(PREFIX_THREADS, 0x2C, "i32.atomic.rmw.and"),
    I64_ATOMIC_RMW_AND(PREFIX_THREADS, 0x2D, "i64.atomic.rmw.and"),
    I32_ATOMIC_RMW8_U_AND(PREFIX_THREADS, 0x2E, "i32.atomic.rmw8_u.and"),
    I32_ATOMIC_RMW16_U_AND(PREFIX_THREADS, 0x2F, "i32.atomic.rmw16_u.and"),
    I64_ATOMIC_RMW8_U_AND(PREFIX_THREADS, 0x30, "i64.atomic.rmw8_u.and"),
    I64_ATOMIC_RMW16_U_AND(PREFIX_THREADS, 0x31, "i64.atomic.rmw16_u.and"),
    I64_ATOMIC_RMW32_U_AND(PREFIX_THREADS, 0x32, "i64.atomic.rmw32_u.and"),
    I32_ATOMIC_RMW_OR(PREFIX_THREADS, 0x33, "i32.atomic.rmw.or"),
    I64_ATOMIC_RMW_OR(PREFIX_THREADS, 0x34, "i64.atomic.rmw.or"),
    I32_ATOMIC_RMW8_U_OR(PREFIX_THREADS, 0x35, "i32.atomic.rmw8_u.or"),
    I32_ATOMIC_RMW16_U_OR(PREFIX_THREADS, 0x36, "i32.atomic.rmw16_u.or"),
    I64_ATOMIC_RMW8_U_OR(PREFIX_THREADS, 0x37, "i64.atomic.rmw8_u.or"),
    I64_ATOMIC_RMW16_U_OR(PREFIX_THREADS, 0x38, "i64.atomic.rmw16_u.or"),
    I64_ATOMIC_RMW32_U_OR(PREFIX_THREADS, 0x39, "i64.atomic.rmw32_u.or"),
    I32_ATOMIC_RMW_XOR(PREFIX_THREADS, 0x3A, "i32.atomic.rmw.xor"),
    I64_ATOMIC_RMW_XOR(PREFIX_THREADS, 0x3B, "i64.atomic.rmw.xor"),
    I32_ATOMIC_RMW8_U_XOR(PREFIX_THREADS, 0x3C, "i32.atomic.rmw8_u.xor"),
    I32_ATOMIC_RMW16_U_XOR(PREFIX_THREADS, 0x3D, "i32.atomic.rmw16_u.xor"),
    I64_ATOMIC_RMW8_U_XOR(PREFIX_THREADS, 0x3E, "i64.atomic.rmw8_u.xor"),
    I64_ATOMIC_RMW16_U_XOR(PREFIX_THREADS, 0x3F, "i64.atomic.rmw16_u.xor"),
    I64_ATOMIC_RMW32_U_XOR(PREFIX_THREADS, 0x40, "i64.atomic.rmw32_u.xor"),
    I32_ATOMIC_RMW_XCHG(PREFIX_THREADS, 0x41, "i32.atomic.rmw.xchg"),
    I64_ATOMIC_RMW_XCHG(PREFIX_THREADS, 0x42, "i64.atomic.rmw.xchg"),
    I32_ATOMIC_RMW8_U_XCHG(PREFIX_THREADS, 0x43, "i32.atomic.rmw8_u.xchg"),
    I32_ATOMIC_RMW16_U_XCHG(PREFIX_THREADS, 0x44, "i32.atomic.rmw16_u.xchg"),
    I64_ATOMIC_RMW8_U_XCHG(PREFIX_THREADS, 0x45, "i64.atomic.rmw8_u.xchg"),
    I64_ATOMIC_RMW16_U_XCHG(PREFIX_THREADS, 0x46, "i64.atomic.rmw16_u.xchg"),
    I64_ATOMIC_RMW32_U_XCHG(PREFIX_THREADS, 0x47, "i64.atomic.rmw32_u.xchg"),
    I32_ATOMIC_RMW_CMPXCHG(PREFIX_THREADS, 0x48, "i32.atomic.rmw.cmpxchg"),
    I64_ATOMIC_RMW_CMPXCHG(PREFIX_THREADS, 0x49, "i64.atomic.rmw.cmpxchg"),
    I32_ATOMIC_RMW8_U_CMPXCHG(PREFIX_THREADS, 0x4A, "i32.atomic.rmw8_u.cmpxchg"),
    I32_ATOMIC_RMW16_U_CMPXCHG(PREFIX_THREADS, 0x4B, "i32.atomic.rmw16_u.cmpxchg"),
    I64_ATOMIC_RMW8_U_CMPXCHG(PREFIX_THREADS, 0x4C, "i64.atomic.rmw8_u.cmpxchg"),
    I64_ATOMIC_RMW16_U_CMPXCHG(PREFIX_THREADS, 0x4D, "i64.atomic.rmw16_u.cmpxchg"),
    I64_ATOMIC_RMW32_U_CMPXCHG(PREFIX_THREADS, 0x4E, "i64.atomic.rmw32_u.cmpxchg"),

    V128_CONST(PREFIX_SIMD, 0x00, "v128.const"),
    V128_LOAD(PREFIX_SIMD, 0x01, "v128.load"),
    V128_STORE(PREFIX_SIMD, 0x02, "v128.store"),
    I8X16_SPLAT(PREFIX_SIMD, 0x03, "i8x16.splat"),
    I16X8_SPLAT(PREFIX_SIMD, 0x04, "i16x8.splat"),
    I32X4_SPLAT(PREFIX_SIMD, 0x05, "i32x4.splat"),
    I64X2_SPLAT(PREFIX_SIMD, 0x06, "i16x2.splat"),
    F32X4_SPLAT(PREFIX_SIMD, 0x07, "i32x4.splat"),
    F64X2_SPLAT(PREFIX_SIMD, 0x08, "i64x2.splat"),
    I8X16_EXTRACT_LANE_S(PREFIX_SIMD, 0x09, "i8x16.extract_lane_s"),
    I8X16_EXTRACT_LANE_U(PREFIX_SIMD, 0x0a, "i8x16.extract_lane_u"),
    I16X8_EXTRACT_LANE_S(PREFIX_SIMD, 0x0b, "i16x8.extract_lane_s"),
    I16X8_EXTRACT_LANE_U(PREFIX_SIMD, 0x0c, "i16x8.extract_lane_u"),
    I32X4_EXTRACT_LANE(PREFIX_SIMD, 0x0d, "i32x4.extract_lane"),
    I64X2_EXTRACT_LANE(PREFIX_SIMD, 0x0e, "i64x2.extract_lane"),
    F32X4_EXTRACT_LANE(PREFIX_SIMD, 0x0f, "i32x4.extract_lane"),
    F64X2_EXTRACT_LANE(PREFIX_SIMD, 0x10, "i64X2.extract_lane"),
    I8X16_REPLACE_LANE(PREFIX_SIMD, 0x11, "i8X16.replace_lane"),
    I16X8_REPLACE_LANE(PREFIX_SIMD, 0x12, "i16X8.replace_lane"),
    I32X4_REPLACE_LANE(PREFIX_SIMD, 0x13, "i32X4.replace_lane"),
    I64X2_REPLACE_LANE(PREFIX_SIMD, 0x14, "i64X2.replace_lane"),
    F32X4_REPLACE_LANE(PREFIX_SIMD, 0x15, "i32X4.replace_lane"),
    F64X2_REPLACE_LANE(PREFIX_SIMD, 0x16, "i64X2.replace_lane"),
    V8X16_SHUFFLE(PREFIX_SIMD, 0x17, "v8X16.shuffle"),
    I8X16_ADD(PREFIX_SIMD, 0x18, "i8x16.add"),
    I16X8_ADD(PREFIX_SIMD, 0x19, "i16x8.add"),
    I32X4_ADD(PREFIX_SIMD, 0x1a, "i32x4.add"),
    I64X2_ADD(PREFIX_SIMD, 0x1b, "i16x2.add"),
    I8X16_SUB(PREFIX_SIMD, 0x1c, "i8x16.sub"),
    I16X8_SUB(PREFIX_SIMD, 0x1d, "i16x8.sub"),
    I32X4_SUB(PREFIX_SIMD, 0x1e, "i32x4.sub"),
    I64X2_SUB(PREFIX_SIMD, 0x1f, "i16x2.sub"),
    I8X16_MUL(PREFIX_SIMD, 0x20, "i8x16.mul"),
    I16X8_MUL(PREFIX_SIMD, 0x21, "i16x8.mul"),
    I32X4_MUL(PREFIX_SIMD, 0x22, "i32x4.mul"),
    I8X16_NEG(PREFIX_SIMD, 0x23, "i8x16.neg"),
    I16X8_NEG(PREFIX_SIMD, 0x24, "i16x8.neg"),
    I32X4_NEG(PREFIX_SIMD, 0x25, "i32x4.neg"),
    I64X2_NEG(PREFIX_SIMD, 0x26, "i16x2.neg"),
    I8X16_ADD_SATURATE_S(PREFIX_SIMD, 0x27, "i8x16.add_saturate_s"),
    I8X16_ADD_SATURATE_U(PREFIX_SIMD, 0x28, "i8x16.add_saturate_u"),
    I16X8_ADD_SATURATE_S(PREFIX_SIMD, 0x29, "i16x8.add_saturate_s"),
    I16X8_ADD_SATURATE_U(PREFIX_SIMD, 0x2a, "i16x8.add_saturate_u"),
    I8X16_SUB_SATURATE_S(PREFIX_SIMD, 0x2b, "i8x16.sub_saturate_s"),
    I8X16_SUB_SATURATE_U(PREFIX_SIMD, 0x2c, "i8x16.sub_saturate_u"),
    I16X8_SUB_SATURATE_S(PREFIX_SIMD, 0x2d, "i16x8.sub_saturate_s"),
    I16X8_SUB_SATURATE_U(PREFIX_SIMD, 0x2e, "i16x8.sub_saturate_u"),
    I8X16_SHL(PREFIX_SIMD, 0x2f, "i8x16.shl"),
    I16X8_SHL(PREFIX_SIMD, 0x30, "i16X8.shl"),
    I32X4_SHL(PREFIX_SIMD, 0x31, "i32X4.shl"),
    I64X2_SHL(PREFIX_SIMD, 0x32, "i64X2.shl"),
    I8X16_SHL_S(PREFIX_SIMD, 0x33, "i8x16.shl_s"),
    I8X16_SHL_U(PREFIX_SIMD, 0x34, "i8x16.shl_u"),
    I16X8_SHL_S(PREFIX_SIMD, 0x35, "i16X8.shl_s"),
    I16X8_SHL_U(PREFIX_SIMD, 0x36, "i16X8.shl_u"),
    I32X4_SHL_S(PREFIX_SIMD, 0x37, "i32X4.shl_s"),
    I32X4_SHL_U(PREFIX_SIMD, 0x38, "i32X4.shl_u"),
    I64X2_SHL_S(PREFIX_SIMD, 0x39, "i64X2.shl_s"),
    I64X2_SHL_U(PREFIX_SIMD, 0x3a, "i64X2.shl_u"),
    V128_AND(PREFIX_SIMD, 0x3b, "v128.and"),
    V128_OR(PREFIX_SIMD, 0x3c, "v128.or"),
    V128_XOR(PREFIX_SIMD, 0x3d, "v128.xor"),
    V128_NOT(PREFIX_SIMD, 0x3e, "v128.not"),
    V128_BITSELECT(PREFIX_SIMD, 0x3f, "v128.bitselect"),
    I8X16_ANY_TRUE(PREFIX_SIMD, 0x40, "i8x16.anytrue"),
    I16X8_ANY_TRUE(PREFIX_SIMD, 0x41, "i16x8.anytrue"),
    I32X4_ANY_TRUE(PREFIX_SIMD, 0x42, "i32x4.anytrue"),
    I64X2_ANY_TRUE(PREFIX_SIMD, 0x43, "i64x2.anytrue"),
    I8X16_ALL_TRUE(PREFIX_SIMD, 0x44, "i8x16.anytrue"),
    I16X8_ALL_TRUE(PREFIX_SIMD, 0x45, "i16x8.anytrue"),
    I32X4_ALL_TRUE(PREFIX_SIMD, 0x46, "i32x4.anytrue"),
    I64X2_ALL_TRUE(PREFIX_SIMD, 0x47, "i64x2.anytrue"),
    I8X16_EQ(PREFIX_SIMD, 0x48, "i8x16.eq"),
    I16X8_EQ(PREFIX_SIMD, 0x49, "i16x8.eq"),
    I32X4_EQ(PREFIX_SIMD, 0x4a, "i32x4.eq"),
    F32X4_EQ(PREFIX_SIMD, 0x4b, "f32x4.eq"),
    F64X2_EQ(PREFIX_SIMD, 0x4c, "i64x2.eq"),
    I8X16_NE(PREFIX_SIMD, 0x4d, "i8x16.ne"),
    I16X8_NE(PREFIX_SIMD, 0x4e, "i16x8.ne"),
    I32X4_NE(PREFIX_SIMD, 0x4f, "i32x4.ne"),
    F32X4_NE(PREFIX_SIMD, 0x50, "f32x4.ne"),
    F64X2_NE(PREFIX_SIMD, 0x51, "f64x2.ne"),

    I8X16_LT_S(PREFIX_SIMD, 0x52, "i8x16.lt_s"),
    I8X16_LT_U(PREFIX_SIMD, 0x53, "i8x16.lt_u"),
    I16X8_LT_S(PREFIX_SIMD, 0x54, "i16x8.lt_s"),
    I16X8_LT_U(PREFIX_SIMD, 0x55, "i16x8.lt_u"),
    I32X4_LT_S(PREFIX_SIMD, 0x56, "i32x4.lt_s"),
    I32X4_LT_U(PREFIX_SIMD, 0x57, "i32x4.lt_u"),
    F32X4_LT(PREFIX_SIMD, 0x58, "f32x4.lt"),
    F64X2_LT(PREFIX_SIMD, 0x59, "f64x2.lt"),

    I8X16_LE_S(PREFIX_SIMD, 0x5a, "i8x16.le_s"),
    I8X16_LE_U(PREFIX_SIMD, 0x5b, "i8x16.le_u"),
    I16X8_LE_S(PREFIX_SIMD, 0x5c, "i16x8.le_s"),
    I16X8_LE_U(PREFIX_SIMD, 0x5d, "i16x8.le_u"),
    I32X4_LE_S(PREFIX_SIMD, 0x5e, "i32x4.le_s"),
    I32X4_LE_U(PREFIX_SIMD, 0x5f, "i32x4.le_u"),
    F32X4_LE(PREFIX_SIMD, 0x60, "f32x4.le"),
    F64X2_LE(PREFIX_SIMD, 0x61, "f64x2.le"),

    I8X16_GT_S(PREFIX_SIMD, 0x62, "i8x16.gt_s"),
    I8X16_GT_U(PREFIX_SIMD, 0x63, "i8x16.gt_u"),
    I16X8_GT_S(PREFIX_SIMD, 0x64, "i16x8.gt_s"),
    I16X8_GT_U(PREFIX_SIMD, 0x65, "i16x8.gt_u"),
    I32X4_GT_S(PREFIX_SIMD, 0x66, "i32x4.gt_s"),
    I32X4_GT_U(PREFIX_SIMD, 0x67, "i32x4.gt_u"),
    F32X4_GT(PREFIX_SIMD, 0x68, "f32x4.gt"),
    F64X2_GT(PREFIX_SIMD, 0x69, "f64x2.gt"),

    I8X16_GE_S(PREFIX_SIMD, 0x6a, "i8x16.ge_s"),
    I8X16_GE_U(PREFIX_SIMD, 0x6b, "i8x16.ge_u"),
    I16X8_GE_S(PREFIX_SIMD, 0x6c, "i16x8.ge_s"),
    I16X8_GE_U(PREFIX_SIMD, 0x6d, "i16x8.ge_u"),
    I32X4_GE_S(PREFIX_SIMD, 0x6e, "i32x4.ge_s"),
    I32X4_GE_U(PREFIX_SIMD, 0x6f, "i32x4.ge_u"),
    F32X4_GE(PREFIX_SIMD, 0x70, "f32x4.ge"),
    F64X2_GE(PREFIX_SIMD, 0x71, "f64x2.ge"),

    F32X4_NEG(PREFIX_SIMD, 0x72, "f32x4.neg"),
    F64X2_NEG(PREFIX_SIMD, 0x73, "f64x2.neg"),
    F32X4_ABS(PREFIX_SIMD, 0x74, "f32x4.abs"),
    F64X2_ABS(PREFIX_SIMD, 0x75, "f64x2.abs"),
    F32X4_MIN(PREFIX_SIMD, 0x76, "f32x4.min"),
    F64X2_MIN(PREFIX_SIMD, 0x77, "f64x2.min"),
    F32X4_MAX(PREFIX_SIMD, 0x78, "f32x4.max"),
    F64X2_MAX(PREFIX_SIMD, 0x79, "f64x2.max"),
    F32X4_ADD(PREFIX_SIMD, 0x7a, "f32x4.add"),
    F64X2_ADD(PREFIX_SIMD, 0x7b, "f64x2.add"),
    F32X4_SUB(PREFIX_SIMD, 0x7c, "f32x4.sub"),
    F64X2_SUB(PREFIX_SIMD, 0x7d, "f64x2.sub"),
    F32X4_DIV(PREFIX_SIMD, 0x7e, "f32x4.div"),
    F64X2_DIV(PREFIX_SIMD, 0x7f, "f64x2.div"),
    F32X4_MUL(PREFIX_SIMD, 0x80, "f32x4.mul"),
    F64X2_MUL(PREFIX_SIMD, 0x81, "f64x2.mul"),
    F32X4_SQRT(PREFIX_SIMD, 0x82, "f32x4.sqrt"),
    F64X2_SQRT(PREFIX_SIMD, 0x83, "f64x2.sqrt"),

    F32X4_CONVERT_S_I32X4(PREFIX_SIMD, 0x84, "f32x4.convert_s/i32x4"),
    F32X4_CONVERT_U_I32X4(PREFIX_SIMD, 0x85, "f32x4.convert_u/i32x4"),
    F64X2_CONVERT_S_I64X2(PREFIX_SIMD, 0x86, "f64x2.convert_s/i64x2"),
    F64X2_CONVERT_U_I64X2(PREFIX_SIMD, 0x87, "f62x2.convert_u/i64x2"),
    I32X4_TRUNC_S_F32X4_SAT(PREFIX_SIMD, 0x88, "i32x4.trunc_s/f32x4:sat"),
    I32X4_TRUNC_U_F32X4_SAT(PREFIX_SIMD, 0x89, "i32x4.trunc_u/f32x4:sat"),
    I64X2_TRUNC_S_F64X2_SAT(PREFIX_SIMD, 0x8a, "i64x2.trunc_s/f64x2:sat"),
    I64X2_TRUNC_U_F64X2_SAT(PREFIX_SIMD, 0x8b, "i64x2.trunc_u/f64x2:sat"),
    // end
    ;

    /**
     * Opcode value. Used for fast access.
     */
    public val opcode: Int = createOpcode(prefix, codeId)

    protected fun createOpcode(prefix: Int, code: Int): Int = prefix shl 8 or code

    public fun hasPrefix(): Boolean = prefix != 0

    public fun getLength(): Int = if (hasPrefix()) 2 else 1

    public fun isEnabled(features: Features): Boolean {
        return when (prefix) {
            PREFIX_GC -> features.isGCEnabled
            PREFIX_FC -> features.isFCEnabled
            PREFIX_SIMD -> features.isSIMDEnabled
            PREFIX_THREADS -> features.isThreadsEnabled
            else -> true
        }
    }

    public companion object {
        public fun isPrefix(value: Int): Boolean = (value == PREFIX_GC) || (value == PREFIX_FC) || (value == PREFIX_THREADS) || (value == PREFIX_SIMD)

        public fun fromCode(code: UInt): Opcode? = fromPrefix(0u, code)

        public fun fromPrefix(prefix: UInt, code: UInt): Opcode? = values().firstOrNull {
            it.prefix == prefix.toInt() && it.codeId == code.toInt()
        }
    }
}

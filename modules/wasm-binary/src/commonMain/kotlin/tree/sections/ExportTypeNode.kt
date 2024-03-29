package org.wasmium.wasm.binary.tree.sections

import org.wasmium.wasm.binary.tree.ExternalKind

public class ExportTypeNode(
    public val exportIndex: UInt,
    public val name: String,
    public val kind: ExternalKind,
    /** Index into the corresponding index space.  */
    public val index: UInt,
)

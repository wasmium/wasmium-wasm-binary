package org.wasmium.wasm.binary.tree.sections

import org.wasmium.wasm.binary.tree.SectionKind
import org.wasmium.wasm.binary.visitors.ElementSectionVisitor
import org.wasmium.wasm.binary.visitors.ElementSegmentVisitor

public class ElementSectionNode : SectionNode(SectionKind.ELEMENT), ElementSectionVisitor {
    public val segments: MutableList<ElementSegmentNode> = mutableListOf<ElementSegmentNode>()

    public fun accept(elementSectionVisitor: ElementSectionVisitor) {
        for (elementSegment in segments) {
            val elementSegmentVisitor = elementSectionVisitor.visitElementSegment(elementSegment.elementIndex!!)
            elementSegment.accept(elementSegmentVisitor)
            elementSectionVisitor.visitEnd()
        }
    }

    override fun visitElementSegment(elementIndex: UInt): ElementSegmentVisitor {
        val elementSegment: ElementSegmentNode = ElementSegmentNode()
        elementSegment.elementIndex = elementIndex
        segments.add(elementSegment)
        return elementSegment
    }

    public override fun visitEnd() {
        // empty
    }
}

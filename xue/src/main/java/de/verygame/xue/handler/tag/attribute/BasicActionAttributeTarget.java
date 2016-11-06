package de.verygame.xue.handler.tag.attribute;

import de.verygame.util.modifier.base.SimpleModifierCallback;
import de.verygame.xue.annotation.AttributeHandler;
import de.verygame.xue.mapping.tag.XueTag;
import de.verygame.xue.mapping.tag.attribute.AbstractAttributeGroup;
import de.verygame.xue.mapping.tag.attribute.AttributeGroupElementMeta;
import de.verygame.xue.util.GroupMetaUtils;
import de.verygame.xue.util.action.BasicAction;

import java.util.List;

/**
 * @author Rico Schrage
 */
public class BasicActionAttributeTarget extends AbstractAttributeGroup<BasicAction> {
    private static final List<AttributeGroupElementMeta> GROUP_META = GroupMetaUtils.buildMetaList(new String[]{ "target", "attribute" },
            new Class<?>[]{ Object.class, String.class });

    private XueTag<?> builder;
    private String attribute;

    @Override
    public List<AttributeGroupElementMeta> getGroupMeta() {
        return GROUP_META;
    }

    @AttributeHandler
    public void applyTarget(BasicAction element, Object value) {
        builder = (XueTag<?>) value;
    }

    @AttributeHandler
    public void applyAttribute(BasicAction element, final String value) {
        attribute = value;
    }

    @Override
    public void end(BasicAction element) {
        element.setActionCallback(new SimpleModifierCallback() {
            @Override
            protected void action(float v) {
                builder.apply(attribute, v);
            }
        });

        element.createModifier();
    }
}

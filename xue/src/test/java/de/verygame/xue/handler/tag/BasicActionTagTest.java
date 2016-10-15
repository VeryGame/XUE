package de.verygame.xue.handler.tag;

import de.verygame.xue.mapping.tag.attribute.Attribute;
import de.verygame.xue.mapping.tag.attribute.AttributeGroup;
import de.verygame.xue.handler.tag.attribute.BasicActionAttributeTarget;
import de.verygame.xue.handler.tag.attribute.BasicActionInterpolation;
import de.verygame.xue.util.action.BasicAction;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Rico Schrage
 */
public class BasicActionTagTest {

    private BasicActionTag basicActionTag = new BasicActionTag();

    @Test
    public void defineAttributes() throws Exception {
        List<Attribute<? super BasicAction, ?>> attributeList = basicActionTag.defineAttributes();

        assertTrue(attributeList.contains(BasicActionInterpolation.getInstance()));
    }

    @Test
    public void defineAttributeGroups() throws Exception {
        List<AttributeGroup<? super BasicAction>> attributeList = basicActionTag.defineAttributeGroups();

        assertTrue(attributeList.contains(BasicActionAttributeTarget.getInstance()));
    }

}
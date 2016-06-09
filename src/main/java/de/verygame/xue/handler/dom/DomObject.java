package de.verygame.xue.handler.dom;

import de.verygame.xue.exception.AttributeUnknownException;
import de.verygame.xue.exception.TagUnknownException;
import de.verygame.xue.handler.Globals;
import de.verygame.xue.mapping.builder.GLMenuBuilder;

/**
 * @author Rico Schrage
 */
public class DomObject<T> implements DomRepresentation<T> {
    protected final GLMenuBuilder<T> builder;

    public DomObject(GLMenuBuilder<T> builder) {
        this.builder = builder;
    }

    @Override
    public void begin() {
        builder.preBuild();
    }

    @Override
    public void end() throws AttributeUnknownException {
        builder.postBuild();
    }

    @Override
    public T getObject() {
        return builder.getElement();
    }

    @Override
    public GLMenuBuilder<T> getBuilder() {
        return builder;
    }

    @Override
    public void apply(String attribute, String value) throws AttributeUnknownException, TagUnknownException {

        if (value.matches(Globals.ATT_INT_REGEX)) {
            int integer = Integer.parseInt(value);

            onApplyInt(attribute, integer);
            builder.applyInt(attribute, integer);
        }
        else if (value.matches(Globals.ATT_FLOAT_REGEX)) {
            float f = Float.parseFloat(value);

            onApplyFloat(attribute, f);
            builder.applyFloat(attribute, f);
        }
        else {
            onApplyString(attribute, value);
            builder.applyString(attribute, value);
        }
    }

    protected void onApplyFloat(String attribute, float f) {
        //for subclasses
    }

    protected void onApplyConst(String attribute, String value, GLMenuBuilder<T> builder) {
        //for subclasses
    }

    protected void onApplyString(String attribute, String value) {
        //for subclasses
    }

    protected void onApplyInt(String attribute, int integer) {
        //for subclasses
    }
}

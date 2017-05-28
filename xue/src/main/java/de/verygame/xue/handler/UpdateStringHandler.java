package de.verygame.xue.handler;

import de.verygame.xue.annotation.Dependency;
import de.verygame.xue.dom.DomObject;
import de.verygame.xue.dom.value.StringValue;
import de.verygame.xue.dom.value.Value;
import de.verygame.xue.input.XueInputEvent;
import de.verygame.xue.input.XueInputHandler;

import java.util.List;
import java.util.Map;

/**
 * @author Rico Schrage
 */
public class UpdateStringHandler<T> implements XueInputHandler {

    @Dependency
    protected ElementsTagGroupHandler<T> elementsTagGroupHandler;

    @Override
    public void onInputEvent(XueInputEvent event) {
        if (event != XueInputEvent.CHANGED) {
            return;
        }

        List<? extends DomObject<? extends T>> domElements = elementsTagGroupHandler.getDom();
        for (int i = 0; i < domElements.size(); ++i) {
            DomObject<? extends T> domElement = domElements.get(i);

            domElement.begin();
            for (Map.Entry<String, Value<?, ?>> entry : domElement.getValues().entrySet()) {
                Value<?, ?> value = entry.getValue();
                if (value instanceof StringValue) {
                    StringValue stringValue = (StringValue) value;
                    String rValue = elementsTagGroupHandler.getGlobalMappings().getString(stringValue.getValue());
                    domElement.applyStringId(entry.getKey(), stringValue, rValue);
                }
            }
            domElement.end();
        }
    }
}

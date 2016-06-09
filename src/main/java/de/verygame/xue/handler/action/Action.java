package de.verygame.xue.handler.action;

/**
 * @author Rico Schrage
 */
public interface Action {
    void update(float delta);
    void reset();

    float getDuration();
    float getStartTime();
    float getStopTime();
}

package org.glavo.imagefx.internal;

import javafx.animation.Timeline;
import javafx.beans.value.WritableValue;
import javafx.scene.image.WritableImage;

import java.lang.ref.WeakReference;

public abstract class AbstractAnimationImage extends WritableImage {

    private Animation animation;

    public AbstractAnimationImage(int width, int height) {
        super(width, height);
    }

    private static final class Animation implements WritableValue<Integer> {
        private final Timeline timeline = new Timeline();
        private final WeakReference<AbstractAnimationImage> imageRef;

        private Integer value;

        private Animation(AbstractAnimationImage imageRef) {
            this.imageRef = new WeakReference<>(imageRef);
        }

        private void updateImage(int frameIndex) {
            if (imageRef.get() == null) {
                timeline.stop();
            }

            // TODO
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public void setValue(Integer value) {
            this.value = value;
            updateImage(value);
        }
    }
}

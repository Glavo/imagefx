package org.glavo.imagefx;

import javafx.scene.image.Image;

public interface AnimationImage {
    default Image self() {
         return (Image) this;
    }
}

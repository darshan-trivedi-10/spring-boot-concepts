package com.learning.spring_boot.springbootcontollerlayer;

import java.beans.PropertyEditorSupport;

public class firstMessagePropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.trim().toUpperCase());
    }
}

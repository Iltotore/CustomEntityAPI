package io.github.iltotore.customentity.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectUtil {

    private static Field MODIFIER_FIELD;

    static {
        try {
            MODIFIER_FIELD = Field.class.getDeclaredField("modifiers");
            MODIFIER_FIELD.setAccessible(true);
        } catch(NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void setFieldModifier(Field field, int modifiers){
        try {
            MODIFIER_FIELD.setInt(field, modifiers);
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void setFinal(Field field, boolean isFinal){
        setFieldModifier(field, field.getModifiers() & (isFinal ? Modifier.FINAL : ~Modifier.FINAL));
    }
}

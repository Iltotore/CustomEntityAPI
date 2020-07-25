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

    /**
     * Change the field modifier
     * @param field the Field to edit.
     * @param modifiers the new modifier.
     */
    public static void setFieldModifier(Field field, int modifiers){
        try {
            MODIFIER_FIELD.setInt(field, modifiers);
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Set the given Field's final property.
     * @param field the Field to edit.
     * @param isFinal true to make the Field final. False otherwise.
     */
    public static void setFinal(Field field, boolean isFinal){
        setFieldModifier(field, field.getModifiers() & (isFinal ? Modifier.FINAL : ~Modifier.FINAL));
    }
}

package org.clinicalontology.terminology.api.model;

import org.apache.commons.lang3.Validate;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Helper class that emulates a Java enum where a native enum is not practical.  It works by scanning the specified
 * class for public+static+final fields of the specified type and building an index of these.  That index is then
 * used to provide approximate implementations of several of the static methods found in a native enum.
 *
 * @param <T> The type of members.
 */
public class CodeSystemEnumerator<T> {

    private final Map<String, T> members = new LinkedHashMap<>();

    private final List<String> names;

    private final List<T> values;

    public CodeSystemEnumerator(Class<T> memberType) {
        this(memberType, memberType);
    }

    @SuppressWarnings("unchecked")
    public CodeSystemEnumerator(Class<?> pseudoEnumClass, Class<T> memberType) {
        for (Field member : pseudoEnumClass.getDeclaredFields()) {
            try {
                member.setAccessible(true);
                int modifiers = member.getModifiers();

                if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
                    Object value = member.get(null);

                    if (memberType.isInstance(value)) {
                        members.put(member.getName(), (T) value);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }

        names = Collections.unmodifiableList(new ArrayList<>(members.keySet()));
        values = Collections.unmodifiableList(new ArrayList<>(members.values()));
    }

    public List<String> names() {
        return names;
    }

    public List<T> values() {
        return values;
    }

    public T valueOf(String key, boolean exceptionIfNotFound) {
        T value = members.get(key);
        Validate.isTrue(value != null || !exceptionIfNotFound, "No member named %s was found.", key);
        return value;
    }

    public T valueOf(String name) {
        return valueOf(name, true);
    }

    public int ordinal(String name) {
        return names.indexOf(name);
    }

    public int ordinal(T member) {
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) == member) {
                return i;
            }
        }

        return -1;
    }

    public String name(T member) {
        int i = ordinal(member);
        return i == -1 ? null : names.get(i);
    }
}

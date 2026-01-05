package org.clinicalontology.terminology.api.model;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.Validate;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * Create a new enumerator where the enum class and member type are the same.
     *
     * @param memberType The type of members.
     */
    public CodeSystemEnumerator(Class<T> memberType) {
        this(memberType, memberType);
    }

    /**
     * Create a new enumerator.
     *
     * @param pseudoEnumClass The class that contains the members.
     * @param memberType      The type of members.
     */
    public CodeSystemEnumerator(
        Class<?> pseudoEnumClass,
        Class<T> memberType
    ) {
        for (Field member : pseudoEnumClass.getDeclaredFields()) {
            try {
                member.setAccessible(true);
                int modifiers = member.getModifiers();

                if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
                    Object value = member.get(null);

                    if (memberType.isInstance(value)) {
                        members.put(member.getName(), memberType.cast(value));
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }

        names = List.copyOf(members.keySet());
        values = List.copyOf(members.values());
    }

    /**
     * Returns the member names.
     *
     * @return The member names.
     */
    public List<String> names() {
        return names;
    }

    /**
     * Returns the member values.
     *
     * @return The member values.
     */
    public List<T> values() {
        return values;
    }

    /**
     * Returns the member with the specified name.
     *
     * @param name                The member name.
     * @param exceptionIfNotFound If true, an exception is thrown if the member is not found.
     * @return The member with the specified name (possibly null).
     */
    public T valueOf(
        String name,
        boolean exceptionIfNotFound
    ) {
        T value = members.get(name);
        Validate.isTrue(value != null || !exceptionIfNotFound, "No member named %s was found.", name);
        return value;
    }

    /**
     * Returns the member with the specified name.  An exception is thrown if the member is not found.
     *
     * @param name The member name.
     * @return The member with the specified name (never null).
     */
    public T valueOf(String name) {
        return valueOf(name, true);
    }

    /**
     * Returns the ordinal of the specified member name.  If the member is not found, an exception is thrown.
     *
     * @param name The member name.
     * @return The ordinal of the specified member name.
     */
    public int ordinal(String name) {
        int ordinal = names.indexOf(name);
        Validate.isTrue(ordinal != -1, "No member named %s was found.", name);
        return ordinal;
    }

    /**
     * Returns the ordinal of the specified member.  If the member is not found, an exception is thrown.
     *
     * @param member The member.
     * @return The ordinal of the specified member.
     */
    public int ordinal(T member) {
        int ordinal = ListUtils.indexOf(values, value -> value == member);
        Validate.isTrue(ordinal != -1, "%s is not a member.", member.toString());
        return ordinal;
    }

    /**
     * Returns the name of the specified member.  If the member is not found, an exception is thrown.
     *
     * @param member The member.
     * @return The name of the specified member.
     */
    public String name(T member) {
        return names.get(ordinal(member));
    }
}

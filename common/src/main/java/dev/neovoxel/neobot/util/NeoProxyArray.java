package dev.neovoxel.neobot.util;

import lombok.Getter;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Value;
import org.graalvm.polyglot.proxy.ProxyArray;

import java.util.ArrayList;
import java.util.List;

@Getter(onMethod_ = {@HostAccess.Export})
public class NeoProxyArray<T> implements ProxyArray {

    private final List<T> list;

    public NeoProxyArray(List<T> list) {
        this.list = list;
    }

    @Override
    public T get(long index) {
        try {
            return list.get((int) index);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void set(long index, Value value) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index cannot be negative: " + index);
        }

        if (index >= list.size()) {
            for (long i = list.size(); i <= index; i++) {
                list.add(null);
            }
        }

        @SuppressWarnings("unchecked")
        T convertedValue = (T) convertValue(value);
        list.set((int) index, convertedValue);
    }

    @Override
    public long getSize() {
        return list.size();
    }

    private Object convertValue(Value value) {
        if (value == null || value.isNull()) {
            return null;
        }

        if (value.isString()) {
            return value.asString();
        } else if (value.isNumber()) {
            if (!list.isEmpty()) {
                T first = list.get(0);
                if (first instanceof Integer) {
                    return value.asInt();
                } else if (first instanceof Long) {
                    return value.asLong();
                } else if (first instanceof Double) {
                    return value.asDouble();
                } else if (first instanceof Float) {
                    return value.asFloat();
                }
            }
            return value.asDouble();
        } else if (value.isBoolean()) {
            return value.asBoolean();
        } else if (value.hasArrayElements()) {
            List<Object> newList = new ArrayList<>();
            for (long i = 0; i < value.getArraySize(); i++) {
                newList.add(convertValue(value.getArrayElement(i)));
            }
            return newList;
        } else {
            return value;
        }
    }


}

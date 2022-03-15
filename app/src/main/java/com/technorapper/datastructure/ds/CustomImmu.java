package com.technorapper.datastructure.ds;

import java.util.ArrayList;
import java.util.List;

public final class CustomImmu implements Cloneable {
    private final List<String> name = new ArrayList<>();
    private final Integer age = 10;

    public List<String> getName() {
        List<String> rName = new ArrayList<>(name);
        return rName;
    }

    public CustomImmu clone() {
        try {
            CustomImmu rName = (CustomImmu) super.clone();

            rName.clone();
            return rName.clone();
        } catch (CloneNotSupportedException e) {
            // Will not happen in this case
            return null;
        }

    }

}

class Test {
    int x, y;
}
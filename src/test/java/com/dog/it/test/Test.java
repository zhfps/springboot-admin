package com.dog.it.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Test {
    private  String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;
        Test test = (Test) o;
        return Objects.equals(getName(), test.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

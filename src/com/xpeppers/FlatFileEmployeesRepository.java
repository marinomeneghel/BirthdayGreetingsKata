package com.xpeppers;

import java.util.List;

public class FlatFileEmployeesRepository implements Repository<List<Employee>> {

    @Override
    public void store(List<Employee> employees) {

    }

    @Override
    public List<Employee> load() {
        return null;
    }

    @Override
    public void delete() {

    }
}

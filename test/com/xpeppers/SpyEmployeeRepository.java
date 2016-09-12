package com.xpeppers;

import com.xpeppers.repositories.Repository;

import java.util.List;

class SpyEmployeeRepository implements Repository<List<Employee>> {
    int loadCalls = 0;

    @Override
    public void store(List<Employee> employees) {

    }

    @Override
    public List<Employee> load() {
        loadCalls++;
        return null;
    }

    @Override
    public void delete() {

    }

    boolean isCalled(int times) {
        return loadCalls == times;
    }
}

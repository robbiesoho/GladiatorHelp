package com.web.repo;

import java.util.List;

public interface DaoContract<T, I> {

	List<T> findAll();

	T findById(I i);

	int update(T t);

	String create(T t);

	String delete(I i);

	T findByName(String name);

}

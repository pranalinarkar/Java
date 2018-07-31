package com.pranali;

import java.util.List;

public interface DAO<T> {
	public void create(T object);
	public List<T> findAll();
public T findById(int i) ;
}

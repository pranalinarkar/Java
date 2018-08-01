package com.pranali;

interface CommandDAO<T> {
	public void save(T object);
	
public void update(T Object);
public void delete(T Object);
public T findById(long i);

}

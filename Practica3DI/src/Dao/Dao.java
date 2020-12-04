package Dao;

import java.util.*;

public interface Dao<E> {

    Optional<E> get(long id);

    List<E> getAll();

    void save(E e) throws Exception;

    void update(E e, String[] params);

    void delete(E e);
    
}

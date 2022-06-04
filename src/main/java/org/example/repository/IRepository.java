package org.example.repository;
import java.util.Collection;
import java.util.Comparator;

public interface IRepository<T>{
    void initialize();
    Collection<T> sort(Comparator<T> T);

}

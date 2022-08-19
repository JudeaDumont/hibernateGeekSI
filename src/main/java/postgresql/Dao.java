package postgresql;

import java.util.Collection;
import java.util.Optional;

//todo: research the dao design pattern and give a brief explanation of what is happening here
public interface Dao<T, I> {
    Optional<T> get(int id);
    Collection<T> getAll();
    Optional<I> save(T t);
    void update(T t);
    void delete(T t);
}
package persistance;


import java.util.List;

public interface CRUDRepository<ID, T> {
    void add(T elem) throws Exception;
    void delete(T elem);
    void update(T elem);
    T findById(ID id);
    List<T> findAll();
}

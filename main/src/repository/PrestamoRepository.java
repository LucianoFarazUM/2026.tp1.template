package repository;

import model.Prestamo;

import java.util.*;

public class PrestamoRepository implements Repository<Prestamo, Integer> {

    private Map<Integer, Prestamo> data = new HashMap<>();
    private int currentId = 0;

    @Override
    public void save(Prestamo prestamo) {
        data.put(currentId++, prestamo);
    }

    @Override
    public Optional<Prestamo> findById(Integer id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public List<Prestamo> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public void delete(Integer id) {
        data.remove(id);
    }
}
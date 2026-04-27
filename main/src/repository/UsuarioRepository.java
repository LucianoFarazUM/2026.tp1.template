package repository;

import model.Usuario;

import java.util.*;

public class UsuarioRepository implements Repository<Usuario, String> {

    private Map<String, Usuario> data = new HashMap<>();

    @Override
    public void save(Usuario usuario) {
        data.put(usuario.getId(), usuario);
    }

    @Override
    public Optional<Usuario> findById(String id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public List<Usuario> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public void delete(String id) {
        data.remove(id);
    }
}
package br.uff.ihs.ss.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public abstract class CrudRepositoryTest<T extends CrudRepository<E, Long>, E> {
    @Autowired
    T repository;

    @Test
    public void givenEntity_whenCount_thenSuccess() {
        assertEquals(3, repository.count());
    }

    @Test
    public void givenValidId_whenFindById_thenSuccess() {
        final Optional<E> s = repository.findById(1L);
        assertTrue(!s.isEmpty());
    }

    @Test
    public void givenValidId_whenDelete_thenSuccess() {
        final Optional<E> s = repository.findById(1L);
        repository.delete(s.get());
        final Optional<E> deleted = repository.findById(1L);
        assertTrue(deleted.isEmpty());
    }
}
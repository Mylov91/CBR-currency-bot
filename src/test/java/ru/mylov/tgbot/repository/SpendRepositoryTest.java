package ru.mylov.tgbot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.mylov.tgbot.entity.Spend;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SpendRepositoryTest {

    @Autowired
    private SpendRepository spendRepository;

    @Test
    void testRepo() {
        for (int i = 0; i < 10; i++, spendRepository.save(new Spend()));
        final List<Spend> found = spendRepository.findAll();
        // Ожидаемое +1, тк скрипт добавляет одну запись
        assertEquals(11, found.size());
    }

    @Test
    void testDataScripts() {
        Optional<Spend> spend = spendRepository.findById(1L);
        assertTrue(spend.isPresent());
        assertEquals(new BigDecimal("1000.00"), spend.get().getSpend());
    }
}
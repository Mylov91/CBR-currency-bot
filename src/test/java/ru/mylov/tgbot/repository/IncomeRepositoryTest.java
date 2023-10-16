package ru.mylov.tgbot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.mylov.tgbot.entity.Income;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IncomeRepositoryTest {

    @Autowired
    private IncomeRepository incomeRepository;

    @Test
    void testRepo() {
        for (int i = 0; i < 10; i++, incomeRepository.save(new Income()));
        final List<Income> found = incomeRepository.findAll();
        // Ожидаемое +1, тк скрипт добавляет одну запись
        assertEquals(11, found.size());
    }

    @Test
    void testDataScripts() {
        Optional<Income> income = incomeRepository.findById(1L);
        assertTrue(income.isPresent());
        assertEquals(new BigDecimal("3000.00"), income.get().getIncome());
    }
}
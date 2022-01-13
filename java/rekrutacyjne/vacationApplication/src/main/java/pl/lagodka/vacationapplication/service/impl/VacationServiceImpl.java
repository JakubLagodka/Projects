package pl.lagodka.vacationapplication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.lagodka.vacationapplication.model.dao.Vacation;
import pl.lagodka.vacationapplication.repository.VacationRepository;
import pl.lagodka.vacationapplication.service.VacationService;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class VacationServiceImpl implements VacationService {
    private final VacationRepository vacationRepository;

    @Override
    public Vacation getById(Long id) {
        return vacationRepository.getById(id);
    }

    @Override
    public Vacation create(Vacation vacation) {
        return vacationRepository.save(vacation);
    }

    @Override
    @Transactional
    public Vacation update(Vacation vacation, Long id) {
        Vacation vacationDb = getById(id);
        vacationDb.setType(vacation.getType());
        vacationDb.setNumber_of_days(vacation.getNumber_of_days());
        return vacationDb;
    }

    @Override
    public void delete(Long id) {
        vacationRepository.deleteById(id);
    }

    @Override
    public Page<Vacation> getPage(Pageable pageable) {
        return vacationRepository.findAll(pageable);
    }
}

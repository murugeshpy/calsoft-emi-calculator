package com.calsoft.emicalculator.repo;

import org.springframework.data.repository.CrudRepository;

import com.calsoft.emicalculator.model.Finance;

public interface FinanceRepo extends CrudRepository<Finance, Long> {


}

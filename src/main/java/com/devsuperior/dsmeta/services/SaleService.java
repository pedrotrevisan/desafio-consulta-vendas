package com.devsuperior.dsmeta.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SaleReportDTO> getReport(String minDate, String maxDate, String sellerName, Pageable pageable) {
		// Se não passar maxDate, usa hoje. Se não passar minDate, usa 12 meses atrás do maxDate
		LocalDate max = maxDate.equals("") ? LocalDate.now() : LocalDate.parse(maxDate);
		LocalDate min = minDate.equals("") ? max.minusMonths(12) : LocalDate.parse(minDate);
		return repository.searchReport(min, max, sellerName, pageable);
	}

	public List<SaleSummaryDTO> getSummary(String minDate, String maxDate) {
		// Se não passar maxDate, usa hoje. Se não passar minDate, usa 12 meses atrás do maxDate
		LocalDate max = maxDate.equals("") ? LocalDate.now() : LocalDate.parse(maxDate);
		LocalDate min = minDate.equals("") ? max.minusMonths(12) : LocalDate.parse(minDate);
		return repository.searchSummary(min, max);
	}
}

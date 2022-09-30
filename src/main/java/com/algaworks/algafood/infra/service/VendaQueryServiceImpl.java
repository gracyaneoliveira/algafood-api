package com.algaworks.algafood.infra.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.filter.VendaDiariaFilter;
import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.model.dto.VendaDiaria;
import com.algaworks.algafood.domain.service.VendaQueryService;

/**
 * select date(p.data_criacao) as data_criacao,
 * 		  count(p.id) as total_vendas,
 * 		  sum(p.valor_total) as total_faturado
 * 
 * from pedido p
 * 
 * group by date(p.data_criacao)
 * 
 *
 * @author gracy
 *
 */

@Repository
public class VendaQueryServiceImpl implements VendaQueryService {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<VendaDiaria> consultarVendasDiarias(VendaDiariaFilter filtro) {
		var builder = manager.getCriteriaBuilder();
		var query = builder.createQuery(VendaDiaria.class);
		var root  = query.from(Pedido.class);
		
		var functionDateDataCricao = builder.function("date", Date.class, root.get("dataCriacao"));
		
		var selection = builder.construct(VendaDiaria.class, 
				functionDateDataCricao, 
				builder.count(root.get("id")), 
				builder.sum(root.get("valorTotal")));
		
		query.select(selection);
		query.groupBy(functionDateDataCricao);
		
		return manager.createQuery(query).getResultList();
	}

}

package br.com.thesharks.hackathon.persist.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.thesharks.hackathon.persist.entity.Interesse;
import br.com.thesharks.hackathon.persist.entity.Usuario;
import br.com.thesharks.hackathon.persist.entity.enums.TipoInteresseEnum;

@Repository
public interface InteresseRepository extends EntidadeRepository<Interesse>{

	List<Interesse> findByUsuario(Usuario usuario);

	List<Interesse> findByTipoInteresseAndValorDoInteresseGreaterThanEqual(TipoInteresseEnum receber, BigDecimal valor);

	List<Interesse> findByTipoInteresseAndValorDoInteresseLessThanEqual(TipoInteresseEnum repasse, BigDecimal valor);

}

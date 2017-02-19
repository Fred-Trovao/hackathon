package br.com.thesharks.hackathon.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.thesharks.hackathon.exception.EntidadeNaoEncontradaException;
import br.com.thesharks.hackathon.persist.entity.EntidadeAbstrata;
import br.com.thesharks.hackathon.persist.repository.EntidadeRepository;

@Service
public abstract class GenericService<T extends EntidadeAbstrata> {

	@Autowired
	private EntidadeRepository<T> entidadeRepository;

	public EntidadeRepository<T> getRepository() {
		return entidadeRepository;
	}

	@Transactional
	public T salvarOuAtualizar(T entidade) throws EntidadeNaoEncontradaException {
		if (entidade.getId() == null) {
			return incluir(entidade);
		}

		return alterar(entidade);
	}

	@Transactional
	public T incluir(T entidade) {
		return getRepository().saveAndFlush(entidade);
	}

	@Transactional
	public T alterar(T entidade) throws EntidadeNaoEncontradaException {
		T saveAndFlush = null;
		if (isCadastrada(entidade)) {
			saveAndFlush = getRepository().saveAndFlush(entidade);
		} else {
			ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
			
			@SuppressWarnings("unchecked")
			Class<T> entidadeClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
			throw new EntidadeNaoEncontradaException(String.format("%s não encontrada.", entidadeClass.getName()));
		}

		return saveAndFlush;
	}

	@Transactional
	public void remover(T entidade) throws Exception {
		if (isCadastrada(entidade)) {

			getRepository().delete(entidade);
		} else {
			throw new Exception();
		}
	}

	@Transactional
	public void removerPorId(Long id) throws Exception {
		if (id != null) {
			T entity = (T) getRepository().findOne(id);
			getRepository().delete(entity);
		}

	}

	@Transactional(readOnly = true)
	public List<T> getAll() {
		return getRepository().findAll();
	}

	@Transactional(readOnly = true)
	public T findById(Long id) {
		return getRepository().findOne(id);
	}

	@Transactional(readOnly = true)
	public boolean existe(Long id) {
		return getRepository().exists(id);
	}

	@Transactional(readOnly = true)
	private boolean isCadastrada(T entidade) {

		if (entidade.getId() == null) {
			return false;
		}

		Serializable id = entidade.getId();
		boolean existe = getRepository().exists((Long) id);
		return existe;
	}

	@Transactional
	public void deleteAll() {
		for (T entidade : getAll()) {
			getRepository().delete(entidade);
		}
	}
}

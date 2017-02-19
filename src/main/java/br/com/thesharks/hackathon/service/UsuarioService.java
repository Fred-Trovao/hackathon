package br.com.thesharks.hackathon.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thesharks.hackathon.persist.entity.Usuario;
import br.com.thesharks.hackathon.persist.repository.UsuarioRepository;
import br.com.thesharks.hackathon.security.SecurityUtils;

@Service
public class UsuarioService extends GenericService<Usuario> {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario findByLogin(String currentLogin) {
		return usuarioRepository.findByLogin(currentLogin);
	}

	public Usuario getUsuarioCurrent() {

		Usuario usuario = usuarioRepository.findByLogin(SecurityUtils.getCurrentLogin());

		return usuario;
	}

	public String encriptarMD5(String senha) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(senha.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}

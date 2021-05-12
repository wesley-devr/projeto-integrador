package com.humanae.humanae.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.humanae.humanae.models.Parceiros;
import com.humanae.humanae.models.ParceirosLogin;
import com.humanae.humanae.repositories.ParceirosRepository;

@Service
public class ParceiroService {

	@Autowired
	private ParceirosRepository repository;
	
	public Optional<Parceiros> cadastrarParceiro (Parceiros parceiroNovo){
		Optional<Parceiros> parceiroExistente = repository.findByEmail(parceiroNovo.getEmail());
		if (parceiroExistente.isPresent()) {
			return Optional.empty();
		} else {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaCriptogra = encoder.encode(parceiroNovo.getSenha());
			parceiroNovo.setSenha(senhaCriptogra);
			return Optional.ofNullable(repository.save(parceiroNovo));

		}
	}
	
	public Optional<ParceirosLogin> logarParceiros(Optional<ParceirosLogin> parceiroLogin){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Parceiros> parceiro = repository.findByEmail(parceiroLogin.get().getEmail());
		
		if(parceiro.isPresent()) {
			if(encoder.matches(parceiroLogin.get().getSenha(), parceiro.get().getSenha())) {
				
				String auth = parceiroLogin.get().getEmail() + ":" + parceiroLogin.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodeAuth);
				
				parceiroLogin.get().setToken(authHeader);
				parceiroLogin.get().setNome(parceiro.get().getNome());
				
				return parceiroLogin;
			}
		}
		
		return null;
	}
}

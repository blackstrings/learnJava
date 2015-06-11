package com.xai.patterns.domain.service;

public abstract class RegistrationService implements DomainService {
	public abstract <K> boolean register(K k);
	public abstract <K> boolean unregister(K k);
}

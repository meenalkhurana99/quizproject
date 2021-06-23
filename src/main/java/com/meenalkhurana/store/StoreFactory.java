package com.meenalkhurana.store;

public class StoreFactory {

	private StoreFactory() {
		
	}
	
	public static IQuestionStore getQuestionStore() {
		IQuestionStore dataStore = new InMemoryStoreImpl();
		return dataStore;
	}
	
	public static IQuizStore getQuizStore() {
		IQuizStore dataStore = new InMemoryStoreImpl();
		return dataStore;
	}
}

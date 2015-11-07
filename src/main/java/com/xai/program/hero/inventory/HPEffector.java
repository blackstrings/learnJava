package com.xai.program.hero.inventory;

public class HPEffector implements IEffector {

	private int hp;
	
	public HPEffector(int hp){
		this.hp = hp;
	}
	
	public void inverseHp(){
		this.hp *= -1;
	}
	
	@Override
	public void applyEffect(Object target) {
		if(target instanceof IDamagable){
			IDamagable obj = (IDamagable) target;
			System.out.println(getClass().getSimpleName() + ": " + hp);
			obj.applyHP(hp);
		}
	}
	
	public String toString(){
		return getClass().getSimpleName();
	}

	
}

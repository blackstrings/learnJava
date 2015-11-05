package com.xai.program.hero.inventory;

public class Box extends Item implements IFixable {

	private boolean unlock = false;
	
	public Box(String name){
		super(name);
	}

	@Override
	public void applyTool(ToolItem toolItem) {
		if(toolItem.name.equals("treasureKey")){
			System.out.println("box unlocked");
			unlock = true;
		}else{
			System.out.println("box still locked");
		}
		
	}

	@Override
	public boolean useOn(Object targetUseOn) {
		if(unlock){
			if(targetUseOn instanceof User){
				User user = (User) targetUseOn;
				Item item = new ComsumptionItem("Drink", 1, 1);
				user.takeItem(item);
				System.out.println("item " + item.name + " taken from box");
				return true;
			}else{
				System.out.println("error target not a user that can take item");
			}
		}
		return false;
	}
	

}

package com.compsci.hunterseeker.screens;

import com.badlogic.gdx.math.Vector2;
import com.compsci.hunterseeker.ai.DumbController;
import com.compsci.hunterseeker.ai.GameData;
import com.compsci.hunterseeker.util.Globals;

public class ChaseDataScreen extends PlayScreen {

	@Override
	public void show() {
		super.show();
		
		data = new GameData("chase", true);
		h.setController(im);
		if (Globals.firstRun) {
			Globals.firstRun = false;
			p.setController(new DumbController());
		}else {
			p.setController(Globals.preyBc);
		}
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		data.addEntry(h, p);

		Vector2 o = Globals.getOffset(p, h, false);
		Globals.preyBc.setInputs(
				(float) (o.len() / Math.sqrt(Globals.APP_WIDTH
						* Globals.APP_WIDTH + Globals.APP_HEIGHT
						* Globals.APP_HEIGHT)), o.angle() / 360);
		
		if (System.currentTimeMillis() - startTime > Globals.chaseTime * 1000) {
			goToNext();
		}
	}
	
	public void goToNext(){
		TrainScreen.gameData = data;
		TrainScreen.nextScreen = "flee";
		TrainScreen.bc = Globals.hunterBc;
		data.save();
		Globals.game.showScreen("train");
	}
	
}

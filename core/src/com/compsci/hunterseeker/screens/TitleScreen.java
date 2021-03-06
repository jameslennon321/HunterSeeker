package com.compsci.hunterseeker.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.compsci.hunterseeker.items.Hunter;

public class TitleScreen extends AbstractScreen {
	
	Hunter h;
	
	@Override
	public void show() {
		super.show();
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		super.resize(width, height);
		
		stage.clear();
		
		
		Label l = new Label("Hunter Seeker", skin);
		l.setPosition(width/2 - l.getWidth()*2.f, height/2);
		l.setFontScale(5.0f);
		stage.addActor(l);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
	}

	@Override
	public void back() {

	}

}

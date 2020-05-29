package com.hil_low.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hil_low.game.Screens.*;

public class Hi_Low_Main extends Game {
    //Instance variables
    private MenuScreen menuScreen;
    private PlayScreen playScreen;

    //This method is the first thing that is called when the program is opened and does the initial setting up
    @Override
    public void create () {
        SpriteBatch batch = new SpriteBatch();
        AssetManager manager = new AssetManager();
        manager.finishLoading();

        menuScreen = new MenuScreen(this);
        playScreen = new PlayScreen(this);

        setScreen(menuScreen);
    }

    //renders the game
    @Override
    public void render () {
        super.render();
    }

    //properly disposes the game when it is over
    @Override
    public void dispose () {
        super.dispose();
    }
}

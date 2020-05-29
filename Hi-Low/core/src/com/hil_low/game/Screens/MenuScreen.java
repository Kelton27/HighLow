package com.hil_low.game.Screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuScreen extends ApplicationAdapter implements Screen {
    //Instance variables
    SpriteBatch batch;
    Stage stage;
    Viewport viewport;
    int correctCnt = 0;
    int wrongCnt = 0;
    Game game;

    //Constructor
    public MenuScreen(Game game){
        this.game = game;
        batch = new SpriteBatch();
        viewport = new FitViewport(800, 800, new OrthographicCamera());
        stage = new Stage(viewport, batch);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        Table table2 = new Table();
        table2.bottom();
        table2.setFillParent(true);

        Image backGround = new Image(new TextureRegion(new Texture(Gdx.files.internal("HIL.jpg"))));
        Image back = new Image(new TextureRegion(new Texture(Gdx.files.internal("HIL.jpg"))));
        Table background = new Table();
        background.add(backGround);

        Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        BitmapFont font2 = new BitmapFont();
        labelStyle.font = font2;
        labelStyle.fontColor = Color.WHITE;

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("button", Color.WHITE);
        textButtonStyle.down = skin.newDrawable("button-down", Color.WHITE);
        textButtonStyle.font = font2;

        Label label = new Label("click to begin",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table2.add(label);

        table.add(backGround);
        stage.addActor(back);
        stage.addActor(table);
        stage.addActor(label);
        stage.addActor(table2);
        stage.draw();
    }

    @Override
    public void show() {
    }

    //This method is called 60 times a second to match the screens refresh rate
    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched() || Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            game.setScreen(new PlayScreen(game));
        }
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void hide() {

    }

    //This method is called to properly dispose of the stage to optimize the game
    @Override
    public void dispose () {
        stage.dispose();
    }
}

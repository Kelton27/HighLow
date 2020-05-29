package com.hil_low.game.Screens;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class PlayScreen extends ApplicationAdapter implements Screen {

	//Instance variables
	private Stage stage;
	private int correctCnt = 0;
	private HashMap<String,Integer> cards;
	private TextureRegion card;
	private Image cardImage;
	private List keylist;
	private Table table2;

	//Constructor
	public PlayScreen(Game game){
		SpriteBatch batch = new SpriteBatch();
		Viewport viewport = new FitViewport(800, 800, new OrthographicCamera());
		stage = new Stage(viewport, batch);

		final Label numCorrect = new Label(String.format("%02d", correctCnt), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		int wrongCnt = 0;
		Label numWrong = new Label(String.format("%02d", wrongCnt), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		Label infoText = new Label("HELLO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

		//Creates a new hashmap of cards that contains the picture of the card and their value
		cards = new HashMap<>();
		cards.put("Clover/card_1_clover.png",1);
		cards.put("Clover/card_2_clover.png",2);
		cards.put("Clover/card_3_clover.png",3);
		cards.put("Clover/card_4_clover.png",4);
		cards.put("Clover/card_5_clover.png",5);
		cards.put("Clover/card_6_clover.png",6);
		cards.put("Clover/card_7_clover.png",7);
		cards.put("Clover/card_8_clover.png",8);
		cards.put("Clover/card_9_clover.png",9);
		cards.put("Clover/card_10_clover.png",10);
		cards.put("Clover/card_11_clover.png",11);
		cards.put("Clover/card_12_clover.png",12);
		cards.put("Clover/card_13_clover.png",13);
		cards.put("Diamond/card_1_diamond.png",1);
		cards.put("Diamond/card_2_diamond.png",2);
		cards.put("Diamond/card_3_diamond.png",3);
		cards.put("Diamond/card_4_diamond.png",4);
		cards.put("Diamond/card_5_diamond.png",5);
		cards.put("Diamond/card_6_diamond.png",6);
		cards.put("Diamond/card_7_diamond.png",7);
		cards.put("Diamond/card_8_diamond.png",8);
		cards.put("Diamond/card_9_diamond.png",9);
		cards.put("Diamond/card_10_diamond.png",10);
		cards.put("Diamond/card_11_diamond.png",11);
		cards.put("Diamond/card_12_diamond.png",12);
		cards.put("Diamond/card_13_diamond.png",13);
		cards.put("Heart/card_1_heart.png",1);
		cards.put("Heart/card_2_heart.png",2);
		cards.put("Heart/card_3_heart.png",3);
		cards.put("Heart/card_4_heart.png",4);
		cards.put("Heart/card_5_heart.png",5);
		cards.put("Heart/card_6_heart.png",6);
		cards.put("Heart/card_7_heart.png",7);
		cards.put("Heart/card_8_heart.png",8);
		cards.put("Heart/card_9_heart.png",9);
		cards.put("Heart/card_10_heart.png",10);
		cards.put("Heart/card_11_heart.png",11);
		cards.put("Heart/card_12_heart.png",12);
		cards.put("Heart/card_13_heart.png",13);
		cards.put("Spade/card_1_spade.png",1);
		cards.put("Spade/card_2_spade.png",2);
		cards.put("Spade/card_3_spade.png",3);
		cards.put("Spade/card_4_spade.png",4);
		cards.put("Spade/card_5_spade.png",5);
		cards.put("Spade/card_6_spade.png",6);
		cards.put("Spade/card_7_spade.png",7);
		cards.put("Spade/card_8_spade.png",8);
		cards.put("Spade/card_9_spade.png",9);
		cards.put("Spade/card_10_spade.png",10);
		cards.put("Spade/card_11_spade.png",11);
		cards.put("Spade/card_12_spade.png",12);
		cards.put("Spade/card_13_spade.png",13);
		keylist = new ArrayList(cards.keySet());
		Collections.shuffle(keylist);

		Table table = new Table();
		table.top();
		table.setFillParent(true);

		table2 = new Table();
		table2.setFillParent(true);

		Table table3 = new Table();
		table3.top();
		table3.setFillParent(true);

		Table table4 = new Table();
		table4.bottom();
		table4.setFillParent(true);

		TextureRegion backGround = new TextureRegion(new Texture(Gdx.files.internal("WalnutWood.jpg")));
		card = new TextureRegion(new Texture(Gdx.files.internal((String)keylist.get(0))));

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

		TextButton btn = new TextButton("Higher", textButtonStyle);
		btn.setPosition(650, 500);
		btn.addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent e, float x, float y, int point, int button) {
				super.touchDown(e, x, y, point, button);
				String currentCard = table2.getChild(0).getName();
				String nextCard = ranCard();
				Gdx.app.log("HigherButton", "pressed");
				if(isHigher(currentCard, nextCard))
					numCorrect.setText(String.format("%02d", correctCnt));

				table2.clear();
				correctCnt++;
				card = new TextureRegion(new Texture(Gdx.files.internal(nextCard)));
				cardImage = new Image(card);
				table2.add(cardImage).width(250).height(400).center();


				return false;
			}
		});

		TextButton btn2 = new TextButton("Lower", textButtonStyle);
		btn2.setPosition(650, 400);
		btn2.addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent e, float x, float y, int point, int button) {
				super.touchDown(e, x, y, point, button);
				Gdx.app.log("LowerButton", "pressed");
				ranCard();
				return false;
			}
		});

		Image backgroundImage = new Image(backGround);
		cardImage = new Image(card);
		table.add(backgroundImage).width(800).height(800);
		table3.add(numCorrect).top().padTop(20).expandX();
		table3.add(numWrong).top().padTop(20).expandX();
		table2.add(cardImage).width(250).height(400).center();
		table4.add(infoText).padBottom(20);
		stage.addActor(table);
		stage.addActor(table2);
		stage.addActor(btn);
		stage.addActor(btn2);
		stage.addActor(table3);

		stage.draw();
	}

	@Override
	public void show() {

	}

	//This method is called 60 times a second to match the screens refresh rate
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose () {
		stage.dispose();
	}

	//This method takes two cards and checks to see which one is higher and returns it
	private boolean isHigher(String c1, String c2) {
		return cards.get(c1) > cards.get(c2);
	}

	//This method draws and returns a random card from the hashmap
	private String ranCard(){
		Collections.shuffle(keylist);
		card = new TextureRegion(new Texture(Gdx.files.internal((String)keylist.get(0))));
		cardImage = new Image(card);
		table2.clear();
		table2.add(cardImage).width(250).height(400).center();
		stage.draw();
		return (String)keylist.get(0);
	}
}

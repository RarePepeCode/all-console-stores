package com.kucinas.allconsolestoreapi.model.entity.game;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Implementation of {@link IGameGraphData}
 * 
 * @author Ignas Kucinas
 *
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "game_graphs")
public class GameGraphData implements IGameGraphData {

	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	@Id
	private Long id;

	@Column
	private String priceData;

	@Column
	private String dateData;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "games_id")
	private Game game;

	/**
	 * Constructor
	 * 
	 * @param game the game for which graph data is being created
	 */
	public GameGraphData(Game game) {
		this.game = game;
		this.priceData = game.getPrice().toString() + ";";
		this.dateData = LocalDate.now().toString() + ";";
	}

	@Override
	public void appendGamesPriceData(String price) {
		this.priceData = priceData + price + ";";
		this.dateData = this.dateData + LocalDate.now().toString() + ";";

	}

}

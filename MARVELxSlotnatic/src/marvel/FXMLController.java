package marvel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FXMLController {
	
	private Stage meineStage;
	
	@FXML private ImageView banner= new ImageView(new Image("icons/banner.jpeg"));
	@FXML private Label slot1;
	@FXML private Label slot2;
	@FXML private Label slot3;
	@FXML private Label faktor;
	@FXML private Label attention;
	@FXML private ImageView icon1;
	@FXML private ImageView icon2;
	@FXML private ImageView icon3;
	@FXML private TextField gut;
	@FXML private TextField ein;
	@FXML private TextField gew;
	@FXML private Button go;
	@FXML private Button plus;
	@FXML private Button minus;
	
	private int einsatz=10;
	private double gewinnFaktor=1.5;
	private double guthaben=250;
	private static Image[] icons = {new Image("icons/1.png"),new Image("icons/2.png"), new Image("icons/3.png"), new Image("icons/4.jpg"),new Image("icons/5.jpg"),new Image("icons/6.jpg"), new Image("icons/7.jpg"), new Image("icons/8.jpg")};

	
	//Übergibt die Stage 
	public void setMeineStage(Stage meineStage) {
			this.meineStage = meineStage;
	}	
	
	//Startet den Banditen
	@FXML private void play(ActionEvent event) {
		if(guthaben>=einsatz ) {
		this.gut.setText(Double.toString(this.guthaben=guthaben-einsatz)+ "€");
		attention.setVisible(false);
		random();
		banner.setOpacity(0.3);
		}
		else {
			attention.setVisible(true);
			
		}
			
	}
	
	//Erhöht den Einsatz wie auch den Gewinnfaktor
	@FXML private void plus(ActionEvent event) {
		if(einsatz!=50) {
			this.ein.setText(Integer.toString(this.einsatz=einsatz+10)+ "€");
			gewinnFaktor=gewinnFaktor+0.5;
			faktor.setText("Faktor="+gewinnFaktor);
		}
		else 
			return;
	}
	//Reduziert den Einsatz wie auch den Gewinnfaktor
	@FXML private void minus(ActionEvent event) {
		if(einsatz!=10) {
			this.ein.setText(Integer.toString(this.einsatz=einsatz-10)+ "€");
			gewinnFaktor=gewinnFaktor-0.5;
			faktor.setText("Faktor="+gewinnFaktor);
		}
		else 
			return;
	}
	
		//Sorgt für zufällige Marvel Helden
		private void random() {
		icon1 = new ImageView(icons[(int) (Math.random() * icons.length)]);
		slot1.setGraphic(icon1);
		icon2 = new ImageView(icons[(int) (Math.random() * icons.length)]);
		slot2.setGraphic(icon2);
		icon3 = new ImageView(icons[(int) (Math.random() * icons.length)]);
		slot3.setGraphic(icon3);
		compare();
	}
		//Vergleicht die einzelnen Marvel Helden für Gewinnkalkulation
		private void compare() {
			String ic1 = icon1.getImage().toString();
			String ic2 = icon2.getImage().toString();
			String ic3 = icon3.getImage().toString();
			
		if (ic1.compareTo(ic2) == 0 && ic1.compareTo(ic3) == 0) {
			gut.setText(Double.toString(this.guthaben=this.guthaben+50*gewinnFaktor)+ "€");
			gew.setText(einsatz*gewinnFaktor+"€");
			return;
		}
		else if (ic1.compareTo(ic2) == 0 || ic2.compareTo(ic3) == 0 || ic1.compareTo(ic3) == 0) {
			gut.setText(Double.toString(this.guthaben=this.guthaben+20*gewinnFaktor)+ "€");
			gew.setText(einsatz*gewinnFaktor+"€");
		}
		else {
			gew.setText("0€");
		}
		liquide();
	}
	//Überprüft auf vorhandenes Guthaben
	//und beendet es wenn nicht liquide 
	private void liquide() {
		if(guthaben ==  0.0) {
			System.exit(0);
		}
		
	//Setzt die Bühne
	setMeineStage(meineStage);
	}
}

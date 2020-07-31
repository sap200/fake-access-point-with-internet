import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import java.util.Scanner;

public class FakeAccessPoint extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		Label label = new Label("Press the start button to start the fake-access point.\r\nPress Stop to access it");
		label.setAlignment(Pos.CENTER);
		
		TextArea textBox = new TextArea();
		textBox.setWrapText(true);
		textBox.setEditable(false);
		
		Button button = new Button("Start FAKE AP");
		button.setOnAction(e -> {
			String str = "[+] Output\n\n";
			if(button.getText().equals("Start FAKE AP")) {
				button.setText("Stop FAKE AP");
				try {
					Process p = Runtime.getRuntime().exec("bash start_fake_ap.sh");
					Scanner sc1 = new Scanner(p.getInputStream());
					Scanner sc2 = new Scanner(p.getErrorStream());
					
					while(sc1.hasNext()) {
						str += sc1.nextLine() + "\n";
						textBox.setText(str);
					}
					
					while(sc2.hasNext()) {
						str += sc2.nextLine() + "\n";
						textBox.setText(str);
					}
					
					
				} catch(Exception ex) {
					
				}
			} else if(button.getText().equals("Stop FAKE AP")) {
				button.setText("Start FAKE AP");
				
				try {
					Process p = Runtime.getRuntime().exec("bash stop_fap.sh");
					
					Scanner sc1 = new Scanner(p.getInputStream());
					Scanner sc2 = new Scanner(p.getErrorStream());
					
					while(sc1.hasNext()) {
						str += sc1.nextLine() + "\n";
						textBox.setText(str);
					}
					
					while(sc2.hasNext()) {
						str += sc2.nextLine() + "\n";
						textBox.setText(str);
					}
					
					textBox.appendText("\n[+] Done");
					
				} catch(Exception ex) {
					
					
				}
				
			}
		});
		
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(10, 10, 10, 10));
		borderPane.setTop(label);
		BorderPane.setMargin(textBox, new Insets(10, 0, 10, 0));
		borderPane.setCenter(textBox);
		borderPane.setBottom(button);
		BorderPane.setAlignment(textBox, Pos.CENTER);
		BorderPane.setAlignment(button, Pos.CENTER);
		
		textBox.prefWidthProperty().bind(borderPane.widthProperty().subtract(20));
		textBox.prefHeightProperty().bind(borderPane.heightProperty().subtract(100));
		
		Scene scene = new Scene(borderPane, 500, 300);
		primaryStage.setTitle("Fake Access Point");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	

	public static void main(String[] args) {
		Application.launch(args);

	}

}

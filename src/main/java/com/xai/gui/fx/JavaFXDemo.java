package com.xai.gui.fx;

/**
 * Quick back history
 * AWT was the first gui for java 1.0
 * Came along later was Swing for java.
 * Now JavaFX is the newer version of using gui for more modern app interface design
 * JavaFX can still incorporate swing elements
 * 
 * Java 7.6+ is required
 * Once you get javaFX installed,
 * the code below is an easy helloworld one class.
 * 
 * There are 2 ways to program javaFX, the simple way all in one class like below
 * or the complex way which is more for bigger apps and utilizes fxml files for layout
 * 
 * installing javaFX to ecipse 4.5+
 * https://www.eclipse.org/efxclipse/install.html
 * http://wiki.eclipse.org/Efxclipse/Tutorials/AddingE(fx)clipse_to_eclipse
 * 
 * here is the hierarchy for javaFX
 * Stage
 * 		Scene
 * 			RootPane/container/StackPane/GridPane/BorderPane/FlowPane/etc
 * 				buttons
 * 				text
 * 				etc
 * 
 * vs the older swing gui package
 * JFrame
 * 		JPanel
 * 			JButton
 * 
 * tutorial basic here
 * http://www.javafxtutorials.com/the-2-ways-to-write-javafx-programs/
 *
 */
public class JavaFXDemo  //extend Application
{
	/*
	@Override
	public void start(Stage myStage){
		Button btn = new Button("Click Me");
		
		//connect
		btn.setOnAction(e -> btn_click());
		
		//frame
		StackPane frame = new StackPane();
		
		//add btn to frame
		frame.getChildren().add(btn);
		
		//create scene for the frame
		Scene scene = new Scene(frame, 200,50);
		
		//put the scene on the stage and show it
		myStage.setScene(scene);
		myStage.setTitle("My Title");
		myStage.show();
		
	}
	
	public void btn_click(){
		System.out.println("I'm clicked");
		
	}
	
	public static void main(String[] args){
		launch(args);
	}
	*/
}

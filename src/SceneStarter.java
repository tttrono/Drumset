import javax.swing.*;

public class SceneStarter {

	public static void main(String[] args) {

		int w = 1281;
		int h = 658;
		SceneFrame sceneframe = new SceneFrame(w,h);
		sceneframe.setupButtonListeners();
		sceneframe.setUpGUI();
		
	}
}

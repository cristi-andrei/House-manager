import EcranPornire.AppInitializer;
import EcranPornire.OpeningUI;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //TasksView.GUI();


        String folderPath = "C:\\Users\\vladm\\OneDrive\\Desktop\\folder proiect"; // Specify your folder path here
        AppInitializer appInitializer = new AppInitializer(folderPath);
        appInitializer.launchUI();

    }
}

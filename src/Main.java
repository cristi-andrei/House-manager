import EcranPornire.AppInitializer;

public class Main {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\crist\\Documents\\GitHub\\House-manager"; // Specify your folder path here

        AppInitializer appInitializer = new AppInitializer(folderPath);
        appInitializer.launchUI();
    }
}
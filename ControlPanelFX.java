import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ControlPanel extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Создание панели (GridPane)
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        // Заголовок
        Label title = new Label("Контрольная Панель");
        title.setFont(new Font("Arial", 24));
        title.setTextFill(Color.DARKBLUE);
        grid.add(title, 0, 0, 2, 1);

        // Кнопка "Старт"
        Button startButton = new Button("Старт");
        startButton.setPrefWidth(100);
        grid.add(startButton, 0, 1);

        // Кнопка "Стоп"
        Button stopButton = new Button("Стоп");
        stopButton.setPrefWidth(100);
        grid.add(stopButton, 1, 1);

        // Индикатор загрузки
        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setProgress(0);
        grid.add(progressIndicator, 0, 2);

        // Поля для статусов
        Label statusLabel = new Label("Статус:");
        TextField statusField = new TextField("Оффлайн");
        statusField.setEditable(false);
        grid.add(statusLabel, 0, 3);
        grid.add(statusField, 1, 3);

        // Поля для других данных
        Label cpuLabel = new Label("CPU:");
        TextField cpuField = new TextField("0.00%");
        cpuField.setEditable(false);
        grid.add(cpuLabel, 0, 4);
        grid.add(cpuField, 1, 4);

        Label ramLabel = new Label("Память:");
        TextField ramField = new TextField("0 ГБ");
        ramField.setEditable(false);
        grid.add(ramLabel, 0, 5);
        grid.add(ramField, 1, 5);

        // Обработчики событий
        startButton.setOnAction(event -> {
            statusField.setText("Онлайн");
            progressIndicator.setProgress(0.5); // Пример обновления прогресса
        });

        stopButton.setOnAction(event -> {
            statusField.setText("Оффлайн");
            progressIndicator.setProgress(0);
        });

        // Создание сцены
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Панель управления");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

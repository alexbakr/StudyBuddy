package edu.bsu.cs222;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GUI extends Application{

    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private Text labelDailyHours;
    private Text labelFunction;
    private Text labelWeeklyHours;
    private Text labelTotalHours;
    private Text labelStudyHours;

    private Text sleepLabel;
    private Text foodLabel;
    private Text workLabel;
    private Text schoolLabel;
    private Text extraLabel;

    private int dailySleepHours;
    private int dailyFoodHours;
    private int workHours;
    private int schoolHours;
    private int extraHours;
    private int weeklyHours;
    private int studyHours;
    private int sleepHours;
    private int foodHours;

    private Button multiplySleep;
    private Button multiplyFood;
    private Button addButton;
    private Button computeButton;
    private Button resetButton;

    private TextField sleepGet;
    private TextField foodGet;
    private TextField sleepView;
    private TextField foodView;
    private TextField workGet;
    private TextField schoolGet;
    private TextField extraGet;
    private TextField totalHoursField;
    private TextField studyHoursField;


    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();

        root.getChildren().add(addVBox());

        Scene scene = new Scene(root, 1280, 900);

        primaryStage.setTitle("Study Buddy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public VBox addVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(0);

        vbox.getChildren().addAll(dailyAverageGrid(), weeklyAverageGrid(), ComputationsGrid(), ResetGrid());

        return vbox;
    }

    public GridPane dailyAverageGrid() { //four by three grid
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);

        //Horizontal Labels
        labelDailyHours = new Text("Number of Hours per Day");
        GridPane.setHalignment(labelDailyHours, HPos.CENTER);
        labelFunction = new Text("Click the button to \n" + "complete the calculations");
        GridPane.setHalignment(labelFunction, HPos.CENTER);
        labelWeeklyHours = new Text("Number of Hours per Week");
        GridPane.setHalignment(labelWeeklyHours, HPos.CENTER);

        //Vertical Labels
        sleepLabel = new Text("On average,\n" + "how many hours \n" + "per day do you sleep?");
        foodLabel = new Text("On average, how many hours per \n" + "day do you take to eat?");

        //Buttons
        multiplySleep = new Button("Multiply");
        multiplySleep.setOnAction(event -> sleepMultiplyButton());
        multiplyFood = new Button("Multiply");
        multiplyFood.setOnAction(event -> foodMultiplyButton());

        //TextFields
        sleepGet = new TextField("0");
        foodGet = new TextField("0");
        sleepView = new TextField("0");
        foodView = new TextField("0");

        grid.add(labelDailyHours,1 ,0);
        grid.add(labelFunction, 2, 0);
        grid.add(labelWeeklyHours, 3, 0);

        grid.add(sleepLabel, 0, 1);
        grid.add(sleepGet, 1, 1);
        grid.add(multiplySleep, 2, 1);
        grid.add(sleepView, 3, 1);
        GridPane.setHalignment(multiplySleep, HPos.CENTER);

        grid.add(foodLabel, 0, 2);
        grid.add(foodGet, 1, 2);
        grid.add(multiplyFood, 2, 2);
        grid.add(foodView, 3, 2);
        GridPane.setHalignment(multiplyFood, HPos.CENTER);

        grid.getColumnConstraints().add(new ColumnConstraints(180));
        grid.getColumnConstraints().add(new ColumnConstraints(180));
        grid.getColumnConstraints().add(new ColumnConstraints(180));
        grid.getColumnConstraints().add(new ColumnConstraints(200));

        grid.getRowConstraints().add(new RowConstraints(73));
        grid.getRowConstraints().add(new RowConstraints(73));
        grid.getRowConstraints().add(new RowConstraints(73));

        return grid;
    }

    public GridPane weeklyAverageGrid() { //two by three grid
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);

        //Labels
        workLabel = new Text("On average, how many hours per week do you spend at work?");
        schoolLabel = new Text("On average, how many hours per week do you spend in class?");
        extraLabel = new Text("On average, how many hours per week are you spending on extra-curricular activities \n" + "(Ex. clubs, hanging out with friends, working out, etc.");

        //TextFields
        workGet = new TextField("0");
        schoolGet = new TextField("0");
        extraGet = new TextField("0");

        grid.add(workLabel, 0, 0);
        grid.add(schoolLabel, 0, 1);
        grid.add(extraLabel, 0, 2);

        grid.add(workGet, 1, 0);
        grid.add(schoolGet, 1, 1);
        grid.add(extraGet, 1, 2);

        grid.getColumnConstraints().add(new ColumnConstraints(540));
        grid.getColumnConstraints().add(new ColumnConstraints(200));


        grid.getRowConstraints().add(new RowConstraints(73));
        grid.getRowConstraints().add(new RowConstraints(73));
        grid.getRowConstraints().add(new RowConstraints(73));



        return grid;
    }

    public GridPane ComputationsGrid() { //two by two grid
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);

        //Labels
        labelTotalHours = new Text("Click the Add button to compute the number of hours you are \n" + "spending each week with your daily living activities.");
        labelStudyHours = new Text("Click the Compute button to find out how many hours remain \n" + "for you to study.");

        //Buttons
        addButton = new Button("Add");
        addButton.setOnAction(event -> addButton());
        computeButton = new Button("Compute");
        computeButton.setOnAction(event -> computeButton());

        //TextFields
        totalHoursField = new TextField("0");
        studyHoursField = new TextField("0");

        grid.add(labelTotalHours, 0, 0);
        grid.add(addButton, 1, 0);
        grid.add(totalHoursField, 2, 0);
        GridPane.setHalignment(addButton, HPos.CENTER);

        grid.add(labelStudyHours, 0, 1);
        grid.add(computeButton, 1, 1);
        grid.add(studyHoursField, 2, 1);
        GridPane.setHalignment(computeButton, HPos.CENTER);

        grid.getColumnConstraints().add(new ColumnConstraints(360));
        grid.getColumnConstraints().add(new ColumnConstraints(180));
        grid.getColumnConstraints().add(new ColumnConstraints(200));

        grid.getRowConstraints().add(new RowConstraints(73));
        grid.getRowConstraints().add(new RowConstraints(73));

        return grid;
    }

    public GridPane ResetGrid() {
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);

        resetButton = new Button("Reset");
        resetButton.setOnAction(event -> resetButton());

        grid.add(resetButton, 0, 0);
        GridPane.setHalignment(resetButton, HPos.CENTER);

        grid.getColumnConstraints().add(new ColumnConstraints(740));

        grid.getRowConstraints().add(new RowConstraints(73));

        return grid;
    }

    public void sleepMultiplyButton() {
        executorService.execute(new sleepMultiply());
    }

    private class sleepMultiply implements Runnable {
        @Override
        public void run() {
            try{
                dailySleepHours = Integer.parseInt(sleepGet.getText());
                sleepHours = weekMultiplication(dailySleepHours);
                sleepView.setText(Integer.toString(sleepHours));
            } catch(Exception exception) {
                sleepView.setText("NaN");
            }
        }
    }

    public void foodMultiplyButton() {
        executorService.execute(new foodMultiply());
    }

    private class foodMultiply implements Runnable {
        @Override
        public void run() {
            try{
                dailyFoodHours = Integer.parseInt(foodGet.getText());
                foodHours = weekMultiplication(dailyFoodHours);
                foodView.setText(Integer.toString(foodHours));
            } catch(Exception exception) {
                foodView.setText("NaN");
            }
        }
    }

    public void addButton()  {
        executorService.execute(new addAll());
    }

    private class addAll implements Runnable {
        @Override
        public void run() {
            HourCalculation calculation = new HourCalculation();
            try {
                weeklyHours = 0;
                workHours = Integer.parseInt(workGet.getText());
                schoolHours = Integer.parseInt(schoolGet.getText());
                extraHours = Integer.parseInt(extraGet.getText());
                Revision rev = setWeeklyHours(sleepHours, workHours, foodHours, schoolHours, extraHours);
                weeklyHours = calculation.hourTotal(rev);

                totalHoursField.setText(Integer.toString(weeklyHours));
            } catch (Exception exception) {
                totalHoursField.setText("NaN");
            }
        }
    }

    public void computeButton() {
        executorService.execute(new computeTotal());
    }

    private class computeTotal implements Runnable {
        @Override
        public void run() {
            StudyCalculation study = new StudyCalculation();
            try {
                studyHours = study.StudyCalculation(weeklyHours);
                studyHoursField.setText(Integer.toString(studyHours));
            } catch (Exception exception) {
                studyHoursField.setText("NaN");
            }
        }
    }

    public void resetButton() {
        executorService.execute(new resetAll());
    }

    private class resetAll implements Runnable {
        @Override
        public void run() {
            reset();
        }
    }

    public int weekMultiplication(int activity) {
        activity = activity * 7;
        return activity;
    }

    public Revision setWeeklyHours(int sleep, int work, int food, int school, int extra) {
        Revision rev = Revision.create()
                .setSleep(sleep)
                .setWork(work)
                .setExtra(extra)
                .setFood(food)
                .setSchool(school)
                .build();
        return rev;
    }

    public void reset() {
        sleepGet.setText("0");
        foodGet.setText("0");
        sleepView.setText("0");
        foodView.setText("0");
        workGet.setText("0");
        schoolGet.setText("0");
        extraGet.setText("0");
        totalHoursField.setText("0");
        studyHoursField.setText("0");
    }
}
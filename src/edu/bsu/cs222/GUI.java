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
    private Text labelTotalHours;
    private Text labelOverallHours;
    private Text labelStudyHours;

    private Text sleep;
    private Text food;
    private Text work;
    private Text school;
    private Text extra;

    private int sleepHours;
    private int foodHours;
    private int workHours;
    private int schoolHours;
    private int extraHours;
    private int totalHours;
    private int studyHours;
    private int weeklySleepHours;
    private int weeklyFoodHours;

    private Button multiplySleep;
    private Button multiplyFood;
    private Button add;
    private Button compute;
    private Button reset;

    private TextField sleepText;
    private TextField foodText;
    private TextField weeklySleep;
    private TextField weeklyFood;
    private TextField workText;
    private TextField schoolText;
    private TextField extraText;
    private TextField overallHours;
    private TextField studyTimeHours;


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

        vbox.getChildren().addAll(dailyAverage(), weeklyAverage(), Computations(), Reset());

        return vbox;
    }

    public GridPane dailyAverage() { //four by three grid
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);

        //Horizontal Labels
        labelDailyHours = new Text("Number of Hours per Day");
        GridPane.setHalignment(labelDailyHours, HPos.CENTER);
        labelFunction = new Text("Click the button to \n" + "complete the calculations");
        GridPane.setHalignment(labelFunction, HPos.CENTER);
        labelTotalHours = new Text("Number of Hours per Week");
        GridPane.setHalignment(labelTotalHours, HPos.CENTER);

        //Vertical Labels
        sleep = new Text("On average, how many hours \n" + "per day do you sleep?");
        food = new Text("On average, how many hours per day do you take to eat?");

        //Buttons
        multiplySleep = new Button("Multiply");
        GridPane.setHalignment(multiplySleep, HPos.CENTER);
        multiplyFood = new Button("Multiply");
        GridPane.setHalignment(multiplyFood, HPos.CENTER);

        //TextFields
        sleepText = new TextField("0");
        foodText = new TextField("0");
        weeklySleep = new TextField("0");
        weeklyFood = new TextField("0");

        multiplySleep.setOnAction(event -> sleepMultiplyButton());
        multiplyFood.setOnAction(event -> foodMultiplyButton());

        grid.add(labelDailyHours,1 ,0);
        grid.add(labelFunction, 2, 0);
        grid.add(labelTotalHours, 3, 0);

        grid.add(sleep, 0, 1);
        grid.add(sleepText, 1, 1);
        grid.add(multiplySleep, 2, 1);
        grid.add(weeklySleep, 3, 1);

        grid.add(food, 0, 2);
        grid.add(foodText, 1, 2);
        grid.add(multiplyFood, 2, 2);
        grid.add(weeklyFood, 3, 2);

        grid.getColumnConstraints().add(new ColumnConstraints(180));
        grid.getColumnConstraints().add(new ColumnConstraints(180));
        grid.getColumnConstraints().add(new ColumnConstraints(180));
        grid.getColumnConstraints().add(new ColumnConstraints(200));


        grid.getRowConstraints().add(new RowConstraints(73));
        grid.getRowConstraints().add(new RowConstraints(73));
        grid.getRowConstraints().add(new RowConstraints(73));

        return grid;
    }

    public GridPane weeklyAverage() { //two by three grid
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);

        //Labels
        work = new Text("On average, how many hours per week do you spend at work?");
        school = new Text("On average, how many hours per week do you spend in class?");
        extra = new Text("On average, how many hours per week are you spending on extra-curricular activities \n" + "(Ex. clubs, hanging out with friends, working out, etc.");

        //TextFields
        workText = new TextField("0");
        schoolText = new TextField("0");
        extraText = new TextField("0");

        grid.add(work, 0, 0);
        grid.add(school, 0, 1);
        grid.add(extra, 0, 2);
        grid.add(workText, 1, 0);
        grid.add(schoolText, 1, 1);
        grid.add(extraText, 1, 2);

        grid.getColumnConstraints().add(new ColumnConstraints(540));
        grid.getColumnConstraints().add(new ColumnConstraints(200));


        grid.getRowConstraints().add(new RowConstraints(73));
        grid.getRowConstraints().add(new RowConstraints(73));
        grid.getRowConstraints().add(new RowConstraints(73));



        return grid;
    }

    public GridPane Computations() { //two by two grid
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);

        //Labels
        labelOverallHours = new Text("Click the Add button to compute the number of hours you are \n" + "spending each week with your daily living activities.");
        labelStudyHours = new Text("Click the Compute button to find out how many hours remain \n" + "for you to study.");

        //Buttons
        add = new Button("Add");
        GridPane.setHalignment(add, HPos.CENTER);
        compute = new Button("Compute");
        GridPane.setHalignment(compute, HPos.CENTER);

        //TextFields
        overallHours = new TextField("0");
        studyTimeHours = new TextField("0");

        add.setOnAction(event -> add());
        compute.setOnAction(event -> compute());

        grid.add(labelOverallHours, 0, 0);
        grid.add(labelStudyHours, 0, 1);
        grid.add(add, 1, 0);
        grid.add(compute, 1, 1);
        grid.add(overallHours, 2, 0);
        grid.add(studyTimeHours, 2, 1);

        grid.getColumnConstraints().add(new ColumnConstraints(360));
        grid.getColumnConstraints().add(new ColumnConstraints(180));
        grid.getColumnConstraints().add(new ColumnConstraints(200));


        grid.getRowConstraints().add(new RowConstraints(73));
        grid.getRowConstraints().add(new RowConstraints(73));

        return grid;
    }

    public GridPane Reset() { //one by one grid
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);

        reset = new Button("Reset");
        grid.getColumnConstraints().add(new ColumnConstraints(740));

        grid.getRowConstraints().add(new RowConstraints(73));
        GridPane.setHalignment(reset, HPos.CENTER);

        reset.setOnAction(event -> reset());

        grid.add(reset, 0, 0);


        return grid;
    }

    public void sleepMultiplyButton() {
        executorService.execute(new sleepMultiply());
    }

    private class sleepMultiply implements Runnable {
        @Override
        public void run() {
            try{
                sleepHours = Integer.parseInt(sleepText.getText());
                weeklySleepHours = sleepHours * 7;
                weeklySleep.setText(Integer.toString(weeklySleepHours));
            } catch(Exception exception) {
                weeklySleep.setText("NaN");
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
                foodHours = Integer.parseInt(foodText.getText());
                weeklyFoodHours = foodHours * 7;
                weeklyFood.setText(Integer.toString(weeklyFoodHours));
            } catch(Exception exception) {
                weeklyFood.setText("NaN");
            }
        }
    }

    public void add()  {
        executorService.execute(new addAll());
    }

    private class addAll implements Runnable {
        @Override
        public void run() {
            try {
                workHours = Integer.parseInt(workText.getText());
                schoolHours = Integer.parseInt(schoolText.getText());
                extraHours = Integer.parseInt(extraText.getText());

                HourCalculation calculation = new HourCalculation();
                Revision rev = Revision.create()
                        .setSleep(weeklySleepHours)
                        .setWork(workHours)
                        .setFood(weeklyFoodHours)
                        .setSchool(schoolHours)
                        .setExtra(extraHours)
                        .build();
                totalHours = calculation.hourTotal(rev);

                overallHours.setText(Integer.toString(totalHours));
            } catch (Exception exception) {
                overallHours.setText("NaN");
            }
        }
    }

    public void compute() {
        executorService.execute(new computeTotal());
    }

    private class computeTotal implements Runnable {
        @Override
        public void run() {
            StudyCalculation study = new StudyCalculation();
            try {
                studyHours = study.StudyCalculation(totalHours);
                studyTimeHours.setText(Integer.toString(studyHours));
            } catch (Exception exception) {
                studyTimeHours.setText("NaN");
            }
        }
    }

    public void reset() {
        executorService.execute(new resetAll());
    }

    private class resetAll implements Runnable {
        @Override
        public void run() {
            sleepText.setText("0");
            foodText.setText("0");
            weeklySleep.setText("0");
            weeklyFood.setText("0");
            workText.setText("0");
            schoolText.setText("0");
            extraText.setText("0");
            overallHours.setText("0");
            studyTimeHours.setText("0");
        }
    }

}
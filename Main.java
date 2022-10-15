package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    static boolean isPressedUp=false, isPressedRight=false, isPressedLeft=false, isPressedDown=false;
    static double vx=0, vy=0, velocity=0.5;

    @Override
    public void start(Stage primaryStage) throws Exception{

        AnchorPane root = new AnchorPane();

        Scene scene = new Scene(root, 600, 600);
        scene.setFill(Color.BEIGE);

        Rectangle rec = new Rectangle(50, 50);
        rec.setFill(Color.BLACK);
        rec.setX(300);
        rec.setY(300);
        root.getChildren().add(rec);

        Rectangle rec1 = new Rectangle(50, 50);
        rec1.setFill(Color.BLACK);
        rec1.setX(300-scene.getWidth());
        rec1.setY(300);
        root.getChildren().add(rec1);

        Rectangle rec2 = new Rectangle(50, 50);
        rec2.setFill(Color.BLACK);
        rec2.setX(300);
        rec2.setY(300+scene.getHeight());
        root.getChildren().add(rec2);

        Rectangle rec3 = new Rectangle(50, 50);
        rec3.setFill(Color.BLACK);
        rec3.setX(300-scene.getWidth());
        rec3.setY(300+scene.getHeight());
        root.getChildren().add(rec3);

        scene.setOnKeyPressed(event -> {
            if(event.getCode()== KeyCode.UP)
            {
                isPressedUp=true;
            }
            if(event.getCode()== KeyCode.RIGHT)
            {
                isPressedRight=true;
            }
            if(event.getCode()== KeyCode.LEFT)
            {
                isPressedLeft=true;
            }
            if(event.getCode()== KeyCode.DOWN)
            {
                isPressedDown=true;
            }
        });

        scene.setOnKeyReleased(event -> {
            if(event.getCode()== KeyCode.UP)
            {
                isPressedUp=false;
            }
            if(event.getCode()== KeyCode.RIGHT)
            {
                isPressedRight=false;
            }
            if(event.getCode()== KeyCode.LEFT)
            {
                isPressedLeft=false;
            }
            if(event.getCode()== KeyCode.DOWN)
            {
                isPressedDown=false;
            }
        });

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {
            if(isPressedUp)
            {
                vy-=velocity;
            }
            if(isPressedDown)
            {
                vy+=velocity;
            }
            if(isPressedLeft)
            {
                vx-=velocity;
            }
            if(isPressedRight)
            {
                vx+=velocity;
            }

            rec.setY(rec.getY()+vy);
            rec.setX(rec.getX()+vx);
            rec1.setY(rec1.getY()+vy);
            rec1.setX(rec1.getX()+vx);
            rec2.setY(rec2.getY()+vy);
            rec2.setX(rec2.getX()+vx);
            rec3.setY(rec3.getY()+vy);
            rec3.setX(rec3.getX()+vx);
            vx*=0.95;
            vy*=0.95;

            if(rec.getX()>1.75*scene.getWidth())
            {
                rec.setX(rec1.getX()-scene.getWidth());
            }
            if(rec.getX()<-0.75* scene.getWidth())
            {
                rec.setX(rec1.getX()+scene.getWidth());
            }
            if(rec.getY()>1.75*scene.getHeight())
            {
                rec.setY(rec2.getY()-scene.getHeight());
            }
            if(rec.getY()<-0.75*scene.getHeight())
            {
                rec.setY(rec2.getY()+scene.getHeight());
            }

            if(rec1.getX()>1.75*scene.getWidth())
            {
                rec1.setX(rec.getX()-scene.getWidth());
            }
            if(rec1.getX()<-0.75* scene.getWidth())
            {
                rec1.setX(rec.getX()+scene.getWidth());
            }
            if(rec1.getY()>1.75*scene.getHeight())
            {
                rec1.setY(rec2.getY()-scene.getHeight());
            }
            if(rec1.getY()<-0.75*scene.getHeight())
            {
                rec1.setY(rec2.getY()+scene.getHeight());
            }

            if(rec2.getX()>1.75*scene.getWidth())
            {
                rec2.setX(rec1.getX()-scene.getWidth());
            }
            if(rec2.getX()<-0.75* scene.getWidth())
            {
                rec2.setX(rec1.getX()+scene.getWidth());
            }
            if(rec2.getY()>1.75*scene.getHeight())
            {
                rec2.setY(rec.getY()-scene.getHeight());
            }
            if(rec2.getY()<-0.75*scene.getHeight())
            {
                rec2.setY(rec.getY()+scene.getHeight());
            }

            if(rec3.getX()>1.75*scene.getWidth())
            {
                rec3.setX(rec.getX()-scene.getWidth());
            }
            if(rec3.getX()<-0.75* scene.getWidth())
            {
                rec3.setX(rec.getX()+scene.getWidth());
            }
            if(rec3.getY()>1.75*scene.getHeight())
            {
                rec3.setY(rec.getY()-scene.getHeight());
            }
            if(rec3.getY()<-0.75*scene.getHeight())
            {
                rec3.setY(rec.getY()+scene.getHeight());
            }
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("smooth movement");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

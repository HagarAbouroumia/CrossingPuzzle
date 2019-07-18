package game6.MVC;

import game6.Model.Controller;
import game6.Farmer;
import game6.Herbivorous;
import game6.ICrosser;
import game6.MVC.GameLevelOne;
import game6.MVC.InstructionsGUI;
import game6.MVC.Congrats;
import game6.Model.StrategyTwo;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class GameLevelTwo {

    Scene scene;
    Stage stage;
    InstructionsGUI instructionsGUI;
    List<ICrosser> crossers = new ArrayList<>();
    List<ICrosser> intialCrossers;
    String[] instructions;
    Controller controller;
    Farmer farmerOne;
    Farmer farmerTwo;
    Farmer farmerThree;
    Farmer farmerFour;
    Herbivorous goat;
    Congrats congrats;
   

    StrategyTwo strategyTwo;
    GameLevelTwo gameLevelTwo;
    boolean isOnLeft = true;
    Label movesNo = new Label();
    Label comment = new Label();
    Label f1 = new Label();
    Label f2 = new Label();
    Label f3 = new Label();
    Label f4 = new Label();
    Label f5 = new Label();
    Label noThing = new Label(" ");

    int counterrF; // one
    int counterrF2;
    int counterrA; // two
    int counterrA2;
    int counterrG; // three
    int counterrG2;
    int counterrL;
    int counterrL2;
    int counterrN;
    int counterrN2;

    Label moves = new Label("Moves ");
    Button restGame = new Button("Reset Game");
    Button instruction = new Button("Show Instructions");
    Button exitButton = new Button("Exit");
    Button Solve = new Button("Solve");

    public void setCongrats(Congrats congrats) {
        this.congrats = congrats;
    }

    public void setCounterrN(int counterrN) {
        this.counterrN = counterrN;
    }

    public void setCounterrN2(int counterrN2) {
        this.counterrN2 = counterrN2;
    }

    public void setIntialCrossers(List<ICrosser> intialCrossers) {
        this.intialCrossers = intialCrossers;
    }

    public void setIsOnLeft(boolean isOnLeft) {
        this.isOnLeft = isOnLeft;
    }

    public void setFarmerOne(Farmer farmerOne) {
        this.farmerOne = farmerOne;
    }

    public void setFarmerTwo(Farmer farmerTwo) {
        this.farmerTwo = farmerTwo;
    }

    public void setFarmerThree(Farmer farmerThree) {
        this.farmerThree = farmerThree;
    }

    public void setFarmerFour(Farmer farmerFour) {
        this.farmerFour = farmerFour;
    }

    public void setGoat(Herbivorous goat) {
        this.goat = goat;
    }

    public void setInstructionsGUI(InstructionsGUI instructionsGUI) {
        this.instructionsGUI = instructionsGUI;
    }

    public void setCrossers(List<ICrosser> crossers) {
        this.crossers = crossers;
    }

    public List<ICrosser> getCrossers() {
        return crossers;
    }

    public void setStrategyTwo(StrategyTwo strategyTwo) {
        this.strategyTwo = strategyTwo;
    }

    public void setGameLevelTwo(GameLevelTwo gameLevelTwo) {
        this.gameLevelTwo = gameLevelTwo;
    }

    public void prepareScene() throws IOException {
        exitButton.setOnAction(e -> Platform.exit());
        setCounterrA(0);
        setCounterrF(0);
        setCounterrG(0);
        setCounterrL(0);
        setCounterrN(0);
        setCounterrA2(0);
        setCounterrF2(0);
        setCounterrG2(0);
        setCounterrL2(0);
        setCounterrN2(0);
        comment = strategyTwo.getOne();
        f1 = strategyTwo.getF1();
        f2 = strategyTwo.getF2();
        f3 = strategyTwo.getF3();
        f4 = strategyTwo.getF4();
        f5 = strategyTwo.getF5();

        Pane pane = new Pane();

        BufferedImage boat = ImageIO.read(new File("boat.jpg"));
        //   intialCrossers = controller.getInitialCrossersEx();
        intialCrossers = controller.getInitialCrossersEx();
        //controllerr.setCommand(initialCrossersCommand);

        Image farmerimage1 = SwingFXUtils.toFXImage(intialCrossers.get(0).getImages()[0], null);
        Image farmerimage2 = SwingFXUtils.toFXImage(intialCrossers.get(1).getImages()[0], null);
        Image farmerimage3 = SwingFXUtils.toFXImage(intialCrossers.get(2).getImages()[0], null);
        Image farmerimage4 = SwingFXUtils.toFXImage(intialCrossers.get(3).getImages()[0], null);
        Image goatImage = SwingFXUtils.toFXImage(intialCrossers.get(4).getImages()[0], null);
        Image boatimage = SwingFXUtils.toFXImage(boat, null);

        ImageView farmerview = new ImageView(farmerimage1);
        farmerOne.setImage(farmerview);
        ImageView farmerview2 = new ImageView(farmerimage2);
        farmerTwo.setImage(farmerview2);
        ImageView farmerview3 = new ImageView(farmerimage3);
        farmerThree.setImage(farmerview3);
        ImageView farmerview4 = new ImageView(farmerimage4);
        farmerFour.setImage(farmerview4);
        ImageView goatview = new ImageView(goatImage);
        goat.setImage(goatview);
        ImageView boatview = new ImageView(boatimage);

        farmerview.setX(1000);
        farmerview.setY(500); //500
        farmerview2.setX(1000);
        farmerview2.setY(400); //500
        farmerview3.setX(1000);
        farmerview3.setY(300); //500
        farmerview4.setX(1000);
        farmerview4.setY(200); //500
        goatview.setX(1000);
        goatview.setY(100); //500
        boatview.setX(700);
        boatview.setY(400); //500

        boatview.setOnMouseClicked((MouseEvent e) -> {
            if (crossers.size() != 0) {
                if (isOnLeft == true) {

                    if (controller.canMove(crossers, isOnLeft) == true) {

                        comment.setText(" ");
                        movesNo.setText(String.valueOf(controller.getNumberofSails()));
                        setCounterrA(0);
                        setCounterrF(0);
                        setCounterrG(0);
                        setCounterrL(0);
                        setCounterrN(0);
                        if (crossers.size() == 1) {

                            System.out.println("ffff");
                            System.out.println(crossers.get(0).getWeight());
                            if (crossers.get(0) == farmerOne) {
                                f1.setLayoutX(140);
                                f1.setLayoutY(550);
                                crossers.get(0).getImageView().setX(50);
                                crossers.get(0).getImageView().setY(500);
                                boatview.setX(200);
                            }

                            if (crossers.get(0) == farmerTwo) {
                                f2.setLayoutX(140);
                                f2.setLayoutY(450);

                                crossers.get(0).getImageView().setX(50);
                                crossers.get(0).getImageView().setY(400);
                                boatview.setX(200);
                            }

                            if (crossers.get(0) == farmerThree) {
                                f3.setLayoutX(140);
                                f3.setLayoutY(350);

                                crossers.get(0).getImageView().setX(50);
                                crossers.get(0).getImageView().setY(300);
                                boatview.setX(200);
                            }

                            if (crossers.get(0) == farmerFour) {
                                f4.setLayoutX(140);
                                f4.setLayoutY(250);

                                crossers.get(0).getImageView().setX(50);
                                crossers.get(0).getImageView().setY(200);
                                boatview.setX(200);
                            }
                        } else if (crossers.size() == 2) {
                            if (crossers.get(0) == farmerOne) {
                                f1.setLayoutX(140);
                                f1.setLayoutY(550);

                                crossers.get(0).getImageView().setX(50);
                                crossers.get(0).getImageView().setY(500);
                                boatview.setX(200);
                            }
                            if (crossers.get(1) == farmerOne) {
                                f1.setLayoutX(140);
                                f1.setLayoutY(550);

                                crossers.get(1).getImageView().setX(50);
                                crossers.get(1).getImageView().setY(500);
                                boatview.setX(200);
                            }
                            if (crossers.get(0) == farmerTwo) {
                                f2.setLayoutX(140);
                                f2.setLayoutY(450);

                                crossers.get(0).getImageView().setX(50);
                                crossers.get(0).getImageView().setY(400);
                                boatview.setX(200);
                            }
                            if (crossers.get(1) == farmerTwo) {
                                f2.setLayoutX(140);
                                f2.setLayoutY(450);

                                crossers.get(1).getImageView().setX(50);
                                crossers.get(1).getImageView().setY(400);
                                boatview.setX(200);
                            }
                            if (crossers.get(0) == farmerThree) {
                                f3.setLayoutX(140);
                                f3.setLayoutY(350);

                                crossers.get(0).getImageView().setX(50);
                                crossers.get(0).getImageView().setY(300);
                                boatview.setX(200);
                            }
                            if (crossers.get(1) == farmerThree) {
                                f3.setLayoutX(140);
                                f3.setLayoutY(350);

                                crossers.get(1).getImageView().setX(50);
                                crossers.get(1).getImageView().setY(300);
                                boatview.setX(200);
                            }
                            if (crossers.get(1) == farmerFour) {
                                f4.setLayoutX(140);
                                f4.setLayoutY(250);

                                crossers.get(1).getImageView().setX(50);
                                crossers.get(1).getImageView().setY(200);
                                boatview.setX(200);
                            }
                            if (crossers.get(0) == farmerFour) {
                                f4.setLayoutX(140);
                                f4.setLayoutY(250);
                                crossers.get(0).getImageView().setX(50);
                                crossers.get(0).getImageView().setY(200);
                                boatview.setX(200);
                            }
                            if (crossers.get(1) == goat) {
                                f5.setLayoutX(140);
                                f5.setLayoutY(150);

                                crossers.get(1).getImageView().setX(50);
                                crossers.get(1).getImageView().setY(100);
                                boatview.setX(200);
                            }
                            if (crossers.get(0) == goat) {
                                f5.setLayoutX(140);
                                f5.setLayoutY(150);

                                crossers.get(0).getImageView().setX(50);
                                crossers.get(0).getImageView().setY(100);
                                boatview.setX(200);
                            }
                        }
                        crossers.clear();
                        setIsOnLeft(false);
                    } else {
                        System.out.println("invalid move");
                    }

                } else if (isOnLeft == false) {

                    if (controller.canMove(crossers, isOnLeft) == true) {
                        comment.setText(" ");
                        movesNo.setText(String.valueOf(controller.getNumberofSails()));
                        setCounterrA2(0);
                        setCounterrF2(0);
                        setCounterrG2(0);
                        setCounterrL2(0);
                        setCounterrN2(0);
                        if (crossers.size() == 1) {

                            if (crossers.get(0) == farmerOne) {
                                f1.setLayoutX(950);
                                f1.setLayoutY(550);

                                crossers.get(0).getImageView().setX(1000);
                                crossers.get(0).getImageView().setY(500);
                                boatview.setX(700);
                            }

                            if (crossers.get(0) == farmerTwo) {

                                f2.setLayoutX(950);
                                f2.setLayoutY(450);

                                crossers.get(0).getImageView().setX(1000);
                                crossers.get(0).getImageView().setY(400);
                                boatview.setX(700);
                            }

                            if (crossers.get(0) == farmerThree) {

                                f3.setLayoutX(950);
                                f3.setLayoutY(350);

                                crossers.get(0).getImageView().setX(1000);
                                crossers.get(0).getImageView().setY(300);
                                boatview.setX(700);
                            }

                            if (crossers.get(0) == farmerFour) {

                                f4.setLayoutX(950);
                                f4.setLayoutY(250);

                                crossers.get(0).getImageView().setX(1000);
                                crossers.get(0).getImageView().setY(200);
                                boatview.setX(700);
                            }
                        } else if (crossers.size() == 2) {

                            if (crossers.get(0) == farmerOne) {
                                f1.setLayoutX(950);
                                f1.setLayoutY(550);

                                crossers.get(0).getImageView().setX(1000);
                                crossers.get(0).getImageView().setY(500);
                                boatview.setX(700);
                            }
                            if (crossers.get(1) == farmerOne) {
                                f1.setLayoutX(950);
                                f1.setLayoutY(550);

                                crossers.get(1).getImageView().setX(1000);
                                crossers.get(1).getImageView().setY(500);
                                boatview.setX(700);
                            }
                            if (crossers.get(0) == farmerTwo) {

                                f2.setLayoutX(950);
                                f2.setLayoutY(450);

                                crossers.get(0).getImageView().setX(1000);
                                crossers.get(0).getImageView().setY(400);
                                boatview.setX(700);
                            }
                            if (crossers.get(1) == farmerTwo) {

                                f2.setLayoutX(950);
                                f2.setLayoutY(450);

                                crossers.get(1).getImageView().setX(1000);
                                crossers.get(1).getImageView().setY(400);
                                boatview.setX(700);
                            }
                            if (crossers.get(0) == farmerThree) {

                                f3.setLayoutX(950);
                                f3.setLayoutY(350);

                                crossers.get(0).getImageView().setX(1000);
                                crossers.get(0).getImageView().setY(300);
                                boatview.setX(700);
                            }
                            if (crossers.get(1) == farmerThree) {

                                f3.setLayoutX(950);
                                f3.setLayoutY(350);

                                crossers.get(1).getImageView().setX(1000);
                                crossers.get(1).getImageView().setY(300);
                                boatview.setX(700);
                            }
                            if (crossers.get(1) == farmerFour) {

                                f4.setLayoutX(950);
                                f4.setLayoutY(250);

                                crossers.get(1).getImageView().setX(1000);
                                crossers.get(1).getImageView().setY(200);
                                boatview.setX(700);
                            }
                            if (crossers.get(0) == farmerFour) {

                                f4.setLayoutX(950);
                                f4.setLayoutY(250);

                                crossers.get(0).getImageView().setX(1000);
                                crossers.get(0).getImageView().setY(200);
                                boatview.setX(700);
                            }
                            if (crossers.get(1) == goat) {

                                f5.setLayoutX(950);
                                f5.setLayoutY(150);
                                crossers.get(1).getImageView().setX(1000);
                                crossers.get(1).getImageView().setY(100);
                                boatview.setX(700);
                            }
                            if (crossers.get(0) == goat) {

                                f5.setLayoutX(950);
                                f5.setLayoutY(150);

                                crossers.get(0).getImageView().setX(1000);
                                crossers.get(0).getImageView().setY(100);
                                boatview.setX(700);
                            }
                        }
                        crossers.clear();
                        setIsOnLeft(true);
                    } else {
                        System.out.println("invalid move");
                    }
                }
            } else {
                comment.setText("No one on boat");
            }
            System.out.println(controller.getCongratss());
            if (controller.getCongratss() == 1) {
                congrats.prepareScene();
                stage.setScene(congrats.getScene());
            }
        }
        );

        farmerview.setOnMouseClicked(
                new EventHandler<Event>() {
            @Override
            public void handle(Event event
            ) {
                if (isOnLeft == true) {

                    if (counterrF == 1) {
                        comment.setText(" ");
                        crossers.remove(farmerOne);
                        farmerview.setX(1000);
                        farmerview.setY(500); //500
                        setCounterrF(0);
                        System.out.println("On the boat and i want to remove it ");
                        System.out.println(crossers.size());
                    } else {
                        crossers.add(farmerOne);
                        if (controller.canMoveToBoat(crossers, farmerOne, isOnLeft) == true) {
                            comment.setText(" ");

                            farmerview.setX(boatview.getX() + 60);
                            farmerview.setY(boatview.getY() - 100);
                            System.out.println("On the boat ");
                            System.out.println(crossers.size());
                            setCounterrF(1);

                        } else {
                            crossers.remove(farmerOne);
                            comment.setText("Invalid move of Crosser");

                        }
                    }
                } else if (isOnLeft == false) {

                    if (counterrF2 == 1) {
                        comment.setText(" ");
                        crossers.remove(farmerOne);
                        farmerview.setX(50);
                        farmerview.setY(500); //500
                        setCounterrF2(0);
                        System.out.println("On the boat and i want to remove it ");
                        System.out.println(crossers.size());
                    } else {
                        crossers.add(farmerOne);
                        if (controller.canMoveToBoat(crossers, farmerOne, isOnLeft) == true) {
                            comment.setText(" ");
                            farmerview.setX(boatview.getX() + 60);
                            farmerview.setY(boatview.getY() - 100);
                            System.out.println("to the boat");
                            System.out.println(crossers.size());
                            setCounterrF2(1);
                        } else {
                            crossers.remove(farmerOne);
                            comment.setText("Invalid move of Crosser");

                        }

                    }

                }

            }
        }
        );
        farmerview2.setOnMouseClicked(
                new EventHandler<Event>() {
            @Override
            public void handle(Event event
            ) {
                if (isOnLeft == true) {
                    if (counterrA == 1) {
                        comment.setText(" ");
                        crossers.remove(farmerTwo);
                        farmerview2.setX(1000);
                        farmerview2.setY(400); //500
                        setCounterrA(0);
                        System.out.println("On the boat and i want to remove it ");
                        System.out.println(crossers.size());
                    } else {
                        crossers.add(farmerTwo);
                        if (controller.canMoveToBoat(crossers, farmerTwo, isOnLeft) == true) {
                            comment.setText(" ");

                            farmerview2.setX(boatview.getX() + 60);
                            farmerview2.setY(boatview.getY() - 200);
                            System.out.println("On the boat ");
                            System.out.println(crossers.size());
                            setCounterrA(1);

                        } else {
                            crossers.remove(farmerTwo);
                            comment.setText("Invalid move of Crosser");

                        }
                    }
                } else if (isOnLeft == false) {

                    if (counterrA2 == 1) {
                        comment.setText(" ");
                        crossers.remove(farmerTwo);
                        farmerview2.setX(50);
                        farmerview2.setY(400); //500
                        setCounterrA2(0);
                        System.out.println("On the boat and i want to remove it ");
                        System.out.println(crossers.size());
                    } else {
                        crossers.add(farmerTwo);
                        if (controller.canMoveToBoat(crossers, farmerTwo, isOnLeft) == true) {
                            comment.setText(" ");
                            farmerview2.setX(boatview.getX() + 60);
                            farmerview2.setY(boatview.getY() - 200);
                            System.out.println("to the boat");
                            System.out.println(crossers.size());
                            setCounterrA2(1);
                        } else {
                            crossers.remove(farmerTwo);
                            comment.setText("Invalid move of Crosser");

                        }

                    }

                }

            }
        }
        );
        farmerview3.setOnMouseClicked(
                new EventHandler<Event>() {
            @Override
            public void handle(Event event
            ) {
                if (isOnLeft == true) {
                    if (counterrG == 1) {
                        comment.setText(" ");
                        crossers.remove(farmerThree);
                        farmerview3.setX(1000);
                        farmerview3.setY(300); //500
                        setCounterrG(0);
                        System.out.println("On the boat and i want to remove it ");
                        System.out.println(crossers.size());
                    } else {
                        crossers.add(farmerThree);
                        if (controller.canMoveToBoat(crossers, farmerThree, isOnLeft) == true) {
                            comment.setText(" ");

                            farmerview3.setX(boatview.getX() + 120);
                            farmerview3.setY(boatview.getY() - 100);
                            System.out.println("On the boat ");
                            System.out.println(crossers.size());
                            setCounterrG(1);

                        } else {
                            crossers.remove(farmerThree);
                            comment.setText("Invalid move of Crosser");

                        }
                    }
                } else if (isOnLeft == false) {

                    if (counterrG2 == 1) {
                        comment.setText(" ");
                        crossers.remove(farmerThree);
                        farmerview3.setX(50);
                        farmerview3.setY(300); //500
                        setCounterrG2(0);
                        System.out.println("On the boat and i want to remove it ");
                        System.out.println(crossers.size());
                    } else {
                        crossers.add(farmerThree);
                        if (controller.canMoveToBoat(crossers, farmerThree, isOnLeft) == true) {
                            comment.setText(" ");
                            farmerview3.setX(boatview.getX() + 120);
                            farmerview3.setY(boatview.getY() - 100);
                            System.out.println("to the boat");
                            System.out.println(crossers.size());
                            setCounterrG2(1);
                        } else {
                            crossers.remove(farmerThree);
                            comment.setText("Invalid move of Crosser");

                        }

                    }

                }

            }
        }
        );
        farmerview4.setOnMouseClicked(
                new EventHandler<Event>() {
            @Override
            public void handle(Event event
            ) {
                if (isOnLeft == true) {
                    if (counterrL == 1) {
                        comment.setText(" ");
                        crossers.remove(farmerFour);
                        farmerview4.setX(1000);
                        farmerview4.setY(200); //500
                        setCounterrL(0);
                        System.out.println("On the boat and i want to remove it ");
                        System.out.println(crossers.size());
                    } else {
                        crossers.add(farmerFour);
                        if (controller.canMoveToBoat(crossers, farmerFour, isOnLeft) == true) {
                            comment.setText(" ");

                            farmerview4.setX(boatview.getX() + 180);
                            farmerview4.setY(boatview.getY() - 100);
                            System.out.println("On the boat ");
                            System.out.println(crossers.size());
                            setCounterrL(1);

                        } else {
                            crossers.remove(farmerFour);
                            comment.setText("Invalid move of Crosser");

                        }
                    }
                } else if (isOnLeft == false) {

                    if (counterrL2 == 1) {
                        comment.setText(" ");
                        crossers.remove(farmerFour);
                        farmerview4.setX(50);
                        farmerview4.setY(200); //500
                        setCounterrL2(0);
                        System.out.println("On the boat and i want to remove it ");
                        System.out.println(crossers.size());
                    } else {
                        crossers.add(farmerFour);
                        if (controller.canMoveToBoat(crossers, farmerFour, isOnLeft) == true) {
                            comment.setText(" ");
                            farmerview4.setX(boatview.getX() + 180);
                            farmerview4.setY(boatview.getY() - 100);
                            System.out.println("to the boat");
                            System.out.println(crossers.size());
                            setCounterrL2(1);
                        } else {
                            crossers.remove(farmerFour);
                            comment.setText("Invalid move of Crosser");

                        }

                    }

                }

            }
        }
        );
        goatview.setOnMouseClicked(
                new EventHandler<Event>() {
            @Override
            public void handle(Event event
            ) {
                if (isOnLeft == true) {
                    if (counterrN == 1) {
                        comment.setText(" ");
                        crossers.remove(goat);
                        goatview.setX(1000);
                        goatview.setY(100); //500
                        setCounterrN(0);
                        System.out.println("On the boat and i want to remove it ");
                        System.out.println(crossers.size());
                    } else {
                        crossers.add(goat);
                        if (controller.canMoveToBoat(crossers, goat, isOnLeft) == true) {
                            comment.setText(" ");

                            goatview.setX(boatview.getX() + 240);
                            goatview.setY(boatview.getY() - 100);
                            System.out.println("On the boat ");
                            System.out.println(crossers.size());
                            setCounterrN(1);

                        } else {
                            crossers.remove(goat);
                            comment.setText("Invalid move of Crosser");

                        }
                    }
                } else if (isOnLeft == false) {

                    if (counterrN2 == 1) {
                        comment.setText(" ");
                        crossers.remove(goat);
                        goatview.setX(50);
                        goatview.setY(100); //500
                        setCounterrN2(0);
                        System.out.println("On the boat and i want to remove it ");
                        System.out.println(crossers.size());
                    } else {
                        crossers.add(goat);
                        if (controller.canMoveToBoat(crossers, goat, isOnLeft) == true) {
                            comment.setText(" ");
                            goatview.setX(boatview.getX() + 240);
                            goatview.setY(boatview.getY() - 100);
                            System.out.println("to the boat");
                            System.out.println(crossers.size());
                            setCounterrN2(1);
                        } else {
                            crossers.remove(goat);
                            comment.setText("Invalid move of Crosser");

                        }

                    }

                }

            }
        }
        );

        restGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                comment.setText(" ");
                movesNo.setText(" ");
                controller.resetGame();
                try {
                    prepareScene();
                } catch (IOException ex) {
                    Logger.getLogger(GameLevelOne.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(gameLevelTwo.getScene());
                controller.resetGame();
                crossers.clear();
                setIsOnLeft(true);

            }
        }
        );
        instruction.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                stage.setScene(instructionsGUI.getScene());
            }
        }
        );


        instruction.setLayoutX(50);
        instruction.setLayoutY(0);
        restGame.setLayoutX(200);
        restGame.setLayoutY(0);
        moves.setLayoutX(300);
        moves.setLayoutY(0);
        movesNo.setLayoutX(350);
        movesNo.setLayoutY(0);
        comment.setLayoutX(400);
        comment.setLayoutY(0);
        exitButton.setLayoutX(500);
        exitButton.setLayoutY(0);
        Solve.setLayoutX(550);
        Solve.setLayoutY(0);
        f1.setLayoutX(950);
        f1.setLayoutY(550);
        f2.setLayoutX(950);
        f2.setLayoutY(450);
        f3.setLayoutX(950);
        f3.setLayoutY(350);
        f4.setLayoutX(950);
        f4.setLayoutY(250);
        f5.setLayoutX(950);
        f5.setLayoutY(150);

        pane.getChildren().addAll(farmerview, farmerview2, farmerview3, farmerview4, goatview, boatview, restGame, instruction, moves, movesNo, comment, exitButton, f1, f2, f3, f4, f5, Solve);
        scene = new Scene(pane, 1100, 600);

    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setCounterrF(int counterrF) {
        this.counterrF = counterrF;
    }

    public void setCounterrA(int counterrA) {
        this.counterrA = counterrA;
    }

    public void setCounterrG(int counterrG) {
        this.counterrG = counterrG;
    }

    public void setCounterrL(int counterrL) {
        this.counterrL = counterrL;
    }

    public void setCounterrF2(int counterrF2) {
        this.counterrF2 = counterrF2;
    }

    public void setCounterrA2(int counterrA2) {
        this.counterrA2 = counterrA2;
    }

    public void setCounterrG2(int counterrG2) {
        this.counterrG2 = counterrG2;
    }

    public void setCounterrL2(int counterrL2) {
        this.counterrL2 = counterrL2;
    }

}

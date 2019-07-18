package game6.MVC;

import game6.MVC.InstructionsGUI;
import game6.MVC.Congrats;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import game6.Model.Caretaker;
import game6.Carnivorous;
import game6.Model.Controller;
import game6.Farmer;
import game6.Herbivorous;
import game6.ICrosser;
import game6.Model.Originator;
import game6.Plant;
import game6.Model.StrategyOne;
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

public class GameLevelOne {

    Scene scene;
    Stage stage;
    InstructionsGUI instructionsGUI;
    List<ICrosser> crossers = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    List<Boolean> tempP = new ArrayList<>();
    List<ICrosser> intialCrossers;
    String[] instructions;
    Controller controller;
    Farmer farmerOne;
    Herbivorous goat;
    Carnivorous lion;
    Plant apple;
    StrategyOne strategyOne;
    GameLevelOne gameLevelOne;
    boolean isOnLeft = true;
    Label movesNo = new Label();
    Label comment = new Label();
    int counterrF;
    int counterrF2;
    int counterrA;
    int counterrA2;
    int counterrG;
    int counterrG2;
    int counterrL;
    int counterrL2;
    Label moves = new Label("Moves ");
    Button restGame = new Button("Reset Game");
    Button instruction = new Button("Show Instructions");
    Button exitButton = new Button("Exit");
    Button Undo = new Button("Undo");
    Congrats congrats;
    Originator originator;
    Caretaker caretaker;
    int size = -1, size2 = 0;
    int numberofSails;

    public void setOriginator(Originator originator) {
        this.originator = originator;
    }

    public void setCaretaker(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    public void setCongrats(Congrats congrats) {
        this.congrats = congrats;
    }

    public void setGameLevelOne(GameLevelOne gameLevelOne) {
        this.gameLevelOne = gameLevelOne;
    }

    public void setIsOnLeft(boolean isOnLeft) {
        this.isOnLeft = isOnLeft;
    }

    public void setFarmerOne(Farmer farmerOne) {
        this.farmerOne = farmerOne;
    }

    public void setGoat(Herbivorous goat) {
        this.goat = goat;
    }

    public void setLion(Carnivorous lion) {
        this.lion = lion;
    }

    public void setApple(Plant apple) {
        this.apple = apple;
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

    public void setStrategyOne(StrategyOne strategyOne) {
        this.strategyOne = strategyOne;
    }

    public void prepareScene() throws IOException {

        exitButton.setOnAction(e -> Platform.exit());
        setCounterrA(0);
        setCounterrF(0);
        setCounterrG(0);
        setCounterrL(0);
        setCounterrA2(0);
        setCounterrF2(0);
        setCounterrG2(0);
        setCounterrL2(0);
        comment = strategyOne.getOne();
        Pane pane = new Pane();

        BufferedImage boat = ImageIO.read(new File("boat.jpg"));
        intialCrossers = controller.getInitialCrossersEx();
        Image goatimage = SwingFXUtils.toFXImage(intialCrossers.get(1).getImages()[0], null);
        Image farmerimage = SwingFXUtils.toFXImage(intialCrossers.get(0).getImages()[0], null);
        Image lionimage = SwingFXUtils.toFXImage(intialCrossers.get(2).getImages()[0], null);
        Image appleimage = SwingFXUtils.toFXImage(intialCrossers.get(3).getImages()[0], null);
        Image boatimage = SwingFXUtils.toFXImage(boat, null);

        ImageView farmerview = new ImageView(farmerimage);
        farmerOne.setImage(farmerview);
        ImageView goatview = new ImageView(goatimage);
        goat.setImage(goatview);
        ImageView lionview = new ImageView(lionimage);
        lion.setImage(lionview);
        ImageView appleview = new ImageView(appleimage);
        apple.setImage(appleview);
        ImageView boatview = new ImageView(boatimage);

        farmerview.setX(1000);
        farmerview.setY(500); //500
        goatview.setX(1000);
        goatview.setY(400); //500
        lionview.setX(1000);
        lionview.setY(200); //500
        appleview.setX(1000);
        appleview.setY(100); //500
        boatview.setX(700);
        boatview.setY(400); //500

        boatview.setOnMouseClicked((MouseEvent e) -> {

            if (crossers.size() != 0) {
                int i = 0;
                if (isOnLeft == true) {
                    if (controller.canMove(crossers, isOnLeft) == true) {
                        comment.setText(" ");
                        movesNo.setText(String.valueOf(controller.getNumberofSails()));
                        setCounterrA(0);
                        setCounterrF(0);
                        setCounterrG(0);
                        setCounterrL(0);
                        if (crossers.size() == 1) {
                            tempP.add(false);
                            list.add(1);
                            originator.setState(farmerOne);
                            caretaker.addMemento(originator.save());

                            crossers.get(0).getImageView().setX(50);
                            crossers.get(0).getImageView().setY(500);
                            boatview.setX(200);
                        } else if (crossers.size() == 2) {
                            tempP.add(false);
                            list.add(2);
                            originator.setState(crossers.get(0));
                            caretaker.addMemento(originator.save());
                            originator.setState(crossers.get(1));
                            caretaker.addMemento(originator.save());
                            if (crossers.get(0) == farmerOne) {
                                crossers.get(0).getImageView().setX(50);
                                crossers.get(0).getImageView().setY(500);
                                boatview.setX(200);
                            }
                            if (crossers.get(1) == farmerOne) {
                                crossers.get(1).getImageView().setX(50);
                                crossers.get(1).getImageView().setY(500);
                                boatview.setX(200);
                            }
                            if (crossers.get(0) == goat) {
                                crossers.get(0).getImageView().setX(50);
                                crossers.get(0).getImageView().setY(400);
                                boatview.setX(200);
                            }
                            if (crossers.get(1) == goat) {
                                crossers.get(1).getImageView().setX(50);
                                crossers.get(1).getImageView().setY(400);
                                boatview.setX(200);
                            }
                            if (crossers.get(0) == apple) {
                                crossers.get(0).getImageView().setX(50);
                                crossers.get(0).getImageView().setY(100);
                                boatview.setX(200);
                            }
                            if (crossers.get(1) == apple) {
                                crossers.get(1).getImageView().setX(50);
                                crossers.get(1).getImageView().setY(100);
                                boatview.setX(200);
                            }
                            if (crossers.get(1) == lion) {
                                crossers.get(1).getImageView().setX(50);
                                crossers.get(1).getImageView().setY(200);
                                boatview.setX(200);
                            }
                            if (crossers.get(0) == lion) {
                                crossers.get(0).getImageView().setX(50);
                                crossers.get(0).getImageView().setY(200);
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
                        if (crossers.size() == 1) {
                            tempP.add(true);
                            list.add(1);
                            originator.setState(crossers.get(0));
                            caretaker.addMemento(originator.save());

                            crossers.get(0).getImageView().setX(1000);
                            crossers.get(0).getImageView().setY(500);
                            boatview.setX(700);
                        } else if (crossers.size() == 2) {
                            tempP.add(true);
                            list.add(2);
                            originator.setState(crossers.get(0));
                            caretaker.addMemento(originator.save());
                            originator.setState(crossers.get(1));
                            caretaker.addMemento(originator.save());

                            if (crossers.get(0) == farmerOne) {
                                crossers.get(0).getImageView().setX(1000);
                                crossers.get(0).getImageView().setY(500);
                                boatview.setX(700);
                            }
                            if (crossers.get(1) == farmerOne) {
                                crossers.get(1).getImageView().setX(1000);
                                crossers.get(1).getImageView().setY(500);
                                boatview.setX(700);
                            }
                            if (crossers.get(0) == goat) {
                                crossers.get(0).getImageView().setX(1000);
                                crossers.get(0).getImageView().setY(400);
                                boatview.setX(700);
                            }
                            if (crossers.get(1) == goat) {
                                crossers.get(1).getImageView().setX(1000);
                                crossers.get(1).getImageView().setY(400);
                                boatview.setX(700);
                            }
                            if (crossers.get(0) == apple) {
                                crossers.get(0).getImageView().setX(1000);
                                crossers.get(0).getImageView().setY(100);
                                boatview.setX(700);
                            }
                            if (crossers.get(1) == apple) {
                                crossers.get(1).getImageView().setX(1000);
                                crossers.get(1).getImageView().setY(100);
                                boatview.setX(700);
                            }
                            if (crossers.get(1) == lion) {
                                crossers.get(1).getImageView().setX(1000);
                                crossers.get(1).getImageView().setY(200);
                                boatview.setX(700);
                            }
                            if (crossers.get(0) == lion) {
                                crossers.get(0).getImageView().setX(1000);
                                crossers.get(0).getImageView().setY(200);
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
            if (controller.getCongratss() == 1) {
                congrats.prepareScene();
                stage.setScene(congrats.getScene());
            }
            size = (list.size() - 1);
            size2 = caretaker.getSize();
            numberofSails = controller.getNumberofSails();

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

        lionview.setOnMouseClicked((Event event) -> {
            if (isOnLeft == true) {

                if (counterrL == 1) {
                    comment.setText(" ");
                    crossers.remove(lion);
                    lionview.setX(1000);
                    lionview.setY(200); //500
                    setCounterrL(0);
                    System.out.println("On the boat and i want to remove it ");
                    System.out.println(crossers.size());
                } else {
                    crossers.add(lion);
                    if (controller.canMoveToBoat(crossers, lion, isOnLeft) == true) {
                        comment.setText(" ");
                        lionview.setX(boatview.getX() + 60);
                        lionview.setY(boatview.getY() - 300);
                        System.out.println("to the boat ");
                        System.out.println(crossers.size());
                        setCounterrL(1);
                    } else {
                        crossers.remove(lion);
                        comment.setText("Invalid move of Crosser");

                    }

                }
                // setCrossers(crossers);
            } else if (isOnLeft == false) {

                if (counterrL2 == 1) {
                    comment.setText(" ");
                    crossers.remove(lion);

                    lionview.setX(50);
                    lionview.setY(200); //500
                    setCounterrL2(0);
                    System.out.println("On the boat and i want to remove it ");
                    System.out.println(crossers.size());
                } else {
                    crossers.add(lion);
                    if (controller.canMoveToBoat(crossers, lion, isOnLeft) == true) {
                        comment.setText(" ");
                        lionview.setX(boatview.getX() + 60);
                        lionview.setY(boatview.getY() - 300);
                        System.out.println("to the boat ");
                        System.out.println(crossers.size());
                        setCounterrL2(1);
                    } else {
                        crossers.remove(lion);
                        comment.setText("Invalid move of Crosser");

                    }

                }
            }
        });
        appleview.setOnMouseClicked(
                new EventHandler<Event>() {
            @Override
            public void handle(Event event
            ) {
                if (isOnLeft == true) {

                    if (counterrA == 1) {
                        comment.setText(" ");
                        crossers.remove(apple);

                        appleview.setX(1000);
                        appleview.setY(100); //500
                        setCounterrA(0);
                        System.out.println("On the boat and i want to remove it ");
                        System.out.println(crossers.size());
                    } else {
                        crossers.add(apple);
                        if (controller.canMoveToBoat(crossers, apple, isOnLeft) == true) {
                            comment.setText(" ");
                            appleview.setX(boatview.getX() + 60);
                            appleview.setY(boatview.getY() - 300);
                            System.out.println("to the boat ");
                            System.out.println(crossers.size());
                            setCounterrA(1);
                        } else {
                            crossers.remove(apple);
                            comment.setText("Invalid move of Crosser");

                        }

                    }
                    // setCrossers(crossers);
                } else if (isOnLeft == false) {

                    if (counterrA2 == 1) {
                        comment.setText(" ");
                        crossers.remove(apple);

                        appleview.setX(50);
                        appleview.setY(100); //500
                        setCounterrA2(0);
                        System.out.println("On the boat and i want to remove it ");
                        System.out.println(crossers.size());
                    } else {
                        crossers.add(apple);
                        if (controller.canMoveToBoat(crossers, apple, isOnLeft) == true) {
                            comment.setText(" ");
                            appleview.setX(boatview.getX() + 60);
                            appleview.setY(boatview.getY() - 300);
                            System.out.println("to the boat ");
                            System.out.println(crossers.size());
                            setCounterrA2(1);
                        } else {
                            crossers.remove(apple);
                            comment.setText("Invalid move of Crosser");

                        }

                    }
                    // setCrossers(crossers);
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
                    if (counterrG == 1) {
                        comment.setText(" ");
                        crossers.remove(goat);
                        goatview.setX(1000);
                        goatview.setY(400); //500
                        setCounterrG(0);
                        System.out.println("On the boat and i want to remove it ");
                        System.out.println(crossers.size());
                    } else {
                        crossers.add(goat);
                        if (controller.canMoveToBoat(crossers, goat, isOnLeft) == true) { // from initial to final position
                            comment.setText(" ");
                            goatview.setX(boatview.getX() + 60);
                            goatview.setY(boatview.getY() - 300);
                            System.out.println("On the boat  ");
                            System.out.println(crossers.size());
                            setCounterrG(1);
                        } else {
                            crossers.remove(goat);
                            comment.setText("Invalid move of Crosser");

                        }

                    }
                    // setCrossers(crossers);
                } else if (isOnLeft == false) {

                    if (counterrG2 == 1) {
                        comment.setText(" ");
                        crossers.remove(goat);
                        goatview.setX(50);
                        goatview.setY(400); //500
                        setCounterrG2(0);
                        System.out.println("On the boat and i want to remove it ");
                        System.out.println(crossers.size());
                    } else {
                        crossers.add(goat);
                        if (controller.canMoveToBoat(crossers, goat, isOnLeft) == true) { // from initial to final position
                            comment.setText(" ");
                            goatview.setX(boatview.getX() + 90);
                            goatview.setY(boatview.getY() - 300);
                            System.out.println("On the boat  ");
                            System.out.println(crossers.size());
                            setCounterrG2(1);
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
                stage.setScene(gameLevelOne.getScene());
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
        Undo.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                if (size >= 0) {
                    crossers.clear();
                    controller.setNumberofSails(--numberofSails);

                    if (tempP.get(size) == true) {

                        setCounterrA(0);
                        setCounterrF(0);
                        setCounterrG(0);
                        setCounterrL(0);

                        comment.setText(" ");
                        movesNo.setText(String.valueOf(controller.getNumberofSails()));
                        if (list.get(size) == 1) {
                            crossers.add(farmerOne);
                            if (controller.canMove(crossers, true) == true) {
                                System.out.println("correct ");
                            } else {
                                System.out.println("wong");
                            }
                            originator.restore(caretaker.get(size2));
                            farmerOne.getImageView().setX(50);
                            farmerOne.getImageView().setY(500);
                            boatview.setX(200);
                            crossers.clear();
                            size2--;
                        } else {
                            originator.restore(caretaker.get(size2));
                            if (originator.getIcrossers().getEatingRank() == 4) {
                                originator.restore(caretaker.get(size2 - 1));
                                if (originator.getIcrossers().getEatingRank() == 1) {
                                    farmerOne.getImageView().setX(50);
                                    farmerOne.getImageView().setY(500);
                                    apple.getImageView().setX(50);
                                    apple.getImageView().setY(100);
                                    farmerOne.getImageView().setX(50);
                                    farmerOne.getImageView().setY(500);
                                    boatview.setX(200);
                                    crossers.add(apple);
                                    crossers.add(farmerOne);
                                    if (controller.canMove(crossers, true) == true) {
                                        System.out.println("correct ");
                                    } else {
                                        System.out.println("wong");
                                    }
                                    crossers.clear();
                                    size2 = size2 - 2;
                                }

                                if (originator.getIcrossers().getEatingRank() == 2) {
                                    farmerOne.getImageView().setX(50);
                                    farmerOne.getImageView().setY(500);
                                    goat.getImageView().setX(50);
                                    goat.getImageView().setY(400);
                                    farmerOne.getImageView().setX(50);
                                    farmerOne.getImageView().setY(500);
                                    boatview.setX(200);
                                    size2 = size2 - 2;
                                    crossers.add(goat);
                                    crossers.add(farmerOne);
                                    if (controller.canMove(crossers, true) == true) {
                                        System.out.println("correct ");
                                    } else {
                                        System.out.println("wong");
                                    }
                                    crossers.clear();
                                }

                                if (originator.getIcrossers().getEatingRank() == 3) {
                                    farmerOne.getImageView().setX(50);
                                    farmerOne.getImageView().setY(500);
                                    lion.getImageView().setX(50);
                                    lion.getImageView().setY(200);
                                    farmerOne.getImageView().setX(50);
                                    farmerOne.getImageView().setY(500);
                                    boatview.setX(200);
                                    size2 = size2 - 2;
                                    crossers.add(lion);
                                    crossers.add(farmerOne);
                                    if (controller.canMove(crossers, true) == true) {
                                        System.out.println("correct ");
                                    } else {
                                        System.out.println("wong");
                                    }
                                    crossers.clear();
                                }

                            } else if (originator.getIcrossers().getEatingRank() != 4) {
                                if (originator.getIcrossers().getEatingRank() == 1) {

                                    apple.getImageView().setX(50);
                                    apple.getImageView().setY(100);
                                    farmerOne.getImageView().setX(50);
                                    farmerOne.getImageView().setY(500);
                                    boatview.setX(200);
                                    size2 = size2 - 2;
                                    crossers.add(apple);
                                    crossers.add(farmerOne);
                                    if (controller.canMove(crossers, true) == true) {
                                        System.out.println("correct ");
                                    } else {
                                        System.out.println("wong");
                                    }
                                    crossers.clear();
                                } else if (originator.getIcrossers().getEatingRank() == 2) {

                                    goat.getImageView().setX(50);
                                    goat.getImageView().setY(400);
                                    farmerOne.getImageView().setX(50);
                                    farmerOne.getImageView().setY(500);
                                    boatview.setX(200);
                                    size2 = size2 - 2;
                                    crossers.add(goat);
                                    crossers.add(farmerOne);
                                    if (controller.canMove(crossers, true) == true) {
                                        System.out.println("correct ");
                                    } else {
                                        System.out.println("wong");
                                    }
                                    crossers.clear();
                                } else if (originator.getIcrossers().getEatingRank() == 3) {

                                    lion.getImageView().setX(50);
                                    lion.getImageView().setY(200);
                                    farmerOne.getImageView().setX(50);
                                    farmerOne.getImageView().setY(500);
                                    boatview.setX(200);
                                    size2 = size2 - 2;
                                    crossers.add(lion);
                                    crossers.add(farmerOne);
                                    if (controller.canMove(crossers, true) == true) {
                                        System.out.println("correct ");
                                    } else {
                                        System.out.println("wong");
                                    }
                                    crossers.clear();
                                    originator.restore(caretaker.get(size2 - 1));
                                }

                            }

                        }
                        setIsOnLeft(false);

                    } else if (tempP.get(size) == false) {

                        setCounterrA2(0);
                        setCounterrF2(0);
                        setCounterrG2(0);
                        setCounterrL2(0);

                        comment.setText(" ");
                        movesNo.setText(String.valueOf(controller.getNumberofSails()));
                        if (list.get(size) == 1) {
                            originator.restore(caretaker.get(size2));
                            farmerOne.getImageView().setX(1000);
                            farmerOne.getImageView().setY(500);

                            boatview.setX(700);
                            size2--;
                            crossers.add(farmerOne);
                            if (controller.canMove(crossers, false) == true) {
                                System.out.println("correct ");
                            } else {
                                System.out.println("wong");
                            }
                            crossers.clear();

                        } else {
                            originator.restore(caretaker.get(size2));
                            if (originator.getIcrossers().getEatingRank() == 4) {
                                originator.restore(caretaker.get(size2 - 1));
                                if (originator.getIcrossers().getEatingRank() == 1) {
                                    farmerOne.getImageView().setX(1000);
                                    farmerOne.getImageView().setY(500);
                                    apple.getImageView().setX(1000);
                                    apple.getImageView().setY(100);
                                    farmerOne.getImageView().setX(1000);
                                    farmerOne.getImageView().setY(500);
                                    boatview.setX(700);
                                    size2 = size2 - 2;
                                    crossers.add(apple);
                                    crossers.add(farmerOne);
                                    if (controller.canMove(crossers, false) == true) {
                                        System.out.println("correct ");
                                    } else {
                                        System.out.println("wong");
                                    }
                                    crossers.clear();
                                } else if (originator.getIcrossers().getEatingRank() == 2) {
                                    farmerOne.getImageView().setX(1000);
                                    farmerOne.getImageView().setY(500);
                                    goat.getImageView().setX(1000);
                                    goat.getImageView().setY(400);
                                    farmerOne.getImageView().setX(1000);
                                    farmerOne.getImageView().setY(500);
                                    boatview.setX(700);
                                    size2 = size2 - 2;
                                    crossers.add(goat);
                                    crossers.add(farmerOne);
                                    if (controller.canMove(crossers, false) == true) {
                                        System.out.println("correct ");
                                    } else {
                                        System.out.println("wong");
                                    }
                                    crossers.clear();
                                } else if (originator.getIcrossers().getEatingRank() == 3) {
                                    farmerOne.getImageView().setX(1000);
                                    farmerOne.getImageView().setY(500);
                                    lion.getImageView().setX(1000);
                                    lion.getImageView().setY(200);
                                    farmerOne.getImageView().setX(1000);
                                    farmerOne.getImageView().setY(500);
                                    boatview.setX(700);
                                    size2 = size2 - 2;
                                    crossers.add(lion);
                                    crossers.add(farmerOne);
                                    if (controller.canMove(crossers, false) == true) {
                                        System.out.println("correct ");
                                    } else {
                                        System.out.println("wong");
                                    }
                                    crossers.clear();
                                }

                            } else if (originator.getIcrossers().getEatingRank() != 4) {
                                if (originator.getIcrossers().getEatingRank() == 1) {
                                    farmerOne.getImageView().setX(1000);
                                    farmerOne.getImageView().setY(500);
                                    apple.getImageView().setX(1000);
                                    apple.getImageView().setY(100);
                                    farmerOne.getImageView().setX(1000);
                                    farmerOne.getImageView().setY(500);
                                    boatview.setX(700);
                                    size2 = size2 - 2;
                                    crossers.add(apple);
                                    crossers.add(farmerOne);
                                    if (controller.canMove(crossers, false) == true) {
                                        System.out.println("correct ");
                                    } else {
                                        System.out.println("wong");
                                    }
                                    crossers.clear();
                                } else if (originator.getIcrossers().getEatingRank() == 2) {
                                    farmerOne.getImageView().setX(1000);
                                    farmerOne.getImageView().setY(500);
                                    goat.getImageView().setX(1000);
                                    goat.getImageView().setY(400);
                                    farmerOne.getImageView().setX(1000);
                                    farmerOne.getImageView().setY(500);
                                    boatview.setX(700);
                                    size2 = size2 - 2;
                                    crossers.add(goat);
                                    crossers.add(farmerOne);
                                    if (controller.canMove(crossers, false) == true) {
                                        System.out.println("correct ");
                                    } else {
                                        System.out.println("wong");
                                    }
                                    crossers.clear();
                                } else if (originator.getIcrossers().getEatingRank() == 3) {
                                    farmerOne.getImageView().setX(1000);
                                    farmerOne.getImageView().setY(500);
                                    lion.getImageView().setX(1000);
                                    lion.getImageView().setY(200);
                                    farmerOne.getImageView().setX(1000);
                                    farmerOne.getImageView().setY(500);
                                    boatview.setX(700);
                                    size2 = size2 - 2;
                                    crossers.add(lion);
                                    crossers.add(farmerOne);
                                    if (controller.canMove(crossers, false) == true) {
                                        System.out.println("correct ");
                                    } else {
                                        System.out.println("wong");
                                    }
                                    crossers.clear();
                                    originator.restore(caretaker.get(size2 - 1));
                                }

                            }

                        }

                        setIsOnLeft(true);
                    }

                    System.out.println(size);

                    crossers.clear();
                    if (size == -1) {
                        caretaker.clear();
                        list.clear();
                        numberofSails = 0;
                        controller.setNumberofSails(0);

                    }
                    size--;
                }
            }

        });

        instruction.setLayoutX(50);
        instruction.setLayoutY(
                0);
        restGame.setLayoutX(
                200);
        restGame.setLayoutY(
                0);
        moves.setLayoutX(
                300);
        moves.setLayoutY(
                0);
        movesNo.setLayoutX(
                350);
        movesNo.setLayoutY(
                0);
        comment.setLayoutX(
                400);
        comment.setLayoutY(
                0);
        exitButton.setLayoutX(
                500);
        exitButton.setLayoutY(
                0);
        Undo.setLayoutX(550);
        Undo.setLayoutY(0);

        pane.getChildren()
                .addAll(farmerview, goatview, lionview, appleview, boatview, restGame, instruction, moves, movesNo, comment, exitButton, Undo);
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

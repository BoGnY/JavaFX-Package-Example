/*
    JavaFX-Package-Example
    Copyright (C) 2017-2018 Luca Bognolo

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program. If not, see <http://www.gnu.org/licenses/>.

 */
package a.simple.pack;

import a.simple.pack.controller.MainController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

/**
 * Utility class for controlling navigation between vistas.
 *
 * All methods on the navigator are static to facilitate simple access from
 * anywhere in the application.
 */
public class VistaNavigator {

    /**
     * Convenience constants for fxml layouts managed by the navigator.
     */
    public static final String MAIN = "a/simple/pack/view/main.fxml";
    public static final String VISTA_1 = "a/simple/pack/view/vista1.fxml";
    public static final String VISTA_2 = "a/simple/pack/view/vista2.fxml";

    /**
     * The main application layout controller.
     */
    private static MainController mainController;

    /**
     * Stores the main controller for later use in navigation tasks.
     *
     * @param mainController the main application layout controller.
     */
    public static void setMainController(MainController mainController) {
        VistaNavigator.mainController = mainController;
    }

    /**
     * Loads the vista specified by the fxml file into the vistaHolder pane of
     * the main application layout.
     *
     * Previously loaded vista for the same fxml file are not cached. The fxml
     * is loaded anew and a new vista node hierarchy generated every time this
     * method is invoked.
     *
     * A more sophisticated load function could potentially add some
     * enhancements or optimizations, for example: cache FXMLLoaders cache
     * loaded vista nodes, so they can be recalled or reused allow a user to
     * specify vista node reuse or new creation allow back and forward history
     * like a browser
     *
     * @param fxml the fxml file to be loaded.
     */
    public static void loadVista(String fxml) {
        try {
            mainController.setVista(FXMLLoader.load(ClassLoader.getSystemResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

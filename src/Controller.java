import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Stack;

import Classes.Gerenciador;

public class Controller {

    // Geral
    private Gerenciador gerenciador = new Gerenciador();

    private Stack<String> fxmlStack = new Stack<>();

    private Stage mainWindow;

    public void pushToStack(String fxml) {
        fxmlStack.push(fxml);
    }

    public String popFromStack() {
        return fxmlStack.isEmpty() ? null : fxmlStack.pop();
    }

    public void setMainWindow(Stage mainWindow) {
        this.mainWindow = mainWindow;
    }

    public Stage getMainWindow() {
        return mainWindow;
    }

    @FXML
    void onClickBack(ActionEvent event) {
        try {
            String previousFXML = popFromStack();
            if (previousFXML == null) {
                System.out.println("Nenhuma página anterior.");
                return;
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource(previousFXML));
            Parent backRoot = loader.load();

            Controller backController = loader.getController();
            backController.setMainWindow(mainWindow);
            backController.fxmlStack = this.fxmlStack;
            mainWindow.setScene(new Scene(backRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Login

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField pwdText;

    @FXML
    private TextField usrText;

    @FXML
    void onClickLogin(ActionEvent event) {
        String username = usrText.getText();
        String password = pwdText.getText();

        if (username.equals("admin") && password.equals("admin")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
                Parent menuRoot = loader.load();

                Controller menuController = loader.getController();
                menuController.setMainWindow(mainWindow);
                menuController.fxmlStack = this.fxmlStack;
                pushToStack("Login.fxml");
                mainWindow.setScene(new Scene(menuRoot));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Login inválido");
        }
    }

    // Menu

    @FXML
    private Button carsButton;

    @FXML
    private Button clientsButton;

    @FXML
    private Button emplyButton;

    @FXML
    void onClickCars(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowOrReserve.fxml"));
            Parent choiceRoot = loader.load();

            Controller choiceController = loader.getController();
            choiceController.setMainWindow(mainWindow);
            choiceController.fxmlStack = this.fxmlStack;
            pushToStack("Menu.fxml");
            mainWindow.setScene(new Scene(choiceRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickClient(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Client.fxml"));
            Parent choiceRoot = loader.load();

            Controller choiceController = loader.getController();
            choiceController.setMainWindow(mainWindow);
            choiceController.fxmlStack = this.fxmlStack;
            pushToStack("Menu.fxml");
            mainWindow.setScene(new Scene(choiceRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickEmply(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Emply.fxml"));
            Parent choiceRoot = loader.load();

            Controller choiceController = loader.getController();
            choiceController.setMainWindow(mainWindow);
            choiceController.fxmlStack = this.fxmlStack;
            pushToStack("Menu.fxml");
            mainWindow.setScene(new Scene(choiceRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Escolha showroom ou pátio

    @FXML
    private Button backButton;

    @FXML
    private Button reserveButton;

    @FXML
    private Button showrButton;

    @FXML
    void onClickReserve(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Reserve.fxml"));
            Parent reserveRoot = loader.load();

            Controller reserveController = loader.getController();
            reserveController.setMainWindow(mainWindow);
            reserveController.fxmlStack = this.fxmlStack;
            pushToStack("ShowOrReserve.fxml");
            mainWindow.setScene(new Scene(reserveRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickShowroom(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Showroom.fxml"));
            Parent showroomRoot = loader.load();

            Controller showroomController = loader.getController();
            showroomController.setMainWindow(mainWindow);
            showroomController.fxmlStack = this.fxmlStack;
            pushToStack("ShowOrReserve.fxml");
            mainWindow.setScene(new Scene(showroomRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Showroom

    @FXML
    private Button addCarShowButton;

    @FXML
    private Button listCarShowButton1;

    @FXML
    private Button editCarShowButton;

    @FXML
    private Button removeCarShowButton;

    @FXML
    private Button sellCarShowButton;

    @FXML
    void onClickListCarShow(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListShowroom.fxml"));
            Parent showroomRoot = loader.load();

            Controller showroomController = loader.getController();
            showroomController.setMainWindow(mainWindow);
            showroomController.fxmlStack = this.fxmlStack;
            pushToStack("Showroom.fxml");
            mainWindow.setScene(new Scene(showroomRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickAddCarShow(ActionEvent event) {

    }

    @FXML
    void onClickEditCarShow(ActionEvent event) {

    }

    @FXML
    void onClickRemoveCarShow(ActionEvent event) {

    }

    @FXML
    void onClickSellCarShowButton(ActionEvent event) {

    }


    //Reserva/Pátio

    @FXML
    private Button addCarReserveButton;

    @FXML
    private Button editCarReserveButton;

    @FXML
    private Button listCarReserveButton;

    @FXML
    private Button removeCarReserveButton;

    @FXML
    private Button sellCarReserveButton;

    @FXML
    void onClickListCarReserve(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListReserva.fxml"));
            Parent showroomRoot = loader.load();

            Controller showroomController = loader.getController();
            showroomController.setMainWindow(mainWindow);
            showroomController.fxmlStack = this.fxmlStack;
            pushToStack("Reserve.fxml");
            mainWindow.setScene(new Scene(showroomRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickAddCarReserve(ActionEvent event) {

    }

    @FXML
    void onClickEditCarReserve(ActionEvent event) {

    }

    @FXML
    void onClickSellCarReserveButton(ActionEvent event) {

    }

    //Clientes

    @FXML
    private Button BuyedRegistrationButton;

    @FXML
    private Button listClientButton;

    @FXML
    private Button addClientButton;

    @FXML
    private Button editClientButton;

    @FXML
    private Button removeClientButton;

    @FXML
    void onClickListClient(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListClientes.fxml"));
            Parent showroomRoot = loader.load();

            Controller showroomController = loader.getController();
            showroomController.setMainWindow(mainWindow);
            showroomController.fxmlStack = this.fxmlStack;
            pushToStack("Cliente.fxml");
            mainWindow.setScene(new Scene(showroomRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickAddClient(ActionEvent event) {

    }

    @FXML
    void onClickBuyedRegistrationButton(ActionEvent event) {

    }

    @FXML
    void onClickEditClient(ActionEvent event) {

    }

    @FXML
    void onClickRemoveClient(ActionEvent event) {

    }

    //Funcionarios

    @FXML
    private Button SelledRegistrationButton;

    @FXML
    private Button addEmplyButton;

    @FXML
    private Button editEmplyButton;

    @FXML
    private Button removeEmplyButton;

    @FXML
    private Button listEmplyButton;

    @FXML
    void onClickListEmply(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListFunc.fxml"));
            Parent showroomRoot = loader.load();

            Controller showroomController = loader.getController();
            showroomController.setMainWindow(mainWindow);
            showroomController.fxmlStack = this.fxmlStack;
            pushToStack("Emply.fxml");
            mainWindow.setScene(new Scene(showroomRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickAddEmply(ActionEvent event) {

    }

    @FXML
    void onClickEditEmply(ActionEvent event) {

    }

    @FXML
    void onClickRemoveEmply(ActionEvent event) {

    }

    @FXML
    void onClickSelledRegistrationButton(ActionEvent event) {

    }

    //listar showroom


    @FXML
    private ListView<String> listViewChassi;

    @FXML
    private ListView<String> listViewName;

    @FXML
    void initializeChassi(ActionEvent event) {
        listViewChassi.setItems(FXCollections.observableArrayList(gerenciador.getChassisShowroom()));
    }

    @FXML
    void initializeName(ActionEvent event) {
        listViewName.setItems(FXCollections.observableArrayList(gerenciador.getNomesShowroom()));
    }

    //Lista reserva

    @FXML
    private ListView<String> listViewChassiReserva;

    @FXML
    private ListView<String> listViewNameReserva;

    @FXML
    void initializeChassiReserva(ActionEvent event) {
        listViewChassi.setItems(FXCollections.observableArrayList(gerenciador.getChassisReserva()));
    }

    @FXML
    void initializeNameReserva(ActionEvent event) {
        listViewName.setItems(FXCollections.observableArrayList(gerenciador.getNomesReserva()));
    }

    //Lista clientes

    @FXML
    private ListView<String> listViewCpfClients;

    @FXML
    private ListView<String> listViewNameClients;

    @FXML
    void initializeCpfClients(ActionEvent event) {
        listViewChassi.setItems(FXCollections.observableArrayList(gerenciador.getCpfClientes()));
    }

    @FXML
    void initializeNameClients(ActionEvent event) {
        listViewChassi.setItems(FXCollections.observableArrayList(gerenciador.getNomesClientes()));
    }

    //Lista funcionarios

    @FXML
    private ListView<String> listViewCpfEmply;

    @FXML
    private ListView<String> listViewNameEmply;

    @FXML
    void initializeCpfEmply(ActionEvent event) {
        listViewChassi.setItems(FXCollections.observableArrayList(gerenciador.getCpfFuncionarios()));
    }

    @FXML
    void initializeNameEmply(ActionEvent event) {
        listViewChassi.setItems(FXCollections.observableArrayList(gerenciador.getNomesFuncionarios()));
    }


}

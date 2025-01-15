import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Stack;

import Classes.Carro;
import Classes.Cliente;
import Classes.Funcionario;
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

    public Gerenciador getGerenciador() {
        return gerenciador;
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
            gerenciador.inicializarBanco();
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CarShowroom.fxml"));
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
    void onClickEditCarShow(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("searchCar.fxml"));
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
    void onClickRemoveCarShow(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RemoveCarShowroom.fxml"));
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
    void onClickSellCarShowButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SellShowroom.fxml"));
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CarReserve.fxml"));
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
    void onClickEditCarReserve(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("searchCar.fxml"));
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
    void onClickRemoveCarReserve(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RemoveCarReserve.fxml"));
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
    void onClickSellCarReserveButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SellReserve.fxml"));
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
            pushToStack("Client.fxml");
            mainWindow.setScene(new Scene(showroomRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onClickAddClientNew(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ClientRegistryNew.fxml"));
            Parent showroomRoot = loader.load();

            Controller showroomController = loader.getController();
            showroomController.setMainWindow(mainWindow);
            showroomController.fxmlStack = this.fxmlStack;
            pushToStack("Client.fxml");
            mainWindow.setScene(new Scene(showroomRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickBuyedRegistrationButton(ActionEvent event) {

    }

    @FXML
    void onClickEditClient(ActionEvent event) {

    }

    @FXML
    void onClickRemoveClient(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RemoveClient.fxml"));
            Parent addClientRoot = loader.load();

            Controller addClientController = loader.getController();
            addClientController.setMainWindow(mainWindow);
            addClientController.fxmlStack = this.fxmlStack;
            pushToStack("Client.fxml");
            mainWindow.setScene(new Scene(addClientRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EmplyRegistry.fxml"));
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
    void onClickEditEmply(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("searchEmply.fxml"));
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
    void onClickRemoveEmply(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RemoveEmply.fxml"));
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
    void onClickSelledRegistrationButton(ActionEvent event) {

    }

    //listar showroom


    @FXML
    private ListView<String> listViewChassi;

    @FXML
    private ListView<String> listViewName;

    @FXML
    void initializeChassi() {
        listViewChassi.setItems(FXCollections.observableArrayList(gerenciador.getChassisShowroom()));
    }

    @FXML
    void initializeName() {
        listViewName.setItems(FXCollections.observableArrayList(gerenciador.getNomesShowroom()));
    }

    //Lista reserva

    @FXML
    private ListView<String> listViewChassiReserva;

    @FXML
    private ListView<String> listViewNameReserva;

    @FXML
    void initializeChassiReserva() {
        listViewChassi.setItems(FXCollections.observableArrayList(gerenciador.getChassisReserva()));
    }

    @FXML
    void initializeNameReserva() {
        listViewName.setItems(FXCollections.observableArrayList(gerenciador.getNomesReserva()));
    }

    //Lista clientes

    @FXML
    private ListView<String> listViewCpfClients;

    @FXML
    private ListView<String> listViewNameClients;

    @FXML
    void initializeCpfClients() {
        listViewChassi.setItems(FXCollections.observableArrayList(gerenciador.getCpfClientes()));
    }

    @FXML
    void initializeNameClients() {
        listViewChassi.setItems(FXCollections.observableArrayList(gerenciador.getNomesClientes()));
    }

    //Lista funcionarios

    @FXML
    private ListView<String> listViewCpfEmply;

    @FXML
    private ListView<String> listViewNameEmply;

    @FXML
    void initializeCpfEmply() {
        listViewChassi.setItems(FXCollections.observableArrayList(gerenciador.getCpfFuncionarios()));
    }

    @FXML
    void initializeNameEmply() {
        listViewChassi.setItems(FXCollections.observableArrayList(gerenciador.getNomesFuncionarios()));
    }

    //cadastro carro showroom

    @FXML
    private TextField brandShowroomCar;

    @FXML
    private TextField chassiCarShowroom;

    @FXML
    private TextField colorShowroomCar;

    @FXML
    private TextField horsepowerCarShowroom;

    @FXML
    private CheckBox isUsedCheckbox;

    @FXML
    private TextField modelCarShowroom;

    @FXML
    private Button submitButtonShowroom;

    @FXML
    private TextField typeCarShowroom;

    @FXML
    private TextField yearCarShowroom;

    @FXML
    void onClickButtonSubmitShowroom(ActionEvent event) {
        try {
            String marca = brandShowroomCar.getText();
            String chassi = chassiCarShowroom.getText();
            String cor = colorShowroomCar.getText();
            int cavalos = Integer.parseInt(horsepowerCarShowroom.getText());
            int ano = Integer.parseInt(yearCarShowroom.getText());
            String tipo = typeCarShowroom.getText();
            String modelo = modelCarShowroom.getText();
            boolean isUsado = isUsedCheckbox.isSelected();
            boolean isShowroom = true;

            gerenciador.cadastroCarro(marca, cor, cavalos, ano, tipo, modelo, isUsado, isShowroom, chassi);

            System.out.println("Carro cadastrado no showroom com sucesso!");

            brandShowroomCar.clear();
            chassiCarShowroom.clear();
            colorShowroomCar.clear();
            horsepowerCarShowroom.clear();
            yearCarShowroom.clear();
            typeCarShowroom.clear();
            modelCarShowroom.clear();
            isUsedCheckbox.setSelected(false);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar carro no showroom: " + e.getMessage());
        }
    }

    @FXML
    void usedCheckboxShowroom(ActionEvent event) {

    }

    //cadastro reserva

    @FXML
    private TextField brandReserveCar;

    @FXML
    private TextField chassiCarReserve;

    @FXML
    private TextField colorReserveCar;

    @FXML
    private TextField horsepowerCarReserve;

    @FXML
    private CheckBox isUsedCheckboxReserve;

    @FXML
    private TextField modelCarReserve;

    @FXML
    private Button submitButtonReserve;

    @FXML
    private TextField typeCarReserve;

    @FXML
    private TextField yearCarReserve;

    @FXML
    void onClickButtonSubmitReserve(ActionEvent event) {
        try {
            String marca = brandReserveCar.getText();
            String chassi = chassiCarReserve.getText();
            String cor = colorReserveCar.getText();
            int cavalos = Integer.parseInt(horsepowerCarReserve.getText());
            int ano = Integer.parseInt(yearCarReserve.getText());
            String tipo = typeCarReserve.getText();
            String modelo = modelCarReserve.getText();
            boolean isUsado = isUsedCheckboxReserve.isSelected();
            boolean isShowroom = false;

            gerenciador.cadastroCarro(marca, cor, cavalos, ano, tipo, modelo, isUsado, isShowroom, chassi);

            System.out.println("Carro cadastrado na reserva com sucesso!");

            brandReserveCar.clear();
            chassiCarReserve.clear();
            colorReserveCar.clear();
            horsepowerCarReserve.clear();
            yearCarReserve.clear();
            typeCarReserve.clear();
            modelCarReserve.clear();
            isUsedCheckboxReserve.setSelected(false);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar carro na reserva: " + e.getMessage());
        }
    }

    @FXML
    void usedCheckboxReserve(ActionEvent event) {

    }

    //cadastro clientes

    @FXML
    private TextField adressClient;

    @FXML
    private TextField cpfClient;

    @FXML
    private DatePicker dateClient;

    @FXML
    private TextField nameClient;

    @FXML
    private Button submitButtonClient;

    void onClickButtonSubmitClient(ActionEvent event) {
        try {
            String nome = nameClient.getText();
            String cpf = cpfClient.getText();
            String endereco = adressClient.getText();
            LocalDate dataNascimento = dateClient.getValue();

            gerenciador.cadastroCliente(nome, cpf, dataNascimento, endereco);

            System.out.println("Cliente cadastrado com sucesso!");

            nameClient.clear();
            cpfClient.clear();
            adressClient.clear();
            dateClient.setValue(null);

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    //cadastro funcionário

    @FXML
    private TextField cpfEmply;

    @FXML
    private DatePicker dateEmply;

    @FXML
    private TextField nameEmply;

    @FXML
    private Button submitButtonEmply;

    @FXML
    private TextField wageEmply;

    @FXML
    void onClickButtonSubmitEmply(ActionEvent event) {
        try {
            
            String nome = nameEmply.getText();
            String cpf = cpfEmply.getText();
            LocalDate dataNascimento = dateEmply.getValue();
            double salario = Double.parseDouble(wageEmply.getText());
            LocalDate dataIngresso = LocalDate.now();

            gerenciador.cadastroFunc(nome, cpf, dataNascimento, salario, dataIngresso);
    
            System.out.println("Funcionário cadastrado com sucesso!");
    
            nameEmply.clear();
            cpfEmply.clear();
            wageEmply.clear();
            dateEmply.setValue(null);
    
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }

    //Remover carro showroom

    @FXML
    private TextField chassiRemoveShowroom;

    @FXML
    private Button removeButtonCarShowroom;

    @FXML
    void onClickButtonRemoveCarShowroom(ActionEvent event) {
        String chassi = chassiRemoveShowroom.getText();
        gerenciador.removerCarro(chassi);
        chassiRemoveShowroom.clear();
    }

    //remover carro reserva

    @FXML
    private TextField chassiRemoveReserve;

    @FXML
    private Button removeButtonCarReserve;

    @FXML
    void onClickButtonRemoveCarReserve(ActionEvent event) {
        String chassi = chassiRemoveReserve.getText();
        gerenciador.removerCarro(chassi);
        chassiRemoveReserve.clear();
    }

    //Remover cliente

    @FXML
    private TextField cpfRemoveClient;

    @FXML
    private Button removeButtonClient;

    @FXML
    void onClickButtonRemoveClient(ActionEvent event) {
        String cpf = cpfRemoveClient.getText();
        gerenciador.removerCliente(cpf);
        cpfRemoveClient.clear();
    }

    //remover funcionário

    @FXML
    private TextField cpfRemoveEmply;

    @FXML
    private Button removeButtonEmply;

    @FXML
    void onClickButtonRemoveEmply(ActionEvent event) {
        String cpf = cpfRemoveEmply.getText();
        gerenciador.removerFunc(cpf);
        cpfRemoveEmply.clear();
    }

    //vender carro reserva
    @FXML
    private TextField chassiSellReserve;

    @FXML
    private TextField cpfClientSellReserve;

    @FXML
    private TextField cpfEmplySellReserve;

    @FXML
    private Button sellButtonCarReserve;

    @FXML
    void onClickButtonSellCarReserve(ActionEvent event) {
        String chassi = chassiSellReserve.getText();
        String cpfClient = cpfClientSellReserve.getText();
        String cpfEmply = cpfEmplySellReserve.getText();

        gerenciador.venderCarro(cpfEmply, cpfClient, chassi);
    }

    //vender carro showroom

    @FXML
    private TextField chassiSellShowroom;

    @FXML
    private TextField cpfClientSellShowroom;

    @FXML
    private TextField cpfEmplySellShowroom;

    @FXML
    private Button sellButtonCarShowroom;

    @FXML
    void onClickButtonSellCarShowroom(ActionEvent event) {
        String chassi = chassiSellShowroom.getText();
        String cpfClient = cpfClientSellShowroom.getText();
        String cpfEmply = cpfEmplySellShowroom.getText();

        gerenciador.venderCarro(cpfEmply, cpfClient, chassi);
    }

    //busca carro
    @FXML
    private TextArea ano;

    @FXML
    private TextArea cavalos;

    @FXML
    private TextField chassiSearch;

    @FXML
    private TextArea cor;

    @FXML
    private TextArea marca;

    @FXML
    private TextArea nomeCarro;

    @FXML
    private Button searchButtonCar;

    @FXML
    private TextArea showroom;

    @FXML
    private TextArea tipo;

    @FXML
    private TextArea usado;

    @FXML
    void onClickButtonSearchCar(ActionEvent event) {
        String chassi = chassiSearch.getText();
        Carro achado = gerenciador.buscaCarro(chassi);
        marca.setText(achado.getMarca());
        cor.setText(achado.getCor());
        cavalos.setText(String.valueOf(achado.getCavalos()));
        ano.setText(String.valueOf(achado.getAno()));
        tipo.setText(achado.getTipo());
        nomeCarro.setText(achado.getNome());
        if (achado.isUsado()) {
            usado.setText("É usado");
        }else{
            usado.setText("É novo");
        }
        if (achado.getIsShowroom()) {
            showroom.setText("É do showroom");
        }else{
            showroom.setText("Não é do showroom");
        }
    }


    //busca cliente

    @FXML
    private TextArea cpfClientField;

    @FXML
    private TextField cpfSearchClient;

    @FXML
    private TextArea datanascimentoClient;

    @FXML
    private TextArea enderecoClient;

    @FXML
    private TextArea nomeClient;

    @FXML
    private Button searchButtonClient;

    @FXML
    void onClickButtonSearchClient(ActionEvent event) {
        String cpfBusca = cpfSearchClient.getText();
        Cliente achado = gerenciador.buscaCliente(cpfBusca);
        cpfClientField.setText(achado.getCpf());
        nomeClient.setText(achado.getNome());
        datanascimentoClient.setText(achado.getDataNascimento().toString());
        enderecoClient.setText(achado.getEndereco());
    }


    //busca funcionario

    @FXML
    private TextArea cpfEmplyField;

    @FXML
    private TextField cpfSearchEmply;

    @FXML
    private TextArea dataIngressoEmply;

    @FXML
    private TextArea datanascimentoEmply;

    @FXML
    private TextArea nomeEmply;

    @FXML
    private TextArea salarioEmply;

    @FXML
    private Button searchButtonEmply;

    @FXML
    void onClickButtonSearchEmply(ActionEvent event) {
        String cpfBusca = cpfSearchEmply.getText();
        Funcionario achado = gerenciador.buscaFuncionario(cpfBusca);
        cpfEmplyField.setText(achado.getCpf());
        nomeEmply.setText(achado.getNome());
        datanascimentoEmply.setText(achado.getDataNascimento().toString());
        dataIngressoEmply.setText(achado.getDataIngresso().toString());
        salarioEmply.setText(String.format("R$ %.2f", achado.getSalario()));
    }


}

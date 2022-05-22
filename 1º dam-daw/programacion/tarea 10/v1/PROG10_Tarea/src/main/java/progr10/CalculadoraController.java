package progr10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculadoraController implements Initializable {

    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn0;
    @FXML
    private Button btnPlus;
    @FXML
    private Button btnMinus;
    @FXML
    private Button btnMult;
    @FXML
    private Button btnDiv;
    @FXML
    private Button btnEquals;
    @FXML
    private TextField txtResult;

    private int resultado;
    private boolean primerOperando;
    private boolean limpiarTexto;
    private boolean sePuedeCalcular;
    private char ultimoOperador;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.primerOperando = true;
        this.limpiarTexto = true;
        this.resultado = 0;
        this.sePuedeCalcular = false;
    }

    @FXML
    private void clickBtn7(ActionEvent event) {
        if (this.limpiarTexto) {
            this.txtResult.setText("7");
            this.limpiarTexto = false;
        } else {
            this.txtResult.appendText("7");
        }
        this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn8(ActionEvent event) {
        if (this.limpiarTexto) {
            this.txtResult.setText("8");
            this.limpiarTexto = false;
        } else {
            this.txtResult.appendText("8");
        }
        this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn9(ActionEvent event) {
        if (this.limpiarTexto) {
            this.txtResult.setText("9");
            this.limpiarTexto = false;
        } else {
            this.txtResult.appendText("9");
        }
        this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn4(ActionEvent event) {
        if (this.limpiarTexto) {
            this.txtResult.setText("4");
            this.limpiarTexto = false;
        } else {
            this.txtResult.appendText("4");
        }
        this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn5(ActionEvent event) {
        if (this.limpiarTexto) {
            this.txtResult.setText("5");
            this.limpiarTexto = false;
        } else {
            this.txtResult.appendText("5");
        }
        this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn6(ActionEvent event) {
        if (this.limpiarTexto) {
            this.txtResult.setText("6");
            this.limpiarTexto = false;
        } else {
            this.txtResult.appendText("6");
        }
        this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn1(ActionEvent event) {
        if (this.limpiarTexto) {
            this.txtResult.setText("1");
            this.limpiarTexto = false;
        } else {
            this.txtResult.appendText("1");
        }
        this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn2(ActionEvent event) {
        if (this.limpiarTexto) {
            this.txtResult.setText("2");
            this.limpiarTexto = false;
        } else {
            this.txtResult.appendText("2");
        }
        this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn3(ActionEvent event) {
        if (this.limpiarTexto) {
            this.txtResult.setText("3");
            this.limpiarTexto = false;
        } else {
            this.txtResult.appendText("3");
        }
        this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn0(ActionEvent event) {
        if (this.limpiarTexto) {
            this.txtResult.setText("0");
            this.limpiarTexto = false;
        } else {
            this.txtResult.appendText("0");
        }
        this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtnPlus(ActionEvent event) {
        if (this.sePuedeCalcular) {
            if (this.primerOperando) {
                this.resultado = Integer.parseInt(this.txtResult.getText());
            } else {
                this.resultado += Integer.parseInt(this.txtResult.getText());
            }

            this.txtResult.setText(this.resultado + "");
            this.primerOperando = false;
            this.limpiarTexto = true;
            this.sePuedeCalcular = false;
        }
        this.ultimoOperador = '+';
    }

    @FXML
    private void clickBtnMinus(ActionEvent event) {
        if (this.sePuedeCalcular) {
            if (this.primerOperando) {
                this.resultado = Integer.parseInt(this.txtResult.getText());
            } else {
                this.resultado -= Integer.parseInt(this.txtResult.getText());
            }

            this.txtResult.setText(this.resultado + "");
            this.primerOperando = false;
            this.limpiarTexto = true;
            this.sePuedeCalcular = false;
        } else if (this.primerOperando) {
            this.txtResult.setText("-");
            this.limpiarTexto = false;
        }
        this.ultimoOperador = '-';
    }

    @FXML
    private void clickBtnMult(ActionEvent event) {
        if (this.sePuedeCalcular) {
            if (this.primerOperando) {
                this.resultado = Integer.parseInt(this.txtResult.getText());
            } else {
                this.resultado *= Integer.parseInt(this.txtResult.getText());
            }

            this.txtResult.setText(this.resultado + "");
            this.primerOperando = false;
            this.limpiarTexto = true;
            this.sePuedeCalcular = false;
        }
        this.ultimoOperador = '*';
    }

    @FXML
    private void clickBtnDiv(ActionEvent event) {
        if (this.sePuedeCalcular) {
            if (this.primerOperando) {
                this.resultado = Integer.parseInt(this.txtResult.getText());
            } else {
                this.resultado /= Integer.parseInt(this.txtResult.getText());
            }

            this.txtResult.setText(this.resultado + "");
            this.primerOperando = false;
            this.limpiarTexto = true;
            this.sePuedeCalcular = false;
        }
        this.ultimoOperador = '/';
    }

    @FXML
    private void clickBtnEquals(ActionEvent event) {

        switch (this.ultimoOperador) {
            case '+':
                this.clickBtnPlus(event);
                break;
            case '-':
                this.clickBtnMinus(event);
                break;
            case '*':
                this.clickBtnMult(event);
                break;
            case '/':
                this.clickBtnDiv(event);
                break;
        }

    }

    @FXML
    private void clickClear(ActionEvent event) {
        this.txtResult.setText("");
        this.primerOperando = false;
        this.limpiarTexto = true;
        this.sePuedeCalcular = false;
    }

    @FXML
    private void clickClearall(ActionEvent event) {
        this.txtResult.setText("");
        this.resultado = 0;
        this.primerOperando = true;
        this.limpiarTexto = true;
        this.sePuedeCalcular = false;
    }

}

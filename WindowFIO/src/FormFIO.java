import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormFIO  extends Container {

    private JPanel fioPanel;
    private JButton переключитьButton;
    private JTextField textField1fio;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JProgressBar progressBar1;

    public JTextField getTextField1fio(){
        return textField1fio;
    }

    public FormFIO() {

        переключитьButton.addActionListener(e -> Form.visibleForm());

        textField1fio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if ((e.getKeyCode() == KeyEvent.VK_ENTER) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)){
                    Form.visibleForm();
                }
            }
        });
    }

    public static void visibleFormFIO(){

        JFrame frameFIO = new JFrame();
        FormFIO formFIO = new FormFIO();

        frameFIO.setContentPane(formFIO.getFioPanel());
        frameFIO.setLayout(new FlowLayout());
        frameFIO.setSize(400, 400);
        frameFIO.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameFIO.setTitle("Вывод");
        Form.centerFrame(frameFIO);
        frameFIO.setVisible(true);
        formFIO.getTextField1fio().setText(Form.text);

        if (!Form.getSavedPatronymic().equals("") ) {
            formFIO.progressBar1.setValue(100);
        }
    }

    public JPanel getFioPanel() {
        return fioPanel;
    }

}

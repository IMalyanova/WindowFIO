import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Form extends Container {

    private static String savedName;
    private static String savedSurname;
    private static String savedPatronymic;

    private void setSavedPatronymic(){
        savedPatronymic = this.savedPatronymic;
    }

    public static String getSavedPatronymic(){
        return savedPatronymic;
    }

    private JPanel rootPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton переключитьButton;
    private JPanel JPanel1;
    private JPanel JPanel2;

    public static String text;

     public Form() {
        переключитьButton.addActionListener(e -> associationTextForm());

        getaVoid(textField1);
        getaVoid(textField2);
        getaVoid(textField3);
    }

    public void getaVoid(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if ((e.getKeyCode() == KeyEvent.VK_ENTER)
                        && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)){
                    associationTextForm();
                }
            }
        });
    }

    private void associationTextForm() {

        savedName = textField1.getText().trim();
        savedSurname = textField2.getText().trim();
        savedPatronymic = textField3.getText().trim();

        text = savedName + " " + savedSurname + " " + savedPatronymic;

        if ((textIncorrectInput(savedSurname))|(textIncorrectInput(savedSurname))){
            JOptionPane.showMessageDialog(rootPanel,"Неверный ввод. Необходимо корректно заполнить фамилию и имя.");
        } else if (savedPatronymic.equals("")) {
            textField3.requestFocusInWindow();
            int option = JOptionPane.showConfirmDialog(rootPanel,"Вы уверенны, что не хотите заполнить отчество?", "An Inane Question",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION){
                FormFIO.visibleFormFIO();
            }
        } else if (textIncorrectInput(savedPatronymic)) {
            JOptionPane.showMessageDialog(rootPanel,"Неверный ввод. Необходимо корректно заполнить отчество");
        } else {
            FormFIO.visibleFormFIO();
        }
    }

    public Boolean textIncorrectInput(String text) {

        Pattern pattern = Pattern.compile("\\s*+([А-ЯЁ][а-яё]++)\\s*+");
        Matcher matcher = pattern.matcher(text);
        Boolean result = matcher.matches();
        if (!result){
            return true;
        }else return false;
    }


    public static void visibleForm() {

        JFrame frame = new JFrame();
        Form form = new Form();

        frame.setContentPane(form.getRootPanel());
        frame.setLayout(new FlowLayout());

        form.textField1.setText(Form.savedName);
        form.textField2.setText(Form.savedSurname);
        form.textField3.setText(Form.savedPatronymic);

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("ФИО");
        centerFrame(frame);
        frame.setVisible(true);
    }


    public JPanel getRootPanel() {
        return rootPanel;
    }


    public static void centerFrame(Window frame) {

        frame.setLocationRelativeTo(null);
    }
}

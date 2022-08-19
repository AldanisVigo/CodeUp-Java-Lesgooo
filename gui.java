import javax.swing.*;
import java.awt.GridLayout;
class GUI {
    public static void main(String[] args){
        UI myUi = new UI();
        myUi.create();
    }
}

class UI{
    void create(){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(100,100);
        window.setTitle("My Window Title");
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));   
        panel.setLayout(new GridLayout(0,1));
        JButton btn = new JButton();
        btn.setText("Click Me!");
        JLabel label = new JLabel("You typed: ");

        JTextField txtField = new JTextField();
        btn.addActionListener(e->{
            btnClicked(txtField,label);
        });
        panel.add(txtField);
        panel.add(btn);
        panel.add(label);
        window.add(panel);
        window.pack();
        window.setVisible(true);
    }

    void btnClicked(JTextField field,JLabel lbl){
        lbl.setText(lbl.getText() + ":" + field.getText());
        System.out.println("You clicked the button");
    }
}

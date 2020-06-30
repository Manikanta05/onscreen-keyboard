import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class onscreen extends JPanel implements
ActionListener
{
static final String st = "!@#$%^&*()-
=+/789qwertyuiop[]{}456asdfghjkl_;:'\"123zxcvbnm,.<>?`~0";
JButton buttonList[];
String buffer = "";
JLabel i;
JTextField text;
JButton backspace, spaceBar;
public void key()
{
text = new JTextField(68);
text.setActionCommand(""+ buffer);
add(text);
int n = st.length();
buttonList = new JButton[n];
for (int i = 0; i < n; i++) {
buttonList[i] = new JButton( "" + st.charAt(i) );
setBackground(Color.LIGHT_GRAY);

16

add(buttonList[i],"Center");
buttonList[i].addActionListener(this);
}
spaceBar = new JButton("Spacebar Key");
add(spaceBar);
spaceBar.addActionListener(this);

backspace = new JButton("BackSpace Key");
add(backspace);
backspace.addActionListener(this);
}
public void actionPerformed( ActionEvent e) {
int n = st.length();
if (e.getSource() == backspace) {
buffer = buffer.substring(0,buffer.length()-1);
text.setText("" + buffer);
}
else if (e.getSource() == spaceBar){
buffer += " ";
}
else{
for (int i = 0; i < n; i++){
if (e.getSource() == buttonList[i]){
buffer += st.toLowerCase().charAt(i);
text.setText(""+ buffer);
break;

17

}
}
}
}
public onscreen(){
JPanel pane = new JPanel();
add(pane);
}
public static void main(String s[])
{
JFrame frame = new JFrame("ONSCREEN KEYBOARD");
onscreen keys= new onscreen();
frame.getContentPane().add(keys,"Center");
keys.key();
Image
icon=Toolkit.getDefaultToolkit().getImage("src\\logo.png");
frame.setIconImage(icon);
frame.setSize(800,240);
frame.setVisible(true);
}
}

package DefaultAction;

import javax.swing.JOptionPane;

public class DefaultAction {

  public static void main(String[] args) {
    alert("Bitte entpacken Sie die .jar Datei mit:\njar -xf DATEINAME.jar");
  }

  public static void alert(String message) {
    JOptionPane.showMessageDialog(
      null,
      message,
      "Hinweis vom PP Team",
      JOptionPane.INFORMATION_MESSAGE);
  }
}
